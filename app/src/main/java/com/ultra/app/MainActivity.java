package com.ultra.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ultra.app.status.ActionBarActivity;
import com.ultra.app.status.StatusActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
            case R.id.network:
                intent.setClass(this, NetWorkActivity.class);
                break;
        }
        startActivity(intent);
    }
}
