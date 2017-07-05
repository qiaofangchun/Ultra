package com.ultra.imageloader;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by Administrator on 2017/7/4 0004.
 */
public interface ImageLoaderStrategy {

    void load(Uri uri);

    void load(File file);

    void load(String url);

    void load(int resourceId);

    void error(int resourceId);

    void error(Drawable drawable);

    void placeholder(int resourceId);

    void placeholder(Drawable drawable);

    void into(ImageView view);


    /**
     * 清除硬盘缓存
     *
     * @param context 上下文
     */
    void clearImageDiskCache(final Context context);

    /**
     * 清除内存缓存
     *
     * @param context 上下文
     */
    void clearImageMemoryCache(Context context);

    /**
     * 根据不同的内存状态，来响应不同的内存释放策略
     *
     * @param context
     * @param level
     */
    void trimMemory(Context context, int level);

    /**
     * 获取缓存大小
     *
     * @param context 上下文
     * @return
     */
    String getCacheSize(Context context);

    /**
     * 保存网络图片到本地
     *
     * @param url
     * @param savePath
     * @param saveFileName
     * @param listener
     */
    void saveImage(String url, String savePath, String saveFileName, ImageSaveListener listener);
}
