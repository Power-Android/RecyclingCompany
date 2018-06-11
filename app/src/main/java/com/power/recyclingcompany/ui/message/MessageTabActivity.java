package com.power.recyclingcompany.ui.message;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.power.recyclingcompany.R;
import com.power.recyclingcompany.app.Constant;
import com.power.recyclingcompany.base.BaseActivity;
import com.power.recyclingcompany.bean.EventBean;
import com.power.recyclingcompany.utils.ToastUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MessageTabActivity extends BaseActivity<MessageTabContract,MessageTabPresenter>
        implements MessageTabContract, BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.title_back_iv)
    ImageView titleBackIv;
    @BindView(R.id.title_content_tv)
    TextView titleContentTv;
    @BindView(R.id.peisong_tv)
    TextView peisongTv;
    @BindView(R.id.peisong_view)
    View peisongView;
    @BindView(R.id.peisong_rl)
    RelativeLayout peisongRl;
    @BindView(R.id.shenhe_tv)
    TextView shenheTv;
    @BindView(R.id.shenhe_view)
    View shenheView;
    @BindView(R.id.shenhe_rl)
    RelativeLayout shenheRl;
    @BindView(R.id.xitong_tv)
    TextView xitongTv;
    @BindView(R.id.xitong_view)
    View xitongView;
    @BindView(R.id.xitong_rl)
    RelativeLayout xitongRl;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private int msg;
    private List<String> list;
    private MessageTabAdapter messageTabAdapter;


    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void event(EventBean eventBean){
        msg = eventBean.getInt_msg();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_tab);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        initView();
    }

    @Override
    protected MessageTabPresenter createPresenter() {
        return new MessageTabPresenter();
    }

    private void initView() {
        titleBackIv.setVisibility(View.VISIBLE);
        titleContentTv.setText("我的消息");

        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        messageTabAdapter = new MessageTabAdapter(R.layout.item_message_tab_layut,null);
        recyclerView.setAdapter(messageTabAdapter);
        messageTabAdapter.setOnItemClickListener(this);

        mPresenter.message(msg);

        switch (msg){
            case Constant.EventKeys.PEI_SONG:
                initPeisongColor();
                messageTabAdapter.setNewData(list);
                break;
            case Constant.EventKeys.SHEN_HE:
                initShenheColor();
                messageTabAdapter.setNewData(list);
                break;
            case Constant.EventKeys.XI_TONG:
                initXitongColor();
                messageTabAdapter.setNewData(list);
                break;
        }
    }

    @OnClick({R.id.title_back_iv, R.id.peisong_rl, R.id.shenhe_rl, R.id.xitong_rl})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back_iv:
                finish();
                break;
            case R.id.peisong_rl:
                initPeisongColor();
                messageTabAdapter.setNewData(list);
                break;
            case R.id.shenhe_rl:
                initShenheColor();
                messageTabAdapter.setNewData(list);
                break;
            case R.id.xitong_rl:
                initXitongColor();
                messageTabAdapter.setNewData(list);
                break;
        }
    }

    private void initPeisongColor(){
        peisongTv.setTextColor(getResources().getColor(R.color.colorPrimary));
        shenheTv.setTextColor(getResources().getColor(R.color.textcolor));
        xitongTv.setTextColor(getResources().getColor(R.color.textcolor));
        peisongView.setVisibility(View.VISIBLE);
        shenheView.setVisibility(View.GONE);
        xitongView.setVisibility(View.GONE);
    }

    private void initShenheColor(){
        shenheTv.setTextColor(getResources().getColor(R.color.colorPrimary));
        peisongTv.setTextColor(getResources().getColor(R.color.textcolor));
        xitongTv.setTextColor(getResources().getColor(R.color.textcolor));
        shenheView.setVisibility(View.VISIBLE);
        peisongView.setVisibility(View.GONE);
        xitongView.setVisibility(View.GONE);
    }

    private void initXitongColor(){
        xitongTv.setTextColor(getResources().getColor(R.color.colorPrimary));
        shenheTv.setTextColor(getResources().getColor(R.color.textcolor));
        peisongTv.setTextColor(getResources().getColor(R.color.textcolor));
        xitongView.setVisibility(View.VISIBLE);
        shenheView.setVisibility(View.GONE);
        peisongView.setVisibility(View.GONE);
    }

    @Override
    public void messageSuccess(List<String> list) {
        this.list = list;
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        ToastUtils.showShort("点击了---item"+position);
    }
}
