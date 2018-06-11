package com.power.recyclingcompany.ui.message;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.power.recyclingcompany.R;
import com.power.recyclingcompany.app.Constant;
import com.power.recyclingcompany.base.BaseActivity;
import com.power.recyclingcompany.bean.EventBean;
import com.power.recyclingcompany.utils.ToastUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MessageActivity extends BaseActivity<MessageContract, MessagePresenter> implements MessageContract,
        BaseQuickAdapter.OnItemClickListener, BaseQuickAdapter.OnItemChildClickListener {

    @BindView(R.id.title_back_iv)
    ImageView titleBackIv;
    @BindView(R.id.title_content_tv)
    TextView titleContentTv;
    @BindView(R.id.peisong_rl)
    RelativeLayout peisongRl;
    @BindView(R.id.shenhe_rl)
    RelativeLayout shenheRl;
    @BindView(R.id.xitong_rl)
    RelativeLayout xitongRl;
    @BindView(R.id.swipe_recycler)
    RecyclerView swipeRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        titleBackIv.setVisibility(View.VISIBLE);
        titleContentTv.setText("我的消息");

        mPresenter.chatData();
    }

    @Override
    protected MessagePresenter createPresenter() {
        return new MessagePresenter();
    }

    @OnClick({R.id.title_back_iv, R.id.peisong_rl, R.id.shenhe_rl, R.id.xitong_rl})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back_iv:
                finish();
                break;
            case R.id.peisong_rl:
                EventBus.getDefault().postSticky(new EventBean(Constant.EventKeys.PEI_SONG));
                startActivity(new Intent(this,MessageTabActivity.class));
                break;
            case R.id.shenhe_rl:
                EventBus.getDefault().postSticky(new EventBean(Constant.EventKeys.SHEN_HE));
                startActivity(new Intent(this,MessageTabActivity.class));
                break;
            case R.id.xitong_rl:
                EventBus.getDefault().postSticky(new EventBean(Constant.EventKeys.XI_TONG));
                startActivity(new Intent(this,MessageTabActivity.class));
                break;
        }
    }

    @Override
    public void chatSuccess(List<String> chatList) {
        swipeRecycler.setNestedScrollingEnabled(false);
        swipeRecycler.setLayoutManager(new LinearLayoutManager(this));
        MessageAdapter messageAdapter = new MessageAdapter(R.layout.item_message_layout,chatList);
        swipeRecycler.setAdapter(messageAdapter);
        messageAdapter.setOnItemClickListener(this);
        messageAdapter.setOnItemChildClickListener(this);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        ToastUtils.showShort("点击了---item"+position);
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        ToastUtils.showShort("点击了删除---item"+position);
    }
}
