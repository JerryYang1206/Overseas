package com.overseas.overseas.fragment;

import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.overseas.overseas.R;
import com.overseas.overseas.activity.SearchActivity;
import com.overseas.overseas.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/1/18.
 */
public class WeiChartFragment extends BaseFragment {


    @BindView(R.id.img_search)
    ImageView imgSearch;
//    @BindView(R.id.mrecycler)
//    RecyclerView mrecycler;
    Unbinder unbinder;
    private List<String> mList=new ArrayList();
    private LiebiaoAdapter liebiaoAdapter;

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_weichart, null);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    protected void initData() {
//        mrecycler.setNestedScrollingEnabled(false);
//        mrecycler.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
//        liebiaoAdapter = new LiebiaoAdapter(R.layout.weiliao_item,mList);
//        mrecycler.setAdapter(liebiaoAdapter);
//        liebiaoAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
////                ChatActivity.invoke(getActivity());
//                if (RongIM.getInstance() != null) {
//                    Log.e("MainActivity", "创建单聊");
//                    RongIM.getInstance().startPrivateChat(getActivity(), "123456", "单聊");
//                }
//            }
//        });
    }

    class LiebiaoAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public LiebiaoAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
            super(layoutResId,data);
        }

        @Override
        protected void convert(BaseViewHolder helper,String item) {
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.img_search)
    public void onClick() {
        startActivity(new Intent(mContext,SearchActivity.class));
    }
}


