package com.view.text.config

import androidx.annotation.ColorInt

/**
 * 格式化字符串配置
 * @author like
 * @date 4/27/21 2:30 PM
 */
class SpanConfig @JvmOverloads constructor(
    var startIndex: Int,
    var endIndex: Int,
    @ColorInt
    var color: Int? = null,
    var isUnderlineText: Boolean = false
)
