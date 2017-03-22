package com.ultra.app.fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ultra.app.R;
import com.ultra.base.BaseFragment;

/**
 * Created by qiaofc on 2017/3/20 0020.
 */

public class TwoFragment extends BaseFragment {
    @Override
    protected void onCreatedView() {
        Log.e("qfc", "2------>初始化数据");
    }

    @Override
    protected View getLayoutView(LayoutInflater inflater, ViewGroup container) {
        Log.e("qfc", "2------>创建View");
        return inflater.inflate(R.layout.fragment_two, container, false);
    }
}