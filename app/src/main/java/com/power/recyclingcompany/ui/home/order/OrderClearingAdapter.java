package com.power.recyclingcompany.ui.home.order;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.power.recyclingcompany.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author power
 * @date 2018/6/25 上午10:34
 * @description:
 */
public class OrderClearingAdapter extends BaseQuickAdapter<String,BaseViewHolder> {

    public OrderClearingAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        RecyclerView itemRecyclerview = helper.getView(R.id.item_recyclerview);
        itemRecyclerview.setNestedScrollingEnabled(false);
        itemRecyclerview.setLayoutManager(new LinearLayoutManager(mContext));
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        OrderClrearingSunAdapter sunAdapter = new OrderClrearingSunAdapter(R.layout.item_order_clearing_sun,list);
        itemRecyclerview.setAdapter(sunAdapter);
    }
}
