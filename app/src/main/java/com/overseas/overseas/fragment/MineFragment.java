package com.overseas.overseas.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lzy.okgo.model.Response;
import com.overseas.overseas.MyApplication;
import com.overseas.overseas.R;
import com.overseas.overseas.activity.LianxirenActivity;
import com.overseas.overseas.base.BaseFragment;
import com.overseas.overseas.bean.NoDataBean;
import com.overseas.overseas.bean.UserInfo;
import com.overseas.overseas.mine.LiShiActivity;
import com.overseas.overseas.mine.ManagerActivity;
import com.overseas.overseas.mine.MyDataActivity;
import com.overseas.overseas.mine.PingJiaActivity;
import com.overseas.overseas.mine.SettingActivity;
import com.overseas.overseas.presenter.UserPresenter;
import com.overseas.overseas.utils.SharedPreferencesUtils;
import com.overseas.overseas.view.CircleImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/1/18.
 */
public class MineFragment extends BaseFragment implements UserPresenter.UserCallBack {


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
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.top_layout)
    LinearLayout topLayout;
    @BindView(R.id.Lianxiren_Layout1)
    LinearLayout LianxirenLayout1;
    @BindView(R.id.tv_lishi_count)
    TextView tvLishiCount;
    @BindView(R.id.tv_pingjun_count)
    TextView tvPingjunCount;
    private UserInfo.DatasEntity.BrokerEntity broker;

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
        UserPresenter presenter = new UserPresenter(mActivity, this);
        presenter.getUserInfo();
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


    @OnClick({R.id.PingJia_Layout, R.id.Lianxiren_Layout, R.id.Setting_Layout, R.id.Lishi_Layout, R.id.PingJun_Layout, R.id.myData, R.id.Manager_Layout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.myData:
                Intent intent = new Intent(mContext, MyDataActivity.class);
                intent.putExtra("pic",broker.getPic());
                intent.putExtra("name",broker.getBrokerName());
                intent.putExtra("sex",broker.getSex());
                intent.putExtra("birthday",broker.getBirthday()+"");
                intent.putExtra("phone",broker.getPhone());
                startActivityForResult(intent,0);
                break;
            case R.id.PingJia_Layout:
                Intent intent1 = new Intent(mContext, PingJiaActivity.class);
                startActivity(intent1);
                break;
            case R.id.Lianxiren_Layout:
                Intent intent2 = new Intent(mContext, LianxirenActivity.class);
                startActivity(intent2);
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
                String brokerId = SharedPreferencesUtils.getInstace(mContext).getStringPreference("brokerId", "");
                Intent intent5 = new Intent(mContext, ManagerActivity.class);
                intent5.putExtra("brokerId", brokerId);
                startActivity(intent5);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==1){
            initData();
        }
    }

    @Override
    public void getUserInfo(Response<UserInfo> response) {
        if (response != null && response.body() != null && response.body().getDatas() != null) {
            UserInfo.DatasEntity datas = response.body().getDatas();
            broker = datas.getBroker();
            tvName.setText(broker.getBrokerName());
            tvContent.setText(MyApplication.isJapanese() ?
                    "あなたは" + datas.getDayNum() + "日間プラットフォームに参加しました。累積取引金額は" + datas.getLjPrice() + "元です" :
                    getResources().getString(R.string.mine_jiarupingtai) + datas.getDayNum() + "天，"
                            + getResources().getString(R.string.mine_leijijiaoyie) + datas.getLjPrice() + "元");
            tvLishiCount.setText(datas.getLscjNum()+"");
            tvPingjunCount.setText(datas.getPjcjNum()+"");
            Glide.with(MyApplication.getGloableContext()).load(broker.getPic()).into(myData);
        }
    }

    @Override
    public void updateUserInfo(Response<NoDataBean> response) {

    }

}


