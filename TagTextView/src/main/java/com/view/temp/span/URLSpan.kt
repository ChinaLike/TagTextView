package com.view.temp.span

import android.graphics.Color
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.text.style.URLSpan
import android.view.View
import androidx.annotation.ColorInt

/**
 * 点击Span
 * @author like
 * @date 4/16/22 5:13 PM
 */
class URLSpan @JvmOverloads constructor(
    url: String,
    @ColorInt val color: Int? = null,
    private val isUnderlineText: Boolean = false
) : URLSpan(url) {

    /**
     * 点击事件
     */
    var onClick: () -> Unit = {}

    /**
     * 点击后的背景颜色
     */
    @ColorInt
    var bgColor: Int = Color.TRANSPARENT

    override fun onClick(widget: View) {
        onClick()
    }

    override fun updateDrawState(ds: TextPaint) {
        color?.apply(ds::setColor)
        ds.isUnderlineText = isUnderlineText
        ds.bgColor = bgColor
    }

}