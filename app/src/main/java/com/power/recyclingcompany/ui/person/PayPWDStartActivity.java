package com.power.recyclingcompany.ui.person;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.power.recyclingcompany.R;
import com.power.recyclingcompany.base.BaseActivity;
import com.power.recyclingcompany.base.BasePresenter;
import com.power.recyclingcompany.utils.SendSmsTimerUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PayPWDStartActivity extends BaseActivity {

    @BindView(R.id.title_back_iv)
    ImageView titleBackIv;
    @BindView(R.id.title_content_tv)
    TextView titleContentTv;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_verify)
    EditText etVerify;
    @BindView(R.id.tv_verify)
    TextView tvVerify;
    @BindView(R.id.jump_tv)
    TextView jumpTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_pwdstart);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        titleBackIv.setVisibility(View.VISIBLE);
        titleContentTv.setText("验证手机号");
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @OnClick({R.id.title_back_iv, R.id.tv_verify, R.id.jump_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back_iv:
                finish();
                break;
            case R.id.tv_verify:
                SendSmsTimerUtils.sendSms(tvVerify, R.color.white, R.color.red);
                break;
            case R.id.jump_tv:
                startActivity(new Intent(this,PayPWDActivity.class));
                finish();
                break;
        }
    }
}
