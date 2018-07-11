package com.overseas.overseas.presenter;

import android.app.Activity;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.overseas.overseas.MyApplication;
import com.overseas.overseas.callback.JsonCallback;
import com.overseas.overseas.model.NoDataBean;
import com.overseas.overseas.model.UserBean;
import com.overseas.overseas.utils.MyUrls;

/**
 * admin  2018/6/13
 */
public class FromPhonePresenter {
    private Activity activity;
    private PhoneCallBack callBack;

    public FromPhonePresenter(Activity activity, PhoneCallBack callBack) {
        this.activity = activity;
        this.callBack = callBack;
    }

    /**
     * 获取手机号
     *
     * @param userId
     */
    public void getUserPhone(String userId) {
        HttpParams params = new HttpParams();
        params.put("userId", userId);
        params.put("brokerId", MyApplication.getUserId(activity));
        OkGo.<UserBean>post(MyUrls.BASEURL + "/app/user/getuserinfo")
                .tag(this)
                .params(params)
                .execute(new JsonCallback<UserBean>(UserBean.class) {
                    @Override
                    public void onSuccess(Response<UserBean> response) {
                        callBack.getUserPhone(response);
                    }
                });
    }

    /**
     * 添加联系人
     *
     * @param brokerId
     */
    public void addLinkman(String brokerId) {
        HttpParams params = new HttpParams();
        params.put("userId", MyApplication.getUserId(activity));
        params.put("brokerId", brokerId);
        OkGo.<NoDataBean>post(MyUrls.BASEURL + "/app/contact/insertcontact")
                .tag(this)
                .params(params)
                .execute(new JsonCallback<NoDataBean>(NoDataBean.class) {
                    @Override
                    public void onSuccess(Response<NoDataBean> response) {

                    }
                });
    }

    /**
     * 删除联系人
     *
     * @param brokerId
     */
    public void deteleLinkman(String brokerId) {
        HttpParams params = new HttpParams();
        params.put("userId", MyApplication.getUserId(activity));
        params.put("brokerId", brokerId);
        OkGo.<NoDataBean>post(MyUrls.BASEURL + "/app/contact/deletecontact")
                .tag(this)
                .params(params)
                .execute(new JsonCallback<NoDataBean>(NoDataBean.class) {
                    @Override
                    public void onSuccess(Response<NoDataBean> response) {

                    }
                });
    }

    /**
     * @param brokerId
     */
    public void recordReply(String brokerId) {
        HttpParams params = new HttpParams();
        params.put("userId", brokerId);
        params.put("brokerId", MyApplication.getUserId(activity));
        OkGo.<NoDataBean>post(MyUrls.BASEURL + "/app/brokerrevler/updaterevertstate")
                .tag(this)
                .params(params)
                .execute(new JsonCallback<NoDataBean>(NoDataBean.class) {
                    @Override
                    public void onSuccess(Response<NoDataBean> response) {

                    }
                });
    }

    public interface PhoneCallBack {
        void getUserPhone(Response<UserBean> response);
    }
}
