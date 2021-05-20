package com.view.text

/**
 * 标签被点击
 * @author like
 * @date 5/13/21 10:07 AM
 */
interface OnTagClickListener {

    /**
     * 被点击Tag 响应，-1 表示文本被点击了
     * @param [tagIndex] 指定文本点击的下标
     */
    fun onTagClick(tagIndex: Int)

}