package com.overseas.overseas.presenter;

import android.app.Activity;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.overseas.overseas.MyApplication;
import com.overseas.overseas.callback.DialogCallback;
import com.overseas.overseas.callback.JsonCallback;
import com.overseas.overseas.model.LinkmanBean;
import com.overseas.overseas.model.NoDataBean;
import com.overseas.overseas.utils.MyUrls;

/**
 * admin  2018/6/13
 */
public class LinkmanPresenter {
    private Activity activity;

    private LinkmanCallBack callBack;

    public LinkmanPresenter(Activity activity, LinkmanCallBack callBack) {
        this.activity = activity;
        this.callBack = callBack;
    }

    /**
     * 获取联系人列表
     */
    public void getLinkmanList() {
        HttpParams params = new HttpParams();
        params.put("token", MyApplication.getUserToken());
        OkGo.<LinkmanBean>post(MyUrls.BASEURL + "/app/contact/mycontactbybroker")
                .tag(this)
                .params(params)
                .execute(new DialogCallback<LinkmanBean>(activity, LinkmanBean.class) {
                    @Override
                    public void onSuccess(Response<LinkmanBean> response) {
                        callBack.getLinkmanList(response);
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

    public interface LinkmanCallBack {
        void getLinkmanList(Response<LinkmanBean> response);

        void getLinkmanListFail();
    }

}
