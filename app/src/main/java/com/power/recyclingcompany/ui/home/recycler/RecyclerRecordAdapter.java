package com.power.recyclingcompany.ui.home.recycler;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author power
 * @date 2018/6/19 上午10:37
 * @description:
 */
public class RecyclerRecordAdapter extends BaseQuickAdapter<String,BaseViewHolder> {

    public RecyclerRecordAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
