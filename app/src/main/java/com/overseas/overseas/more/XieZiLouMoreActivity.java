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

public class XieZiLouMoreActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.act_xiezilou_wujianmingcheng)
    TextView actXiezilouWujianmingcheng;
    @BindView(R.id.act_xiezilou_shoujia)
    TextView actXiezilouShoujia;
    @BindView(R.id.act_xiezilou_mianji)
    TextView actXiezilouMianji;
    @BindView(R.id.act_xiezilou_shoumaileixing)
    TextView actXiezilouShoumaileixing;
    @BindView(R.id.act_xiezilou_suoyouquan)
    TextView actXiezilouSuoyouquan;
    @BindView(R.id.act_xiezilou_diyuyongtu)
    TextView actXiezilouDiyuyongtu;
    @BindView(R.id.act_xiezilou_jianzhunianfen)
    TextView actXiezilouJianzhunianfen;
    @BindView(R.id.act_xiezilou_xianzhuang)
    TextView actXiezilouXianzhuang;
    @BindView(R.id.act_xiezilou_huibaolv)
    TextView actXiezilouHuibaolv;
    @BindView(R.id.act_xiezilou_rujuriqi)
    TextView actXiezilouRujuriqi;
    @BindView(R.id.act_xiezilou_guanlihuishe)
    TextView actXiezilouGuanlihuishe;
    @BindView(R.id.act_xiezilou_guanlifei)
    TextView actXiezilouGuanlifei;
    @BindView(R.id.act_xiezilou_guanli)
    TextView actXiezilouGuanli;
    @BindView(R.id.act_xiezilou_diduan)
    TextView actXiezilouDiduan;
    @BindView(R.id.act_xiezilou_jutiweizhi)
    TextView actXiezilouJutiweizhi;
    @BindView(R.id.act_xiezilou_zhuyaochezhan)
    TextView actXiezilouZhuyaochezhan;
    @BindView(R.id.act_xiezilou_chezhanjuli)
    TextView actXiezilouChezhanjuli;
    @BindView(R.id.act_xiezilou_tingchewei)
    TextView actXiezilouTingchewei;
    @BindView(R.id.act_xiezilou_shineishebei)
    TextView actXiezilouShineishebei;
    @BindView(R.id.act_xiezilou_beizhu)
    TextView actXiezilouBeizhu;
    private ShangYeDetailsBean.DatasBean datas;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiezilou_more);
        ButterKnife.bind(this);
        datas = (ShangYeDetailsBean.DatasBean) getIntent().getSerializableExtra("datas");
        if (datas != null) {
            initData();
        }
    }
    private void initData() {
        boolean ja = MyUtils.isJa(mContext);
        actXiezilouWujianmingcheng.setText(ja?datas.getTitleJpn():datas.getTitleCn());/*物件名称*/
        actXiezilouShoujia.setText(ja?datas.getSellingPriceJpn():datas.getSellingPriceCn());/*售价*/
        actXiezilouMianji.setText(ja?datas.getAreaJpn():datas.getAreaCn());/*面积*/
        actXiezilouSuoyouquan.setText(ja?datas.getOwnershipJpn():datas.getOwnershipCn());/*所有权*/
        actXiezilouDiyuyongtu.setText(ja?datas.getOwnershipJpn():datas.getOwnershipCn());/*地域用途*/
        actXiezilouJianzhunianfen.setText(ja?datas.getYearBuiltJpn():datas.getYearBuiltCn());/*建筑年份*/
        actXiezilouHuibaolv.setText(ja?datas.getReturnRateJpn():datas.getReturnRateCn());/*回报率*/
        actXiezilouRujuriqi.setText(ja?datas.getDoichoIrinoJpn():datas.getDistrictCn());/*入居日期*/
        actXiezilouDiduan.setText(ja?datas.getDistrictJpn():datas.getDistrictCn());/*地段*/
        actXiezilouJutiweizhi.setText(ja?datas.getSpecificLocationJpn():datas.getSpecificLocationCn());/*具体位置*/
        actXiezilouChezhanjuli.setText(ja?datas.getStationDistanceJpn():datas.getStationDistanceCn());/*车站距离*/
        actXiezilouTingchewei.setText(ja?datas.getParkingSpaceJpn():datas.getParkingSpaceCn());/*停车位*/
        actXiezilouShineishebei.setText(ja?datas.getIndoorEquipmentJpn():datas.getIndoorEquipmentCn());/*室内设备*/
        actXiezilouBeizhu.setText(ja?datas.getRemarksJpn():datas.getRemarksCn());/*备注*/
        actXiezilouGuanlihuishe.setText(ja?datas.getManagementSocietyJpn():datas.getManagementSocietyCn());/*管理会社*/
        actXiezilouGuanlifei.setText(ja?datas.getManagementFeeJpn():datas.getManagementFeeCn());/*管理费*/
        actXiezilouGuanli.setText(ja?datas.getManageJpn():datas.getManageCn());/*管理*/
        actXiezilouXianzhuang.setText(ja ? datas.getActualityJpn() : datas.getActualityCn());/*现状*/
        actXiezilouShoumaileixing.setText(ja ? datas.getLeaseTypeJpn() : datas.getLeaseTypeCn());/*售卖类型*/

//        actShangpuYingyeleixing.setText(ja ? datas.() : datas.getActualityCn());/*营业类型*/
//        actShangpuZhuyaochezhan.setText(ja?datas.getRailwayStationJpn():datas.getRailwayStationCn());/*主要车站*/
//        actShangpuJianzhugongsi.setText(ja?datas.getConstructionCompanyJpn():datas.getConstructionCompanyCn());/*建筑公司*/

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
