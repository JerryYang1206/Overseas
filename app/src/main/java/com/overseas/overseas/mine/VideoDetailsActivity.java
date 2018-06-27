package com.overseas.overseas.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.overseas.overseas.R;
import com.overseas.overseas.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

public class VideoDetailsActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.videoplayer)
    JZVideoPlayerStandard videoplayer;
    @BindView(R.id.img_back)
    ImageView img_back;
    private String videoUrl,VideoImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_details);
        ButterKnife.bind(this);
        videoUrl = getIntent().getStringExtra("VideoUrl");
        VideoImg = getIntent().getStringExtra("VideoImg");
        img_back.setOnClickListener(this);
        initView();
    }

    private void initView() {
       /* "http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4"*/
        videoplayer.setUp(videoUrl
                , JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "");
        Glide.with(this).load(VideoImg).into(videoplayer.thumbImageView);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
