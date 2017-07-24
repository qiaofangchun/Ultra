package com.ultra.app.status.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ultra.app.R;
import com.ultra.base.BaseActivity;
import com.ultra.statusbar.ImmersionBar;

/**
 * Created by geyifeng on 2017/6/2.
 */

public class WhiteStatusBarActivity extends BaseActivity {
    private Button btn;
    private TextView text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_white_bar);
        ImmersionBar.with(this)
                .titleBar(R.id.toolbar)
                .init();
        btn = (Button) findViewById(R.id.btn);
        text = (TextView) findViewById(R.id.text);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImmersionBar.with(WhiteStatusBarActivity.this)
                        .statusBarDarkFont(true, 0.2f)
                        .init();
                text.setText("A：重点在于statusBarDarkFont(true,0.2f)这个方法，" +
                        "原理：如果当前设备支持状态栏字体变色，会设置状态栏字体为黑色，" +
                        "如果当前设备不支持状态栏字体变色，会使当前状态栏加上透明度，否则不执行透明度。");
                btn.setVisibility(View.GONE);
            }
        });
    }
}
