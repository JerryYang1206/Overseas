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

public class ShangPuMoreActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.act_shangpu_wujianmingcheng)
    TextView actShangpuWujianmingcheng;
    @BindView(R.id.act_shangpu_shoujia)
    TextView actShangpuShoujia;
    @BindView(R.id.act_shangpu_mianji)
    TextView actShangpuMianji;
    @BindView(R.id.act_shangpu_suoyouquan)
    TextView actShangpuSuoyouquan;
    @BindView(R.id.act_shangpu_diyuyongtu)
    TextView actShangpuDiyuyongtu;
    @BindView(R.id.act_shangpu_shoumaileixing)
    TextView actShangpuShoumaileixing;
    @BindView(R.id.act_shangpu_jianzhunianfen)
    TextView actShangpuJianzhunianfen;
    @BindView(R.id.act_shangpu_jianzhugouzao)
    TextView actShangpuJianzhugouzao;
    @BindView(R.id.act_shangpu_jianzhugongsi)
    TextView actShangpuJianzhugongsi;
    @BindView(R.id.act_shangpu_chaoxiang)
    TextView actShangpuChaoxiang;
    @BindView(R.id.act_shangpu_yingyeleixing)
    TextView actShangpuYingyeleixing;
    @BindView(R.id.act_shangpu_xianzhuang)
    TextView actShangpuXianzhuang;
    @BindView(R.id.act_shangpu_huibaolv)
    TextView actShangpuHuibaolv;
    @BindView(R.id.act_shangpu_rujuriqi)
    TextView actShangpuRujuriqi;
    @BindView(R.id.act_shangpu_diduan)
    TextView actShangpuDiduan;
    @BindView(R.id.act_shangpu_jutiweizhi)
    TextView actShangpuJutiweizhi;
    @BindView(R.id.act_shangpu_zhuyaochezhan)
    TextView actShangpuZhuyaochezhan;
    @BindView(R.id.act_shangpu_chezhanjuli)
    TextView actShangpuChezhanjuli;
    @BindView(R.id.act_shangpu_tingchewei)
    TextView actShangpuTingchewei;
    @BindView(R.id.act_shangpu_shangpuzhaopai)
    TextView actShangpuShangpuzhaopai;
    @BindView(R.id.act_shangpu_jujiagaodu)
    TextView actShangpuJujiagaodu;
    @BindView(R.id.act_shangpu_shiwaishezhi)
    TextView actShangpuShiwaishezhi;
    @BindView(R.id.act_shangpu_shineishebei)
    TextView actShangpuShineishebei;
    @BindView(R.id.act_shangpu_tezheng)
    TextView actShangpuTezheng;
    @BindView(R.id.act_shangpu_tiaojian)
    TextView actShangpuTiaojian;
    @BindView(R.id.act_gaoerfu_beizhu)
    TextView actGaoerfuBeizhu;
    private ShangYeDetailsBean.DatasBean datas;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shangpu_more);
        ButterKnife.bind(this);
        datas = (ShangYeDetailsBean.DatasBean) getIntent().getSerializableExtra("datas");
        if (datas != null) {
            initData();
        }
    }
    private void initData() {
        boolean ja = MyUtils.isJa(mContext);
        actShangpuWujianmingcheng.setText(ja?datas.getTitleJpn():datas.getTitleCn());/*物件名称*/
        actShangpuShoujia.setText(ja?datas.getSellingPriceJpn():datas.getSellingPriceCn());/*售价*/
        actShangpuMianji.setText(ja?datas.getAreaJpn():datas.getAreaCn());/*面积*/
        actShangpuSuoyouquan.setText(ja?datas.getOwnershipJpn():datas.getOwnershipCn());/*所有权*/
        actShangpuDiyuyongtu.setText(ja?datas.getOwnershipJpn():datas.getOwnershipCn());/*地域用途*/
        actShangpuJianzhunianfen.setText(ja?datas.getYearBuiltJpn():datas.getYearBuiltCn());/*建筑年份*/
        actShangpuJianzhugouzao.setText(ja?datas.getBuildingConstructionJpn():datas.getBuildingConstructionCn());/*建筑构造*/
        actShangpuChaoxiang.setText(ja?datas.getOrientationJpn():datas.getOrientationCn());/*朝向*/
        actShangpuHuibaolv.setText(ja?datas.getReturnRateJpn():datas.getReturnRateCn());/*回报率*/
        actShangpuRujuriqi.setText(ja?datas.getDoichoIrinoJpn():datas.getDistrictCn());/*入居日期*/
        actShangpuDiduan.setText(ja?datas.getDistrictJpn():datas.getDistrictCn());/*地段*/
        actShangpuJutiweizhi.setText(ja?datas.getSpecificLocationJpn():datas.getSpecificLocationCn());/*具体位置*/
        actShangpuChezhanjuli.setText(ja?datas.getStationDistanceJpn():datas.getStationDistanceCn());/*车站距离*/
        actShangpuTingchewei.setText(ja?datas.getParkingSpaceJpn():datas.getParkingSpaceCn());/*停车位*/
        actShangpuShineishebei.setText(ja?datas.getIndoorEquipmentJpn():datas.getIndoorEquipmentCn());/*室内设备*/
        actGaoerfuBeizhu.setText(ja?datas.getRemarksJpn():datas.getRemarksCn());/*备注*/
        actShangpuShangpuzhaopai.setText(ja ? datas.getShopSignsJpn() : datas.getShopSignsCn());/*商铺招牌*/
        actShangpuJujiagaodu.setText(ja ? datas.getBicepsShelfJpn() : datas.getBicepsShelfCn());/*举架高度*/
        actShangpuShiwaishezhi.setText(ja ? datas.getOutdoorSettingJpn() : datas.getOutdoorSettingCn());/*室外设置*/
        actShangpuTezheng.setText(ja ? datas.getCharacteristicJpn() : datas.getCharacteristicCn());/*特征*/
        actShangpuTiaojian.setText(ja ? datas.getConditionJpn() : datas.getConditionCn());/*条件*/
        actShangpuShoumaileixing.setText(ja ? datas.getLeaseTypeJpn() : datas.getLeaseTypeCn());/*售卖类型*/
        actShangpuXianzhuang.setText(ja ? datas.getActualityJpn() : datas.getActualityCn());/*现状*/
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
