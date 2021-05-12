package com.view.text.config

import androidx.annotation.ColorInt
import com.view.text.constants.SpanType

/**
 * 超链配置
 * @author like
 * @date 4/27/21 2:16 PM
 */
class URLSpanConfig @JvmOverloads constructor(
    var startIndex: Int,
    var endIndex: Int,
    var type: SpanType,
    var linkText: String,
    @ColorInt
    var color: Int? = null,
    var isUnderlineText: Boolean = false
)
