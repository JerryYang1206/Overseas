package com.overseas.overseas.presenter;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.overseas.overseas.MyApplication;
import com.overseas.overseas.base.LoginActivity;
import com.overseas.overseas.bean.MyPingjiaBean;
import com.overseas.overseas.callback.DialogCallback;
import com.overseas.overseas.utils.MyUrls;


/**
 * Created by Administrator on 2018/6/27.
 */

public class MyPingjiaPresenter {
    private Activity activity;
    private PingjiaCallBack callBack;

    public MyPingjiaPresenter(Activity activity, PingjiaCallBack callBack) {
        this.activity = activity;
        this.callBack = callBack;
    }

    public void getAllPingjiaData(int pageNo) {
        HttpParams params = new HttpParams();
        params.put("pageNo", pageNo);
        params.put("token", MyApplication.getUserToken());
        OkGo.<MyPingjiaBean>post(MyUrls.BASEURL + "/app/fivestar/mycomments")
                .tag(this)
                .params(params)
                .execute(new DialogCallback<MyPingjiaBean>(activity, MyPingjiaBean.class) {
                    @Override
                    public void onSuccess(Response<MyPingjiaBean> response) {
                        if (TextUtils.equals(response.body().getCode(), "201")) {
                            activity.startActivity(new Intent(activity, LoginActivity.class));
                            MyApplication.logOut();
                        } else {
                            callBack.getAllPingjiaData(response);
                        }
                    }
                });
    }

    public interface PingjiaCallBack {
        void getAllPingjiaData(Response<MyPingjiaBean> response);
    }
}
