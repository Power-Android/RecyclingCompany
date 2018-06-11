package com.power.recyclingcompany.ui.message;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author power
 * @date 2018/6/8 上午10:00
 * @description:
 */
public class MessageTabAdapter extends BaseQuickAdapter<String,BaseViewHolder> {

    public MessageTabAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
