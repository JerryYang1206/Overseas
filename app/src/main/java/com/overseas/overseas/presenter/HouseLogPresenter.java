package com.overseas.overseas.presenter;

import android.app.Activity;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.overseas.overseas.bean.NoDataBean;
import com.overseas.overseas.callback.JsonCallback;
import com.overseas.overseas.utils.MyUrls;
import com.overseas.overseas.utils.SharedPreferencesUtils;

/**
 * admin  2018/6/9
 */
public class HouseLogPresenter {
    private Activity activity;

    public HouseLogPresenter(Activity activity) {
        this.activity = activity;
    }

    /**
     * 看房日志
     * @param houseType
     * @param houseId
     * @param shType
     */
    public void setHouseLog(String houseType, String houseId, String shType){
        HttpParams params = new HttpParams();
        params.put("token", SharedPreferencesUtils.getInstace(activity).getStringPreference("token",""));
        params.put("houseType", houseType);
        params.put("houseId", houseId);
        params.put("shType", shType);
        OkGo.<NoDataBean>post(MyUrls.BASEURL + "/app/seehouselog/insertkflog")
                .tag(this)
                .params(params)
                .execute(new JsonCallback<NoDataBean>(NoDataBean.class) {
                    @Override
                    public void onSuccess(Response<NoDataBean> response) {
                    }
                });
    }
}
