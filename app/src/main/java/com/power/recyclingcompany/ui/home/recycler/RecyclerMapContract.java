package com.power.recyclingcompany.ui.home.recycler;

import com.power.recyclingcompany.base.BaseContract;
import com.power.recyclingcompany.bean.LatLngBean;

import java.util.List;

/**
 * @author power
 * @date 2018/6/19 上午10:51
 * @description:
 */
public interface RecyclerMapContract extends BaseContract {
    void dataSuccess(List<LatLngBean> latLngBeanList);
}
