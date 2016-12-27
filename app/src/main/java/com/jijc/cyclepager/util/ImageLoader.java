package com.jijc.cyclepager.util;

import android.util.Log;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;

import java.io.File;

/**
 * Created by jijc on 16/8/29.
 */
public class ImageLoader {

    private static final String TAG = ImageLoader.class.getSimpleName();
    private final static com.nostra13.universalimageloader.core.ImageLoader imageLoader = com.nostra13.universalimageloader.core.ImageLoader.getInstance();


    public static void loadImageAsync(ImageView imageView, String imageUri) {
        try {
            loadImageAsync(imageView, imageUri, null, null, null);
        } catch (Exception exception) {
            exception.printStackTrace();
            Log.d(TAG, "Image loading exception.");
        }
    }

    public static void loadImageAsync(ImageView imageView, String imageUri, ImageLoadingListener imageLoadingListener) {
        try {
            loadImageAsync(imageView, imageUri, null, imageLoadingListener, null);
        } catch (Exception exception) {
            exception.printStackTrace();
            Log.d(TAG, "Image loading exception.");
        }

    }

    public static void loadImageAsync(String imageUri, ImageLoadingListener imageLoadingListener) {
        try {
            loadImageAsync(null, imageUri, null, imageLoadingListener, null);
        } catch (Exception exception) {
            exception.printStackTrace();
            Log.d(TAG, "Image loading exception.");
        }

    }

    public static void loadImageAsync(String imageUri, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener) {
        try {
            loadImageAsync(null, imageUri, displayImageOptions, imageLoadingListener, null);
        } catch (Exception exception) {
            exception.printStackTrace();
            Log.d(TAG, "Image loading exception.");
        }

    }

    public static void loadImageAsync(ImageView imageView, String imageUri, DisplayImageOptions displayImageOptions) {
        try {
            loadImageAsync(imageView, imageUri, displayImageOptions, null, null);
        } catch (Exception exception) {
            exception.printStackTrace();
            Log.d(TAG, "Image loading exception.");
        }

    }

    public static void loadImageAsync(ImageView imageView, String imageUri, DisplayImageOptions displayImageOptions,
                                      ImageLoadingListener imageLoadingListener) {
        try {
            loadImageAsync(imageView, imageUri, displayImageOptions, imageLoadingListener, null);
        } catch (Exception exception) {
            exception.printStackTrace();
            Log.d(TAG, "Image loading exception.");
        }

    }

    public static void loadImageAsync(ImageView imageView, String imageUri, DisplayImageOptions displayImageOptions,
                                      ImageLoadingListener imageLoadingListener,
                                      ImageLoadingProgressListener progressListener) {
        try {
            if (imageView == null) {
                imageLoader.loadImage(imageUri, displayImageOptions, imageLoadingListener);

            } else {
                imageLoader.displayImage(imageUri, imageView, displayImageOptions, imageLoadingListener, progressListener);

            }        } catch (Exception exception) {
            exception.printStackTrace();
            Log.d(TAG, "Image loading exception.");
        }

    }

    public static File getFile(String fileUrl) {
        return imageLoader.getDiskCache().get(fileUrl);
    }

}
