package com.ultra.imageloader;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import java.io.File;

/**
 * 图片加载策略基类
 * Created by Administrator on 2017/7/5 0005.
 */

public abstract class BaseImageLoaderStrategy {
    protected Context context;

    /**
     * 初始化第三方加载请求
     *
     * @param context
     */
    public abstract void init(Context context);

    /**
     * 根据图片uri加载
     *
     * @param uri
     */
    public abstract void load(Uri uri);

    /**
     * 根据图片文件加载
     *
     * @param file
     */
    public abstract void load(File file);

    /**
     * 根据图片地址加载
     *
     * @param url
     */
    public abstract void load(String url);

    /**
     * 根据图片资源文件加载
     *
     * @param resourceId
     */
    public abstract void load(int resourceId);

    /**
     * 加载出错占位图
     *
     * @param resourceId 资源文件id
     */
    public abstract void error(int resourceId);

    /**
     * 加载出错占位图
     *
     * @param drawable 自定义drawable
     */
    public abstract void error(Drawable drawable);

    /**
     * 图片加载占位图
     *
     * @param resourceId 资源文件id
     */
    public abstract void placeholder(int resourceId);

    /**
     * 图片加载占位图
     *
     * @param drawable 自定义drawable
     */
    public abstract void placeholder(Drawable drawable);

    /**
     * 开始加载图片
     *
     * @param imageView
     */
    public abstract void into(ImageView imageView);

    /**
     * 加载图片监听
     *
     * @param listener 监听器
     */
    public abstract void listener(ProgressListener listener);

    /**
     * 清除硬盘缓存
     *
     * @param context 上下文
     */
    public abstract void clearImageDiskCache(final Context context);

    /**
     * 清除内存缓存
     *
     * @param context 上下文
     */
    public abstract void clearImageMemoryCache(Context context);

    /**
     * 根据不同的内存状态，来响应不同的内存释放策略
     *
     * @param context 上下文
     * @param level
     */
    public abstract void trimMemory(Context context, int level);

    /**
     * 获取缓存大小
     *
     * @param context 上下文
     * @return
     */
    public abstract String getCacheSize(Context context);

    /**
     * 保存网络图片到本地
     *
     * @param url          图片url
     * @param savePath     保存路径
     * @param saveFileName 保存文件名
     * @param listener     保存监听
     */
    public abstract void saveImage(String url, String savePath, String saveFileName, ImageSaveListener listener);

}
