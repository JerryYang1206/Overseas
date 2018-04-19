package com.overseas.overseas.base;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.overseas.overseas.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity {

    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.edt_phone_number)
    EditText edtPhoneNumber;
    @BindView(R.id.edt_code)
    EditText edtCode;
    @BindView(R.id.tv_getcode)
    TextView tvGetcode;
    @BindView(R.id.edt_password)
    EditText edtPassword;
    @BindView(R.id.edt_two_password)
    EditText edtTwoPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_xieyi)
    TextView tvXieyi;
    @BindView(R.id.tv_show_pop)
    TextView tvShowPop;
    private View popupView;
    private PopupWindow basePopupWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back_img, R.id.tv_register, R.id.tv_getcode, R.id.btn_login, R.id.tv_xieyi,R.id.tv_show_pop})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_img:
                finish();
                break;
            case R.id.tv_register:
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                break;
            case R.id.tv_getcode:
                break;
            case R.id.btn_login:
                break;
            case R.id.tv_xieyi:
                startActivity(new Intent(RegisterActivity.this, XieyiActivity.class));
                break;
            case R.id.tv_show_pop:
                initPop();
                basePopupWindow.showAsDropDown(view);
                break;
        }
    }
    private void initPop() {
        //屏幕变暗
        WindowManager.LayoutParams lp =  getWindow().getAttributes();
        lp.alpha = 0.7f;
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getWindow().setAttributes(lp);

        popupView = View.inflate(RegisterActivity.this,R.layout.layout_check_popupwindow, null);

        basePopupWindow = (PopupWindow) new PopupWindow(popupView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        basePopupWindow.setTouchable(true);
        basePopupWindow.setOutsideTouchable(true);
        basePopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        //消失的监听，屏幕还原
        basePopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp =  getWindow().getAttributes();
                lp.alpha = 1.0f;
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                getWindow().setAttributes(lp);
            }
        });
    }
}
