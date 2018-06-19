package com.power.recyclingcompany.ui.home.driver;

import com.power.recyclingcompany.base.BaseContract;
import com.power.recyclingcompany.bean.LatLngBean;

import java.util.List;

/**
 * @author power
 * @date 2018/6/19 上午11:04
 * @description:
 */
public interface DriverFBContract extends BaseContract {
    void dataSuccess(List<LatLngBean> latLngBeanList);
}
