package com.power.recyclingcompany.ui.home.recycler;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
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
 * @date 2018-06-19 10:20:04
 * @description: 邀请记录页面
 */
public class RecyclerRecordActivity extends BaseActivity<RecyclerRecordContract, RecyclerRecordPresenter>
        implements RecyclerRecordContract{

    @BindView(R.id.title_back_iv)
    ImageView titleBackIv;
    @BindView(R.id.title_content_tv)
    TextView titleContentTv;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_record);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        titleBackIv.setVisibility(View.VISIBLE);
        titleContentTv.setText("邀请记录");

        mPresenter.requestData();
    }

    @Override
    protected RecyclerRecordPresenter createPresenter() {
        return new RecyclerRecordPresenter();
    }

    @OnClick(R.id.title_back_iv)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void dataSuccess(List<String> list) {
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        RecyclerRecordAdapter recordAdapter = new RecyclerRecordAdapter(R.layout.item_recycler_record,list);
        recyclerView.setAdapter(recordAdapter);
    }
}
