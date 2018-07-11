package com.power.recyclingcompany.ui.home.recycler;

import com.power.recyclingcompany.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author power
 * @date 2018/7/10 下午2:57
 * @description:
 */
public class RecyclerOrderPresenter extends BasePresenter<RecyclerOrderContract> {
    public RecyclerOrderPresenter() {

    }

    public void getData() {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");

        getView().dataSuccess(list);
    }
}
