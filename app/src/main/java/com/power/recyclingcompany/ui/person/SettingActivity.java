package com.power.recyclingcompany.ui.person;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.power.recyclingcompany.R;
import com.power.recyclingcompany.base.BaseActivity;
import com.power.recyclingcompany.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author power
 * @date 2018-06-28 11:17:14
 * @description: 设置
 */
public class SettingActivity extends BaseActivity {

    @BindView(R.id.title_back_iv)
    ImageView titleBackIv;
    @BindView(R.id.title_content_tv)
    TextView titleContentTv;
    @BindView(R.id.zfmm_rl)
    RelativeLayout zfmmRl;
    @BindView(R.id.dlmm_rl)
    RelativeLayout dlmmRl;
    @BindView(R.id.jcgx_rl)
    RelativeLayout jcgxRl;
    @BindView(R.id.exit_tv)
    TextView exitTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        titleBackIv.setVisibility(View.VISIBLE);
        titleContentTv.setText("设置");
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @OnClick({R.id.title_back_iv, R.id.exit_tv,R.id.zfmm_rl, R.id.dlmm_rl, R.id.jcgx_rl})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back_iv:
                finish();
                break;
            case R.id.exit_tv:
                break;
            case R.id.zfmm_rl:
                startActivity(new Intent(this,PayPWDActivity.class));
                break;
            case R.id.dlmm_rl:
                startActivity(new Intent(this,EditPassWordActivity.class));
                break;
            case R.id.jcgx_rl:
                break;
        }
    }

}
