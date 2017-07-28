package com.ultra.app.adapter.binder;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ultra.adapter.ViewHolder;
import com.ultra.app.R;
import com.ultra.app.adapter.bean.ChatData;

/**
 * Created by qiaofc on 2017/7/28 0028.
 */

public class ChatTextViewBinder extends ChatBaseViewBinder {
    @Override
    protected int getLayout() {
        return R.layout.item_chat_text;
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new ViewHolder(inflater.inflate(R.layout.item_chat_text, null, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull ChatData data) {
        super.onBindViewHolder(holder, data);
        TextView content = holder.getView(R.id.content);
        content.setText(data.getContent());
    }
}
