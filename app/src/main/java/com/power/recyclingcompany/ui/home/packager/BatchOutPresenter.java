package com.power.recyclingcompany.ui.home.packager;

import com.power.recyclingcompany.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author power
 * @date 2018/6/27 下午2:53
 * @description:
 */
public class BatchOutPresenter extends BasePresenter<BatchOutContract>{
    public BatchOutPresenter() {

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
