package com.power.recyclingcompany.ui.person;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.power.recyclingcompany.R;
import com.power.recyclingcompany.base.BaseActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author power
 * @date 2018-06-28 11:12:32
 * @description: 回收类别页面
 */
public class RecyclerCategoryActivity extends BaseActivity<RecyclerCategoryContract, RecyclerCategoryPresenter>
        implements RecyclerCategoryContract {

    @BindView(R.id.title_back_iv)
    ImageView titleBackIv;
    @BindView(R.id.title_content_tv)
    TextView titleContentTv;
    @BindView(R.id.title_right_tv)
    TextView titleRightTv;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    public static boolean isEdit;
    private RecyclerCategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_category);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        titleBackIv.setVisibility(View.VISIBLE);
        titleContentTv.setText("主营回收类别");
        titleRightTv.setVisibility(View.VISIBLE);
        titleRightTv.setText("编辑");

        mPresenter.requestData();
    }

    @Override
    protected RecyclerCategoryPresenter createPresenter() {
        return new RecyclerCategoryPresenter();
    }

    @OnClick({R.id.title_back_iv, R.id.title_right_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back_iv:
                finish();
                break;
            case R.id.title_right_tv:
                if (isEdit){
                    titleRightTv.setText("编辑");
                }else {//编辑状态
                    titleRightTv.setText("完成");
                }
                isEdit = !isEdit;
                categoryAdapter.notifyDataSetChanged();
                break;
        }
    }

    @Override
    public void dataSuccess(List<String> list) {
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new GridLayoutManager(this,4));
        categoryAdapter = new RecyclerCategoryAdapter(R.layout.item_recycler_category_layout,list);
        recyclerView.setAdapter(categoryAdapter);
    }
}
