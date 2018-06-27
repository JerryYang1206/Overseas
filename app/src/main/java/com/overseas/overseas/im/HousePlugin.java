package com.overseas.overseas.im;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;


import com.overseas.overseas.R;
import com.overseas.overseas.mine.ManagerActivity;

import io.rong.imkit.RongExtension;
import io.rong.imkit.plugin.IPluginModule;

/**
 * Created by   admin on 2018/4/28.
 */

public class HousePlugin implements IPluginModule {
    @Override
    public Drawable obtainDrawable(Context context) {
        return ContextCompat.getDrawable(context, R.drawable.house_plugin);
    }

    @Override
    public String obtainTitle(Context context) {
        return "房源";
    }

    @Override
    public void onClick(Fragment fragment, RongExtension rongExtension) {
        Intent intent = new Intent(fragment.getActivity(), ManagerActivity.class);
        String id = fragment.getActivity().getIntent().getData().getQueryParameter("targetId");
        intent.putExtra("ManagerId", id);
        rongExtension.startActivityForPluginResult(intent, 23, this);
    }

    @Override
    public void onActivityResult(int i, int i1, Intent intent) {

    }
}