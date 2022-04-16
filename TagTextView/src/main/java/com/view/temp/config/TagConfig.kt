package com.view.temp.config

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import androidx.annotation.Dimension
import androidx.annotation.DrawableRes
import com.core.util.dp
import com.core.util.sp

/**
 * 每一个标签Item的配置
 * @author like
 * @date 4/15/22 10:07 AM
 */
data class TagConfig(val type: Type) {

    /**
     * 标签的圆角
     */
    var radius: Int = 2.dp

    /**
     * 标签左上圆角
     */
    var leftTopRadius: Int? = null

    /**
     * 标签左下圆角
     */
    var leftBottomRadius: Int? = null

    /**
     * 标签右上圆角
     */
    var rightTopRadius: Int? = null

    /**
     * 标签右下圆角
     */
    var rightBottomRadius: Int? = null

    /**
     * 内边距
     */
    var padding: Int = 0

    /**
     * 上内边距
     */
    var topPadding: Int? = null

    /**
     * 右内边距
     */
    var rightPadding: Int? = null

    /**
     * 下内边距
     */
    var bottomPadding: Int? = null

    /**
     * 左内边距
     */
    var leftPadding: Int? = null

    /**
     * 背景颜色
     */
    @ColorInt
    var backgroundColor: Int = Color.TRANSPARENT

    /**
     * 开始渐变颜色
     */
    @ColorInt
    var startGradientBackgroundColor: Int? = null

    /**
     * 结束渐变颜色
     */
    @ColorInt
    var endGradientBackgroundColor: Int? = null

    /**
     * 边框大小
     */
    var strokeWidth:Int = 0

    /**
     * 边框颜色
     */
    @ColorInt
    var strokeColor:Int = Color.GRAY

    /**
     * 文字大小
     */
    @Dimension(unit = Dimension.SP)
    var textSize: Float = 14F

    /**
     * 文字的颜色
     */
    @ColorInt
    var textColor: Int = Color.GRAY

    /**
     * 标签的宽度，不设置自适应大小
     */
    var width: Int? = null

    /**
     * 标签的高度，不设置自适应高度
     */
    var height: Int = textSize.sp

    /**
     * 标签对其方式
     */
    var align: Align = Align.CENTER

    /**
     * 文本，[type] 为[Type.TEXT] 或[Type.TEXT_IMAGE]可用
     */
    var text:String = ""

    /**
     * 本地图片，[type] 为[Type.IMAGE] 或[Type.TEXT_IMAGE]可用
     */
    @DrawableRes
    var imageResource:Int? = null

    /**
     * 图片Drawable，[type] 为[Type.IMAGE] 或[Type.TEXT_IMAGE]可用
     */
    var imageDrawable:Drawable? = null

    /**
     * 图片Bitmap，[type] 为[Type.IMAGE] 或[Type.TEXT_IMAGE]可用
     */
    var imageBitmap:Bitmap? = null

    /**
     * 图片的网络Url，[type] 为[Type.URL]可用
     */
    var imageUrl:String? = null

    /**
     * 显示位置
     */
    var position:Int = 0

    /**
     * 设置距离左边
     */
    var marginLeft:Int = 0

    /**
     * 设置距离右边
     */
    var marginRight:Int = 0

    /**
     * 设置文字距离图片的距离，当[type]=[Type.TEXT_IMAGE]时有效
     */
    var textMarginImage:Int = 0

}