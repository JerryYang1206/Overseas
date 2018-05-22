package com.overseas.overseas.more;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.overseas.overseas.R;
import com.overseas.overseas.base.BaseActivity;

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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiezilou_more);
        ButterKnife.bind(this);

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
