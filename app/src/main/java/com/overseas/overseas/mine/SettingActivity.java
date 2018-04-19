package com.overseas.overseas.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.overseas.overseas.R;
import com.overseas.overseas.base.BaseActivity;
import com.overseas.overseas.base.BaseDialog;
import com.overseas.overseas.base.XieyiActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingActivity extends BaseActivity {

    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.language_layout)
    LinearLayout languageLayout;
    @BindView(R.id.about_layout)
    LinearLayout aboutLayout;
    @BindView(R.id.finish_login)
    Button finishLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back_img, R.id.language_layout, R.id.about_layout, R.id.finish_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_img:
                finish();
                break;
            case R.id.language_layout:
                Intent intent=new Intent(SettingActivity.this,LanguageActivity.class);
                startActivity(intent);
                break;
            case R.id.about_layout:
                Intent intent1=new Intent(SettingActivity.this,XieyiActivity.class);
                startActivity(intent1);
                break;
            case R.id.finish_login:
                showcallDialog();
                break;
        }
    }
    private void showcallDialog() {
        BaseDialog.Builder builder = new BaseDialog.Builder(SettingActivity.this);
        //设置dialogpadding
        //设置显示位置
        //设置动画
        //设置dialog的宽高
        //设置触摸dialog外围是否关闭
        //设置监听事件
        final BaseDialog
                dialog = builder.setViewId(R.layout.item_callnumber)
                //设置dialogpadding
                .setPaddingdp(40, 0, 40, 0)
                //设置显示位置
                .setGravity(Gravity.CENTER)
                //设置动画
                .setAnimation(R.style.bottom_tab_style)
                //设置dialog的宽高
                .setWidthHeightpx(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                //设置触摸dialog外围是否关闭
                .isOnTouchCanceled(true)
                //设置监听事件
                .builder();
        dialog.show();
        Button btnclear = dialog.getView(R.id.btn_call);
        Button btndismiss = dialog.getView(R.id.btn_dismiss);
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btndismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }
}
