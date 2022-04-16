package com.view.temp.adapter

import android.content.Context
import android.view.View
import com.view.temp.config.TagConfig

/**
 *
 * @author like
 * @date 4/15/22 2:52 PM
 */
class SimpleTagAdapter(context: Context,dataList:MutableList<TagConfig>):BaseTagAdapter(context,dataList) {

    override fun convert(position: Int, item: TagConfig): View {
        return View(context)
    }
}