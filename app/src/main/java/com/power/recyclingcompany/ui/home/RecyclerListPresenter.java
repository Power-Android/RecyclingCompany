package com.power.recyclingcompany.ui.home;

import android.support.v7.widget.LinearLayoutManager;

import com.power.recyclingcompany.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author power
 * @date 2018/6/11 下午6:40
 * @description:
 */
public class RecyclerListPresenter extends BasePresenter<RecyclerListConstract> {
    public void listData() {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        getView().DataSuccess(list);
    }
}
