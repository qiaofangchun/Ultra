package com.ultra.app.adapter.binder;

import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.ultra.adapter.ViewHolder;
import com.ultra.app.R;
import com.ultra.app.adapter.bean.ChatData;

/**
 * Created by qiaofc on 2017/7/28 0028.
 */

public class ChatImageViewBinder extends ChatBaseViewBinder {
    @Override
    protected int getLayout() {
        return R.layout.item_chat_image;
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull ChatData data) {
        super.onBindViewHolder(holder, data);
        ImageView content = holder.getView(R.id.content);
        content.setImageResource(R.mipmap.img);
    }
}
