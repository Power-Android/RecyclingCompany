package com.power.recyclingcompany.ui.home.recycler;

import com.power.recyclingcompany.base.BasePresenter;
import com.power.recyclingcompany.bean.Apply;

import java.util.ArrayList;
import java.util.List;

/**
 * @author power
 * @date 2018/6/15 上午10:11
 * @description:
 */
public class RecyclerApplyPresenter extends BasePresenter<RecyclerApplyContract> {

    public RecyclerApplyPresenter() {

    }

    public void requestData() {
        List<Apply> list = new ArrayList<>();
        list.add(new Apply(Apply.ALREADY));
        list.add(new Apply(Apply.NOT));
        list.add(new Apply(Apply.ALREADY));
        list.add(new Apply(Apply.NOT));
        list.add(new Apply(Apply.ALREADY));
        list.add(new Apply(Apply.NOT));

        getView().DataSuccess(list);
    }
}
