package com.view.text.config

/**
 * 超链类型
 * @author like
 * @date 4/16/22 4:47 PM
 */
sealed class LinkType {
    /**
     * 电话
     */
    object TEL : LinkType()

    /**
     * 邮件
     */
    object EMAIL : LinkType()

    /**
     * 网络地址
     */
    object HTTP : LinkType()

    /**
     * 短信
     */
    object SMS : LinkType()

    /**
     * 彩信
     */
    object MMS : LinkType()

    /**
     * 地图
     */
    object GEO : LinkType()
}
