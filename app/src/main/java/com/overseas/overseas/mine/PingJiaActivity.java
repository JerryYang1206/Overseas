package com.overseas.overseas.mine;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.overseas.overseas.R;
import com.overseas.overseas.base.BaseActivity;
import com.overseas.overseas.view.LetterSpacingTextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PingJiaActivity extends BaseActivity {

    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.recycler_liebiao)
    RecyclerView recyclerLiebiao;
    private List<String> mList=new ArrayList();
    private LiebiaoAdapter mLiebiaoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ping_jia);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        if (mList.size()<=0){
            mList.add("");
            mList.add("");
            mList.add("");
            mList.add("");
            mList.add("");
        }
        if (mLiebiaoAdapter == null) {
            mLiebiaoAdapter = new LiebiaoAdapter(R.layout.liebiao_item,mList);
        }
        recyclerLiebiao.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerLiebiao.setNestedScrollingEnabled(false);
        recyclerLiebiao.setAdapter(mLiebiaoAdapter);
    }
    class LiebiaoAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public LiebiaoAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
            super(layoutResId,data);
        }

        @Override
        protected void convert(BaseViewHolder helper,String item) {
            LetterSpacingTextView tv_content = helper.getView(R.id.tv_content);
            tv_content.setSpacing(5);
            tv_content.setText("活动内容展示,活动内容展示,活动内容展示活动内容展示活动内容展示，活动内容展示活动内容展示");
        }
    }
    @OnClick(R.id.back_img)
    public void onClick() {
        finish();
    }
}
