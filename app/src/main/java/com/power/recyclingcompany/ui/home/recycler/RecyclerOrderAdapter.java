package com.power.recyclingcompany.ui.home.recycler;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author power
 * @date 2018/7/10 下午3:01
 * @description:
 */
public class RecyclerOrderAdapter extends BaseQuickAdapter<String,BaseViewHolder> {

    public RecyclerOrderAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
