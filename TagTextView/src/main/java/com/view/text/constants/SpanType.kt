package com.view.text.constants

/**
 * Span的类型
 * @author like
 * @date 4/27/21 11:13 AM
 */
sealed class SpanType{

    /**
     * 电话
     */
    object TEL:SpanType()

    /**
     * 邮件
     */
    object EMAIL:SpanType()

    /**
     * 网络地址
     */
    object HTTP:SpanType()

    /**
     * 短信
     */
    object SMS:SpanType()

    /**
     * 彩信
     */
    object MMS:SpanType()

    /**
     * 地图
     */
    object GEO:SpanType()
}
