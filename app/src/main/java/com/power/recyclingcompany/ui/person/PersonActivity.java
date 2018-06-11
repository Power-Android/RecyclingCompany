package com.power.recyclingcompany.ui.person;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.power.recyclingcompany.R;
import com.power.recyclingcompany.base.BaseActivity;
import com.power.recyclingcompany.utils.SizeUtils;
import com.power.recyclingcompany.view.CircleImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PersonActivity extends BaseActivity<PersonContract, PersonPresenter> implements PersonContract {

    @BindView(R.id.title_back_iv)
    ImageView titleBackIv;
    @BindView(R.id.title_content_tv)
    TextView titleContentTv;
    @BindView(R.id.title_rl)
    RelativeLayout titleRl;
    @BindView(R.id.face_iv)
    CircleImageView faceIv;
    @BindView(R.id.company_tv)
    TextView companyTv;
    @BindView(R.id.faren_tv)
    TextView farenTv;
    @BindView(R.id.hslb_tv)
    TextView hslbTv;
    @BindView(R.id.lbjg_tv)
    TextView lbjgTv;
    @BindView(R.id.yjjy_tv)
    TextView yjjyTv;
    @BindView(R.id.wdyhk_tv)
    TextView wdyhkTv;
    @BindView(R.id.wdxx_tv)
    TextView wdxxTv;
    @BindView(R.id.bzzx_iv)
    TextView bzzxIv;
    @BindView(R.id.gywm_tv)
    TextView gywmTv;
    @BindView(R.id.shezhi_tv)
    TextView shezhiTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        ButterKnife.bind(this);
        initSystemBarTint();
        initView();
    }

    private void initView() {
        int statusBarHeight = SizeUtils.getStatusBarHeight(this);
        SizeUtils.setMargins(titleRl, 0, statusBarHeight, 0, 0);
        titleBackIv.setVisibility(View.VISIBLE);
        titleContentTv.setText("我的");
    }


    @Override
    protected boolean translucentStatusBar() {
        return true;
    }

    @Override
    protected PersonPresenter createPresenter() {
        return new PersonPresenter();
    }

    @OnClick({R.id.title_back_iv, R.id.face_iv, R.id.hslb_tv, R.id.lbjg_tv, R.id.yjjy_tv, R.id.wdyhk_tv, R.id.wdxx_tv, R.id.bzzx_iv, R.id.gywm_tv, R.id.shezhi_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back_iv:
                finish();
                break;
            case R.id.face_iv:
                break;
            case R.id.hslb_tv:
                break;
            case R.id.lbjg_tv:
                break;
            case R.id.yjjy_tv:
                break;
            case R.id.wdyhk_tv:
                break;
            case R.id.wdxx_tv:
                break;
            case R.id.bzzx_iv:
                break;
            case R.id.gywm_tv:
                break;
            case R.id.shezhi_tv:
                break;
        }
    }
}
