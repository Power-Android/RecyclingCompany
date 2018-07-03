package com.power.recyclingcompany.ui.person;

import android.content.Intent;
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
 * @date 2018-06-28 11:14:51
 * @description: 我的银行卡页面
 */
public class MyBankCardActivity extends BaseActivity<MyBankCardContract, MyBankCardPresenter>
        implements MyBankCardContract {

    @BindView(R.id.title_back_iv)
    ImageView titleBackIv;
    @BindView(R.id.title_content_tv)
    TextView titleContentTv;
    @BindView(R.id.title_right_tv)
    TextView titleRightTv;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.add_card_tv)
    TextView addCardTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bank_card);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        titleBackIv.setVisibility(View.VISIBLE);
        titleContentTv.setText("银行卡管理");
        titleRightTv.setVisibility(View.VISIBLE);
        titleRightTv.setText("解绑银行");

        mPresenter.getData();
    }

    @Override
    protected MyBankCardPresenter createPresenter() {
        return new MyBankCardPresenter();
    }

    @OnClick({R.id.title_back_iv, R.id.title_right_tv, R.id.add_card_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back_iv:
                finish();
                break;
            case R.id.title_right_tv:
                startActivity(new Intent(this,UnBindCardActivity.class));
                break;
            case R.id.add_card_tv:
                startActivity(new Intent(this,BindCardActivity.class));
                break;
        }
    }

    @Override
    public void dataSuccess(List<String> list) {
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyBankCardAdapter bankCardAdapter = new MyBankCardAdapter(R.layout.item_bank_card_layout,list);
        recyclerView.setAdapter(bankCardAdapter);
    }
}
