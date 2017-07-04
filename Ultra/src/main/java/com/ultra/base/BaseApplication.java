package com.ultra.base;

import android.app.Application;

import com.ultra.utils.Utils;

/**
 * Created by Administrator on 2017/3/19 0019.
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}