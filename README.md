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

| API | 类型 | 默认值 | 描述 | 版本说明 | 说明 |
| ---------- | ------------- | ------------- | ------------- | ------------- | ------------- |
| `tvt_type` | enum  |   | 标签类型 |   | text-文本标签，image-图片标签，textImage-图文 |
| `tvt_radius` | dimension  |   | 标签圆角 |   | `tvt_type`为text、textImage时有效 |
| `tvt_left_top_radius` | dimension  |   | 标签左上角圆角 |   | `tvt_type`为text、textImage，且`tvt_radius`未设置有效 |
| `tvt_left_bottom_radius` | dimension  |   | 标签左下角圆角 |   | `tvt_type`为text、textImage，且`tvt_radius`未设置有效 |
| `tvt_right_top_radius` | dimension  |   | 标签右上角圆角 |   | `tvt_type`为text、textImage，且`tvt_radius`未设置有效 |
| `tvt_right_bottom_radius` | dimension  |   | 标签右下角圆角 |   | `tvt_type`为text、textImage，且`tvt_radius`未设置有效 |
| `tvt_padding` | dimension  |   | 标签内边距 |   | `tvt_type`为text、textImage时有效 |
| `tvt_top_padding` | dimension  |   | 标签上内边距 |   | `tvt_type`为text、textImage，且`tvt_padding`未设置有效 |
| `tvt_right_padding` | dimension  |   | 标签右内边距 |   | `tvt_type`为text、textImage，且`tvt_padding`未设置有效 |
| `tvt_bottom_padding` | dimension  |   | 标签下内边距 |   | `tvt_type`为text、textImage，且`tvt_padding`未设置有效 |
| `tvt_left_padding` | dimension  |   | 标签左内边距 |   | `tvt_type`为text、textImage，且`tvt_padding`未设置有效 |
| `tvt_background_color` | color  |   | 标签背景颜色 |   | `tvt_type`为text、textImage时有效 |
| `tvt_start_gradient_background_color` | color  |   | 标签渐变开始颜色 |   | `tvt_type`为text、textImage时有效 |
| `tvt_end_gradient_background_color` | color  |   | 标签渐变结束颜色 |   | `tvt_type`为text、textImage时有效 |
| `tvt_stroke_width` | dimension  |   | 标签边框宽度 |   | `tvt_type`为text、textImage时有效 |
| `tvt_stroke_color` | color  |   | 标签边框颜色 |   | `tvt_type`为text、textImage，且`tvt_stroke_width`>0有效 |
| `tvt_text_size` | dimension  |   | 文本字体大小 |   | `tvt_type`为text、textImage有效 |
| `tvt_text_color` | color  |   | 文本字体颜色 |   | `tvt_type`为text、textImage有效 |
| `tvt_width` | dimension  |   | 标签宽度 |   | `tvt_type`为text、textImage有效 |
| `tvt_height` | dimension  |   | 标签高度 |   | `tvt_type`为text、textImage有效 |
| `tvt_align` | enum  |   | 标签与文本对其方式 |   | baseline-基线对其（默认），center-中心对其，bottom-底部对其 |
| `tvt_text` | string  |   | 标签文本 |   | `tvt_type`为text、textImage有效 |
| `tvt_image_resource` | reference  |   | 标签图片 |   | `tvt_type`为image、textImage有效 |
| `tvt_position` | integer  |   | 标签显示位置 |   | 默认在文本最前面 |
| `tvt_margin_left` | dimension  |   | 标签距离左侧距离 |   |  |
| `tvt_margin_right` | dimension  |   | 标签距离右侧距离 |   |  |
| `tvt_text_margin_image` | dimension  |   | 文本与图片的距离 |   | `tvt_type`为textImage有效 |
| `tvt_layout` | reference  |   | 自定义View标签 |   | 不设置`tvt_type`时有效 |
| `tvt_image_align_text` | enum  |   | 图片与文字的位置关系 |   | `tvt_type`为textImage有效，left-图片在文字的左边（默认），top-图片在文字上边，right-图片在文字的右边，bottom-图片在文字的下边 |
| `tvt_image_width` | dimension  |   | 图片的宽度 |   | `tvt_type`为image、textImage时有效 |
| `tvt_image_height` | dimension  |   | 图片的高度 |   | `tvt_type`为image、textImage时有效 |

### TagConfig属性

