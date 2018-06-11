package com.power.recyclingcompany.ui.login;

import com.power.recyclingcompany.base.BasePresenter;

/**
 * @author power
 * @date 2018/6/6 上午9:45
 * @description:
 */
public class LoginPresenter extends BasePresenter<LoginContract> {

    public LoginPresenter() {
    }


    public void login(String userName, String passWord) {
        getView().loginSuccess();
    }
}
