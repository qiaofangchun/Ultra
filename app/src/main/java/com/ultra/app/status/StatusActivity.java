package com.ultra.app.status;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ultra.app.NetWorkActivity;
import com.ultra.app.R;
import com.ultra.base.BaseActivity;
import com.ultra.statusbar.ImmersionBar;

public class StatusActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImmersionBar.with(this)
                .titleBar(toolbar)
                .init();
        findViewById(R.id.btn_pic).setOnClickListener(this);
        findViewById(R.id.btn_color).setOnClickListener(this);
        findViewById(R.id.btn_pic_color).setOnClickListener(this);
        findViewById(R.id.btn_action_bar).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_pic_color:
                intent.setClass(this, ImgAndColorActivity.class);
                break;
            case R.id.btn_pic:
                intent.setClass(this, PictureActivity.class);
                break;
            case R.id.btn_color:
                intent.setClass(this, ColorActivity.class);
                break;
            case R.id.btn_shape:
                intent.setClass(this, NetWorkActivity.class);
                break;
            case R.id.btn_swipe_back:
                intent.setClass(this, NetWorkActivity.class);
                break;
            case R.id.btn_fragment:
                intent.setClass(this, NetWorkActivity.class);
                break;
            case R.id.btn_drawer:
                intent.setClass(this, NetWorkActivity.class);
                break;
            case R.id.btn_coordinator:
                intent.setClass(this, NetWorkActivity.class);
                break;
            case R.id.btn_web:
                intent.setClass(this, NetWorkActivity.class);
                break;
            case R.id.btn_action_bar:
                intent.setClass(this, ActionBarActivity.class);
                break;
            case R.id.btn_flyme:
                intent.setClass(this, NetWorkActivity.class);
                break;
            case R.id.btn_over:
                intent.setClass(this, NetWorkActivity.class);
                break;
            case R.id.btn_key_board:
                intent.setClass(this, NetWorkActivity.class);
                break;
            case R.id.btn_white_status_bar:
                intent.setClass(this, NetWorkActivity.class);
                break;
            case R.id.btn_status_hide:
                intent.setClass(this, NetWorkActivity.class);
                break;
            case R.id.btn_navigation_hide:
                intent.setClass(this, NetWorkActivity.class);
                break;
            case R.id.btn_bar_hide:
                intent.setClass(this, NetWorkActivity.class);
                break;
            case R.id.btn_bar_show:
                intent.setClass(this, NetWorkActivity.class);
                break;
            case R.id.btn_full:
                intent.setClass(this, NetWorkActivity.class);
                break;
            case R.id.btn_bar_font_dark:
                intent.setClass(this, NetWorkActivity.class);
                break;
            case R.id.btn_bar_font_light:
                intent.setClass(this, NetWorkActivity.class);
                break;
        }
        startActivity(intent);
    }
}
