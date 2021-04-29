package com.view.text.ex

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.view.View
import androidx.annotation.ColorInt

/**
 * 设置View的渐变背景和圆角（可单独设置圆角）
 * @param [colors] 渐变颜色
 * @param [cornerRadii] 单独设置圆角
 */
fun View.setGradientBackgroundAndRadius(@ColorInt colors: IntArray, cornerRadii: FloatArray) {
    val drawable = GradientDrawable().apply {
        this.orientation = GradientDrawable.Orientation.LEFT_RIGHT
        this.colors = colors
        this.cornerRadii = cornerRadii
    }

    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
        background = drawable
    } else {
        setBackgroundDrawable(drawable)
    }
}

/**
 * 设置View的渐变背景和圆角
 * @param [colors] 渐变颜色
 * @param [radius] 圆角
 */
fun View.setGradientBackgroundAndRadius(@ColorInt colors: IntArray, radius: Float) {
    val drawable = GradientDrawable().apply {
        this.orientation = GradientDrawable.Orientation.LEFT_RIGHT
        this.colors = colors
        this.cornerRadius = radius
    }

    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
        background = drawable
    } else {
        setBackgroundDrawable(drawable)
    }
}

/**
 * 设置View的背景和圆角（可单独设置圆角）
 * @param [color] 背景颜色
 * @param [cornerRadii] 单独设置圆角
 */
fun View.setBackgroundAndRadius(@ColorInt color: Int, cornerRadii: FloatArray) {
    val drawable = GradientDrawable().apply {
        this.setColor(color)
        this.cornerRadii = cornerRadii
    }

    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
        background = drawable
    } else {
        setBackgroundDrawable(drawable)
    }
}

/**
 * 设置View的背景和圆角
 * @param [color] 背景
 * @param [radius] 圆角
 */
fun View.setBackgroundAndRadius(@ColorInt color: Int, radius: Float) {
    val drawable = GradientDrawable().apply {
        this.setColor(color)
        this.cornerRadius = radius
    }

    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
        background = drawable
    } else {
        setBackgroundDrawable(drawable)
    }
}

/**
 * 设置View的圆角（可单独设置圆角）
 * @param [cornerRadii] 单独设置圆角
 */
fun View.setRadius(cornerRadii: FloatArray) {
    val drawable = GradientDrawable().apply {
        this.setColor(Color.TRANSPARENT)
        this.cornerRadii = cornerRadii
    }

    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
        background = drawable
    } else {
        setBackgroundDrawable(drawable)
    }
}

/**
 * 设置View的圆角，背景默认透明
 * @param [radius] 圆角
 */
fun View.setRadius(radius: Float) {
    val drawable = GradientDrawable().apply {
        this.setColor(Color.TRANSPARENT)
        this.cornerRadius = radius
    }

    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
        background = drawable
    } else {
        setBackgroundDrawable(drawable)
    }
}

/**
 * 设置View的边框宽度和颜色
 * @param [strokeWidth] 宽度
 * @param [strokeColor] 颜色
 * @param [backgroundColor] 背景颜色（默认透明）
 */
fun View.setStroke(strokeWidth: Int, @ColorInt strokeColor: Int,@ColorInt backgroundColor:Int = Color.TRANSPARENT) {
    val drawable = GradientDrawable().apply {
        setColor(backgroundColor)
        setStroke(strokeWidth, strokeColor)
    }
    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
        background = drawable
    } else {
        setBackgroundDrawable(drawable)
    }
}

/**
 * 设置View的边框宽度和颜色
 * @param [strokeWidth] 宽度
 * @param [strokeColor] 颜色
 * @param [corner] 圆角
 * @param [backgroundColor] 背景颜色（默认透明）
 */
fun View.setStroke(strokeWidth: Int, @ColorInt strokeColor: Int, corner: Float,@ColorInt backgroundColor:Int = Color.TRANSPARENT) {
    val drawable = GradientDrawable().apply {
        setColor(backgroundColor)
        cornerRadius = corner
        setStroke(strokeWidth, strokeColor)
    }
    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
        background = drawable
    } else {
        setBackgroundDrawable(drawable)
    }
}

/**
 * 设置View的边框宽度和颜色
 * @param [strokeWidth] 宽度
 * @param [strokeColor] 颜色
 * @param [corner] 圆角
 * @param [backgroundColor] 背景颜色（默认透明）
 */
fun View.setStroke(strokeWidth: Int, @ColorInt strokeColor: Int, corner: FloatArray,@ColorInt backgroundColor:Int = Color.TRANSPARENT) {
    val drawable = GradientDrawable().apply {
        setColor(backgroundColor)
        cornerRadii = corner
        setStroke(strokeWidth, strokeColor)
    }
    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
        background = drawable
    } else {
        setBackgroundDrawable(drawable)
    }
}

/**
 * 把View转化成Bitmap
 */
fun View.convertViewToBitmap(): Bitmap {
    measure(
        View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
        View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
    )
    layout(0, 0, measuredWidth, measuredHeight)
    val bitmap =
        Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)
    draw(canvas)
    canvas.save()
    return bitmap
}

