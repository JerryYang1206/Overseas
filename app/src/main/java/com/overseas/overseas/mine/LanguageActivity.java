package com.overseas.overseas.mine;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.overseas.overseas.MainActivity;
import com.overseas.overseas.MyApplication;
import com.overseas.overseas.R;
import com.overseas.overseas.base.BaseActivity;
import com.overseas.overseas.base.LancherActivity;
import com.overseas.overseas.utils.SharedPreferencesUtils;

import java.util.HashMap;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;

public class LanguageActivity extends BaseActivity {

    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.tv_baocun)
    TextView tvBaocun;
    @BindView(R.id.language_layout)
    LinearLayout languageLayout;
    @BindView(R.id.about_layout)
    LinearLayout aboutLayout;
    @BindView(R.id.img_check_zhongwen)
    ImageView imgCheckZhongwen;
    @BindView(R.id.img_check_riwen)
    ImageView imgCheckRiwen;

    Resources resources;
    DisplayMetrics dm;
    Configuration config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        ButterKnife.bind(this);
        resources = getResources();
        dm = resources.getDisplayMetrics();
        config = resources.getConfiguration();

        String location = SharedPreferencesUtils.getInstace(this).getStringPreference("city", "");
        if (!TextUtils.isEmpty(location)) {

            if (TextUtils.equals(location, "zh")) {
                imgCheckZhongwen.setVisibility(View.VISIBLE);
                imgCheckRiwen.setVisibility(View.GONE);
            } else if (TextUtils.equals(location, "ja")) {
                imgCheckZhongwen.setVisibility(View.GONE);
                imgCheckRiwen.setVisibility(View.VISIBLE);
            }
        }
    }

    @OnClick({R.id.back_img, R.id.tv_baocun, R.id.language_layout, R.id.about_layout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_img:
                finish();
                break;
            case R.id.tv_baocun:
                finish();
                break;
            case R.id.language_layout:
                imgCheckZhongwen.setVisibility(View.VISIBLE);
                imgCheckRiwen.setVisibility(View.GONE);
                Locale myLocale = new Locale("zh");
                config.locale = myLocale;
                resources.updateConfiguration(config, dm);
                SharedPreferencesUtils.getInstace(this).setStringPreference("city", "zh");
                recrete();
                break;
            case R.id.about_layout:
                imgCheckZhongwen.setVisibility(View.GONE);
                imgCheckRiwen.setVisibility(View.VISIBLE);
                Locale jaLocale = new Locale("ja");
                config.locale = jaLocale;
                resources.updateConfiguration(config, dm);
                SharedPreferencesUtils.getInstace(this).setStringPreference("city", "ja");
                recrete();
                break;
        }
    }

    public void recrete() {
        removeAllActivitys();

        HashMap<String, Boolean> hashMap = new HashMap<>();
        //会话类型 以及是否聚合显示
        hashMap.put(Conversation.ConversationType.PRIVATE.getName(), false);
//        hashMap.put(Conversation.ConversationType.PUSH_SERVICE.getName(),true);
//        hashMap.put(Conversation.ConversationType.SYSTEM.getName(),true);
        RongIM.getInstance().startConversationList(this, hashMap);

//        Intent intent = new Intent(this, MainActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        startActivity(intent);

    }
}
