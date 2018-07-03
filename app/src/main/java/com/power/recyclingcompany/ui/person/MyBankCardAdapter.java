package com.power.recyclingcompany.ui.person;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author power
 * @date 2018/6/29 下午3:53
 * @description:
 */
public class MyBankCardAdapter extends BaseQuickAdapter<String,BaseViewHolder> {

    public MyBankCardAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
