package com.power.recyclingcompany.ui.home.recycler;

import com.power.recyclingcompany.base.BaseContract;

import java.util.List;

/**
 * @author power
 * @date 2018/7/10 下午2:57
 * @description:
 */
public interface RecyclerOrderContract extends BaseContract {
    void dataSuccess(List<String> list);
}
