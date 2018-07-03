package com.power.recyclingcompany.ui.home.driver;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author power
 * @date 2018/6/19 下午5:26
 * @description:
 */
public class DriverRecordAdapter extends BaseQuickAdapter<String,BaseViewHolder> {

    public DriverRecordAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
