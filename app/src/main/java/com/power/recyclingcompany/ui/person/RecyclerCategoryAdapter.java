package com.power.recyclingcompany.ui.person;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.power.recyclingcompany.R;

import java.util.List;

import static com.power.recyclingcompany.ui.person.RecyclerCategoryActivity.isEdit;

/**
 * @author power
 * @date 2018/6/28 上午11:30
 * @description:
 */
public class RecyclerCategoryAdapter extends BaseQuickAdapter<String,BaseViewHolder> {

    public RecyclerCategoryAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        if (isEdit){
            helper.setVisible(R.id.item_checkbox,true);
        }
        if (!isEdit){
            helper.setVisible(R.id.item_checkbox,false);
        }
    }
}
