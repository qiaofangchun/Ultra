package com.ultra.app.adapter;

import android.support.v7.util.DiffUtil;

import com.ultra.app.adapter.bean.ChatData;
import com.ultra.utils.EmptyUtils;

import java.util.List;

/**
 * Created by qiaofc on 2017/7/28 0028.
 */

public class ChatDiffCallBack extends DiffUtil.Callback {

    private List<ChatData> mOldDatas, mNewDatas;

    public ChatDiffCallBack(List<ChatData> mOldDatas, List<ChatData> mNewDatas){
        this.mOldDatas = mOldDatas;
        this.mNewDatas = mNewDatas;
    }

    @Override
    public int getOldListSize() {
        return EmptyUtils.isEmpty(mOldDatas) ? 0 : mOldDatas.size();
    }

    @Override
    public int getNewListSize() {
        return EmptyUtils.isEmpty(mNewDatas) ? 0 : mNewDatas.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        if (mOldDatas.get(oldItemPosition) == mNewDatas.get(newItemPosition)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        if (mOldDatas.get(oldItemPosition).getContent().equals(mNewDatas.get(newItemPosition).getContent())) {
            return true;
        }
        return false;
    }
}
