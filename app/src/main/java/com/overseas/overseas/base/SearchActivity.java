package com.overseas.overseas.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.overseas.overseas.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends BaseActivity {

    @BindView(R.id.tv_search)
    TextView tvSearch;
    @BindView(R.id.mrecycler)
    RecyclerView mrecycler;
    @BindView(R.id.back_img)
    ImageView backImg;
    private List<String> mList = new ArrayList();
    private LiebiaoAdapter liebiaoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        if (mList.size() <= 0) {
            mList.add("");
            mList.add("");
            mList.add("");
        }
        mrecycler.setNestedScrollingEnabled(false);
        mrecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        liebiaoAdapter = new LiebiaoAdapter(R.layout.weiliao_item, mList);

    }

    @OnClick({R.id.back_img, R.id.tv_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_img:
                finish();
                break;
            case R.id.tv_search:
                mrecycler.setAdapter(liebiaoAdapter);
                break;
        }
    }

    class LiebiaoAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public LiebiaoAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
        }
    }

}
