package com.power.recyclingcompany.ui.login;

import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;
import com.power.recyclingcompany.base.BasePresenter;

/**
 * @author power
 * @date 2018/6/6 下午5:12
 * @description:
 */
public class RigistPresenter extends BasePresenter<RigistContract> {
    public RigistPresenter() {
    }

    public void rigist(String userName, String passWord) {
        getView().rigistSuccess();
        //注册失败会抛出HyphenateException
//        try {
//            EMClient.getInstance().createAccount("huishougongsi", "123456");//同步方法
//        } catch (HyphenateException e) {
//            e.printStackTrace();
//        }
    }
}
