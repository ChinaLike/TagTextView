package com.view.text.annotation

import androidx.annotation.IntDef

/**
 * 缩放类型
 * @author like
 * @date 2022/10/8 16:42
 */
@MustBeDocumented
@IntDef(DrawableZoomType.TEXT, DrawableZoomType.ORIGINAL, DrawableZoomType.CUSTOM)
@Retention(AnnotationRetention.SOURCE)
annotation class DrawableZoomType {

    companion object {

        /**
         * 原始大小
         */
        const val ORIGINAL: Int = 0

        /**
         * 匹配文字大小
         */
        const val TEXT: Int = -1

        /**
         * 自定义大小
         */
        const val CUSTOM: Int = 1

    }

}
