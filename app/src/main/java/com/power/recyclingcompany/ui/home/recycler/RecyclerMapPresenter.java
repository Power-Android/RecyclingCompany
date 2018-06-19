package com.power.recyclingcompany.ui.home.recycler;

import com.power.recyclingcompany.base.BasePresenter;
import com.power.recyclingcompany.bean.LatLngBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author power
 * @date 2018/6/19 上午10:51
 * @description:
 */
public class RecyclerMapPresenter extends BasePresenter<RecyclerMapContract> {
    public RecyclerMapPresenter() {

    }

    public void requestData() {
        List<LatLngBean> latLngBeanList = new ArrayList<>();
        latLngBeanList.add(new LatLngBean(40.045917,116.297545,"15373228877",""));
        latLngBeanList.add(new LatLngBean(40.046917,116.292945,"15215517733",""));
        latLngBeanList.add(new LatLngBean(40.049917,116.292745,"17611225576",""));
        latLngBeanList.add(new LatLngBean(40.044217,116.296745,"18977665431",""));
        latLngBeanList.add(new LatLngBean(40.048917,116.298455,"13386559327",""));

        getView().dataSuccess(latLngBeanList);
    }
}
