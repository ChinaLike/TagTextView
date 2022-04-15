package com.like.tag

import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.core.util.DensityUtil
import com.view.text.OnTagClickListener
import com.view.text.TagTextView
import com.view.text.adapter.BaseTagAdapter
import com.view.text.config.SpanConfig
import com.view.text.config.TagConfig
import com.view.text.config.URLSpanConfig
import com.view.text.constants.SpanType
import com.view.text.constants.TagLocation
import com.view.text.ex.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //简单标签，支持一个字符串（默认）
        findViewById<TagTextView>(R.id.simpleTagTextView).apply {
            text = "荣耀V40轻奢版 5G 超级快充 6400万超清四摄 8GB+128GB钛空银 移动联通电信5G 双卡双待手机"
            setTextTag("新品")
            setOnClickListener {
                Toast.makeText(this@MainActivity,"文本本点击",Toast.LENGTH_SHORT).show()
            }
        }
        //简单标签，支持一个字符串（自定义内边距）
        findViewById<TagTextView>(R.id.customSimpleTagTextView).apply {
            tagLeftPadding = DensityUtil.dp2px(this@MainActivity, 15F).toInt()
            tagRightPadding = DensityUtil.dp2px(this@MainActivity, 15F).toInt()
            tagTopPadding = DensityUtil.dp2px(this@MainActivity, 1F).toInt()
            tagBottomPadding = DensityUtil.dp2px(this@MainActivity, 1F).toInt()
            tagBackgroundColor = Color.parseColor("#FF0040")
            text = "荣耀V40轻奢版 5G 超级快充 6400万超清四摄 8GB+128GB钛空银 移动联通电信5G 双卡双待手机"
            setTextTag("新品")
        }
        //简单标签，支持一个字符串（自定义圆角）
        findViewById<TagTextView>(R.id.tagTextView2).apply {
            tagLeftPadding = DensityUtil.dp2px(this@MainActivity, 15F).toInt()
            tagRightPadding = DensityUtil.dp2px(this@MainActivity, 15F).toInt()
            tagTopPadding = DensityUtil.dp2px(this@MainActivity, 1F).toInt()
            tagBottomPadding = DensityUtil.dp2px(this@MainActivity, 1F).toInt()
            leftBottomRadius = DensityUtil.dp2px(this@MainActivity, 15F).toFloat()
            rightTopRadius = DensityUtil.dp2px(this@MainActivity, 15F).toFloat()
            tagBackgroundColor = Color.parseColor("#FFB800")
            text = "荣耀V40轻奢版 5G 超级快充 6400万超清四摄 8GB+128GB钛空银 移动联通电信5G 双卡双待手机"
            setTextTag("新品")
        }

        //简单标签，支持2个及以上字符串（方式1 默认）
        findViewById<TagTextView>(R.id.tagTextView3).apply {
            text = "荣耀V40轻奢版 5G 超级快充 6400万超清四摄 8GB+128GB钛空银 移动联通电信5G 双卡双待手机"
            setTextTag("新品", "精品")
        }

        //简单标签，支持2个及以上字符串（方式2 默认）
        findViewById<TagTextView>(R.id.tagTextView4).apply {
            text = "荣耀V40轻奢版 5G 超级快充 6400万超清四摄 8GB+128GB钛空银 移动联通电信5G 双卡双待手机"
            setTextTag(mutableListOf("新品", "店家推荐", "精选"))
        }

        //简单标签，设置Item间的间距
        findViewById<TagTextView>(R.id.tagTextView5).apply {
            tagSpace = DensityUtil.dp2px(this@MainActivity, 10F).toInt()
            text = "荣耀V40轻奢版 5G 超级快充 6400万超清四摄 8GB+128GB钛空银 移动联通电信5G 双卡双待手机"
            setTextTag(mutableListOf("新品", "店家推荐", "精选"))
        }

        //简单标签，设置文字与Item的间距
        findViewById<TagTextView>(R.id.tagTextView6).apply {
            textSpace = DensityUtil.dp2px(this@MainActivity, 5F).toInt()
            text = "荣耀V40轻奢版 5G 超级快充 6400万超清四摄 8GB+128GB钛空银 移动联通电信5G 双卡双待手机"
            setTextTag(mutableListOf("新品", "精选"))
        }

        //简单标签，自定义属性
        findViewById<TagTextView>(R.id.tagTextView7).apply {
            tagSpace = DensityUtil.dp2px(this@MainActivity, 10F).toInt()
            textSpace = DensityUtil.dp2px(this@MainActivity, 5F).toInt()
            radius = DensityUtil.dp2px(this@MainActivity, 2F).toFloat()
            tagPadding = DensityUtil.dp2px(this@MainActivity, 5F).toInt()
            setTextColor(Color.parseColor("#FF6718"))
            text = "荣耀V40轻奢版 5G 超级快充 6400万超清四摄 8GB+128GB钛空银 移动联通电信5G 双卡双待手机"
            setTextTag("优选", "新上市", "推荐")
        }
        //布局中设置样式
        findViewById<TagTextView>(R.id.tagTextView8).apply {
            setTextTag("新品", "黄金", "心悦")
        }

        //渐变背景
        findViewById<TagTextView>(R.id.tagTextView9).apply {
            tagStartBackgroundColor = Color.parseColor("#84D21D")
            tagEndBackgroundColor = Color.parseColor("#269E00")
            text = "荣耀V40轻奢版 5G 超级快充 6400万超清四摄 8GB+128GB钛空银 移动联通电信5G 双卡双待手机"
            setTextTag("优选", "新上市", "推荐")
        }

        //自定义标签
        val data: MutableList<String> = mutableListOf("", "圆角标签", "有边框标签", "渐变标签", "自定义圆角")

        val customTagTextView = findViewById<TagTextView>(R.id.customTagTextView).apply {
            tagSpace = DensityUtil.dp2px(this@MainActivity, 5F).toInt()
            textSpace = DensityUtil.dp2px(this@MainActivity, 10F).toInt()
            text = "荣耀V40轻奢版 5G 超级快充 6400万超清四摄 8GB+128GB钛空银 移动联通电信5G 双卡双待手机"
            setTextTag(
                object : BaseTagAdapter<String>(this@MainActivity, data) {
                    /**
                     * 自定义Item样式
                     */
                    override fun convert(position: Int): View {
                        var view: View = View(context)
                        when (position) {
                            0 -> {
                                view = AppCompatImageView(context).apply {
                                    setImageResource(R.mipmap.notice)
                                }
                            }
                            1 -> {
                                view = LayoutInflater.from(context).inflate(
                                    R.layout.adapter_custom_tag,
                                    null
                                )
                                view.findViewById<LinearLayout>(R.id.rootView).apply {
                                    this.setBackgroundResource(R.drawable.radius_fill_bg)
                                }
                                view.findViewById<AppCompatTextView>(R.id.tagText).apply {
                                    text = "${data[position]}"
                                    setTextColor(Color.RED)
                                    setTextSize(
                                        TypedValue.COMPLEX_UNIT_PX,
                                        DensityUtil.sp2px(this@MainActivity, 10F).toFloat()
                                    )
                                }
                            }
                            2 -> {
                                view = LayoutInflater.from(context).inflate(
                                    R.layout.adapter_custom_tag,
                                    null
                                )
                                view.findViewById<AppCompatTextView>(R.id.tagText).apply {
                                    text = "${data[position]}"
                                }
                            }
                            3 -> {
                                view = LayoutInflater.from(context).inflate(
                                    R.layout.adapter_custom_tag,
                                    null
                                )
                                view.findViewById<LinearLayout>(R.id.rootView).apply {
                                    this.setBackgroundResource(R.drawable.gra_bg)
                                }
                                view.findViewById<AppCompatTextView>(R.id.tagText).apply {
                                    text = "${data[position]}"
                                }
                            }
                            4 -> {
                                view = LayoutInflater.from(context).inflate(
                                    R.layout.adapter_custom_tag,
                                    null
                                )
                                view.findViewById<LinearLayout>(R.id.rootView).apply {
                                    this.setBackgroundResource(R.drawable.custom_radius)

                                }
                                view.findViewById<AppCompatTextView>(R.id.tagText).apply {
                                    text = "${data[position]}"
                                }
                            }
                        }
                        return view
                    }

                }
            )
        }

        //标签显示在文本后面
        findViewById<TagTextView>(R.id.tagTextView10).apply {
            tagLocation = TagLocation.END
            tagSpace = DensityUtil.dp2px(this@MainActivity, 5F).toInt()
            textSpace = DensityUtil.dp2px(this@MainActivity, 40F).toInt()
            //设置也无效
            firstTagLeftSpace = DensityUtil.dp2px(this@MainActivity, 1000F).toInt()
            tagStartBackgroundColor = Color.parseColor("#84D21D")
            tagEndBackgroundColor = Color.parseColor("#269E00")
            text = "荣耀V40轻奢版 5G 超级快充万超清四摄钛空银 移动联通电信5G 双卡双待手机"
            setTextTag("新品", "黄金", "心悦")
        }

        //设置单个图片
        findViewById<TagTextView>(R.id.tagTextView13).apply {
            tagSpace = DensityUtil.dp2px(this@MainActivity, 100F).toInt()
            text = "荣耀V40轻奢版 5G 超级快充 6400万超清四摄 8GB+128GB钛空银 移动联通电信5G 双卡双待手机"
            setTextTag(R.mipmap.icon_new1)
        }

        //设置多个图片
        findViewById<TagTextView>(R.id.tagTextView14).apply {
            tagSpace = DensityUtil.dp2px(this@MainActivity, 10F).toInt()
            text = "荣耀V40轻奢版 5G 超级快充 6400万超清四摄 8GB+128GB钛空银 移动联通电信5G 双卡双待手机"
            setTextTag(R.mipmap.icon_new1, R.mipmap.icon_new2, R.mipmap.icon_new3)
        }

        //不使用TagTextView
        findViewById<AppCompatTextView>(R.id.tagTextView15).apply {
            text = "荣耀V40轻奢版 5G 超级快充 6400万超清四摄 8GB+128GB钛空银 移动联通电信5G 双卡双待手机"
            setTextTag(TagConfig().apply {
                tagStartBackgroundColor = Color.parseColor("#FF0000")
                tagEndBackgroundColor = Color.parseColor("#00FF00")
                radius = DensityUtil.dp2px(this@MainActivity,2F).toFloat()
            }, "新品")
        }

        //下划线
        findViewById<AppCompatTextView>(R.id.tagTextView17).apply {
            setUnderline()
        }

        //删除线
        findViewById<AppCompatTextView>(R.id.tagTextView19).apply {
            setDeleteLine()
        }
        //设置制定文本颜色和点击响应
        findViewById<AppCompatTextView>(R.id.tagTextView20).apply {
            setSpecificTextColor(mutableListOf(SpanConfig(0,2), SpanConfig(17,26,Color.GREEN,true)),object :OnTagClickListener{
                /**
                 * 被点击Tag 响应，-1 表示文本被点击了
                 * @param [tagIndex] 指定文本点击的下标
                 */
                override fun onTagClick(tagIndex: Int) {
                    if (tagIndex == -1){
                        Toast.makeText(this@MainActivity,"文本本点击",Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this@MainActivity,"第${tagIndex}被点击",Toast.LENGTH_SHORT).show()
                    }
                }

            })
        }

        //设置超链
        findViewById<AppCompatTextView>(R.id.tagTextView21).apply {
//            setURLSpan(0,11,SpanType.TEL,"15934345454",Color.RED)
            setURLSpan(mutableListOf(URLSpanConfig(0,11,SpanType.TEL,"12345"),URLSpanConfig(12,15,SpanType.HTTP,"http://www.baidu.com",Color.GREEN,true)))
        }
    }
}