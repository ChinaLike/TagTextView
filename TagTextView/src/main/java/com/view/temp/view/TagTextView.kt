package com.view.temp.view

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.core.util.DensityUtil
import com.view.temp.config.TagConfig
import com.view.temp.config.Type
import com.view.text.R

/**
 * 自定义标签文本
 * @author like
 * @date 4/15/22 1:56 PM
 */
class TagTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    private var config: TagConfig? = null

    init {
        attrs?.apply(::init)
    }

    /**
     *         <attr name="tvtRadius" format="dimension"/>
    <attr name="tvtLeftTopRadius" format="dimension" />
    <attr name="tvtLeftBottomRadius" format="dimension" />
    <attr name="tvtRightTopRadius" format="dimension" />
    <attr name="tvtRightBottomRadius" format="dimension" />
    <attr name="tvtPadding" format="dimension"/>
    <attr name="tvtTopPadding" format="dimension" />
    <attr name="tvtRightPadding" format="dimension" />
    <attr name="tvtBottomPadding" format="dimension" />
    <attr name="tvtLeftPadding" format="dimension" />
    <attr name="tvtBackgroundColor" format="color" />
    <attr name="tvtStartGradientBackgroundColor" format="color"/>
    <attr name="tvtEndGradientBackgroundColor" format="color"/>
    <attr name="tvtStrokeWidth" format="dimension" />
    <attr name="tvtStrokeColor" format="color"/>
    <attr name="tvtTextSize" format="dimension"/>
    <attr name="tvtTextColor" format="color"/>
    <attr name="tvtWidth" format="dimension"/>
    <attr name="tvtHeight" format="dimension"/>
    <attr name="tvtAlign" format="enum">
    <enum name="BASELINE" value="0"/>
    <enum name="CENTER" value="1"/>
    <enum name="BOTTOM" value="2"/>
    </attr>
    <attr name="tvtText" format="string"/>
    <attr name="tvtImageResource" format="reference"/>
    <attr name="tvtPosition" format="integer"/>
    <attr name="tvtMarginLeft" format="dimension"/>
    <attr name="tvtMarginRight" format="dimension"/>
    <attr name="tvtTextMarginImage" format="dimension"/>
     */

    private fun init(attrs: AttributeSet) =
        with(context.obtainStyledAttributes(attrs, R.styleable.TagTextView1)) {
            val type = getInt(R.styleable.TagTextView1_tvtType, -1)
            config = when (type) {
                Type.TEXT.ordinal -> TagConfig(Type.TEXT)
                Type.IMAGE.ordinal -> TagConfig(Type.IMAGE)
                Type.TEXT_IMAGE.ordinal -> TagConfig(Type.TEXT)
                Type.URL.ordinal -> TagConfig(Type.URL)
                else -> null
            }
            if (config == null) {
                throw NullPointerException("必选在XML中设置tvtType属性")
            }

            for (i in 0 until indexCount) {
                when (val attr = getIndex(i)) {
                    R.styleable.TagTextView1_tvtRadius -> {
                        config?.radius = getDimension(attr, config?.radius?.toFloat() ?: 0F).toInt()
                    }
                    R.styleable.TagTextView1_tvtLeftTopRadius -> {
                        config?.leftTopRadius = getDimension(attr, 0F).toInt()
                    }
                    R.styleable.TagTextView1_tvtLeftBottomRadius -> {
                        config?.leftBottomRadius = getDimension(attr, 0F).toInt()
                    }
                    R.styleable.TagTextView1_tvtRightTopRadius -> {
                        config?.rightTopRadius = getDimension(attr, 0F).toInt()
                    }
                    R.styleable.TagTextView1_tvtRightBottomRadius -> {
                        config?.rightBottomRadius = getDimension(attr, 0F).toInt()
                    }
                    R.styleable.TagTextView1_tvtPadding -> {
                        config?.padding = getDimension(attr, 0F).toInt()
                    }
                    R.styleable.TagTextView1_tvtTopPadding -> {
                        config?.topPadding = getDimension(attr, 0F).toInt()
                    }
                    R.styleable.TagTextView1_tvtRightPadding -> {
                        config?.rightPadding = getDimension(attr, 0F).toInt()
                    }
                    R.styleable.TagTextView1_tvtBottomPadding -> {
                        config?.bottomPadding = getDimension(attr, 0F).toInt()
                    }
                    R.styleable.TagTextView1_tvtLeftPadding -> {
                        config?.leftPadding = getDimension(attr, 0F).toInt()
                    }
                    R.styleable.TagTextView1_tvtBackgroundColor -> {
                        config?.backgroundColor = getColor(attr, Color.TRANSPARENT)
                    }
                    R.styleable.TagTextView1_tvtStartGradientBackgroundColor -> {
                        config?.startGradientBackgroundColor = getColor(attr, Color.TRANSPARENT)
                    }
                    R.styleable.TagTextView1_tvtEndGradientBackgroundColor -> {
                        config?.endGradientBackgroundColor = getColor(attr, Color.TRANSPARENT)
                    }
                    R.styleable.TagTextView1_tvtStrokeWidth -> {
                        config?.strokeWidth = getDimension(attr, 0F).toInt()
                    }
                    R.styleable.TagTextView1_tvtStrokeColor -> {
                        config?.strokeColor = getColor(attr, Color.GRAY)
                    }
                    R.styleable.TagTextView1_tvtTextSize -> {
                        val textSize = getDimension(attr, 0F)
                        if (textSize != 0F) {
                            config?.textSize = DensityUtil.px2sp(textSize).toFloat()
                        }
                    }
                    R.styleable.TagTextView1_tvtTextColor -> {
                        config?.textColor = getColor(attr, Color.GRAY)
                    }
                    R.styleable.TagTextView1_tvtWidth -> {
                        config?.width = getDimension(attr, 0F).toInt()
                    }
                    R.styleable.TagTextView1_tvtHeight -> {
                        config?.height = getDimension(attr, 0F).toInt()
                    }
                    R.styleable.TagTextView1_tvtAlign -> {
                        val align = getInt(attr,-1)
                        if (align != -1){
                            
                        }
                        config?.align = getDimension(attr, 0F).toInt()
                    }
                    R.styleable.TagTextView1_tvtText -> {
                        config?.text = getString(attr)?:""
                    }
                    R.styleable.TagTextView1_tvtImageResource -> {
                        config?.imageDrawable = getDrawable(attr)
                    }
                    R.styleable.TagTextView1_tvtImageUrl -> {
                        config?.imageUrl = getString(attr)
                    }
                    R.styleable.TagTextView1_tvtPosition -> {
                        config?.position = getInt(attr, 0)
                    }
                    R.styleable.TagTextView1_tvtMarginLeft -> {
                        config?.marginLeft = getDimension(attr, 0F).toInt()
                    }
                    R.styleable.TagTextView1_tvtMarginRight -> {
                        config?.marginRight = getDimension(attr, 0F).toInt()
                    }
                    R.styleable.TagTextView1_tvtTextMarginImage -> {
                        config?.textMarginImage = getDimension(attr, 0F).toInt()
                    }
                }
            }
            recycle()
        }

}