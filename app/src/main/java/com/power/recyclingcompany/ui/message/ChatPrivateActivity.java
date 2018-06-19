package com.power.recyclingcompany.ui.message;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.power.recyclingcompany.R;
import com.power.recyclingcompany.base.BaseActivity;
import com.power.recyclingcompany.base.BaseFragment;
import com.power.recyclingcompany.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChatPrivateActivity extends BaseActivity {

    @BindView(R.id.chat_framelayout)
    FrameLayout chatFramelayout;
    private BaseFragment baseFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_private);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        ChatPrivateFragment chatPrivateFragment = new ChatPrivateFragment();
        chatPrivateFragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().add(R.id.chat_framelayout, chatPrivateFragment).commit();
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}
