package com.power.recyclingcompany.ui.home.recycler;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.util.MultiTypeDelegate;
import com.power.recyclingcompany.R;
import com.power.recyclingcompany.bean.Apply;

import java.util.List;

/**
 * @author power
 * @date 2018/6/15 上午10:16
 * @description: 解决了与实体类（Bean类）耦合的问题，不用强制实体类实现MultiItemEntity接口
 */
public class RecyclerApplyAdapter extends BaseQuickAdapter<Apply,BaseViewHolder> {

    public RecyclerApplyAdapter(@Nullable List<Apply> data) {
        super(data);

        setMultiTypeDelegate(new MultiTypeDelegate<Apply>() {
            @Override
            protected int getItemType(Apply apply) {
                //根据你的实体类来判断布局类型
                return apply.getItemType();
            }
        });

        //设置每种type相对应的布局
        getMultiTypeDelegate()
                .registerItemType(Apply.ALREADY, R.layout.item_recycler_already_apply)
                .registerItemType(Apply.NOT,R.layout.item_recycler_not_apply);

    }

    @Override
    protected void convert(BaseViewHolder helper, Apply item) {
        //根据type进行不同操作
        switch (helper.getItemViewType()){
            case Apply.ALREADY:

                break;
            case Apply.NOT:

                break;
        }
    }
}
