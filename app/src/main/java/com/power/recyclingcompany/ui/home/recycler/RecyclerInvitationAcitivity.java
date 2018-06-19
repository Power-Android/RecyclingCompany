package com.power.recyclingcompany.ui.home.recycler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.power.recyclingcompany.R;
import com.power.recyclingcompany.base.BaseActivity;
import com.power.recyclingcompany.utils.RegexUtils;
import com.power.recyclingcompany.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecyclerInvitationAcitivity extends BaseActivity<RecyclerInvitationContract, RecyclerInvitationPresenter>
        implements RecyclerInvitationContract {

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
        setContentView(R.layout.activity_recycler_invitation_acitivity);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    protected RecyclerInvitationPresenter createPresenter() {
        return new RecyclerInvitationPresenter();
    }

    private void initView() {
        titleBackIv.setVisibility(View.VISIBLE);
        titleContentTv.setText("邀请回收人员");
        titleRightTv.setVisibility(View.VISIBLE);
        titleRightTv.setText("邀请记录");
    }

    @OnClick({R.id.title_back_iv, R.id.title_right_tv, R.id.query_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back_iv:
                finish();
                break;
            case R.id.title_right_tv:
                startActivity(new Intent(this,RecyclerRecordActivity.class));
                break;
            case R.id.query_tv:
                if (RegexUtils.isIDCard18(cardNumEt.getText().toString().trim())){
                    finish();
                }else {
                    ToastUtils.showShort("请输入正确的身份证号");
                }
                break;
        }
    }
}
