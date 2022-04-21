package com.like.tag

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.core.util.dp
import com.core.util.sp
import com.view.text.addTag
import com.view.text.config.Align
import com.view.text.config.Orientation
import com.view.text.config.TagConfig
import com.view.text.config.Type
import kotlinx.android.synthetic.main.layout_image_style.*
import kotlinx.android.synthetic.main.layout_text_image_style.*
import kotlinx.android.synthetic.main.layout_text_style.*
import kotlinx.android.synthetic.main.layout_url_style.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //文本
        textStyle()
        //图片
        imageStyle()
        //图文
        textImageStyle()
        //网络图片
        urlStyle()
    }

    /**
     * 1. 文本标签样式(type=Type.TEXT)
     */
    private fun textStyle() {
        //1.1 默认样式
        val tv1Config = TagConfig(Type.TEXT).apply {
            text = "新品"
        }
        text_tv1.addTag(tv1Config)

        //1.2 自定义背景颜色
        val tv2Config = TagConfig(Type.TEXT).apply {
            text = "新品"
            rightPadding = 5.dp
            leftPadding = 5.dp
            backgroundColor = Color.parseColor("#FF0040")
        }
        text_tv2.addTag(tv2Config)

        //1.3 自定义圆角
        val tv3Config = TagConfig(Type.TEXT).apply {
            text = "新品"
            leftPadding = 15.dp
            rightPadding = 15.dp
            leftTopRadius = 99.dp.toFloat()
            rightBottomRadius = 99.dp.toFloat()
            backgroundColor = Color.parseColor("#FFB800")
        }
        text_tv3.addTag(tv3Config)

        //1.4 自定义内边距
        val tv4Config = TagConfig(Type.TEXT).apply {
            text = "新品"
            leftPadding = 15.dp
            rightPadding = 15.dp
            radius = 2.dp.toFloat()
            backgroundColor = Color.parseColor("#00BFFF")
        }
        text_tv4.addTag(tv4Config)


        //1.5 自定义边框
        val tv5Config = TagConfig(Type.TEXT).apply {
            text = "新品"
            leftPadding = 10.dp
            rightPadding = 10.dp
            strokeWidth = 1.dp
            strokeColor = Color.parseColor("#FF0040")
            textColor = Color.parseColor("#FF0040")
            backgroundColor = Color.parseColor("#FFA07A")
        }
        text_tv5.addTag(tv5Config)

        //1.6 自定义外边距
        val tv6Config = TagConfig(Type.TEXT).apply {
            text = "新品"
            padding = 10.dp
            marginLeft = 20.dp
            marginRight = 10.dp
            backgroundColor = Color.parseColor("#32CD32")
        }
        text_tv6.addTag(tv6Config)

        //1.7 自定义显示位置
        val tv7Config = TagConfig(Type.TEXT).apply {
            text = "新品"
            leftPadding = 10.dp
            rightPadding = 10.dp
            leftTopRadius = 0.dp.toFloat()
            leftBottomRadius = 0.dp.toFloat()
            rightTopRadius = 99.dp.toFloat()
            rightBottomRadius = 99.dp.toFloat()
            marginLeft = 10.dp
            marginRight = 10.dp
            backgroundColor = Color.parseColor("#FF1493")
            position = 5
        }
        text_tv7.addTag(tv7Config)

        //1.8 固定标签大小
        val tv8Config = TagConfig(Type.TEXT).apply {
            text = "新品"
            width = 20.dp
            height = 10.dp
            backgroundColor = Color.parseColor("#40E0D0")
        }
        text_tv8.addTag(tv8Config)

        //1.9 渐变标签
        val tv9Config = TagConfig(Type.TEXT).apply {
            text = "新品"
            startGradientBackgroundColor = Color.parseColor("#FFA07A")
            endGradientBackgroundColor = Color.parseColor("#FF0040")
        }
        text_tv9.addTag(tv9Config)

        //1.10 对其方式,底部对其
        val tv10Config = TagConfig(Type.TEXT).apply {
            text = "新品"
            align = Align.BOTTOM
            height = 50.dp
            width = 70.dp
            startGradientBackgroundColor = Color.parseColor("#FFA07A")
            endGradientBackgroundColor = Color.parseColor("#FF0040")
        }
        text_tv10.addTag(tv10Config)


        //1.11 设置文本样式
        val tv11Config = TagConfig(Type.TEXT).apply {
            text = "新品"
            textColor = Color.parseColor("#40E0D0")
            textSize = 20.sp.toFloat()
            startGradientBackgroundColor = Color.parseColor("#FFA07A")
            endGradientBackgroundColor = Color.parseColor("#FF0040")
        }
        text_tv11.addTag(tv11Config)

        //1.12 添加多个文本标签
        val tv12Config = TagConfig(Type.TEXT).apply {
            text = "新品"
            startGradientBackgroundColor = Color.parseColor("#F0E68C")
            endGradientBackgroundColor = Color.parseColor("#FFD700")
        }
        val tv12Config1 = TagConfig(Type.TEXT).apply {
            text = "精品"
            startGradientBackgroundColor = Color.parseColor("#FFA07A")
            endGradientBackgroundColor = Color.parseColor("#FF0040")
            strokeWidth = 1.dp
            marginLeft = 5.dp
            strokeColor = Color.parseColor("#228B22")
        }
        val tv12Config2 = TagConfig(Type.TEXT).apply {
            text = "限时销售"
            startGradientBackgroundColor = Color.parseColor("#87CEFA")
            endGradientBackgroundColor = Color.parseColor("#00BFFF")
            strokeWidth = 1.dp
            strokeColor = Color.parseColor("#FF4500")
            textColor = Color.parseColor("#FF4500")
            textSize = 10.sp.toFloat()
            marginLeft = 10.dp
            marginRight = 5.dp
            leftPadding = 10.dp
            rightPadding = 10.dp
            topPadding = 5.dp
            bottomPadding = 5.dp
            leftTopRadius = 5.dp.toFloat()
            leftBottomRadius = 10.dp.toFloat()
            rightTopRadius = 2.dp.toFloat()
            rightBottomRadius = 5.dp.toFloat()
            position = 6
        }
        text_tv12.addTag(tv12Config)
        text_tv12.addTag(tv12Config1)
        text_tv12.addTag(tv12Config2)
    }

    /**
     * 2.图片标签样式(type=Type.IMAGE)
     */
    private fun imageStyle() {
        //2.1 默认样式
        val tv1Config = TagConfig(Type.IMAGE).apply {
            imageResource = R.mipmap.icon_new1
        }
        image_tv1.addTag(tv1Config)

        //2.2 自定义大小
        val tv2Config = TagConfig(Type.IMAGE).apply {
            imageResource = R.mipmap.icon_new2
            width = 80.dp
            height = 40.dp
        }
        image_tv2.addTag(tv2Config)

        //2.3 自定义边距
        val tv3Config = TagConfig(Type.IMAGE).apply {
            imageResource = R.mipmap.icon_new3
            marginLeft = 15.dp
            marginRight = 10.dp
        }
        image_tv3.addTag(tv3Config)

        //2.4 自定义对其方式,底部对其
        val tv4Config = TagConfig(Type.IMAGE).apply {
            imageResource = R.mipmap.icon_new1
            height = 50.dp
            width = 100.dp
            align = Align.BOTTOM
        }
        image_tv4.addTag(tv4Config)

        //2.5 自定义位置
        val tv5Config = TagConfig(Type.IMAGE).apply {
            imageResource = R.mipmap.icon_new3
            position = 5
        }
        image_tv5.addTag(tv5Config)

        //2.6 支持多个图片
        val tv6Config = TagConfig(Type.IMAGE).apply {
            imageResource = R.mipmap.icon_new1
        }
        val tv6Config1 = TagConfig(Type.IMAGE).apply {
            imageResource = R.mipmap.icon_new2
            position = 5
        }
        val tv6Config2 = TagConfig(Type.IMAGE).apply {
            imageResource = R.mipmap.icon_new3
            position = 11
        }
        image_tv6.addTag(tv6Config)
        image_tv6.addTag(tv6Config1)
        image_tv6.addTag(tv6Config2)
    }

    /**
     * 3.文本+图片 标签样式(type=Type.TEXT_IMAGE)
     */
    private fun textImageStyle() {
        //3.1 默认样式
        val tv1Config = TagConfig(Type.TEXT_IMAGE).apply {
            imageResource = R.mipmap.icon_1
            text = "钻石会员"
        }
        text_image_tv1.addTag(tv1Config)

        //3.2 设置图片在文字的那个方向
        val tv2Config = TagConfig(Type.TEXT_IMAGE).apply {
            imageResource = R.mipmap.icon_3
            text = "支持钱包支付"
            imageAlignText = Orientation.TOP
            textMarginImage = 10.dp
            imageWidth = 40.dp
            imageHeight = 40.dp
            startGradientBackgroundColor = Color.parseColor("#FFA07A")
            endGradientBackgroundColor = Color.parseColor("#FF0040")
        }
        text_image_tv2.addTag(tv2Config)

        //3.3 设置图片大小
        val tv3Config = TagConfig(Type.TEXT_IMAGE).apply {
            imageResource = R.mipmap.icon_4
            text = "支持触控"
            imageWidth = 10.dp
            imageHeight = 10.dp
            radius = 5.dp.toFloat()
            startGradientBackgroundColor = Color.parseColor("#87CEFA")
            endGradientBackgroundColor = Color.parseColor("#00BFFF")
            textColor = Color.parseColor("#FF0040")
            textSize = 12.sp.toFloat()
            marginRight = 10.dp
        }
        text_image_tv3.addTag(tv3Config)

        //3.4 设置图片和文字的距离
        val tv4Config = TagConfig(Type.TEXT_IMAGE).apply {
            imageResource = R.mipmap.icon_3
            text = "支持钱包支付"
            startGradientBackgroundColor = Color.parseColor("#FFA07A")
            endGradientBackgroundColor = Color.parseColor("#FF0040")
            textMarginImage = 10.dp
        }
        text_image_tv4.addTag(tv4Config)

        //3.5 自定义显示位置
        val tv5Config = TagConfig(Type.TEXT_IMAGE).apply {
            imageResource = R.mipmap.icon_5
            text = "绑定"
            position = text_image_tv5.text.length
            startGradientBackgroundColor = Color.parseColor("#FFA07A")
            endGradientBackgroundColor = Color.parseColor("#FF0040")
            textMarginImage = 4.dp
        }
        text_image_tv5.addTag(tv5Config)

        //3.6 支持多个
        val tv6Config = TagConfig(Type.TEXT_IMAGE).apply {
            imageResource = R.mipmap.icon_3
            text = "支持钱包支付"
            position = 11
            startGradientBackgroundColor = Color.parseColor("#FFA07A")
            endGradientBackgroundColor = Color.parseColor("#FF0040")
            textMarginImage = 10.dp
        }
        val tv6Config1 = TagConfig(Type.TEXT_IMAGE).apply {
            imageResource = R.mipmap.icon_1
            text = "钻石会员"
            position = 5
            startGradientBackgroundColor = Color.parseColor("#FFA07A")
            endGradientBackgroundColor = Color.parseColor("#FF0040")
            textMarginImage = 4.dp
        }
        text_image_tv6.addTag(tv6Config)
        text_image_tv6.addTag(tv6Config1)
    }

    /**
     * 4.网络标签样式(type=Type.URL)
     */
    private fun urlStyle() {
        //4.1 默认样式
        val tv1Config = TagConfig(Type.URL).apply {
            imageUrl = "https://i.postimg.cc/DyjsBr3v/image.png"
        }
        url_tv1.addTag(tv1Config)

        //4.2 自定义大小
        val tv2Config = TagConfig(Type.URL).apply {
            imageUrl = "https://i.postimg.cc/KjjS4SFZ/20130527035844363.png"
            width = 50.dp
            height = 50.dp
        }
        url_tv2.addTag(tv2Config)

        //4.3 支持GIF
        val tv3Config = TagConfig(Type.URL).apply {
            imageUrl = "https://i.postimg.cc/1XNYV9gr/20150723102349987.gif"
        }
        url_tv3.addTag(tv3Config)

        //4.4 自定义位置
        val tv4Config = TagConfig(Type.URL).apply {
            imageUrl = "https://i.postimg.cc/DyjsBr3v/image.png"
            position = 5
        }
        url_tv4.addTag(tv4Config)

        //4.5 支持多个
        val tv5Config = TagConfig(Type.URL).apply {
            imageUrl = "https://i.postimg.cc/28pNrtMf/20140710033452506.png"
            marginLeft = 20.dp
            marginRight = 10.dp
        }
        val tv5Config1 = TagConfig(Type.URL).apply {
            imageUrl = "https://i.postimg.cc/5ydL218z/20130513035745587.gif"
            position = 5
            width = 40.dp
            height = 50.dp
        }
        url_tv5.addTag(tv5Config)
        url_tv5.addTag(tv5Config1)
    }

}