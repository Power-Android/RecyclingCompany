package com.power.recyclingcompany.ui.home.packager;

import com.power.recyclingcompany.base.BaseContract;

import java.util.List;

/**
 * @author power
 * @date 2018/6/27 下午2:52
 * @description:
 */
public interface BatchOutContract extends BaseContract{
    void dataSuccess(List<String> list);
}
