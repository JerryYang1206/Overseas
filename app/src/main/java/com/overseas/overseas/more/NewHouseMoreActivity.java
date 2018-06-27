package com.overseas.overseas.more;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.overseas.overseas.R;
import com.overseas.overseas.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewHouseMoreActivity extends BaseActivity {

    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.tv_wujian_name)
    TextView tvWujianName;
    @BindView(R.id.tv_house_price)
    TextView tvHousePrice;
    @BindView(R.id.tv_house_huxing)
    TextView tvHouseHuxing;
    @BindView(R.id.tv_dongceng_num)
    TextView tvDongcengNum;
    @BindView(R.id.tv_tudi_area)
    TextView tvTudiArea;
    @BindView(R.id.tv_jianzhu_area)
    TextView tvJianzhuArea;
    @BindView(R.id.tv_house_suoyouquan)
    TextView tvHouseSuoyouquan;
    @BindView(R.id.tv_house_years)
    TextView tvHouseYears;
    @BindView(R.id.tv_jianzhu_gongsi)
    TextView tvJianzhuGongsi;
    @BindView(R.id.tv_house_gouzao)
    TextView tvHouseGouzao;
    @BindView(R.id.tv_house_chaoxiang)
    TextView tvHouseChaoxiang;
    @BindView(R.id.tv_house_fugailv)
    TextView tvHouseFugailv;
    @BindView(R.id.tv_house_rongjilv)
    TextView tvHouseRongjilv;
    @BindView(R.id.tv_ruzhu_riqi)
    TextView tvRuzhuRiqi;
    @BindView(R.id.tv_house_xianzhuang)
    TextView tvHouseXianzhuang;
    @BindView(R.id.tv_stop_car)
    TextView tvStopCar;
    @BindView(R.id.tv_house_gongkai)
    TextView tvHouseGongkai;
    @BindView(R.id.tv_house_diduan)
    TextView tvHouseDiduan;
    @BindView(R.id.tv_house_jutiweizhi)
    TextView tvHouseJutiweizhi;
    @BindView(R.id.tv_house_zhuyaochezhan)
    TextView tvHouseZhuyaochezhan;
    @BindView(R.id.tv_house_chezhanjuli)
    TextView tvHouseChezhanjuli;
    @BindView(R.id.tv_house_linjiejuli)
    TextView tvHouseLinjiejuli;
    @BindView(R.id.tv_house_tudi)
    TextView tvHouseTudi;
    @BindView(R.id.tv_house_shebei)
    TextView tvHouseShebei;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_house_more);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.back_img)
    public void onViewClicked() {
        finish();
    }
}
