package com.ultra.app.status.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.ultra.app.R;
import com.ultra.base.BaseActivity;
import com.ultra.statusbar.ImmersionBar;

/**
 * Created by geyifeng on 2017/5/30.
 */

public class CoordinatorActivity extends BaseActivity {
    private FloatingActionButton fab;
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_coordinator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ImmersionBar.with(this).titleBar(toolbar).init();
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        fab = (FloatingActionButton) findViewById(R.id.fab);
        textView = (TextView) findViewById(R.id.text);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "我是Snackbar", Snackbar.LENGTH_LONG)
                        .show();
            }
        });
        textView.setText("关于Snackbar在4.4和emui3.1上高度显示不准确的问题是由于沉浸式使用了系统的" +
                "WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS或者WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION" +
                "属性造成的，目前尚不知有什么解决办法");
    }
}
