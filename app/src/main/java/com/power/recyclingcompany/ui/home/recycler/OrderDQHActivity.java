package com.power.recyclingcompany.ui.home.recycler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hyphenate.chat.EMMessage;
import com.hyphenate.easeui.EaseConstant;
import com.power.recyclingcompany.R;
import com.power.recyclingcompany.app.Constant;
import com.power.recyclingcompany.base.BaseActivity;
import com.power.recyclingcompany.ui.message.ChatPrivateActivity;
import com.power.recyclingcompany.utils.SPUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author power
 * @date 2018年07月11日10:56:53
 * @description: 待取货订单详情
 */
public class OrderDQHActivity extends BaseActivity<OrderDetailContract, OrderDetailPresenter> {

    @BindView(R.id.title_back_iv)
    ImageView titleBackIv;
    @BindView(R.id.title_content_tv)
    TextView titleContentTv;
    @BindView(R.id.id_tv)
    TextView idTv;
    @BindView(R.id.name_tv)
    TextView nameTv;
    @BindView(R.id.leibie_tv)
    TextView leibieTv;
    @BindView(R.id.siji_tv)
    TextView sijiTv;
    @BindView(R.id.siji_phone_tv)
    TextView sijiPhoneTv;
    @BindView(R.id.juli_tv)
    TextView juliTv;
    @BindView(R.id.address_tv)
    TextView addressTv;
    @BindView(R.id.xiadan_date_tv)
    TextView xiadanDateTv;
    @BindView(R.id.jiedan_date_tv)
    TextView jiedanDateTv;
    @BindView(R.id.feipin_num_tv)
    TextView feipinNumTv;
    @BindView(R.id.feipin_jiage_tv)
    TextView feipinJiageTv;
    @BindView(R.id.lianxi_siji_tv)
    TextView lianxiSijiTv;
    @BindView(R.id.lianxi_huishou_tv)
    TextView lianxiHuishouTv;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_dqh);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        titleBackIv.setVisibility(View.VISIBLE);
        titleContentTv.setText("订单详情");
    }

    @Override
    protected OrderDetailPresenter createPresenter() {
        return new OrderDetailPresenter();
    }

    @OnClick({R.id.title_back_iv, R.id.lianxi_siji_tv, R.id.lianxi_huishou_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back_iv:
                finish();
                break;
            case R.id.lianxi_siji_tv:
                //设置要发送出去的昵称
                SPUtils.getInstance().put(Constant.keys.USERNAME,"Power公司端");
                //设置要发送出去的头像
                SPUtils.getInstance().put(Constant.keys.FACE,"http://img4q.duitang.com/uploads/item/201506/13/20150613215049_xiHNV.jpeg");

                intent = new Intent(this,ChatPrivateActivity.class);
                intent.putExtra(EaseConstant.EXTRA_USER_ID,"test02");
                intent.putExtra(EaseConstant.EXTRA_CHAT_TYPE, EMMessage.ChatType.Chat);
                startActivity(intent);
                break;
            case R.id.lianxi_huishou_tv:
                //设置要发送出去的昵称
                SPUtils.getInstance().put(Constant.keys.USERNAME,"Power公司端");
                //设置要发送出去的头像
                SPUtils.getInstance().put(Constant.keys.FACE,"http://img4q.duitang.com/uploads/item/201506/13/20150613215049_xiHNV.jpeg");

                intent = new Intent(this,ChatPrivateActivity.class);
                intent.putExtra(EaseConstant.EXTRA_USER_ID,"test02");
                intent.putExtra(EaseConstant.EXTRA_CHAT_TYPE, EMMessage.ChatType.Chat);
                startActivity(intent);
                break;
        }
    }
}
