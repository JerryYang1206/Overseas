package com.overseas.overseas.im;

import android.net.Uri;
import android.util.Log;


import com.overseas.overseas.utils.CacheUtils;
import com.overseas.overseas.utils.Constants;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.UserInfo;

/**
 * admin  2018/6/12
 */
public class RcConnect {

    public static void rongCloudConection(String token){
        RongIM.connect(token, new RongIMClient.ConnectCallback() {
            @Override
            public void onSuccess(String s) {
                Log.e("MainActivity", "——onSuccess—-" +
                        s.toString());
                setUserInfo();
            }

            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                Log.e("MainActivity", "——onError—-" +
                        errorCode);
            }

            @Override
            public void onTokenIncorrect() {
                //Connect Token 失效的状态处理，需要重新获取 Token
            }
        });
    }

    public static void setUserInfo(){
//        LoginBean.DatasBean loginBean = CacheUtils.get(Constants.USERINFO);

//        if (loginBean == null)
//            return;

//        RongIM.getInstance().setCurrentUserInfo(new UserInfo(loginBean.getId() + "", loginBean.getNickname(), Uri.parse(loginBean.getPic())));
//        RongIM.setUserInfoProvider(new RongIM.UserInfoProvider() {
//            @Override
//            public UserInfo getUserInfo(String s) {
//                return new UserInfo(loginBean.getId() + "", loginBean.getNickname(), Uri.parse(loginBean.getPic()));
//            }
//        }, true);
    }
}
