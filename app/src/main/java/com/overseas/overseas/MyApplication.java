package com.overseas.overseas;

import android.app.Application;
import android.content.Context;

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
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(this);
        setOkGo();//OkGo----第三方网络框架

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

