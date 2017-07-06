package com.ultra.imageloader;

/**
 * 通知图片加载进度
 * Created by Administrator on 2017/7/5 0005.
 */
public interface ProgressListener {

    void onLoading(int bytesRead, int contentLength);

    void onFailure(Exception e);

    void onResourceReady(int width, int height);
}