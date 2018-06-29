package com.overseas.overseas.mine;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.liaoinstan.springview.widget.SpringView;
import com.lzy.okgo.model.Response;
import com.overseas.overseas.MyApplication;
import com.overseas.overseas.R;
import com.overseas.overseas.base.BaseActivity;
import com.overseas.overseas.bean.HistroyDoneBean;
import com.overseas.overseas.bean.OneCheckBean;
import com.overseas.overseas.presenter.HistroyPresenter;
import com.overseas.overseas.utils.TUtils;
import com.overseas.overseas.view.MyFooter;
import com.overseas.overseas.view.MyHeader;
import com.yanzhenjie.recyclerview.swipe.SwipeMenu;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuBridge;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;
import com.yyydjk.library.DropDownMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LiShiActivity extends BaseActivity implements MyItemClickListener, HistroyPresenter.HistroyCallBack {

    @BindView(R.id.iv_back)
    ImageView iv_back;
    @BindView(R.id.dropDownMenu)
    DropDownMenu mDropDownMenu;
    private String headers[];
    private List<View> popupViews = new ArrayList<>();
    private SwipeMenuRecyclerView mrecycler;
    private LiebiaoAdapter liebiaoAdapter;
    private TextView tvNoContent;
    private SpringView springview;
    private HistroyPresenter presenter;
    private boolean isLoadMore;
    private int page = 1;
    private boolean isJa;
    private List<HistroyDoneBean.DatasEntity> mDatas;
    private int typeId = 2;//默认二手房
    private int timeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_li_shi);
        ButterKnife.bind(this);
        initView();
        initData();
        initListener();
    }

    private void initListener() {
        springview.setHeader(new MyHeader(this));
        springview.setFooter(new MyFooter(this));
        springview.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                isLoadMore = false;
                page = 1;
                presenter.getHistroyList(page, typeId, timeId);
                springview.onFinishFreshAndLoad();
            }

            @Override
            public void onLoadmore() {
                isLoadMore = true;
                page++;
                presenter.getHistroyList(page, typeId, timeId);
                springview.onFinishFreshAndLoad();
            }
        });
    }

    private void initView() {
        headers = new String[]{getResources().getString(R.string.leixing), getResources().getString(R.string.shijian)};
        /**
         * 第一个界面
         * */
        List<OneCheckBean> list = new ArrayList();
        if (list.size() == 0) {
            list.add(new OneCheckBean(true, getResources().getString(R.string.ershoufang), 2));
            list.add(new OneCheckBean(false, getResources().getString(R.string.zufang), 1));
            list.add(new OneCheckBean(false, getResources().getString(R.string.xinfang), 0));
            list.add(new OneCheckBean(false, getResources().getString(R.string.tudi), 3));
            list.add(new OneCheckBean(false, getResources().getString(R.string.bieshu), 7));
            list.add(new OneCheckBean(false, getResources().getString(R.string.haiwaidichan), 5));
            list.add(new OneCheckBean(false, getResources().getString(R.string.shangyedichan), 4));
            list.add(new OneCheckBean(false, getResources().getString(R.string.zhonggguofangyuan), 6));
        }
        SecView secView = new SecView(LiShiActivity.this);
        popupViews.add(secView.secView());
        secView.setListener(this);
        secView.insertData(list, mDropDownMenu, true);
        /**
         * 第二个界面
         * */
        List<OneCheckBean> list1 = new ArrayList();
        if (list1.size() == 0) {
            for (int i = 0; i < 6; i++) {
                list1.add(new OneCheckBean(false, (i + 1) + getString(R.string.geyue), i + 1));
            }
        }
        SecView secView1 = new SecView(LiShiActivity.this);
        popupViews.add(secView1.secView());
        secView1.setListener(this);
        secView1.insertData(list1, mDropDownMenu, true);
        /**
         * Dropdownmenu下面的主体部分
         * */
        View fifthView = LayoutInflater.from(LiShiActivity.this).inflate(R.layout.activity_main_view, null);
        mrecycler = (SwipeMenuRecyclerView) fifthView.findViewById(R.id.mrecycler);
        springview = (SpringView) fifthView.findViewById(R.id.springview);
        tvNoContent = (TextView) fifthView.findViewById(R.id.tv_noContent);
        mrecycler.setNestedScrollingEnabled(false);
        mrecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mDropDownMenu.setDropDownMenu(Arrays.asList(headers), popupViews, fifthView);
    }

    private void initData() {
        presenter = new HistroyPresenter(this, this);
        presenter.getHistroyList(page, typeId, timeId);
    }

    // 创建菜单:
    SwipeMenuCreator mSwipeMenuCreator = new SwipeMenuCreator() {
        @Override
        public void onCreateMenu(SwipeMenu leftMenu, SwipeMenu rightMenu, int viewType) {
            //            SwipeMenuItem deleteItem = new SwipeMenuItem(mContext); // 各种文字和图标属性设置。
            //            leftMenu.addMenuItem(deleteItem); // 在Item左侧添加一个菜单。
            SwipeMenuItem deleteItem = new SwipeMenuItem(LiShiActivity.this); // 各种文字和图标属性设置。
            deleteItem.setWidth(150);
            deleteItem.setHeight(380);
            deleteItem.setText(getResources().getString(R.string.shanchu));
            deleteItem.setTextSize(14);
            deleteItem.setBackgroundColor(getResources().getColor(R.color.red));
            deleteItem.setTextColor(Color.WHITE);
            rightMenu.addMenuItem(deleteItem); // 在Item右侧添加一个菜单。
            // 注意:哪边不想要菜单,那么不要添加即可。
        }
    };

    @Override
    public void getHistroyList(Response<HistroyDoneBean> response) {
        HistroyDoneBean body = response.body();
        final List<HistroyDoneBean.DatasEntity> datas = body.getDatas();
        tvNoContent.setVisibility(View.GONE);
        springview.setVisibility(View.VISIBLE);
        if (mDatas == null || mDatas.size() == 0) {
            if (datas == null || datas.size() == 0) {
                tvNoContent.setVisibility(View.VISIBLE);
                springview.setVisibility(View.GONE);
                if (liebiaoAdapter != null) {
                    liebiaoAdapter.notifyDataSetChanged();
                }
                return;
            }
            mDatas = datas;
            liebiaoAdapter = new LiebiaoAdapter(R.layout.item_zuijin, mDatas);
            mrecycler.setAdapter(liebiaoAdapter);
        } else {
            if (datas == null || datas.size() == 0) {
                TUtils.showFail(this, getString(R.string.meiyougengduoshujule));
                return;
            }
            if (!isLoadMore) {
                mDatas = datas;
                TUtils.showFail(this, getString(R.string.shuaxinchenggong));
            } else {
                mDatas.addAll(mDatas);
            }
            liebiaoAdapter.notifyDataSetChanged();
        }
        mrecycler.setSwipeMenuCreator(mSwipeMenuCreator);
        mrecycler.setSwipeMenuItemClickListener(new SwipeMenuItemClickListener() {
            @Override
            public void onItemClick(SwipeMenuBridge menuBridge) {
                String shType = mDatas.get(menuBridge.getPosition()).getShType();
                if (TextUtils.isEmpty(shType)) {
                    presenter.deteleHouseRecord(mDatas.get(menuBridge.getPosition()).getId(), typeId, 100);
                }else {
                    presenter.deteleHouseRecord(mDatas.get(menuBridge.getPosition()).getId(), typeId, Integer.parseInt(shType));
                }
                mDatas.remove(menuBridge.getAdapterPosition());
                menuBridge.closeMenu();
                liebiaoAdapter.notifyDataSetChanged();
            }
        });
    }


    class LiebiaoAdapter extends BaseQuickAdapter<HistroyDoneBean.DatasEntity, BaseViewHolder> {

        public LiebiaoAdapter(@LayoutRes int layoutResId, @Nullable List<HistroyDoneBean.DatasEntity> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, final HistroyDoneBean.DatasEntity item) {
            helper.getView(R.id.layout_all_height).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int houseId = item.getId();
                    String hType = typeId+"";
                    String ShType = item.getShType();
                    if (TextUtils.equals(hType, "2")) { //二手房
                        Intent intent = new Intent(LiShiActivity.this, LishiOldHouseActivity.class);
                        intent.putExtra("houseId", houseId + "");
                        startActivity(intent);
                    } else if (TextUtils.equals(hType, "0")) { //新房
                        Intent intent = new Intent(LiShiActivity.this, LishiNewHouseActivity.class);
                        intent.putExtra("houseId", houseId + "");
                        startActivity(intent);
                    } else if (TextUtils.equals(hType, "1")) { //租房
                        Intent intent = new Intent(LiShiActivity.this, LishiZuHouseActivity.class);

                        if (TextUtils.equals(ShType, "0")) { //办公室出租
                            intent.putExtra("houseId", houseId + "");
                            intent.putExtra("houseType", "bangongshi");
                        } else if (TextUtils.equals(ShType, "1")) { //商铺出租
                            intent.putExtra("houseId", houseId + "");
                            intent.putExtra("houseType", "shangpu");
                        } else if (TextUtils.equals(ShType, "2")) { //别墅
                            intent.putExtra("houseId", houseId + "");
                            intent.putExtra("houseType", "bieshu");
                        } else if (TextUtils.equals(ShType, "3")) { //二层公寓
                            intent.putExtra("houseId", houseId + "");
                            intent.putExtra("houseType", "erceng");
                        } else if (TextUtils.equals(ShType, "4")) { //学生公寓
                            intent.putExtra("houseId", houseId + "");
                            intent.putExtra("houseType", "xuesheng");
                        } else if (TextUtils.equals(ShType, "5")) { //多层公寓
                            intent.putExtra("houseId", houseId + "");
                            intent.putExtra("houseType", "duoceng");
                        }
                        startActivity(intent);
                    } else if (TextUtils.equals(hType, "3")) {  //土地
                        Intent intent = new Intent(LiShiActivity.this, LishiTudiActivity.class);
                        intent.putExtra("houseId", houseId + "");
                        startActivity(intent);
                    } else if (TextUtils.equals(hType, "7")) {  //别墅
                        Intent intent = new Intent(LiShiActivity.this, BieshudetailsActivity.class);
                        intent.putExtra("houseId", houseId + "");
                        startActivity(intent);
                    } else if (TextUtils.equals(hType, "4")) {  //商业地产
                        if (TextUtils.equals(ShType, "0")) {    //酒店
                            Intent intent = new Intent(LiShiActivity.this, LishiJiuDianActivity.class);
                            intent.putExtra("houseId", houseId + "");
                            startActivity(intent);
                        } else if (TextUtils.equals(ShType, "1")) { //高尔夫球场
                            Intent intent = new Intent(LiShiActivity.this, LishiGaoerfuActivity.class);
                            intent.putExtra("houseId", houseId + "");
                            startActivity(intent);
                        } else if (TextUtils.equals(ShType, "2")) { //写字楼
                            Intent intent = new Intent(LiShiActivity.this, LishiXiezilouActivity.class);
                            intent.putExtra("houseId", houseId + "");
                            startActivity(intent);
                        } else if (TextUtils.equals(ShType, "3")) { //商铺
                                                        Intent intent = new Intent(LiShiActivity.this, LishiShangPuActivity.class);
                                                        intent.putExtra("houseId", houseId + "");
                                                        startActivity(intent);
                        }
                    } else if (TextUtils.equals(hType, "6")) { //中国房源
                        Intent intent = new Intent(LiShiActivity.this, LishiZhongGuoActivity.class);
                        intent.putExtra("houseId", houseId + "");
                        startActivity(intent);
                    } else if (TextUtils.equals(hType, "5")) {  //海外房源
                        Intent intent = new Intent(LiShiActivity.this, LishiHaiwaiActivity.class);
                        intent.putExtra("houseId", houseId + "");
                        startActivity(intent);
                    }
                }
            });
            Glide.with(MyApplication.getGloableContext()).load(item.getImageUrl())
                    .into((ImageView) helper.getView(R.id.img_house));
            helper.setText(R.id.tv_house_name, isJa ? item.getTitleJpn() : item.getTitleCn())
                    .setText(R.id.tv_house_address, isJa ? item.getAddressJpn() : item.getAddressCn())
                    .setText(R.id.tv_house_area, isJa ? item.getAreaJpn() : item.getAreaCn())
                    .setText(R.id.tv_price, isJa ? item.getPriceJpn() : item.getPriceCn())
                    .setText(R.id.tv_house_room, isJa ? item.getDoorModelJpn() : item.getDoorModelCn());
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
    public void onItemClick(View view, int postion, int id) {
        switch (postion) {
            case 1://类型
                typeId = id;
                page = 1;
                if (mDatas != null)
                    mDatas.clear();
                initData();
                break;
            case 2://时间
                timeId = id;
                page = 1;
                if (mDatas != null)
                    mDatas.clear();
                initData();
                break;
            default:
                break;
        }
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }


}
