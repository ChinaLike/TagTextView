package com.view.text.annotation

import androidx.annotation.IntDef

/**
 * 标签对齐方式
 * @author like
 * @date 4/15/22 11:18 AM
 */
@MustBeDocumented
@IntDef(Align.BASELINE, Align.CENTER, Align.BOTTOM, Align.TOP)
@Retention(AnnotationRetention.SOURCE)
annotation class Align {

    companion object {
        /**
         * 基线对齐
         */
        const val BASELINE: Int = 0

        /**
         * 中心对齐
         */
        const val CENTER: Int = 1

        /**
         * 底部对齐
         */
        const val BOTTOM: Int = 2

        /**
         * 顶部对齐
         */
        const val TOP: Int = 3

    }
}