package com.overseas.overseas.mine;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.overseas.overseas.R;
import com.overseas.overseas.base.BaseActivity;
import com.overseas.overseas.base.BaseDialog;
import com.overseas.overseas.bean.HouseDetailsBean;
import com.overseas.overseas.bean.SuccessBean;
import com.overseas.overseas.callback.DialogCallback;
import com.overseas.overseas.im.ImManager;
import com.overseas.overseas.more.ZuBanGongMoreActivity;
import com.overseas.overseas.more.ZuBieSuMoreActivity;
import com.overseas.overseas.more.ZuDuoCengMoreActivity;
import com.overseas.overseas.more.ZuErCengMoreActivity;
import com.overseas.overseas.more.ZuShangPuMoreActivity;
import com.overseas.overseas.more.ZuXueShengMoreActivity;
import com.overseas.overseas.presenter.HouseLogPresenter;
import com.overseas.overseas.utils.CacheUtils;
import com.overseas.overseas.utils.MyUrls;
import com.overseas.overseas.utils.MyUtils;
import com.overseas.overseas.utils.SharedPreferencesUtils;
import com.overseas.overseas.view.CircleImageView;

import org.zackratos.ultimatebar.UltimateBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jzvd.JZVideoPlayer;

public class LishiZuHouseActivity extends BaseActivity {

