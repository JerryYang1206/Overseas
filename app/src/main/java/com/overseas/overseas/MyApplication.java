package com.overseas.overseas;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.multidex.MultiDex;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.baidu.mapapi.SDKInitializer;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.cookie.CookieJarImpl;
import com.lzy.okgo.cookie.store.DBCookieStore;
import com.lzy.okgo.https.HttpsUtils;
import com.lzy.okgo.interceptor.HttpLoggingInterceptor;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.HttpParams;
import com.overseas.overseas.bean.LoginBean;
import com.overseas.overseas.im.TalkExtensionModule;
import com.overseas.overseas.utils.CacheUtils;
import com.overseas.overseas.utils.Constants;
import com.overseas.overseas.utils.SharedPreferencesUtils;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
//import com.umeng.message.IUmengRegisterCallback;
//import com.umeng.message.PushAgent;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import io.rong.imkit.DefaultExtensionModule;
import io.rong.imkit.IExtensionModule;
import io.rong.imkit.RongExtensionManager;
import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.UserInfo;
import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2017/8/24.
 */

public class MyApplication extends Application {
    private static MyApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        CacheUtils.init(application);
        SDKInitializer.initialize(this);
        setOkGo();//OkGo----第三方网络框架
        initRc();
        initUMPush();
    }
    private void initUMPush() {

//                Toast.makeText(getApplicationContext(), "Push", Toast.LENGTH_SHORT).show();
        PushAgent mPushAgent = PushAgent.getInstance(this);
        //注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //                Toast.makeText(getContext(), "友盟推送注册成功", Toast.LENGTH_SHORT).show();

                System.out.println("友盟推送注册成功" + deviceToken);
                SharedPreferencesUtils.getInstace(application).setStringPreference("UMPUSHID", deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {
                //                Toast.makeText(getContext(), "友盟推送注册失败", Toast.LENGTH_SHORT).show();
            }
        });


    }
    private void initRc() {
        RongIM.init(this);
        RongIM.getInstance().setMessageAttachedUserInfo(true);

        final LoginBean.DatasBean bean = CacheUtils.get(Constants.USERINFO);

        if (bean != null && bean.getRongCloudToken() != null) {
            RongIM.connect(bean.getRongCloudToken(), new RongIMClient.ConnectCallback() {
                @Override
                public void onSuccess(String s) {
                    if (bean.getPic() == null || bean.getPic().equals("")) {
                        RongIM.getInstance().setCurrentUserInfo(new UserInfo("broker" + bean.getId(), bean.getNickname(), Uri.parse("")));
                    } else {
                        RongIM.getInstance().setCurrentUserInfo(new UserInfo("broker" + bean.getId(), bean.getNickname(), Uri.parse(bean.getPic())));
                    }
                }

                @Override
                public void onError(RongIMClient.ErrorCode errorCode) {
                }

                @Override
                public void onTokenIncorrect() {
                    //Connect Token 失效的状态处理，需要重新获取 Token
                }
            });
        }

        setMyExtensionModule();
    }

    public void setMyExtensionModule() {
        List<IExtensionModule> moduleList = RongExtensionManager.getInstance().getExtensionModules();
        IExtensionModule defaultModule = null;
        if (moduleList != null) {
            for (IExtensionModule module : moduleList) {
                if (module instanceof DefaultExtensionModule) {
                    defaultModule = module;
                    break;
                }
            }
            if (defaultModule != null) {
                RongExtensionManager.getInstance().unregisterExtensionModule(defaultModule);
                RongExtensionManager.getInstance().registerExtensionModule(new TalkExtensionModule());
            }
        }
    }

    /**
     * OkGo------第三方网络请求框架
     */
    private void setOkGo() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        HttpHeaders headers = new HttpHeaders();
        HttpParams params = new HttpParams();
        //log相关
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor("TAG");
        loggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY);        //log打印级别，决定了log显示的详细程度
        loggingInterceptor.setColorLevel(Level.SEVERE);                     //log颜色级别，决定了log在控制台显示的颜色
        builder.addInterceptor(loggingInterceptor);                                 //添加OkGo默认debug日志
        //超时时间设置，默认60秒
        builder.readTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);      //全局的读取超时时间
        builder.writeTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);     //全局的写入超时时间
        builder.connectTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);   //全局的连接超时时间

        //自动管理cookie（或者叫session的保持），以下几种任选其一就行
        //builder.cookieJar(new CookieJarImpl(new SPCookieStore(this)));            //使用sp保持cookie，如果cookie不过期，则一直有效
        builder.cookieJar(new CookieJarImpl(new DBCookieStore(this)));              //使用数据库保持cookie，如果cookie不过期，则一直有效
        //builder.cookieJar(new CookieJarImpl(new MemoryCookieStore()));            //使用内存保持cookie，app退出后，cookie消失


        //https相关设置，以下几种方案根据需要自己设置
        //方法一：信任所有证书,不安全有风险
        HttpsUtils.SSLParams sslParams1 = HttpsUtils.getSslSocketFactory();
        //方法二：自定义信任规则，校验服务端证书
        //        HttpsUtils.SSLParams sslParams2 = HttpsUtils.getSslSocketFactory(new SafeTrustManager());
        //方法三：使用预埋证书，校验服务端证书（自签名证书）
        //HttpsUtils.SSLParams sslParams3 = HttpsUtils.getSslSocketFactory(getAssets().open("srca.cer"));
        //方法四：使用bks证书和密码管理客户端证书（双向认证），使用预埋证书，校验服务端证书（自签名证书）
        //HttpsUtils.SSLParams sslParams4 = HttpsUtils.getSslSocketFactory(getAssets().open("xxx.bks"), "123456", getAssets().open("yyy.cer"));
        builder.sslSocketFactory(sslParams1.sSLSocketFactory, sslParams1.trustManager);
        //配置https的域名匹配规则，详细看demo的初始化介绍，不需要就不要加入，使用不当会导致https握手失败
        //        builder.hostnameVerifier(new SafeHostnameVerifier());

        OkGo.getInstance().init(this)                              //必须调用初始化
                .setOkHttpClient(builder.build())                  //建议设置OkHttpClient，不设置将使用默认的
                .setCacheMode(CacheMode.NO_CACHE)                 //全局统一缓存模式，默认不使用缓存，可以不传
                .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)    //全局统一缓存时间，默认永不过期，可以不传
                .setRetryCount(3)//全局统一超时重连次数，默认为三次，那么最差的情况会请求4次(一次原始请求，三次重连请求)，不需要可以设置为0
                .addCommonHeaders(headers)                         //全局公共头
                .addCommonParams(params);                          //全局公共参数

    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
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

    public static Context getGloableContext() {
        return application.getApplicationContext();
    }
    public static boolean isJapanese(){
        String location = SharedPreferencesUtils.getInstace(application.getApplicationContext()).getStringPreference("city", "");
        if (!TextUtils.isEmpty(location) && TextUtils.equals(location, "ja")) {
            return true;
        }
        return false;
    }
    public static String getUserToken(){
        LoginBean.DatasBean datasBean = CacheUtils.get(Constants.USERINFO);
        if (datasBean != null) {
            return datasBean.getToken();
        }
        return null;
    }

    public static String getUserId(Context context){
        LoginBean.DatasBean datasBean = CacheUtils.get(Constants.USERINFO);
        if (datasBean != null) {
            return datasBean.getId() + "";
        }
        return "";
    }

    public static boolean isLogin(){
        LoginBean.DatasBean datasBean = CacheUtils.get(Constants.USERINFO);
        if (datasBean == null) {
            return false;
        }
        return true;
    }

    public static boolean isNetworkAvailable() {
        ConnectivityManager connectivity = (ConnectivityManager)
                application.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void logOut(){
        String language = CacheUtils.get(Constants.COUNTRY);

        CacheUtils.removeAll();
        CacheUtils.put(Constants.COUNTRY, language);

        if (RongIM.getInstance() != null) {

            List<Conversation> conversationList = RongIM.getInstance().getRongIMClient().getConversationList();

            if (conversationList != null && conversationList.size() > 0) {

                for (Conversation c : conversationList) {

                    RongIM.getInstance().getRongIMClient().removeConversation(c.getConversationType(), c.getTargetId());

                }
                Log.e("=============>>", "清除成功");
            }

            RongIM.getInstance().clearConversations(new RongIMClient.ResultCallback() {
                @Override
                public void onSuccess(Object o) {

                }

                @Override
                public void onError(RongIMClient.ErrorCode errorCode) {

                }
            }, Conversation.ConversationType.PRIVATE);
            RongIM.getInstance().logout();
        }
    }
}

