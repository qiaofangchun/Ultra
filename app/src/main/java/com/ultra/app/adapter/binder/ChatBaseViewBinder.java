package com.ultra.app.adapter.binder;

import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ultra.adapter.ItemViewBinder;
import com.ultra.adapter.ViewHolder;
import com.ultra.app.R;
import com.ultra.app.adapter.bean.ChatData;

/**
 * Created by qiaofc on 2017/7/28 0028.
 */

public abstract class ChatBaseViewBinder extends ItemViewBinder<ChatData, ViewHolder> {
    protected abstract int getLayout();

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new ViewHolder(inflater.inflate(getLayout(), null, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull ChatData data) {
        LinearLayout layout = holder.getView(R.id.layout);
        TextView userName = holder.getView(R.id.user_name);
        ImageView userHeader = holder.getView(R.id.user_head);
        LinearLayout.LayoutParams nameLp = (LinearLayout.LayoutParams) userName.getLayoutParams();
        RelativeLayout.LayoutParams layLp = (RelativeLayout.LayoutParams) layout.getLayoutParams();
        RelativeLayout.LayoutParams headLp = (RelativeLayout.LayoutParams) userHeader.getLayoutParams();
        if (data.getDirection() == 0) {  //左边
            nameLp.gravity = Gravity.LEFT;

            headLp.removeRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            headLp.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);

            layLp.removeRule(RelativeLayout.LEFT_OF);
            layLp.addRule(RelativeLayout.RIGHT_OF, R.id.user_head);

        } else {  // 右边
            nameLp.gravity = Gravity.RIGHT;

            headLp.removeRule(RelativeLayout.ALIGN_PARENT_LEFT);
            headLp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);

            layLp.removeRule(RelativeLayout.RIGHT_OF);
            layLp.addRule(RelativeLayout.LEFT_OF, R.id.user_head);
        }
        userName.setLayoutParams(nameLp);
        userHeader.setLayoutParams(headLp);
        layout.setLayoutParams(layLp);
    }
}
