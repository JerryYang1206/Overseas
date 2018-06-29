package com.overseas.overseas.mine;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
import com.overseas.overseas.bean.ManagerBean;
import com.overseas.overseas.callback.DialogCallback;
import com.overseas.overseas.utils.MyUrls;
import com.overseas.overseas.view.CircleImageView;
import com.overseas.overseas.view.NoCacheViewPager;
import com.overseas.overseas.view.RatingBarView;

import org.zackratos.ultimatebar.UltimateBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ManagerActivity extends BaseActivity {

    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.ratingBarView)
    RatingBarView ratingBarView;
    @BindView(R.id.all_shop)
    RadioButton allShop;
    @BindView(R.id.rb_pifu)
    RadioButton rbPifu;
    @BindView(R.id.rg_look)
    RadioGroup rgLook;
    @BindView(R.id.view_shoufang)
    View viewShoufang;
    @BindView(R.id.view_zufang)
    View viewZufang;
    @BindView(R.id.vp_look)
    NoCacheViewPager vpLook;
    @BindView(R.id.img_share)
    ImageView imgShare;
    @BindView(R.id.manager_head_img)
    CircleImageView managerHeadImg;
    @BindView(R.id.manager_name)
    TextView managerName;
    @BindView(R.id.manager_huifulv)
    TextView managerHuifulv;
    @BindView(R.id.bg_layout)
    LinearLayout bgLayout;
    @BindView(R.id.manager_years)
    TextView managerYears;
    @BindView(R.id.manager_count)
    TextView managerCount;
    @BindView(R.id.activity_zui_jin)
    LinearLayout activityZuiJin;
    @BindView(R.id.manager_location)
    TextView managerLocation;
    private List<Fragment> mBaseFragmentList = new ArrayList<>();
    private FragmentManager fm;
    private MyAdapter myAdapter;
    private int avgStar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //拉伸图片覆盖标题栏
        UltimateBar ultimateBar = new UltimateBar(this);
        ultimateBar.setImmersionBar(false);
        setContentView(R.layout.activity_manager);
        ButterKnife.bind(this);
        initManager();
        initRatingBar();
        initData();
        initListener();
    }

    private void initManager() {
        String brokerId = getIntent().getStringExtra("brokerId");
        Log.d("ManagerActivity", brokerId+"-----------");
        HttpParams params = new HttpParams();
        params.put("brokerId", brokerId);
        OkGo.<ManagerBean>post(MyUrls.BASEURL + "/app/broker/getbrokerinfo")
                .tag(this)
                .params(params)
                .execute(new DialogCallback<ManagerBean>(ManagerActivity.this, ManagerBean.class) {
                    @Override
                    public void onSuccess(Response<ManagerBean> response) {
                        int code = response.code();
                        final ManagerBean ManagerBean = response.body();
                        if (ManagerBean==null){
                            return;
                        }
                        String code1 = ManagerBean.getCode();
                        final ManagerBean.DatasBean datas = ManagerBean.getDatas();
                        if (datas==null){
                            return;
                        }
                        if (datas.getBrokerinfo()==null){
                            return;
                        }

                        avgStar = datas.getBrokerinfo().getAvgStar();
                        if (code1.equals("200")) {
                            Glide.with(ManagerActivity.this).load(datas.getBrokerinfo().getPic()).into(managerHeadImg);
                            managerName.setText(datas.getBrokerinfo().getBrokerName() + "");
                            managerHuifulv.setText(datas.getBrokerinfo().getTurnover() + "%");
                            managerYears.setText(datas.getDaynum() + "");
                            managerCount.setText(datas.getFwrs() + "");
                            managerLocation.setText("："+datas.getBrokerinfo().getIntimacyCn() + "");
                            managerHeadImg.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Log.d("ManagerActivity", "-------点击-----");
//                                    ImManager.enterChat(ManagerActivity.this,datas.getBrokerinfo().getId()+"",datas.getBrokerinfo().getBrokerName(),datas.getBrokerinfo().getPic());
                                }
                            });
                        } else {
                            Toast.makeText(ManagerActivity.this, ManagerBean.getMsg(), Toast.LENGTH_SHORT).show();
                        }


                    }
                });

    }

    private void initData() {
        if (mBaseFragmentList.size() <= 0) {
            mBaseFragmentList.add(new ShoufangFragment());
            mBaseFragmentList.add(new ZufangFragment());
        }

    }

    private void initListener() {
        vpLook.setOnPageChangeListener(new NoCacheViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                ((RadioButton) rgLook.getChildAt(position)).setChecked(true);
                if (position == 0) {
                    viewZufang.setVisibility(View.INVISIBLE);
                    viewShoufang.setVisibility(View.VISIBLE);
                } else if (position == 1) {
                    viewZufang.setVisibility(View.VISIBLE);
                    viewShoufang.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        rgLook.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i) {
                    case R.id.all_shop:
                        vpLook.setCurrentItem(0);
                        break;
                    case R.id.rb_pifu:
                        vpLook.setCurrentItem(1);
                        break;
                    default:
                        vpLook.setCurrentItem(0);
                        break;
                }
            }
        });


        fm = getSupportFragmentManager();
        myAdapter = new MyAdapter(fm);
        vpLook.setAdapter(myAdapter);
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

    class LiebiaoAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public LiebiaoAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
        }
    }

    private void initRatingBar() {
        ratingBarView = (RatingBarView) findViewById(R.id.ratingBarView);
        ratingBarView.setRatingCount(5);//设置RatingBarView总数
        ratingBarView.setSelectedCount(avgStar);//设置RatingBarView选中数
        ratingBarView.setSelectedIconResId(R.drawable.start_check);//设置RatingBarView选中的图片id
        ratingBarView.setNormalIconResId(R.drawable.start_nocheck);//设置RatingBarView正常图片id
        ratingBarView.setClickable(false);//设置RatingBarView是否可点击
        ratingBarView.setChildPadding(2);//设置RatingBarView的子view的padding
        ratingBarView.setChildMargin(2);//设置RatingBarView的子view左右之间的margin
        ratingBarView.setChildDimension(22);//设置RatingBarView的子view的宽高尺寸
        ratingBarView.setOnRatingBarClickListener(new RatingBarView.RatingBarViewClickListener() {
            @Override
            public void onRatingBarClick(LinearLayout parent, View childView, int position) {
                Log.e("tag", String.valueOf(childView instanceof ImageView) + "," + position);
            }
        });
    }

    @OnClick({R.id.back_img, R.id.bg_layout, R.id.img_share})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_img:
                finish();
                break;
            case R.id.img_share:
                showDialog(Gravity.BOTTOM, R.style.Bottom_Top_aniamtion);
                break;

        }
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
}
