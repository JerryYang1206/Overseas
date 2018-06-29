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

public class ZuXueShengMoreActivity extends BaseActivity {

    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.tv_house_huxing)
    TextView tvHouseHuxing;
    @BindView(R.id.tv_house_price)
    TextView tvHousePrice;
    @BindView(R.id.tv_more_louceng)
    TextView tvMoreLouceng;
    @BindView(R.id.tv_house_chaoxiang)
    TextView tvHouseChaoxiang;
    @BindView(R.id.tv_house_area)
    TextView tvHouseArea;
    @BindView(R.id.tv_house_zhuyaochezhan)
    TextView tvHouseZhuyaochezhan;
    @BindView(R.id.tv_house_chezhanjuli)
    TextView tvHouseChezhanjuli;
    @BindView(R.id.tv_house_fangjianzhuangkuang)
    TextView tvHouseFangjianzhuangkuang;
    @BindView(R.id.tv_house_years)
    TextView tvHouseYears;
    @BindView(R.id.tv_house_feiyong)
    TextView tvHouseFeiyong;
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
        setContentView(R.layout.activity_xue_sheng_more);
        ButterKnife.bind(this);
        datas = (HouseDetailsBean.DatasBean) getIntent().getSerializableExtra("datas");
        if (datas != null) {
            initData();
        }
    }
    private void initData() {
        boolean ja = MyUtils.isJa(mContext);
        tvHousePrice.setText(ja ? datas.getRentJpn() : datas.getRentCn());/*售价*/
        tvHouseArea.setText(ja ? datas.getAreaJpn() : datas.getAreaCn());/*面积*/
        tvHouseHuxing.setText(ja ? datas.getDoorModelJpn() : datas.getDoorModelCn());/*户型*/
        tvMoreLouceng.setText(ja ? datas.getFloorJpn() : datas.getFloorCn());/*楼层*/
        tvHouseYears.setText(ja ? datas.getYearBuiltJpn() : datas.getYearBuiltCn());/*建筑年份*/
        tvHouseChaoxiang.setText(ja ? datas.getOrientationJpn() : datas.getOrientationCn());/*朝向*/
        tvHouseZhuyaochezhan.setText(ja ? datas.getTrainStationJpn() : datas.getTrainStationCn());/*主要车站*/
        tvHouseChezhanjuli.setText(ja ? datas.getStationDistanceJpn() : datas.getStationDistanceCn());/*车站距离*/
        tvHouseShineishebei.setText(ja ? datas.getIndoorEquipmentJpn() : datas.getIndoorEquipmentCn());/*室内设备*/
        tvHouseBeizhu.setText(ja ? datas.getRemarksJpn() : datas.getRemarksCn());/*备注*/
        tvHouseFangjianzhuangkuang.setText(ja ? datas.getRoomStatusJpn() : datas.getRoomStatusCn());/*房间状况*/
        tvHouseFeiyong.setText(ja ? datas.getChargeJpn() : datas.getChargeCn());/*费用*/
    }
    @OnClick(R.id.back_img)
    public void onViewClicked() {
        finish();
    }
}
