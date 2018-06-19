package com.power.recyclingcompany.ui.home.recycler;

import com.power.recyclingcompany.base.BaseContract;

import java.util.List;

/**
 * @author power
 * @date 2018/6/19 上午10:21
 * @description:
 */
public interface RecyclerRecordContract extends BaseContract {
    void dataSuccess(List<String> list);
}
