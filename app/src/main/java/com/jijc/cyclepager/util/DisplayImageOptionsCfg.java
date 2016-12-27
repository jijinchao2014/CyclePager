package com.jijc.cyclepager.util;

import com.jijc.cyclepager.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;

/**
 * Created by zhou on 13-12-18.
 */
public class DisplayImageOptionsCfg {

    private static DisplayImageOptionsCfg instance;

    public static DisplayImageOptionsCfg getInstance() {
        if (instance == null) {
            instance = new DisplayImageOptionsCfg();
        }
        return instance;
    }

    public DisplayImageOptions getNoDiskOptions() {
        return new DisplayImageOptions.Builder()
                .cacheInMemory(true).cacheOnDisk(false)
                .considerExifParams(true)
//                .bitmapConfig(Bitmap.Config.ARGB_8888)
                .build();
    }

    public DisplayImageOptions getOptions() {
        return getOptions(R.mipmap.default_bg, new SimpleBitmapDisplayer());
    }

    public DisplayImageOptions getOptions(int res) {
        return getOptions(res, new SimpleBitmapDisplayer());
    }
    
    public DisplayImageOptions getOptions(BitmapDisplayer displayer) {
        return new DisplayImageOptions.Builder()
                .cacheInMemory(true).cacheOnDisc(true)
                .displayer(displayer)
//                .bitmapConfig(Bitmap.Config.ARGB_8888)
                .build();
    }

    public DisplayImageOptions getLocalOptions(BitmapDisplayer displayer) {
        return new DisplayImageOptions.Builder()
                .cacheInMemory(true).cacheOnDisc(true)
                .displayer(displayer)
                .considerExifParams(true)
//                .bitmapConfig(Bitmap.Config.ARGB_8888)
                .build();
    }

    public DisplayImageOptions getOptions(int resLoading, int resLoadFail, BitmapDisplayer displayer) {
        return new DisplayImageOptions.Builder()
                .showImageOnLoading(resLoading)
                .showImageForEmptyUri(resLoadFail)
                .showImageOnFail(resLoadFail)
                .cacheInMemory(true).cacheOnDisk(true)
                .displayer(displayer)
//                .bitmapConfig(Bitmap.Config.ARGB_8888)
                .build();
    }
    public DisplayImageOptions getOptionsWithFail(int resLoadFail, BitmapDisplayer displayer) {
        return new DisplayImageOptions.Builder()
                .showImageForEmptyUri(resLoadFail)
                .showImageOnFail(resLoadFail)
                .cacheInMemory(true).cacheOnDisk(true)
                .displayer(displayer)
//                .bitmapConfig(Bitmap.Config.ARGB_8888)
                .build();
    }

    /**
     * @param res
     * @param displayer RoundedBitmapDisplayer（int roundPixels）设置圆角图片
     *                  FakeBitmapDisplayer（）这个类什么都没做
     *                  FadeInBitmapDisplayer（int durationMillis）设置图片渐显的时间
     *                  SimpleBitmapDisplayer()
     *                  --------------------------------
     *                  imageScaleType:
     *                  EXACTLY :图像将完全按比例缩小的目标大小
     *                  EXACTLY_STRETCHED:图片会缩放到目标大小完全
     *                  IN_SAMPLE_INT:图像将被二次采样的整数倍
     *                  IN_SAMPLE_POWER_OF_2:图片将降低2倍，直到下一减少步骤，使图像更小的目标大小
     *                  NONE:图片不会调整
     * @return
     */
    public DisplayImageOptions getOptions(int res, BitmapDisplayer displayer) {
        return new DisplayImageOptions.Builder()
                .showImageOnLoading(res)
                .showImageForEmptyUri(res)
                .showImageOnFail(res)
                .cacheInMemory(true).cacheOnDisk(true)
                .displayer(displayer)
//                .bitmapConfig(Bitmap.Config.ARGB_8888)
                .build();
    }
}

