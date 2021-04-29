package com.view.text

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ImageSpan
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.view.text.adapter.BaseTagAdapter
import com.view.text.base.ITagText
import com.view.text.config.TagConfig
import com.view.text.constants.TagLocation
import com.view.text.ex.setTextTag
import com.view.text.span.CenterImageSpan
import com.view.text.utils.DensityUtil
import org.jetbrains.annotations.NotNull

/**
 * 标签文本
 * @author like
 * @date 4/20/21 2:18 PM
 */
class TagTextView : AppCompatTextView, ITagText {

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

    /**
     * 标签文本
     */
    private var tagText: String? = null

    /**
     * 标签图片
     */
    private var tagImage: Drawable? = null

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        tagRightPadding = DensityUtil.dp2px(context, 10F).toInt()
        tagLeftPadding = DensityUtil.dp2px(context, 10F).toInt()
        attrs?.let { init(it) }
        //设置文本
        tagText?.let {
            setTextTag(it)
        }
        //设置资源对象
        tagImage?.let {
            setTextTag(it)
        }
    }

    private fun init(attrs: AttributeSet) =
        with(context.obtainStyledAttributes(attrs, R.styleable.TagTextView)) {
            for (i in 0 until indexCount) {
                when (val attr = getIndex(i)) {
                    R.styleable.TagTextView_tvt_left_top_radius -> {
                        leftTopRadius = getDimension(attr, 0F)
                    }
                    R.styleable.TagTextView_tvt_left_bottom_radius -> {
                        leftBottomRadius = getDimension(attr, 0F)
                    }
                    R.styleable.TagTextView_tvt_right_top_radius -> {
                        rightTopRadius = getDimension(attr, 0F)
                    }
                    R.styleable.TagTextView_tvt_right_bottom_radius -> {
                        rightBottomRadius = getDimension(attr, 0F)
                    }
                    R.styleable.TagTextView_tvt_radius -> {
                        radius = getDimension(attr, radius)
                    }
                    R.styleable.TagTextView_tvt_tag_left_padding -> {
                        tagLeftPadding = getDimensionPixelOffset(attr, 0)
                    }
                    R.styleable.TagTextView_tvt_tag_top_padding -> {
                        tagTopPadding = getDimensionPixelOffset(attr, 0)
                    }
                    R.styleable.TagTextView_tvt_tag_right_padding -> {
                        tagRightPadding = getDimensionPixelOffset(attr, 0)
                    }
                    R.styleable.TagTextView_tvt_tag_bottom_padding -> {
                        tagBottomPadding = getDimensionPixelOffset(attr, 0)
                    }
                    R.styleable.TagTextView_tvt_tag_padding -> {
                        tagPadding = getDimensionPixelOffset(attr, tagPadding)
                    }
                    R.styleable.TagTextView_tvt_tag_background_color -> {
                        tagBackgroundColor = getColor(attr, tagBackgroundColor)
                    }
                    R.styleable.TagTextView_tvt_tag_space -> {
                        tagSpace = getDimensionPixelOffset(attr, tagSpace)
                    }
                    R.styleable.TagTextView_tvt_text_space -> {
                        textSpace = getDimensionPixelOffset(attr, textSpace)
                    }
                    R.styleable.TagTextView_tvt_tag_location -> {
                        tagLocation = getInt(attr, tagLocation)
                    }

                    R.styleable.TagTextView_tvt_tag_start_background_color -> {
                        tagStartBackgroundColor = getColor(attr, Color.TRANSPARENT)
                    }
                    R.styleable.TagTextView_tvt_tag_end_background_color -> {
                        tagEndBackgroundColor = getDimensionPixelOffset(attr, Color.TRANSPARENT)
                    }
                    R.styleable.TagTextView_tvt_tag_text_size -> {
                        tagTextSize = getDimension(
                            attr,
                            context.resources.getDimension(R.dimen.tag_text_size)
                        )
                    }
                    R.styleable.TagTextView_tvt_tag_text_color -> {
                        tagTextColor = getColor(attr, tagTextColor)
                    }
                    R.styleable.TagTextView_tvt_first_tag_left_space -> {
                        firstTagLeftSpace = getInt(attr, firstTagLeftSpace)
                    }
                    R.styleable.TagTextView_tvt_tag_text -> {
                        tagText = getString(attr)
                    }
                    R.styleable.TagTextView_tvt_tag_image -> {
                        tagImage = getDrawable(attr)
                    }
                    R.styleable.TagTextView_tvt_tag_width -> {
                        tagWidth = getDimension(attr,0F).toInt()
                    }
                    R.styleable.TagTextView_tvt_tag_height -> {
                        tagHeight = getDimension(attr,0F).toInt()
                    }
                }
            }
            recycle()
        }

    /**
     * 设置文本的标签，自定义标签，样式需要先设置或者在XML中设置
     * @param [adapter] 自定义标签适配器
     */
    override fun setTextTag(adapter: BaseTagAdapter<*>) {
        setTextTag(attrToConfig(),adapter)
    }

    /**
     * 设置文本的标签
     * @param [dataList] 数据 支持传递[String]、[DrawableRes]、[Bitmap]、[Drawable]
     */
    override fun <T> setTextTag(dataList: MutableList<T>) {
        setTextTag(attrToConfig(),dataList)
    }

    /**
     * 设置文本的标签，支持多个字符串，样式需要先设置或者在XML中设置
     * @param [tagText] 标签文本
     */
    override fun setTextTag(vararg tagText: String) {
        tagText?.let {
            setTextTag(attrToConfig(),it.toMutableList())
        }
    }

    /**
     * 设置文本的标签，支持多个[Bitmap]对象，样式需要先设置或者在XML中设置
     * @param [bitmap] 位图
     */
    override fun setTextTag(vararg bitmap: Bitmap) {
        bitmap?.let {
            setTextTag(attrToConfig(),it.toMutableList())
        }
    }

    /**
     * 设置文本的标签，支持多个资源图片文件，样式需要先设置或者在XML中设置
     * @param [imageRes] 图片资源
     */
    override fun setTextTag(@DrawableRes vararg imageRes: Int) {
        imageRes?.let {
            setTextTag(attrToConfig(),it.toMutableList())
        }
    }

    /**
     * 设置文本的标签，支持多个[Drawable]对象，样式需要先设置或者在XML中设置
     * @param [drawable] Drawable对象
     */
    override fun setTextTag(vararg drawable: Drawable) {
        drawable?.let {
            setTextTag(attrToConfig(),it.toMutableList())
        }
    }

    /**
     * 把属性转化成Config
     */
    private fun attrToConfig():TagConfig {
        val config = TagConfig()
        config.leftTopRadius = leftTopRadius
        config.leftBottomRadius = leftBottomRadius
        config.rightTopRadius = rightTopRadius
        config.rightBottomRadius = rightBottomRadius
        config.radius = radius
        config.tagLeftPadding = tagLeftPadding
        config.tagTopPadding = tagTopPadding
        config.tagRightPadding = tagRightPadding
        config.tagBottomPadding = tagBottomPadding
        config.tagPadding = tagPadding
        config.tagBackgroundColor = tagBackgroundColor
        config.tagSpace = tagSpace
        config.textSpace = textSpace
        config.firstTagLeftSpace = firstTagLeftSpace
        config.tagLocation = tagLocation
        config.tagStartBackgroundColor = tagStartBackgroundColor
        config.tagEndBackgroundColor = tagEndBackgroundColor
        config.tagTextSize = tagTextSize
        config.tagTextColor = tagTextColor
        config.tagWidth = tagWidth
        config.tagHeight = tagHeight
        return config
    }
}