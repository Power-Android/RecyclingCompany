package com.power.recyclingcompany.ui.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.power.recyclingcompany.R;
import com.power.recyclingcompany.base.BaseFragment;
import com.power.recyclingcompany.utils.ToastUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author power
 * @date 2018/6/11 上午9:57
 * @description: 回收人员列表
 */
public class RecycleListFragment extends BaseFragment<RecyclerListConstract,RecyclerListPresenter>
        implements RecyclerListConstract, BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.search_tv)
    TextView searchTv;
    @BindView(R.id.search_et)
    EditText searchEt;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    Unbinder unbinder;

    @Override
    protected RecyclerListPresenter createPresenter() {
        return new RecyclerListPresenter();
    }

    @Override
    protected void initLazyData() {

    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler_list, null);
        unbinder = ButterKnife.bind(this, view);
        initData();
        return view;
    }

    private void initData() {
        mPresenter.listData();
    }

    @OnClick(R.id.search_tv)
    public void onSearchTvClicked() {
        ToastUtils.showShort("点击了搜索");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void DataSuccess(List<String> list) {
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        RecyclerListAdapter listAdapter = new RecyclerListAdapter(R.layout.item_home_list,list);
        recyclerView.setAdapter(listAdapter);
        listAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
