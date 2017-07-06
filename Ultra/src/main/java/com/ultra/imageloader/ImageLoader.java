package com.ultra.imageloader;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by Administrator on 2017/7/5 0005.
 */

public class ImageLoader {
    private BaseImageLoaderStrategy strategy;
    private static ImageLoader imageLoader;

    private ImageLoader() {
    }

    public static void init(BaseImageLoaderStrategy strategy) {
        if (imageLoader == null) {
            synchronized (ImageLoader.class) {
                if (imageLoader == null) {
                    imageLoader = new ImageLoader();
                }
            }
        }
        imageLoader.strategy = strategy;
    }

    public static ImageLoader get(Context context) {
        if (ImageLoader.imageLoader == null) {
            throw new NullPointerException("you must be first call init method");
        }
        imageLoader.strategy.init(context);
        return ImageLoader.imageLoader;
    }

    public ImageLoader load(Object object) {
        if (object instanceof String) {
            strategy.load((String) object);
        } else if (object instanceof Uri) {
            strategy.load((Uri) object);
        } else if (object instanceof Integer) {
            strategy.load((Integer) object);
        } else if (object instanceof File) {
            strategy.load((File) object);
        } else {
            throw new UnsupportedOperationException(
                    String.format("picture loading mode is not supported for %s",
                            object.getClass().getSimpleName()));
        }
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

    public static void getCacheSize(Context context) {
        imageLoader.strategy.getCacheSize(context);
    }

    public static void saveImage(String url, String savePath, String saveFileName, ImageSaveListener listener) {
        imageLoader.strategy.saveImage(url, savePath, saveFileName, listener);
    }
}