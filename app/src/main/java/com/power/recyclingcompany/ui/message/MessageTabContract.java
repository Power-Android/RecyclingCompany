package com.power.recyclingcompany.ui.message;

import com.power.recyclingcompany.base.BaseContract;

import java.util.List;

/**
 * @author power
 * @date 2018/6/8 上午9:53
 * @description:
 */
public interface MessageTabContract extends BaseContract {
    void messageSuccess(List<String> list);
}
