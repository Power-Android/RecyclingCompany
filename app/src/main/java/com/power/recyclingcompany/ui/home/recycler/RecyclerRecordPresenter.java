package com.power.recyclingcompany.ui.home.recycler;

import com.power.recyclingcompany.R;
import com.power.recyclingcompany.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author power
 * @date 2018/6/19 上午10:21
 * @description:
 */
public class RecyclerRecordPresenter extends BasePresenter<RecyclerRecordContract> {
    public RecyclerRecordPresenter() {

    }

    public void requestData() {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        getView().dataSuccess(list);
    }
}
