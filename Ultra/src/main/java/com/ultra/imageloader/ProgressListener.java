package com.ultra.imageloader;

/**
 * 通知图片加载进度
 * modified by soulrelay
 */
public interface ProgressListener {

    void onLoading(int bytesRead, int contentLength);

    void onFailure(Exception e);

    void onResourceReady(int width, int height);
}
