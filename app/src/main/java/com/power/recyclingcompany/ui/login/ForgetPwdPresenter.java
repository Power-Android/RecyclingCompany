package com.power.recyclingcompany.ui.login;

import com.power.recyclingcompany.base.BaseContract;
import com.power.recyclingcompany.base.BasePresenter;

/**
 * @author power
 * @date 2018/6/6 下午5:47
 * @description:
 */
public class ForgetPwdPresenter extends BasePresenter<ForgetPwdContract> {
    public ForgetPwdPresenter() {
    }

    public void reset(String phoneNum, String verifyNum, String passsword) {
        getView().resetSuccess();
    }
}
