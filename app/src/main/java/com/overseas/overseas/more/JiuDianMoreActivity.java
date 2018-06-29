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

public class JiuDianMoreActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.act_jiudian_shoujia)
    TextView actJiudianShoujia;
    @BindView(R.id.act_jiudian_jiudianloucengshu)
    TextView actJiudianJiudianloucengshu;
    @BindView(R.id.act_jiudian_suoyouquan)
    TextView actJiudianSuoyouquan;
    @BindView(R.id.act_jiudian_chezhanjuli)
    TextView actJiudianChezhanjuli;
    @BindView(R.id.act_jiudian_jianzhunianfen)
    TextView actJiudianJianzhunianfen;
    @BindView(R.id.act_jiudian_jianzhugouzao)
    TextView actJiudianJianzhugouzao;
    @BindView(R.id.act_jiudian_diyuyongtu)
    TextView actJiudianDiyuyongtu;
    @BindView(R.id.act_jiudian_xianzhuang)
    TextView actJiudianXianzhuang;
    @BindView(R.id.act_jiudian_huibaolv)
    TextView actJiudianHuibaolv;
    @BindView(R.id.act_gaoerfu_beizhu)
    TextView actGaoerfuBeizhu;
    private ShangYeDetailsBean.DatasBean datas;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jiudian_more);
        ButterKnife.bind(this);
        datas = (ShangYeDetailsBean.DatasBean) getIntent().getSerializableExtra("datas");
        if (datas != null) {
            initData();
        }
    }
    private void initData() {
        boolean ja = MyUtils.isJa(mContext);
        actJiudianShoujia.setText(ja?datas.getSellingPriceJpn():datas.getSellingPriceCn());/*售价*/
        actJiudianSuoyouquan.setText(ja?datas.getOwnershipJpn():datas.getOwnershipCn());/*所有权*/
        actJiudianHuibaolv.setText(ja?datas.getReturnRateJpn():datas.getReturnRateCn());/*回报率*/
        actJiudianChezhanjuli.setText(ja?datas.getStationDistanceJpn():datas.getStationDistanceCn());/*车站距离*/
        actGaoerfuBeizhu.setText(ja?datas.getRemarksJpn():datas.getRemarksCn());/*备注*/
        actJiudianXianzhuang.setText(ja ? datas.getActualityJpn() : datas.getActualityCn());/*现状*/
        actJiudianJiudianloucengshu.setText(ja ? datas.getActualityJpn() : datas.getActualityCn());/*酒店楼层数*/
        actJiudianJianzhunianfen.setText(ja?datas.getYearBuiltJpn():datas.getYearBuiltCn());/*建筑年份*/
        actJiudianJianzhugouzao.setText(ja?datas.getBuildingConstructionJpn():datas.getBuildingConstructionCn());/*建筑构造*/
        actJiudianDiyuyongtu.setText(ja?datas.getOwnershipJpn():datas.getOwnershipCn());/*地域用途*/


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
