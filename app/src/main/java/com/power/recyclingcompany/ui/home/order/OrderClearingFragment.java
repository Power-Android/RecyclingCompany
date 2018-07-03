package com.power.recyclingcompany.ui.home.order;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.power.recyclingcompany.R;
import com.power.recyclingcompany.base.BaseFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author power
 * @date 2018/6/19 下午6:36
 * @description:
 */
@SuppressLint("ValidFragment")
public class OrderClearingFragment extends BaseFragment<OrderClearingContract,OrderClearingPresenter>
        implements OrderClearingContract {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    Unbinder unbinder;
    private String position;

    public OrderClearingFragment(String position) {
        this.position = position;
    }

    @Override
    protected OrderClearingPresenter createPresenter() {
        return new OrderClearingPresenter();
    }

    @Override
    protected void initLazyData() {

    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order_clearing, null);
        unbinder = ButterKnife.bind(this, view);
        initData();
        return view;
    }

    private void initData() {
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mPresenter.requestData();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void dataSuccess(List<String> list) {
        OrderClearingAdapter orderClearingAdapter = new OrderClearingAdapter(R.layout.item_order_clearing_layout,list);
        recyclerView.setAdapter(orderClearingAdapter);
    }
}
