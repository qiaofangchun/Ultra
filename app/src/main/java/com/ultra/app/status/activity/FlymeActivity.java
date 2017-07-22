package com.ultra.app.status.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ultra.app.R;
import com.ultra.base.BaseActivity;
import com.ultra.statusbar.ImmersionBar;

/**
 * Created by geyifeng on 2017/5/31.
 */

public class FlymeActivity extends BaseActivity {
    private Button btn;
    private EditText et;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_flyme);
        ImmersionBar.with(this)
                .titleBar(R.id.toolbar)
                .navigationBarColor(R.color.colorPrimary)
                .init();
        et = (EditText) findViewById(R.id.et);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "#" + et.getText().toString();
                if (s.length() == 7)
                    ImmersionBar.with(FlymeActivity.this)
                            .flymeOSStatusBarFontColor(s)
                            .init();
                else
                    Toast.makeText(FlymeActivity.this, "请正确输入6位颜色值", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
