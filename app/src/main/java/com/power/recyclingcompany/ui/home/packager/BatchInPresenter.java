package com.power.recyclingcompany.ui.home.packager;

import com.power.recyclingcompany.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author power
 * @date 2018/6/25 下午4:10
 * @description:
 */
public class BatchInPresenter extends BasePresenter<BatchInContract> {
    public BatchInPresenter() {

    }

    public void requestData() {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");

        getView().dataSuccess(list);
    }
}
