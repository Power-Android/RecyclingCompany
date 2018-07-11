package com.power.recyclingcompany.ui.person;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.power.recyclingcompany.R;
import com.power.recyclingcompany.base.BaseActivity;
import com.power.recyclingcompany.widget.BaseDialog;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BindCardActivity extends BaseActivity<BindCardContrat, BindCardPresenter>
        implements BindCardContrat{

    @BindView(R.id.title_back_iv)
    ImageView titleBackIv;
    @BindView(R.id.title_content_tv)
    TextView titleContentTv;
    @BindView(R.id.card_name_et)
    EditText cardNameEt;
    @BindView(R.id.card_num_et)
    EditText cardNumEt;
    @BindView(R.id.bank_tv)
    TextView bankTv;
    @BindView(R.id.bank_rl)
    RelativeLayout bankRl;
    @BindView(R.id.bind_tv)
    TextView bindTv;
    private BaseDialog mDialog;
    private BaseDialog.Builder mBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_card);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        titleBackIv.setVisibility(View.VISIBLE);
        titleContentTv.setText("绑定银行卡");
    }

    @Override
    protected BindCardPresenter createPresenter() {
        return new BindCardPresenter();
    }

    @OnClick({R.id.title_back_iv, R.id.bank_rl, R.id.bind_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back_iv:
                finish();
                break;
            case R.id.bank_rl:
                mPresenter.getData();
                break;
            case R.id.bind_tv:
                finish();
                break;
        }
    }

    @Override
    public void dataSuccess(List<String> list) {
        showCardDialog(list);
    }

    private void showCardDialog(List<String> list) {
        mBuilder = new BaseDialog.Builder(this);
        mDialog = mBuilder.setViewId(R.layout.dialog_order_card)
                //设置dialogpadding
                .setPaddingdp(0, 0, 0, 0)
                //设置显示位置
                .setGravity(Gravity.BOTTOM)
                //设置动画
                .setAnimation(R.style.bottom_aniamtion)
                //设置dialog的宽高
                .setWidthHeightpx(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                //设置触摸dialog外围是否关闭
                .isOnTouchCanceled(true)
                //设置监听事件
                .builder();
        mDialog.setCancelable(true);
        RecyclerView recyclerView = mDialog.getView(R.id.recyclerView);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        BindCardAdapter bindCardAdapter = new BindCardAdapter(R.layout.item_bind_card_layout,list);
        recyclerView.setAdapter(bindCardAdapter);
        mDialog.show();
    }
}
