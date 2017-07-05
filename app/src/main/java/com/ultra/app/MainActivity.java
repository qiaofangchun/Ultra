package com.ultra.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.ultra.app.status.ActionBarActivity;
import com.ultra.app.status.StatusActivity;
import com.ultra.imageloader.ImageLoader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.image);
        findViewById(R.id.network).setOnClickListener(this);
        findViewById(R.id.status_bar).setOnClickListener(this);
        ImageLoader.init(new GlideImageLoaderStrategy(this))
                .load("http://p2.sanwen8.com/userimage7/16/0221/22/27905781_201602212217260375262590.jpg")
                .into(imageView);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.status_bar:
                intent.setClass(this, StatusActivity.class);
                break;
            case R.id.network:
                intent.setClass(this, NetWorkActivity.class);
                break;
        }
        startActivity(intent);
    }
}
