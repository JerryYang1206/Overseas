package com.overseas.overseas.base;

import android.Manifest;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
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
import com.overseas.overseas.MainActivity;
import com.overseas.overseas.R;
import com.overseas.overseas.bean.LoginBean;
import com.overseas.overseas.callback.DialogCallback;
import com.overseas.overseas.im.RcConnect;
import com.overseas.overseas.utils.CacheUtils;
import com.overseas.overseas.utils.Constants;
import com.overseas.overseas.utils.MyUrls;
import com.overseas.overseas.utils.MyUtils;
import com.overseas.overseas.utils.SharedPreferencesUtils;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.rong.imkit.RongIM;
import io.rong.imlib.model.Conversation;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.edt_phone_number)
    EditText edtPhoneNumber;
    @BindView(R.id.edt_password)
    EditText edtPassword;
    @BindView(R.id.edt_code)
    EditText edtCode;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_show_pop)
    TextView tvShowPop;
    private View popupView;
    private PopupWindow basePopupWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        boolean ja = MyUtils.isJa(this);
        if (!ja){
            tvShowPop.setText("+86");
        }else {
            tvShowPop.setText("+81");
        }

        ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE},
                1);
    }

    @OnClick({R.id.back_img, R.id.tv_register, R.id.btn_login,R.id.tv_show_pop})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_img:
                //                startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                HashMap<String, Boolean> hashMap = new HashMap<>();
//                //会话类型 以及是否聚合显示
//                hashMap.put(Conversation.ConversationType.PRIVATE.getName(), false);
////        hashMap.put(Conversation.ConversationType.PUSH_SERVICE.getName(),true);
////        hashMap.put(Conversation.ConversationType.SYSTEM.getName(),true);
//                RongIM.getInstance().startConversationList(this, hashMap);
                finish();
                break;
            case R.id.tv_register:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                finish();
                break;
            case R.id.btn_login:
                initLoginNet();

//                HashMap<String, Boolean> hashMap = new HashMap<>();
//                //会话类型 以及是否聚合显示
//                hashMap.put(Conversation.ConversationType.PRIVATE.getName(), false);
////        hashMap.put(Conversation.ConversationType.PUSH_SERVICE.getName(),true);
////        hashMap.put(Conversation.ConversationType.SYSTEM.getName(),true);
//                RongIM.getInstance().startConversationList(this, hashMap);

                break;
            case R.id.tv_show_pop:
                initPop();
                basePopupWindow.showAsDropDown(view);
                break;
        }
    }


    private void initLoginNet() {
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
            if(TextUtils.isEmpty(edtPassword.getText().toString())) {
                Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
                return;
            }else if (!MyUtils.isPswRuleNO(edtPassword.getText().toString())){
                Toast.makeText(this, "请输入6-16位数字和字母组成的密码", Toast.LENGTH_SHORT).show();
            }else if (TextUtils.isEmpty(edtCode.getText().toString())){
                Toast.makeText(this, "请输入验证码", Toast.LENGTH_SHORT).show();
            }else {
                HttpParams params = new HttpParams();
                params.put("tPhone", edtPhoneNumber.getText().toString());
                params.put("passWord", edtPassword.getText().toString());
                OkGo.<LoginBean>post(MyUrls.BASEURL + "/app/user/login")
                        .tag(this)
                        .params(params)
                        .execute(new DialogCallback<LoginBean>(this, LoginBean.class) {
                            @Override
                            public void onSuccess(Response<LoginBean> response) {
                                int code = response.code();
                                LoginBean loginBean = response.body();
//                                Log.d("LoginActivity", LoginBean.getCode()+"-------------");
                                if (loginBean.getCode().equals("200")){
                                    SharedPreferencesUtils.getInstace(LoginActivity.this).setStringPreference("uid",loginBean.getDatas().getId()+"");
                                    SharedPreferencesUtils.getInstace(LoginActivity.this).setStringPreference("token",loginBean.getDatas().getToken()+"");
                                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                    Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                                    RcConnect.rongCloudConection(loginBean.getDatas().getRongCloudToken());

                                    CacheUtils.put(Constants.USERINFO, loginBean.getDatas());
                                    HashMap<String, Boolean> hm = new HashMap<>();
                                    hm.put(Conversation.ConversationType.PRIVATE.getName(), false);
                                    RongIM.getInstance().startConversationList(LoginActivity.this, hm);
                                    finish();
                                }else if (loginBean.getCode().equals("-1")){
                                    Toast.makeText(LoginActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
                                }else if (loginBean.getCode().equals("206")){
                                    Toast.makeText(LoginActivity.this, "用户名或者密码错误", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        }

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
