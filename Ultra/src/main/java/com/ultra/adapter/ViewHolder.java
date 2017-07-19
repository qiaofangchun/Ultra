package com.ultra.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * Created by qiaofc on 2016/7/1 0001.
 */
public class ViewHolder extends RecyclerView.ViewHolder {
    private final SparseArray<View> views;

    public ViewHolder(View itemView) {
        super(itemView);
        views = new SparseArray<View>();
    }

    public <T extends View> T getView(int id) {
        View view = views.get(id);
        if (view == null) {
            view = itemView.findViewById(id);
            views.put(id, view);
        }
        return (T) view;
    }
}