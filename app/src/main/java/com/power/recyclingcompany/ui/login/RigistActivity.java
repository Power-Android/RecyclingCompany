package com.power.recyclingcompany.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.power.recyclingcompany.R;
import com.power.recyclingcompany.base.BaseActivity;
import com.power.recyclingcompany.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author power
 * @date 2018-06-06 17:34:33
 * @description: 注册页面
 */
public class RigistActivity extends BaseActivity<RigistContract, RigistPresenter> implements RigistContract{

    @BindView(R.id.title_back_iv)
    ImageView titleBackIv;
    @BindView(R.id.title_content_tv)
    TextView titleContentTv;
    @BindView(R.id.et_user)
    EditText etUser;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.et_again)
    EditText etAgain;
    @BindView(R.id.tv_rigist)
    TextView tvRigist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rigist);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        titleBackIv.setVisibility(View.VISIBLE);
        titleContentTv.setText("注册");
    }

    @Override
    protected RigistPresenter createPresenter() {
        return new RigistPresenter();
    }

    @OnClick({R.id.title_back_iv, R.id.tv_rigist})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back_iv:
                finish();
                break;
            case R.id.tv_rigist:
                String userName = etUser.getText().toString();
                String passWord = etPassword.getText().toString();
                String againPwd = etAgain.getText().toString();
                if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(passWord)){
                    ToastUtils.showShort("用户名或密码不能为空");
                    return;
                }
                if (!TextUtils.equals(passWord,againPwd)){
                    ToastUtils.showShort("密码输入不一致");
                    return;
                }
                mPresenter.rigist(userName,passWord);
                break;
        }
    }

    @Override
    public void rigistSuccess() {
        startActivity(new Intent(this,RigistSecActivity.class));
    }
}
