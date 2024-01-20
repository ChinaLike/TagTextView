package com.like.tag;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.core.util.DensityUtilKt;
import com.view.text.TextViewExKt;
import com.view.text.annotation.DrawableZoomType;
import com.view.text.annotation.Align;
import com.view.text.config.LinkType;
import com.view.text.config.Orientation;
import com.view.text.config.TagConfig;
import com.view.text.config.Type;
import com.view.text.view.TagTextView;

import java.util.ArrayList;
import java.util.List;

public class JavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //文本
        textStyle();
        //图片
        imageStyle();
        //图文
        textImageStyle();
        //网络图片
        urlStyle();
        //在XML使用
        xmlStyle();
        //扩展方法
        exFun();
        //列表中的使用
        recyclerViewStyle();
    }

    /**
     * 1. 文本标签样式(type=Type.TEXT)
     */
    private void textStyle() {
        //1.1 默认样式
        TagConfig tv1Config = new TagConfig(Type.TEXT);
        tv1Config.setText("新品");
        TextViewExKt.addTag(findViewById(R.id.text_tv1), tv1Config, () -> {
            Toast.makeText(JavaActivity.this, "新品图标被点击了", Toast.LENGTH_SHORT).show();
            return null;
        });


        //1.2 自定义背景颜色
        TagConfig tv2Config = new TagConfig(Type.TEXT);
        tv2Config.setText("新品");
        tv2Config.setRightPadding(DensityUtilKt.getDp(5));
        tv2Config.setLeftPadding(DensityUtilKt.getDp(5));
        tv2Config.setBackgroundColor(Color.parseColor("#FF0040"));
        TextViewExKt.addTag(findViewById(R.id.text_tv2), tv2Config);

        //1.3 自定义圆角
        TagConfig tv3Config = new TagConfig(Type.TEXT);
        tv3Config.setText("新品");
        tv3Config.setLeftPadding(DensityUtilKt.getDp(15));
        tv3Config.setRightPadding(DensityUtilKt.getDp(15));
        tv3Config.setRightTopRadius(DensityUtilKt.getDp(99));
        tv3Config.setRightBottomRadius(DensityUtilKt.getDp(99));
        tv3Config.setBackgroundColor(Color.parseColor("#FFB800"));
        TextViewExKt.addTag(findViewById(R.id.text_tv3), tv3Config);

        //1.4 自定义内边距
        TagConfig tv4Config = new TagConfig(Type.TEXT);
        tv4Config.setText("新品");
        tv4Config.setLeftPadding(DensityUtilKt.getDp(15));
        tv4Config.setRightPadding(DensityUtilKt.getDp(15));
        tv4Config.setRadius((float) DensityUtilKt.getDp(2));
        tv4Config.setBackgroundColor(Color.parseColor("#00BFFF"));
        TextViewExKt.addTag(findViewById(R.id.text_tv4), tv4Config);


        //1.5 自定义边框
        TagConfig tv5Config = new TagConfig(Type.TEXT);
        tv5Config.setText("新品");
        tv5Config.setLeftPadding(DensityUtilKt.getDp(10));
        tv5Config.setRightPadding(DensityUtilKt.getDp(10));
        tv5Config.setStrokeWidth(DensityUtilKt.getDp(1));
        tv5Config.setStrokeColor(Color.parseColor("#FF0040"));
        tv5Config.setTextColor(Color.parseColor("#FF0040"));
        tv5Config.setBackgroundColor(Color.parseColor("#FFA07A"));
        TextViewExKt.addTag(findViewById(R.id.text_tv5), tv5Config);

        //1.6 自定义外边距
        TagConfig tv6Config = new TagConfig(Type.TEXT);
        tv6Config.setText("新品");
        tv6Config.setPadding(DensityUtilKt.getDp(10));
        tv6Config.setMarginLeft(DensityUtilKt.getDp(20));
        tv6Config.setMarginRight(DensityUtilKt.getDp(10));
        tv6Config.setBackgroundColor(Color.parseColor("#32CD32"));
        TextViewExKt.addTag(findViewById(R.id.text_tv6), tv6Config);

        //1.7 自定义显示位置
        TagConfig tv7Config = new TagConfig(Type.TEXT);
        tv7Config.setText("新品");
        tv7Config.setLeftPadding(DensityUtilKt.getDp(10));
        tv7Config.setRightPadding(DensityUtilKt.getDp(10));
        tv7Config.setLeftTopRadius(0);
        tv7Config.setLeftBottomRadius(0);
        tv7Config.setRightTopRadius(DensityUtilKt.getDp(99));
        tv7Config.setMarginLeft(DensityUtilKt.getDp(10));
        tv7Config.setMarginRight(DensityUtilKt.getDp(10));
        tv7Config.setBackgroundColor(Color.parseColor("#FF1493"));
        tv7Config.setPosition(5);
        TextViewExKt.addTag(findViewById(R.id.text_tv7), tv7Config);

        //1.8 固定标签大小
        TagConfig tv8Config = new TagConfig(Type.TEXT);
        tv8Config.setText("新品");
        tv8Config.setDrawableZoomType(DrawableZoomType.CUSTOM);
        tv8Config.setWidth(DensityUtilKt.getDp(20));
        tv8Config.setHeight(DensityUtilKt.getDp(20));
        tv8Config.setBackgroundColor(Color.parseColor("#40E0D0"));
        TextViewExKt.addTag(findViewById(R.id.text_tv8), tv8Config);

        //1.9 渐变标签
        TagConfig tv9Config = new TagConfig(Type.TEXT);
        tv9Config.setText("新品");
        tv9Config.setStartGradientBackgroundColor(Color.parseColor("#FFA07A"));
        tv9Config.setEndGradientBackgroundColor(Color.parseColor("#FF0040"));
        TextViewExKt.addTag(findViewById(R.id.text_tv9), tv9Config);

        //1.10 对齐方式,底部对齐
        TagConfig tv10Config = new TagConfig(Type.TEXT);
        tv10Config.setText("新品");
        tv10Config.setDrawableZoomType(DrawableZoomType.CUSTOM);
        tv10Config.setAlign(Align.BOTTOM);
        tv10Config.setHeight(DensityUtilKt.getDp(50));
        tv10Config.setWidth(DensityUtilKt.getDp(70));
        tv10Config.setStartGradientBackgroundColor(Color.parseColor("#FFA07A"));
        tv10Config.setEndGradientBackgroundColor(Color.parseColor("#FF0040"));
        TextViewExKt.addTag(findViewById(R.id.text_tv10), tv10Config);


        //1.11 设置文本样式
        TagConfig tv11Config = new TagConfig(Type.TEXT);
        tv11Config.setText("新品");
        tv11Config.setTextColor(Color.parseColor("#40E0D0"));
        tv11Config.setTextSize((float) DensityUtilKt.getSp(20));
        tv11Config.setStartGradientBackgroundColor(Color.parseColor("#FFA07A"));
        tv11Config.setEndGradientBackgroundColor(Color.parseColor("#FF0040"));
        TextViewExKt.addTag(findViewById(R.id.text_tv11), tv11Config);

        //1.12 添加多个文本标签
        TagConfig tv12Config = new TagConfig(Type.TEXT);
        tv12Config.setText("新品");
        tv12Config.setStartGradientBackgroundColor(Color.parseColor("#F0E68C"));
        tv12Config.setEndGradientBackgroundColor(Color.parseColor("#FFD700"));

        TagConfig tv12Config1 = new TagConfig(Type.TEXT);
        tv12Config1.setText("精品");
        tv12Config1.setStartGradientBackgroundColor(Color.parseColor("#FFA07A"));
        tv12Config1.setEndGradientBackgroundColor(Color.parseColor("#FF0040"));
        tv12Config1.setStrokeWidth(DensityUtilKt.getDp(1));
        tv12Config1.setMarginLeft(DensityUtilKt.getDp(5));
        tv12Config1.setStrokeColor(Color.parseColor("#228B22"));

        TagConfig tv12Config2 = new TagConfig(Type.TEXT);
        tv12Config2.setText("限时销售");
        tv12Config2.setStartGradientBackgroundColor(Color.parseColor("#87CEFA"));
        tv12Config2.setEndGradientBackgroundColor(Color.parseColor("#00BFFF"));
        tv12Config2.setStrokeWidth(DensityUtilKt.getDp(1));
        tv12Config2.setStrokeColor(Color.parseColor("#FF4500"));
        tv12Config2.setTextColor(Color.parseColor("#FF4500"));
        tv12Config2.setTextSize((float) DensityUtilKt.getSp(10));
        tv12Config2.setMarginLeft(DensityUtilKt.getDp(10));
        tv12Config2.setMarginRight(DensityUtilKt.getDp(5));
        tv12Config2.setLeftPadding(DensityUtilKt.getDp(10));
        tv12Config2.setRightPadding(DensityUtilKt.getDp(10));
        tv12Config2.setTopPadding(DensityUtilKt.getDp(5));
        tv12Config2.setBottomPadding(DensityUtilKt.getDp(5));
        tv12Config2.setLeftTopRadius(DensityUtilKt.getDp(5));
        tv12Config2.setLeftBottomRadius(DensityUtilKt.getDp(10));
        tv12Config2.setRightTopRadius(DensityUtilKt.getDp(2));
        tv12Config2.setRightBottomRadius(DensityUtilKt.getDp(5));
        tv12Config2.setPosition(6);


        TextViewExKt.addTag(findViewById(R.id.text_tv12), tv12Config, () -> {
            Toast.makeText(JavaActivity.this, "新品图标被点击了", Toast.LENGTH_SHORT).show();
            return null;
        });
        TextViewExKt.addTag(findViewById(R.id.text_tv12), tv12Config1);
        TextViewExKt.addTag(findViewById(R.id.text_tv12), tv12Config2);

        //1.13 支持自定义View
        View view = LayoutInflater.from(this).inflate(R.layout.custom_text_view, null);
        TextViewExKt.addTag(findViewById(R.id.text_tv13), view, 5);

        //1.14 替换指定字符串为标签形式
        TextView text_tv14 = findViewById(R.id.text_tv14);
        TagConfig tv14Config = new TagConfig(Type.TEXT);
        tv14Config.setText("超级快充");
        tv14Config.setStartGradientBackgroundColor(Color.parseColor("#ABDCFF"));
        tv14Config.setEndGradientBackgroundColor(Color.parseColor("#0396FF"));
        tv14Config.setRadius((float) DensityUtilKt.getDp(5));
        tv14Config.setAlign(Align.CENTER);
        TextViewExKt.replaceTag(text_tv14, "超级快充", tv14Config, true, () -> {
            Toast.makeText(JavaActivity.this, "超级快充被点击了", Toast.LENGTH_SHORT).show();
            return null;
        });

        TagConfig tv14Config1 = new TagConfig(Type.TEXT);
        tv14Config1.setText("移动5G");
        tv14Config1.setStartGradientBackgroundColor(Color.parseColor("#FEC163"));
        tv14Config1.setEndGradientBackgroundColor(Color.parseColor("#DE4313"));
        tv14Config1.setMarginLeft(DensityUtilKt.getDp(20));
        tv14Config1.setAlign(Align.BASELINE);
        TextViewExKt.replaceTag(text_tv14, 40, 48, tv14Config1);

        View view1 = LayoutInflater.from(this).inflate(R.layout.custom_tag_view, null);
        TextViewExKt.replaceTag(text_tv14, "荣耀", view1,true,Align.TOP);


        //1.15 对齐方式,底部对齐
        TextView text_tv15 = findViewById(R.id.text_tv15);
        TagConfig tv15Config = new TagConfig(Type.TEXT);
        tv15Config.setText("有问题？");
        tv15Config.setAlign(Align.TOP);
        tv15Config.setDrawableZoomType(DrawableZoomType.CUSTOM);
        tv15Config.setWidth(DensityUtilKt.getDp(70));
        tv15Config.setHeight(DensityUtilKt.getDp(50));
        tv15Config.setStartGradientBackgroundColor(Color.parseColor("#FFA07A"));
        tv15Config.setEndGradientBackgroundColor(Color.parseColor("#FF0040"));
        tv15Config.setPosition(text_tv15.getText().toString().length());
        TextViewExKt.addTag(text_tv15, tv15Config, () -> {
            Toast.makeText(JavaActivity.this, "这里是解释", Toast.LENGTH_LONG).show();
            return null;
        });

        //1.16 自定义背景图片
        TextView text_tv16 = findViewById(R.id.text_tv16);
        TagConfig tv16Config = new TagConfig(Type.TEXT);
        tv16Config.setText("新品");
        tv16Config.setLeftTopRadius(DensityUtilKt.getDp(10));
        tv16Config.setWidth(DensityUtilKt.getDp(40));
        tv16Config.setHeight(DensityUtilKt.getDp(20));
        tv16Config.setBackgroundDrawable(ContextCompat.getDrawable(this, R.mipmap.custom_img));
        TextViewExKt.addTag(text_tv16,tv16Config);

        //1.18 自定义字体
        TextView text_tv18 = findViewById(R.id.text_tv18);
        TagConfig tv18Config = new TagConfig(Type.TEXT);
        tv18Config.setText("520折扣");
        tv18Config.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/DIN-Bold.otf"));
        tv18Config.setWidth(DensityUtilKt.getDp(80));
        tv18Config.setHeight(DensityUtilKt.getDp(20));
        tv18Config.setBackgroundDrawable(ContextCompat.getDrawable(this, R.mipmap.custom_img));
        TextViewExKt.addTag(text_tv18,tv18Config);
    }

    /**
     * 2.图片标签样式(type=Type.IMAGE)
     */
    private void imageStyle() {
        //2.1 默认样式
        TagConfig tv1Config = new TagConfig(Type.IMAGE);
        tv1Config.setImageResource(R.mipmap.icon_new1);
        TextViewExKt.addTag(findViewById(R.id.image_tv1), tv1Config, () -> {
            Toast.makeText(JavaActivity.this, "被点击了", Toast.LENGTH_SHORT).show();
            return null;
        });

        //2.2 自定义大小
        TagConfig tv2Config = new TagConfig(Type.IMAGE);
        tv2Config.setImageResource(R.mipmap.icon_new2);
        tv2Config.setDrawableZoomType(DrawableZoomType.CUSTOM);
        tv2Config.setWidth(DensityUtilKt.getDp(80));
        tv2Config.setHeight(DensityUtilKt.getDp(40));
        TextViewExKt.addTag(findViewById(R.id.image_tv2), tv2Config);

        //2.3 自定义边距
        TagConfig tv3Config = new TagConfig(Type.IMAGE);
        tv3Config.setImageResource(R.mipmap.icon_new3);
        tv3Config.setMarginLeft(DensityUtilKt.getDp(15));
        tv3Config.setMarginRight(DensityUtilKt.getDp(10));
        TextViewExKt.addTag(findViewById(R.id.image_tv3), tv3Config);

        //2.4 自定义对齐方式,底部对齐
        TagConfig tv4Config = new TagConfig(Type.IMAGE);
        tv4Config.setImageResource(R.mipmap.icon_new1);
        tv4Config.setDrawableZoomType(DrawableZoomType.CUSTOM);
        tv4Config.setHeight(DensityUtilKt.getDp(15));
        tv4Config.setWidth(DensityUtilKt.getDp(100));
        tv4Config.setAlign(Align.BOTTOM);
        TextViewExKt.addTag(findViewById(R.id.image_tv4), tv4Config);

        //2.5 自定义位置
        TagConfig tv5Config = new TagConfig(Type.IMAGE);
        tv5Config.setImageResource(R.mipmap.icon_new3);
        tv5Config.setPosition(5);
        TextViewExKt.addTag(findViewById(R.id.image_tv5), tv5Config);

        //2.6 支持多个图片
        TagConfig tv6Config = new TagConfig(Type.IMAGE);
        tv6Config.setImageResource(R.mipmap.icon_new1);
        TagConfig tv6Config1 = new TagConfig(Type.IMAGE);
        tv6Config1.setImageResource(R.mipmap.icon_new2);
        tv6Config1.setPosition(5);
        TagConfig tv6Config2 = new TagConfig(Type.IMAGE);
        tv6Config2.setImageResource(R.mipmap.icon_new3);
        tv6Config2.setPosition(11);

        TextViewExKt.addTag(findViewById(R.id.image_tv6), tv6Config);
        TextViewExKt.addTag(findViewById(R.id.image_tv6), tv6Config1);
        TextViewExKt.addTag(findViewById(R.id.image_tv6), tv6Config2);


        //图片在顶部
        TextView tv7 = findViewById(R.id.image_tv7);
        TagConfig tv7Config = new TagConfig(Type.IMAGE);
        tv7Config.setAlign(Align.TOP);
        tv7Config.setImageResource(R.mipmap.question);
        tv7Config.setMarginLeft(DensityUtilKt.getDp(10));
        tv7Config.setPosition(tv7.getText().toString().length());
        TextViewExKt.addTag(tv7, tv7Config, () -> {
            Toast.makeText(JavaActivity.this, "你要问什么问题呢", Toast.LENGTH_LONG).show();
            return null;
        });
    }

    /**
     * 3.文本+图片 标签样式(type=Type.TEXT_IMAGE)
     */
    private void textImageStyle() {
        //3.1 默认样式
        TagConfig tv1Config = new TagConfig(Type.TEXT_IMAGE);
        tv1Config.setText("钻石会员");
        tv1Config.setImageResource(R.mipmap.icon_1);
        TextViewExKt.addTag(findViewById(R.id.text_image_tv1), tv1Config, () -> {
            Toast.makeText(JavaActivity.this, "被点击了", Toast.LENGTH_SHORT).show();
            return null;
        });

        //3.2 设置图片在文字的那个方向
        TagConfig tv2Config = new TagConfig(Type.TEXT_IMAGE);
        tv2Config.setText("支持钱包支付");
        tv2Config.setImageResource(R.mipmap.icon_3);
        tv2Config.setImageAlignText(Orientation.TOP);
        tv2Config.setTextMarginImage(DensityUtilKt.getDp(10));
        tv2Config.setImageWidth(DensityUtilKt.getDp(40));
        tv2Config.setImageHeight(DensityUtilKt.getDp(40));
        tv2Config.setStartGradientBackgroundColor(Color.parseColor("#FFA07A"));
        tv2Config.setEndGradientBackgroundColor(Color.parseColor("#FF0040"));
        TextViewExKt.addTag(findViewById(R.id.text_image_tv2), tv2Config);

        //3.3 设置图片大小
        TagConfig tv3Config = new TagConfig(Type.TEXT_IMAGE);
        tv3Config.setText("支持触控");
        tv3Config.setImageResource(R.mipmap.icon_4);
        tv3Config.setRadius((float) DensityUtilKt.getDp(5));
        tv3Config.setImageWidth(DensityUtilKt.getDp(10));
        tv3Config.setImageHeight(DensityUtilKt.getDp(10));
        tv3Config.setStartGradientBackgroundColor(Color.parseColor("#87CEFA"));
        tv3Config.setEndGradientBackgroundColor(Color.parseColor("#00BFFF"));
        tv3Config.setTextColor(Color.parseColor("#FF0040"));
        tv3Config.setTextSize((float) DensityUtilKt.getSp(12));
        tv3Config.setMarginRight(DensityUtilKt.getDp(10));
        TextViewExKt.addTag(findViewById(R.id.text_image_tv3), tv3Config);

        //3.4 设置图片和文字的距离
        TagConfig tv4Config = new TagConfig(Type.TEXT_IMAGE);
        tv4Config.setText("支持钱包支付");
        tv4Config.setImageResource(R.mipmap.icon_3);
        tv4Config.setStartGradientBackgroundColor(Color.parseColor("#FFA07A"));
        tv4Config.setEndGradientBackgroundColor(Color.parseColor("#FF0040"));
        tv4Config.setTextMarginImage(DensityUtilKt.getDp(10));
        TextViewExKt.addTag(findViewById(R.id.text_image_tv4), tv4Config);

        //3.5 自定义显示位置
        TagConfig tv5Config = new TagConfig(Type.TEXT_IMAGE);
        tv5Config.setText("绑定");
        tv5Config.setImageResource(R.mipmap.icon_5);
        AppCompatTextView text_image_tv5 = findViewById(R.id.text_image_tv5);
        tv5Config.setPosition(text_image_tv5.getText().length());
        tv5Config.setStartGradientBackgroundColor(Color.parseColor("#FFA07A"));
        tv5Config.setEndGradientBackgroundColor(Color.parseColor("#FF0040"));
        tv5Config.setTextMarginImage(DensityUtilKt.getDp(4));
        TextViewExKt.addTag(text_image_tv5, tv5Config);

        //3.6 支持多个
        TagConfig tv6Config = new TagConfig(Type.TEXT_IMAGE);
        tv6Config.setText("支持钱包支付");
        tv6Config.setImageResource(R.mipmap.icon_3);
        tv6Config.setPosition(11);
        tv6Config.setStartGradientBackgroundColor(Color.parseColor("#FFA07A"));
        tv6Config.setEndGradientBackgroundColor(Color.parseColor("#FF0040"));
        tv6Config.setTextMarginImage(DensityUtilKt.getDp(10));


        TagConfig tv6Config1 = new TagConfig(Type.TEXT_IMAGE);
        tv6Config1.setText("钻石会员");
        tv6Config1.setImageResource(R.mipmap.icon_1);
        tv6Config1.setPosition(5);
        tv6Config1.setStartGradientBackgroundColor(Color.parseColor("#FFA07A"));
        tv6Config1.setEndGradientBackgroundColor(Color.parseColor("#FF0040"));
        tv6Config1.setTextMarginImage(DensityUtilKt.getDp(4));

        TextViewExKt.addTag(findViewById(R.id.text_image_tv6), tv6Config);
        TextViewExKt.addTag(findViewById(R.id.text_image_tv6), tv6Config1);
    }

    /**
     * 4.网络标签样式(type=Type.URL)
     */
    private void urlStyle() {
        //4.1 默认样式
        TagConfig tv1Config = new TagConfig(Type.URL);
        tv1Config.setImageUrl("https://i.postimg.cc/DyjsBr3v/image.png");
        TextViewExKt.addTag(findViewById(R.id.url_tv1), tv1Config, () -> {
            Toast.makeText(JavaActivity.this, "网络标签被点击了", Toast.LENGTH_SHORT).show();
            return null;
        });

        //4.2 自定义大小
        TagConfig tv2Config = new TagConfig(Type.URL);
        tv2Config.setImageUrl("https://i.postimg.cc/KjjS4SFZ/20130527035844363.png");
        tv2Config.setDrawableZoomType(DrawableZoomType.CUSTOM);
        tv2Config.setImageWidth(DensityUtilKt.getDp(50));
        tv2Config.setImageHeight(DensityUtilKt.getDp(50));
        TextViewExKt.addTag(findViewById(R.id.url_tv2), tv2Config);

        //4.3 支持GIF
        TagConfig tv3Config = new TagConfig(Type.URL);
        tv3Config.setImageUrl("https://i.postimg.cc/1XNYV9gr/20150723102349987.gif");
        TextViewExKt.addTag(findViewById(R.id.url_tv3), tv3Config);

        //4.4 自定义位置
        TagConfig tv4Config = new TagConfig(Type.URL);
        tv4Config.setImageUrl("https://i.postimg.cc/VvNYQSHk/20180317074635221.png");
        tv4Config.setPosition(5);
        TextViewExKt.addTag(findViewById(R.id.url_tv4), tv4Config);

        //4.5 支持多个
        TagConfig tv5Config = new TagConfig(Type.URL);
        tv5Config.setImageUrl("https://i.postimg.cc/28pNrtMf/20140710033452506.png");
        tv5Config.setMarginLeft(DensityUtilKt.getDp(20));
        tv5Config.setMarginRight(DensityUtilKt.getDp(10));

        TagConfig tv5Config1 = new TagConfig(Type.URL);
        tv5Config1.setImageUrl("https://i.postimg.cc/5ydL218z/20130513035745587.gif");
        tv5Config1.setDrawableZoomType(DrawableZoomType.CUSTOM);
        tv5Config1.setPosition(5);
        tv5Config1.setImageWidth(DensityUtilKt.getDp(40));
        tv5Config1.setImageHeight(DensityUtilKt.getDp(50));

        TextViewExKt.addTag(findViewById(R.id.url_tv5), tv5Config);
        TextViewExKt.addTag(findViewById(R.id.url_tv5), tv5Config1);
    }

    /**
     * 5.在XML中使用
     */
    private void xmlStyle() {
        //5.5 只使用View，标签在代码设置
        TagTextView xml_tv5 = findViewById(R.id.xml_tv5);
        TagConfig tv5Config = new TagConfig(Type.TEXT);
        tv5Config.setText("新品");
        tv5Config.setStartGradientBackgroundColor(Color.parseColor("#CE9FFC"));
        tv5Config.setEndGradientBackgroundColor(Color.parseColor("#7367F0"));
        tv5Config.setRadius((float) DensityUtilKt.getDp(10));
        xml_tv5.addTag(tv5Config);

    }

    /**
     * 扩展方法使用
     */
    private void exFun() {

        //设置下划线
        AppCompatTextView ex_tv1 = findViewById(R.id.ex_tv1);
        TextViewExKt.setUnderline(ex_tv1, "荣耀V40轻奢版");//指定字符串，且默认匹配第一个
        TextViewExKt.setUnderline(ex_tv1, "5G", false);//指定字符串，且默认匹配最后一个
        TextViewExKt.setUnderline(ex_tv1, 17, 26, () -> {
            Toast.makeText(this, "17至26下标文字被点击", Toast.LENGTH_SHORT).show();
            return null;
        });
        TextViewExKt.setUnderline(ex_tv1, 27, 30, () -> {
            Toast.makeText(this, "27至30文字下标被点击", Toast.LENGTH_SHORT).show();
            return null;
        });


        //设置删除线
        AppCompatTextView ex_tv2 = findViewById(R.id.ex_tv2);
        TextViewExKt.setDeleteLine(ex_tv2, "荣耀V40轻奢版");//指定字符串，且默认匹配第一个
        TextViewExKt.setDeleteLine(ex_tv2, "5G", false);//指定字符串，且默认匹配最后一个
        TextViewExKt.setDeleteLine(ex_tv2, 17, 26);
        TextViewExKt.setDeleteLine(ex_tv2, 27, 36, Color.RED, () -> {
            Toast.makeText(this, "27至36文字下标被点击", Toast.LENGTH_SHORT).show();
            return null;
        });
        TextViewExKt.setDeleteLine(ex_tv2, "双卡双待手机", false, Color.BLUE, () -> {
            Toast.makeText(this, "27至36文字下标被点击", Toast.LENGTH_SHORT).show();
            return null;
        });


        //指定文本颜色
        AppCompatTextView ex_tv3 = findViewById(R.id.ex_tv3);
        ex_tv3.setOnClickListener(v -> {

        });
        TextViewExKt.setSpecificTextColor(ex_tv3, Color.parseColor("#FF0040"), "荣耀V40轻奢版");//指定字符串，且默认匹配第一个
        TextViewExKt.setSpecificTextColor(ex_tv3, Color.parseColor("#3813C2"), "5G", false);//指定字符串，且默认匹配最后一个
        TextViewExKt.setSpecificTextColor(ex_tv3, Color.parseColor("#FFC600"), "移动联通电信", false, false, () -> {
            Toast.makeText(this, "移动联通电信被点击", Toast.LENGTH_SHORT).show();
            return null;
        });//指定文本，可响应点击事件
        TextViewExKt.setSpecificTextColor(ex_tv3, Color.parseColor("#4C83FF"), 12, 16, false, () -> {
            Toast.makeText(this, "超级快充被点击", Toast.LENGTH_SHORT).show();
            return null;
        });//指定下标，可响应点击事件

        //设置超链
        AppCompatTextView ex_tv4 = findViewById(R.id.ex_tv4);
        ex_tv4.setText("电话链接-邮箱链接-网络链接-短信链接-彩信链接-地图链接");
        TextViewExKt.setURLSpan(ex_tv4, 0, 4, LinkType.TEL.INSTANCE, "10086", Color.parseColor("#FF0040"));//电话链接
        TextViewExKt.setURLSpan(ex_tv4,
                5,
                9,
                LinkType.EMAIL.INSTANCE,
                "10086@mail.com",
                Color.parseColor("#3813C2"),
                true
        );//邮件链接
        TextViewExKt.setURLSpan(
                ex_tv4,
                10,
                14,
                LinkType.HTTP.INSTANCE,
                "http://baidu.com",
                Color.parseColor("#C346C2"),
                true
        );//网络连接
        TextViewExKt.setURLSpan(
                ex_tv4, 15, 19, LinkType.SMS.INSTANCE, "10086", Color.parseColor("#4C83FF"), false);//短信链接
        TextViewExKt.setURLSpan(
                ex_tv4, 20, 24, LinkType.MMS.INSTANCE, "10086", Color.parseColor("#58CFFB"), true);//彩信链接
        TextViewExKt.setURLSpan(
                ex_tv4,
                ex_tv4.getText().length() - 4,
                ex_tv4.getText().length(),
                LinkType.GEO.INSTANCE,
                "10086",
                Color.parseColor("#49C628"),
                true
        );//地图链接

    }

    /**
     * 列表
     */
    private void recyclerViewStyle() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new TestAdapter(this, getData()));
    }

    private List<ItemBean> getData() {
        List<ItemBean> list = new ArrayList<>();

        TagConfig tagConfig1 = new TagConfig(Type.TEXT);
        tagConfig1.setText("新品");
        tagConfig1.setBackgroundColor(Color.parseColor("#FA742B"));
        list.add(new ItemBean(
                "HUAWEI nova 8 SE 6400万高清四摄 支持66W超级快充 6.5英寸OLED大屏 8GB+128GB幻夜黑华为手机 标配无充",
                "https://img14.360buyimg.com/n0/jfs/t1/112159/2/24025/88731/625ed1f3E0c9e092d/bc0200a21ea5ab66.jpg",
                tagConfig1)
        );

        list.add(new ItemBean(
                "华为智选 NZone s7pro 5G手机 【S7 Pro+】星空蓝8+128GB 官方标配",
                "https://img14.360buyimg.com/n0/jfs/t1/144481/18/22264/36775/61ac564cEb081b02c/67f89db3846cbb59.jpg",
                null)
        );

        TagConfig tagConfig3 = new TagConfig(Type.TEXT_IMAGE);
        tagConfig3.setText("钻石用户");
        tagConfig3.setImageResource(R.mipmap.icon_1);
        tagConfig3.setBackgroundColor(Color.parseColor("#FA742B"));
        list.add(new ItemBean(
                "华为智选 NZone s7pro 5G手机 【S7 Pro+】星空蓝8+128GB 官方标配",
                "https://img14.360buyimg.com/n0/jfs/t1/147378/17/24994/68806/623c09b8E25d4d8d6/c98c30744541e85d.jpg",
                tagConfig3)
        );

        list.add(new ItemBean(
                "华为智选 NZone s7pro 5G手机 【S7 Pro+】星空蓝8+128GB 官方标配",
                "https://img14.360buyimg.com/n0/jfs/t1/204262/20/17633/41667/61ac564bEef77131c/4f64d67793fde772.jpg",
                null)
        );

        TagConfig tagConfig5 = new TagConfig(Type.IMAGE);
        tagConfig5.setImageResource(R.mipmap.icon_3);
        tagConfig5.setImageWidth(DensityUtilKt.getDp(20));
        tagConfig5.setImageHeight(DensityUtilKt.getDp(20));
        tagConfig5.setMarginRight(DensityUtilKt.getDp(20));
        list.add(new ItemBean(
                "华为nova8se 麒麟710A芯片 搭载HarmonyOS系统 幻夜黑 8GB+128GB（66W充电套装+耳机套装）",
                "https://img14.360buyimg.com/n0/jfs/t1/132208/19/27529/193053/625d4efdEc356624c/ccf19294cd5ae141.jpg",
                tagConfig5)
        );

        TagConfig tagConfig6 = new TagConfig(Type.TEXT);
        tagConfig6.setText("新品");
        tagConfig6.setRadius((float) DensityUtilKt.getDp(5));
        tagConfig6.setStartGradientBackgroundColor(Color.parseColor("#F6D242"));
        tagConfig6.setEndGradientBackgroundColor(Color.parseColor("#FF52E5"));
        list.add(new ItemBean(
                "华为nova8se 麒麟710A芯片 搭载HarmonyOS系统 幻夜黑 8GB+128GB（66W充电套装+耳机套装）",
                "https://img14.360buyimg.com/n0/jfs/t1/112159/2/24025/88731/625ed1f3E0c9e092d/bc0200a21ea5ab66.jpg",
                tagConfig6)
        );


        return list;
    }

}