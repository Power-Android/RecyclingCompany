package com.power.recyclingcompany.ui.home.packager;

import com.power.recyclingcompany.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author power
 * @date 2018/6/25 下午3:17
 * @description:
 */
public class PackageOutPresenter extends BasePresenter<PackageOutContract> {
    public PackageOutPresenter() {

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
