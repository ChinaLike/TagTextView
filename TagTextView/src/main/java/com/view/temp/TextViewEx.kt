package com.view.temp

import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ReplacementSpan
import android.text.style.StrikethroughSpan
import android.text.style.UnderlineSpan
import android.view.View
import android.widget.TextView
import androidx.annotation.ColorInt
import com.view.temp.config.Align
import com.view.temp.config.LinkType
import com.view.temp.config.TagConfig
import com.view.temp.config.Type
import com.view.temp.movement.ClickableMovementMethod
import com.view.temp.span.CenterImageSpan
import com.view.temp.span.ClickableSpan
import com.view.temp.span.GlideImageSpan
import com.view.temp.span.URLSpan
import com.view.temp.view.TagItemView
import com.view.text.ex.convertViewToBitmap

/**
 * 插入占位标签
 */
private const val TAG: String = "T"

/**
 * 添加标签
 * @param [config] 标签配置
 */
fun TextView.addTag(config: TagConfig) {
    val builder = createSpannableStringBuilder(this, config.position)
    val newPosition = insertPlaceholder(builder, config.position)
    val imageSpan = createSpan(this, config)
    builder.setSpan(
        imageSpan,
        newPosition,
        newPosition + TAG.length,
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
    )
    text = builder
}

/**
 * 添加自定义标签
 * @param [view] 标签View
 * @param [position] 标签显示位置
 */
@JvmOverloads
fun TextView.addTag(
    view: View,
    position: Int = 0,
    align: Align = Align.CENTER,
    marginLeft: Int = 0,
    marginRight: Int = 0
) {
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
    text = builder
}

/**
 * 设置下划线
 * @param [underlineText] 需要添加下划线的文本,不传或者为空就全部文本添加下划线
 * @param [isFirst] 是否匹配第一个，true是，false匹配最后一个
 */
@JvmOverloads
fun TextView.setUnderline(underlineText: String? = null, isFirst: Boolean = true) {
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
    setUnderline(startIndex, endIndex)
}

/**
 * 设置下划线
 * @param [startIndex] 指定开始位置
 * @param [endIndex] 指定结束位置
 */
fun TextView.setUnderline(startIndex: Int, endIndex: Int) {
    if (startIndex < 0 || endIndex <= 0 || endIndex < startIndex) {
        return
    }
    val builder = SpannableStringBuilder(text)
    builder.setSpan(UnderlineSpan(), startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    text = builder
}

/**
 * 设置文本删除线
 * @param [deleteLineText] 需要添加删除线的文本,不传或者为空就全部文本添加删除线
 * @param [isFirst] 是否匹配第一个，true是，false匹配最后一个
 */
@JvmOverloads
fun TextView.setDeleteLine(deleteLineText: String? = null, isFirst: Boolean = true) {
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
    setDeleteLine(startIndex, endIndex)
}

/**
 * 设置文本删除线
 * @param [startIndex] 指定开始位置
 * @param [endIndex] 指定结束位置
 */
fun TextView.setDeleteLine(startIndex: Int, endIndex: Int) {
    if (startIndex < 0 || endIndex <= 0 || endIndex < startIndex) {
        return
    }
    val builder = SpannableStringBuilder(text)
    builder.setSpan(StrikethroughSpan(), startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    text = builder
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
) {
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
) {
    if (startIndex < 0 || endIndex <= 0 || endIndex < startIndex) {
        return
    }
    val builder = SpannableStringBuilder(text)
    movementMethod = ClickableMovementMethod.getInstance()
    builder.setSpan(ClickableSpan(color, isUnderlineText).apply {
        onClick = click
    }, startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    text = builder
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
) {
    if (startIndex < 0 || endIndex <= 0 || endIndex < startIndex) {
        return
    }
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
    builder.setSpan(URLSpan("$url${linkText}",color,isUnderlineText),startIndex,endIndex,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
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
private fun insertPlaceholder(builder: SpannableStringBuilder, position: Int): Int {
    val endIndex = builder.toString().length
    val spans = builder.getSpans(0, endIndex, ReplacementSpan::class.java)
    var newPosition = position
    spans.forEach {
        val startIndex = builder.getSpanStart(it)
        if (newPosition >= startIndex) {
            newPosition += TAG.length
        }
    }
    builder.insert(newPosition, TAG)
    return newPosition
}


/**
 * 创建Item的Span
 * @param [textView] 文本组件
 * @param [config] 配置参数
 */
private fun createSpan(textView: TextView, config: TagConfig): ReplacementSpan {
    return when (config.type) {
        Type.URL -> GlideImageSpan(
            textView,
            config.imageUrl ?: throw NullPointerException("当type=Type.URL时必须设置imageUrl")
        ).apply {
            setAlign(config.align)
            setDrawableSize(config.width ?: 0, config.height)
            setMarginHorizontal(config.marginLeft, config.marginRight)
        }
        else -> CenterImageSpan(createDrawable(createItemView(textView.context, config))).apply {
            setAlign(config.align)
            setMarginHorizontal(config.marginLeft, config.marginRight)
        }
    }
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
        config.leftPadding ?: config.padding,
        config.topPadding ?: config.padding,
        config.rightPadding ?: config.padding,
        config.bottomPadding ?: config.padding
    )
    //圆角
    val cornerRadii = floatArrayOf(
        config.leftTopRadius?.toFloat() ?: config.radius.toFloat(),
        config.leftTopRadius?.toFloat() ?: config.radius.toFloat(),
        config.rightTopRadius?.toFloat() ?: config.radius.toFloat(),
        config.rightTopRadius?.toFloat() ?: config.radius.toFloat(),
        config.rightBottomRadius?.toFloat() ?: config.radius.toFloat(),
        config.rightBottomRadius?.toFloat() ?: config.radius.toFloat(),
        config.leftBottomRadius?.toFloat() ?: config.radius.toFloat(),
        config.leftBottomRadius?.toFloat() ?: config.radius.toFloat()
    )
    val gradientDrawable = GradientDrawable().apply {
        this.cornerRadii = cornerRadii
        this.colors =
            intArrayOf(
                config.startGradientBackgroundColor ?: config.backgroundColor,
                config.endGradientBackgroundColor ?: config.backgroundColor
            )
        if (config.strokeWidth > 0) {
            setStroke(config.strokeWidth, config.strokeColor)
        }
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

