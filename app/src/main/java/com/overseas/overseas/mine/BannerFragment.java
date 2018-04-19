package com.overseas.overseas.mine;

import android.view.View;

import com.overseas.overseas.R;
import com.overseas.overseas.base.BaseFragment;

/**
 * Created by Administrator on 2018/1/18.
 */
public class BannerFragment extends BaseFragment {



    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_banner, null);
        return view;
    }

    @Override
    protected void initData() {
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


