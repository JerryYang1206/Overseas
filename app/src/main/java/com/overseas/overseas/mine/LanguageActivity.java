package com.overseas.overseas.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.overseas.overseas.R;
import com.overseas.overseas.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LanguageActivity extends BaseActivity {

    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.tv_baocun)
    TextView tvBaocun;
    @BindView(R.id.language_layout)
    LinearLayout languageLayout;
    @BindView(R.id.about_layout)
    LinearLayout aboutLayout;
    @BindView(R.id.img_check_zhongwen)
    ImageView imgCheckZhongwen;
    @BindView(R.id.img_check_riwen)
    ImageView imgCheckRiwen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back_img, R.id.tv_baocun, R.id.language_layout, R.id.about_layout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_img:
                finish();
                break;
            case R.id.tv_baocun:
                finish();
                break;
            case R.id.language_layout:
                imgCheckZhongwen.setVisibility(View.VISIBLE);
                imgCheckRiwen.setVisibility(View.GONE);
                break;
            case R.id.about_layout:
                imgCheckZhongwen.setVisibility(View.GONE);
                imgCheckRiwen.setVisibility(View.VISIBLE);
                break;
        }
    }
}
