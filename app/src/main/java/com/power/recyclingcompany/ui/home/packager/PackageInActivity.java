package com.power.recyclingcompany.ui.home.packager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.power.recyclingcompany.R;
import com.power.recyclingcompany.base.BaseActivity;
import com.power.recyclingcompany.widget.BaseDialog;

import java.util.List;
import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author power
 * @date 2018-06-25 14:26:33
 * @description: 包装袋入库页面
 */
public class PackageInActivity extends BaseActivity<PackageInContract, PackageInPresenter>
        implements PackageInContract {

    @BindView(R.id.title_back_iv)
    ImageView titleBackIv;
    @BindView(R.id.title_more_iv)
    ImageView titleMoreIv;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.title_content_tv)
    TextView titleContentTv;
    private BaseDialog mDialog;
    private BaseDialog.Builder mBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_in);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        titleBackIv.setVisibility(View.VISIBLE);
        titleContentTv.setText("包装袋入库");
        titleMoreIv.setVisibility(View.VISIBLE);

        mPresenter.reuestData();
    }

    @Override
    protected PackageInPresenter createPresenter() {
        return new PackageInPresenter();
    }

    @OnClick({R.id.title_back_iv, R.id.title_more_iv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back_iv:
                finish();
                break;
            case R.id.title_more_iv:
                showMoreDialog();
                break;
        }
    }

    private void showMoreDialog() {
        mBuilder = new BaseDialog.Builder(this);
        mDialog = mBuilder.setViewId(R.layout.dialog_secltor_more)
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
        mDialog.show();
        mDialog.getView(R.id.cancle_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialog.dismiss();
            }
        });
        TextView oneTv = mDialog.getView(R.id.one_tv);
        oneTv.setText("批量入库");
        oneTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialog.dismiss();
                startActivity(new Intent(PackageInActivity.this,BatchInActivity.class));
            }
        });
        TextView twoTv = mDialog.getView(R.id.two_tv);
        twoTv.setText("单品入库");
        twoTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialog.dismiss();
                startActivity(new Intent(PackageInActivity.this,SingleInActivity.class));
            }
        });
    }

    @Override
    public void dataSuccess(List<String> list) {
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PackageInAdapter packageInAdapter = new PackageInAdapter(R.layout.item_package_in_layout,list);
        View headerView = LayoutInflater.from(this).inflate(R.layout.header_package_in,null);
        packageInAdapter.addHeaderView(headerView);
        recyclerView.setAdapter(packageInAdapter);
    }
}
