package com.view.text.config

import android.graphics.Color
import androidx.annotation.ColorInt
import com.view.text.constants.TagLocation

/**
 * 标签配置
 * @author like
 * @date 4/26/21 10:02 AM
 */
class TagConfig {

    /**
     * 标签左上圆角
     */
    var leftTopRadius: Float? = null

    /**
     * 标签左下圆角
     */
    var leftBottomRadius: Float? = null

    /**
     * 标签右上圆角
     */
    var rightTopRadius: Float? = null

    /**
     * 标签右下圆角
     */
    var rightBottomRadius: Float? = null

    /**
     * 标签圆角
     */
    var radius: Float = 9999F

    /**
     * 标签左边内边距
     */
    var tagLeftPadding: Int? = null

    /**
     * 标签顶部内边距
     */
    var tagTopPadding: Int? = null

    /**
     * 标签右边内边距
     */
    var tagRightPadding: Int? = null

    /**
     * 标签底部内边距
     */
    var tagBottomPadding: Int? = null

    /**
     * 标签内边距
     */
    var tagPadding: Int = 0

    /**
     * 标签背景颜色
     */
    @ColorInt
    var tagBackgroundColor: Int = Color.GRAY

    /**
     * 标签之间的间隙
     */
    var tagSpace: Int = 0

    /**
     * 文本与标签的间距
     */
    var textSpace: Int = 0

    /**
     * 最左边间距
     */
    var firstTagLeftSpace: Int = 0

    /**
     * 标签位置
     */
    var tagLocation: Int = TagLocation.START

    /**
     * 标签渐变开始颜色
     */
    var tagStartBackgroundColor: Int? = null

    /**
     * 标签渐变结束颜色
     */
    var tagEndBackgroundColor: Int? = null

    /**
     * 标签大小，单位 px
     */
    var tagTextSize: Float? = null

    /**
     * 标签文字颜色
     */
    var tagTextColor: Int = Color.WHITE

    /**
     * 标签宽度
     */
    var tagWidth:Int? = null

    /**
     * 标签高度
     */
    var tagHeight:Int? = null

}