package com.ultra.app.status;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

import com.ultra.app.R;
import com.ultra.statusbar.ImmersionBar;

public class ImgAndColorActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_img_and_color);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        ImmersionBar.with(this)
                .titleBar(toolbar)
                .navigationBarColor(R.color.colorPrimary)
                .fullScreen(true)
                .addTag("PicAndColor")  //给上面参数打标记，以后可以通过标记恢复
                .init();
        findViewById(R.id.btn_color).setOnClickListener(this);
        findViewById(R.id.btn_status_color).setOnClickListener(this);
        findViewById(R.id.btn_navigation_color).setOnClickListener(this);
        ((SeekBar) findViewById(R.id.seek_bar)).setOnSeekBarChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_status_color:
                ImmersionBar.with(this).statusBarColor(R.color.colorAccent).init();
                break;
            case R.id.btn_navigation_color:
                if (ImmersionBar.hasNavigationBar(this))
                    ImmersionBar.with(this).navigationBarColor(R.color.colorAccent).init();
                else
                    Toast.makeText(this, "当前设备没有导航栏", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_color:
                ImmersionBar.with(this).getTag("PicAndColor").init(); //根据tag标记来恢复
                break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        float alpha = (float) progress / 100;
        ImmersionBar.with(this)
                .statusBarColorTransform(R.color.colorPrimary)
                .navigationBarColorTransform(R.color.colorPrimary)
                .addViewSupportTransformColor(toolbar)
                .barAlpha(alpha)
                .init();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
