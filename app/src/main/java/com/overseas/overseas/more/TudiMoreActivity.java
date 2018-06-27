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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tudi_more);
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
