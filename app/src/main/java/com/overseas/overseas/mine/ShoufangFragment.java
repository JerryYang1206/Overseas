package com.overseas.overseas.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.overseas.overseas.R;
import com.overseas.overseas.base.BaseFragmentL;
import com.overseas.overseas.bean.ManShouBean;
import com.overseas.overseas.callback.DialogCallback;
import com.overseas.overseas.utils.MyUrls;
import com.overseas.overseas.utils.MyUtils;
import com.overseas.overseas.utils.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2018/1/18.
 */
public class ShoufangFragment extends BaseFragmentL{

    private RecyclerView mrecycler;
    private TextView tvNoData;
    private LiebiaoAdapter mLiebiaoAdapter;
    private List<String> mList=new ArrayList();
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(mContext, R.layout.fragment_shoufang, null);
        mrecycler= (RecyclerView) view.findViewById(R.id.Mrecycler);
        tvNoData= (TextView) view.findViewById(R.id.tv_wushuju);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initNet();
    }

    private void initNet() {
        String brokerId = SharedPreferencesUtils.getInstace(mContext).getStringPreference("brokerId", "");
        HttpParams params = new HttpParams();
        params.put("brokerId", brokerId);
        params.put("pageNo", 1);
        OkGo.<ManShouBean>post(MyUrls.BASEURL + "/app/brokerhouse/selecthouselist")
                .tag(this)
                .params(params)
                .execute(new DialogCallback<ManShouBean>(mActivity, ManShouBean.class) {
                    @Override
                    public void onSuccess(Response<ManShouBean> response) {
                        int code = response.code();
                        final ManShouBean ManShouBean = response.body();
                        if (ManShouBean==null){
                            tvNoData.setVisibility(View.VISIBLE);
                            return;
                        }
                        String code1 = ManShouBean.getCode();
                        final List<ManShouBean.DatasBean> datas = ManShouBean.getDatas();
                        if (datas==null){
                            tvNoData.setVisibility(View.VISIBLE);
                            return;
                        }
                        if (code1.equals("200")) {
                            if (mLiebiaoAdapter == null) {
                                mLiebiaoAdapter = new LiebiaoAdapter(R.layout.item_zuijin,datas);
                            }
                            mrecycler.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL,false));
                            mrecycler.setNestedScrollingEnabled(false);
                            mrecycler.setAdapter(mLiebiaoAdapter);
                            mLiebiaoAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                    if (!TextUtils.isEmpty(datas.get(position).getHType())) {
                                        if (TextUtils.equals(datas.get(position).getHType(), "0")) { //二手房
                                            Intent intent = new Intent(mContext, LishiOldHouseActivity.class);
                                            intent.putExtra("houseId", datas.get(position).getId() + "");
                                            startActivity(intent);
                                        } else if (TextUtils.equals(datas.get(position).getHType(), "1")) { //新房
                                            Intent intent = new Intent(mContext, LishiNewHouseActivity.class);
                                            intent.putExtra("houseId", datas.get(position).getId() + "");
                                            startActivity(intent);
                                        } else if (TextUtils.equals(datas.get(position).getHType(), "2")) { //租房
                                            Intent intent = new Intent(mContext, LishiZuHouseActivity.class);

                                            if (TextUtils.equals(datas.get(position).getShType() + "", "0")) { //办公室出租
                                                intent.putExtra("houseId", datas.get(position).getId() + "");
                                                intent.putExtra("houseType", "bangongshi");
                                            } else if (TextUtils.equals(datas.get(position).getShType() + "", "1")) { //商铺出租
                                                intent.putExtra("houseId", datas.get(position).getId() + "");
                                                intent.putExtra("houseType", "shangpu");
                                            } else if (TextUtils.equals(datas.get(position).getShType() + "", "2")) { //别墅
                                                intent.putExtra("houseId", datas.get(position).getId() + "");
                                                intent.putExtra("houseType", "bieshu");
                                            } else if (TextUtils.equals(datas.get(position).getShType() + "", "3")) { //二层公寓
                                                intent.putExtra("houseId", datas.get(position).getId() + "");
                                                intent.putExtra("houseType", "erceng");
                                            } else if (TextUtils.equals(datas.get(position).getShType() + "", "4")) { //学生公寓
                                                intent.putExtra("houseId", datas.get(position).getId() + "");
                                                intent.putExtra("houseType", "xuesheng");
                                            } else if (TextUtils.equals(datas.get(position).getShType() + "", "5")) { //多层公寓
                                                intent.putExtra("houseId", datas.get(position).getId() + "");
                                                intent.putExtra("houseType", "duoceng");
                                            }
                                            startActivity(intent);
                                        } else if (TextUtils.equals(datas.get(position).getHType(), "3")) {  //土地
                                            Intent intent = new Intent(mContext, LishiTudiActivity.class);
                                            intent.putExtra("houseId", datas.get(position).getId() + "");
                                            startActivity(intent);
                                        } else if (TextUtils.equals(datas.get(position).getHType(), "4")) {  //别墅
                                            Intent intent = new Intent(mContext, BieshudetailsActivity.class);
                                            intent.putExtra("houseId", datas.get(position).getId() + "");
                                            startActivity(intent);
                                        } else if (TextUtils.equals(datas.get(position).getHType(), "5")) {  //商业地产
                                            if (TextUtils.equals(datas.get(position).getShType() + "", "0")) {    //酒店
                                                Intent intent = new Intent(mContext, LishiShangyeActivity.class);
                                                intent.putExtra("houseId", datas.get(position).getId() + "");
                                                startActivity(intent);
                                            } else if (TextUtils.equals(datas.get(position).getShType() + "", "1")) { //高尔夫球场
                                                Intent intent = new Intent(mContext, LishiGaoerfuActivity.class);
                                                intent.putExtra("houseId", datas.get(position).getId() + "");
                                                startActivity(intent);
                                            } else if (TextUtils.equals(datas.get(position).getShType() + "", "2")) { //写字楼
                                                Intent intent = new Intent(mContext, LishiXiezilouActivity.class);
                                                intent.putExtra("houseId", datas.get(position).getId() + "");
                                                startActivity(intent);
                                            } else if (TextUtils.equals(datas.get(position).getShType() + "", "3")) { //商铺
//                                                Intent intent = new Intent(mContext, LishiShangyeActivity.class);
//                                                intent.putExtra("houseId", datas.get(position).getId() + "");
//                                                startActivity(intent);
                                            }
                                        } else if (TextUtils.equals(datas.get(position).getHType(), "6")) { //中国房源
                                            Intent intent = new Intent(mContext, LishiZhongGuoActivity.class);
                                            intent.putExtra("houseId", datas.get(position).getId() + "");
                                            startActivity(intent);
                                        } else if (TextUtils.equals(datas.get(position).getHType(), "7")) {  //海外房源
                                            Intent intent = new Intent(mContext, LishiHaiwaiActivity.class);
                                            intent.putExtra("houseId", datas.get(position).getId() + "");
                                            startActivity(intent);
                                        }

                                    }
                                }
                            });
                        } else {
                            Toast.makeText(mContext, ManShouBean.getMsg(), Toast.LENGTH_SHORT).show();
                        }


                    }
                });
    }

    @Override
    protected void initLazyData() {

    }

    class LiebiaoAdapter extends BaseQuickAdapter<ManShouBean.DatasBean, BaseViewHolder> {

        public LiebiaoAdapter(@LayoutRes int layoutResId, @Nullable List<ManShouBean.DatasBean> data) {
            super(layoutResId,data);
        }

        @Override
        protected void convert(BaseViewHolder helper, ManShouBean.DatasBean item) {
            boolean isJa = MyUtils.isJa(mContext);
            helper.setText(R.id.tv_house_name, isJa ? item.getTitleJpn() : item.getTitleCn());
            helper.setText(R.id.tv_house_address, isJa ? item.getAddressJpn() : item.getAddressCn());
            helper.setText(R.id.tv_house_room, isJa ? item.getDoorModelJpn() : item.getDoorModelCn());
            helper.setText(R.id.tv_house_area, isJa ? item.getAreaJpn() : item.getAreaCn());
            helper.setText(R.id.tv_price, isJa ? item.getPriceJpn() : item.getPriceCn());
            Glide.with(mContext).load(item.getImageUrl()).into((ImageView) helper.getView(R.id.img_house));
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


