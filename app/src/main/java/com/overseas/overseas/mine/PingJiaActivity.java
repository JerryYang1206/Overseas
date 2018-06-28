package com.overseas.overseas.mine;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.overseas.overseas.bean.MyPingjiaBean;
import com.overseas.overseas.presenter.MyPingjiaPresenter;
import com.overseas.overseas.utils.TUtils;
import com.overseas.overseas.view.LetterSpacingTextView;
import com.overseas.overseas.view.MyFooter;
import com.overseas.overseas.view.MyHeader;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PingJiaActivity extends BaseActivity implements MyPingjiaPresenter.PingjiaCallBack {

    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.recycler_liebiao)
    RecyclerView mrecycler;
    @BindView(R.id.springview)
    SpringView springview;
    @BindView(R.id.tv_noContent)
    TextView tvNoContent;
    private LiebiaoAdapter liebiaoAdapter;
    private MyPingjiaPresenter presenter;
    private boolean isLoadMore;
    private int page = 1;
    private List<MyPingjiaBean.DatasEntity> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ping_jia);
        ButterKnife.bind(this);
        mrecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mrecycler.setNestedScrollingEnabled(false);
        presenter = new MyPingjiaPresenter(this, this);
        presenter.getAllPingjiaData(page);
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
                presenter.getAllPingjiaData(page);
                springview.onFinishFreshAndLoad();
            }

            @Override
            public void onLoadmore() {
                isLoadMore = true;
                page++;
                presenter.getAllPingjiaData(page);
                springview.onFinishFreshAndLoad();
            }
        });
    }

    @Override
    public void getAllPingjiaData(Response<MyPingjiaBean> response) {
        List<MyPingjiaBean.DatasEntity> datas = response.body().getDatas();
        tvNoContent.setVisibility(View.GONE);
        springview.setVisibility(View.VISIBLE);
        if (mDatas == null || mDatas.size() == 0) {
            if (mDatas == null || mDatas.size() == 0) {
                tvNoContent.setVisibility(View.VISIBLE);
                springview.setVisibility(View.GONE);
                if (liebiaoAdapter != null) {
                    liebiaoAdapter.notifyDataSetChanged();
                }
                return;
            }
            mDatas = datas;
            liebiaoAdapter = new LiebiaoAdapter(R.layout.liebiao_item, mDatas);
            mrecycler.setAdapter(liebiaoAdapter);
        } else {
            if (mDatas == null || mDatas.size() == 0) {
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
    }

    class LiebiaoAdapter extends BaseQuickAdapter<MyPingjiaBean.DatasEntity, BaseViewHolder> {

        public LiebiaoAdapter(@LayoutRes int layoutResId, @Nullable List<MyPingjiaBean.DatasEntity> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, MyPingjiaBean.DatasEntity item) {
            LetterSpacingTextView tv_content = helper.getView(R.id.tv_content);
            tv_content.setSpacing(3);
            tv_content.setText(item.getContent());
            helper.setText(R.id.tv_name, item.getUserName())
                    .setText(R.id.tv_time, getTime(item.getCreateTime()))
                    .setText(R.id.tv_haoping, item.getStar() + "");
            Glide.with(MyApplication.getGloableContext()).load(item.getPicUrl())
                    .into((ImageView) helper.getView(R.id.iv_head));
        }
    }

    private String getTime(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        Date curDate = new Date(time);
        String date = sdf.format(curDate);
        return date;
    }

    @OnClick(R.id.back_img)
    public void onClick() {
        finish();
    }
}
