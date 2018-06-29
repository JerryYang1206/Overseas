package com.overseas.overseas.presenter;

import android.app.Activity;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.overseas.overseas.MyApplication;
import com.overseas.overseas.bean.NoDataBean;
import com.overseas.overseas.bean.UserInfo;
import com.overseas.overseas.callback.DialogCallback;
import com.overseas.overseas.callback.JsonCallback;
import com.overseas.overseas.utils.MyUrls;

/**
 * admin  2018/6/6
 */
public class UserPresenter {
    private Activity activity;
    private UserCallBack callBack;

    public UserPresenter(Activity activity, UserCallBack callBack) {
        this.activity = activity;
        this.callBack = callBack;
    }

    /**
     * 获取用户信息
     */
    public void getUserInfo() {
        HttpParams params = new HttpParams();
        params.put("token", MyApplication.getUserToken());
        OkGo.<UserInfo>post(MyUrls.BASEURL + "/app/broker/myhome")
                .tag(this)
                .params(params)
                .execute(new JsonCallback<UserInfo>(UserInfo.class) {
                    @Override
                    public void onSuccess(Response<UserInfo> response) {
                        callBack.getUserInfo(response);
                    }
                });
    }

    /**
     * 更新用户信息
     *
     * @param token
     * @param nickName
     * @param sex
     */
    public void updateUserInfo(String token, String nickName, int sex, String birthday, String picUrl) {
        HttpParams params = new HttpParams();
        params.put("token", token);
        params.put("nickName", nickName);
        params.put("sex", sex);
        params.put("birthday", birthday);
        params.put("picUrl", picUrl);
        OkGo.<NoDataBean>post(MyUrls.BASEURL + "/app/broker/updatebroker")
                .tag(this)
                .params(params)
                .execute(new DialogCallback<NoDataBean>(activity, NoDataBean.class) {
                    @Override
                    public void onSuccess(Response<NoDataBean> response) {
                        callBack.updateUserInfo(response);
                    }
                });
    }

    public interface UserCallBack {
        void getUserInfo(Response<UserInfo> response);
        void updateUserInfo(Response<NoDataBean> response);
    }
}
