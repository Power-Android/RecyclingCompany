package com.power.recyclingcompany.ui.person;

import com.power.recyclingcompany.base.BaseContract;

import java.util.List;

/**
 * @author power
 * @date 2018/6/29 下午4:52
 * @description:
 */
public interface UnBindCardContract extends BaseContract {
    void dataSuccess(List<String> list);
}
