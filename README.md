# TagTextView 

[![](https://img.shields.io/badge/platform-android-brightgreen.svg)](https://developer.android.com/index.html)  [![API](https://img.shields.io/badge/API-14%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=14)  [![](https://jitpack.io/v/ChinaLike/TagTextView.svg)](https://jitpack.io/#ChinaLike/TagTextView)  [![Gradle-4.1.2](https://img.shields.io/badge/Gradle-4.1.2-brightgreen.svg)](https://img.shields.io/badge/Gradle-4.1.2-brightgreen.svg)  [![](https://img.shields.io/badge/language-kotlin-brightgreen.svg)](https://kotlinlang.org/)

SDK主要用于在TextView的指定位置添加文本、图片、图文、网络标签,基本能满足大多数APP的开发，对于比较复杂的标签还可以添加自定义View来实现，SDK中包含了给文本添加下划线、删除线、标记文本颜色、超链等扩展方法。

![image](https://github.com/ChinaLike/TagTextView/blob/main/screenshots/screenshot.jpg)

## API特色

+ 支持在文本的任意位置添加各种不同标签
+ 支持网络标签
+ 支持自定义布局文件
+ 支持指定文本点击响应
+ 支持下划线
+ 支持删除线
+ 支持超链

## 如何使用

> Step 1.先在 build.gradle(Project:XXX) 的 repositories 添加:

	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
> Step 2. 然后在 build.gradle(Module:XXX) 的 dependencies 添加:

	dependencies {
           implementation 'com.github.ChinaLike:TagTextView:0.1.0'
           // 如果支持网络图片标签，需要添加Glide库
           //implementation "com.github.bumptech.glide:glide:4.11.0"
	}
	
> Step 3. 如果支持网络标签，需要在`AndroidManifest.xml`中添加:

    ```
        <uses-permission android:name="android.permission.INTERNET" />
    ```
	
详细使用请参照[Wiki](https://github.com/ChinaLike/TagTextView/wiki/TagTextView%E4%BD%BF%E7%94%A8%E6%96%87%E6%A1%A3#%E7%A4%BA%E4%BE%8B%E4%BB%8B%E7%BB%8D)

## API说明

### XML属性

| <div style="width:200pt">API</div>    | <div style="width:200pt">类型</div>      | <div style="width:200pt">默认值</div>           | <div style="width:200pt">描述</div>                 | <div style="width:200pt">版本说明</div> | <div style="width:500pt">说明</div>   ｜                                                                                                                       |
|---------------------------------------|-----------|------------------|----------------------|----------|-------------------------------------------------------------------------------------------------------------------------------|
| `tvt_type`                            | enum      |                  | 标签类型             |          | text-文本标签，image-图片标签，textImage-图文                                                                                 |
| `tvt_radius`                          | dimension |                  | 标签圆角             |          | `tvt_type`为text、textImage时有效                                                                                             |
| `tvt_left_top_radius`                 | dimension | 2dp              | 标签左上角圆角       |          | `tvt_type`为text、textImage，且`tvt_radius`未设置有效                                                                         |
| `tvt_left_bottom_radius`              | dimension | 2dp              | 标签左下角圆角       |          | `tvt_type`为text、textImage，且`tvt_radius`未设置有效                                                                         |
| `tvt_right_top_radius`                | dimension | 2dp              | 标签右上角圆角       |          | `tvt_type`为text、textImage，且`tvt_radius`未设置有效                                                                         |
| `tvt_right_bottom_radius`             | dimension | 2dp              | 标签右下角圆角       |          | `tvt_type`为text、textImage，且`tvt_radius`未设置有效                                                                         |
| `tvt_padding`                         | dimension |                  | 标签内边距           |          | `tvt_type`为text、textImage时有效                                                                                             |
| `tvt_top_padding`                     | dimension | 0dp              | 标签上内边距         |          | `tvt_type`为text、textImage，且`tvt_padding`未设置有效                                                                        |
| `tvt_right_padding`                   | dimension | 5dp              | 标签右内边距         |          | `tvt_type`为text、textImage，且`tvt_padding`未设置有效                                                                        |
| `tvt_bottom_padding`                  | dimension | 0dp              | 标签下内边距         |          | `tvt_type`为text、textImage，且`tvt_padding`未设置有效                                                                        |
| `tvt_left_padding`                    | dimension | 5dp              | 标签左内边距         |          | `tvt_type`为text、textImage，且`tvt_padding`未设置有效                                                                        |
| `tvt_background_color`                | color     | Color.GRAY       | 标签背景颜色         |          | `tvt_type`为text、textImage时有效                                                                                             |
| `tvt_start_gradient_background_color` | color     |                  | 标签渐变开始颜色     |          | `tvt_type`为text、textImage时有效                                                                                             |
| `tvt_end_gradient_background_color`   | color     |                  | 标签渐变结束颜色     |          | `tvt_type`为text、textImage时有效                                                                                             |
| `tvt_stroke_width`                    | dimension |                  | 标签边框宽度         |          | `tvt_type`为text、textImage时有效                                                                                             |
| `tvt_stroke_color`                    | color     | Color.GRAY       | 标签边框颜色         |          | `tvt_type`为text、textImage，且`tvt_stroke_width`>0有效                                                                       |
| `tvt_text_size`                       | dimension |                  | 文本字体大小         |          | `tvt_type`为text、textImage有效                                                                                               |
| `tvt_text_color`                      | color     | Color.WHITE      | 文本字体颜色         |          | `tvt_type`为text、textImage有效                                                                                               |
| `tvt_width`                           | dimension |                  | 标签宽度             |          | `tvt_type`为text、textImage有效                                                                                               |
| `tvt_height`                          | dimension |                  | 标签高度             |          | `tvt_type`为text、textImage有效                                                                                               |
| `tvt_align`                           | enum      | Align.CENTER     | 标签与文本对其方式   |          | baseline-基线对其，center-中心对其，bottom-底部对其                                                                           |
| `tvt_text`                            | string    |                  | 标签文本             |          | `tvt_type`为text、textImage有效                                                                                               |
| `tvt_image_resource`                  | reference |                  | 标签图片             |          | `tvt_type`为image、textImage有效                                                                                              |
| `tvt_position`                        | integer   | 0                | 标签显示位置         |          | 默认在文本最前面                                                                                                              |
| `tvt_margin_left`                     | dimension | 0                | 标签距离左侧距离     |          |                                                                                                                               |
| `tvt_margin_right`                    | dimension | 0                | 标签距离右侧距离     |          |                                                                                                                               |
| `tvt_text_margin_image`               | dimension | 0dp              | 文本与图片的距离     |          | `tvt_type`为textImage有效                                                                                                     |
| `tvt_layout`                          | reference |                  | 自定义View标签       |          | 不设置`tvt_type`时有效                                                                                                        |
| `tvt_image_align_text`                | enum      | Orientation.LEFT | 图片与文字的位置关系 |          | `tvt_type`为textImage有效，left-图片在文字的左边（默认），top-图片在文字上边，right-图片在文字的右边，bottom-图片在文字的下边 |
| `tvt_image_width`                     | dimension |                  | 图片的宽度           |          | `tvt_type`为image、textImage时有效                                                                                            |
| `tvt_image_height`                    | dimension |                  | 图片的高度           |          | `tvt_type`为image、textImage时有效                                                                                            |

### TagConfig属性

<style type="text/css">
.tg  {border-collapse:collapse;border-color:#9ABAD9;border-spacing:0;}
.tg td{background-color:#EBF5FF;border-color:#9ABAD9;border-style:solid;border-width:1px;color:#444;
  font-family:Arial, sans-serif;font-size:14px;overflow:hidden;padding:10px 5px;word-break:normal;}
.tg th{background-color:#409cff;border-color:#9ABAD9;border-style:solid;border-width:1px;color:#fff;
  font-family:Arial, sans-serif;font-size:14px;font-weight:normal;overflow:hidden;padding:10px 5px;word-break:normal;}
.tg .tg-0pky{border-color:inherit;text-align:left;vertical-align:top}
</style>
<table class="tg">
<thead>
  <tr>
    <th class="tg-0pky">API</th>
    <th class="tg-0pky">类型</th>
    <th class="tg-0pky">默认值</th>
    <th class="tg-0pky">描述</th>
    <th class="tg-0pky">版本说明</th>
    <th class="tg-0pky">说明</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td class="tg-0pky">type</td>
    <td class="tg-0pky">Type</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky">标签类型</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky">TEXT-文本，IMAGE-图片，TEXT_IMAGE-图文结合，URL-网络链接</td>
  </tr>
  <tr>
    <td class="tg-0pky">textSize</td>
    <td class="tg-0pky">Float</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky">标签上文本的字体大小</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky">单位PX，不传就和TextView的textSize保持一致</td>
  </tr>
  <tr>
    <td class="tg-0pky">textColor</td>
    <td class="tg-0pky">Int</td>
    <td class="tg-0pky">Color.WHITE</td>
    <td class="tg-0pky">标签上文本的字体颜色</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky"></td>
  </tr>
  <tr>
    <td class="tg-0pky">width</td>
    <td class="tg-0pky">Int</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky">标签宽度</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky">不设置自动适应</td>
  </tr>
  <tr>
    <td class="tg-0pky">height</td>
    <td class="tg-0pky">Int</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky">标签宽度</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky">不设置自动适应</td>
  </tr>
  <tr>
    <td class="tg-0pky">radius</td>
    <td class="tg-0pky">Float</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky">标签的圆角</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky">默认值：2dp</td>
  </tr>
  <tr>
    <td class="tg-0pky">leftTopRadius</td>
    <td class="tg-0pky">Float</td>
    <td class="tg-0pky">2dp</td>
    <td class="tg-0pky">标签左上的圆角</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky"></td>
  </tr>
  <tr>
    <td class="tg-0pky">leftBottomRadius</td>
    <td class="tg-0pky">Float</td>
    <td class="tg-0pky">2dp</td>
    <td class="tg-0pky">标签左下的圆角</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky"></td>
  </tr>
  <tr>
    <td class="tg-0pky">rightTopRadius</td>
    <td class="tg-0pky">Float</td>
    <td class="tg-0pky">2dp</td>
    <td class="tg-0pky">标签右上的圆角</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky"></td>
  </tr>
  <tr>
    <td class="tg-0pky">rightBottomRadius</td>
    <td class="tg-0pky">Float</td>
    <td class="tg-0pky">2dp</td>
    <td class="tg-0pky">标签右下的圆角</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky"></td>
  </tr>
  <tr>
    <td class="tg-0pky">padding</td>
    <td class="tg-0pky">Int</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky">标签的内边距</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky">默认值：topPadding=0，rightPadding=5,bottomPadding=0,leftPadding=5</td>
  </tr>
  <tr>
    <td class="tg-0pky">topPadding</td>
    <td class="tg-0pky">Int</td>
    <td class="tg-0pky">0dp</td>
    <td class="tg-0pky">标签的上内边距</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky"></td>
  </tr>
  <tr>
    <td class="tg-0pky">rightPadding</td>
    <td class="tg-0pky">Int</td>
    <td class="tg-0pky">5dp</td>
    <td class="tg-0pky">标签的右内边距</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky"></td>
  </tr>
  <tr>
    <td class="tg-0pky">bottomPadding</td>
    <td class="tg-0pky">Int</td>
    <td class="tg-0pky">0dp</td>
    <td class="tg-0pky">标签的下内边距</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky"></td>
  </tr>
  <tr>
    <td class="tg-0pky">leftPadding</td>
    <td class="tg-0pky">Int</td>
    <td class="tg-0pky">5dp</td>
    <td class="tg-0pky">标签的左内边距</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky"></td>
  </tr>
  <tr>
    <td class="tg-0pky">backgroundColor</td>
    <td class="tg-0pky">Int</td>
    <td class="tg-0pky">Color.GRAY</td>
    <td class="tg-0pky">标签的背景颜色</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky"></td>
  </tr>
  <tr>
    <td class="tg-0pky">startGradientBackgroundColor</td>
    <td class="tg-0pky">Int</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky">标签的渐变开始颜色</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky"></td>
  </tr>
  <tr>
    <td class="tg-0pky">endGradientBackgroundColor</td>
    <td class="tg-0pky">Int</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky">标签的渐变结束颜色</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky"></td>
  </tr>
  <tr>
    <td class="tg-0pky">gradientOrientation</td>
    <td class="tg-0pky">GradientDrawable.Orientation</td>
    <td class="tg-0pky">GradientDrawable.Orientation.LEFT_RIGHT</td>
    <td class="tg-0pky">标签的渐变样式</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky"></td>
  </tr>
  <tr>
    <td class="tg-0pky">strokeWidth</td>
    <td class="tg-0pky">Int</td>
    <td class="tg-0pky">0</td>
    <td class="tg-0pky">标签的边框宽度</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky"></td>
  </tr>
  <tr>
    <td class="tg-0pky">strokeColor</td>
    <td class="tg-0pky">Int</td>
    <td class="tg-0pky">Color.GRAY</td>
    <td class="tg-0pky">标签的边框颜色</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky">strokeWidth&gt;0有效</td>
  </tr>
  <tr>
    <td class="tg-0pky">imageAlignText</td>
    <td class="tg-0pky"><a href="https://github.com/ChinaLike/TagTextView/blob/main/TagTextView/src/main/java/com/view/text/config/Orientation.kt"><span style="color:#905">[Orientation](https://github.com/ChinaLike/TagTextView/blob/main/TagTextView/src/main/java/com/view/text/config/Orientation.kt)</span></a></td>
    <td class="tg-0pky">Orientation.LEFT</td>
    <td class="tg-0pky">图片在文字的那一个方向</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky"></td>
  </tr>
  <tr>
    <td class="tg-0pky">imageWidth</td>
    <td class="tg-0pky">Int</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky">图片的宽度</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky">不设置图片自适应</td>
  </tr>
  <tr>
    <td class="tg-0pky">imageHeight</td>
    <td class="tg-0pky">Int</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky">图片的高度</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky">不设置图片自适应</td>
  </tr>
  <tr>
    <td class="tg-0pky">align</td>
    <td class="tg-0pky"><a href="https://github.com/ChinaLike/TagTextView/blob/main/TagTextView/src/main/java/com/view/text/config/Align.kt"><span style="color:#905">[Align](https://github.com/ChinaLike/TagTextView/blob/main/TagTextView/src/main/java/com/view/text/config/Align.kt)</span></a></td>
    <td class="tg-0pky">Align.CENTER</td>
    <td class="tg-0pky">标签的对其方式</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky"></td>
  </tr>
  <tr>
    <td class="tg-0pky">text</td>
    <td class="tg-0pky">String</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky">标签文本</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky">type为TYPE.TEXT、TYPE.TEXT_IMAGE有效</td>
  </tr>
  <tr>
    <td class="tg-0pky">imageResource</td>
    <td class="tg-0pky">Int</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky">标签图片</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky">type为TYPE.IMAGE、TYPE.TEXT_IMAGE有效</td>
  </tr>
  <tr>
    <td class="tg-0pky">imageDrawable</td>
    <td class="tg-0pky">Drawable</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky">标签图片</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky">type为TYPE.IMAGE、TYPE.TEXT_IMAGE有效</td>
  </tr>
  <tr>
    <td class="tg-0pky">imageBitmap</td>
    <td class="tg-0pky">Bitmap</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky">标签图片</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky">type为TYPE.IMAGE、TYPE.TEXT_IMAGE有效</td>
  </tr>
  <tr>
    <td class="tg-0pky">imageUrl</td>
    <td class="tg-0pky">String</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky">标签网络图片链接</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky">type为TYPE.URL有效</td>
  </tr>
  <tr>
    <td class="tg-0pky">position</td>
    <td class="tg-0pky">Int</td>
    <td class="tg-0pky">0</td>
    <td class="tg-0pky">标签显示位置</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky">多次添加依次排序</td>
  </tr>
  <tr>
    <td class="tg-0pky">marginLeft</td>
    <td class="tg-0pky">Int</td>
    <td class="tg-0pky">0dp</td>
    <td class="tg-0pky">标签距离左边距离</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky"></td>
  </tr>
  <tr>
    <td class="tg-0pky">marginRight</td>
    <td class="tg-0pky">Int</td>
    <td class="tg-0pky">0dp</td>
    <td class="tg-0pky">标签距离右边距离</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky"></td>
  </tr>
  <tr>
    <td class="tg-0pky">textMarginImage</td>
    <td class="tg-0pky">Int</td>
    <td class="tg-0pky">0dp</td>
    <td class="tg-0pky">标签内文字距离图片的距离</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky">type为Type.TEXT_IMAGE有效</td>
  </tr>
</tbody>
</table>

### 方法

- addTag(config:TagConfig)
    
    + 添加标签
    
    + 属性介绍
    
        config:标签的样式配置,参考[TagConfig](#TagConfig属性)
    
- addTag(view:View,position:Int,align:Align,marginLeft:Int,marginRight:Int)

    + 添加自定义标签
    
    + 属性介绍
        
        view:自定义View
        
        position:显示位置，默认：0
        
        align:对其方式，默认：Align.CENTER
        
        marginLeft:标签距离左侧距离，默认：0
        
        marginRight:标签距离右侧距离，默认：0
    
- addTextTag(block: TagConfig.() -> Unit)

    + 添加文本标签
    
    + 属性介绍
    
        block:标签自定义参数
    
- addImageTag(block: TagConfig.() -> Unit)

    + 添加图标标签
    
    + 属性介绍
    
        block: 标签自定义参数
    
- addTextImageTag(block: TagConfig.() -> Unit)

    + 添加图文标签
    
    + 属性介绍
    
        block: 标签自定义参数

    
- addUrlTag(block: TagConfig.() -> Unit)

    + 添加图文标签
    
    + 属性介绍
    
        block: 标签自定义参数

-  setUnderline(underlineText: String? = null, isFirst: Boolean = true) 

	+ 设置文本下划线
	
	+ 属性介绍
	
        underlineText:需要加下划线的文本,不设置则匹配所有文本
        
        isFirst:是否匹配第一个指定字符串

-  setUnderline(startIndex: Int, endIndex: Int)

	+ 设置文本下划线
	
	+ 属性介绍
	
        startIndex:开始下标
        
        endIndex:结束下标

-  setDeleteLine(deleteLineText: String? = null, isFirst: Boolean = true)

	+ 设置文本删除线
	
	+ 属性介绍
	
	    deleteLineText:需要加删除线的文本，不设置则匹配所有文本

-  setDeleteLine(startIndex: Int, endIndex: Int)

	+ 设置文本删除线
	
	+ 属性介绍
	
        startIndex:开始下标
        
        endIndex:结束下标

-  setSpecificTextColor(@ColorInt color: Int,specificText: String,isFirst: Boolean = true,isUnderlineText: Boolean = false,click: () -> Unit = {})

	+ 设置指定文字颜色
	
	+ 属性介绍
	
        color:制定文本颜色
        
        specificText:指定文本
        
        isFirst:匹配第一个，默认值：true
        
        isUnderlineText:是否显示下划线，可选，默认值false
        
        click:点击事件响应

-  setSpecificTextColor(@ColorInt color: Int,startIndex: Int，endIndex: Int,isUnderlineText: Boolean = false,click: () -> Unit = {})

	+ 设置指定文字颜色
	
	+ 属性介绍
	
        color:制定文本颜色
        
        startIndex:开始下标
        
        endIndex:结束下标
        
        isUnderlineText:是否显示下划线，可选，默认值false
        
        click:点击事件响应

-  setURLSpan(startIndex: Int,endIndex: Int,type: LinkType,linkText: String,@ColorInt color: Int? = null,isUnderlineText: Boolean = false)

	+ 设置超链
	
	+ 属性介绍
	
        startIndex:开始下标
        
        endIndex:结束下标
        
        type:超链接类型，参考[LinkType](https://github.com/ChinaLike/TagTextView/blob/main/TagTextView/src/main/java/com/view/text/config/LinkType.kt)
        
        linkText:链接文本 ，比如跳转电话，只需要传入电话号码就可以
        
        color:超链文本的颜色
        
        isUnderlineText:是否显示下划线，默认值false
