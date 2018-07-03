package com.power.recyclingcompany.ui.home.driver;

import com.power.recyclingcompany.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author power
 * @date 2018/6/19 下午5:21
 * @description:
 */
public class DriverRecordPresenter extends BasePresenter<DriverRecordContract>{
    public DriverRecordPresenter() {

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
