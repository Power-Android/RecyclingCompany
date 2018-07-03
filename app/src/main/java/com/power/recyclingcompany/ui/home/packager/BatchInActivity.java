package com.power.recyclingcompany.ui.home.packager;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
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
 * @date 2018-06-25 16:13:15
 * @description: 批量入库页面
 */
public class BatchInActivity extends BaseActivity<BatchInContract, BatchInPresenter> implements BatchInContract {

    @BindView(R.id.title_back_iv)
    ImageView titleBackIv;
    @BindView(R.id.title_content_tv)
    TextView titleContentTv;
    @BindView(R.id.title_code_iv)
    ImageView titleCodeIv;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.query_tv)
    TextView queryTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batch_in);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        titleBackIv.setVisibility(View.VISIBLE);
        titleContentTv.setText("批量入库");
        titleCodeIv.setVisibility(View.VISIBLE);

        mPresenter.requestData();
    }

    @Override
    protected BatchInPresenter createPresenter() {
        return new BatchInPresenter();
    }

    @OnClick({R.id.title_back_iv, R.id.title_code_iv,R.id.query_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back_iv:
                finish();
                break;
            case R.id.title_code_iv:
                break;
            case R.id.query_tv:
                finish();
                break;
        }
    }

    @Override
    public void dataSuccess(List<String> list) {
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        BatchInAdapter batchInAdapter = new BatchInAdapter(R.layout.item_batch_in_layout, list);
        View headerView = LayoutInflater.from(this).inflate(R.layout.header_batch_in, null);
        batchInAdapter.addHeaderView(headerView);
        recyclerView.setAdapter(batchInAdapter);
    }
}
