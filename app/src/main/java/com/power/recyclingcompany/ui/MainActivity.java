package com.power.recyclingcompany.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.power.recyclingcompany.R;
import com.power.recyclingcompany.base.BaseActivity;
import com.power.recyclingcompany.ui.home.driver.DriverApplyActivity;
import com.power.recyclingcompany.ui.home.driver.DriverFBActivity;
import com.power.recyclingcompany.ui.home.driver.DriverInvitationActivity;
import com.power.recyclingcompany.ui.home.order.OrderClearingActivity;
import com.power.recyclingcompany.ui.home.packager.PackageInActivity;
import com.power.recyclingcompany.ui.home.packager.PackageOutActivity;
import com.power.recyclingcompany.ui.home.recycler.RecyclerFBActivity;
import com.power.recyclingcompany.ui.home.recycler.RecyclerApplyActivity;
import com.power.recyclingcompany.ui.home.recycler.RecyclerInvitationAcitivity;
import com.power.recyclingcompany.ui.message.MessageActivity;
import com.power.recyclingcompany.ui.person.PersonCenterActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author power
 * @date 2018/5/29 下午5:53
 * @description:
 */
public class MainActivity extends BaseActivity<MainContract, MainPresenter> implements MainContract {

    @BindView(R.id.title_message_iv)
    ImageView titleMessageIv;
    @BindView(R.id.title_content_tv)
    TextView titleContentTv;
    @BindView(R.id.title_person_iv)
    ImageView titlePersonIv;
    @BindView(R.id.hsryfb_tv)
    TextView hsryfbTv;
    @BindView(R.id.hsrysq_tv)
    TextView hsrysqTv;
    @BindView(R.id.yqhsry_tv)
    TextView yqhsryTv;
    @BindView(R.id.sjryfb_tv)
    TextView sjryfbTv;
    @BindView(R.id.sjrysq_tv)
    TextView sjrysqTv;
    @BindView(R.id.yqsjjr_tv)
    TextView yqsjjrTv;
    @BindView(R.id.ddjs_tv)
    TextView ddjsTv;
    @BindView(R.id.bzdrk_tv)
    TextView bzdrkTv;
    @BindView(R.id.bzdck_tv)
    TextView bzdckTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        titleMessageIv.setVisibility(View.VISIBLE);
        titleContentTv.setText("易换云");
        titlePersonIv.setVisibility(View.VISIBLE);
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @OnClick({R.id.title_message_iv, R.id.title_person_iv, R.id.hsryfb_tv, R.id.hsrysq_tv, R.id.yqhsry_tv,
            R.id.sjryfb_tv, R.id.sjrysq_tv, R.id.yqsjjr_tv, R.id.ddjs_tv, R.id.bzdrk_tv, R.id.bzdck_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_message_iv://消息
                startActivity(new Intent(this, MessageActivity.class));
                break;
            case R.id.title_person_iv://我的
                startActivity(new Intent(this, PersonCenterActivity.class));
                break;
            case R.id.hsryfb_tv://回收人员分布
                startActivity(new Intent(this, RecyclerFBActivity.class));
                break;
            case R.id.hsrysq_tv://回收人员申请
                startActivity(new Intent(this, RecyclerApplyActivity.class));
                break;
            case R.id.yqhsry_tv://邀请回收人员
                startActivity(new Intent(this, RecyclerInvitationAcitivity.class));
                break;
            case R.id.sjryfb_tv://司机人员分布
                startActivity(new Intent(this, DriverFBActivity.class));
                break;
            case R.id.sjrysq_tv://司机人员申请
                startActivity(new Intent(this, DriverApplyActivity.class));
                break;
            case R.id.yqsjjr_tv://邀请司机加入
                startActivity(new Intent(this, DriverInvitationActivity.class));
                break;
            case R.id.ddjs_tv://订单结算
                startActivity(new Intent(this, OrderClearingActivity.class));
                break;
            case R.id.bzdrk_tv://包装袋入库
                startActivity(new Intent(this, PackageInActivity.class));
                break;
            case R.id.bzdck_tv://包装袋出库
                startActivity(new Intent(this, PackageOutActivity.class));
                break;
        }
    }
}
