package com.overseas.overseas.presenter;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.overseas.overseas.MyApplication;
import com.overseas.overseas.base.LoginActivity;
import com.overseas.overseas.bean.HistroyDoneBean;
import com.overseas.overseas.bean.NoDataBean;
import com.overseas.overseas.callback.DialogCallback;
import com.overseas.overseas.callback.JsonCallback;
import com.overseas.overseas.utils.MyUrls;

/**
 * Created by Administrator on 2018/6/27.
 */

public class HistroyPresenter {
    private Activity activity;
    private HistroyCallBack callBack;

    public HistroyPresenter(Activity activity, HistroyCallBack callBack) {
        this.activity = activity;
        this.callBack = callBack;
    }

    public void getHistroyList(int pageNo, int hType, int monthTime) {
        HttpParams params = new HttpParams();
        params.put("pageNo", pageNo);
        params.put("hType", hType);
        if (monthTime != 0)
            params.put("monthTime", monthTime);
        params.put("token", MyApplication.getUserToken());
        OkGo.<HistroyDoneBean>post(MyUrls.BASEURL + "/app/indent/historyindent")
                .tag(this)
                .params(params)
                .execute(new DialogCallback<HistroyDoneBean>(activity, HistroyDoneBean.class) {
                    @Override
                    public void onSuccess(Response<HistroyDoneBean> response) {
                        if (TextUtils.equals(response.body().getCode(), "201")) {
                            activity.startActivity(new Intent(activity, LoginActivity.class));
                            MyApplication.logOut();
                        } else {
                            callBack.getHistroyList(response);
                        }
                    }
                });
    }

    /*删除历史记录*/
    public void deteleHouseRecord(int hId, int hType, int shType) {
        HttpParams params = new HttpParams();
        params.put("token", MyApplication.getUserToken());
        params.put("hType", hType);
        params.put("hId", hId);
        params.put("shType", shType);
        OkGo.<NoDataBean>post(MyUrls.BASEURL + "/app/seehouselog/deletekflog")
                .tag(this)
                .params(params)
                .execute(new JsonCallback<NoDataBean>(NoDataBean.class) {
                    @Override
                    public void onSuccess(Response<NoDataBean> response) {
                        if (TextUtils.equals(response.body().getCode(), "201")) {
                            activity.startActivity(new Intent(activity, LoginActivity.class));
                            MyApplication.logOut();
                        }
                    }
                });
    }

    public interface HistroyCallBack {
        void getHistroyList(Response<HistroyDoneBean> response);
    }
}
