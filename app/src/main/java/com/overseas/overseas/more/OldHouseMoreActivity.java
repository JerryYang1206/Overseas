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

public class OldHouseMoreActivity extends BaseActivity {

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
    @BindView(R.id.tv_more_louceng)
    TextView tvMoreLouceng;
    @BindView(R.id.tv_house_suoyouquan)
    TextView tvHouseSuoyouquan;
    @BindView(R.id.tv_house_years)
    TextView tvHouseYears;
    @BindView(R.id.tv_house_gouzao)
    TextView tvHouseGouzao;
    @BindView(R.id.tv_jianzhu_gongsi)
    TextView tvJianzhuGongsi;
    @BindView(R.id.tv_house_chaoxiang)
    TextView tvHouseChaoxiang;
    @BindView(R.id.tv_people_num)
    TextView tvPeopleNum;
    @BindView(R.id.tv_house_huibaolv)
    TextView tvHouseHuibaolv;
    @BindView(R.id.tv_ruzhu_riqi)
    TextView tvRuzhuRiqi;
    @BindView(R.id.tv_house_qita)
    TextView tvHouseQita;
    @BindView(R.id.tv_house_guanlihuishe)
    TextView tvHouseGuanlihuishe;
    @BindView(R.id.tv_house_guanlifei)
    TextView tvHouseGuanlifei;
    @BindView(R.id.tv_house_xiushanfei)
    TextView tvHouseXiushanfei;
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
    @BindView(R.id.tv_house_xingneng)
    TextView tvHouseXingneng;
    @BindView(R.id.tv_house_zhengmingshu)
    TextView tvHouseZhengmingshu;
    @BindView(R.id.tv_house_xiaci)
    TextView tvHouseXiaci;
    @BindView(R.id.tv_house_beizhu)
    TextView tvHouseBeizhu;
    @BindView(R.id.activity_zui_jin)
    LinearLayout activityZuiJin;
    private HouseDetailsBean.DatasBean datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_house_more);
        ButterKnife.bind(this);
        datas = (HouseDetailsBean.DatasBean) getIntent().getSerializableExtra("datas");
        if (datas != null) {
            initData();
        }
    }

    private void initData() {
        boolean ja = MyUtils.isJa(mContext);
        tvWujianName.setText(ja?datas.getArticleNameJpn():datas.getArticleNameCn());/*物件名称*/
        tvHousePrice.setText(ja?datas.getSellingPriceJpn():datas.getSellingPriceCn());/*售价*/
        tvHouseArea.setText(ja?datas.getAreaJpn():datas.getAreaCn());/*面积*/
        tvHouseHuxing.setText(ja?datas.getDoorModelJpn():datas.getDoorModelCn());/*户型*/
        tvMoreLouceng.setText(ja?datas.getFloorJpn():datas.getFloorCn());/*楼层*/
        tvHouseSuoyouquan.setText(ja?datas.getOwnershipJpn():datas.getOwnershipCn());/*所有权*/
        tvHouseYears.setText(ja?datas.getYearBuiltJpn():datas.getYearBuiltCn());/*建筑年份*/
        tvHouseGouzao.setText(ja?datas.getBuildingConstructionJpn():datas.getBuildingConstructionCn());/*建筑构造*/
        tvJianzhuGongsi.setText(ja?datas.getConstructionCompanyJpn():datas.getConstructionCompanyCn());/*建筑公司*/
        tvHouseChaoxiang.setText(ja?datas.getOrientationJpn():datas.getOrientationCn());/*朝向*/
        tvPeopleNum.setText(ja?datas.getHouseholdsJpn():datas.getHouseholdsCn());/*总户数*/
        tvHouseHuibaolv.setText(ja?datas.getReturnRateJpn():datas.getReturnRateCn());/*回报率*/
        tvRuzhuRiqi.setText(ja?datas.getDoichoIrinoDateJpn():datas.getDoichoIrinoDateCn());/*入居日期*/
        tvHouseQita.setText(ja?datas.getRestsJpn():datas.getRestsCn());/*其他*/
        tvHouseGuanlihuishe.setText(ja?datas.getManagementSocietyJpn():datas.getManagementSocietyCn());/*管理会社*/
        tvHouseGuanlifei.setText(ja?datas.getAdministrativeFeeJpn():datas.getAdministrativeFeeCn());/*管理费*/
        tvHouseXiushanfei.setText(ja?datas.getRepairChargeJpn():datas.getRepairChargeCn());/*修缮费*/
        tvHouseGuanli.setText(ja?datas.getManageJpn():datas.getManageCn());/*管理*/
        tvHouseDiduan.setText(ja?datas.getDistrictJpn():datas.getDistrictCn());/*地段*/
        tvHouseJutiweizhi.setText(ja?datas.getSpecificLocationJpn():datas.getSpecificLocationCn());/*具体位置*/
        tvHouseZhuyaochezhan.setText(ja?datas.getTrainStationJpn():datas.getTrainStationCn());/*主要车站*/
        tvHouseChezhanjuli.setText(ja?datas.getStationDistanceJpn():datas.getStationDistanceCn());/*车站距离*/
        tvHouseFengjing.setText(ja?datas.getSceneryJpn():datas.getSceneryCn());/*窗外风景*/
        tvHouseGongyong.setText(ja?datas.getCommonPartsJpn():datas.getCommonPartsCn());/*共用部分*/
        tvHouseZhoubian.setText(ja?datas.getSurroundingsJpn():datas.getSurroundingsCn());/*周边环境*/
        tvStopCar.setText(ja?datas.getParkingSpaceJpn():datas.getParkingSpaceCn());/*停车位*/
        tvHouseShineishebei.setText(ja?datas.getIndoorEquipmentJpn():datas.getIndoorEquipmentCn());/*室内设备*/
        tvHouseCook.setText(ja?datas.getKitchenJpn():datas.getKitchenCn());/*厨房*/
        tvHouseWeishengjian.setText(ja?datas.getToiletJpn():datas.getToiletCn());/*卫生间*/
        tvHouseYushi.setText(ja?datas.getShowersJpn():datas.getShowersCn());/*浴室*/
        tvHouseXingneng.setText(ja?datas.getPerformanceJpn():datas.getPerformanceCn());/*性能*/
        tvHouseZhengmingshu.setText(ja?datas.getTestimonialJpn():datas.getTestimonialCn());/*证明书*/
        tvHouseXiaci.setText(ja?datas.getDefectsEnsureJpn():datas.getDefectsEnsureCn());/*瑕疵保证*/
        tvHouseBeizhu.setText(ja?datas.getRemarksJpn():datas.getRemarksCn());/*备注*/
    }

    @OnClick(R.id.back_img)
    public void onViewClicked() {
        finish();
    }
}
