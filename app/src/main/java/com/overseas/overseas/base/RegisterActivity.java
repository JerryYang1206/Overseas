package com.overseas.overseas.base;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.overseas.overseas.R;
import com.overseas.overseas.bean.SuccessBean;
import com.overseas.overseas.callback.DialogCallback;
import com.overseas.overseas.utils.MyUrls;
import com.overseas.overseas.utils.MyUtils;
import com.overseas.overseas.utils.SendSmsTimerUtils;

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
    private String QuNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        boolean ja = MyUtils.isJa(this);
        if (!ja){
            tvShowPop.setText("+86");
        }else {
            tvShowPop.setText("+81");
        }


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
                if (TextUtils.isEmpty(edtPhoneNumber.getText().toString())) {
                    Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
                    return;
                }else if (!MyUtils.isMobileNO(edtPhoneNumber.getText().toString())) {
                    Toast.makeText(this, "手机号格式错误", Toast.LENGTH_SHORT).show();
                    return;
                }else if (!TextUtils.isEmpty(edtPhoneNumber.getText().toString())&&MyUtils.isMobileNO(edtPhoneNumber.getText().toString())) {
                    String phone = edtPhoneNumber.getText().toString();
                    String substring = phone.substring(0, 3);
                    if (substring.equals("050") || substring.equals("060") || substring.equals("070") || substring.equals("080") || substring.equals("090")) {
                        QuNumber = "1";//国际
                        if (tvShowPop.getText().equals("+86")) {
                            Toast.makeText(this, "请选择正确的区号", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    } else {
                        QuNumber = "2";//国内
                        if (tvShowPop.getText().equals("+81")) {
                            Toast.makeText(this, "请选择正确的区号", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                    getCode();//验证码接口
                }
                break;
            case R.id.btn_login:
                initNet();
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
    private void initNet() {
        if (TextUtils.isEmpty(edtPhoneNumber.getText().toString())) {
            Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
            return;
        }else if (!MyUtils.isMobileNO(edtPhoneNumber.getText().toString())) {
            Toast.makeText(this, "手机号格式错误", Toast.LENGTH_SHORT).show();
            return;
        }else if (!TextUtils.isEmpty(edtPhoneNumber.getText().toString())&&MyUtils.isMobileNO(edtPhoneNumber.getText().toString())){
            String phone = edtPhoneNumber.getText().toString();
            String substring = phone.substring(0, 3);
            if (substring.equals("050")||substring.equals("060")||substring.equals("070")||substring.equals("080")||substring.equals("090")){
                if (tvShowPop.getText().equals("+86")){
                    Toast.makeText(this, "请选择正确的区号", Toast.LENGTH_SHORT).show();
                    return;
                }
            }else {
                if (tvShowPop.getText().equals("+81")){
                    Toast.makeText(this, "请选择正确的区号", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            if(TextUtils.isEmpty(edtCode.getText().toString())) {
                Toast.makeText(this, "请输入验证码", Toast.LENGTH_SHORT).show();
                return;
            }else if(TextUtils.isEmpty(edtPassword.getText().toString())) {
                Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
                return;
            }else if (!MyUtils.isPswRuleNO(edtPassword.getText().toString())){
                Toast.makeText(this, "请输入6-16位数字和字母组成的密码", Toast.LENGTH_SHORT).show();
            }else if(TextUtils.isEmpty(edtTwoPassword.getText().toString())) {
                Toast.makeText(this, "请输入确认密码", Toast.LENGTH_SHORT).show();
                return;
            }else if(!edtPassword.getText().toString().equals(edtTwoPassword.getText().toString())) {
                Toast.makeText(this, "两次输入的密码不一致，请重新输入", Toast.LENGTH_SHORT).show();
                return;
            }else {
                HttpParams params = new HttpParams();
                params.put("phone", edtPhoneNumber.getText().toString());
                params.put("passWord",edtTwoPassword.getText().toString());
                params.put("codeMsg", edtCode.getText().toString());
                OkGo.<SuccessBean>post(MyUrls.BASEURL + "/app/broker/registeredbroker")
                        .tag(this)
                        .params(params)
                        .execute(new DialogCallback<SuccessBean>(this, SuccessBean.class) {
                            @Override
                            public void onSuccess(Response<SuccessBean> response) {
                                int code = response.code();
                                SuccessBean successBean = response.body();
                                if (successBean.getCode().equals("200")){
                                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                                    finish();
                                    return;
                                }else if (successBean.getCode().equals("-1")){
                                    Toast.makeText(RegisterActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                                    return;
                                }else if (successBean.getCode().equals("207")){
                                    Toast.makeText(RegisterActivity.this, "此号码已被注册", Toast.LENGTH_SHORT).show();
                                    return;
                                }else {
                                    Toast.makeText(RegisterActivity.this, successBean.getMsg()+"", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            }
                        });
            }
        }

    }
    private void getCode() {
        HttpParams params = new HttpParams();
        String quhao;
        if (tvShowPop.getText().equals("+81")){
            quhao="81";
        }else {
            quhao="86";
        }
        params.put("phone", "00"+quhao+edtPhoneNumber.getText().toString());
        params.put("sendType",QuNumber);
        params.put("vPhone",edtPhoneNumber.getText().toString());
        OkGo.<SuccessBean>post(MyUrls.BASEURL + "/send/msg/sendmsg")
                .tag(this)
                .params(params)
                .execute(new DialogCallback<SuccessBean>(this, SuccessBean.class) {
                    @Override
                    public void onSuccess(Response<SuccessBean> response) {
                        int code = response.code();
                        SuccessBean successBean = response.body();
                        if (successBean.getCode().equals("200")){
                            SendSmsTimerUtils.sendSms(tvGetcode, R.color.shihuangse, R.color.shihuangse);
                            Toast.makeText(RegisterActivity.this, "发送成功", Toast.LENGTH_SHORT).show();
                        }else if (successBean.getCode().equals("-1")){
                            Toast.makeText(RegisterActivity.this, "发送失败", Toast.LENGTH_SHORT).show();
                        }else if (successBean.getCode().equals("500")){
                            Toast.makeText(RegisterActivity.this, "内部服务器错误", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(RegisterActivity.this, successBean.getMsg(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    private void initPop() {
        //屏幕变暗
        WindowManager.LayoutParams lp =  getWindow().getAttributes();
        lp.alpha = 0.7f;
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getWindow().setAttributes(lp);

        popupView = View.inflate(this,R.layout.layout_check_popupwindow, null);
        popupView.findViewById(R.id.tv_saoyisao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvShowPop.setText("+86");
                basePopupWindow.dismiss();
            }
        });
        popupView.findViewById(R.id.tv_weiliao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvShowPop.setText("+81");
                basePopupWindow.dismiss();
            }
        });
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
