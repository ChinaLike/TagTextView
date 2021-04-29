package com.view.text.base

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import com.view.text.adapter.BaseTagAdapter

/**
 * 定义方法
 * @author like
 * @date 4/25/21 1:46 PM
 */
interface ITagText {

    /**
     * 设置文本的标签，自定义标签，样式需要先设置或者在XML中设置
     * @param [adapter] 自定义标签适配器
     */
    fun setTextTag(adapter:BaseTagAdapter<*>)

    /**
     * 设置文本的标签
     * @param [dataList] 数据 支持传递[String]、[DrawableRes]、[Bitmap]、[Drawable]
     */
    fun <T> setTextTag(dataList:MutableList<T>)

    /**
     * 设置文本的标签，支持多个字符串，样式需要先设置或者在XML中设置
     * @param [tagText] 标签文本
     */
    fun setTextTag(vararg tagText:String)

    /**
     * 设置文本的标签，支持多个资源图片文件，样式需要先设置或者在XML中设置
     * @param [imageRes] 图片资源
     */
    fun setTextTag(@DrawableRes vararg imageRes:Int)

    /**
     * 设置文本的标签，支持多个[Bitmap]对象，样式需要先设置或者在XML中设置
     * @param [bitmap] 位图
     */
    fun setTextTag(vararg bitmap: Bitmap)

    /**
     * 设置文本的标签，支持多个[Drawable]对象，样式需要先设置或者在XML中设置
     * @param [drawable] Drawable对象
     */
    fun setTextTag(vararg drawable: Drawable)

}