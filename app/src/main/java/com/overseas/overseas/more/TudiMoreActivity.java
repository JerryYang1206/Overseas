package com.overseas.overseas.more;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.overseas.overseas.R;
import com.overseas.overseas.base.BaseActivity;
import com.overseas.overseas.bean.TudiDetailsBean;
import com.overseas.overseas.utils.MyUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by   admin on 2018/5/18.
 */

public class TudiMoreActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.act_tudi_shoujia)
    TextView actTudiShoujia;
    @BindView(R.id.act_tudi_mianji)
    TextView actTudiMianji;
    @BindView(R.id.act_tudi_suoyouquan)
    TextView actTudiSuoyouquan;
    @BindView(R.id.act_tudi_weizhi)
    TextView actTudiWeizhi;
    @BindView(R.id.act_tudi_jutiweizhi)
    TextView actTudiJutiweizhi;
    @BindView(R.id.act_tudi_chezhanjuli)
    TextView actTudiChezhanjuli;
    @BindView(R.id.act_tudi_jianzhufugailv)
    TextView actTudiJianzhufugailv;
    @BindView(R.id.act_tudi_rongjilv)
    TextView actTudiRongjilv;
    @BindView(R.id.act_tudi_huibaolv)
    TextView actTudiHuibaolv;
    @BindView(R.id.act_tudi_shifoujiejiao)
    TextView actTudiShifoujiejiao;
    @BindView(R.id.act_tudi_nengfougaojianzhu)
    TextView actTudiNengfougaojianzhu;
    @BindView(R.id.act_tudi_zhouweifengjing)
    TextView actTudiZhouweifengjing;
    @BindView(R.id.act_tudi_zhouweihuanjing)
    TextView actTudiZhouweihuanjing;
    @BindView(R.id.act_tudi_jineng)
    TextView actTudiJineng;
    @BindView(R.id.act_tudi_beizhu)
    TextView actTudiBeizhu;
    private TudiDetailsBean.DatasBean datas;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tudi_more);
        ButterKnife.bind(this);
        datas = (TudiDetailsBean.DatasBean) getIntent().getSerializableExtra("datas");
        if (datas != null) {
            initData();
        }

    }
    private void initData() {
        boolean ja = MyUtils.isJa(mContext);
        actTudiShoujia.setText(ja ? datas.getSellingPriceJpn() : datas.getSellingPriceCn());/*售价*/
        actTudiMianji.setText(ja ? datas.getAreaJpn() : datas.getAreaCn());/*面积*/
        actTudiSuoyouquan.setText(ja ? datas.getOwnershipJpn() : datas.getOwnershipCn());/*所有权*/
        actTudiWeizhi.setText(ja ? datas.getLocationJpn() : datas.getLocationCn());/*位置*/
        actTudiJutiweizhi.setText(ja ? datas.getSpecificLocationJpn() : datas.getSpecificLocationCn());/*具体位置*/
        actTudiChezhanjuli.setText(ja ? datas.getStationJpn() : datas.getStationCn());/*车站距离*/
        actTudiJianzhufugailv.setText(ja ? datas.getBuildingCoverageJpn() : datas.getBuildingCoverageCn());/*建筑覆盖率*/
        actTudiRongjilv.setText(ja ? datas.getPlotRatioJpn() : datas.getPlotRatioCn());/*容积率*/
        actTudiHuibaolv.setText(ja ? datas.getReturnRateJpn() : datas.getReturnRateCn());/*回报率*/
        actTudiShifoujiejiao.setText(ja ? datas.getCornerJpn() : datas.getCornerCn());/*是否街角*/
        actTudiNengfougaojianzhu.setText(ja ? datas.getTallShipsJpn() : datas.getTallShipsCn());/*能否高建筑*/
        actTudiZhouweifengjing.setText(ja ? datas.getAroundSceneryJpn() : datas.getAroundSceneryCn());/*周围风景*/
//        actTudiZhouweihuanjing.setText(ja ? datas.getRestsJpn() : datas.getRestsCn());/*周围环境*/
        actTudiJineng.setText(ja ? datas.getEngineryJpn() : datas.getEngineryCn());/*机能*/
        actTudiBeizhu.setText(ja ? datas.getRemarksJpn() : datas.getRemarksCn());/*备注*/

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
