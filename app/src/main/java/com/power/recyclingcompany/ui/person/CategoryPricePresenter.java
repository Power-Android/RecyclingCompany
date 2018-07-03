package com.power.recyclingcompany.ui.person;

import com.power.recyclingcompany.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author power
 * @date 2018/6/29 上午9:05
 * @description:
 */
public class CategoryPricePresenter extends BasePresenter<CategoryPriceContract> {
    public CategoryPricePresenter() {

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
