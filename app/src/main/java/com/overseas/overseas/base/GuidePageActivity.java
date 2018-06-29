package com.overseas.overseas.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.overseas.overseas.R;
import com.overseas.overseas.utils.SharedPreferencesUtils;

import org.zackratos.ultimatebar.UltimateBar;


/**
 * Created by lxk on 2017/6/30.
 */

public class GuidePageActivity extends BaseActivity {
    private ViewPager vp;
    private GuidePagerAdapter mGuidePagerAdapter;
    private int[] imgurls = {R.drawable.yindaoye1, R.drawable.yindaoye2, R.drawable.yindaoye3};
//    private List<GuidePageBean.DatasBean> datas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UltimateBar ultimateBar = new UltimateBar(this);
        ultimateBar.setImmersionBar(false);
        setContentView(R.layout.activity_guide);
        vp = (ViewPager) findViewById(R.id.vp);
//        go();
        if (mGuidePagerAdapter == null) {
            mGuidePagerAdapter = new GuidePagerAdapter();
        }
        vp.setAdapter(mGuidePagerAdapter);
    }

//    private void go() {
//        OkGo.get(MyContants.BASEURL+"Startpage/leadPage")
//                .tag(GuidePageActivity.this)
//                .execute(new StringCallback() {
//                    @Override
//                    public void onSuccess(String s, Call call, Response response) {
//                        Gson gson = new Gson();
//                        GuidePageBean guidePageBean = new Gson().fromJson(s, GuidePageBean.class);
//                        if (guidePageBean.getCode()==101){
//                            Intent intent = new Intent(GuidePageActivity.this, MainActivity.class);
//                            startActivity(intent);
//                            finish();
//                        }else {
//                            if (guidePageBean.getDatas() != null && guidePageBean.getDatas().size() > 0&&guidePageBean!=null) {
//                                datas = guidePageBean.getDatas();
//                                if (mGuidePagerAdapter == null) {
//                                    mGuidePagerAdapter = new GuidePagerAdapter();
//                                }
//                                vp.setAdapter(mGuidePagerAdapter);
//                            }
//                        }
//
//
//                    }
//
//                    @Override
//                    public void onError(Call call, Response response, Exception e) {
//                        Toast.makeText(GuidePageActivity.this, "请检查网络或重试", Toast.LENGTH_SHORT).show();
//                        Log.e("请求失败", "失败原因：" + response);
//                    }
//                });
//    }

    private class GuidePagerAdapter extends PagerAdapter {

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = View.inflate(GuidePageActivity.this, R.layout.item_guide, null);
            TextView tv_jinru = (TextView) view.findViewById(R.id.tv_jinru);
            if (position == 2) {
                tv_jinru.setVisibility(View.VISIBLE);
            } else {
                tv_jinru.setVisibility(View.GONE);
            }
            tv_jinru.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferencesUtils.getInstace(GuidePageActivity.this).setBooleanPreference( "guide", true);
                    startActivity(new Intent(GuidePageActivity.this,LoginActivity.class));
                    finish();
                }
            });
            ImageView iv_guide = (ImageView) view.findViewById(R.id.iv_guide);
            if (imgurls!=null) {
                Glide.with(GuidePageActivity.this).load(imgurls[position]).into(iv_guide);
            }
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
