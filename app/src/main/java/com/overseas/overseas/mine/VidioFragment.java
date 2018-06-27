package com.overseas.overseas.mine;

import android.view.View;

import com.overseas.overseas.R;
import com.overseas.overseas.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by Administrator on 2018/1/18.
 */
public class VidioFragment extends BaseFragment {


    @BindView(R.id.videoplayer)
    JZVideoPlayerStandard videoplayer;
    Unbinder unbinder;

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_vidio, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initData() {
        videoplayer.setUp("http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4"
                , JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "");
        videoplayer.thumbImageView.setImageResource(R.drawable.bg_map);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
//        videoplayer.onStatePause();
    }

    @Override
    public void onPause() {
        super.onPause();
           }
}


