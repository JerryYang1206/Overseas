package com.overseas.overseas.more;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.overseas.overseas.R;
import com.overseas.overseas.base.BaseActivity;
import com.overseas.overseas.bean.HouseDetailsBean;
import com.overseas.overseas.utils.MyUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ZuDuoCengMoreActivity extends BaseActivity {

    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.tv_wujian_name)
    TextView tvWujianName;
    @BindView(R.id.tv_house_price)
    TextView tvHousePrice;
    @BindView(R.id.tv_house_area)
    TextView tvHouseArea;
    @BindView(R.id.tv_house_huxing)
    TextView tvHouseHuxing;
    @BindView(R.id.tv_chuqi_feiyong)
    TextView tvChuqiFeiyong;
    @BindView(R.id.tv_more_louceng)
    TextView tvMoreLouceng;
    @BindView(R.id.tv_house_years)
    TextView tvHouseYears;
    @BindView(R.id.tv_house_gouzao)
    TextView tvHouseGouzao;
    @BindView(R.id.tv_house_chaoxiang)
    TextView tvHouseChaoxiang;
    @BindView(R.id.tv_ruzhu_riqi)
    TextView tvRuzhuRiqi;
    @BindView(R.id.tv_house_qita)
    TextView tvHouseQita;
    @BindView(R.id.tv_house_guanlihuishe)
    TextView tvHouseGuanlihuishe;
    @BindView(R.id.tv_house_guanlifei)
    TextView tvHouseGuanlifei;
    @BindView(R.id.tv_house_guanli)
    TextView tvHouseGuanli;
    @BindView(R.id.tv_house_meiqi)
    TextView tvHouseMeiqi;
    @BindView(R.id.tv_house_diduan)
    TextView tvHouseDiduan;
    @BindView(R.id.tv_house_jutiweizhi)
    TextView tvHouseJutiweizhi;
    @BindView(R.id.tv_house_zhuyaochezhan)
    TextView tvHouseZhuyaochezhan;
    @BindView(R.id.tv_house_chezhanjuli)
    TextView tvHouseChezhanjuli;
    @BindView(R.id.tv_house_fengjing)
    TextView tvHouseFengjing;
    @BindView(R.id.tv_house_gongyong)
    TextView tvHouseGongyong;
    @BindView(R.id.tv_house_zhoubian)
    TextView tvHouseZhoubian;
    @BindView(R.id.tv_stop_car)
    TextView tvStopCar;
    @BindView(R.id.tv_house_shineishebei)
    TextView tvHouseShineishebei;
    @BindView(R.id.tv_house_cook)
    TextView tvHouseCook;
    @BindView(R.id.tv_house_weishengjian)
    TextView tvHouseWeishengjian;
    @BindView(R.id.tv_house_yushi)
    TextView tvHouseYushi;
    @BindView(R.id.tv_house_rujutiaojian)
    TextView tvHouseRujutiaojian;
    @BindView(R.id.tv_house_beizhu)
    TextView tvHouseBeizhu;
    @BindView(R.id.activity_zui_jin)
    LinearLayout activityZuiJin;
    private HouseDetailsBean.DatasBean datas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duo_ceng_more);
        ButterKnife.bind(this);
        datas = (HouseDetailsBean.DatasBean) getIntent().getSerializableExtra("datas");
        if (datas != null) {
            initData();
        }
    }
    private void initData() {
        boolean ja = MyUtils.isJa(mContext);
        tvWujianName.setText(ja ? datas.getArticleNameJpn() : datas.getArticleNameCn());/*物件名称*/
        tvHousePrice.setText(ja ? datas.getRentJpn() : datas.getRentCn());/*售价*/
        tvHouseArea.setText(ja ? datas.getAreaJpn() : datas.getAreaCn());/*面积*/
        tvHouseHuxing.setText(ja ? datas.getDoorModelJpn() : datas.getDoorModelCn());/*户型*/
        tvChuqiFeiyong.setText(ja ? datas.getChargeJpn() : datas.getChargeCn());/*初期费用*/
        tvMoreLouceng.setText(ja ? datas.getFloorJpn() : datas.getFloorCn());/*楼层*/
        tvHouseYears.setText(ja ? datas.getYearBuiltJpn() : datas.getYearBuiltCn());/*建筑年份*/
        tvHouseGouzao.setText(ja ? datas.getBuildingConstructionJpn() : datas.getBuildingConstructionCn());/*建筑构造*/
        tvHouseChaoxiang.setText(ja ? datas.getOrientationJpn() : datas.getOrientationCn());/*朝向*/
        tvRuzhuRiqi.setText(ja ? datas.getDoichoIrinoDateJpn() : datas.getDoichoIrinoDateCn());/*入居日期*/
        tvHouseQita.setText(ja ? datas.getRestsJpn() : datas.getRestsCn());/*其他*/
        tvHouseGuanlihuishe.setText(ja ? datas.getManagementSocietyJpn() : datas.getManagementSocietyCn());/*管理会社*/
        tvHouseGuanlifei.setText(ja ? datas.getAdministrativeFeeJpn() : datas.getAdministrativeFeeCn());/*管理费*/
        tvHouseGuanli.setText(ja ? datas.getManageJpn() : datas.getManageCn());/*管理*/
        tvHouseMeiqi.setText(ja ? datas.getGasElectricJpn() : datas.getGasElectricCn());/*煤气和电力*/
        tvHouseDiduan.setText(ja ? datas.getDistrictJpn() : datas.getDistrictCn());/*地段*/
        tvHouseJutiweizhi.setText(ja ? datas.getSpecificLocationJpn() : datas.getSpecificLocationCn());/*具体位置*/
        tvHouseZhuyaochezhan.setText(ja ? datas.getTrainStationJpn() : datas.getTrainStationCn());/*主要车站*/
        tvHouseChezhanjuli.setText(ja ? datas.getStationDistanceJpn() : datas.getStationDistanceCn());/*车站距离*/
        tvHouseFengjing.setText(ja ? datas.getSceneryJpn() : datas.getSceneryCn());/*窗外风景*/
        tvHouseGongyong.setText(ja ? datas.getCommonPartsJpn() : datas.getCommonPartsCn());/*共用部分*/
        tvHouseZhoubian.setText(ja ? datas.getSurroundingsJpn() : datas.getSurroundingsCn());/*周边环境*/
        tvStopCar.setText(ja ? datas.getParkingSpaceJpn() : datas.getParkingSpaceCn());/*停车位*/
        tvHouseShineishebei.setText(ja ? datas.getIndoorEquipmentJpn() : datas.getIndoorEquipmentCn());/*室内设备*/
        tvHouseCook.setText(ja ? datas.getKitchenJpn() : datas.getKitchenCn());/*厨房*/
        tvHouseWeishengjian.setText(ja ? datas.getToiletJpn() : datas.getToiletCn());/*卫生间*/
        tvHouseYushi.setText(ja ? datas.getShowersJpn() : datas.getShowersCn());/*浴室*/
        tvHouseRujutiaojian.setText(ja ? datas.getDoichoIrinoConditionJpn() : datas.getDoichoIrinoConditionCn());/*入居条件*/
        tvHouseBeizhu.setText(ja ? datas.getRemarksJpn() : datas.getRemarksCn());/*备注*/
    }


    @OnClick(R.id.back_img)
    public void onViewClicked() {
        finish();
    }
}
