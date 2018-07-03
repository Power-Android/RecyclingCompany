package com.power.recyclingcompany.ui.home.order;

import com.power.recyclingcompany.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author power
 * @date 2018/6/25 上午10:36
 * @description:
 */
public class OrderClearingPresenter extends BasePresenter<OrderClearingContract>{
    public void requestData() {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");

        getView().dataSuccess(list);
    }
}
