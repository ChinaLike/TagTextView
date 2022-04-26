# TagTextView 

[![](https://img.shields.io/badge/platform-android-brightgreen.svg)](https://developer.android.com/index.html)  [![API](https://img.shields.io/badge/API-14%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=14)  [![](https://jitpack.io/v/ChinaLike/TagTextView.svg)](https://jitpack.io/#ChinaLike/TagTextView)  [![Gradle-4.1.2](https://img.shields.io/badge/Gradle-4.1.2-brightgreen.svg)](https://img.shields.io/badge/Gradle-4.1.2-brightgreen.svg)  [![](https://img.shields.io/badge/language-kotlin-brightgreen.svg)](https://kotlinlang.org/)

SDK主要用于在TextView的指定位置添加文本、图片、图文、网络标签,基本能满足大多数APP的开发，对于比较复杂的标签还可以添加自定义View来实现，SDK中包含了给文本添加下划线、删除线、标记文本颜色、超链等扩展方法。

![image](https://github.com/ChinaLike/TagTextView/blob/main/screenshots/screenshot.jpg)

## API特色

+ 支持在文本的任意位置添加各种不同标签
+ 支持指定位置、文本替换为指定标签
+ 支持网络标签
+ 支持Gif标签
+ 支持自定义布局文件
+ 支持指定文本点击响应
+ 支持下划线
+ 支持删除线
+ 支持超链
+ 支持Kotlin、Java

## 如何使用

> Step 1.先在 build.gradle(Project:XXX) 的 repositories 添加:
    
    ```
	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
	```

> Step 2. 然后在 build.gradle(Module:XXX) 的 dependencies 添加:

    ```
	dependencies {
           implementation 'com.github.ChinaLike:TagTextView:0.1.0'
           // 如果支持网络图片标签，需要添加Glide库
           //implementation "com.github.bumptech.glide:glide:4.11.0"
	}
	```

> Step 3. 如果支持网络标签，需要在`AndroidManifest.xml`中添加:

    ```
        <uses-permission android:name="android.permission.INTERNET" />
    ```
详细用法可参考[Demo](https://github.com/ChinaLike/TagTextView/tree/main/app/src/main/java/com/like/tag)	
Kotlin使用参考[MainActivity](https://github.com/ChinaLike/TagTextView/blob/main/app/src/main/java/com/like/tag/MainActivity.kt)文件
Java使用参考[JavaActivity](https://github.com/ChinaLike/TagTextView/blob/main/app/src/main/java/com/like/tag/JavaActivity.java)文件

## API说明

### XML属性

| API                                   | 描述                 | 默认值           | 说明                                                                                                                          |
|---------------------------------------|----------------------|------------------|-------------------------------------------------------------------------------------------------------------------------------|
| `tvt_type`                            | 标签类型             |                  | text-文本标签，image-图片标签，textImage-图文                                                                                 |
| `tvt_radius`                          | 标签圆角             |                  | `tvt_type`为text、textImage时有效                                                                                             |
| `tvt_left_top_radius`                 | 标签左上角圆角       | 2dp              | `tvt_type`为text、textImage，且`tvt_radius`未设置有效                                                                         |
| `tvt_left_bottom_radius`              | 标签左下角圆角       | 2dp              | `tvt_type`为text、textImage，且`tvt_radius`未设置有效                                                                         |
| `tvt_right_top_radius`                | 标签右上角圆角       | 2dp              | `tvt_type`为text、textImage，且`tvt_radius`未设置有效                                                                         |
| `tvt_right_bottom_radius`             | 标签右下角圆角       | 2dp              | `tvt_type`为text、textImage，且`tvt_radius`未设置有效                                                                         |
| `tvt_padding`                         | 标签内边距           |                  | `tvt_type`为text、textImage时有效                                                                                             |
| `tvt_top_padding`                     | 标签上内边距         | 0dp              | `tvt_type`为text、textImage，且`tvt_padding`未设置有效                                                                        |
| `tvt_right_padding`                   | 标签右内边距         | 5dp              | `tvt_type`为text、textImage，且`tvt_padding`未设置有效                                                                        |
| `tvt_bottom_padding`                  | 标签下内边距         | 0dp              | `tvt_type`为text、textImage，且`tvt_padding`未设置有效                                                                        |
| `tvt_left_padding`                    | 标签左内边距         | 5dp              | `tvt_type`为text、textImage，且`tvt_padding`未设置有效                                                                        |
| `tvt_background_color`                | 标签背景颜色         | Color.GRAY       | `tvt_type`为text、textImage时有效                                                                                             |
| `tvt_start_gradient_background_color` | 标签渐变开始颜色     |                  | `tvt_type`为text、textImage时有效                                                                                             |
| `tvt_end_gradient_background_color`   | 标签渐变结束颜色     |                  | `tvt_type`为text、textImage时有效                                                                                             |
| `tvt_stroke_width`                    | 标签边框宽度         |                  | `tvt_type`为text、textImage时有效                                                                                             |
| `tvt_stroke_color`                    | 标签边框颜色         | Color.GRAY       | `tvt_type`为text、textImage，且`tvt_stroke_width`>0有效                                                                       |
| `tvt_text_size`                       | 文本字体大小         |                  | `tvt_type`为text、textImage有效                                                                                               |
| `tvt_text_color`                      | 文本字体颜色         | Color.WHITE      | `tvt_type`为text、textImage有效                                                                                               |
| `tvt_width`                           | 标签宽度             |                  | `tvt_type`为text、textImage有效                                                                                               |
| `tvt_height`                          | 标签高度             |                  | `tvt_type`为text、textImage有效                                                                                               |
| `tvt_align`                           | 标签与文本对其方式   | Align.CENTER     | baseline-基线对其，center-中心对其，bottom-底部对其                                                                           |
| `tvt_text`                            | 标签文本             |                  | `tvt_type`为text、textImage有效                                                                                               |
| `tvt_image_resource`                  | 标签图片             |                  | `tvt_type`为image、textImage有效                                                                                              |
| `tvt_position`                        | 标签显示位置         | 0                | 默认在文本最前面                                                                                                              |
| `tvt_margin_left`                     | 标签距离左侧距离     | 0                |                                                                                                                               |
| `tvt_margin_right`                    | 标签距离右侧距离     | 0                |                                                                                                                               |
| `tvt_text_margin_image`               | 文本与图片的距离     | 0dp              | `tvt_type`为textImage有效                                                                                                     |
| `tvt_layout`                          | 自定义View标签       |                  | 不设置`tvt_type`时有效                                                                                                        |
| `tvt_image_align_text`                | 图片与文字的位置关系 | Orientation.LEFT | `tvt_type`为textImage有效，left-图片在文字的左边（默认），top-图片在文字上边，right-图片在文字的右边，bottom-图片在文字的下边 |
| `tvt_image_width`                     | 图片的宽度           |                  | `tvt_type`为image、textImage时有效                                                                                            |
| `tvt_image_height`                    | 图片的高度           |                  | `tvt_type`为image、textImage时有效                                                                                            |

### TagConfig属性

| API                          | 描述                     | 默认值                                    | 说明                                                               |
|------------------------------|-------------------------|-------------------------------------------|--------------------------------------------------------------------|
| type                         | 标签类型                 |                                           | TEXT-文本，IMAGE-图片，TEXT_IMAGE-图文结合，URL-网络链接           |
| textSize                     | 标签上文本的字体大小     |                                           | 单位PX，不传就和TextView的textSize保持一致                         |
| textColor                    | 标签上文本的字体颜色     | Color.WHITE                               |                                                                    |
| width                        | 标签宽度                 |                                           | 不设置自动适应                                                     |
| height                       | 标签宽度                 |                                           | 不设置自动适应                                                     |
| radius                       | 标签的圆角               |                                           |                                                                    |
| leftTopRadius                | 标签左上的圆角           | 2dp                                       |                                                                    |
| leftBottomRadius             | 标签左下的圆角           | 2dp                                       |                                                                    |
| rightTopRadius               | 标签右上的圆角           | 2dp                                       |                                                                    |
| rightBottomRadius            | 标签右下的圆角           | 2dp                                       |                                                                    |
| padding                      | 标签的内边距             |                                           | 默认值：topPadding=0，rightPadding=5,bottomPadding=0,leftPadding=5 |
| topPadding                   | 标签的上内边距           | 0dp                                       |                                                                    |
| rightPadding                 | 标签的右内边距           | 5dp                                       |                                                                    |
| bottomPadding                | 标签的下内边距           | 0dp                                       |                                                                    |
| leftPadding                  | 标签的左内边距           | 5dp                                       |                                                                    |
| backgroundColor              | 标签的背景颜色           | Color.GRAY                                |                                                                    |
| startGradientBackgroundColor | 标签的渐变开始颜色       |                                           |                                                                    |
| endGradientBackgroundColor   | 标签的渐变结束颜色       |                                           |                                                                    |
| gradientOrientation          | 标签的渐变样式           | GradientDrawable .Orientation .LEFT_RIGHT |                                                                    |
| strokeWidth                  | 标签的边框宽度           | 0                                         |                                                                    |
| strokeColor                  | 标签的边框颜色           | Color.GRAY                                | strokeWidth>0有效                                                  |
| imageAlignText               | 图片在文字的那一个方向   | Orientation.LEFT                          |                                                                    |
| imageWidth                   | 图片的宽度               |                                           | 不设置图片自适应                                                   |
| imageHeight                  | 图片的高度               |                                           | 不设置图片自适应                                                   |
| align                        | 标签的对其方式           | Align.CENTER                              |                                                                    |
| text                         | 标签文本                 |                                           | type为TYPE.TEXT、TYPE.TEXT_IMAGE有效                               |
| imageResource                | 标签图片                 |                                           | type为TYPE.IMAGE、TYPE.TEXT_IMAGE有效                              |
| imageDrawable                | 标签图片                 |                                           | type为TYPE.IMAGE、TYPE.TEXT_IMAGE有效                              |
| imageBitmap                  | 标签图片                 |                                           | type为TYPE.IMAGE、TYPE.TEXT_IMAGE有效                              |
| imageUrl                     | 标签网络图片链接         |                                           | type为TYPE.URL有效                                                 |
| position                     | 标签显示位置             | 0                                         | 多次添加依次排序                                                   |
| marginLeft                   | 标签距离左边距离         | 0dp                                       |                                                                    |
| marginRight                  | 标签距离右边距离         | 0dp                                       |                                                                    |
| textMarginImage              | 标签内文字距离图片的距离 | 0dp                                       | type为Type.TEXT_IMAGE有效                                          |

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
        
- replaceTag(tagText: String, config: TagConfig, isFirst: Boolean = true)

    + 替换标签
    
    + 属性介绍
    
        tagText:需要替换的文本
        
        config:标签配置
        
        isFirst:是否匹配第一个
    
- replaceTag(tagText: String, view: View, isFirst: Boolean = true, align: Align = Align.CENTER, marginLeft: Int = 0, marginRight: Int = 0)

    + 替换标签
    
    + 属性介绍
    
         tagText:需要替换的文本
         
         view:自定义标签
         
         isFirst:是否匹配第一个
         
         align:标签对齐方式
         
         marginLeft:标签距离左侧距离
         
         marginRight:标签距离右侧距离
  
- replaceTag(startIndex: Int, endIndex: Int, config: TagConfig)

    + 替换标签
    
    + 属性介绍
    
         startIndex:开始下标
         
         endIndex:结束下标
         
         config:标签配置

- replaceTag( startIndex: Int, endIndex: Int, view: View, align: Align = Align.CENTER, marginLeft: Int = 0, marginRight: Int = 0 )

    + 替换标签
    
    + 属性介绍
    
         startIndex:开始位置
         
         endIndex:结束位置
         
         view:自定义标签
         
         align:标签对齐方式
         
         marginLeft:标签距离左侧距离
         
         marginRight:标签距离右侧距离

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
