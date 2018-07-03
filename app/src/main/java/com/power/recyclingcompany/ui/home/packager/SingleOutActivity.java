package com.power.recyclingcompany.ui.home.packager;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.power.recyclingcompany.R;
import com.power.recyclingcompany.base.BaseActivity;
import com.power.recyclingcompany.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SingleOutActivity extends BaseActivity {

    @BindView(R.id.title_back_iv)
    ImageView titleBackIv;
    @BindView(R.id.title_content_tv)
    TextView titleContentTv;
    @BindView(R.id.title_right_tv)
    TextView titleRightTv;
    @BindView(R.id.driver_code_et)
    EditText driverCodeEt;
    @BindView(R.id.driver_code_iv)
    ImageView driverCodeIv;
    @BindView(R.id.code_et)
    EditText codeEt;
    @BindView(R.id.code_iv)
    ImageView codeIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_out);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        titleBackIv.setVisibility(View.VISIBLE);
        titleContentTv.setText("单品出库");
        titleRightTv.setVisibility(View.VISIBLE);
        titleRightTv.setText("确认出库");
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @OnClick({R.id.title_back_iv, R.id.title_right_tv, R.id.driver_code_iv, R.id.code_iv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back_iv:
                finish();
                break;
            case R.id.title_right_tv:
                finish();
                break;
            case R.id.driver_code_iv:
                break;
            case R.id.code_iv:
                break;
        }
    }
}
