package com.ultra.app.status;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.ultra.app.R;
import com.ultra.base.BaseActivity;
import com.ultra.statusbar.ImmersionBar;

public class ColorActivity extends BaseActivity {
    private View layout;
    private Toolbar toolbar;
    private SeekBar seekBar;
    private TextView textView;
    private Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_color);
        layout = findViewById(R.id.layout);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        seekBar = (SeekBar) findViewById(R.id.seek_bar);
        textView = (TextView) findViewById(R.id.text_view);
        ImmersionBar.with(this)
                .titleBar(toolbar)
                .statusBarColor(R.color.colorPrimary)
                .navigationBarColor(R.color.btn8)
                .init();
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float alpha = (float) progress / 100;
                textView.setText("透明度:" + alpha + "f");
                ImmersionBar.with(ColorActivity.this)
                        .barAlpha(alpha)
                        .statusBarColorTransform(R.color.btn14)
                        .navigationBarColorTransform(R.color.btn3)
                        .addViewSupportTransformColor(toolbar)
                        .addViewSupportTransformColor(btn1, R.color.btn1, R.color.btn4)
                        .addViewSupportTransformColor(btn2, R.color.btn3, R.color.btn12)
                        .addViewSupportTransformColor(btn3, R.color.btn5, R.color.btn10)
                        .addViewSupportTransformColor(layout, R.color.darker_gray, R.color.btn5)
                        .init();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}