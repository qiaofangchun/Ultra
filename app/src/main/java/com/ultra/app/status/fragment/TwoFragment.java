package com.ultra.app.status.fragment;

import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ultra.app.R;
import com.ultra.base.BaseFragment;
import com.ultra.statusbar.ImmersionBar;

/**
 * Created by qiaofc on 2017/3/20 0020.
 */

public class TwoFragment extends BaseFragment {
    private Toolbar toolbar;

    @Override
    protected void immersionInit() {
        ImmersionBar.with(this)
                .titleBar(R.id.toolbar,getView())
                .statusBarDarkFont(false)
                .init();
    }

    @Override
    protected void onCreatedView() {

    }

    @Override
    protected View getLayoutView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        return view;
    }
}