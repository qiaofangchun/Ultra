package com.ultra.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import com.ultra.app.status.BaseImageLoaderStrategy;
import com.ultra.imageloader.ImageSaveListener;

import java.io.File;

/**
 * Created by qiaofc on 2017/7/5 0005.
 */

public class GlideImageLoaderStrategy extends BaseImageLoaderStrategy {
    private GlideRequest requestBuilder;

    public GlideImageLoaderStrategy(Context context) {
        super(context);
        requestBuilder = GlideApp.with(context).load("");
    }

    @Override
    public void load(Uri uri) {
        requestBuilder.load(uri);
    }

    @Override
    public void load(File file) {
        requestBuilder.load(file);
    }

    @Override
    public void load(String url) {
        requestBuilder.load(url);
    }

    @Override
    public void load(int resourceId) {
        requestBuilder.load(resourceId);
    }

    @Override
    public void error(int resourceId) {
        requestBuilder.error(resourceId);
    }

    @Override
    public void error(Drawable drawable) {
        requestBuilder.error(drawable);
    }

    @Override
    public void placeholder(int resourceId) {
        requestBuilder.error(resourceId);
    }

    @Override
    public void placeholder(Drawable drawable) {
        requestBuilder.error(drawable);
    }

    @Override

    public void into(ImageView imageView) {
        requestBuilder.into(imageView);
    }

    @Override
    public void clearImageDiskCache(Context context) {

    }

    @Override
    public void clearImageMemoryCache(Context context) {

    }

    @Override
    public void trimMemory(Context context, int level) {

    }

    @Override
    public String getCacheSize(Context context) {
        return null;
    }

    @Override
    public void saveImage(String url, String savePath, String saveFileName, ImageSaveListener listener) {

    }
}
