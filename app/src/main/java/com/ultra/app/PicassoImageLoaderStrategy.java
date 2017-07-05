package com.ultra.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.ultra.app.status.BaseImageLoaderStrategy;
import com.ultra.imageloader.ImageSaveListener;

import java.io.File;

/**
 * Created by qiaofc on 2017/7/5 0005.
 */

public class PicassoImageLoaderStrategy extends BaseImageLoaderStrategy {
    private RequestCreator requestCreator;

    public PicassoImageLoaderStrategy(Context context) {
        super(context);
    }

    @Override
    public void load(Uri uri) {
        requestCreator = Picasso.with(context).load(uri);
    }

    @Override
    public void load(File file) {
        requestCreator = Picasso.with(context).load(file);
    }

    @Override
    public void load(String url) {
        requestCreator = Picasso.with(context).load(url);
    }

    @Override
    public void load(int resourceId) {
        requestCreator = Picasso.with(context).load(resourceId);
    }

    @Override
    public void error(int resourceId) {
        requestCreator.error(resourceId);
    }

    @Override
    public void error(Drawable drawable) {
        requestCreator.error(drawable);
    }

    @Override
    public void placeholder(int resourceId) {
        requestCreator.error(resourceId);
    }

    @Override
    public void placeholder(Drawable drawable) {
        requestCreator.error(drawable);
    }

    @Override
    public void into(ImageView imageView) {
        requestCreator.into(imageView);
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
