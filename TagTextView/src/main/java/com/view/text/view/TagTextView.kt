package com.view.text.view

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import com.view.text.R
import com.view.text.addTag
import com.view.text.config.Align
import com.view.text.config.Orientation
import com.view.text.config.TagConfig
import com.view.text.config.Type

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
            var align: Align = config?.align ?: Align.CENTER
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
                        val alignValue = getInt(attr, -1)
                        if (alignValue != -1) {
                            when (alignValue) {
                                Align.BASELINE.ordinal -> {
                                    align = Align.BASELINE
                                }
                                Align.CENTER.ordinal -> {
                                    align = Align.CENTER
                                }
                                Align.BOTTOM.ordinal -> {
                                    align = Align.BOTTOM
                                }
                            }
                        }
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

}