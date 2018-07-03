package com.power.recyclingcompany.ui.home.packager;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author power
 * @date 2018/6/25 下午2:40
 * @description:
 */
public class PackageInAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public PackageInAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
