package com.view.temp.span

import android.graphics.Color
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.view.View
import androidx.annotation.ColorInt

/**
 * 点击Span
 * @author like
 * @date 4/16/22 5:13 PM
 */
class ClickableSpan @JvmOverloads constructor(
    @ColorInt val color: Int,
    private val isUnderlineText: Boolean = false
) : ClickableSpan() {

    /**
     * 点击事件
     */
    var onClick: () -> Unit = {}

    /**
     * 点击后的背景颜色
     */
    @ColorInt
    var bgColor:Int = Color.TRANSPARENT

    override fun onClick(widget: View) {
        onClick()
    }

    override fun updateDrawState(ds: TextPaint) {
        ds.color = color
        ds.isUnderlineText = isUnderlineText
        ds.bgColor = bgColor
    }

}