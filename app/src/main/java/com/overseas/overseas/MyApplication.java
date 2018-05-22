package com.overseas.overseas;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.util.Log;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;


/**
 * Created by Administrator on 2017/8/24.
 */

public class MyApplication extends Application {
    private static MyApplication application;

    public static final String token1 = "f2+AlWV8zuooyGsXatiiuZtacAbWKJAKs7xt/96ZapGfFyCIuQAUQ6GvccmqXXIgyZaVJawFDNQXfFYeg33Oyw==";

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;

//        //融云
/**
 *
 * OnCreate 会被多个进程重入，这段保护代码，确保只有您需要使用 RongIM 的进程和 Push 进程执行了 init。
 * io.rong.push 为融云 push 进程名称，不可修改。
 */
//        if (getApplicationInfo().packageName.equals(getCurProcessName(getApplicationContext())) ||
//                "io.rong.push".equals(getCurProcessName(getApplicationContext()))) {

            /**
             * IMKit SDK调用第一步 初始化
             */
            RongIM.init(this);

//            if (getApplicationInfo().packageName.equals(getCurProcessName(getApplicationContext()))) {
//
//                DemoContext.init(this);
//            }
//        }
//
//
        /**
         * f2+AlWV8zuooyGsXatiiuZtacAbWKJAKs7xt/96ZapGfFyCIuQAUQ6GvccmqXXIgyZaVJawFDNQXfFYeg33Oyw==111111
         *
         * zZpOAITWWL4fpEnEryMT6W7tnvnoFRHtvRSk65MeRaWjhNUpICiAMeAsdWqpv9eZkCcfaLVPfU4emRfjS8IkRA==123456
         * yX1H7qaDlNpvL6rQWVenj5tacAbWKJAKs7xt/96ZapGfFyCIuQAUQ02TzGZx9B3ZHSPOvW5317G0rTlvfACy9w==12345
         */


        RongIM.connect(token1, new RongIMClient.ConnectCallback() {
            @Override
            public void onSuccess(String s) {
                Log.e("MainActivity", "——onSuccess—-" +
                        s.toString());
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


//        List<IExtensionModule> moduleList = RongExtensionManager.getInstance().getExtensionModules();
//        IExtensionModule defaultModule = null;
//        if (moduleList != null) {
//            for (IExtensionModule module : moduleList) {
//                if (module instanceof DefaultExtensionModule) {
//                    defaultModule = module;
//                    break;
//                }
//            }
//            if (defaultModule != null) {
//                RongExtensionManager.getInstance().unregisterExtensionModule(defaultModule);
//                RongExtensionManager
//                        .getInstance().registerExtensionModule();
//            }
//        }

//        RongIM.getInstance().refreshUserInfoCache(new UserInfo("111111", "六个一", Uri.parse("http://f9.topitme.com/9/37/30/11224703137bb30379o.jpg")));

//        RongIM.setOnReceiveMessageListener(new RongIMClient.OnReceiveMessageListener() {
//            @Override
//            public boolean onReceived(Message message, int i) {
//                Log.e("MainActivity", "——onSuccess—-" +
//                        message.getContent().toString() + "----" + message.getTargetId().toString());
//                return false;
//            }
//        });

//        OkGo.post("http://api.cn.ronghub.com/user/getToken.json")//URL
//                .tag(this)
//                .params("userId","12345")
//                .params("name","name")
//                .params("portraitUri","http://img1.imgtn.bdimg.com/it/u=3920398476,1501488149&fm=27&gp=0.jpg")
//                .execute(new JsonCallback<Object>() {
//                    @Override
//                    public void onSuccess(com.lzy.okgo.model.Response<Object> response) {
//                          Log.i("===========>>response", response.message().toString());
//                    }
//
//                    @Override
//                    public void onError(Response<Object> response) {
//                        super.onError(response);
//                    }
//
//                    @Override
//                    public void onFinish() {
//                        super.onFinish();
//                    }
//
//                });
    }


    public void setMyExtensionModule() {
//        List<IExtensionModule> moduleList = RongExtensionManager.getInstance().getExtensionModules();
//        IExtensionModule defaultModule = null;
//        if (moduleList != null) {
//            for (IExtensionModule module : moduleList) {
//                if (module instanceof DefaultExtensionModule) {
//                    defaultModule = module;
//                    break;
//                }
//            }
//            if (defaultModule != null) {
//                RongExtensionManager.getInstance().unregisterExtensionModule(defaultModule);
//                RongExtensionManager.getInstance().registerExtensionModule(new MyExtensionModule());
//            }
//        }
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//        MultiDex.install(this);


    }

    /**
     * 获得当前进程的名字
     *
     * @param context
     * @return
     */
    public static String getCurProcessName(Context context) {

        int pid = android.os.Process.myPid();

        ActivityManager activityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);

        for (ActivityManager.RunningAppProcessInfo appProcess : activityManager
                .getRunningAppProcesses()) {

            if (appProcess.pid == pid) {

                return appProcess.processName;
            }
        }
        return null;
    }

    private void setRongConnect(String token) {
//        RongIMClient.connect(token, new RongIMClient.ConnectCallback() {
//            @Override
//            public void onTokenIncorrect() {
//
//            }
//
//            @Override
//            public void onSuccess(String s) {
//                Log.i("===========>>", "连接服务器成功" + s.toString());
//            }
//
//            @Override
//            public void onError(RongIMClient.ErrorCode errorCode) {
//                Log.i("===========>>", "连接服务器失败" + errorCode.toString());
//            }
//        });
    }

    public static Context getGloableContext() {
        return application.getApplicationContext();
    }

}

