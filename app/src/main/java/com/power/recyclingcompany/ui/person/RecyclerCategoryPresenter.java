package com.power.recyclingcompany.ui.person;

import com.power.recyclingcompany.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author power
 * @date 2018/6/28 上午11:18
 * @description:
 */
public class RecyclerCategoryPresenter extends BasePresenter<RecyclerCategoryContract> {
    public RecyclerCategoryPresenter() {

    }

    public void requestData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            list.add("");
        }

        getView().dataSuccess(list);
    }
}
