package com.power.recyclingcompany.ui.home.recycler;

import com.power.recyclingcompany.base.BaseContract;

import java.util.List;

/**
 * @author power
 * @date 2018/6/11 下午6:39
 * @description:
 */
public interface RecyclerListContract extends BaseContract {
    void DataSuccess(List<String> list);
}
