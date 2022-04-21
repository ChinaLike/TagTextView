package com.view.text.view

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import com.core.util.DensityUtil
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
            val type = getInt(R.styleable.TagTextView_tvtType, -1)
            config = when (type) {
                Type.TEXT.ordinal -> TagConfig(Type.TEXT)
                Type.IMAGE.ordinal -> TagConfig(Type.IMAGE)
                Type.TEXT_IMAGE.ordinal -> TagConfig(Type.TEXT)
                Type.URL.ordinal -> TagConfig(Type.URL)
                else -> null
            }

            var position: Int = config?.position ?: 0
            var align: Align = config?.align ?: Align.CENTER
            var marginLeft: Int = config?.marginLeft ?: 0
            var marginRight: Int = config?.marginRight ?: 0

            for (i in 0 until indexCount) {
                when (val attr = getIndex(i)) {
                    R.styleable.TagTextView_tvtRadius -> {
                        config?.radius = getDimension(attr, 0F)
                    }
                    R.styleable.TagTextView_tvtLeftTopRadius -> {
                        config?.leftTopRadius = getDimension(attr, 0F)
                    }
                    R.styleable.TagTextView_tvtLeftBottomRadius -> {
                        config?.leftBottomRadius = getDimension(attr, 0F)
                    }
                    R.styleable.TagTextView_tvtRightTopRadius -> {
                        config?.rightTopRadius = getDimension(attr, 0F)
                    }
                    R.styleable.TagTextView_tvtRightBottomRadius -> {
                        config?.rightBottomRadius = getDimension(attr, 0F)
                    }
                    R.styleable.TagTextView_tvtPadding -> {
                        config?.padding = getDimension(attr, 0F).toInt()
                    }
                    R.styleable.TagTextView_tvtTopPadding -> {
                        config?.topPadding = getDimension(attr, 0F).toInt()
                    }
                    R.styleable.TagTextView_tvtRightPadding -> {
                        config?.rightPadding = getDimension(attr, 0F).toInt()
                    }
                    R.styleable.TagTextView_tvtBottomPadding -> {
                        config?.bottomPadding = getDimension(attr, 0F).toInt()
                    }
                    R.styleable.TagTextView_tvtLeftPadding -> {
                        config?.leftPadding = getDimension(attr, 0F).toInt()
                    }
                    R.styleable.TagTextView_tvtBackgroundColor -> {
                        config?.backgroundColor = getColor(attr, Color.TRANSPARENT)
                    }
                    R.styleable.TagTextView_tvtStartGradientBackgroundColor -> {
                        config?.startGradientBackgroundColor = getColor(attr, Color.TRANSPARENT)
                    }
                    R.styleable.TagTextView_tvtEndGradientBackgroundColor -> {
                        config?.endGradientBackgroundColor = getColor(attr, Color.TRANSPARENT)
                    }
                    R.styleable.TagTextView_tvtStrokeWidth -> {
                        config?.strokeWidth = getDimension(attr, 0F).toInt()
                    }
                    R.styleable.TagTextView_tvtStrokeColor -> {
                        config?.strokeColor = getColor(attr, Color.GRAY)
                    }
                    R.styleable.TagTextView_tvtTextSize -> {
                        val textSize = getDimension(attr, 0F)
                        if (textSize != 0F) {
                            config?.textSize = textSize
                        }
                    }
                    R.styleable.TagTextView_tvtTextColor -> {
                        config?.textColor = getColor(attr, Color.GRAY)
                    }
                    R.styleable.TagTextView_tvtWidth -> {
                        config?.width = getDimension(attr, 0F).toInt()
                    }
                    R.styleable.TagTextView_tvtHeight -> {
                        config?.height = getDimension(attr, 0F).toInt()
                    }
                    R.styleable.TagTextView_tvtAlign -> {
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
                    R.styleable.TagTextView_tvtText -> {
                        config?.text = getString(attr) ?: ""
                    }
                    R.styleable.TagTextView_tvtImageResource -> {
                        config?.imageDrawable = getDrawable(attr)
                    }
                    R.styleable.TagTextView_tvtImageUrl -> {
                        config?.imageUrl = getString(attr)
                    }
                    R.styleable.TagTextView_tvtPosition -> {
                        position = getInt(attr, 0)
                        config?.position = position
                    }
                    R.styleable.TagTextView_tvtMarginLeft -> {
                        marginLeft = getDimension(attr, 0F).toInt()
                        config?.marginLeft = marginLeft
                    }
                    R.styleable.TagTextView_tvtMarginRight -> {
                        marginRight = getDimension(attr, 0F).toInt()
                        config?.marginRight = marginRight
                    }
                    R.styleable.TagTextView_tvtTextMarginImage -> {
                        config?.textMarginImage = getDimension(attr, 0F).toInt()
                    }
                    R.styleable.TagTextView_tvtLayout -> {
                        val resourceId = getResourceId(attr, 0)
                        if (resourceId != 0) {
                            customLayout = inflate(context, resourceId, null)
                        }
                    }
                    R.styleable.TagTextView_tvtImageAlignText -> {
                        val imageAlignText = getInt(attr, Orientation.LEFT.ordinal)
                        config?.imageAlignText = when (imageAlignText) {
                            Orientation.TOP.ordinal -> Orientation.TOP
                            Orientation.RIGHT.ordinal -> Orientation.RIGHT
                            Orientation.BOTTOM.ordinal -> Orientation.BOTTOM
                            else -> Orientation.LEFT
                        }
                    }
                    R.styleable.TagTextView_tvtImageWidth -> {
                        config?.imageWidth = getDimension(
                            attr,
                            ViewGroup.LayoutParams.WRAP_CONTENT.toFloat()
                        ).toInt()
                    }
                    R.styleable.TagTextView_tvtImageHeight -> {
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