package com.overseas.overseas.mine;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.overseas.overseas.R;
import com.overseas.overseas.base.BaseActivity;
import com.overseas.overseas.bean.HouseDetailsBean;
import com.overseas.overseas.utils.MyUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BannerDetailsActivity extends BaseActivity {
    @BindView(R.id.vp_banner)
    ViewPager vpBanner;
    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.tv_all_num)
    TextView tvAllNum;
    private List<String> bannerlist;
    private List<View> mBannerList = new ArrayList<>();
    private String position;
    private HouseDetailsBean.DatasBean datas;
    private List<HouseDetailsBean.DatasBean.BannerlistBean> bannerlist1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_details);
        ButterKnife.bind(this);
        position = getIntent().getStringExtra("position");
        datas = (HouseDetailsBean.DatasBean) getIntent().getSerializableExtra("datas");
        bannerlist = (List<String>) getIntent().getSerializableExtra("bannerlist");
        if (datas!=null){
            bannerlist1 = datas.getBannerlist();
        }
        initVpBanner();
    }

    private void initVpBanner() {
        if (bannerlist!=null) {
            int screenWidth = MyUtils.getScreenWidth(BannerDetailsActivity.this);
            for (int i = 0; i < bannerlist.size(); i++) {
                View inflate = View.inflate(mContext, R.layout.banner_layout, null);
                ImageView img_banner = (ImageView) inflate.findViewById(R.id.img_banner);
                //设置图片参数
                ViewGroup.LayoutParams layoutParams = img_banner.getLayoutParams();
                layoutParams.width = screenWidth;
                layoutParams.height = (int) (screenWidth * 0.7);
                img_banner.setLayoutParams(layoutParams);
                Glide.with(this).load(bannerlist.get(i)).into(img_banner);
                mBannerList.add(inflate);
            }
            tvAllNum.setText(bannerlist.size()+"");
        }else {
            int screenWidth = MyUtils.getScreenWidth(BannerDetailsActivity.this);
            for (int i = 0; i < bannerlist1.size(); i++) {
                View inflate = View.inflate(mContext, R.layout.banner_layout, null);
                ImageView img_banner = (ImageView) inflate.findViewById(R.id.img_banner);
                //设置图片参数
                ViewGroup.LayoutParams layoutParams = img_banner.getLayoutParams();
                layoutParams.width = screenWidth;
                layoutParams.height = (int) (screenWidth * 0.7);
                img_banner.setLayoutParams(layoutParams);
                Glide.with(this).load(bannerlist1.get(i).getVal()).into(img_banner);
                mBannerList.add(inflate);
            }
            tvAllNum.setText(bannerlist1.size()+"");
        }

        tvNum.setText(Integer.parseInt(position)+1 + "");
        vpBanner.setAdapter(adapter);
        vpBanner.setCurrentItem(Integer.parseInt(position));
        vpBanner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {

                tvNum.setText((position + 1) + "");

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

    @OnClick(R.id.back_img)
    public void onViewClicked() {
        finish();
    }
}