    @BindView(R.id.vp_vidio)
    ViewPager vpVidio;
    @BindView(R.id.tv_to_num)
    TextView tvToNum;
    @BindView(R.id.tv_all_num)
    TextView tvAllNum;
    @BindView(R.id.Huxing_Recycler)
    RecyclerView HuxingRecycler;
    @BindView(R.id.img_share)
    ImageView imgShare;
    @BindView(R.id.img_start)
    ImageView imgStart;
    @BindView(R.id.tv_See_More)
    TextView tvSeeMore;
    @BindView(R.id.tv_price)
    TextView tv_price;
    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.mScrollView)
    NestedScrollView mScrollView;
    @BindView(R.id.re_top_bg)
    RelativeLayout re_top_bg;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_details_name)
    TextView tvDetailsName;
    @BindView(R.id.tv_details_area)
    TextView tvDetailsArea;
    @BindView(R.id.tv_details_location)
    TextView tvDetailsLocation;
    @BindView(R.id.tv_details_manager_head)
    CircleImageView tvDetailsManagerHead;
    @BindView(R.id.tv_details_manager_name)
    TextView tvDetailsManagerName;
    @BindView(R.id.tv_suiyi)
    TextView tvSuiyi;
    @BindView(R.id.lishi_zu_wl)
    TextView lishiZuWl;
    @BindView(R.id.tv_details_manager_phone)
    TextView tvDetailsManagerPhone;
    @BindView(R.id.activity_lishi_new_house)
    RelativeLayout activityLishiNewHouse;
    private int mDistanceY;
    private LiebiaoAdapter mLiebiaoAdapter;
    private List<String> mList = new ArrayList();
    private List<Fragment> mBaseFragmentList = new ArrayList<>();
    private FragmentManager fm;
    private MyAdapter myAdapter;
    private String houseType;
    private HouseDetailsBean.DatasBean datas;
    private boolean isJa;
    private int mType;
    private String houseId;
    private String token;
    private int isSc;
    private boolean isStart;
    private List<HouseDetailsBean.DatasBean.BannerlistBean> bannerlist;
    private List<HouseDetailsBean.DatasBean.HxtlistBean> hxtlist;
    private List<String> mUrlList = new ArrayList();
    private List<View> mBannerList = new ArrayList<>();
    private HouseDetailsBean.DatasBean.HwdcBrokerBean hwdcBroker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //拉伸图片覆盖标题栏
        UltimateBar ultimateBar = new UltimateBar(this);
        ultimateBar.setImmersionBar(false);
        setContentView(R.layout.activity_lishi_zu_house);
        ButterKnife.bind(this);
        String iszu = getIntent().getStringExtra("iszu");
        houseType = getIntent().getStringExtra("houseType");
        if (!TextUtils.isEmpty(houseType)) {
            switch (houseType) {
                case "duoceng":
                    mType = 5;
                    break;
                case "xuesheng":
                    mType = 4;
                    break;
                case "erceng":
                    mType = 3;
                    break;
                case "bieshu":
                    mType = 2;
                    break;
                case "shangpu":
                    mType = 1;
                    break;
                case "bangongshi":
                    mType = 0;
                    break;
            }
        }

        initScroll();
        initDetailsNet();

    }

    private void initDetailsNet() {
        token = SharedPreferencesUtils.getInstace(this).getStringPreference("token", "");
        houseId = getIntent().getStringExtra("houseId");
        new HouseLogPresenter(this).setHouseLog("2",houseId,mType+"");
        HttpParams params = new HttpParams();
        params.put("hId", houseId);
        params.put("hType", 2);
        params.put("token", token);
        OkGo.<HouseDetailsBean>post(MyUrls.BASEURL + "/app/houseresourse/houseinfo")
                .tag(this)
                .params(params)
                .execute(new DialogCallback<HouseDetailsBean>(this, HouseDetailsBean.class) {
                    @Override
                    public void onSuccess(Response<HouseDetailsBean> response) {
                        int code = response.code();
                        HouseDetailsBean oldHouseListBean = response.body();
                        if (oldHouseListBean==null){
                            return;
                        }
                        datas = oldHouseListBean.getDatas();
                        if (datas==null){
                            return;
                        }
                        bannerlist = datas.getBannerlist();
                        hxtlist = datas.getHxtlist();
                        hwdcBroker = datas.getHwdcBroker();
                        boolean isJa = MyUtils.isJa(mContext);
                        tvDetailsName.setText(isJa ? datas.getTitleJpn() : datas.getTitleCn());
                        tv_price.setText(isJa ? datas.getSellingPriceJpn() : datas.getSellingPriceCn());
                        tvDetailsArea.setText(isJa ? datas.getAreaJpn() : datas.getAreaCn());
                        tvDetailsLocation.setText(isJa ? datas.getSpecificLocationJpn() : datas.getSpecificLocationCn());
                        tvDetailsManagerName.setText(hwdcBroker.getBrokerName());
                        Glide.with(LishiZuHouseActivity.this).load(hwdcBroker.getPic() + "").into(tvDetailsManagerHead);
                        isSc = datas.getIsSc();
                        if (isSc == 0) {//收藏
                            isStart = true;
                            imgStart.setImageResource(R.drawable.shoucang2);
                        } else {//未收藏
                            isStart = false;
                            imgStart.setImageResource(R.drawable.shoucang);
                        }
                        initViewPager();
                        initData();
                    }
                });
    }

    private void initScroll() {
        mScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                //滑动的距离
                mDistanceY += scrollY - oldScrollY;
                //toolbar的高度
                int toolbarHeight = 300;//我写死的高度

                //当滑动的距离 <= toolbar高度的时候，改变Toolbar背景色的透明度，达到渐变的效果
                if (mDistanceY <= toolbarHeight) {
                    float scale = (float) mDistanceY / toolbarHeight;
                    float alpha = scale * 255;
                    re_top_bg.setBackgroundColor(Color.argb((int) alpha, 199, 151, 127));
                    tv_title.setVisibility(View.GONE);
                } else {
                    //上述虽然判断了滑动距离与toolbar高度相等的情况，但是实际测试时发现，标题栏的背景色
                    //很少能达到完全不透明的情况，所以这里又判断了滑动距离大于toolbar高度的情况，
                    //将标题栏的颜色设置为完全不透明状态
                    re_top_bg.setBackgroundResource(R.color.shihuangse);
                    tv_title.setVisibility(View.VISIBLE);
                }
            }
        });
    }


    private void initViewPager() {
        if (bannerlist==null&&bannerlist.size()<=0){
            return;
        }
        if (mBannerList.size() <= 0) {
            if (datas.getVideoUrls() != null) {
                if (datas.getVideoUrls().equals("")) {
                    for (int i = 0; i < bannerlist.size(); i++) {
                        mUrlList.add(bannerlist.get(i).getVal() + "");
                    }
                } else {
                    mUrlList.add(datas.getVideoImgs());
                    for (int i = 0; i < bannerlist.size(); i++) {
                        mUrlList.add(bannerlist.get(i).getVal() + "");
                    }
                }
            }
            for (int i = 0; i < mUrlList.size(); i++) {
                View inflate = View.inflate(mContext, R.layout.details_banner_layout, null);
                ImageView img_banner = (ImageView) inflate.findViewById(R.id.img_banner);
                ImageView imgStartVideo = (ImageView) inflate.findViewById(R.id.img_start_video);
                RelativeLayout rela_layout = (RelativeLayout) inflate.findViewById(R.id.rela_layout);
                Glide.with(this).load(mUrlList.get(i)).into(img_banner);
                mBannerList.add(inflate);
                if (i == 0 && !datas.getVideoUrls().equals("")) {
                    imgStartVideo.setVisibility(View.VISIBLE);
                } else {
                    imgStartVideo.setVisibility(View.GONE);
                }
                final int finalI = i;
                rela_layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (finalI == 0 && !datas.getVideoUrls().equals("")) {
                            Intent intent = new Intent(mContext, VideoDetailsActivity.class);
                            intent.putExtra("VideoUrl", datas.getVideoUrls() + "");
                            intent.putExtra("VideoImg", datas.getVideoImgs() + "");
                            startActivity(intent);
                        } else {
                            Intent intent = new Intent(mContext, BannerDetailsActivity.class);
                            intent.putExtra("datas", datas);
                            if (datas.getVideoUrls().equals("")) {
                                intent.putExtra("position", finalI + "");
                            } else {
                                intent.putExtra("position", (finalI - 1) + "");
                            }
                            startActivity(intent);
                        }
                    }
                });

            }


        }
        tvAllNum.setText(mBannerList.size() + "");
        vpVidio.setAdapter(adapter);
        vpVidio.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {

                tvToNum.setText((position + 1) + "");
                if (position == 1) {

                } else if (position == 0) {
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    //需要给ViewPager设置适配器
    PagerAdapter adapter = new PagerAdapter() {

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            // TODO Auto-generated method stub
            return arg0 == arg1;
        }

        //有多少个切换页
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return mBannerList.size();
        }

        //对超出范围的资源进行销毁
        @Override
        public void destroyItem(ViewGroup container, int position,
                                Object object) {
            // TODO Auto-generated method stub
            container.removeView(mBannerList.get(position));
        }

        //对显示的资源进行初始化
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // TODO Auto-generated method stub
            container.addView(mBannerList.get(position));
            return mBannerList.get(position);
        }

    };

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }

    private void initData() {
        findViewById(R.id.lishi_zu_wl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hwdcBroker != null) {
                    ImManager.enterChatDetails(LishiZuHouseActivity.this, hwdcBroker.getId() + "", hwdcBroker.getBrokerName(), hwdcBroker.getPic());
                }
            }
        });


        if (mLiebiaoAdapter == null) {
            mLiebiaoAdapter = new LiebiaoAdapter(R.layout.huxing_item, hxtlist);
        }
        HuxingRecycler.setLayoutManager(new GridLayoutManager(LishiZuHouseActivity.this, 3));
        HuxingRecycler.setNestedScrollingEnabled(false);
        HuxingRecycler.setAdapter(mLiebiaoAdapter);
        mLiebiaoAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                showHuxingDialog(position);
            }
        });
    }

    private void showHuxingDialog(int position) {
        BaseDialog.Builder builder = new BaseDialog.Builder(this);
        final BaseDialog dialog = builder.setViewId(R.layout.dialog_huxingtu)
                //设置dialogpadding
                .setPaddingdp(0, 0, 0, 0)
                //设置显示位置
                .setGravity(Gravity.CENTER)
                //设置动画
                .setAnimation(R.style.Alpah_aniamtion)
                //设置dialog的宽高
                .setWidthHeightpx(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                //设置触摸dialog外围是否关闭
                .isOnTouchCanceled(true)
                //设置监听事件
                .builder();
        dialog.show();
        ImageView img_dialog_huxing = (ImageView) dialog.findViewById(R.id.img_dialog_huxing);
        img_dialog_huxing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        Glide.with(LishiZuHouseActivity.this).load(hxtlist.get(position).getVal()).into(img_dialog_huxing);
    }


    class MyAdapter extends FragmentStatePagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mBaseFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mBaseFragmentList.size();
        }
    }
    private void ShowCallDialog(final String tel) {
        BaseDialog.Builder builder = new BaseDialog.Builder(this);
        final BaseDialog dialog = builder.setViewId(R.layout.call_layout)
                .setPaddingdp(0, 10, 0, 10)
                .setGravity(Gravity.CENTER)
                .setAnimation(R.style.bottom_tab_style)
                .setWidthHeightpx(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                .isOnTouchCanceled(false)
                .builder();
        dialog.show();
        TextView text_sure = dialog.getView(R.id.text_sure);
        final TextView tv_content = dialog.getView(R.id.tv_content);
        tv_content.setText(tel);
        TextView text_pause = dialog.getView(R.id.text_pause);

        text_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Intent dialIntent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:" + tel));
                startActivity(dialIntent);
            }
        });

        text_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

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

    @OnClick({R.id.img_share, R.id.img_start, R.id.tv_See_More, R.id.back_img,R.id.tv_details_manager_phone,R.id.tv_details_location,R.id.manager_data})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.manager_data:
                Intent Managerintent = new Intent(LishiZuHouseActivity.this, ManagerActivity.class);
                Managerintent.putExtra("brokerId",datas.getHwdcBroker().getId()+"");
                startActivity(Managerintent);
                break;
            case R.id.img_share:
                showDialog(Gravity.BOTTOM, R.style.Bottom_Top_aniamtion);
                break;
            case R.id.tv_details_manager_phone:
                ShowCallDialog(hwdcBroker.getPhone() + "");
                break;
            case R.id.tv_details_location:
                double mylatitude = CacheUtils.get("mylatitude");
                double mylongitude = CacheUtils.get("mylongitude");
                //检测地图是否安装和唤起
                if (checkMapAppsIsExist(LishiZuHouseActivity.this, BAIDU_PKG)) {
                    Toast.makeText(mContext,getResources().getString(R.string.zhengzaidakaibaiduditu), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.setData(Uri.parse(BAIDU_HEAD + BAIDU_ORIGIN + mylatitude
                            + "," + mylongitude + BAIDU_DESTINATION + datas.getLatitude() + "," + datas.getLongitude()
                            + BAIDU_MODE));
                    startActivity(intent);
                } else {
                    Toast.makeText(mContext,getResources().getString(R.string.baidudituweianzhuang), Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.img_start:
                if (MyUtils.isLogin(this)) {
                    if (!isStart) {
                        initStart();
                        isStart = true;
                    } else {
                        initUnStart();
                        isStart = false;
                    }
                } else {
                    Toast.makeText(mContext,getResources().getString(R.string.qingxiandenglu), Toast.LENGTH_SHORT).show();
                    MyUtils.StartLoginActivity(this);
                }
                break;
            case R.id.tv_See_More:
                if (!TextUtils.isEmpty(houseType)) {
                    Intent intent;
                    switch (houseType) {
                        case "duoceng":
                            intent = new Intent(mContext, ZuDuoCengMoreActivity.class);
                            intent.putExtra("datas", datas);
                            startActivity(intent);
                            break;
                        case "xuesheng":
                            intent = new Intent(mContext, ZuXueShengMoreActivity.class);
                            intent.putExtra("datas", datas);
                            startActivity(intent);
                            break;
                        case "erceng":
                            intent = new Intent(mContext, ZuErCengMoreActivity.class);
                            intent.putExtra("datas", datas);
                            startActivity(intent);
                            break;
                        case "bieshu":
                            intent = new Intent(mContext, ZuBieSuMoreActivity.class);
                            intent.putExtra("datas", datas);
                            startActivity(intent);
                            break;
                        case "shangpu":
                            intent = new Intent(mContext, ZuShangPuMoreActivity.class);
                            intent.putExtra("datas", datas);
                            startActivity(intent);
                            break;
                        case "bangongshi":
                            intent = new Intent(mContext, ZuBanGongMoreActivity.class);
                            intent.putExtra("datas", datas);
                            startActivity(intent);
                            break;
                    }
                }
                break;
            case R.id.back_img:
                finish();
                break;
        }
    }

    //收藏
    private void initStart() {
        HttpParams params = new HttpParams();
        params.put("hType", 2);//房源类型 0二手房 1新房 2租房 3土地 4别墅 5商业地产 6中国房源 7海外房源 8找团地
        params.put("token", token);//用户登录标识
        params.put("shType", mType);//房源类型下的小类型 例：租房下的二层公寓传3 租房（0办公室出租 1商铺出租 2别墅 3二层公寓 4学生公寓详情 5多层公寓详情） 商业地产（0酒店 1高尔夫球场 2写字楼 3商铺）
        params.put("hId", houseId);
        OkGo.<SuccessBean>post(MyUrls.BASEURL + "/app/collectionhouse/insertcollectionhouse")
                .tag(this)
                .params(params)
                .execute(new DialogCallback<SuccessBean>(LishiZuHouseActivity.this, SuccessBean.class) {
                    @Override
                    public void onSuccess(Response<SuccessBean> response) {
                        int code = response.code();
                        final SuccessBean oldHouseListBean = response.body();
                        String code1 = oldHouseListBean.getCode();
                        if (code1.equals("200")) {
                            imgStart.setImageResource(R.drawable.shoucang2);
                            Toast.makeText(mContext,getResources().getString(R.string.shoucangchenggong), Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(LishiZuHouseActivity.this, code1, Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    //取消收藏
    private void initUnStart() {
        HttpParams params = new HttpParams();
        params.put("hType", 2);//房源类型 0二手房 1新房 2租房 3土地 4别墅 5商业地产 6中国房源 7海外房源 8找团地
        params.put("token", token);//用户登录标识
        params.put("shType", mType);//房源类型下的小类型 例：租房下的二层公寓传3 租房（0办公室出租 1商铺出租 2别墅 3二层公寓 4学生公寓详情 5多层公寓详情） 商业地产（0酒店 1高尔夫球场 2写字楼 3商铺）
        params.put("hId", houseId);
        OkGo.<SuccessBean>post(MyUrls.BASEURL + "/app/collectionhouse/deletecollectionhouse")
                .tag(this)
                .params(params)
                .execute(new DialogCallback<SuccessBean>(LishiZuHouseActivity.this, SuccessBean.class) {
                    @Override
                    public void onSuccess(Response<SuccessBean> response) {
                        int code = response.code();
                        final SuccessBean oldHouseListBean = response.body();
                        String code1 = oldHouseListBean.getCode();
                        if (code1.equals("200")) {
                            imgStart.setImageResource(R.drawable.shoucang);
                            Toast.makeText(mContext,getResources().getString(R.string.quxiaoshoucangchenggong), Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(LishiZuHouseActivity.this, code1, Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    private void showDialog(int grary, int animationStyle) {
        BaseDialog.Builder builder = new BaseDialog.Builder(this);
        //设置触摸dialog外围是否关闭
        //设置监听事件
        final BaseDialog dialog = builder.setViewId(R.layout.dialog_share)
                //设置dialogpadding
                .setPaddingdp(0, 0, 0, 0)
                //设置显示位置
                .setGravity(grary)
                //设置动画
                .setAnimation(animationStyle)
                //设置dialog的宽高
                .setWidthHeightpx(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                //设置触摸dialog外围是否关闭
                .isOnTouchCanceled(true)
                //设置监听事件
                .builder();
        dialog.show();
//        LinearLayout weiliao_layout = (LinearLayout) dialog.findViewById(R.id.weiliao_layout);
        LinearLayout weixin_layout = (LinearLayout) dialog.findViewById(R.id.weixin_layout);
        LinearLayout pengyouquan_layout = (LinearLayout) dialog.findViewById(R.id.pengyouquan_layout);
        LinearLayout weibo_layout = (LinearLayout) dialog.findViewById(R.id.weibo_layout);
        TextView tv_dismiss = (TextView) dialog.findViewById(R.id.tv_dismiss);
        //微聊分享
//        weiliao_layout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
        //微信分享
        weixin_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //朋友圈分享
        pengyouquan_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //微博分享
        weibo_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //取消
        tv_dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    class LiebiaoAdapter extends BaseQuickAdapter<HouseDetailsBean.DatasBean.HxtlistBean, BaseViewHolder> {

        public LiebiaoAdapter(@LayoutRes int layoutResId, @Nullable List<HouseDetailsBean.DatasBean.HxtlistBean> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, HouseDetailsBean.DatasBean.HxtlistBean item) {
            Glide.with(LishiZuHouseActivity.this).load(item.getVal()).into((ImageView) helper.getView(R.id.img_huxing));

        }
    }
}
