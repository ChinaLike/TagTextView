package com.view.text.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View

/**
 * Tag适配器
 * @author like
 * @date 4/21/21 9:54 AM
 */
abstract class BaseTagAdapter<T>(val context: Context,  val data: MutableList<T>) {

    fun getItemCount(): Int {
        return data?.size ?: 0
    }

    /**
     * 自定义Item样式
     */
    abstract fun convert(position: Int):View

}