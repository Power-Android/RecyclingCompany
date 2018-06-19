package com.power.recyclingcompany.ui.home.recycler;

import com.power.recyclingcompany.base.BaseContract;
import com.power.recyclingcompany.bean.Apply;

import java.util.List;

/**
 * @author power
 * @date 2018/6/15 上午10:10
 * @description:
 */
public interface RecyclerApplyContract extends BaseContract {
    void DataSuccess(List<Apply> list);
}
