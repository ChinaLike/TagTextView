package com.like.tag

import com.view.text.config.TagConfig

/**
 *
 * @author like
 * @date 4/22/22 4:31 PM
 */
data class ItemBean(
    val text: String,
    val url:String,
    val config: TagConfig? = null
)
