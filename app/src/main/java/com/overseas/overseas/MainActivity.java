package com.overseas.overseas;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.overseas.overseas.base.BaseActivity;
import com.overseas.overseas.base.BaseFragment;
import com.overseas.overseas.fragment.MineFragment;
import com.overseas.overseas.fragment.WeiChartFragment;

import org.zackratos.ultimatebar.UltimateBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.rb_Game)
    RadioButton rbGame;
    @BindView(R.id.rb_Okami)
    RadioButton rbOkami;
    @BindView(R.id.rgp)
    RadioGroup rgp;
    private List<BaseFragment> mBaseFragmentList = new ArrayList<>();
    private long preTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UltimateBar ultimateBar = new UltimateBar(this);
        ultimateBar.setImmersionBar(false);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //        HashMap<String, Boolean> hashMap = new HashMap<>();
        //        //会话类型 以及是否聚合显示
        //        hashMap.put(Conversation.ConversationType.PRIVATE.getName(), false);
        ////        hashMap.put(Conversation.ConversationType.PUSH_SERVICE.getName(),true);
        ////        hashMap.put(Conversation.ConversationType.SYSTEM.getName(),true);
        //        RongIM.getInstance().startConversationList(this, hashMap);

        initData();
        //设置Tab
        initsetradio();
        initListener();
    }

    private void initData() {
        if (mBaseFragmentList.size() <= 0) {
            mBaseFragmentList.add(new WeiChartFragment());
            mBaseFragmentList.add(new MineFragment());
        }
    }

    private void initsetradio() {
        Drawable drawablegame = getResources().getDrawable(R.drawable.tab_game_selector);
        drawablegame.setBounds(0, 0, 80, 80);
        rbGame.setCompoundDrawables(null, drawablegame, null, null);

        Drawable drawablemine = getResources().getDrawable(R.drawable.tab_mine_selector);
        drawablemine.setBounds(0, 0, 80, 80);
        rbOkami.setCompoundDrawables(null, drawablemine, null, null);
    }

    private void initListener() {
        rbGame.setOnClickListener(this);
        rbOkami.setOnClickListener(this);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        //注意add方法会走fragment的生命周期方法，相当于加载了一遍数据
        fragmentTransaction.add(R.id.fl_content, mBaseFragmentList.get(0));
        fragmentTransaction.add(R.id.fl_content, mBaseFragmentList.get(1));
        fragmentTransaction.show(mBaseFragmentList.get(0));
        fragmentTransaction.hide(mBaseFragmentList.get(1));
        rgp.check(R.id.rb_Game);//刷新radiobutton的状态
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() > preTime + 2000) {
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
            preTime = System.currentTimeMillis();
        } else {
            super.onBackPressed();//相当于finish()
            removeAllActivitys();//删除所有引用
        }
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (v.getId()) {
            case R.id.rb_Game:
                fragmentTransaction.show(mBaseFragmentList.get(0));
                fragmentTransaction.hide(mBaseFragmentList.get(1));
                fragmentTransaction.commitAllowingStateLoss();
                break;
            case R.id.rb_Okami:
                fragmentTransaction.show(mBaseFragmentList.get(1));
                fragmentTransaction.hide(mBaseFragmentList.get(0));
                fragmentTransaction.commitAllowingStateLoss();
                break;
        }
    }
}
