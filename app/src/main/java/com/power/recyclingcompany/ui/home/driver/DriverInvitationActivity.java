package com.power.recyclingcompany.ui.home.driver;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.power.recyclingcompany.R;
import com.power.recyclingcompany.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DriverInvitationActivity extends BaseActivity<DriverInvitationContract,DriverInvitationPresenter>
        implements DriverInvitationContract{

    @BindView(R.id.title_back_iv)
    ImageView titleBackIv;
    @BindView(R.id.title_content_tv)
    TextView titleContentTv;
    @BindView(R.id.title_right_tv)
    TextView titleRightTv;
    @BindView(R.id.card_num_et)
    EditText cardNumEt;
    @BindView(R.id.query_tv)
    TextView queryTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_invitation);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        titleBackIv.setVisibility(View.VISIBLE);
        titleContentTv.setText("邀请司机人员");
        titleRightTv.setVisibility(View.VISIBLE);
        titleRightTv.setText("邀请记录");
    }

    @Override
    protected DriverInvitationPresenter createPresenter() {
        return new DriverInvitationPresenter();
    }

    @OnClick({R.id.title_back_iv, R.id.title_right_tv, R.id.query_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back_iv:
                finish();
                break;
            case R.id.title_right_tv:
                startActivity(new Intent(this,DriverRecordActivity.class));
                break;
            case R.id.query_tv:
                finish();
                break;
        }
    }
}
