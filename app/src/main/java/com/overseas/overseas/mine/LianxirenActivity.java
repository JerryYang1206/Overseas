//package com.overseas.overseas.mine;
//
//import android.graphics.Color;
//import android.os.Bundle;
//import android.support.annotation.LayoutRes;
//import android.support.annotation.Nullable;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.Toast;
//
//import com.chad.library.adapter.base.BaseQuickAdapter;
//import com.chad.library.adapter.base.BaseViewHolder;
//import com.overseas.overseas.R;
//import com.overseas.overseas.base.BaseActivity;
//import com.yanzhenjie.recyclerview.swipe.SwipeMenu;
//import com.yanzhenjie.recyclerview.swipe.SwipeMenuBridge;
//import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
//import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
//import com.yanzhenjie.recyclerview.swipe.SwipeMenuItemClickListener;
//import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//import butterknife.OnClick;
//
//public class LianxirenActivity extends BaseActivity {
//
//    @BindView(R.id.Mrecycler)
//    RecyclerView Mrecycler;
//    @BindView(R.id.back_img)
//    ImageView backImg;
//    private LiebiaoAdapter mLiebiaoAdapter;
//    private List<String> mList = new ArrayList();
//    private ItemAdapter itemAdapter;
//    private SwipeMenuRecyclerView mrecycler_item;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_lianxiren);
//        ButterKnife.bind(this);
//        initData();
//    }
//
//    private void initData() {
//        if (mList.size() <= 0) {
//            mList.add("");
//            mList.add("");
//            mList.add("");
//            mList.add("");
//            mList.add("");
//        }
//        if (mLiebiaoAdapter == null) {
//            mLiebiaoAdapter = new LiebiaoAdapter(R.layout.lianxiren_item, mList);
//        }
//        Mrecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        Mrecycler.setNestedScrollingEnabled(false);
//        Mrecycler.setAdapter(mLiebiaoAdapter);
//        mLiebiaoAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                Toast.makeText(LianxirenActivity.this, "点击了第" + position + "条", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    @OnClick(R.id.back_img)
//    public void onClick() {
//        finish();
//    }
//
//    class LiebiaoAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
//
//        public LiebiaoAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
//            super(layoutResId, data);
//        }
//
//        @Override
//        protected void convert(BaseViewHolder helper, String item) {
//            mrecycler_item = helper.getView(R.id.mrecycler_item);
//            if (itemAdapter == null) {
//                itemAdapter = new ItemAdapter(R.layout.item_lianxiren, mList);
//            }
//            mrecycler_item.setLayoutManager(new LinearLayoutManager(LianxirenActivity.this, LinearLayoutManager.VERTICAL, false));
//            mrecycler_item.setNestedScrollingEnabled(false);
//            // 设置监听器。
//            mrecycler_item.setSwipeMenuCreator(mSwipeMenuCreator);
//
//            mrecycler_item.setSwipeMenuItemClickListener(new SwipeMenuItemClickListener() {
//                @Override
//                public void onItemClick(SwipeMenuBridge menuBridge) {
//                    mList.remove(menuBridge.getAdapterPosition());
//                    menuBridge.closeMenu();
//                    itemAdapter.notifyDataSetChanged();
//                }
//
//            });
//            itemAdapter.setOnItemClickListener(new OnItemClickListener() {
//                @Override
//                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                    Toast.makeText(LianxirenActivity.this, "点击了第" + position + "条", Toast.LENGTH_SHORT).show();
//                }
//            });
//            mrecycler_item.setAdapter(itemAdapter);
//
//        }
//    }
//
//    // 创建菜单:
//    SwipeMenuCreator mSwipeMenuCreator = new SwipeMenuCreator() {
//        @Override
//        public void onCreateMenu(SwipeMenu leftMenu, SwipeMenu rightMenu, int viewType) {
////            SwipeMenuItem deleteItem = new SwipeMenuItem(mContext); // 各种文字和图标属性设置。
////            leftMenu.addMenuItem(deleteItem); // 在Item左侧添加一个菜单。
//            SwipeMenuItem deleteItem = new SwipeMenuItem(LianxirenActivity.this); // 各种文字和图标属性设置。
//            deleteItem.setWeight(100);
//            deleteItem.setHeight(180);
//            deleteItem.setText("   删除   ");
//            deleteItem.setTextSize(14);
//            deleteItem.setBackgroundColor(getResources().getColor(R.color.red));
//            deleteItem.setTextColor(Color.WHITE);
//            rightMenu.addMenuItem(deleteItem); // 在Item右侧添加一个菜单。
//
//// 注意:哪边不想要菜单,那么不要添加即可。
//        }
//    };
//
//    class ItemAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
//
//        public ItemAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
//            super(layoutResId, data);
//        }
//
//        @Override
//        protected void convert(BaseViewHolder helper, String item) {
//
//        }
//    }
//}
