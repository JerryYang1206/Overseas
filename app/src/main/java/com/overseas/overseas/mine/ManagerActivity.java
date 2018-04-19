package com.overseas.overseas.mine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.overseas.overseas.R;
import com.overseas.overseas.base.BaseActivity;
import com.overseas.overseas.view.NoCacheViewPager;
import com.overseas.overseas.view.RatingBarView;

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
    private List<Fragment> mBaseFragmentList = new ArrayList<>();
    private FragmentManager fm;
    private MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        ButterKnife.bind(this);
        initRatingBar();
        initData();
        initListener();
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
                if (position==0){
                    viewZufang.setVisibility(View.INVISIBLE);
                    viewShoufang.setVisibility(View.VISIBLE);
                }else if (position==1){
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
//                        vp_look.removeAllViews();
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




    private void initRatingBar() {
        ratingBarView = (RatingBarView) findViewById(R.id.ratingBarView);
        ratingBarView.setRatingCount(5);//设置RatingBarView总数
        ratingBarView.setSelectedCount(2);//设置RatingBarView选中数
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

    @OnClick({R.id.back_img, R.id.bg_layout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_img:
                finish();
                break;
        }
    }
}
