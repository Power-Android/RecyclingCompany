package com.power.recyclingcompany.ui.person;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.power.recyclingcompany.R;
import com.power.recyclingcompany.app.Constant;
import com.power.recyclingcompany.base.BaseActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author power
 * @date 2018-06-28 11:13:20
 * @description: 类别价格页面
 */
public class CategoryPriceFormActivity extends BaseActivity<CategoryPriceContract, CategoryPricePresenter>
        implements CategoryPriceContract {

    @BindView(R.id.title_back_iv)
    ImageView titleBackIv;
    @BindView(R.id.title_content_tv)
    TextView titleContentTv;
    @BindView(R.id.title_right_tv)
    TextView titleRightTv;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private CategoryPriceFormAdapter formAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_price);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        titleBackIv.setVisibility(View.VISIBLE);
        titleContentTv.setText("类别价格编辑");
        titleRightTv.setVisibility(View.VISIBLE);
        titleRightTv.setText("编辑");

        mPresenter.requestData();
    }

    @Override
    protected CategoryPricePresenter createPresenter() {
        return new CategoryPricePresenter();
    }

    @OnClick({R.id.title_back_iv, R.id.title_right_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back_iv:
                finish();
                break;
            case R.id.title_right_tv:
                startActivityForResult(new Intent(this,CategoryPriceEditActivity.class), Constant.REQUEST_CODE_CATEGORY);
                break;
        }
    }

    @Override
    public void dataSuccess(final List<String> list) {
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        formAdapter = new CategoryPriceFormAdapter(R.layout.item_category_form_layut,list);
        View headerView = LayoutInflater.from(this).inflate(R.layout.header_category_form,null);
        formAdapter.addHeaderView(headerView);
        recyclerView.setAdapter(formAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constant.REQUEST_CODE_CATEGORY && resultCode == Constant.RESULT_CODE_CATEGORY){
            List<String> list = (List<String>)data.getSerializableExtra("result");
            formAdapter.setNewData(list);
        }
    }
}
