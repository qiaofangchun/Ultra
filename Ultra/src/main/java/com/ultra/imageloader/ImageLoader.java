package com.ultra.imageloader;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by qiaofc on 2017/7/5 0005.
 */

public class ImageLoader {
    private ImageLoaderStrategy strategy;
    private static ImageLoader imageLoader;

    private ImageLoader() {
    }

    public static ImageLoader init(ImageLoaderStrategy strategy) {
        if (imageLoader == null) {
            synchronized (ImageLoader.class) {
                if (imageLoader == null) {
                    imageLoader = new ImageLoader();
                }
            }
        }
        imageLoader.strategy(strategy);
        return imageLoader;
    }

    private ImageLoader strategy(ImageLoaderStrategy strategy) {
        this.strategy = strategy;
        return this;
    }

    public ImageLoader load(Uri uri) {
        strategy.load(uri);
        return this;
    }

    public ImageLoader load(File file) {
        strategy.load(file);
        return this;
    }

    public ImageLoader load(String url) {
        strategy.load(url);
        return this;
    }

    public ImageLoader load(int resourceId) {
        strategy.load(resourceId);
        return this;
    }

    public ImageLoader error(int resourceId) {
        strategy.error(resourceId);
        return this;
    }

    public ImageLoader error(Drawable drawable) {
        strategy.error(drawable);
        return this;
    }

    public ImageLoader placeholder(int resourceId) {
        strategy.placeholder(resourceId);
        return this;
    }

    public ImageLoader placeholder(Drawable drawable) {
        strategy.placeholder(drawable);
        return this;
    }

    public void into(ImageView imageView) {
        strategy.into(imageView);
    }
}