package com.ultra.app.status.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;

import com.ultra.app.R;
import com.ultra.base.BaseActivity;
import com.ultra.statusbar.ImmersionBar;

/**
 * Created by geyifeng on 2017/6/19.
 */

public class WebActivity extends BaseActivity {
    private WebView web;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_web);
        ImmersionBar.with(this)
                .titleBar(R.id.toolbar)
                .keyboardEnable(true)  //解决软键盘与底部输入框冲突问题
                .init();
        web = (WebView) findViewById(R.id.web);
        web.loadUrl("https://github.com/qiaofangchun/Ultra");
    }
}
