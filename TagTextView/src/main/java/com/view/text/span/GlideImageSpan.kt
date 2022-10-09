package com.view.text.span

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.graphics.drawable.NinePatchDrawable
import android.text.style.ReplacementSpan
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.request.Request
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.view.text.annotation.Align
import com.view.text.annotation.DrawableZoomType
import java.util.concurrent.atomic.AtomicReference
import kotlin.math.max

/**
 * 利用Glide加载网络图片
 * 1.设置图片对齐方式
 * 2.自定义图片宽高
 * 3.支持间距
 */
class GlideImageSpan(val view: TextView, val url: Any) : ReplacementSpan(), ISpan {

    /** gif循环次数 */
    private var loopCount: Int = GifDrawable.LOOP_FOREVER

    /**
     * 图片缩放类型
     */
    @DrawableZoomType
    private var drawableZoomType: Int = DrawableZoomType.ORIGINAL

    /**
     * 图片宽度
     */
    private var drawableWidth: Int = 0

    /**
     * 图片高度
     */
    private var drawableHeight: Int = 0

    /**
     * 图片间距，默认0
     */
    private var drawableMargin: Rect = Rect()

    /**
     * 文字
     */
    private var textRect = Rect()

    /**
     * 文字大小
     */
    private var textSize: Int = 0

    /**
     * 设置对齐方式
     */
    private var align: Int = Align.CENTER

    /**
     * Drawable对象
     */
    private var drawableRef: AtomicReference<Drawable> = AtomicReference()

    /**
     * Glide自定义配置项
     */
    private var requestOption: RequestOptions = RequestOptions()

    /**
     * 初始固定图片显示区域, 优先级: 自定义尺寸 > 占位图尺寸 > 文字尺寸
     */
    private var fixDrawableBounds = Rect()

    private var request: Request? = null

    /**
     * 获取占位图
     */
    private val placeHolder: Drawable? by lazy {
        val placeHolder = try {
            requestOption.placeholderDrawable ?: ContextCompat.getDrawable(
                view.context,
                requestOption.placeholderId
            )
        } catch (e: Exception) {
            null
        }
        placeHolder?.setFixedRatioZoom()
        placeHolder
    }

    /**
     * 刷新回调
     */
    private val drawableCallback = object : Drawable.Callback {
        override fun invalidateDrawable(who: Drawable) {
            view.invalidate()
        }

        override fun scheduleDrawable(who: Drawable, what: Runnable, `when`: Long) {
        }

        override fun unscheduleDrawable(who: Drawable, what: Runnable) {
        }
    }

    private fun getDrawable(): Drawable? {
        if (drawableRef.get() == null && (request == null || request?.isComplete == true)) {
            val drawableSize = getDrawableSize()
            request = Glide.with(view).load(url).apply(requestOption)
                .into(object : CustomTarget<Drawable>(drawableSize.width(), drawableSize.height()) {

                    override fun onResourceReady(
                        resource: Drawable,
                        transition: Transition<in Drawable>?
                    ) {
                        if (resource is GifDrawable) {
                            resource.callback = drawableCallback
                            resource.setLoopCount(loopCount)
                            resource.start()
                        }
                        if (fixDrawableBounds.isEmpty) {
                            fixDrawableBounds = getDrawableSize()
                        }
                        resource.bounds = fixDrawableBounds
                        drawableRef.set(resource)
                        view.invalidate()
                    }

                    override fun onLoadStarted(placeholder: Drawable?) {
                        if (placeholder != null) {
                            placeholder.setFixedRatioZoom()
                            drawableRef.set(placeholder)
                        }
                    }

                    override fun onLoadFailed(errorDrawable: Drawable?) {
                        if (errorDrawable != null && errorDrawable != drawableRef.get()) {
                            errorDrawable.setFixedRatioZoom()
                            drawableRef.set(errorDrawable)
                            view.invalidate()
                        }
                    }

                    override fun onLoadCleared(placeholder: Drawable?) {

                    }

                }).request
        }
        return drawableRef.get()
    }

    /**
     * 根据参数获取图片大小
     */
    private fun getDrawableSize(): Rect {
        val width = when (drawableZoomType) {
            DrawableZoomType.CUSTOM -> if (drawableWidth != 0) drawableWidth else textRect.width()
            DrawableZoomType.TEXT -> textRect.width()
            else -> placeHolder?.intrinsicWidth ?: textRect.width()
        }
        val height = when (drawableZoomType) {
            DrawableZoomType.CUSTOM -> if (drawableHeight != 0) drawableHeight else textRect.height()
            DrawableZoomType.TEXT -> textRect.width()
            else -> placeHolder?.intrinsicHeight ?: textRect.height()
        }

        return Rect(0, 0, width, height)
    }

