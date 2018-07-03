package com.power.recyclingcompany.ui.person;

import com.power.recyclingcompany.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author power
 * @date 2018/7/2 上午10:01
 * @description:
 */
public class HelpCenterPresenter extends BasePresenter<HelpCenterContract> {
    public HelpCenterPresenter() {

    }

    public void getData() {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");

        getView().datSuccess(list);
    }
}
