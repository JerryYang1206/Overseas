package com.overseas.overseas.map;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.navi.BaiduMapAppNotSupportNaviException;
import com.baidu.mapapi.navi.BaiduMapNavigation;
import com.baidu.mapapi.navi.NaviParaOption;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.baidu.mapapi.utils.OpenClientUtil;
import com.overseas.overseas.R;
import com.overseas.overseas.base.BaseActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MapActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    @BindView(R.id.view1)
    View view1;
    @BindView(R.id.view2)
    View view2;
    @BindView(R.id.view3)
    View view3;
    @BindView(R.id.view4)
    View view4;
    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.message_char)
    ImageView messageChar;
    private ImageView iv_back;
    private MapView permapview;
    private RadioGroup radioGroup;
    private BaiduMap mBaiduMap;
    private LocationClient mLocClient;
    private PoiSearch mPoiSearch;
    private MyLocationListenner myListener = new MyLocationListenner();
    private List<OverlayOptions> overlayOptions;
    private TextView tv_dh;
    private String lat;
    private String log;
    private String tag;
    //头部 添加相应地区
    private final static String BAIDU_HEAD = "baidumap://map/direction?region=0";
    //起点的经纬度
    private final static String BAIDU_ORIGIN = "&origin=";
    //终点的经纬度
    private final static String BAIDU_DESTINATION = "&destination=";
    //路线规划方式
    private final static String BAIDU_MODE = "&mode=walking";
    //百度地图的包名
    private final static String BAIDU_PKG = "com.baidu.BaiduMap";
    private View markView;
    private String houseName;
    private String stationNameCn;
    private String subwayStationNum;
    private double mlongitude;
    private double mlatitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        ButterKnife.bind(this);

        initView();

    }

    private void initView() {


        lat = getIntent().getStringExtra("lat");
        log = getIntent().getStringExtra("log");
        tag = getIntent().getStringExtra("TAG");
        subwayStationNum = getIntent().getStringExtra("subwayStationNum");
        stationNameCn = getIntent().getStringExtra("stationNameCn");
        houseName = getIntent().getStringExtra("HouseName");
        Log.d("MapActivity", lat + "------------------");
        Log.d("MapActivity", log + "------------------");
        Log.d("MapActivity", tag + "------------------");

        permapview = (MapView) findViewById(R.id.permapview);
        permapview.removeViewAt(1);//隐藏logo
        permapview.removeViewAt(2);//隐藏比例尺
        permapview.showZoomControls(false);// 隐藏缩放控件
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        radioGroup.setOnCheckedChangeListener(this);

        initmap();
        // 定位初始化
        initLocation();


        if (tag.equals("1")){
            radioGroup.check(R.id.radiobank);
            poiserch("商场", R.drawable.shop_logo);
        }else if (tag.equals("2")){
            radioGroup.check(R.id.radiobus);
            poiserch("学校", R.drawable.school_logo);
        }else if (tag.equals("3")){
            radioGroup.check(R.id.radiosubw);
            poiserch("幼儿园", R.drawable.youeryuan_logo);
        }else if (tag.equals("4")){
            radioGroup.check(R.id.radioedut);
            poiserch("医院", R.drawable.yiyuan_logo);
        }

    }

    private void poiserch(String str, final int dra) {
        mPoiSearch = PoiSearch.newInstance();
        OnGetPoiSearchResultListener poiListener = new OnGetPoiSearchResultListener() {
            public void onGetPoiResult(PoiResult result) {
                // 获取POI检索结果
                if (result.error == SearchResult.ERRORNO.NO_ERROR) {
                    mBaiduMap.clear();
                    //创建PoiOverlay
                    PoiOverlay overlay = new PoiOverlay(mBaiduMap);
                    //设置PoiOverlay数据
                    overlay.setData(result, dra);
                    //添加PoiOverlay到地图中
                    overlay.addToMap();
                    overlay.zoomToSpan();
                    List<OverlayOptions> overlayOptions = overlay
                            .getOverlayOptions();
                    if (overlayOptions.size() == 0) {
                        mBaiduMap.clear();
                    } else {
                        //路线弹窗
                      View markView = View.inflate(MapActivity.this, R.layout.location_layout, null);
                        TextView map_title = (TextView) markView.findViewById(R.id.map_title);
                        TextView map_station = (TextView) markView.findViewById(R.id.map_station);
                        map_title.setText(houseName);
                        map_station.setText("距"+stationNameCn+subwayStationNum+"米");
                        MarkerOptions markerOptions = new MarkerOptions()
                                .icon(BitmapDescriptorFactory.fromView(markView))
                                .position(new LatLng(Double.valueOf(lat), Double.valueOf(log)))
                                .zIndex(14)
                                .draggable(true);
                        mBaiduMap.addOverlay(markerOptions);
                        mBaiduMap.addOverlays(overlayOptions);
                        mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
                            @Override
                            public boolean onMarkerClick(Marker marker) {
                                //检测地图是否安装和唤起
                                if (checkMapAppsIsExist(MapActivity.this, BAIDU_PKG)) {
                                    Toast.makeText(MapActivity.this, "百度地图已经安装", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent();
                                    intent.setData(Uri.parse(BAIDU_HEAD + BAIDU_ORIGIN + mlatitude
                                            + "," + mlongitude + BAIDU_DESTINATION + lat + "," + log
                                            + BAIDU_MODE));
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(MapActivity.this, "百度地图未安装或版本过低", Toast.LENGTH_SHORT).show();
                                }
                                return false;
                            }
                        });
                    }
                    return;
                }
            }

            @Override
            public void onGetPoiDetailResult(PoiDetailResult poiDetailResult) {
                LatLng location = poiDetailResult.getLocation();
                double latitude = location.latitude;
                double longitude = location.longitude;
                Log.d("MapActivity", "latitude:" + latitude+"-------");
                Log.d("MapActivity", "longitude:" + longitude+"-------");

            }

            @Override
            public void onGetPoiIndoorResult(PoiIndoorResult poiIndoorResult) {
            }


        };

        mPoiSearch.setOnGetPoiSearchResultListener(poiListener);
        if (str.equals("地铁")) {
            mBaiduMap.clear();
        } else {
            if (!TextUtils.isEmpty(lat) && !TextUtils.isEmpty(log)) {
                mPoiSearch.searchNearby((new PoiNearbySearchOption())
                        .location(new LatLng(Double.parseDouble(lat), Double.parseDouble(log)))
                        .keyword(str)
                        .radius(30000)
                        .pageNum(1));
            }
        }
    }
    /**
     * 检测地图应用是否安装
     *
     * @param context
     * @param packagename
     * @return
     */
    public boolean checkMapAppsIsExist(Context context, String packagename) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(packagename, 0);
        } catch (Exception e) {
            packageInfo = null;
            e.printStackTrace();
        }
        if (packageInfo == null) {
            return false;
        } else {
            return true;
        }
    }

    private void initmap() {
        mBaiduMap = permapview.getMap();
        myListener = new MyLocationListenner();
        // 开启定位图层
        mBaiduMap.setMyLocationEnabled(true);
        MyLocationConfiguration.LocationMode mCurrentMode = MyLocationConfiguration.LocationMode.NORMAL;
        //添加定位信息
        mBaiduMap.setMapStatus(MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().zoom(14).build()));   // 设置级别
        LatLng ll = new LatLng(Double.parseDouble(lat),
                Double.parseDouble(log));
        mBaiduMap.setMapStatus(MapStatusUpdateFactory.newLatLng(ll));
        MyLocationData.Builder builder = new MyLocationData.Builder();
        builder.latitude(Double.parseDouble(lat));
        builder.longitude(Double.parseDouble(log));
        MyLocationData data = builder.build();
        //设置定位的小图标
        BitmapDescriptor mCurrentMarker = BitmapDescriptorFactory
                .fromResource(R.drawable.dingwei_logo1);
        mBaiduMap.setMyLocationConfiguration(new MyLocationConfiguration(
                mCurrentMode, true, mCurrentMarker,
                0, 0));

        //设置定位数据
        mBaiduMap.setMyLocationData(data);

    }


    private void initLocation() {
        mLocClient = new LocationClient(this);
        mLocClient.registerLocationListener(myListener);
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);// 设置定位模式
        //		option.setScanSpan(5000);// 设置发起定位请求的间隔时间,ms
        option.setNeedDeviceDirect(true);// 设置返回结果包含手机的方向

        option.setOpenGps(true);
        option.setAddrType("all");// 返回的定位结果包含地址信息
        option.setCoorType("bd09ll");// 返回的定位结果是百度经纬度,默认值gcj02
        option.setIsNeedAddress(true);// 返回的定位结果包含地址信息
        option.setIsNeedLocationPoiList(true);

        mLocClient.setLocOption(option);
        mLocClient.start();
        mLocClient.registerLocationListener(new BDLocationListener() {
            @Override
            public void onReceiveLocation(BDLocation bdLocation) {
                mlongitude = bdLocation.getLongitude();
                mlatitude = bdLocation.getLatitude();
            }
        });
    }

    @Override
    public void onPause() {
        permapview.onPause();
        super.onPause();
    }

    @Override
    public void onResume() {
        permapview.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        mLocClient.stop();
        // 关闭定位图层
        mBaiduMap.setMyLocationEnabled(false);
        permapview.onDestroy();
        permapview = null;
        mPoiSearch.destroy();
        super.onDestroy();
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.radiobank:
                poiserch("商场", R.drawable.shop_logo);
                view1.setVisibility(View.VISIBLE);
                view2.setVisibility(View.INVISIBLE);
                view3.setVisibility(View.INVISIBLE);
                view4.setVisibility(View.INVISIBLE);
                break;
            case R.id.radiobus:
                poiserch("学校", R.drawable.school_logo);
                view1.setVisibility(View.INVISIBLE);
                view2.setVisibility(View.VISIBLE);
                view3.setVisibility(View.INVISIBLE);
                view4.setVisibility(View.INVISIBLE);

                break;
            case R.id.radiosubw:
                poiserch("幼儿园", R.drawable.youeryuan_logo);
                view1.setVisibility(View.INVISIBLE);
                view2.setVisibility(View.INVISIBLE);
                view3.setVisibility(View.VISIBLE);
                view4.setVisibility(View.INVISIBLE);
                break;
            case R.id.radioedut:
                poiserch("医院", R.drawable.yiyuan_logo);
                view1.setVisibility(View.INVISIBLE);
                view2.setVisibility(View.INVISIBLE);
                view3.setVisibility(View.INVISIBLE);
                view4.setVisibility(View.VISIBLE);
                break;
        }
    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.iv_back:
