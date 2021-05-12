package com.view.text.ex

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.text.*
import android.text.method.LinkMovementMethod
import android.text.style.*
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import com.view.text.adapter.BaseTagAdapter
import com.view.text.adapter.SimpleTagAdapter
import com.view.text.config.SpanConfig
import com.view.text.config.TagConfig
import com.view.text.config.URLSpanConfig
import com.view.text.constants.SpanType
import com.view.text.constants.TagLocation
import com.view.text.span.CenterImageSpan
import org.jetbrains.annotations.NotNull

/**
 * TextView 扩展方法
 * 设置字符串标签
 * @param [config] 标签配置
 * @param [tagText] 字符串
 */
fun TextView.setTextTag(config: TagConfig = TagConfig(), vararg tagText: String) {
    tagText?.let {
        setTextTag(config, it.toMutableList())
    }
}

/**
 * TextView 扩展方法
 * 设置图片标签
 * @param [config] 标签配置
 * @param [imageRes] 图片资源
 */
fun TextView.setTextTag(config: TagConfig = TagConfig(), @DrawableRes vararg imageRes: Int) {
    imageRes?.let {
        setTextTag(config, it.toMutableList())
    }
}

/**
 * TextView 扩展方法
 * 设置字符串标签
 * @param [config] 标签配置
 * @param [drawable] 图片Drawable
 */
fun TextView.setTextTag(config: TagConfig = TagConfig(), vararg drawable: Drawable) {
    drawable?.let {
        setTextTag(config, it.toMutableList())
    }
}

/**
 * TextView 扩展方法
 * 设置图片标签
 * @param [config] 标签配置
 * @param [bitmap] 图片Bitmap
 */
fun TextView.setTextTag(config: TagConfig = TagConfig(), vararg bitmap: Bitmap) {
    bitmap?.let {
        setTextTag(config, it.toMutableList())
    }
}

/**
 * TextView 扩展方法
 * 设置标签
 * @param [config] 标签配置
 * @param [dataList] 数据集合
 */
fun <T> TextView.setTextTag(config: TagConfig = TagConfig(), dataList: MutableList<T>) {
    if (dataList?.isNotEmpty()) {
        setTextTag(config, SimpleTagAdapter(context, dataList, config))
    }
}

/**
 * TextView 扩展方法
 * 自定义标签
 * @param [config] 标签配置
 * @param [adapter] 适配器
 */
fun <T> TextView.setTextTag(config: TagConfig = TagConfig(), adapter: BaseTagAdapter<T>) {
    val tags: MutableList<String> = mutableListOf()
    for (i in 0 until adapter.getItemCount()) {
        tags.add("$i")
    }
    text = createSpannableString(text.toString(), tags, config, adapter)
    gravity = Gravity.CENTER_VERTICAL
}

/**
 * 设置文本下划线
 * @param [underline] 需要添加下划线的文本
 */
fun TextView.setUnderline(underline: String) {
    val startIndex = text.indexOf(underline)
    if (startIndex >= 0) {
        val endIndex = startIndex + underline.length
        setUnderline(startIndex, endIndex)
    } else {
        throw NullPointerException("不存在[$underline]字符串")
    }
}

/**
 * 设置文本下划线
 * @param [startIndex] 开始下标
 * @param [endIndex] 结束下标
 */
fun TextView.setUnderline(startIndex: Int, endIndex: Int) {
    setUnderline(intArrayOf(startIndex, endIndex))
}

/**
 * 设置文本下划线
 * @param [indexRang] 下标范围
 */
