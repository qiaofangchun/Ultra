package com.ultra.app.status.fragment;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ultra.app.R;
import com.ultra.base.BaseFragment;

/**
 * Created by qiaofc on 2017/3/20 0020.
 */

public class FourFragment extends BaseFragment {
    private View rootView;
    private RecyclerView recyclerView;

    @Override
    protected void onCreatedView() {
        Log.e("qfc", "4------>初始化数据");
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
    }

    @Override
    protected View getLayoutView(LayoutInflater inflater, ViewGroup container) {
        rootView = inflater.inflate(R.layout.fragment_four, container, false);
        return rootView;
    }
}