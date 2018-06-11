package com.power.recyclingcompany.ui.message;

import com.power.recyclingcompany.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author power
 * @date 2018/6/7 下午4:37
 * @description:
 */
public class MessagePresenter extends BasePresenter<MessageContract>{
    public MessagePresenter() {

    }

    public void chatData() {
        List<String> chatList = new ArrayList<>();
        chatList.add("");
        chatList.add("");
        chatList.add("");
        chatList.add("");
        chatList.add("");

        getView().chatSuccess(chatList);
    }
}
