package com.overseas.overseas.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.lzy.okgo.model.Response;
import com.overseas.overseas.R;
import com.overseas.overseas.base.BaseActivity;
import com.overseas.overseas.im.ImManager;
import com.overseas.overseas.model.ChatSearchBean;
import com.overseas.overseas.presenter.CharSearchPresenter;
import com.overseas.overseas.utils.SoftKeyboardTool;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends BaseActivity implements CharSearchPresenter.ChatSearchCallBack {

    @BindView(R.id.back_img)
    ImageView back;
    @BindView(R.id.tv_search)
    TextView tvSearch;
    @BindView(R.id.search_list_recycler)
    RecyclerView searchListRecycler;
    @BindView(R.id.act_search_manager)
    EditText actSearchManager;
    @BindView(R.id.tv_noContent)
    TextView tvNoContent;
    private List<ChatSearchBean.DatasBean> mList = new ArrayList();
    private SearchListAdapter adapter;

    private int page = 1;

    private CharSearchPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        presenter = new CharSearchPresenter(this, this);

        searchListRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new SearchListAdapter(this, mList);
        searchListRecycler.setAdapter(adapter);

        actSearchManager.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

//                if (s.length() > 0) {
//                    mList.clear();
//                    adapter.setSearchContent(actSearchManager.getText().toString());
//
//                } else {
//                    tvNoContent.setVisibility(View.GONE);
//                    searchListRecycler.setVisibility(View.GONE);
//                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        findViewById(R.id.test_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImManager.enterChat(SearchActivity.this, "", "嘿","");
            }
        });
    }

    @OnClick({R.id.back_img, R.id.tv_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_img:
                SoftKeyboardTool.closeKeyboard(this);
                finish();
                break;
            case R.id.tv_search:
                presenter.getSearchList(page, actSearchManager.getText().toString());
                break;
        }
    }

    @Override
    public void getSearchList(Response<ChatSearchBean> response) {
        if (response != null && response.body() != null && response.body().getDatas() != null) {
            if (response.body().getDatas().size() > 0) {
                mList.addAll(response.body().getDatas());
                searchListRecycler.setVisibility(View.VISIBLE);
                tvNoContent.setVisibility(View.GONE);
            } else {
                tvNoContent.setVisibility(View.VISIBLE);
                searchListRecycler.setVisibility(View.GONE);
            }
            adapter.notifyDataSetChanged();
        }
    }
}
