package com.power.recyclingcompany.ui.home.packager;

import com.power.recyclingcompany.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author power
 * @date 2018/6/25 下午2:27
 * @description:
 */
public class PackageInPresenter extends BasePresenter<PackageInContract> {
    public PackageInPresenter() {

    }

    public void reuestData() {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");

        getView().dataSuccess(list);
    }
}
