package com.overseas.overseas.mine;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.overseas.overseas.R;
import com.overseas.overseas.base.BaseActivity;
import com.overseas.overseas.bean.CloseSelectBean;
import com.overseas.overseas.utils.SharedPreferencesUtils;
import com.yanzhenjie.recyclerview.swipe.SwipeMenu;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuBridge;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;
import com.yyydjk.library.DropDownMenu;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LiShiActivity extends BaseActivity implements MyItemClickListener {

    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.dropDownMenu)
    DropDownMenu mDropDownMenu;

    private List<View> popupViews = new ArrayList<>();
    private SwipeMenuRecyclerView mrecycler;
    private List<String> mList = new ArrayList();
    private LiebiaoAdapter liebiaoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_li_shi);
        ButterKnife.bind(this);
        EventBus.getDefault().register(LiShiActivity.this);
        initView();

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void myEvent(CloseSelectBean messageEvent) {
        if (messageEvent.getClose().equals("close")) {
            mDropDownMenu.closeMenu();
        }
    }

    private void initView() {
        String headers[] = {getResources().getString(R.string.leixing), getResources().getString(R.string.shijian)};

        /**
         * 第一个界面
         * */
        FirstView firstView = new FirstView(LiShiActivity.this);
        firstView.setListener(this);
        popupViews.add(firstView.firstView());
        /**
         * 第二个界面
         * */
        SecView secView = new SecView(LiShiActivity.this);
        secView.setListener(this);
        popupViews.add(secView.secView());

        /**
         * Dropdownmenu下面的主体部分
         * */
        View fifthView = LayoutInflater.from(LiShiActivity.this).inflate(R.layout.activity_main_view, null);
        mrecycler = (SwipeMenuRecyclerView) fifthView.findViewById(R.id.mrecycler);
        mDropDownMenu.setDropDownMenu(Arrays.asList(headers), popupViews, fifthView);
        initData();
    }

    private void initData() {
        if (mList.size() <= 0) {
            mList.add("");
            mList.add("");
            mList.add("");
            mList.add("");
            mList.add("");
        }
        liebiaoAdapter = new LiebiaoAdapter(R.layout.item_zuijin, mList);
        mrecycler.setNestedScrollingEnabled(false);
        mrecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        // 设置监听器。
        mrecycler.setSwipeMenuCreator(mSwipeMenuCreator);

        mrecycler.setSwipeMenuItemClickListener(new SwipeMenuItemClickListener() {
            @Override
            public void onItemClick(SwipeMenuBridge menuBridge) {
                mList.remove(menuBridge.getAdapterPosition());
                menuBridge.closeMenu();
                liebiaoAdapter.notifyDataSetChanged();

            }
        });
        mrecycler.setAdapter(liebiaoAdapter);

    }

    // 创建菜单:
    SwipeMenuCreator mSwipeMenuCreator = new SwipeMenuCreator() {
        @Override
        public void onCreateMenu(SwipeMenu leftMenu, SwipeMenu rightMenu, int viewType) {
            //            SwipeMenuItem deleteItem = new SwipeMenuItem(mContext); // 各种文字和图标属性设置。
            //            leftMenu.addMenuItem(deleteItem); // 在Item左侧添加一个菜单。
            SwipeMenuItem deleteItem = new SwipeMenuItem(LiShiActivity.this); // 各种文字和图标属性设置。
            deleteItem.setWeight(100);
            deleteItem.setHeight(380);
            deleteItem.setText("   删除   ");
            deleteItem.setTextSize(14);
            deleteItem.setBackgroundColor(getResources().getColor(R.color.red));
            deleteItem.setTextColor(Color.WHITE);
            rightMenu.addMenuItem(deleteItem); // 在Item右侧添加一个菜单。
            // 注意:哪边不想要菜单,那么不要添加即可。
        }
    };


    class LiebiaoAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public LiebiaoAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
            LinearLayout layout_all_height = helper.getView(R.id.layout_all_height);
            layout_all_height.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String leixing = SharedPreferencesUtils.getInstace(LiShiActivity.this).getStringPreference("leixing", "");
                    if (leixing.equals("二手房")) {
                        Intent intent = new Intent(LiShiActivity.this, LishiOldHouseActivity.class);
                        startActivity(intent);
                        return;
                    } else if (leixing.equals("租房")) {
                        Intent intent = new Intent(LiShiActivity.this, LishiZuHouseActivity.class);
                        startActivity(intent);
                        return;
                    } else if (leixing.equals("新房")) {
                        Intent intent = new Intent(LiShiActivity.this, LishiNewHouseActivity.class);
                        startActivity(intent);
                        return;
                    } else if (leixing.equals("海外地产")) {
                        Intent intent = new Intent(LiShiActivity.this, LishiHaiwaiActivity.class);
                        startActivity(intent);
                        return;
                    } else if (leixing.equals("商业地产")) {
                        Intent intent = new Intent(LiShiActivity.this, LishiShangyeActivity.class);
                        startActivity(intent);
                        return;
                    } else if (leixing.equals("中国房源")) {
                        Intent intent = new Intent(LiShiActivity.this, LishiZhongGuoActivity.class);
                        startActivity(intent);
                        return;
                    }
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        //退出activity前关闭菜单
        if (mDropDownMenu.isShowing()) {
            mDropDownMenu.closeMenu();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onItemClick(View view, int postion, String string) {
        switch (postion) {
            case 1:
                mDropDownMenu.setTabText(string);
                mDropDownMenu.closeMenu();
                break;
            case 2:
                mDropDownMenu.setTabText(string);
                mDropDownMenu.closeMenu();
                break;
            default:
                break;
        }
    }

    @OnClick(R.id.back_img)
    public void onClick() {
        finish();
    }


}
