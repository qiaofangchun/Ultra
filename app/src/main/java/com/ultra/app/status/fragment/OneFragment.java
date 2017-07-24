package com.ultra.app.status.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ultra.app.R;
import com.ultra.base.BaseFragment;
import com.ultra.statusbar.ImmersionBar;

/**
 * Created by qiaofc on 2017/3/20 0020.
 */

public class OneFragment extends BaseFragment {

    @Override
    protected void immersionInit() {
        ImmersionBar.with(this)
                .titleBar(R.id.toolbar, getView())
                .statusBarDarkFont(false)
                .init();
    }

    @Override
    protected void onCreatedView() {

    }

    @Override
    protected View getLayoutView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        return view;
    }
}
