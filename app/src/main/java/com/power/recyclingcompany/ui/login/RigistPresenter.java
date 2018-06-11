package com.power.recyclingcompany.ui.login;

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
    }
}
