package com.power.recyclingcompany.ui.login;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.power.recyclingcompany.R;
import com.power.recyclingcompany.base.BaseActivity;
import com.power.recyclingcompany.utils.SendSmsTimerUtils;
import com.power.recyclingcompany.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author power
 * @date 2018-06-06 17:44:36
 * @description: 忘记密码页面
 */
public class ForgetPwdActivity extends BaseActivity<ForgetPwdContract, ForgetPwdPresenter> implements ForgetPwdContract{

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
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.et_again_pwd)
    EditText etAgainPwd;
    @BindView(R.id.tv_reset)
    TextView tvReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pwd);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        titleBackIv.setVisibility(View.VISIBLE);
        titleContentTv.setText("忘记密码");
    }

    @Override
    protected ForgetPwdPresenter createPresenter() {
        return new ForgetPwdPresenter();
    }

    @OnClick({R.id.title_back_iv, R.id.tv_verify, R.id.tv_reset})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back_iv:
                finish();
                break;
            case R.id.tv_verify:
                SendSmsTimerUtils.sendSms(tvVerify, R.color.white, R.color.red);
                break;
            case R.id.tv_reset:
                String phoneNum = etPhone.getText().toString();
                String verifyNum = etVerify.getText().toString();
                String passsword = etPassword.getText().toString();
                String againPwd = etAgainPwd.getText().toString();
                if (TextUtils.isEmpty(phoneNum) || TextUtils.isEmpty(verifyNum)){
                    ToastUtils.showShort("手机号或验证码不能为空");
                    return;
                }
                if (TextUtils.isEmpty(passsword) || TextUtils.isEmpty(passsword)){
                    ToastUtils.showShort("密码不能为空");
                    return;
                }
                if (!TextUtils.equals(passsword,againPwd)){
                    ToastUtils.showShort("密码输入不一致");
                    return;
                }
                mPresenter.reset(phoneNum,verifyNum,passsword);
                break;
        }
    }

    @Override
    public void resetSuccess() {
        finish();
    }
}
