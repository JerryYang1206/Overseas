package com.overseas.overseas.base;

import android.os.Bundle;
import android.widget.ImageView;

import com.overseas.overseas.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class XieyiActivity extends BaseActivity {

    @BindView(R.id.back_img)
    ImageView backImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xieyi);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.back_img)
    public void onClick() {
        finish();
    }
}