//                finish();
//                break;
//            case R.id.tv_dh:
//                //                boolean map = isAvilible(MapActivity.this, "百度地图");
//                //              if(map){
//                startNavi();
//                //              }else {
//                //                  Toast.makeText(MapActivity.this,"请安装百度地图",Toast.LENGTH_SHORT).show();
//                //              }
//                break;
//        }
//    }

    /**
     * 开发 > URI API > Android
     * 跳转到百度地图
     *
     * @param context
     * @param loc1
     * @param loc2
     */
    /**
     * 启动百度地图导航(Native)
     */
    public void startNavi() {

        LocationClient mmlocation = new LocationClient(MapActivity.this);
        mmlocation.registerLocationListener(new BDLocationListener() {
            @Override
            public void onReceiveLocation(BDLocation bdLocation) {
                double mLat2 = Double.parseDouble(lat);
                double mLon2 = Double.parseDouble(log);

                LatLng pt2 = new LatLng(mLat2, mLon2);
                LatLng pt1 = new LatLng(bdLocation.getLatitude(), bdLocation.getLongitude());
                // 构建 导航参数
                NaviParaOption para = new NaviParaOption()
                        .startPoint(pt1).endPoint(pt2);

                try {
                    BaiduMapNavigation.openBaiduMapNavi(para, MapActivity.this);
                } catch (BaiduMapAppNotSupportNaviException e) {
                    e.printStackTrace();
                    showDialog();
                }
            }

        });
        mmlocation.start();


    }
    //    /**
    //     * 启动百度地图导航(Web)
    //     */
    //    public void startWebNavi() {
    //
    //        LocationClient weblocation=new LocationClient(MapActivity.this);
    //        weblocation.registerLocationListener(new BDLocationListener() {
    //            @Override
    //            public void onReceiveLocation(BDLocation bdLocation) {
    //                // 百度大厦坐标
    //                double mLat2 = 40.056858;
    //                double mLon2 = 116.308194;
    //
    //                LatLng pt2 = new LatLng(mLat2, mLon2);
    //                LatLng pt1 = new LatLng(bdLocation.getLatitude(), bdLocation.getLongitude());
    //                // 构建 导航参数
    //                NaviParaOption para = new NaviParaOption()
    //                        .startPoint(pt1).endPoint(pt2);
    //
    //                BaiduMapNavigation.openWebBaiduMapNavi(para, MapActivity.this);
    //            }
    //
    //            @Override
    //            public void onConnectHotSpotMessage(String s, int i) {
    //
    //            }
    //        });
    //     weblocation.start();
    //    }


    /**
     * 提示未安装百度地图app或app版本过低
     */
    public void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("您尚未安装百度地图app或app版本过低，点击确认安装？");
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                OpenClientUtil.getLatestBaiduMapApp(MapActivity.this);
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.create().show();
    }

    @OnClick({R.id.back_img, R.id.message_char})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_img:
                finish();
                break;
            case R.id.message_char:
//                EventBus.getDefault().post(new EventBean(Constants.EVENT_CHAT));
                finish();
                break;
        }
    }
}
