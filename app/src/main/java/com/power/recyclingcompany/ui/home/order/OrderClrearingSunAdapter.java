package com.power.recyclingcompany.ui.home.order;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author power
 * @date 2018/6/25 上午10:45
 * @description:
 */
public class OrderClrearingSunAdapter extends BaseQuickAdapter<String,BaseViewHolder>{

    public OrderClrearingSunAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