    override fun getSize(
        paint: Paint,
        text: CharSequence?,
        start: Int,
        end: Int,
        fm: Paint.FontMetricsInt?
    ): Int {
        val fontMetricsInt = paint.fontMetricsInt
        if (textSize > 0) {
            paint.textSize = textSize.toFloat()
        }
        val rect = Rect()
        paint.getTextBounds(text.toString(), start, end, rect)
        //占位符使用的英文，相比汉字少了一半
        textRect.set(0, 0, rect.width() * 2, fontMetricsInt.descent - fontMetricsInt.ascent)

        val drawable = getDrawable()
        val bounds = drawable?.bounds ?: getDrawableSize()
        fixDrawableBounds = bounds
        val imageHeight = bounds.height()
        if (fm != null) {
            when (align) {
                Align.CENTER -> {
                    val fontHeight = fontMetricsInt.descent - fontMetricsInt.ascent
                    fm.ascent =
                        fontMetricsInt.ascent - (imageHeight - fontHeight) / 2 - drawableMargin.top
                    fm.descent = fm.ascent + imageHeight + drawableMargin.bottom
                }
                Align.BASELINE -> {
                    fm.ascent =
                        fontMetricsInt.bottom - imageHeight - fontMetricsInt.descent - drawableMargin.top - drawableMargin.bottom
                    fm.descent = 0
                }
                Align.BOTTOM -> {
                    fm.ascent =
                        -fontMetricsInt.descent - imageHeight - drawableMargin.top - drawableMargin.bottom
                    fm.descent = 0
                }
                Align.TOP -> {
                    fm.ascent = fontMetricsInt.ascent + drawableMargin.top
                    fm.descent = fm.ascent + imageHeight + drawableMargin.bottom
                }
            }

            fm.top = fm.ascent
            fm.bottom = fm.descent
        }

        return bounds.right + drawableMargin.left + drawableMargin.right
    }

    override fun draw(
        canvas: Canvas,
        text: CharSequence?,
        start: Int,
        end: Int,
        x: Float,
        top: Int,
        y: Int,
        bottom: Int,
        paint: Paint
    ) {
        val drawable = getDrawable()
        canvas.save()
        val bounds = drawable?.bounds ?: getDrawableSize()
        val fontMetricsInt = paint.fontMetricsInt
        var transY = when (align) {
            Align.BASELINE -> y - (bounds.bottom + bounds.height()) / 2
            Align.CENTER -> y + (fontMetricsInt.descent + fontMetricsInt.ascent - bounds.bottom) / 2
            Align.TOP -> top + (fontMetricsInt.ascent - fontMetricsInt.top)
            Align.BOTTOM -> y - (bounds.bottom + bounds.height() - fontMetricsInt.descent) / 2
            else -> 0
        } - drawableMargin.bottom + drawableMargin.top
        canvas.translate(x + drawableMargin.left, transY.toFloat())
        drawable?.draw(canvas)
        canvas.restore()
    }


    /**
     * 根据参数设置图片大小
     */
    private fun Drawable.setFixedRatioZoom() {
        drawableWidth = when (drawableZoomType) {
            DrawableZoomType.TEXT -> textRect.width()
            DrawableZoomType.CUSTOM -> drawableWidth
            else -> intrinsicWidth
        }
        drawableHeight = when (drawableZoomType) {
            DrawableZoomType.TEXT -> textRect.height()
            DrawableZoomType.CUSTOM -> drawableHeight
            else -> intrinsicHeight
        }
        var width = drawableWidth
        var height = drawableHeight

        if (this is NinePatchDrawable) {
            width = max(width, intrinsicWidth)
            height = max(height, intrinsicHeight)
        }
        bounds.set(0, 0, width, height)
    }


    /**
     * 配置Glide请求选项, 例如占位图、加载失败图等
     * 如果使用[RequestOptions.placeholder]占位图会导致默认使用占位图宽高, 除非你使用[setDrawableSize]覆盖默认值
     *
     * 默认会使用[RequestOptions.fitCenterTransform]保持图片纵横比例不变, 当然你可以覆盖该配置
     */
    fun setRequestOption(requestOption: RequestOptions) = apply {
        this.requestOption = requestOption
    }

    /** gif图播放循环次数, 默认无限循环 */
    fun setLoopCount(loopCount: Int) = apply {
        this.loopCount = loopCount
    }

    /**
     * 设置居中方式
     * @param [align] 居中方式
     */
    override fun setAlign(align: Int) {
        this.align = align
    }

    /**
     * 设置字体大小
     * @param [size] 字体大小，单位px
     */
    override fun setTextSize(size: Int) {
        this.textSize = size
    }

    /**
     * 设置图片缩放类型
     * @param [type] 参考[DrawableZoomType]
     */
    override fun setDrawableZoomType(type: Int) {
        this.drawableZoomType = type
    }

    /**
     * 设置Drawable的大小
     * @param [width] 宽度
     * @param [height] 高度，默认 高度=宽度
     */
    override fun setDrawableSize(width: Int, height: Int) {
        this.drawableWidth = width
        this.drawableHeight = height
        drawableRef.set(null)
    }

    /**
     * 设置Drawable的左右间距
     * @param [left] 左边间距
     * @param [right] 右边间距
     */
    override fun setMarginHorizontal(left: Int, right: Int) {
        this.drawableMargin.left = left
        this.drawableMargin.right = right
        drawableRef.set(null)
    }

    /**
     * 设置Drawable的上下间距
     * @param [top] 上边间距
     * @param [bottom] 下边间距
     */
    override fun setMarginVertical(top: Int, bottom: Int) {
        this.drawableMargin.top = top
        this.drawableMargin.bottom = bottom
        drawableRef.set(null)
    }

}
