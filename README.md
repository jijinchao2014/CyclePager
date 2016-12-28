# CyclePager：自定义的ViewPager
---

### 主要功能点
* 支持无限轮播;
* 可定制指示点;
* 可定制item的布局;
* 可自定义ViewPager切换效果
* 支持item点击;
* 按住停止轮播;
* 抬手继续的功能

### 实现效果
 截得图片比较卡顿，实际效果很流畅滴。

![JiJinchao CyclePage]( https://github.com/jijinchao2014/CyclePager/blob/master/cyclepager.gif?raw=true )

### 如何使用
1.在项目的build.gradle中添加依赖(或者把<a href = "https://github.com/jijinchao2014/CyclePager"><b>代码下载</b></a>后将关键代码复制到自己的项目中)：

	 compile 'com.jijc.cyclepager:cyclepagerlibrary:1.0.2'
2.布局文件中使用CyclePager

    <com.jijc.cyclepagerlibrary.view.CyclePager
     android:id="@+id/viewpager"
     android:layout_width="match_parent"
     android:layout_height="wrap_content"/>
 注意：如果需要添加指示点，则需要使用LinearLayout进行占位，开发者可自定义指示点的形状和显示的位置
 只需要自己调整好布局即可（完整布局如下）

	<?xml version="1.0" encoding="utf-8"?>
	<RelativeLayout
	    xmlns:android="http://schemas.android.com/apk/res/android"
	    xmlns:tools="http://schemas.android.com/tools"
	    android:layout_width="match_parent"
	    android:layout_height="135dp"
	    tools:context="com.jijc.cyclepager.MainActivity">
	    <com.jijc.cyclepagerlibrary.view.CyclePager
	        android:id="@+id/viewpager"
	        android:layout_width="match_parent"
	        android:layout_height="wrap_content"/>
	    <LinearLayout
	        android:visibility="gone"
	        android:id="@+id/ll_point"
	        android:orientation="horizontal"
	        android:layout_width="match_parent"
	        android:gravity="center_vertical|right"
	        android:padding="10dp"
	        android:layout_alignParentBottom="true"
	        android:layout_height="wrap_content">
	    </LinearLayout>
	</RelativeLayout>
3.Activity或者Frgment中初始化CyclePager并按照需求进行一些必要设置

- 设置指示点，如不需要可不调用

    	viewpager.addPoints(mContext, R.drawable.bg_pointer1, ll_point, ListUtils.getSize(imgList));

- CyclePager设置数据,详情参考方法注释

		viewpager.setImages(mContext, imgList, R.layout.item_cycle_pager, new CyclePager.OnItemInitLisenter() {
	            @Override
	            public void initItemView(View view, int position) {
	
	                ImageView iv_img = (ImageView) view.findViewById(R.id.iv_img);
	                TextView tv_play_count = (TextView) view.findViewById(R.id.tv_play_count);
	                tv_play_count.setText("这是第" + (position + 1) + "个图片");
	                Object tag = iv_img.getTag();
	                if (tag == null || !TextUtils.equals((String) tag, imgList.get(position))) {
	                    ImageLoader.loadImageAsync(iv_img, imgList.get(position), DisplayImageOptionsCfg.getInstance().getOptions(R.mipmap.item_live_bg));
	                    iv_img.setTag(imgList.get(position));
	                }
	            }
	
	            @Override
	            public void onItemClick(int position) {
	                Toast.makeText(mContext, "pos:" + (position + 1) + "-url:" + imgList.get(position), Toast.LENGTH_SHORT).show();
	            }
	
	            @Override
	            public void onItemVisible(int position) {
		
	            }
	        }, 6);	
- 设置切换效果，如果想使用默认效果则不必设置

		viewpager.setPageTransformer(new DepthPageTransformer());
- 开启自动轮播并设置轮播间隔，如不需要可不调用

    	viewpager.startRoll(3000);

4.如果启动了自动滚动，开发者想要在某种情况（比如退出页面）停止滚动时可使用如下方法：

		viewpager.stopRoll();