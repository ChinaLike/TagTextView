package com.view.text.view

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.appcompat.widget.AppCompatTextView
import com.view.text.R
import com.view.text.annotation.Align
import com.view.text.annotation.DrawableZoomType
import com.view.text.config.LinkType
import com.view.text.config.Orientation
import com.view.text.config.TagConfig
import com.view.text.config.Type
import com.view.text.addImageTag as addImageTagKx
import com.view.text.addTag as addTagKx
import com.view.text.addTextImageTag as addTextImageTagKx
import com.view.text.addTextTag as addTextTagKx
import com.view.text.addUrlTag as addUrlTagKx
import com.view.text.getOriginalText as getOriginalTextKx
import com.view.text.replaceTag as replaceTagKx
import com.view.text.setDeleteLine as setDeleteLineKx
import com.view.text.setSpecificTextColor as setSpecificTextColorKx
import com.view.text.setURLSpan as setURLSpanKx
import com.view.text.setUnderline as setUnderlineKx

/**
 * 自定义标签文本
 * @author like
 * @date 4/15/22 1:56 PM
 */
open class TagTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    private var config: TagConfig? = null

    init {
        attrs?.apply(::init)
    }

    private fun init(attrs: AttributeSet) =
        with(context.obtainStyledAttributes(attrs, R.styleable.TagTextView)) {
            //自定义View
            var customLayout: View? = null
            val type = getInt(R.styleable.TagTextView_tvt_type, -1)
            config = when (type) {
                Type.TEXT.ordinal -> TagConfig(Type.TEXT)
                Type.IMAGE.ordinal -> TagConfig(Type.IMAGE)
                Type.TEXT_IMAGE.ordinal -> TagConfig(Type.TEXT_IMAGE)
                else -> null
            }

            var position: Int = config?.position ?: 0
            var align: Int = config?.align ?: Align.CENTER
            var drawableZoomType: Int = config?.align ?: DrawableZoomType.ORIGINAL
            var marginLeft: Int = config?.marginLeft ?: 0
            var marginRight: Int = config?.marginRight ?: 0

            for (i in 0 until indexCount) {
                when (val attr = getIndex(i)) {
                    R.styleable.TagTextView_tvt_radius -> {
                        config?.radius = getDimension(attr, 0F)
                    }

                    R.styleable.TagTextView_tvt_left_top_radius -> {
                        config?.leftTopRadius = getDimension(attr, 0F)
                    }

                    R.styleable.TagTextView_tvt_left_bottom_radius -> {
                        config?.leftBottomRadius = getDimension(attr, 0F)
                    }

                    R.styleable.TagTextView_tvt_right_top_radius -> {
                        config?.rightTopRadius = getDimension(attr, 0F)
                    }

                    R.styleable.TagTextView_tvt_right_bottom_radius -> {
                        config?.rightBottomRadius = getDimension(attr, 0F)
                    }

                    R.styleable.TagTextView_tvt_padding -> {
                        config?.padding = getDimension(attr, 0F).toInt()
                    }

                    R.styleable.TagTextView_tvt_top_padding -> {
                        config?.topPadding = getDimension(attr, 0F).toInt()
                    }

                    R.styleable.TagTextView_tvt_right_padding -> {
                        config?.rightPadding = getDimension(attr, 0F).toInt()
                    }

                    R.styleable.TagTextView_tvt_bottom_padding -> {
                        config?.bottomPadding = getDimension(attr, 0F).toInt()
                    }

                    R.styleable.TagTextView_tvt_left_padding -> {
                        config?.leftPadding = getDimension(attr, 0F).toInt()
                    }

                    R.styleable.TagTextView_tvt_background_color -> {
                        config?.backgroundColor = getColor(attr, Color.TRANSPARENT)
                    }

                    R.styleable.TagTextView_tvt_background_img -> {
                        config?.backgroundDrawable = getDrawable(attr)
                    }

                    R.styleable.TagTextView_tvt_start_gradient_background_color -> {
                        config?.startGradientBackgroundColor = getColor(attr, Color.TRANSPARENT)
                    }

                    R.styleable.TagTextView_tvt_end_gradient_background_color -> {
                        config?.endGradientBackgroundColor = getColor(attr, Color.TRANSPARENT)
                    }

                    R.styleable.TagTextView_tvt_stroke_width -> {
                        config?.strokeWidth = getDimension(attr, 0F).toInt()
                    }

                    R.styleable.TagTextView_tvt_stroke_color -> {
                        config?.strokeColor = getColor(attr, Color.GRAY)
                    }

                    R.styleable.TagTextView_tvt_text_size -> {
                        val textSize = getDimension(attr, 0F)
                        if (textSize != 0F) {
                            config?.textSize = textSize
                        }
                    }

                    R.styleable.TagTextView_tvt_text_color -> {
                        config?.textColor = getColor(attr, Color.GRAY)
                    }

                    R.styleable.TagTextView_tvt_width -> {
                        config?.width = getDimension(attr, 0F).toInt()
                    }

                    R.styleable.TagTextView_tvt_height -> {
                        config?.height = getDimension(attr, 0F).toInt()
                    }

                    R.styleable.TagTextView_tvt_align -> {
                        align = getInt(attr, Align.CENTER)
                        config?.align = align
                    }

                    R.styleable.TagTextView_tvt_text -> {
                        config?.text = getString(attr) ?: ""
                    }

                    R.styleable.TagTextView_tvt_image_resource -> {
                        config?.imageDrawable = getDrawable(attr)
                    }

                    R.styleable.TagTextView_tvt_position -> {
                        position = getInt(attr, 0)
                        config?.position = position
                    }

                    R.styleable.TagTextView_tvt_margin_left -> {
                        marginLeft = getDimension(attr, 0F).toInt()
                        config?.marginLeft = marginLeft
                    }

                    R.styleable.TagTextView_tvt_margin_right -> {
                        marginRight = getDimension(attr, 0F).toInt()
                        config?.marginRight = marginRight
                    }

                    R.styleable.TagTextView_tvt_text_margin_image -> {
                        config?.textMarginImage = getDimension(attr, 0F).toInt()
                    }

                    R.styleable.TagTextView_tvt_layout -> {
                        val resourceId = getResourceId(attr, 0)
                        if (resourceId != 0) {
                            customLayout = inflate(context, resourceId, null)
                        }
                    }

                    R.styleable.TagTextView_tvt_image_align_text -> {
                        val imageAlignText = getInt(attr, Orientation.LEFT.ordinal)
                        config?.imageAlignText = when (imageAlignText) {
                            Orientation.TOP.ordinal -> Orientation.TOP
                            Orientation.RIGHT.ordinal -> Orientation.RIGHT
                            Orientation.BOTTOM.ordinal -> Orientation.BOTTOM
                            else -> Orientation.LEFT
                        }
                    }

                    R.styleable.TagTextView_tvt_drawable_zoom_type -> {
                        drawableZoomType = getInt(attr, DrawableZoomType.ORIGINAL)
                        config?.drawableZoomType = drawableZoomType
                    }

                    R.styleable.TagTextView_tvt_image_width -> {
                        config?.imageWidth = getDimension(
                            attr,
                            ViewGroup.LayoutParams.WRAP_CONTENT.toFloat()
                        ).toInt()
                    }

                    R.styleable.TagTextView_tvt_image_height -> {
                        config?.imageHeight = getDimension(
                            attr,
                            ViewGroup.LayoutParams.WRAP_CONTENT.toFloat()
                        ).toInt()
                    }
                }
            }
            if (customLayout != null) {
                addTag(customLayout, position, align, marginLeft, marginRight)
            } else {
                config?.apply(::addTag)
            }
            recycle()
        }

    /**
     * 添加标签
     * @param [config] 标签配置
     * @param [onClickListener] 监听事件
     */
    @JvmOverloads
    fun addTag(config: TagConfig, onClickListener: (() -> Unit)? = null): TagTextView = apply {
        addTagKx(config, onClickListener)
    }

    /**
     * 添加自定义标签
     * @param [view] 标签View
     * @param [position] 标签在文本中显示位置
     * @param [align] 标签与文本显示位置
     * @param [marginLeft] 标签左边距
     * @param [marginRight] 标签右边距
     * @param [onClickListener] 监听事件
     */
    @JvmOverloads
    fun addTag(
        view: View,
        position: Int = 0,
        @Align align: Int = Align.CENTER,
        marginLeft: Int = 0,
        marginRight: Int = 0,
        onClickListener: (() -> Unit)? = null
    ): TagTextView = apply {
        addTagKx(view, position, align, marginLeft, marginRight, onClickListener)
    }

    /**
     * 添加文本标签
     * @param [block] 配置
     */
    fun addTextTag(block: TagConfig.() -> Unit): TagTextView = apply {
        addTextTagKx(block)
    }

    /**
     * 添加文本标签
     * @param [block] 配置
     * @param [onClickListener] 监听事件
     */
    fun addTextTag(block: TagConfig.() -> Unit, onClickListener: () -> Unit): TagTextView = apply {
        addTextTagKx(block, onClickListener)
    }

    /**
     * 添加图标标签
     * @param [block] 配置
     */
    fun addImageTag(block: TagConfig.() -> Unit): TagTextView = apply {
        addImageTagKx(block)
    }

    /**
     * 添加图标标签
     * @param [block] 配置
     * @param [onClickListener] 监听事件
     */
    fun addImageTag(block: TagConfig.() -> Unit, onClickListener: () -> Unit): TagTextView = apply {
        addImageTagKx(block, onClickListener)
    }

    /**
     * 添加图文标签
     * @param [block] 配置
     */
    fun addTextImageTag(block: TagConfig.() -> Unit): TagTextView = apply {
        addTextImageTagKx(block)
    }

    /**
     * 添加图文标签
     * @param [block] 配置
     * @param [onClickListener] 监听事件
     */
    fun addTextImageTag(block: TagConfig.() -> Unit, onClickListener: () -> Unit): TagTextView =
        apply {
            addTextImageTagKx(block, onClickListener)
        }

    /**
     * 添加网络标签
     * @param [block] 配置
     */
    fun addUrlTag(block: TagConfig.() -> Unit): TagTextView = apply {
        addUrlTagKx(block)
    }

    /**
     * 添加网络标签
     * @param [block] 配置
     * @param [onClickListener] 监听事件
     */
    fun addUrlTag(block: TagConfig.() -> Unit, onClickListener: () -> Unit): TagTextView = apply {
        addUrlTagKx(block, onClickListener)
    }

    /**
     * 设置下划线
     * @param [underlineText] 需要添加下划线的文本,不传或者为空就全部文本添加下划线
     * @param [isFirst] 是否匹配第一个，true是，false匹配最后一个
     * @param [click] 点击事件
     */
    @JvmOverloads
    fun setUnderline(
        underlineText: String? = null,
        isFirst: Boolean = true,
        click: () -> Unit = {}
    ): TagTextView = apply {
        setUnderlineKx(underlineText, isFirst, click)
    }

    /**
     * 设置下划线
     * @param [startIndex] 指定开始位置
     * @param [endIndex] 指定结束位置
     * @param [click] 点击事件
     */
    @JvmOverloads
    fun setUnderline(startIndex: Int, endIndex: Int, click: () -> Unit = {}): TagTextView = apply {
        setUnderlineKx(startIndex, endIndex, click)
    }

    /**
     * 设置文本删除线
     * @param [deleteLineText] 需要添加删除线的文本,不传或者为空就全部文本添加删除线
     * @param [isFirst] 是否匹配第一个，true是，false匹配最后一个
     * @param [color] 删除线文本颜色
     * @param [click] 点击事件
     */
    @JvmOverloads
    fun setDeleteLine(
        deleteLineText: String? = null,
        isFirst: Boolean = true,
        @ColorInt color: Int? = null,
        click: () -> Unit = {}
    ): TagTextView =
        apply {
            setDeleteLineKx(deleteLineText, isFirst, color, click)
        }

    /**
     * 设置文本删除线
     * @param [startIndex] 指定开始位置
     * @param [endIndex] 指定结束位置
     * @param [color] 删除线文本颜色
     * @param [click] 点击事件
     */
    fun setDeleteLine(
        startIndex: Int,
        endIndex: Int,
        @ColorInt color: Int? = null,
        click: () -> Unit = {}
    ): TagTextView = apply {
        setDeleteLineKx(startIndex, endIndex, color, click)
    }

    /**
     * 指定文字颜色
     * @param [color] 文字颜色
     * @param [specificText] 指定文字
     * @param [isFirst] 是否匹配第一个，true是，false匹配最后一个
     * @param [isUnderlineText] 是否添加下划线
     * @param [click] 点击事件
     */
    @JvmOverloads
    fun setSpecificTextColor(
        @ColorInt color: Int,
        specificText: String,
        isFirst: Boolean = true,
        isUnderlineText: Boolean = false,
        click: () -> Unit = {}
    ): TagTextView = apply {
        setSpecificTextColorKx(color, specificText, isFirst, isUnderlineText, click)
    }

    /**
     * 指定文字颜色
     * @param [color] 文字颜色
     * @param [startIndex] 开始下标
     * @param [endIndex] 结束下标
     * @param [isUnderlineText] 是否添加下划线
     * @param [click] 点击事件
     */
    @JvmOverloads
    fun setSpecificTextColor(
        @ColorInt color: Int,
        startIndex: Int,
        endIndex: Int,
        isUnderlineText: Boolean = false,
        click: () -> Unit = {}
    ): TagTextView = apply {
        setSpecificTextColorKx(color, startIndex, endIndex, isUnderlineText, click)
    }

    /**
     * 设置超链
     * @param [startIndex] 开始下标
     * @param [endIndex] 结束下标
     * @param [type] 类型
     * @param [linkText] 链接文本 ，比如跳转电话，只需要传入电话号码就可以
     * @param [color] 文本颜色
     * @param [isUnderlineText] 是否添加下划线
     */
    @JvmOverloads
    fun setURLSpan(
        startIndex: Int,
        endIndex: Int,
        type: LinkType,
        linkText: String,
        @ColorInt color: Int? = null,
        isUnderlineText: Boolean = false
    ): TagTextView = apply {
        setURLSpanKx(startIndex, endIndex, type, linkText, color, isUnderlineText)
    }

    /**
     * 替换标签
     * 1.[config]中设置position无效
     * @param [tagText] 需要替换的文本
     * @param [config] 标签配置
     * @param [isFirst] 是否匹配第一个
     * @param [onClickListener] 监听事件
     */
    @JvmOverloads
    fun replaceTag(
        tagText: String,
        config: TagConfig,
        isFirst: Boolean = true,
        onClickListener: (() -> Unit)? = null
    ): TagTextView =
        apply {
            replaceTagKx(tagText, config, isFirst, onClickListener)
        }

    /**
     * 替换标签
     * @param [tagText] 需要替换的文本
     * @param [view] 自定义标签
     * @param [isFirst] 是否匹配第一个
     * @param [align] 标签对齐方式
     * @param [marginLeft] 标签距离左侧距离
     * @param [marginRight] 标签距离右侧距离
     * @param [onClickListener] 监听事件
     */
    @JvmOverloads
    fun replaceTag(
        tagText: String,
        view: View,
        isFirst: Boolean = true,
        @Align align: Int = Align.CENTER,
        marginLeft: Int = 0,
        marginRight: Int = 0,
        onClickListener: (() -> Unit)? = null
    ): TagTextView = apply {
        replaceTagKx(tagText, view, isFirst, align, marginLeft, marginRight, onClickListener)
    }

    /**
     * 替换标签
     * 1.[config]中设置position无效
     * @param [startIndex] 开始下标
     * @param [endIndex] 结束下标
     * @param [config] 标签配置
     * @param [onClickListener] 监听事件
     */
    @JvmOverloads
    fun replaceTag(
        startIndex: Int,
        endIndex: Int,
        config: TagConfig,
        onClickListener: (() -> Unit)? = null
    ): TagTextView = apply {
        replaceTagKx(startIndex, endIndex, config, onClickListener)
    }

    /**
     * 替换标签
     * @param [startIndex] 开始位置
     * @param [endIndex] 结束位置
     * @param [view] 自定义标签
     * @param [align] 标签对齐方式
     * @param [marginLeft] 标签距离左侧距离
     * @param [marginRight] 标签距离右侧距离
     * @param [onClickListener] 监听事件
     */
    @JvmOverloads
    fun replaceTag(
        startIndex: Int,
        endIndex: Int,
        view: View,
        @Align align: Int = Align.CENTER,
        marginLeft: Int = 0,
        marginRight: Int = 0,
        onClickListener: (() -> Unit)? = null
    ): TagTextView = apply {
        replaceTagKx(startIndex, endIndex, view, align, marginLeft, marginRight, onClickListener)
    }

    /**
     * 获取文本
     */
    fun getOriginalText(): CharSequence {
        return getOriginalTextKx()
    }
}