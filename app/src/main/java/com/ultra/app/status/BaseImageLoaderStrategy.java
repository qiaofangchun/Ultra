package com.ultra.app.status;

import android.content.Context;

import com.ultra.imageloader.ImageLoaderStrategy;

/**
 * Created by qiaofc on 2017/7/5 0005.
 */

public abstract class BaseImageLoaderStrategy implements ImageLoaderStrategy {
    protected Context context;

    public BaseImageLoaderStrategy(Context context) {
        this.context = context;
    }
}
