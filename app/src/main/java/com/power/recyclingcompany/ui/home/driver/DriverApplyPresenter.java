package com.power.recyclingcompany.ui.home.driver;

import com.power.recyclingcompany.base.BasePresenter;
import com.power.recyclingcompany.bean.Apply;

import java.util.ArrayList;
import java.util.List;

/**
 * @author power
 * @date 2018/6/19 下午2:37
 * @description:
 */
public class DriverApplyPresenter extends BasePresenter<DriverApplyContract>{
    public DriverApplyPresenter() {

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
