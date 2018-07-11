package com.power.recyclingcompany.ui.person;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.power.recyclingcompany.R;
import com.power.recyclingcompany.base.BaseActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author power
 * @date 2018-06-28 11:15:41
 * @description: 帮助中心页面
 */
public class HelpCenterActivity extends BaseActivity<HelpCenterContract, HelpCenterPresenter>
        implements HelpCenterContract {

    @BindView(R.id.title_back_iv)
    ImageView titleBackIv;
    @BindView(R.id.title_content_tv)
    TextView titleContentTv;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_center);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        titleBackIv.setVisibility(View.VISIBLE);
        titleContentTv.setText("帮助");

        mPresenter.getData();
    }

    @Override
    protected HelpCenterPresenter createPresenter() {
        return new HelpCenterPresenter();
    }

    @OnClick(R.id.title_back_iv)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void datSuccess(List<String> list) {
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        HelpCenterAdapter helpCenterAdapter = new HelpCenterAdapter(R.layout.item_help_center_layout,list);
        recyclerView.setAdapter(helpCenterAdapter);
        helpCenterAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(HelpCenterActivity.this,HelpDetailActivity.class));
            }
        });
    }
}
