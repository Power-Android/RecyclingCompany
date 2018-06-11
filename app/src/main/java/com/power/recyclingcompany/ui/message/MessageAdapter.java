package com.power.recyclingcompany.ui.message;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.power.recyclingcompany.R;

import java.util.List;

/**
 * @author power
 * @date 2018/6/7 下午5:09
 * @description:
 */
public class MessageAdapter extends BaseQuickAdapter<String,BaseViewHolder> {

    public MessageAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.addOnClickListener(R.id.bottom_wrapper);
    }
}
