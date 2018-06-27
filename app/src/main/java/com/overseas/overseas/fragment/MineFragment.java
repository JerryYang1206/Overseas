package com.overseas.overseas.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.overseas.overseas.R;
import com.overseas.overseas.base.BaseFragment;
import com.overseas.overseas.mine.LiShiActivity;
import com.overseas.overseas.mine.LianxirenActivity;
import com.overseas.overseas.mine.MyDataActivity;
import com.overseas.overseas.mine.PingJiaActivity;
import com.overseas.overseas.mine.SettingActivity;
import com.overseas.overseas.view.CircleImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/1/18.
 */
public class MineFragment extends BaseFragment {


    @BindView(R.id.myData)
    CircleImageView myData;
    Unbinder unbinder;
    @BindView(R.id.PingJia_Layout)
    LinearLayout PingJiaLayout;
    @BindView(R.id.Lianxiren_Layout)
    LinearLayout LianxirenLayout;
    @BindView(R.id.Setting_Layout)
    LinearLayout SettingLayout;
    @BindView(R.id.Lishi_Layout)
    LinearLayout LishiLayout;
    @BindView(R.id.PingJun_Layout)
    LinearLayout PingJunLayout;
    @BindView(R.id.Manager_Layout)
    LinearLayout Manager_Layout;

    @Override
    protected View initView() {
//        UltimateBar ultimateBar = new UltimateBar(getActivity());
//        ultimateBar.setImmersionBar(false);
        View view = View.inflate(mContext, R.layout.fragment_mine, null);
        unbinder = ButterKnife.bind(this, view);
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
        unbinder.unbind();
    }



    @OnClick({R.id.PingJia_Layout, R.id.Lianxiren_Layout, R.id.Setting_Layout, R.id.Lishi_Layout, R.id.PingJun_Layout,R.id.myData,R.id.Manager_Layout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.myData:
                Intent intent = new Intent(mContext, MyDataActivity.class);
                startActivity(intent);
                break;
            case R.id.PingJia_Layout:
                Intent intent1 = new Intent(mContext, PingJiaActivity.class);
                startActivity(intent1);
                break;
            case R.id.Lianxiren_Layout:
//                Intent intent2 = new Intent(mContext, LianxirenActivity.class);
//                startActivity(intent2);

                setMyExtensionModule();
                if (RongIM.getInstance() != null) {
                    Log.e("MainActivity", "创建单聊");
                    RongIM.getInstance().startPrivateChat(getActivity(), "123456", "单聊");
                }
                break;
            case R.id.Setting_Layout:
                Intent intent3 = new Intent(mContext, SettingActivity.class);
                startActivity(intent3);
                break;
            case R.id.Lishi_Layout:
                Intent intent4 = new Intent(mContext, LiShiActivity.class);
                startActivity(intent4);
                break;
            case R.id.Manager_Layout:
                Intent intent5 = new Intent(mContext, ManagerActivity.class);
                startActivity(intent5);
                break;
        }
    }

    public void setMyExtensionModule() {
        List<IExtensionModule> moduleList = RongExtensionManager.getInstance().getExtensionModules();
        IExtensionModule defaultModule = null;
        if (moduleList != null) {
            for (IExtensionModule module : moduleList) {
                if (module instanceof DefaultExtensionModule) {
                    defaultModule = module;
                    break;
                }
            }
            if (defaultModule != null) {
                RongExtensionManager.getInstance().unregisterExtensionModule(defaultModule);
//                RongExtensionManager.getInstance().registerExtensionModule(new MyExtensionModule());
            }
        }
    }
}


