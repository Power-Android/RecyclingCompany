package com.power.recyclingcompany.ui.person;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.power.recyclingcompany.R;

import java.util.List;

/**
 * @author power
 * @date 2018/6/29 上午9:39
 * @description:
 */
public class CategoryPriceEditAdapter extends BaseQuickAdapter<String,BaseViewHolder> {

    public CategoryPriceEditAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.addOnClickListener(R.id.add_iv)
                .addOnClickListener(R.id.del_iv);
    }
}
