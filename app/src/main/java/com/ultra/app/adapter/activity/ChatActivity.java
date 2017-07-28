package com.ultra.app.adapter.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ultra.adapter.ItemViewBinder;
import com.ultra.adapter.MultiTypeAdapter;
import com.ultra.adapter.OneToManyLinker;
import com.ultra.app.R;
import com.ultra.app.adapter.ChatDiffCallBack;
import com.ultra.app.adapter.bean.ChatData;
import com.ultra.app.adapter.bean.ChatDataType;
import com.ultra.app.adapter.binder.ChatImageViewBinder;
import com.ultra.app.adapter.binder.ChatTextViewBinder;
import com.ultra.base.BaseActivity;
import com.ultra.statusbar.ImmersionBar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiaofc on 2017/7/28 0028.
 */

public class ChatActivity extends BaseActivity implements View.OnClickListener {
    private Button send_content;
    private EditText chat_content;
    private MultiTypeAdapter adapter;
    private RecyclerView recyclerView;
    private List<ChatData> chatDataList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ImmersionBar.with(this)
                .titleBar(R.id.toolbar)
                .keyboardEnable(true)
                .init();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        send_content = (Button) findViewById(R.id.send_content);
        send_content.setOnClickListener(this);
        chat_content = (EditText) findViewById(R.id.chat_content);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        chatDataList = new ArrayList<>();
        adapter = new MultiTypeAdapter(chatDataList);
        recyclerView.setAdapter(adapter);

        adapter.register(ChatData.class).to(
                new ChatTextViewBinder(),
                new ChatImageViewBinder()
        ).withClassLinker(new OneToManyLinker<ChatData>() {
            @NonNull
            @Override
            public Class<? extends ItemViewBinder<ChatData, ?>> index(@NonNull ChatData data) {
                if (data.getType() == ChatDataType.IMAGE) {
                    return ChatImageViewBinder.class;
                } else {
                    return ChatTextViewBinder.class;
                }
            }
        });

        for (int i = 0; i < 10; i++) {
            ChatData data = new ChatData();
            if (Math.random() < 0.6) {
                data.setType(ChatDataType.TEXT);
            } else {
                data.setType(ChatDataType.IMAGE);
            }
            data.setDirection(i % 2);
            data.setContent("聊天内容》》" + i);
            chatDataList.add(data);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_content:
                String content = chat_content.getText().toString();
                if (TextUtils.isEmpty(content)) {
                    return;
                }
                List<ChatData> newData = new ArrayList<>();
                ChatData data = new ChatData();
                data.setContent(content);
                data.setDirection(1);
                data.setType(ChatDataType.TEXT);
                chatDataList.add(data);
                chat_content.setText("");
                chatDataList.get(0).setContent("aaaaaaaaaaaaaa");
                ChatDiffCallBack callBack = new ChatDiffCallBack(chatDataList, null);
                DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(callBack, false);
                diffResult.dispatchUpdatesTo(adapter);
                recyclerView.smoothScrollToPosition(adapter.getItemCount());
                break;
        }
    }
}