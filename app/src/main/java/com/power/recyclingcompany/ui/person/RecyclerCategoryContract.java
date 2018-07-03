package com.power.recyclingcompany.ui.person;

import com.power.recyclingcompany.base.BaseContract;

import java.util.List;

/**
 * @author power
 * @date 2018/6/28 上午11:18
 * @description:
 */
public interface RecyclerCategoryContract extends BaseContract {
    void dataSuccess(List<String> list);
}
