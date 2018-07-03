package com.power.recyclingcompany.ui.home.driver;

import com.power.recyclingcompany.base.BaseContract;
import com.power.recyclingcompany.bean.Apply;

import java.util.List;

/**
 * @author power
 * @date 2018/6/19 下午2:36
 * @description:
 */
public interface DriverApplyContract extends BaseContract{
    void DataSuccess(List<Apply> list);
}
