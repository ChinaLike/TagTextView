package com.view.text.span

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.graphics.drawable.NinePatchDrawable
import android.net.Uri
import android.text.style.ImageSpan
import com.view.text.annotation.DrawableZoomType
import com.view.text.annotation.Align
import java.lang.ref.WeakReference
import kotlin.math.max

/**
 * 在官方[ImageSpan]图片显示Span上做了更多扩展:
 * 1.增加对齐方式,[Align.CENTER]居中对齐、[Align.BASELINE]基线对齐、[Align.BOTTOM]底部对齐、[Align.TOP]顶部对齐
 * 2.图片适配大小适配，0-原始大小、-1-使用文字大小、1-指定大小
 * 3.图片间距
 */
class CenterImageSpan : ImageSpan, ISpan {

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
    @Align
    private var align: Int = Align.CENTER

    var mNormalSizeText: String = ""

    /**
     * Drawable对象
     */
    private var drawableRef: WeakReference<Drawable>? = null

    constructor(drawable: Drawable) : super(drawable)
    constructor(drawable: Drawable, source: String) : super(drawable, source)
    constructor(context: Context, uri: Uri) : super(context, uri)
    constructor(context: Context, resourceId: Int) : super(context, resourceId)
    constructor(context: Context, bitmap: Bitmap) : super(context, bitmap)

    override fun getDrawable(): Drawable {
        return drawableRef?.get() ?: super.getDrawable().apply {
            setDrawableSize()
            drawableRef = WeakReference(this)
        }
    }

    /**
     * 根据参数设置图片大小
     */
    private fun Drawable.setDrawableSize() {
        drawableWidth = when (drawableZoomType) {
            DrawableZoomType.TEXT -> textRect.width()
            DrawableZoomType.CUSTOM -> if (drawableWidth != 0) drawableWidth else intrinsicWidth
            else -> intrinsicWidth
        }
        drawableHeight = when (drawableZoomType) {
            DrawableZoomType.TEXT -> textRect.height()
            DrawableZoomType.CUSTOM -> if (drawableHeight != 0) drawableHeight else intrinsicHeight
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

    override fun getSize(
        paint: Paint,
        text: CharSequence?,
        start: Int,
        end: Int,
        fm: Paint.FontMetricsInt?
    ): Int {
        //处理按照文字大小匹配
        val fontMetricsInt = paint.fontMetricsInt
        if (textSize > 0) {
            paint.textSize = textSize.toFloat()
        }
        if (drawableZoomType == DrawableZoomType.TEXT) {
            val rect = Rect()
            paint.getTextBounds(text.toString(), start, end, rect)
            //占位符使用的英文，相比汉字少了一半
            textRect.set(0, 0, rect.width() * 2, fontMetricsInt.descent - fontMetricsInt.ascent)
        }
        val bounds = drawable.bounds
        if (fm != null) {
            val imageHeight = bounds.height()
            when (align) {
                Align.CENTER -> {
                    val fontHeight = fontMetricsInt.descent - fontMetricsInt.ascent
                    fm.ascent =
                        fontMetricsInt.ascent - (imageHeight - fontHeight) / 2 - drawableMargin.top
                    fm.descent = fm.ascent + imageHeight + drawableMargin.bottom
                }
                Align.BASELINE -> {
                    fm.ascent =
                        fontMetricsInt.descent - imageHeight - fontMetricsInt.descent - drawableMargin.top - drawableMargin.bottom
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

    /**
     * 绘制图片的位置
     */
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
        canvas.save()
        val bounds = drawable.bounds
        val fontMetricsInt = paint.fontMetricsInt
        var transY = when (align) {
            Align.BASELINE -> y - (bounds.bottom + bounds.height()) / 2
            Align.CENTER -> y + (fontMetricsInt.descent + fontMetricsInt.ascent - bounds.bottom) / 2
            Align.TOP -> top + (fontMetricsInt.ascent - fontMetricsInt.top)
            Align.BOTTOM -> y - (bounds.bottom + bounds.height() - fontMetricsInt.descent) / 2
            else -> 0
        } - drawableMargin.bottom + drawableMargin.top
        canvas.translate(x + drawableMargin.left, transY.toFloat())
        drawable.draw(canvas)
        canvas.restore()
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
        drawableRef?.clear()
    }

    /**
     * 设置Drawable的左右间距
     * @param [left] 左边间距
     * @param [right] 右边间距
     */
    override fun setMarginHorizontal(left: Int, right: Int) {
        this.drawableMargin.left = left
        this.drawableMargin.right = right
        drawableRef?.clear()
    }

    /**
     * 设置Drawable的上下间距
     * @param [top] 上边间距
     * @param [bottom] 下边间距
     */
    override fun setMarginVertical(top: Int, bottom: Int) {
        this.drawableMargin.top = top
        this.drawableMargin.bottom = bottom
        drawableRef?.clear()
    }
}