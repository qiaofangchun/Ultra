package com.ultra.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.squareup.picasso.Picasso;
import com.ultra.imageloader.BaseImageLoaderStrategy;
import com.ultra.imageloader.ImageSaveListener;
import com.ultra.imageloader.ProgressListener;

import java.io.File;

/**
 * Created by qiaofc on 2017/7/5 0005.
 */

public class GlideImageLoaderStrategy extends BaseImageLoaderStrategy {
    private RequestOptions options;
    private GlideRequest requestBuilder;

    @Override
    public void init(Context context) {
        this.context = context;
        options = new RequestOptions();
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
        options.error(resourceId);
    }

    @Override
    public void error(Drawable drawable) {
        options.error(drawable);
    }

    @Override
    public void placeholder(int resourceId) {
        options.error(resourceId);
    }

    @Override
    public void placeholder(Drawable drawable) {
        options.error(drawable);
    }

    @Override

    public void into(ImageView imageView) {
        requestBuilder.apply(options).into(imageView);
    }

    @Override
    public void listener(final ProgressListener listener) {

    }

    @Override
    public void clearImageDiskCache(Context context) {

    }

    @Override
    public void clearImageMemoryCache(Context context) {

    }

    @Override
    public void trimMemory(Context context, int level) {
        GlideApp.get(context).trimMemory(level);
    }

    @Override
    public String getCacheSize(Context context) {
        return null;
    }

    @Override
    public void saveImage(String url, String savePath, String saveFileName, ImageSaveListener listener) {

    }
}
