package com.ultra.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ultra.app.adapter.activity.ChatActivity;
import com.ultra.app.network.NetWorkActivity;
import com.ultra.app.status.activity.StatusActivity;
import com.ultra.statusbar.ImmersionBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImmersionBar.with(this)
                .titleBar(toolbar)
                .init();
        findViewById(R.id.adapter).setOnClickListener(this);
        findViewById(R.id.network).setOnClickListener(this);
        findViewById(R.id.status_bar).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.status_bar:
                intent.setClass(this, StatusActivity.class);
                break;
            case R.id.adapter:
                intent.setClass(this, ChatActivity.class);
                break;
            case R.id.network:
                intent.setClass(this, NetWorkActivity.class);
                break;
        }
        startActivity(intent);
    }
}
