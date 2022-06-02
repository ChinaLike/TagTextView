package com.like.tag

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.core.util.dp
import com.core.util.sp
import com.view.text.*
import com.view.text.config.*
import kotlinx.android.synthetic.main.layout_ex_function.*
import kotlinx.android.synthetic.main.layout_image_style.*
import kotlinx.android.synthetic.main.layout_recycler_view.*
import kotlinx.android.synthetic.main.layout_text_image_style.*
import kotlinx.android.synthetic.main.layout_text_style.*
import kotlinx.android.synthetic.main.layout_url_style.*
import kotlinx.android.synthetic.main.layout_xml.*

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
        //在XML使用
        xmlStyle()
        //扩展方法
        exFun()
        //列表中的使用
        recyclerViewStyle()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.custom_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.javaBtn) {
            startActivity(Intent(this, JavaActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
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
        text_tv12.addTextTag {
            text = "新品"
            startGradientBackgroundColor = Color.parseColor("#F0E68C")
            endGradientBackgroundColor = Color.parseColor("#FFD700")
        }
        text_tv12.addTextTag {
            text = "精品"
            startGradientBackgroundColor = Color.parseColor("#FFA07A")
            endGradientBackgroundColor = Color.parseColor("#FF0040")
            strokeWidth = 1.dp
            marginLeft = 5.dp
            strokeColor = Color.parseColor("#228B22")
        }
        text_tv12.addTextTag {
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

        //1.13 支持自定义View
        val view = LayoutInflater.from(this).inflate(R.layout.custom_text_view, null)
        text_tv13.addTag(view, position = 5)

        //1.14 替换指定字符串为标签形式
        text_tv14.replaceTag("超级快充", TagConfig(Type.TEXT).apply {
            text = "超级快充"
            startGradientBackgroundColor = Color.parseColor("#ABDCFF")
            endGradientBackgroundColor = Color.parseColor("#0396FF")
            radius = 5.dp.toFloat()
        }).replaceTag(40,48, TagConfig(Type.TEXT).apply {
            text = "移动5G"
            startGradientBackgroundColor = Color.parseColor("#FEC163")
            endGradientBackgroundColor = Color.parseColor("#DE4313")
            marginLeft = 20.dp
        }).replaceTag("荣耀", LayoutInflater.from(this).inflate(R.layout.custom_tag_view,null))
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
        image_tv6.addImageTag {
            imageResource = R.mipmap.icon_new1
        }
        image_tv6.addImageTag {
            imageResource = R.mipmap.icon_new2
            position = 5
        }
        image_tv6.addImageTag {
            imageResource = R.mipmap.icon_new3
            position = 11
        }
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
        text_image_tv6.addTextImageTag {
            imageResource = R.mipmap.icon_3
            text = "支持钱包支付"
            position = 11
            startGradientBackgroundColor = Color.parseColor("#FFA07A")
            endGradientBackgroundColor = Color.parseColor("#FF0040")
            textMarginImage = 10.dp
        }.addTextImageTag {
            imageResource = R.mipmap.icon_1
            text = "钻石会员"
            position = 5
            startGradientBackgroundColor = Color.parseColor("#FFA07A")
            endGradientBackgroundColor = Color.parseColor("#FF0040")
            textMarginImage = 4.dp
        }
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
            imageUrl = "https://i.postimg.cc/VvNYQSHk/20180317074635221.png"
            position = 5
        }
        url_tv4.addTag(tv4Config)

        //4.5 支持多个
        url_tv5.addUrlTag {
            imageUrl = "https://i.postimg.cc/28pNrtMf/20140710033452506.png"
            marginLeft = 20.dp
            marginRight = 10.dp
        }.addUrlTag {
            imageUrl = "https://i.postimg.cc/5ydL218z/20130513035745587.gif"
            position = 5
            width = 40.dp
            height = 50.dp
        }
    }

    /**
     * 5.在XML中使用
     */
    private fun xmlStyle() {
        //5.5 只使用View，标签在代码设置
        xml_tv5.addTag(TagConfig(Type.TEXT).apply {
            text = "新品"
            startGradientBackgroundColor = Color.parseColor("#CE9FFC")
            endGradientBackgroundColor = Color.parseColor("#7367F0")
            radius = 10.dp.toFloat()
        })

    }

    /**
     * 扩展方法使用
     */
    private fun exFun() {

        //设置下划线
        ex_tv1.setUnderline("荣耀V40轻奢版")//指定字符串，且默认匹配第一个
        ex_tv1.setUnderline("5G", false)//指定字符串，且默认匹配最后一个
        ex_tv1.setUnderline(17,26){
            Toast.makeText(this, "17至26下标文字被点击", Toast.LENGTH_SHORT).show()
        }
        ex_tv1.setUnderline(27,30){
            Toast.makeText(this, "27至30文字下标被点击", Toast.LENGTH_SHORT).show()
        }
        ex_tv1.setUnderline(31,39,object :OnTagClickListener{
            override fun onClick() {
                Toast.makeText(this@MainActivity, "31至39文字下标被点击", Toast.LENGTH_SHORT).show()
            }
        })

        //设置删除线
        ex_tv2.setDeleteLine("荣耀V40轻奢版")//指定字符串，且默认匹配第一个
        ex_tv2.setDeleteLine("5G", false)//指定字符串，且默认匹配最后一个
        ex_tv2.setDeleteLine(17, 26)
        ex_tv2.setDeleteLine(27, 36,Color.RED){
            Toast.makeText(this, "27至36文字下标被点击", Toast.LENGTH_SHORT).show()
        }
        ex_tv2.setDeleteLine("双卡双待手机",false,Color.BLUE){
            Toast.makeText(this, "双卡双待手机", Toast.LENGTH_SHORT).show()
        }

        ex_tv2.setDeleteLine(40,44,Color.GREEN,object :OnTagClickListener{
            override fun onClick() {
                Toast.makeText(this@MainActivity, "40至44文字下标被点击", Toast.LENGTH_SHORT).show()
            }
        })

        //指定文本颜色
        ex_tv3.setSpecificTextColor(Color.parseColor("#FF0040"), "荣耀V40轻奢版")//指定字符串，且默认匹配第一个
        ex_tv3.setSpecificTextColor(Color.parseColor("#3813C2"), "5G", false)//指定字符串，且默认匹配最后一个
        ex_tv3.setSpecificTextColor(Color.parseColor("#FFC600"), "移动联通电信") {
            Toast.makeText(this, "移动联通电信被点击", Toast.LENGTH_SHORT).show()
        }//指定文本，可响应点击事件
        ex_tv3.setSpecificTextColor(Color.parseColor("#4C83FF"), 12, 16) {
            Toast.makeText(this, "超级快充被点击", Toast.LENGTH_SHORT).show()
        }//指定下标，可响应点击事件
        ex_tv3.setSpecificTextColor(
            Color.parseColor("#C346C2"),
            "双卡双待",
            true,
            true,
            object : OnTagClickListener {
                override fun onClick() {
                    Toast.makeText(this@MainActivity, "双卡双待被点击", Toast.LENGTH_SHORT).show()
                }
            }) //指定文本，并设置下划线，可响应点击事件


        //设置超链
        ex_tv4.text = "电话链接-邮箱链接-网络链接-短信链接-彩信链接-地图链接"
        ex_tv4.setURLSpan(0, 4, LinkType.TEL, "10086", Color.parseColor("#FF0040"))//电话链接
        ex_tv4.setURLSpan(
            5,
            9,
            LinkType.EMAIL,
            "10086@mail.com",
            Color.parseColor("#3813C2"),
            true
        )//邮件链接
        ex_tv4.setURLSpan(
            10,
            14,
            LinkType.HTTP,
            "http://baidu.com",
            Color.parseColor("#C346C2"),
            true
        )//网络连接
        ex_tv4.setURLSpan(15, 19, LinkType.SMS, "10086", Color.parseColor("#4C83FF"), false)//短信链接
        ex_tv4.setURLSpan(20, 24, LinkType.MMS, "10086", Color.parseColor("#58CFFB"), true)//彩信链接
        ex_tv4.setURLSpan(
            ex_tv4.text.length - 4,
            ex_tv4.text.length,
            LinkType.GEO,
            "10086",
            Color.parseColor("#49C628"),
            true
        )//地图链接

    }

    /**
     * 列表
     */
    private fun recyclerViewStyle() {
        recyclerView.adapter = TestAdapter(this, getData())
    }

    private fun getData(): MutableList<ItemBean> {
        val list: MutableList<ItemBean> = mutableListOf()

        list.add(
            ItemBean(
                "HUAWEI nova 8 SE 6400万高清四摄 支持66W超级快充 6.5英寸OLED大屏 8GB+128GB幻夜黑华为手机 标配无充",
                "https://img14.360buyimg.com/n0/jfs/t1/112159/2/24025/88731/625ed1f3E0c9e092d/bc0200a21ea5ab66.jpg",
                TagConfig(Type.TEXT).apply {
                    text = "新品"
                    backgroundColor = Color.parseColor("#FA742B")
                })
        )

        list.add(
            ItemBean(
                "华为智选 NZone s7pro 5G手机 【S7 Pro+】星空蓝8+128GB 官方标配",
                "https://img14.360buyimg.com/n0/jfs/t1/144481/18/22264/36775/61ac564cEb081b02c/67f89db3846cbb59.jpg"
            )
        )

        list.add(
            ItemBean(
                "华为智选 NZone s7pro 5G手机 【S7 Pro+】星空蓝8+128GB 官方标配",
                "https://img14.360buyimg.com/n0/jfs/t1/147378/17/24994/68806/623c09b8E25d4d8d6/c98c30744541e85d.jpg",
                TagConfig(Type.TEXT_IMAGE).apply {
                    text = "钻石用户"
                    imageResource = R.mipmap.icon_1
                    backgroundColor = Color.parseColor("#FA742B")
                })
        )

        list.add(
            ItemBean(
                "华为智选 NZone s7pro 5G手机 【S7 Pro+】星空蓝8+128GB 官方标配",
                "https://img14.360buyimg.com/n0/jfs/t1/204262/20/17633/41667/61ac564bEef77131c/4f64d67793fde772.jpg"
            )
        )

        list.add(
            ItemBean(
                "华为nova8se 麒麟710A芯片 搭载HarmonyOS系统 幻夜黑 8GB+128GB（66W充电套装+耳机套装）",
                "https://img14.360buyimg.com/n0/jfs/t1/132208/19/27529/193053/625d4efdEc356624c/ccf19294cd5ae141.jpg",
                TagConfig(Type.IMAGE).apply {
                    imageResource = R.mipmap.icon_3
                    imageWidth = 20.dp
                    imageHeight = 20.dp
                    marginRight = 20.dp
                })
        )

        list.add(
            ItemBean(
                "华为nova8se 麒麟710A芯片 搭载HarmonyOS系统 幻夜黑 8GB+128GB（66W充电套装+耳机套装）",
                "https://img14.360buyimg.com/n0/jfs/t1/112159/2/24025/88731/625ed1f3E0c9e092d/bc0200a21ea5ab66.jpg",
                TagConfig(Type.TEXT).apply {
                    text = "新品"
                    startGradientBackgroundColor = Color.parseColor("#F6D242")
                    endGradientBackgroundColor = Color.parseColor("#FF52E5")
                    radius = 5.dp.toFloat()
                })
        )


        return list
    }

}