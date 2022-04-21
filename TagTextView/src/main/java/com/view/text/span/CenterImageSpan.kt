package com.view.text.span

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.net.Uri
import android.text.style.ImageSpan
import com.view.text.config.Align
import java.lang.ref.WeakReference

/**
 * 比官方[ImageSpan]更好用的图片显示Span
 *
 * 设置图片垂直对齐方式
 * 设置图片宽高且保持固定比例
 * 设置图片水平间距
 *
 * 默认图片垂直居中对齐文字, 使用[setAlign]可指定
 *
 * 需应对更复杂的图片加载需求请使用[GlideImageSpan]
 */
class CenterImageSpan : ImageSpan {

    /** 图片宽度 */
    var drawableWidth: Int? = null
        private set

    /** 图片高度 */
    var drawableHeight: Int? = null
        private set

    /** 图片左间距 */
    var marginLeft: Int = 0
        private set

    /** 图片右间距 */
    var marginRight: Int = 0
        private set

    private var drawableRef: WeakReference<Drawable>? = null

    override fun getDrawable(): Drawable {
        return drawableRef?.get() ?: super.getDrawable().apply {
            setBounds(0, 0, drawableWidth?:intrinsicWidth, drawableHeight?:intrinsicHeight)
            drawableRef = WeakReference(this)
        }
    }

    constructor(drawable: Drawable) : super(drawable)
    constructor(drawable: Drawable, source: String) : super(drawable, source)
    constructor(context: Context, uri: Uri) : super(context, uri)
    constructor(context: Context, resourceId: Int) : super(context, resourceId)
    constructor(context: Context, bitmap: Bitmap) : super(context, bitmap)

    override fun getSize(
        paint: Paint,
        text: CharSequence?,
        start: Int,
        end: Int,
        fm: Paint.FontMetricsInt?
    ): Int {
        val bounds = drawable.bounds
        if (fm != null) {
            val fontMetricsInt = paint.fontMetricsInt
            val fontHeight = fontMetricsInt.descent - fontMetricsInt.ascent
            val imageHeight = bounds.height()
            when (align) {
                Align.CENTER -> {
                    fm.ascent = fontMetricsInt.ascent - ((imageHeight - fontHeight) / 2.0f).toInt()
                    fm.descent = fm.ascent + imageHeight
                }
                Align.BASELINE -> {
                    fm.ascent = -bounds.bottom
                    fm.descent = 0
                }
                Align.BOTTOM -> {
                    fm.ascent = -bounds.bottom + fm.descent
                    fm.descent = 0
                }
            }
            fm.top = fm.ascent
            fm.bottom = fm.descent
        }
        return bounds.right + marginLeft + marginRight
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
        canvas.save()
        val bounds = drawable.bounds
        var transY = bottom - bounds.bottom
        if (align == Align.BASELINE) {
            transY -= paint.fontMetricsInt.descent
        } else if (align == Align.CENTER) {
            transY -= (bottom - top) / 2 - (bounds.bottom - bounds.top) / 2
        }
        canvas.translate(x + marginLeft, transY.toFloat())
        drawable.draw(canvas)
        canvas.restore()
    }

    private var align: Align = Align.CENTER

    /**
     * 设置图片垂直对其方式
     * 图片默认垂直居中对齐文字: [Align.CENTER]
     */
    fun setAlign(align: Align) = apply {
        this.align = align
    }

    /**
     * 设置图片宽高
     */
    fun setDrawableSize(width: Int?, height: Int?) = apply {
        this.drawableWidth = width
        this.drawableHeight = height
        drawableRef?.clear()
    }

    /** 设置图片水平间距 */
    fun setMarginHorizontal(left: Int, right: Int = left) = apply {
        this.marginLeft = left
        this.marginRight = right
        drawableRef?.clear()
    }

}