fun TextView.setUnderline(vararg indexRang: IntArray) {
    val spannableString = SpannableString(text)
    indexRang?.forEach {
        if (it.size == 2 && it[0] >= 0 && it[0] <= text.length && it[1] > it[0] && it[1] <= text.length) {
            spannableString.setSpan(
                UnderlineSpan(),
                it[0],
                it[1],
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
    }
    text = spannableString
}

/**
 * 设置文本下划线
 */
fun TextView.setUnderline() {
    setUnderline(0, text.length)
}

/**
 * 设置文本删除线
 * @param [underline] 需要添加删除线的文本
 */
fun TextView.setDeleteLine(underline: String) {
    val startIndex = text.indexOf(underline)
    if (startIndex >= 0) {
        val endIndex = startIndex + underline.length
        setDeleteLine(startIndex, endIndex)
    }
}

/**
 * 设置文本删除线
 * @param [startIndex] 开始下标
 * @param [endIndex] 结束下标
 */
fun TextView.setDeleteLine(startIndex: Int, endIndex: Int) {
    setDeleteLine(intArrayOf(startIndex, endIndex))
}

/**
 * 设置文本删除线
 * @param [indexRang] 下标范围
 */
fun TextView.setDeleteLine(vararg indexRang: IntArray) {
    val spannableString = SpannableString(text)
    indexRang?.forEach {
        if (it.size == 2 && it[0] >= 0 && it[0] <= text.length && it[1] > it[0] && it[1] <= text.length) {
            spannableString.setSpan(
                StrikethroughSpan(),
                it[0],
                it[1],
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
    }
    text = spannableString
}

/**
 * 设置文本删除线
 */
fun TextView.setDeleteLine() {
    setDeleteLine(0, text.length)
}

/**
 * 设置指定文字颜色并点击
 * @param [color] 指定文本颜色
 * @param [specificText] 指定文本
 * @param [isUnderlineText] 是否显示下划线
 * @param [onClick] 点击事件
 */
fun TextView.setSpecificTextColor(
    @ColorInt color: Int,
    specificText: String,
    isUnderlineText: Boolean = false,
    onClick: (index: Int) -> Unit = {}
) {
    val startIndex = text.indexOf(specificText)
    if (startIndex >= 0) {
        val endIndex = startIndex + specificText.length
        setSpecificTextColor(color, startIndex, endIndex, isUnderlineText, onClick)
    }
}

/**
 * 设置指定文字颜色并点击
 * @param [color] 指定文本颜色
 * @param [startIndex] 开始下标
 * @param [endIndex] 结束下标
 * @param [isUnderlineText] 是否显示下划线
 * @param [onClick] 点击事件
 */
fun TextView.setSpecificTextColor(
    @ColorInt color: Int,
    startIndex: Int,
    endIndex: Int,
    isUnderlineText: Boolean = false,
    onClick: (index: Int) -> Unit = {}
) {
    setSpecificTextColor(
        mutableListOf(SpanConfig(startIndex, endIndex, color, isUnderlineText)),
        onClick
    )
}

/**
 * 设置指定文字颜色并点击
 * @param [data] 自定义文本样式
 * @param [onClick] 点击事件
 */
fun TextView.setSpecificTextColor(
    data: MutableList<SpanConfig>,
    onClick: (index: Int) -> Unit = {}
) {
    val spannableString = SpannableStringBuilder(text)
    movementMethod = LinkMovementMethod.getInstance()
    data?.indices.forEach { index ->
        val entity = data[index]
        if (entity.startIndex >= 0 && entity.startIndex <= text.length && entity.endIndex > entity.startIndex && entity.endIndex <= text.length) {
            spannableString.setSpan(
                ForegroundColorSpan(entity.color ?: Color.RED),
                entity.startIndex,
                entity.endIndex,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            spannableString.setSpan(object : ClickableSpan() {

                override fun onClick(widget: View) {
                    onClick(index)
                }

                override fun updateDrawState(ds: TextPaint) {
                    entity.color?.let {
                        ds.color = it
                    }
                    ds.isUnderlineText = entity.isUnderlineText
                    ds.clearShadowLayer()
                }

            }, entity.startIndex, entity.endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
    }
    text = spannableString
}

/**
 * 设置超链
 * @param [startIndex] 开始下标
 * @param [endIndex] 结束下标
 * @param [type] 跳转类型，参考[SpanType]
 * @param [linkText] 链接文本 ，比如跳转电话，只需要传入电话号码就可以
 * @param [color] 指定文本的颜色
 * @param [isUnderlineText] 是否显示下划线
 */
fun TextView.setURLSpan(
    startIndex: Int,
    endIndex: Int,
    type: SpanType,
    linkText: String,
    @ColorInt color: Int? = null,
    isUnderlineText: Boolean = false
) {
    setURLSpan(
        mutableListOf(
            URLSpanConfig(
                startIndex,
                endIndex,
                type,
                linkText,
                color,
                isUnderlineText
            )
        )
    )
}

/**
 * 设置超链
 * @param [data] 自定义数据
 */
fun TextView.setURLSpan(data: MutableList<URLSpanConfig>?) {
    movementMethod = LinkMovementMethod.getInstance()
    val spannableString = SpannableString(text)
    data?.forEach {
        if (it.startIndex >= 0 && it.startIndex <= text.length && it.endIndex > it.startIndex && it.endIndex <= text.length) {
            var typeText: String = when (it.type) {
                SpanType.EMAIL -> "mailto:"
                SpanType.GEO -> "geo:"
                SpanType.HTTP -> ""
                SpanType.MMS -> "mms:"
                SpanType.SMS -> "sms:"
                SpanType.TEL -> "tel:"
            }
            spannableString.setSpan(
                object : URLSpan("$typeText${it.linkText}") {
                    override fun updateDrawState(ds: TextPaint) {
                        super.updateDrawState(ds)
                        it.color?.let { color ->
                            ds.color = color
                        }
                        ds.isUnderlineText = it.isUnderlineText
                    }
                },
                it.startIndex,
                it.endIndex,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
    }
    text = spannableString
}


private fun createSpannableString(
    text: String?,
    tags: MutableList<String>,
    config: TagConfig,
    @NotNull adapter: BaseTagAdapter<*>
): SpannableString {
    val spannableString = SpannableString(createStringBuffer(text, tags, config))

    for (index in tags.indices) {
        val item = tags[index]
        val view: View = adapter.convert(index)
        val leftSpace =
            if (index == 0) if (config.tagLocation == TagLocation.START) config.firstTagLeftSpace else config.textSpace else 0
        val rightSpace =
            if (index == tags.size - 1) if (config.tagLocation == TagLocation.START) config.textSpace else 0 else config.tagSpace
        val rootView = LinearLayout(adapter.context).apply {
            this.setPadding(leftSpace, 0, rightSpace, 0)
            this.addView(view)
        }
        val drawable: Drawable = BitmapDrawable(rootView.convertViewToBitmap()).apply {
            setBounds(0, 0, rootView.width, rootView.height)
        }
        val imageSpan = CenterImageSpan(drawable, ImageSpan.ALIGN_BASELINE)
        var startIndex = getLastLength(tags, index, config, text ?: "")
        var endIndex = startIndex + item.length
        spannableString.setSpan(
            imageSpan,
            startIndex,
            endIndex,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }

    return spannableString
}

/**
 * 虚拟标签字符串
 */
private fun createStringBuffer(
    text: String?,
    tags: MutableList<String>,
    config: TagConfig
): StringBuffer {
    val contentBuffer = StringBuffer()
    if (config.tagLocation == TagLocation.END) {
        //结束显示
        contentBuffer.append("$text")
        tags?.forEach { contentBuffer.append(it) }
    } else {
        //开始显示
        tags?.forEach { contentBuffer.append(it) }
        contentBuffer.append("$text")
    }
    return contentBuffer
}

private fun getLastLength(
    tags: List<String>,
    maxLength: Int,
    config: TagConfig,
    text: String
): Int {
    var length = if (config.tagLocation == TagLocation.START) 0 else text.length
    for (i in 0 until maxLength) {
        length += tags[i].length
    }
    return length
}