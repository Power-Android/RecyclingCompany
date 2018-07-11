package com.power.recyclingcompany.ui.home.recycler;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.power.recyclingcompany.R;
import com.power.recyclingcompany.base.BaseActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author power
 * @date 2018-07-10 14:56:55
 * @description: 回收订单页面
 */
public class RecyclerOrderActivity extends BaseActivity<RecyclerOrderContract, RecyclerOrderPresenter>
        implements RecyclerOrderContract{

    @BindView(R.id.title_back_iv)
    ImageView titleBackIv;
    @BindView(R.id.title_content_tv)
    TextView titleContentTv;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_order);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        titleBackIv.setVisibility(View.VISIBLE);
        titleContentTv.setText("回收订单");

        mPresenter.getData();
    }

    @Override
    protected RecyclerOrderPresenter createPresenter() {
        return new RecyclerOrderPresenter();
    }

    @OnClick(R.id.title_back_iv)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void dataSuccess(List<String> list) {
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerOrderAdapter orderAdapter = new RecyclerOrderAdapter(R.layout.item_recycler_order_layout,list);
        recyclerView.setAdapter(orderAdapter);
    }
}
