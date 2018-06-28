package com.overseas.overseas.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.lzy.okgo.model.Response;
import com.overseas.overseas.MyApplication;
import com.overseas.overseas.R;
import com.overseas.overseas.base.BaseActivity;
import com.overseas.overseas.base.LoginActivity;
import com.overseas.overseas.im.ImManager;
import com.overseas.overseas.model.LinkmanBean;
import com.overseas.overseas.presenter.LinkmanPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LianxirenActivity extends BaseActivity implements LinkmanPresenter.LinkmanCallBack, LinkmanAdapter.OnItemClickListener {

    @BindView(R.id.act_linkman_recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.back_img)
    ImageView backImg;

    private LinkmanPresenter presenter;
    private List<Object> mList = new ArrayList<>();
    private LinkmanAdapter adapter;

    private TextView state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lianxiren);
        ButterKnife.bind(this);

        presenter = new LinkmanPresenter(this, this);
        presenter.getLinkmanList();

        state = (TextView) findViewById(R.id.no_more_data);
        state.setText(getString(R.string.no_more_linkman));
        initData();
    }

    private void initData() {
        adapter = new LinkmanAdapter(mList, this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
    }

    @OnClick({R.id.back_img})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_img:
                finish();
                break;
        }
    }

    @Override
    public void getLinkmanList(Response<LinkmanBean> response) {
        if (TextUtils.equals(response.body().getCode(), "201")) {
            startActivity(new Intent(this, LoginActivity.class));
            MyApplication.logOut();
            return;
        }

        mList.clear();

        if (response != null && response.body() != null && response.body().getDatas() != null) {
            if (response.body().getDatas().size() > 0) {
                for (int i = 0; i < response.body().getDatas().size(); i++) {
                    if (response.body().getDatas().get(i).getList() != null && response.body().getDatas().get(i).getList().size() > 0) {
                        mList.add(response.body().getDatas().get(i));
                        for (int j = 0; j < response.body().getDatas().get(i).getList().size(); j++) {
                            mList.add(response.body().getDatas().get(i).getList().get(j));
                        }
                    }
                }
            }

            adapter.notifyDataSetChanged();
        }

        if (mList.size() > 0) {
            state.setVisibility(View.GONE);
        } else {
            state.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void getLinkmanListFail() {
        if (!MyApplication.isNetworkAvailable()) {
            state.setVisibility(View.VISIBLE);
//            state.setText(getString(R.string.no_network));
        }
    }

    @Override
    public void onItemClickListener(LinkmanBean.DatasBean.ListBean bean) {
        ImManager.enterChat(this, bean.getId() + "", bean.getBrokerName(), bean.getPic());
    }

    @Override
    public void onItemDeleteListener(int position, String userId) {
        mList.remove(position);
        adapter.notifyDataSetChanged();
        presenter.deteleLinkman(userId);
    }
}
