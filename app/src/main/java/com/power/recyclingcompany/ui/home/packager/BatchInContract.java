package com.power.recyclingcompany.ui.home.packager;

import com.power.recyclingcompany.base.BaseContract;

import java.util.List;

/**
 * @author power
 * @date 2018/6/25 下午4:10
 * @description:
 */
public interface BatchInContract extends BaseContract{
    void dataSuccess(List<String> list);
}
