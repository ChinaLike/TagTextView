package com.view.text

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.TextUtils
import android.text.method.LinkMovementMethod
import android.text.style.ReplacementSpan
import android.text.style.StrikethroughSpan
import android.text.style.UnderlineSpan
import android.view.View
import android.widget.TextView
import androidx.annotation.ColorInt
import com.view.text.annotation.Align
import com.view.text.config.LinkType
import com.view.text.config.TagConfig
import com.view.text.config.Type
import com.view.text.movement.ClickableMovementMethod
import com.view.text.span.CenterImageSpan
import com.view.text.span.ClickableSpan
import com.view.text.span.GlideImageSpan
import com.view.text.span.URLSpan
import com.view.text.view.TagItemView

/**
 * 插入占位标签
 */
private const val TAG: String = "T"

/**
 * 添加标签
 * @param [config] 标签配置
 * @param [onClickListener] 监听事件
 */
@JvmOverloads
fun TextView.addTag(config: TagConfig, onClickListener: (() -> Unit)? = null): TextView = apply {
    verifyText(this)
    val builder = createSpannableStringBuilder(this, config.position)
    val newPosition = insertPlaceholder(builder, config.position)
    val imageSpan = createSpan(this, config)
    builder.setSpan(
        imageSpan,
        newPosition,
        newPosition + TAG.length,
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
    )
    setClickListener(builder, newPosition, newPosition + TAG.length, onClickListener)
    text = builder
}

/**
 * 替换标签
 * 1.[config]中设置position无效
 * @param [tagText] 需要替换的文本
 * @param [config] 标签配置
 * @param [isFirst] 是否匹配第一个
 * @param [onClickListener] 点击事件
 */
