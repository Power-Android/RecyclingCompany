package com.power.recyclingcompany.ui.person;

import com.power.recyclingcompany.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author power
 * @date 2018/6/29 下午4:42
 * @description:
 */
public class BindCardPresenter extends BasePresenter<BindCardContrat> {
    public BindCardPresenter() {

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
