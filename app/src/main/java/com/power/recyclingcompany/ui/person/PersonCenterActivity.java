package com.power.recyclingcompany.ui.person;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.power.recyclingcompany.R;
import com.power.recyclingcompany.base.BaseActivity;
import com.power.recyclingcompany.ui.message.MessageActivity;
import com.power.recyclingcompany.utils.SizeUtils;
import com.power.recyclingcompany.view.CircleImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PersonCenterActivity extends BaseActivity<PersonCenterContract, PersonCenterPresenter> implements PersonCenterContract {

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
    protected PersonCenterPresenter createPresenter() {
        return new PersonCenterPresenter();
    }

    @OnClick({R.id.title_back_iv, R.id.face_iv, R.id.hslb_tv, R.id.lbjg_tv, R.id.yjjy_tv, R.id.wdyhk_tv,
            R.id.wdxx_tv, R.id.bzzx_iv, R.id.gywm_tv, R.id.shezhi_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back_iv:
                finish();
                break;
            case R.id.face_iv://公司信息
                startActivity(new Intent(this,PersonInfoActivity.class));
                break;
            case R.id.hslb_tv://回收类别
                startActivity(new Intent(this,RecyclerCategoryActivity.class));
                break;
            case R.id.lbjg_tv://类别价格
                startActivity(new Intent(this,CategoryPriceFormActivity.class));
                break;
            case R.id.yjjy_tv://意见建议
                startActivity(new Intent(this,OpinionActivity.class));
                break;
            case R.id.wdyhk_tv://我的银行卡
                startActivity(new Intent(this,MyBankCardActivity.class));
                break;
            case R.id.wdxx_tv://我的消息
                startActivity(new Intent(this, MessageActivity.class));
                break;
            case R.id.bzzx_iv://帮助中心
                startActivity(new Intent(this,HelpCenterActivity.class));
                break;
            case R.id.gywm_tv://关于我们
                startActivity(new Intent(this,AboutUsActivity.class));
                break;
            case R.id.shezhi_tv://设置
                startActivity(new Intent(this,SettingActivity.class));
                break;
        }
    }
}
