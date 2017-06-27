package com.ultra.app.status;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.SeekBar;

import com.ultra.app.R;
import com.ultra.statusbar.ImmersionBar;

public class ImgAndColorActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_and_color);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        ImmersionBar.with(this).titleBar(toolbar).init();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((SeekBar)findViewById(R.id.seek_bar)).setOnSeekBarChangeListener(this);
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
