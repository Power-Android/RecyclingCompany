package com.power.recyclingcompany.ui.login;

import com.power.recyclingcompany.base.BasePresenter;

/**
 * @author power
 * @date 2018/6/7 上午9:59
 * @description:
 */
public class RigistSecPresenter extends BasePresenter<RigistSecContract>{
    public RigistSecPresenter() {
    }

    public void commit() {
        getView().commitSuccess();
    }
}
