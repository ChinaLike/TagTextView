# TagTextView [![](https://img.shields.io/badge/platform-android-brightgreen.svg)](https://developer.android.com/index.html)  [![API](https://img.shields.io/badge/API-14%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=14)  [![](https://jitpack.io/v/ChinaLike/TagTextView.svg)](https://jitpack.io/#ChinaLike/TagTextView)  [![Gradle-4.1.2](https://img.shields.io/badge/Gradle-4.1.2-brightgreen.svg)](https://img.shields.io/badge/Gradle-4.1.2-brightgreen.svg)  [![](https://img.shields.io/badge/language-kotlin-brightgreen.svg)](https://kotlinlang.org/)

## Demo介绍

TagTextView主要是给TextView前面（或结尾）添加一个（或多个）字符串或者图片标签的库，以下是Demo中的一些示例图片

![image](https://github.com/ChinaLike/TagTextView/blob/main/screenshots/screenshot.jpg)

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
           implementation 'com.github.ChinaLike:TagTextView:0.0.2'
	}

## API说明

### TagTextView功能

> xml属性

| API | 类型 | 默认值 | 描述 | 版本说明 | 说明 |
| ---------- | ------------- | ------------- | ------------- | ------------- | ------------- |
| `tvt_left_top_radius` | dimension  |   | 标签左上圆角 |   |  |
| `tvt_left_bottom_radius` |  dimension |   | 标签左下圆角 |   |  |
| `tvt_right_top_radius` | dimension  |   | 标签右上圆角 |   |  |
| `tvt_right_bottom_radius` |  dimension |   | 标签右下圆角 |   |  |
| `tvt_radius` |  dimension | 9999dp  | 标签圆角 |  | 当单独设置了标签圆角此方法对应方位圆角将失效  |
| `tvt_tag_left_padding` |  dimension | 10dp | 标签左边内边距 |   |  |
| `tvt_tag_top_padding` |  dimension |  | 标签顶部内边距 |   |  |
| `tvt_tag_right_padding` |  dimension | 10dp | 标签右边内边距 |   |  |
| `tvt_tag_bottom_padding` |  dimension |  | 标签底部内边距 |   |  |
| `tvt_tag_padding` |  dimension | 0 | 标签内边距 |   | 当单独设置了标签内边距此方法对应方位内边距将失效 |
| `tvt_tag_background_color` | color  | Color.GRAY | 标签背景颜色 |   |  |
| `tvt_tag_space` |  dimension | 0 | 标签与标签的间隔 |   |  |
| `tvt_text_space` |  dimension | 0 | 标签与文本的间隔 |   |  |
| `tvt_tag_location` | enum  | start | 标签显示的位置 |   | start开始位置，end结束位置 |
| `tvt_tag_start_background_color` | color  |  | 渐变背景开始颜色 |   |  |
| `tvt_tag_end_background_color` | color  |  | 渐变背景结束颜色 |   |  |
| `tvt_tag_text_size` |  dimension | 14sp | 标签文本大小 |   |  |
| `tvt_tag_text_color` |  color | Color.WHITE | 标签文本颜色 |   |  |
| `tvt_first_tag_left_space` | dimension  | 0 | 第一个标签距离左边距离 |   |  |
| `tvt_tag_text` | string  |  | 标签内容 |   | 如果`tvt_tag_text` 、`tvt_tag_image`都设置的话，只有`tvt_tag_image`生效 |
| `tvt_tag_image` |  reference |  | 图片标签 |   | 如果`tvt_tag_text` 、`tvt_tag_image`都设置的话，只有`tvt_tag_image`生效 |
| `tvt_tag_width` |  dimension |  | 标签的自定义宽度 |   |  |
| `tvt_tag_height` |  dimension |  | 标签的自定义高度 |   |  |

> 属性

| API | 类型 | 默认值 | 描述 | 版本说明 | 说明 |
| ---------- | ------------- | ------------- | ------------- | ------------- | ------------- |
| `leftTopRadius` | Float  |   | 标签左上圆角 |   |  |
| `leftBottomRadius` |  Float |   | 标签左下圆角 |   |  |
| `rightTopRadius` | Float  |   | 标签右上圆角 |   |  |
| `rightBottomRadius` |  Float |   | 标签右下圆角 |   |  |
| `radius` |  Float | 9999F  | 标签圆角 |  | 当单独设置了标签圆角此方法对应方位圆角将失效  |
| `tagLeftPadding` |  Int | 10dp | 标签左边内边距 |   |  |
| `tagTopPadding` |  Int |  | 标签顶部内边距 |   |  |
| `tagRightPadding` |  Int | 10dp | 标签右边内边距 |   |  |
| `tagBottomPadding` |  Int |  | 标签底部内边距 |   |  |
| `tagPadding` |  Int | 0 | 标签内边距 |   | 当单独设置了标签内边距此方法对应方位内边距将失效 |
| `tagBackgroundColor` | Int  | Color.GRAY | 标签背景颜色 |   |  |
| `tagSpace` |  Int | 0 | 标签与标签的间隔 |   |  |
| `textSpace` |  Int | 0 | 标签与文本的间隔 |   |  |
| `tagLocation` | Int  | `TagLocation.START` | 标签显示的位置 |   |`TagLocation.START`开始位置，`TagLocation.END`结束位置 |
| `tagStartBackgroundColor` | Int  |  | 渐变背景开始颜色 |   |  |
| `tagEndBackgroundColor` | Int  |  | 渐变背景结束颜色 |   |  |
| `tagTextSize` |  Float | 14sp | 标签文本大小 |   |  |
| `tagTextColor` |  Int | Color.WHITE | 标签文本颜色 |   |  |
| `firstTagLeftSpace` | Int  | 0 | 第一个标签距离左边距离 |   |  |
| `tagText` | String  |  | 标签内容 |   | 如果`tagText` 、`tagImage`都设置的话，只有`tagImage`生效 |
| `tagImage` |  Drawable |  | 图片标签 |   | 如果`tagText` 、`tagImage`都设置的话，只有`tagImage`生效 |
| `tagWidth` |  Int |  | 标签的自定义宽度 |   |  |
| `tagHeight` |  Int |  | 标签的自定义高度 |   |  |

