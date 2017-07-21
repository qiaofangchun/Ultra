package com.ultra.app.status.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.ultra.anim.GradientAnim;
import com.ultra.app.R;
import com.ultra.base.BaseActivity;
import com.ultra.statusbar.ImmersionBar;

/**
 * Created by geyifeng on 2017/6/6.
 */

public class ShapeActivity extends BaseActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_shape);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        ImmersionBar.with(this)
                .titleBar(toolbar)
                .init();
        new GradientAnim().onView(toolbar)
                .setTransitionDuration(4000)
                .setBackgroundResource(R.drawable.gradient_anim)
                .start();
    }
}
