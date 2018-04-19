package com.overseas.overseas.mine;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.overseas.overseas.R;
import com.overseas.overseas.base.BaseActivity;
import com.yanzhenjie.recyclerview.swipe.SwipeMenu;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuBridge;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ZuiJinActivity extends BaseActivity {

    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.mrecycler)
    SwipeMenuRecyclerView mrecycler;
    private List<String> mList=new ArrayList();
    private int measuredHeight;
    private LiebiaoAdapter liebiaoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zui_jin);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
            mList.add("q");
            mList.add("q");
            mList.add("w");
            mList.add("q");
            mList.add("w");

        liebiaoAdapter = new LiebiaoAdapter(R.layout.item_zuijin,mList);
        mrecycler.setNestedScrollingEnabled(false);
        mrecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

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
            SwipeMenuItem deleteItem = new SwipeMenuItem(ZuiJinActivity.this); // 各种文字和图标属性设置。
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
            super(layoutResId,data);
        }

        @Override
        protected void convert(BaseViewHolder helper,String item) {
            LinearLayout layout_all_height = helper.getView(R.id.layout_all_height);
            layout_all_height.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(ZuiJinActivity.this,LishiNewHouseActivity.class);
                    startActivity(intent);                }
            });
        }
    }
    @OnClick(R.id.back_img)
    public void onClick() {
        finish();
    }
}
