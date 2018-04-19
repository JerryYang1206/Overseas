package com.overseas.overseas.mine;

import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.overseas.overseas.R;
import com.overseas.overseas.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/18.
 */
public class ZufangFragment extends BaseFragment {

    private RecyclerView mrecycler;
    private LiebiaoAdapter mLiebiaoAdapter;
    private List<String> mList=new ArrayList();

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_zufang, null);
        mrecycler= (RecyclerView) view.findViewById(R.id.Mrecycler);
        return view;
    }

    @Override
    protected void initData() {
        if (mList.size()<=0){
            mList.add("");
            mList.add("");
            mList.add("");
            mList.add("");
            mList.add("");
        }
        if (mLiebiaoAdapter == null) {
            mLiebiaoAdapter = new LiebiaoAdapter(R.layout.item_zufang,mList);
        }
        mrecycler.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
        mrecycler.setNestedScrollingEnabled(false);
        mrecycler.setAdapter(mLiebiaoAdapter);
        mLiebiaoAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent=new Intent(mContext,LishiNewHouseActivity.class);
                startActivity(intent);
            }
        });
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
    }

    @Override
    public void onPause() {
        super.onPause();
           }
}


