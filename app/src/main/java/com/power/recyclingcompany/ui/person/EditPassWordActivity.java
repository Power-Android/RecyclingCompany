package com.power.recyclingcompany.ui.person;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.power.recyclingcompany.R;
import com.power.recyclingcompany.base.BaseActivity;
import com.power.recyclingcompany.base.BasePresenter;
import com.power.recyclingcompany.ui.login.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EditPassWordActivity extends BaseActivity {

    @BindView(R.id.title_back_iv)
    ImageView titleBackIv;
    @BindView(R.id.title_content_tv)
    TextView titleContentTv;
    @BindView(R.id.oldpass_et)
    EditText oldpassEt;
    @BindView(R.id.newpass_et)
    EditText newpassEt;
    @BindView(R.id.querypass_et)
    EditText querypassEt;
    @BindView(R.id.edit_tv)
    TextView editTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_pass_word);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        titleBackIv.setVisibility(View.VISIBLE);
        titleContentTv.setText("修改密码");


    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @OnClick({R.id.title_back_iv, R.id.edit_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back_iv:
                finish();
                break;
            case R.id.edit_tv:
                removeAllActivitys();
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }
}
