package com.power.recyclingcompany.ui.person;

import com.power.recyclingcompany.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author power
 * @date 2018/6/29 下午3:07
 * @description:
 */
public class MyBankCardPresenter extends BasePresenter<MyBankCardContract> {
    public MyBankCardPresenter() {

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
