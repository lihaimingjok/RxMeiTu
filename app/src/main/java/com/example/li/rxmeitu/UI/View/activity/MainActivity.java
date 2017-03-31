package com.example.li.rxmeitu.UI.View.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.li.rxmeitu.Common.AutoLoadRecylerView;
import com.example.li.rxmeitu.Common.DividerItemDecoration;
import com.example.li.rxmeitu.Modle.JokeBean;
import com.example.li.rxmeitu.Presenter.JokePresenter;
import com.example.li.rxmeitu.R;
import com.example.li.rxmeitu.UI.View.JokeView;
import com.example.li.rxmeitu.UI.View.adapter.JokeAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements JokeView, SwipeRefreshLayout.OnRefreshListener, AutoLoadRecylerView.loadMoreListener {

    @Bind(R.id.record_recycleview)
    AutoLoadRecylerView recordRecycleview;
    @Bind(R.id.joke_refresh_layout)
    SwipeRefreshLayout jokeRefreshLayout;
    @Bind(R.id.common_error_txt)
    TextView commonErrorTxt;
    @Bind(R.id.retry_btn)
    Button retryBtn;
    @Bind(R.id.common_error)
    RelativeLayout commonError;
    private JokePresenter jokePresenter;
    private int page = 1;
    private List<JokeBean.ResultEntity.DataEntity> jokelist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initData();
        loadData();
    }
    private LinearLayoutManager linearLayoutManager;
    private void initView() {
        jokeRefreshLayout.setOnRefreshListener(this);
       linearLayoutManager = new LinearLayoutManager(this);
        recordRecycleview.setLayoutManager(linearLayoutManager);
        recordRecycleview.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        recordRecycleview.setLoadMoreListener(this);
    }
    private JokeAdapter jokeAdapter;
    private void initData(){
        jokelist = new ArrayList<>();
        jokeAdapter = new JokeAdapter(this, jokelist);
        recordRecycleview.setAdapter(jokeAdapter);
        jokePresenter = new JokePresenter();
        jokePresenter.attachView(this);
    }
    private void loadData(){
        jokePresenter.loadList(page,20,"5bfaf760871d767c53282a8e5aaa4dd1");
        page++;
    }
    @Override
    public void refresh(List<JokeBean.ResultEntity.DataEntity> list) {
        commonError.setVisibility(View.GONE);
        jokelist.clear();
        jokelist.addAll(list);
        jokeAdapter.notifyDataSetChanged();
        jokeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void loadMore(List<JokeBean.ResultEntity.DataEntity> list) {
        commonError.setVisibility(View.GONE);
        jokelist.addAll(list);
        jokeAdapter.notifyDataSetChanged();
        recordRecycleview.setLoading(false);
    }

    @Override
    public void onRefresh() {
        page = 1;
        loadData();
    }
    @OnClick(R.id.retry_btn)
    void setRetryBtnonClick() {
        onRefresh();
    }

    @Override
    public void onLoadMore() {
        loadData();
    }
}
