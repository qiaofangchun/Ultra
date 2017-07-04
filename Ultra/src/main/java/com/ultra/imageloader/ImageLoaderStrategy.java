package com.ultra.imageloader;

import android.content.Context;
import android.widget.ImageView;


/**
 * Created by Administrator on 2017/7/4 0004.
 */
public interface ImageLoaderStrategy {

    /**
     * 通过url加载图片，无占位图
     * @param url 网络图片地址
     * @param imageView 图片控件
     */
    void loadImage(String url, ImageView imageView);

    /**
     * 通过资源文件加载图片，无占位图
     * @param res 图片资源文件
     * @param imageView 图片控件
     */
    void loadImage(int res, ImageView imageView);

    /**
     * 通过url加载图片，无占位图，
     * @param url 网络图片地址
     * @param imageView 图片控件
     */
    void loadImageWithAppCxt(String url, ImageView imageView);

    /**
     * 通过资源文件加载图片，无占位图
     * @param res 图片资源文件
     * @param imageView 图片控件
     */
    void loadImageWithAppCxt(int res, ImageView imageView);

    void loadCircleImage(String url, int placeholder, ImageView imageView);

    void loadCircleBorderImage(String url, int placeholder, ImageView imageView, float borderWidth, int borderColor);

    void loadCircleBorderImage(String url, int placeholder, ImageView imageView, float borderWidth, int borderColor, int heightPx, int widthPx);


    void loadImage(String url, int placeholder, ImageView imageView);

    void loadImageWithProgress(String url, ImageView imageView, ProgressListener listener);

    void loadImageWithPrepareCall(String url, ImageView imageView, int placeholder, SourceReadyListener listener);

    void loadGifImage(String url, int placeholder, ImageView imageView);

    void loadGifWithProgress(String url, ImageView imageView, ProgressListener listener);

    void loadGifWithPrepareCall(String url, ImageView imageView, SourceReadyListener listener);

    /**
     * 清除硬盘缓存
     * @param context 上下文
     */
    void clearImageDiskCache(final Context context);

    /**
     * 清除内存缓存
     * @param context 上下文
     */
    void clearImageMemoryCache(Context context);

    /**
     * 根据不同的内存状态，来响应不同的内存释放策略
     * @param context
     * @param level
     */
    void trimMemory(Context context, int level);

    /**
     * 获取缓存大小
     * @param context 上下文
     * @return
     */
    String getCacheSize(Context context);

    /**
     * 保存网络图片到本地
     * @param url
     * @param savePath
     * @param saveFileName
     * @param listener
     */
    void saveImage(String url, String savePath, String saveFileName, ImageSaveListener listener);

}
