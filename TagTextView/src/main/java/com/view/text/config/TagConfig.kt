package com.view.text.config

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
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
     * 文字大小
     */
    @Dimension(unit = Dimension.PX)
    var textSize: Float? = null

    /**
     * 文字的颜色
     */
    @ColorInt
    var textColor: Int = Color.WHITE

    /**
     * 标签的宽度
     */
    var width: Int? = null

    /**
     * 标签的高度
     */
    var height: Int? = null

    /**
     * 标签的圆角
     */
    var radius: Float? = null

    /**
     * 默认圆角大小
     */
    private val defaultRadius = 2.dp.toFloat()

    /**
     * 标签左上圆角
     */
    var leftTopRadius: Float = defaultRadius

    /**
     * 标签左下圆角
     */
    var leftBottomRadius: Float = defaultRadius

    /**
     * 标签右上圆角
     */
    var rightTopRadius: Float = defaultRadius

    /**
     * 标签右下圆角
     */
    var rightBottomRadius: Float = defaultRadius

    /**
     * 内边距
     */
    var padding: Int? = null

    /**
     * 默认内边距
     */
    private val defaultPadding = 5.dp

    /**
     * 上内边距
     */
    var topPadding: Int = 0

    /**
     * 右内边距
     */
    var rightPadding: Int = defaultPadding

    /**
     * 下内边距
     */
    var bottomPadding: Int = 0

    /**
     * 左内边距
     */
    var leftPadding: Int = defaultPadding

    /**
     * 背景颜色
     */
    @ColorInt
    var backgroundColor: Int = Color.GRAY

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
     * 渐变方向
     */
    var gradientOrientation: GradientDrawable.Orientation = GradientDrawable.Orientation.LEFT_RIGHT

    /**
     * 边框大小
     */
    var strokeWidth: Int = 0

    /**
     * 边框颜色
     */
    @ColorInt
    var strokeColor: Int = Color.GRAY

    /**
     * 图片在文字那一个方向，默认 左侧
     */
    var imageAlignText: Orientation = Orientation.LEFT

    /**
     * 图片的宽度，不设置为宽度自适应
     */
    var imageWidth: Int? = null

    /**
     * 图片的高度，不设置为高度自适应
     */
    var imageHeight: Int? = null

    /**
     * 标签对其方式
     */
    var align: Align = Align.CENTER

    /**
     * 文本，[type] 为[Type.TEXT] 或[Type.TEXT_IMAGE]可用
     */
    var text: String = ""

    /**
     * 本地图片，[type] 为[Type.IMAGE] 或[Type.TEXT_IMAGE]可用
     */
    @DrawableRes
    var imageResource: Int? = null

    /**
     * 图片Drawable，[type] 为[Type.IMAGE] 或[Type.TEXT_IMAGE]可用
     */
    var imageDrawable: Drawable? = null

    /**
     * 图片Bitmap，[type] 为[Type.IMAGE] 或[Type.TEXT_IMAGE]可用
     */
    var imageBitmap: Bitmap? = null

    /**
     * 图片的网络Url，[type] 为[Type.URL]可用
     */
    var imageUrl: String? = null

    /**
     * 显示位置
     */
    var position: Int = 0

    /**
     * 设置距离左边
     */
    var marginLeft: Int = 0

    /**
     * 设置距离右边
     */
    var marginRight: Int = 0

    /**
     * 设置文字距离图片的距离，当[type]=[Type.TEXT_IMAGE]时有效
     */
    var textMarginImage: Int = 0

}