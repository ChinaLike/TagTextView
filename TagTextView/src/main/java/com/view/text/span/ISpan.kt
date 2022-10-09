package com.view.text.span

import com.view.text.annotation.DrawableZoomType
import com.view.text.annotation.Align

/**
 *
 * @author like
 * @date 2022/10/9 14:38
 */
interface ISpan {

    /**
     * 设置居中方式
     * @param [align] 居中方式
     */
    fun setAlign(@Align align: Int)

    /**
     * 设置字体大小
     * @param [size] 字体大小，单位px
     */
    fun setTextSize(size: Int)

    /**
     * 设置图片缩放类型
     * @param [type] 参考[DrawableZoomType]
     */
    fun setDrawableZoomType(@DrawableZoomType type:Int)

    /**
     * 设置Drawable的大小
     * @param [width] 宽度
     * @param [height] 高度，默认 高度=宽度
     */
    fun setDrawableSize(width: Int, height: Int = width)

    /**
     * 设置Drawable的左右间距
     * @param [left] 左边间距
     * @param [right] 右边间距
     */
    fun setMarginHorizontal(left: Int, right: Int = left)

    /**
     * 设置Drawable的上下间距
     * @param [top] 上边间距
     * @param [bottom] 下边间距
     */
    fun setMarginVertical(top: Int, bottom: Int = top)

}