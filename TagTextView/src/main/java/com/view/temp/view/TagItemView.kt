package com.view.temp.view

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.view.temp.config.TagConfig
import com.view.temp.config.Type

/**
 * 自定义Tag
 * @author like
 * @date 4/15/22 1:50 PM
 */
class TagItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    /**
     * 图片
     */
    private val imageView: AppCompatImageView by lazy { AppCompatImageView(context) }

    /**
     * 文字
     */
    private val textView: AppCompatTextView by lazy { AppCompatTextView(context) }

    init {
        gravity = Gravity.CENTER
        orientation = HORIZONTAL
        addView(imageView)
        addView(textView)
    }

    /**
     * 设置配置参数控制视图
     */
    fun setConfig(config: TagConfig) = when (config.type) {
        Type.TEXT -> {
            textView.visibility = View.VISIBLE
            imageView.visibility = View.GONE
            setTextView(config)
        }
        Type.TEXT_IMAGE -> {
            textView.visibility = View.VISIBLE
            imageView.visibility = View.VISIBLE
            setImage(config)
            setTextView(config)
            setMargin(config.textMarginImage)
        }
        Type.IMAGE -> {
            textView.visibility = View.GONE
            imageView.visibility = View.VISIBLE
            setImage(config)
        }
        else -> {
            throw IllegalArgumentException("${TagItemView::class.java.simpleName}不支持此类型")
        }
    }

    /**
     * 设置文本
     */
    private fun setTextView(config: TagConfig) = with(textView) {
        text = config.text
        setTextColor(config.textColor)
        setTextSize(TypedValue.COMPLEX_UNIT_SP, config.textSize)
    }

    /**
     * 设置图片
     */
    private fun setImage(config: TagConfig) = with(imageView){
        when {
            config.imageResource != null -> {
                setImageResource(config.imageResource!!)
            }
            config.imageDrawable != null -> {
                setImageDrawable(config.imageDrawable)
            }
            config.imageBitmap != null -> {
                setImageBitmap(config.imageBitmap)
            }
        }
    }

    /**
     * 设置文本距离图片的距离
     */
    private fun setMargin(textMarginImage:Int){
        showDividers = SHOW_DIVIDER_MIDDLE
        dividerDrawable = GradientDrawable().apply {
            this.setSize(textMarginImage,0)
            this.setColor(Color.TRANSPARENT)
        }
    }

}