> 方法

-  setTextTag(params) 

	设置标签
	
	params:标签内容，支持以下格式

		BaseTagAdapter<*>:自定义适配器,自己实现标签显示样式，自定义中只有tvt_tag_space、tvt_text_space、tvt_tag_location、tvt_first_tag_left_space字段有效
	
		MutableList<T>:多个标签，T支持String、DrawableRes、Bitmap、Drawable
	
		String:字符串标签，如果是一个只需要传入一个字符串，多个就传入多个字符串
	
		Bitmap:图片标签，如果是一个只需要传入一个Bitmap，多个就传入多个Bitmap
	
		Int:图片标签，如果是一个只需要传入一个DrawableRes，多个就传入多个DrawableRes
	
		Drawable:图片标签，如果是一个只需要传入一个Drawable，多个就传入多个Drawable
     
### 扩展功能（不支持xml配置样式）

-  setTextTag(config:TagConfig,params:Any) 

	设置标签
	
	config: 标签样式，可选，参考[TagConfig](https://github.com/ChinaLike/TagTextView/blob/main/TagTextView/src/main/java/com/view/text/config/TagConfig.kt)
	
	params:标签内容，支持以下格式：
	
		BaseTagAdapter<*>:自定义适配器,自己实现标签显示样式MutableList<T>:多个标签，T支持String、DrawableRes、Bitmap、Drawable
		
		String:字符串标签，如果是一个只需要传入一个字符串，多个就传入多个字符串
		
		Bitmap:图片标签，如果是一个只需要传入一个Bitmap，多个就传入多个Bitmap
		
		Int:图片标签，如果是一个只需要传入一个DrawableRes，多个就传入多个DrawableRes
		
		Drawable:图片标签，如果是一个只需要传入一个Drawable，多个就传入多个Drawable

-  setUnderline(underline: String) 

	设置文本下划线
	
	underline:需要加下划线的文本，如果多个一样，只有第一个加下划线

-  setUnderline(startIndex: Int, endIndex: Int)

	设置文本下划线
	
	startIndex:开始下标
	
	endIndex:结束下标

-  setUnderline(vararg indexRang: IntArray)

	设置文本下划线
	
	indexRang:整型数组，大小为2，可传多组

-  setUnderline()

	设置文本下划线
	
	所有文本都设置下划线

-  setDeleteLine(underline: String)

	设置文本删除线
	
	underline:需要加删除线的文本，如果多个一样，只有第一个加删除线

-  setDeleteLine(startIndex: Int, endIndex: Int)

	设置文本删除线
	
	startIndex:开始下标
	
	endIndex:结束下标

-  setDeleteLine(vararg indexRang: IntArray)

	设置文本删除线
	
	indexRang:整型数组，大小为2，可传多组

-  setDeleteLine()

	设置文本删除线
	
	所有文本都设置删除线

-  setSpecificTextColor(@ColorInt color: Int,specificText: String，isUnderlineText: Boolean = false,onTagClickListener: OnTagClickListener? = null)

	设置指定文字颜色
	
	color:制定文本颜色
	
	specificText:指定文本
	
	isUnderlineText:是否显示下划线，可选，默认值false
	
	onClick:点击事件响应，可选	

-  setSpecificTextColor(@ColorInt color: Int,startIndex: Int，endIndex: Int,isUnderlineText: Boolean = false,onTagClickListener: OnTagClickListener? = null)

	设置指定文字颜色
	
	color:制定文本颜色
	
	startIndex:开始下标
	
	endIndex:结束下标
	
	isUnderlineText:是否显示下划线，可选，默认值false
	
	onClick:点击事件响应，可选	

-  setSpecificTextColor(data: MutableList<SpanConfig>,onTagClickListener: OnTagClickListener? = null)

	设置指定文字颜色
	
	data:自定义多个指定文本的颜色
	
	onClick:点击事件响应，可选


-  setURLSpan(startIndex: Int,endIndex: Int,type: SpanType,linkText: String,@ColorInt color: Int? = null,isUnderlineText: Boolean = false)

	设置超链
	
	startIndex:开始下标
	
	endIndex:结束下标
	
	type:超链接类型，参考[SpanType](https://github.com/ChinaLike/TagTextView/blob/main/TagTextView/src/main/java/com/view/text/constants/SpanType.kt)
	
	linkText:链接文本 ，比如跳转电话，只需要传入电话号码就可以
	
	color:超链文本的颜色
	
	isUnderlineText:是否显示下划线，可选，默认值false

-  setURLSpan(data: MutableList<URLSpanConfig>?)

	设置超链
	
	data:自定义超链，参考[URLSpanConfig](https://github.com/ChinaLike/TagTextView/blob/main/TagTextView/src/main/java/com/view/text/config/URLSpanConfig.kt)