package com.overseas.overseas.more;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.overseas.overseas.R;
import com.overseas.overseas.base.BaseActivity;
import com.overseas.overseas.bean.ShangYeDetailsBean;
import com.overseas.overseas.utils.MyUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by   admin on 2018/5/18.
 */

public class GaoErFuMoreActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.act_gaoerfu_shoujia)
    TextView actGaoerfuShoujia;
    @BindView(R.id.act_gaoerfu_mianji)
    TextView actGaoerfuMianji;
    @BindView(R.id.act_gaoerfu_suoyouquan)
    TextView actGaoerfuSuoyouquan;
    @BindView(R.id.act_gaoerfu_chezhanjuli)
    TextView actGaoerfuChezhanjuli;
    @BindView(R.id.act_gaoerfu_jutiweizhi)
    TextView actGaoerfuJutiweizhi;
    @BindView(R.id.act_gaoerfu_xianzhuang)
    TextView actGaoerfuXianzhuang;
    @BindView(R.id.act_gaoerfu_shuiyuan)
    TextView actGaoerfuShuiyuan;
    @BindView(R.id.act_gaoerfu_dixing)
    TextView actGaoerfuDixing;
    @BindView(R.id.act_gaoerfu_turangqingkuang)
    TextView actGaoerfuTurangqingkuang;
    @BindView(R.id.act_gaoerfu_huibaolv)
    TextView actGaoerfuHuibaolv;
    @BindView(R.id.act_gaoerfu_zhoubiansheshi)
    TextView actGaoerfuZhoubiansheshi;
    @BindView(R.id.act_gaoerfu_beizhu)
    TextView actGaoerfuBeizhu;
    private ShangYeDetailsBean.DatasBean datas;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaoerfu_more);
        ButterKnife.bind(this);
        datas = (ShangYeDetailsBean.DatasBean) getIntent().getSerializableExtra("datas");
        if (datas != null) {
            initData();
        }
    }
    private void initData() {
        boolean ja = MyUtils.isJa(mContext);
        actGaoerfuShoujia.setText(ja?datas.getSellingPriceJpn():datas.getSellingPriceCn());/*售价*/
        actGaoerfuMianji.setText(ja?datas.getAreaJpn():datas.getAreaCn());/*面积*/
        actGaoerfuSuoyouquan.setText(ja?datas.getOwnershipJpn():datas.getOwnershipCn());/*所有权*/
        actGaoerfuHuibaolv.setText(ja?datas.getReturnRateJpn():datas.getReturnRateCn());/*回报率*/
        actGaoerfuJutiweizhi.setText(ja?datas.getSpecificLocationJpn():datas.getSpecificLocationCn());/*具体位置*/
        actGaoerfuChezhanjuli.setText(ja?datas.getStationDistanceJpn():datas.getStationDistanceCn());/*车站距离*/
        actGaoerfuBeizhu.setText(ja?datas.getRemarksJpn():datas.getRemarksCn());/*备注*/
        actGaoerfuXianzhuang.setText(ja ? datas.getActualityJpn() : datas.getActualityCn());/*现状*/
        actGaoerfuTurangqingkuang.setText(ja ? datas.getSoilRegimeJpn() : datas.getSoilRegimeCn());/*土壤情况*/
        actGaoerfuShuiyuan.setText(ja ? datas.getHeadwatersJpn() : datas.getHeadwatersCn());/*水源*/
        actGaoerfuDixing.setText(ja ? datas.getTerrainJpn() : datas.getTerrainCn());/*地形*/
        actGaoerfuZhoubiansheshi.setText(ja ? datas.getSurroundingsJpn() : datas.getSurroundingsCn());/*周边环境*/

    }
    @OnClick(R.id.back)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
        }
    }
}
