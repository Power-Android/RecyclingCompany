package com.power.recyclingcompany.ui.person;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.power.recyclingcompany.R;
import com.power.recyclingcompany.app.Constant;
import com.power.recyclingcompany.base.BaseActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CategoryPriceEditActivity extends BaseActivity<CategoryPriceContract, CategoryPricePresenter>
        implements CategoryPriceContract {

    @BindView(R.id.title_back_iv)
    ImageView titleBackIv;
    @BindView(R.id.title_content_tv)
    TextView titleContentTv;
    @BindView(R.id.title_right_tv)
    TextView titleRightTv;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private CategoryPriceEditAdapter editAdapter;
    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_price_edit);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        titleBackIv.setVisibility(View.VISIBLE);
        titleContentTv.setText("类别价格编辑");
        titleRightTv.setVisibility(View.VISIBLE);
        titleRightTv.setText("完成");

        mPresenter.requestData();
    }

    @Override
    protected CategoryPricePresenter createPresenter() {
        return new CategoryPricePresenter();
    }

    @Override
    public void dataSuccess(final List<String> list) {
        this.list = list;
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        editAdapter = new CategoryPriceEditAdapter(R.layout.item_category_price_layout,list);
        recyclerView.setAdapter(editAdapter);

        editAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.add_iv:
                        list.add("");
                        adapter.notifyDataSetChanged();
                        break;
                    case R.id.del_iv:
                        if (list.size() > 1){
                            list.remove(position);
                            adapter.notifyDataSetChanged();
                        }
                        break;
                }
            }
        });
    }

    @OnClick({R.id.title_back_iv, R.id.title_right_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back_iv:
                finish();
                break;
            case R.id.title_right_tv:
                Intent intent = new Intent();
                intent.putExtra("result", (Serializable) list);
                setResult(Constant.RESULT_CODE_CATEGORY,intent);
                finish();
                break;
        }
    }
}