@JvmOverloads
fun TextView.replaceTag(
    tagText: String,
    config: TagConfig,
    isFirst: Boolean = true,
    onClickListener: (() -> Unit)? = null
): TextView =
    apply {
        verifyText(this)
        val startIndex = if (isFirst) text.indexOf(tagText) else text.lastIndexOf(tagText)
        if (startIndex == -1) {
            return this
        }
        config.position = startIndex
        val builder = createSpannableStringBuilder(this, config.position)
        val imageSpan = createSpan(this, config)
        builder.setSpan(
            imageSpan,
            startIndex,
            startIndex + tagText.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        setClickListener(builder, startIndex, startIndex + tagText.length, onClickListener)
        text = builder
    }

/**
 * 替换标签
 * @param [tagText] 需要替换的文本
 * @param [view] 自定义标签
 * @param [isFirst] 是否匹配第一个
 * @param [align] 标签对齐方式
 * @param [marginLeft] 标签距离左侧距离
 * @param [marginRight] 标签距离右侧距离
 * @param [onClickListener] 点击事件
 */
@JvmOverloads
fun TextView.replaceTag(
    tagText: String,
    view: View,
    isFirst: Boolean = true,
    @Align align: Int = Align.CENTER,
    marginLeft: Int = 0,
    marginRight: Int = 0,
    onClickListener: (() -> Unit)? = null
): TextView = apply {
    verifyText(this)
    val startIndex = if (isFirst) text.indexOf(tagText) else text.lastIndexOf(tagText)
    if (startIndex == -1) {
        return this
    }
    val builder = createSpannableStringBuilder(this, startIndex)
    val imageSpan = CenterImageSpan(createDrawable(view)).apply {
        setAlign(align)
        setMarginHorizontal(marginLeft, marginRight)
    }
    builder.setSpan(
        imageSpan,
        startIndex,
        startIndex + tagText.length,
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
    )
    setClickListener(builder, startIndex, startIndex + tagText.length, onClickListener)
    text = builder
}

/**
 * 替换标签
 * 1.[config]中设置position无效
 * @param [startIndex] 开始下标
 * @param [endIndex] 结束下标
 * @param [config] 标签配置
 * @param [onClickListener] 点击事件
 */
@JvmOverloads
fun TextView.replaceTag(
    startIndex: Int,
    endIndex: Int,
    config: TagConfig,
    onClickListener: (() -> Unit)? = null
): TextView = apply {
    verifyText(this)
    if (verifyPosition(startIndex, endIndex)) {
        config.position = startIndex
        val builder = createSpannableStringBuilder(this, config.position)
        val imageSpan = createSpan(this, config)
        builder.setSpan(
            imageSpan,
            startIndex,
            endIndex,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        setClickListener(builder, startIndex, endIndex, onClickListener)
        text = builder
    }
}

/**
 * 替换标签
 * @param [startIndex] 开始位置
 * @param [endIndex] 结束位置
 * @param [view] 自定义标签
 * @param [align] 标签对齐方式
 * @param [marginLeft] 标签距离左侧距离
 * @param [marginRight] 标签距离右侧距离
 * @param [onClickListener] 点击事件
 */
@JvmOverloads
fun TextView.replaceTag(
    startIndex: Int,
    endIndex: Int,
    view: View,
    @Align align: Int = Align.CENTER,
    marginLeft: Int = 0,
    marginRight: Int = 0,
    onClickListener: (() -> Unit)? = null
): TextView = apply {
    verifyText(this)
    if (verifyPosition(startIndex, endIndex)) {
        val builder = createSpannableStringBuilder(this, startIndex)
        val imageSpan = CenterImageSpan(createDrawable(view)).apply {
            setAlign(align)
            setMarginHorizontal(marginLeft, marginRight)
        }
        builder.setSpan(
            imageSpan,
            startIndex,
            endIndex,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        setClickListener(builder, startIndex, endIndex, onClickListener)
        text = builder
    }
}

/**
 * 添加文本标签
 * @param [block] 配置
 */
fun TextView.addTextTag(block: TagConfig.() -> Unit): TextView = apply {
    val tagConfig = TagConfig(Type.TEXT)
    block(tagConfig)
    addTag(tagConfig)
}

/**
 * 添加文本标签
 * @param [block] 配置
 * @param [onClickListener] 监听事件
 */
fun TextView.addTextTag(block: TagConfig.() -> Unit, onClickListener: () -> Unit): TextView =
    apply {
        val tagConfig = TagConfig(Type.TEXT)
        block(tagConfig)
        addTag(tagConfig, onClickListener)
    }

/**
 * 添加图标标签
 * @param [block] 配置
 */
fun TextView.addImageTag(block: TagConfig.() -> Unit): TextView = apply {
    val tagConfig = TagConfig(Type.IMAGE)
    block(tagConfig)
    addTag(tagConfig)
}

/**
 * 添加图标标签
 * @param [block] 配置
 * @param [onClickListener] 监听事件
 */
fun TextView.addImageTag(block: TagConfig.() -> Unit, onClickListener: () -> Unit): TextView =
    apply {
        val tagConfig = TagConfig(Type.IMAGE)
        block(tagConfig)
        addTag(tagConfig, onClickListener)
    }

/**
 * 添加图文标签
 * @param [block] 配置
 */
fun TextView.addTextImageTag(block: TagConfig.() -> Unit): TextView = apply {
    val tagConfig = TagConfig(Type.TEXT_IMAGE)
    block(tagConfig)
    addTag(tagConfig)
}

/**
 * 添加图文标签
 * @param [block] 配置
 * @param [onClickListener] 监听事件
 */
fun TextView.addTextImageTag(block: TagConfig.() -> Unit, onClickListener: () -> Unit): TextView =
    apply {
        val tagConfig = TagConfig(Type.TEXT_IMAGE)
        block(tagConfig)
        addTag(tagConfig, onClickListener)
    }

/**
 * 添加网络标签
 * @param [block] 配置
 */
fun TextView.addUrlTag(block: TagConfig.() -> Unit): TextView = apply {
    val tagConfig = TagConfig(Type.URL)
    block(tagConfig)
    addTag(tagConfig)
}

/**
 * 添加网络标签
 * @param [block] 配置
 * @param [onClickListener] 监听事件
 */
fun TextView.addUrlTag(block: TagConfig.() -> Unit, onClickListener: () -> Unit): TextView = apply {
    val tagConfig = TagConfig(Type.URL)
    block(tagConfig)
    addTag(tagConfig, onClickListener)
}

/**
 * 添加自定义标签
 * @param [view] 标签View
 * @param [position] 标签显示位置
 * @param [align] 标签对齐方式
 * @param [marginLeft] 左边距
 * @param [marginRight] 右边距
 * @param [onClickListener] 点击事件
 */
@JvmOverloads
fun TextView.addTag(
    view: View,
    position: Int = 0,
    @Align align: Int = Align.CENTER,
    marginLeft: Int = 0,
    marginRight: Int = 0,
    onClickListener: (() -> Unit)? = null
): TextView = apply {
    verifyText(this)
    val builder = createSpannableStringBuilder(this, position)
    val newPosition = insertPlaceholder(builder, position)
    val imageSpan = CenterImageSpan(createDrawable(view)).apply {
        setAlign(align)
        setMarginHorizontal(marginLeft, marginRight)
    }
    builder.setSpan(
        imageSpan,
        newPosition,
        newPosition + TAG.length,
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
    )
    setClickListener(builder, newPosition, newPosition + TAG.length, onClickListener)
    text = builder
}

/**
 * 设置下划线
 * @param [underlineText] 需要添加下划线的文本,不传或者为空就全部文本添加下划线
 * @param [isFirst] 是否匹配第一个，true是，false匹配最后一个
 * @param [click] 点击事件
 */
@JvmOverloads
fun TextView.setUnderline(
    underlineText: String? = null,
    isFirst: Boolean = true,
    click: () -> Unit = {}
): TextView =
    apply {
        var startIndex: Int = 0
        var endIndex: Int = 0
        if (underlineText.isNullOrEmpty()) {
            endIndex = text.length
        } else {
            startIndex = if (isFirst) {
                text.indexOf(underlineText)
            } else {
                text.lastIndexOf(underlineText)
            }
            endIndex = startIndex + underlineText.length
        }
        setUnderline(startIndex, endIndex, click)
    }

/**
 * 设置下划线
 * @param [startIndex] 指定开始位置
 * @param [endIndex] 指定结束位置
 * @param [click] 点击事件
 */
@JvmOverloads
fun TextView.setUnderline(startIndex: Int, endIndex: Int, click: () -> Unit = {}): TextView =
    apply {
        if (verifyPosition(startIndex, endIndex)) {
            val builder = SpannableStringBuilder(text)
            builder.setSpan(UnderlineSpan(), startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

            movementMethod = ClickableMovementMethod.getInstance()
            builder.setSpan(ClickableSpan(currentTextColor, true).apply {
                onClick = click
            }, startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

            text = builder
        }
    }

/**
 * 设置文本删除线
 * @param [deleteLineText] 需要添加删除线的文本,不传或者为空就全部文本添加删除线
 * @param [isFirst] 是否匹配第一个，true是，false匹配最后一个
 * @param [color] 删除线文本颜色
 * @param [click] 点击事件
 */
@JvmOverloads
fun TextView.setDeleteLine(
    deleteLineText: String? = null,
    isFirst: Boolean = true,
    @ColorInt color: Int? = null,
    click: () -> Unit = {}
): TextView =
    apply {
        var startIndex: Int = 0
        var endIndex: Int = 0
        if (deleteLineText.isNullOrEmpty()) {
            endIndex = text.length
        } else {
            startIndex = if (isFirst) {
                text.indexOf(deleteLineText)
            } else {
                text.lastIndexOf(deleteLineText)
            }
            endIndex = startIndex + deleteLineText.length
        }
        setDeleteLine(startIndex, endIndex, color, click)
    }

/**
 * 设置文本删除线
 * @param [startIndex] 指定开始位置
 * @param [endIndex] 指定结束位置
 * @param [color] 删除线文本颜色
 * @param [click] 点击事件
 */
@JvmOverloads
fun TextView.setDeleteLine(
    startIndex: Int,
    endIndex: Int,
    @ColorInt color: Int? = null,
    click: () -> Unit = {}
): TextView = apply {
    if (verifyPosition(startIndex, endIndex)) {
        val builder = SpannableStringBuilder(text)
        builder.setSpan(StrikethroughSpan(), startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        movementMethod = ClickableMovementMethod.getInstance()
        builder.setSpan(ClickableSpan(color ?: currentTextColor, false).apply {
            onClick = click
        }, startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        text = builder
    }
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
fun TextView.setSpecificTextColor(
    @ColorInt color: Int,
    specificText: String,
    isFirst: Boolean = true,
    isUnderlineText: Boolean = false,
    click: () -> Unit = {}
): TextView = apply {
    var startIndex: Int = 0
    var endIndex: Int = 0
    if (specificText.isNullOrEmpty()) {
        endIndex = text.length
    } else {
        startIndex = if (isFirst) {
            text.indexOf(specificText)
        } else {
            text.lastIndexOf(specificText)
        }
        endIndex = startIndex + specificText.length
    }
    setSpecificTextColor(color, startIndex, endIndex, isUnderlineText, click)
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
fun TextView.setSpecificTextColor(
    @ColorInt color: Int,
    startIndex: Int,
    endIndex: Int,
    isUnderlineText: Boolean = false,
    click: () -> Unit = {}
): TextView = apply {
    if (verifyPosition(startIndex, endIndex)) {
        val builder = SpannableStringBuilder(text)
        movementMethod = ClickableMovementMethod.getInstance()
        builder.setSpan(ClickableSpan(color, isUnderlineText).apply {
            onClick = click
        }, startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        text = builder
    }
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
fun TextView.setURLSpan(
    startIndex: Int,
    endIndex: Int,
    type: LinkType,
    linkText: String,
    @ColorInt color: Int? = null,
    isUnderlineText: Boolean = false
): TextView = apply {
    val textLength = text.length
    if (textLength > 0 && verifyPosition(startIndex, endIndex)) {
        val builder = SpannableStringBuilder(text)
        movementMethod = ClickableMovementMethod.getInstance()
        val url = when (type) {
            LinkType.EMAIL -> "mailto:"
            LinkType.GEO -> "geo:"
            LinkType.HTTP -> ""
            LinkType.MMS -> "mms:"
            LinkType.SMS -> "sms:"
            LinkType.TEL -> "tel:"
        }
        builder.setSpan(
            URLSpan("$url${linkText}", color, isUnderlineText),
            startIndex,
            endIndex,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        text = builder
    }

}

/**
 * 创建SpannableStringBuilder
 * @param [textView] 文本组件
 * @param [position] 需要添加的下标
 */
private fun createSpannableStringBuilder(
    textView: TextView,
    position: Int
): SpannableStringBuilder {
    val textLength = textView.text.length
    if (position > textLength) {
        throw IndexOutOfBoundsException("下标越界，当前文字长度:$textLength,position:${position}")
    }
    return SpannableStringBuilder(textView.text)
}

/**
 * 插入占位符
 * @param [builder] SpannableStringBuilder
 * @param [position] 用户设置插入的位置，这个值根据具体情况需要重新调整
 * @return 新的position
 */
@JvmOverloads
private fun insertPlaceholder(
    builder: SpannableStringBuilder,
    position: Int,
    tag: String = TAG
): Int {
    val endIndex = builder.toString().length
    val spans = builder.getSpans(0, endIndex, ReplacementSpan::class.java)
    var newPosition = position
    spans.forEach {
        val startIndex = builder.getSpanStart(it)
        if (newPosition >= startIndex) {
            newPosition += tag.length
        }
    }
    builder.insert(newPosition, tag)
    return newPosition
}


/**
 * 创建Item的Span
 * @param [textView] 文本组件
 * @param [config] 配置参数
 */
private fun createSpan(textView: TextView, config: TagConfig): ReplacementSpan {
    val span = when (config.type) {
        Type.URL -> GlideImageSpan(
            textView, config.imageUrl ?: throw NullPointerException("当type=Type.URL时,必须设置imageUrl")
        ).apply { setDrawableSize(config.imageWidth, config.imageHeight) }
        Type.IMAGE -> {
            when {
                config.imageResource != null -> {
                    CenterImageSpan(textView.context, config.imageResource!!)
                }
                config.imageDrawable != null -> {
                    CenterImageSpan(config.imageDrawable!!)
                }
                config.imageBitmap != null -> {
                    CenterImageSpan(textView.context, config.imageBitmap!!)
                }
                else -> {
                    throw NullPointerException("当type=Type.IMAGE时，必须设置【imageResource】、【imageDrawable】、【imageBitmap】其中一项")
                }
            }.apply { setDrawableSize(config.imageWidth, config.imageHeight) }
        }
        else -> CenterImageSpan(
            createDrawable(
                createItemView(
                    textView.context,
                    config
                )
            )
        ).apply {
            mNormalSizeText = textView.text.toString()
            setDrawableSize(config.width, config.height)
        }
    }.apply {
        setAlign(config.align)
        setTextSize(textView.textSize.toInt())
        setDrawableZoomType(config.drawableZoomType)
        setMarginHorizontal(config.marginLeft, config.marginRight)
        setMarginVertical(config.marginTop, config.marginBottom)
    }
    return span
}

/**
 * 创建视图
 */
private fun createItemView(context: Context, config: TagConfig): View {
    val tagItemView = TagItemView(context).apply {
        setConfig(config)
    }
    //设置内边距
    tagItemView.setPadding(
        config.padding ?: config.leftPadding,
        config.padding ?: config.topPadding,
        config.padding ?: config.rightPadding,
        config.padding ?: config.bottomPadding
    )
    //圆角
    val cornerRadii = floatArrayOf(
        config?.radius ?: config.leftTopRadius, config?.radius ?: config.leftTopRadius,
        config?.radius ?: config.rightTopRadius, config?.radius ?: config.rightTopRadius,
        config?.radius ?: config.rightBottomRadius, config?.radius ?: config.rightBottomRadius,
        config?.radius ?: config.leftBottomRadius, config?.radius ?: config.leftBottomRadius
    )
    val gradientDrawable = GradientDrawable().apply {
        setCornerRadii(cornerRadii)
        this.colors =
            intArrayOf(
                config.startGradientBackgroundColor ?: config.backgroundColor,
                config.endGradientBackgroundColor ?: config.backgroundColor
            )
        if (config.strokeWidth > 0) {
            setStroke(config.strokeWidth, config.strokeColor)
        }
        orientation = config.gradientOrientation
    }
    tagItemView.background = gradientDrawable
    return tagItemView
}

/**
 * 把View转为Drawable
 */
private fun createDrawable(view: View): Drawable {
    val bitmap = view.convertViewToBitmap()
    return BitmapDrawable(Resources.getSystem(), bitmap).apply {
        setBounds(0, 0, view.width, view.height)
    }
}

/**
 * 校验文本，需要预先设置文本
 */
private fun verifyText(textView: TextView) {
    if (TextUtils.isEmpty(textView.text)) {
        throw NullPointerException("请优先设置TextView的text")
    }
}

/**
 * 校验位置
 * @param [startIndex] 开始下标
 * @param [endIndex] 结束下标
 * @return true 合格
 */
private fun TextView.verifyPosition(startIndex: Int, endIndex: Int): Boolean {
    return !(startIndex < 0 || endIndex <= startIndex || endIndex > text.length || startIndex >= text.length)
}

/**
 * 把View转化成Bitmap
 */
private fun View.convertViewToBitmap(): Bitmap {
    measure(
        View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
        View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
    )
    layout(0, 0, measuredWidth, measuredHeight)
    val bitmap =
        Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)
    draw(canvas)
    canvas.save()
    return bitmap
}

/**
 * 设置点击事件
 */
private fun TextView.setClickListener(
    builder: SpannableStringBuilder,
    startIndex: Int,
    endIndex: Int,
    onClickListener: (() -> Unit)?
) {
    if (onClickListener != null) {
        builder.setSpan(
            ClickableSpan(Color.TRANSPARENT).apply { onClick = onClickListener },
            startIndex,
            endIndex,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        movementMethod = LinkMovementMethod.getInstance()
    }
}


