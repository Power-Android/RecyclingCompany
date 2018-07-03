package com.power.recyclingcompany.ui.home.order;

import com.power.recyclingcompany.base.BaseContract;

import java.util.List;

/**
 * @author power
 * @date 2018/6/25 上午10:36
 * @description:
 */
public interface OrderClearingContract extends BaseContract{
    void dataSuccess(List<String> list);
}
