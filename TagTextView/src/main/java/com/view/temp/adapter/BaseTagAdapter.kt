package com.view.temp.adapter

import android.content.Context
import android.view.View
import com.view.temp.config.TagConfig

/**
 *
 * @author like
 * @date 4/15/22 2:23 PM
 */
abstract class BaseTagAdapter(val context: Context, val dataList: MutableList<TagConfig>) {

    fun getItemCount(): Int = dataList.size

    abstract fun convert(position:Int,item:TagConfig):View

}