| API | 类型 | 默认值 | 描述 | 版本说明 | 说明 |
| ---------- | ------------- | ------------- | ------------- | ------------- | ------------- |
| type | Type  |   | 标签类型 |   | TEXT-文本，IMAGE-图片，TEXT_IMAGE-图文结合，URL-网络链接 |
| textSize | Float  |   | 标签上文本的字体大小 |   | 单位PX，不传就和TextView的textSize保持一致 |
| textColor | Int  |   | 标签上文本的字体颜色 |   | 默认值：Color.WHITE |
| width | Int  |   | 标签宽度 |   | 不设置自动适应 |
| height | Int  |   | 标签宽度 |   | 不设置自动适应 |
| radius | Float  |   | 标签的圆角 |   | 默认值：2dp |
| leftTopRadius | Float  |   | 标签左上的圆角 |   | 默认值：2dp |
| leftBottomRadius | Float  |   | 标签左下的圆角 |   | 默认值：2dp |
| rightTopRadius | Float  |   | 标签右上的圆角 |   | 默认值：2dp |
| rightBottomRadius | Float  |   | 标签右下的圆角 |   | 默认值：2dp |
| padding | Int  |   | 标签的内边距 |   | 默认值：topPadding=0，rightPadding=5,bottomPadding=0,leftPadding=5 |
| topPadding | Int  |   | 标签的上内边距 |   | 默认值：0dp |
| rightPadding | Int  |   | 标签的右内边距 |   | 默认值：5dp |
| bottomPadding | Int  |   | 标签的下内边距 |   | 默认值：0dp |
| leftPadding | Int  |   | 标签的左内边距 |   | 默认值：5dp |
| backgroundColor | Int  |   | 标签的背景颜色 |   | 默认值：Color.GRAY |
| startGradientBackgroundColor | Int  |   | 标签的渐变开始颜色 |   |  |
| endGradientBackgroundColor | Int  |   | 标签的渐变结束颜色 |   |  |
| gradientOrientation | GradientDrawable.Orientation  |   | 标签的渐变样式 |   |  |
| strokeWidth | Int  |   | 标签的边框宽度 |   |  |
| strokeColor | Int  |   | 标签的边框颜色 |   | strokeWidth>0有效 |
| imageAlignText | [Orientation](/src/main/java/com/view/text/config/Orientation.kt)  |   | 图片在文字的那一个方向 |   | 默认值：Orientation.LEFT |
| imageWidth | Int  |   | 图片的宽度 |   | 不设置图片自适应 |
| imageHeight | Int  |   | 图片的高度 |   | 不设置图片自适应 |
| align | [Align](/src/main/java/com/view/text/config/Align.kt)  |   | 标签的对其方式  |   | 默认值：Align.CENTER |
| text | String  |   | 标签文本 |   | type为TYPE.TEXT、TYPE.TEXT_IMAGE有效 |
| imageResource | Int  |   | 标签图片 |   | type为TYPE.IMAGE、TYPE.TEXT_IMAGE有效 |
| imageDrawable | Drawable  |   | 标签图片 |   | type为TYPE.IMAGE、TYPE.TEXT_IMAGE有效 |
| imageBitmap | Bitmap  |   | 标签图片 |   | type为TYPE.IMAGE、TYPE.TEXT_IMAGE有效 |
| imageUrl | String  |   | 标签网络图片链接 |   | type为TYPE.URL有效 |
| position | Int  |   | 标签显示位置 |   | 默认值：0，多次添加依次排序 |
| marginLeft | Int  |   | 标签距离左边距离 |   | 默认值：0 |
| marginRight | Int  |   | 标签距离右边距离 |   | 默认值：0 |
| textMarginImage | Int  |   | 标签内文字距离图片的距离 |   | 默认值：0，type为Type.TEXT_IMAGE有效 |

### 方法

- addTag(config:TagConfig)
    
    添加标签
    
    config:标签的样式配置,参考[TagConfig](#TagConfig属性)
    
- addTag(view:View,position:Int,align:Align,marginLeft:Int,marginRight:Int)

    添加自定义标签
    
    view:自定义View
    
    position:显示位置，默认：0
    
    align:对其方式，默认：Align.CENTER
    
    marginLeft:标签距离左侧距离，默认：0
    
    marginRight:标签距离右侧距离，默认：0
    
- addTextTag(block: TagConfig.() -> Unit)

    添加文本标签
    block:标签自定义参数
    
- addImageTag(block: TagConfig.() -> Unit)

    添加图标标签
    block: 标签自定义参数
    
- addTextImageTag(block: TagConfig.() -> Unit)

    添加图文标签
    block: 标签自定义参数

    
- addUrlTag(block: TagConfig.() -> Unit)

    添加图文标签
    block: 标签自定义参数

-  setUnderline(underlineText: String? = null, isFirst: Boolean = true) 

	设置文本下划线
	
	underlineText:需要加下划线的文本,不设置则匹配所有文本
	
	isFirst:是否匹配第一个指定字符串

-  setUnderline(startIndex: Int, endIndex: Int)

	设置文本下划线
	
	startIndex:开始下标
	
	endIndex:结束下标

-  setDeleteLine(deleteLineText: String? = null, isFirst: Boolean = true)

	设置文本删除线
	
	deleteLineText:需要加删除线的文本，不设置则匹配所有文本

-  setDeleteLine(startIndex: Int, endIndex: Int)

	设置文本删除线
	
	startIndex:开始下标
	
	endIndex:结束下标

-  setSpecificTextColor(@ColorInt color: Int,specificText: String,isFirst: Boolean = true,isUnderlineText: Boolean = false,click: () -> Unit = {})

	设置指定文字颜色
	
	color:制定文本颜色
	
	specificText:指定文本
	
	isFirst:匹配第一个，默认值：true
	
	isUnderlineText:是否显示下划线，可选，默认值false
	
	click:点击事件响应

-  setSpecificTextColor(@ColorInt color: Int,startIndex: Int，endIndex: Int,isUnderlineText: Boolean = false,click: () -> Unit = {})

	设置指定文字颜色
	
	color:制定文本颜色
	
	startIndex:开始下标
	
	endIndex:结束下标
	
	isUnderlineText:是否显示下划线，可选，默认值false
	
	click:点击事件响应

-  setURLSpan(startIndex: Int,endIndex: Int,type: LinkType,linkText: String,@ColorInt color: Int? = null,isUnderlineText: Boolean = false)

	设置超链
	
	startIndex:开始下标
	
	endIndex:结束下标
	
	type:超链接类型，参考[LinkType](/src/main/java/com/view/text/config/LinkType.kt)
	
	linkText:链接文本 ，比如跳转电话，只需要传入电话号码就可以
	
	color:超链文本的颜色
	
	isUnderlineText:是否显示下划线，默认值false
