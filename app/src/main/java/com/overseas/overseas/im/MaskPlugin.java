package com.overseas.overseas.im;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;


import com.overseas.overseas.R;

import io.rong.imkit.RongExtension;
import io.rong.imkit.RongIM;
import io.rong.imkit.plugin.IPluginModule;
import io.rong.imlib.RongIMClient;

/**
 * Created by   admin on 2018/4/28.
 */

public class MaskPlugin implements IPluginModule {
    @Override
    public Drawable obtainDrawable(Context context) {
        return ContextCompat.getDrawable(context, R.drawable.shield_plugin);
    }

    @Override
    public String obtainTitle(Context context) {
        return "屏蔽拉黑";
    }

    @Override
    public void onClick(final Fragment fragment, RongExtension rongExtension) {
        final String id = fragment.getActivity().getIntent().getData().getQueryParameter("targetId");
        RongIM.getInstance().getBlacklistStatus(id, new RongIMClient.ResultCallback<RongIMClient.BlacklistStatus>() {
            @Override
            public void onSuccess(RongIMClient.BlacklistStatus blacklistStatus) {
                if (blacklistStatus == RongIMClient.BlacklistStatus.IN_BLACK_LIST) {
                    ImManager.removeFromBlack(id, fragment.getActivity());
                } else {
                    ImManager.addToBlack(id, fragment.getActivity());
                }
            }

            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {

            }
        });
    }

    @Override
    public void onActivityResult(int i, int i1, Intent intent) {

    }
}