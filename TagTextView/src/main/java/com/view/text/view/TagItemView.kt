package com.view.text.view

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
import com.view.text.config.Orientation
import com.view.text.config.TagConfig
import com.view.text.config.Type

/**
 * 自定义Tag
 * @author like
 * @date 4/15/22 1:50 PM
 */
internal class TagItemView @JvmOverloads constructor(
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
    }

    /**
     * 设置配置参数控制视图
     */
    fun setConfig(config: TagConfig) {
        //设置图片在文字那个方向
        setOrientation(config.imageAlignText)
        //设置图片的大小
        setImageSize(config.imageWidth, config.imageHeight)
        when (config.type) {
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
    }

    /**
     * 设置文本
     */
    private fun setTextView(config: TagConfig) = with(textView) {
        text = config.text
        setTextColor(config.textColor)
        setTextSize(TypedValue.COMPLEX_UNIT_PX, config.textSize ?: textSize)
    }

    /**
     * 设置图片
     */
    private fun setImage(config: TagConfig) = with(imageView) {
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
    private fun setMargin(textMarginImage: Int) {
        showDividers = SHOW_DIVIDER_MIDDLE
        dividerDrawable = GradientDrawable().apply {
            this.setSize(textMarginImage, textMarginImage)
            this.setColor(Color.TRANSPARENT)
        }
    }

    /**
     * 设置图片在文字的方向
     */
    private fun setOrientation(orientation: Orientation) {
        when (orientation) {
            Orientation.LEFT -> {
                this.orientation = HORIZONTAL
                addView(imageView)
                addView(textView,LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT)
            }
            Orientation.TOP -> {
                this.orientation = VERTICAL
                addView(imageView)
                addView(textView,LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT)
            }
            Orientation.RIGHT -> {
                this.orientation = HORIZONTAL
                addView(textView,LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT)
                addView(imageView)
            }
            Orientation.BOTTOM -> {
                this.orientation = VERTICAL
                addView(textView,LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT)
                addView(imageView)
            }
        }
    }

    /**
     * 设置图片的大小
     */
    private fun setImageSize(imageWidth: Int?, imageHeight: Int?) {
        val layoutParams = LayoutParams(
            imageWidth ?: textView.textSize.toInt(),
            imageHeight ?: textView.textSize.toInt()
        )
        imageView.layoutParams = layoutParams
    }

}