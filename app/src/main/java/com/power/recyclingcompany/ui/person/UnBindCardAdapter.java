package com.power.recyclingcompany.ui.person;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author power
 * @date 2018/7/2 上午9:45
 * @description:
 */
public class UnBindCardAdapter extends BaseQuickAdapter<String,BaseViewHolder> {

    public UnBindCardAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
