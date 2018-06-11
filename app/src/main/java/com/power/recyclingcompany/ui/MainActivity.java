package com.power.recyclingcompany.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.power.recyclingcompany.R;
import com.power.recyclingcompany.base.BaseActivity;
import com.power.recyclingcompany.ui.message.MessageActivity;
import com.power.recyclingcompany.ui.person.PersonActivity;

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
                startActivity(new Intent(this,MessageActivity.class));
                break;
            case R.id.title_person_iv://我的
                startActivity(new Intent(this,PersonActivity.class));
                break;
            case R.id.hsryfb_tv:
                break;
            case R.id.hsrysq_tv:
                break;
            case R.id.yqhsry_tv:
                break;
            case R.id.sjryfb_tv:
                break;
            case R.id.sjrysq_tv:
                break;
            case R.id.yqsjjr_tv:
                break;
            case R.id.ddjs_tv:
                break;
            case R.id.bzdrk_tv:
                break;
            case R.id.bzdck_tv:
                break;
        }
    }
}
