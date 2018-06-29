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

public class ZuBanGongMoreActivity extends BaseActivity {

    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.tv_wujian_name)
    TextView tvWujianName;
    @BindView(R.id.tv_house_price)
    TextView tvHousePrice;
    @BindView(R.id.tv_house_area)
    TextView tvHouseArea;
    @BindView(R.id.tv_more_louceng)
    TextView tvMoreLouceng;
    @BindView(R.id.tv_house_years)
    TextView tvHouseYears;
    @BindView(R.id.tv_chuqi_feiyong)
    TextView tvChuqiFeiyong;
    @BindView(R.id.tv_ruzhu_riqi)
    TextView tvRuzhuRiqi;
    @BindView(R.id.tv_house_guanlihuishe)
    TextView tvHouseGuanlihuishe;
    @BindView(R.id.tv_house_guanlifei)
    TextView tvHouseGuanlifei;
    @BindView(R.id.tv_house_guanli)
    TextView tvHouseGuanli;
    @BindView(R.id.tv_house_diduan)
    TextView tvHouseDiduan;
    @BindView(R.id.tv_house_jutiweizhi)
    TextView tvHouseJutiweizhi;
    @BindView(R.id.tv_house_zhuyaochezhan)
    TextView tvHouseZhuyaochezhan;
    @BindView(R.id.tv_house_chezhanjuli)
    TextView tvHouseChezhanjuli;
    @BindView(R.id.tv_stop_car)
    TextView tvStopCar;
    @BindView(R.id.tv_house_shineishebei)
    TextView tvHouseShineishebei;
    @BindView(R.id.tv_house_beizhu)
    TextView tvHouseBeizhu;
    @BindView(R.id.activity_zui_jin)
    LinearLayout activityZuiJin;
    private HouseDetailsBean.DatasBean datas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zu_ban_gong_more);
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
        tvMoreLouceng.setText(ja ? datas.getFloorJpn() : datas.getFloorCn());/*楼层*/
        tvHouseYears.setText(ja ? datas.getYearBuiltJpn() : datas.getYearBuiltCn());/*建筑年份*/
        tvRuzhuRiqi.setText(ja ? datas.getDoichoIrinoDateJpn() : datas.getDoichoIrinoDateCn());/*入居日期*/
        tvHouseDiduan.setText(ja ? datas.getDistrictJpn() : datas.getDistrictCn());/*地段*/
        tvHouseJutiweizhi.setText(ja ? datas.getSpecificLocationJpn() : datas.getSpecificLocationCn());/*具体位置*/
        tvHouseZhuyaochezhan.setText(ja ? datas.getTrainStationJpn() : datas.getTrainStationCn());/*主要车站*/
        tvHouseChezhanjuli.setText(ja ? datas.getStationDistanceJpn() : datas.getStationDistanceCn());/*车站距离*/
        tvStopCar.setText(ja ? datas.getParkingSpaceJpn() : datas.getParkingSpaceCn());/*停车位*/
        tvHouseShineishebei.setText(ja ? datas.getIndoorEquipmentJpn() : datas.getIndoorEquipmentCn());/*室内设备*/
        tvHouseBeizhu.setText(ja ? datas.getRemarksJpn() : datas.getRemarksCn());/*备注*/
        tvChuqiFeiyong.setText(ja ? datas.getChargeJpn() : datas.getChargeCn());/*初期费用*/
        tvHouseGuanlihuishe.setText(ja ? datas.getManagementSocietyJpn() : datas.getManagementSocietyCn());/*管理会社*/
        tvHouseGuanlifei.setText(ja ? datas.getAdministrativeFeeJpn() : datas.getAdministrativeFeeCn());/*管理费*/
        tvHouseGuanli.setText(ja ? datas.getManageJpn() : datas.getManageCn());/*管理*/
    }
    @OnClick(R.id.back_img)
    public void onViewClicked() {
        finish();
    }
}
