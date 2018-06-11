package com.power.recyclingcompany.ui.message;

import com.power.recyclingcompany.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author power
 * @date 2018/6/8 上午9:53
 * @description:
 */
public class MessageTabPresenter extends BasePresenter<MessageTabContract> {
    public MessageTabPresenter() {

    }

    public void message(int msg) {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        getView().messageSuccess(list);
    }
}
