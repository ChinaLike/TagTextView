package com.view.text.adapter

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.view.text.config.TagConfig
import com.view.text.ex.setBackgroundAndRadius
import com.view.text.ex.setGradientBackgroundAndRadius

/**
 * 简单文本标签适配
 * @author like
 * @date 4/25/21 1:41 PM
 */
class SimpleTagAdapter<T>(
    context: Context,
    data: MutableList<T>,
    private val config: TagConfig = TagConfig()
) : BaseTagAdapter<T>(context, data) {
    /**
     * 自定义Item样式
     */
    override fun convert(position: Int): View {
        var view = View(context)

        when (val item = data[position]) {
            is String -> {
                view = LinearLayout(context).apply {
                    this.orientation = LinearLayout.VERTICAL
                    this.gravity = Gravity.CENTER
                    this.setPadding(
                        config.tagLeftPadding ?: config.tagPadding,
                        config.tagTopPadding ?: config.tagPadding,
                        config.tagRightPadding ?: config.tagPadding,
                        config.tagBottomPadding ?: config.tagPadding
                    )

                    //圆角
                    val cornerRadii = floatArrayOf(
                        config.leftTopRadius ?: config.radius,
                        config.leftTopRadius ?: config.radius,
                        config.rightTopRadius ?: config.radius,
                        config.rightTopRadius ?: config.radius,
                        config.rightBottomRadius ?: config.radius,
                        config.rightBottomRadius ?: config.radius,
                        config.leftBottomRadius ?: config.radius,
                        config.leftBottomRadius ?: config.radius
                    )
                    if (config.tagStartBackgroundColor != null && config.tagEndBackgroundColor != null) {
                        setGradientBackgroundAndRadius(
                            intArrayOf(
                                config.tagStartBackgroundColor!!,
                                config.tagEndBackgroundColor!!
                            ), cornerRadii
                        )
                    } else {
                        setBackgroundAndRadius(config.tagBackgroundColor, cornerRadii)
                    }

                    this.addView(AppCompatTextView(context).apply {
                        this.text = "$item"
                        this.setTextColor(config.tagTextColor)
                        this.setTextSize(
                            TypedValue.COMPLEX_UNIT_PX,
                            config.tagTextSize ?: textSize
                        )
                    })
                }
            }
            is Int -> {
                view = AppCompatImageView(context).apply {
                    this.setImageResource(item)
                }
            }
            is Bitmap -> {
                view = AppCompatImageView(context).apply {
                    this.setImageBitmap(item)
                }
            }
            is Drawable -> {
                view = AppCompatImageView(context).apply {
                    this.setImageDrawable(item)
                }
            }
        }
        return view.apply {
            layoutParams = ViewGroup.LayoutParams(config.tagWidth?:ViewGroup.LayoutParams.WRAP_CONTENT,config.tagHeight?:ViewGroup.LayoutParams.WRAP_CONTENT)
        }
    }
}