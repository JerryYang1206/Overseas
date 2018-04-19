package com.overseas.overseas.base;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2015/11/18.
 */
public abstract class BaseFragment extends Fragment {
    protected Context mContext;
    protected Activity mActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext =getContext();//主要是方便子类调用
        mActivity = getActivity();//主要是方便子类调用
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //        System.out.println("onCreateView被调用");
        return initView();
    }

    //强制子类实现该方法，展示界面view
    protected abstract View initView();//抽象方法不能私有

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        //        System.out.println("onActivityCreated被调用");
    }
    /**
     * 当孩子需要初始化数据，或者联网请求绑定数据，展示数据的 等等可以重写该方法
     */
    protected abstract void initData();


}
