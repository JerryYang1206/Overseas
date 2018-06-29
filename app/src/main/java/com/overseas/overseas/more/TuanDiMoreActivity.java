package com.overseas.overseas.more;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.overseas.overseas.R;
import com.overseas.overseas.base.BaseActivity;
import com.overseas.overseas.bean.HouseDetailsBean;
import com.overseas.overseas.utils.MyUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by   admin on 2018/5/18.
 */

public class TuanDiMoreActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.act_tuandi_zujin)
    TextView actTuandiZujin;
    @BindView(R.id.act_tuandi_huxing)
    TextView actTuandiHuxing;
    @BindView(R.id.act_tuandi_chuqifeiyong)
    TextView actTuandiChuqifeiyong;
    @BindView(R.id.act_tuandi_shuidiandengfeiyong)
    TextView actTuandiShuidiandengfeiyong;
    @BindView(R.id.act_tuandi_mianji)
    TextView actTuandiMianji;
    @BindView(R.id.act_tuandi_louceng)
    TextView actTuandiLouceng;
    @BindView(R.id.act_tuandi_chaoxiang)
    TextView actTuandiChaoxiang;
    @BindView(R.id.act_tuandi_fangjianzhuangkuang)
    TextView actTuandiFangjianzhuangkuang;
    @BindView(R.id.act_tuandi_qianyuenianxian)
    TextView actTuandiQianyuenianxian;
    @BindView(R.id.act_tuandi_guanlihuishe)
    TextView actTuandiGuanlihuishe;
    @BindView(R.id.act_tuandi_guanlifei)
    TextView actTuandiGuanlifei;
    @BindView(R.id.act_tuandi_xiushanfei)
    TextView actTuandiXiushanfei;
    @BindView(R.id.act_tuandi_guanli)
    TextView actTuandiGuanli;
    @BindView(R.id.act_tuandi_diduan)
    TextView actTuandiDiduan;
    @BindView(R.id.act_tuandi_jutiweizhi)
    TextView actTuandiJutiweizhi;
    @BindView(R.id.act_tuandi_zhuyaochezhan)
    TextView actTuandiZhuyaochezhan;
    @BindView(R.id.act_tuandi_chezhanjuli)
    TextView actTuandiChezhanjuli;
    @BindView(R.id.act_tuandi_chuangwaifengjing)
    TextView actTuandiChuangwaifengjing;
    @BindView(R.id.act_tuandi_gongyongbufen)
    TextView actTuandiGongyongbufen;
    @BindView(R.id.act_tuandi_zhoubianhuanjing)
    TextView actTuandiZhoubianhuanjing;
    @BindView(R.id.act_tuandi_tingchewei)
    TextView actTuandiTingchewei;
    @BindView(R.id.act_tuandi_shineishebei)
    TextView actTuandiShineishebei;
    @BindView(R.id.act_tuandi_chufang)
    TextView actTuandiChufang;
    @BindView(R.id.act_tuandi_weishengjian)
    TextView actTuandiWeishengjian;
    @BindView(R.id.act_tuandi_yushi)
    TextView actTuandiYushi;
    @BindView(R.id.act_tuandi_xingneng)
    TextView actTuandiXingneng;
    @BindView(R.id.act_tuandi_zhengmingshu)
    TextView actTuandiZhengmingshu;
    @BindView(R.id.act_tuandi_xiacibaozhang)
    TextView actTuandiXiacibaozhang;
    @BindView(R.id.act_tuandi_beizhu)
    TextView actTuandiBeizhu;
    private HouseDetailsBean.DatasBean datas;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuandi_more);
        ButterKnife.bind(this);
        datas = (HouseDetailsBean.DatasBean) getIntent().getSerializableExtra("datas");
        if (datas != null) {
            initData();
        }
    }
    private void initData() {
        boolean ja = MyUtils.isJa(mContext);
        actTuandiZujin.setText(ja?datas.getSellingPriceJpn():datas.getSellingPriceCn());/*售价*/
        actTuandiMianji.setText(ja?datas.getAreaJpn():datas.getAreaCn());/*面积*/
        actTuandiChaoxiang.setText(ja?datas.getOrientationJpn():datas.getOrientationCn());/*朝向*/
        actTuandiJutiweizhi.setText(ja?datas.getSpecificLocationJpn():datas.getSpecificLocationCn());/*具体位置*/
        actTuandiChezhanjuli.setText(ja?datas.getStationDistanceJpn():datas.getStationDistanceCn());/*车站距离*/
        actTuandiTingchewei.setText(ja?datas.getParkingSpaceJpn():datas.getParkingSpaceCn());/*停车位*/
        actTuandiShineishebei.setText(ja?datas.getIndoorEquipmentJpn():datas.getIndoorEquipmentCn());/*室内设备*/
        actTuandiBeizhu.setText(ja?datas.getRemarksJpn():datas.getRemarksCn());/*备注*/
        actTuandiLouceng.setText(ja ? datas.getFloorJpn() : datas.getFloorCn());/*楼层*/
        actTuandiDiduan.setText(ja ? datas.getDistrictJpn() : datas.getDistrictCn());/*地段*/
        actTuandiZhuyaochezhan.setText(ja ? datas.getTrainStationJpn() : datas.getTrainStationCn());/*主要车站*/
        actTuandiChuqifeiyong.setText(ja ? datas.getChargeJpn() : datas.getChargeCn());/*初期费用*/
        actTuandiGuanlihuishe.setText(ja ? datas.getManagementSocietyJpn() : datas.getManagementSocietyCn());/*管理会社*/
        actTuandiGuanlifei.setText(ja ? datas.getAdministrativeFeeJpn() : datas.getAdministrativeFeeCn());/*管理费*/
        actTuandiGuanli.setText(ja ? datas.getManageJpn() : datas.getManageCn());/*管理*/
        actTuandiHuxing.setText(ja ? datas.getDoorModelJpn() : datas.getDoorModelCn());/*户型*/
        actTuandiFangjianzhuangkuang.setText(ja ? datas.getBuildingConstructionJpn() : datas.getBuildingConstructionCn());/*建筑构造*/
        actTuandiChuangwaifengjing.setText(ja ? datas.getSceneryJpn() : datas.getSceneryCn());/*窗外风景*/
        actTuandiGongyongbufen.setText(ja ? datas.getCommonPartsJpn() : datas.getCommonPartsCn());/*共用部分*/
        actTuandiZhoubianhuanjing.setText(ja ? datas.getSurroundingsJpn() : datas.getSurroundingsCn());/*周边环境*/
        actTuandiChufang.setText(ja ? datas.getKitchenJpn() : datas.getKitchenCn());/*厨房*/
        actTuandiWeishengjian.setText(ja ? datas.getToiletJpn() : datas.getToiletCn());/*卫生间*/
        actTuandiYushi.setText(ja ? datas.getShowersJpn() : datas.getShowersCn());/*浴室*/
        actTuandiQianyuenianxian.setText(ja ? datas.getSignYearJpn() : datas.getSignYearCn());/*签约年限*/
        actTuandiXiushanfei.setText(ja ? datas.getRepairChargeJpn() : datas.getRepairChargeCn());/*修缮费*/
        actTuandiXingneng.setText(ja ? datas.getPerformanceJpn() : datas.getPerformanceCn());/*性能*/
        actTuandiZhengmingshu.setText(ja ? datas.getTestimonialJpn() : datas.getTestimonialCn());/*证明书*/
        actTuandiXiacibaozhang.setText(ja ? datas.getDefectsEnsureJpn() : datas.getDefectsEnsureCn());/*瑕疵保障*/
        actTuandiShuidiandengfeiyong.setText(ja ? "接口没返回" : "接口没返回");/*水电等费用*/
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
