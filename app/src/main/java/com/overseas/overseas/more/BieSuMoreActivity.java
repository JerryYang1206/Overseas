package com.overseas.overseas.more;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.overseas.overseas.MyApplication;
import com.overseas.overseas.R;
import com.overseas.overseas.base.BaseActivity;
import com.overseas.overseas.bean.VillaDetailsBean;
import com.overseas.overseas.utils.CacheUtils;
import com.overseas.overseas.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by   admin on 2018/5/18.
 */

public class BieSuMoreActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.act_biesu_wujianmingcheng)
    TextView tvWujianmingcheng;
    @BindView(R.id.act_biesu_shoujia)
    TextView tvShoujia;
    @BindView(R.id.act_biesu_huxing)
    TextView tvHuxing;
    @BindView(R.id.act_biesu_dongcengshu)
    TextView tvDongcengshu;
    @BindView(R.id.act_biesu_tudimianji)
    TextView tvTudimianji;
    @BindView(R.id.act_biesu_jianzumianji)
    TextView tvJianzumianji;
    @BindView(R.id.act_biesu_suoyouquan)
    TextView tvSuoyouquan;
    @BindView(R.id.act_biesu_jianzhunianfen)
    TextView tvJianzhunianfen;
    @BindView(R.id.act_biesu_jianzhushejigongsi)
    TextView tvJianzhushejigongsi;
    @BindView(R.id.act_biesu_jianzhugouzao)
    TextView tvJianzhugouzao;
    @BindView(R.id.act_biesu_chaoxiang)
    TextView tvChaoxiang;
    @BindView(R.id.act_biesu_jianzhufugai)
    TextView tvJianzhufugai;
    @BindView(R.id.act_biesu_rongjilv)
    TextView tvRongjilv;
    @BindView(R.id.act_biesu_rujuriqi)
    TextView tvRujuriqi;
    @BindView(R.id.act_biesu_xianzhuang)
    TextView tvXianzhuang;
    @BindView(R.id.act_biesu_tingchechang)
    TextView tvTingchechang;
    @BindView(R.id.act_biesu_gongkaiqingbaori)
    TextView tvGongkaiqingbaori;
    @BindView(R.id.act_biesu_diduan)
    TextView tvDiduan;
    @BindView(R.id.act_biesu_jutiweizhi)
    TextView tvJutiweizhi;
    @BindView(R.id.act_biesu_zhuyaochezhan)
    TextView tvZhuyaochezhan;
    @BindView(R.id.act_biesu_chezhanjuli)
    TextView tvChezhanjuli;
    @BindView(R.id.act_biesu_daolulinjiejuli)
    TextView tvDaolulinjiejuli;
    @BindView(R.id.act_biesu_tudi)
    TextView tvTudi;
    @BindView(R.id.act_biesu_shineishebei)
    TextView tvShineishebei;
    @BindView(R.id.act_biesu_chufang)
    TextView tvChufang;
    @BindView(R.id.act_biesu_weishengjian)
    TextView tvWeishengjian;
    @BindView(R.id.act_biesu_yushi)
    TextView tvYushi;
    @BindView(R.id.act_biesu_xingneng)
    TextView tvXingneng;
    @BindView(R.id.act_biesu_zhengmingshu)
    TextView tvZhengmingshu;
    @BindView(R.id.act_biesu_xiacibaozhang)
    TextView tvXiacibaozhang;
    @BindView(R.id.act_biesu_beizhu)
    TextView tvBeizhu;

    private VillaDetailsBean.DatasBean datasBean;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biesu_more);
        ButterKnife.bind(this);

        datasBean = getIntent().getParcelableExtra("details");

        String country = CacheUtils.get(Constants.COUNTRY);


        show();

    }

    private void show() {
        if (datasBean != null) {
            tvWujianmingcheng.setText(MyApplication.isJapanese() ? datasBean.getArticleNameJpn() : datasBean.getArticleNameCn());
            tvShoujia.setText(MyApplication.isJapanese() ? datasBean.getSellingPriceJpn() : datasBean.getSellingPriceCn());
            tvHuxing.setText(MyApplication.isJapanese() ? datasBean.getVillaTypeJpn() : datasBean.getVillaTypeCn());
            tvDongcengshu.setText(MyApplication.isJapanese() ? datasBean.getHomesLayerJpn() : datasBean.getHomesLayerCn());
            tvTudimianji.setText(MyApplication.isJapanese() ? datasBean.getAreaJpn() : datasBean.getAreaCn());
            tvJianzumianji.setText(MyApplication.isJapanese() ? datasBean.getCoveredAreaJpn() : datasBean.getCoveredAreaCn());
            tvSuoyouquan.setText(MyApplication.isJapanese() ? datasBean.getOwnershipJpn() : datasBean.getOwnershipCn());
            tvJianzhunianfen.setText(MyApplication.isJapanese() ? datasBean.getYearBuiltJpn() : datasBean.getYearBuiltCn());
            tvJianzhushejigongsi.setText(MyApplication.isJapanese() ? datasBean.getArchitecturalJpn() : datasBean.getArchitecturalCn());
            tvJianzhugouzao.setText(MyApplication.isJapanese() ? datasBean.getBuildingConstructionJpn() : datasBean.getBuildingConstructionCn());
            tvChaoxiang.setText(MyApplication.isJapanese() ? datasBean.getOrientationJpn() : datasBean.getOrientationCn());
            tvJianzhufugai.setText(datasBean.getBuildingWrap());
            tvRongjilv.setText(datasBean.getPlotRatio());
            tvRujuriqi.setText(MyApplication.isJapanese() ? datasBean.getDoichoIrinoDateJpn() : datasBean.getDoichoIrinoDateCn());
            tvXianzhuang.setText(MyApplication.isJapanese() ? datasBean.getCurrentSituationJpn() : datasBean.getCurrentSituationCn());
            tvTingchechang.setText(MyApplication.isJapanese() ? datasBean.getParkJpn() : datasBean.getParkCn());
            tvGongkaiqingbaori.setText(MyApplication.isJapanese() ? datasBean.getPublicInformationDayJpn() : datasBean.getPublicInformationDayCn());
            tvDiduan.setText(MyApplication.isJapanese() ? datasBean.getDistrictJpn() : datasBean.getDistrictCn());
            tvJutiweizhi.setText(MyApplication.isJapanese() ? datasBean.getSpecificLocationJpn() : datasBean.getSpecificLocationCn());
            tvZhuyaochezhan.setText(MyApplication.isJapanese() ? datasBean.getTrainStationJpn() : datasBean.getTrainStationCn());
            tvChezhanjuli.setText(MyApplication.isJapanese() ? datasBean.getStationDistanceJpn() : datasBean.getStationDistanceCn());
            tvDaolulinjiejuli.setText(MyApplication.isJapanese() ? datasBean.getStreetDistanceJpn() : datasBean.getStreetDistanceCn());
            tvTudi.setText(MyApplication.isJapanese() ? datasBean.getLandJpn() : datasBean.getLandCn());
            tvShineishebei.setText(MyApplication.isJapanese() ? datasBean.getIndoorFacilityJpn() : datasBean.getIndoorFacilityCn());
            tvChufang.setText(MyApplication.isJapanese() ? datasBean.getKitchenJpn() : datasBean.getKitchenCn());
            tvWeishengjian.setText(MyApplication.isJapanese() ? datasBean.getToiletJpn() : datasBean.getToiletCn());
            tvYushi.setText(MyApplication.isJapanese() ? datasBean.getShowerRoomJpn() : datasBean.getShowerRoomCn());
            tvXingneng.setText(MyApplication.isJapanese() ? datasBean.getPerformanceJpn() : datasBean.getPerformanceCn());
            tvZhengmingshu.setText(MyApplication.isJapanese() ? datasBean.getTestimonialJpn() :datasBean.getTestimonialCn());
            tvXiacibaozhang.setText(MyApplication.isJapanese() ? datasBean.getDefectsEnsureJpn() : datasBean.getDefectsEnsureCn());
            tvBeizhu.setText(MyApplication.isJapanese() ? datasBean.getRemarkJpn() : datasBean.getRemarkCn());
        }
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
