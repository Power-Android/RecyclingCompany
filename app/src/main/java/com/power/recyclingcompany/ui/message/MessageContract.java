package com.power.recyclingcompany.ui.message;

import com.power.recyclingcompany.base.BaseContract;

import java.util.List;

/**
 * @author power
 * @date 2018/6/7 下午4:36
 * @description:
 */
public interface MessageContract extends BaseContract{
    void chatSuccess(List<String> chatList);
}
