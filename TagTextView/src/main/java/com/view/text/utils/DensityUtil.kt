package com.view.text.utils

import android.content.Context

/**
 * 单位转换
 * @author like
 * @date 4/25/21 6:08 PM
 */
object DensityUtil {

    fun dp2px(context: Context, dpValue: Float): Float {
        val scale = context.resources.displayMetrics.density
        return dpValue * scale + 0.5F
    }

    fun sp2px(context: Context, spValue: Float): Float {
        val scale = context.resources.displayMetrics.scaledDensity
        return spValue * scale + 0.5F
    }

}