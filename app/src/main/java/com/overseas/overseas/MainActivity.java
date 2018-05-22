package com.overseas.overseas;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.overseas.overseas.base.BaseActivity;
import com.overseas.overseas.base.BaseFragment;
import com.overseas.overseas.fragment.MineFragment;
import com.overseas.overseas.fragment.WeiChartFragment;
import com.overseas.overseas.im.ImManager;

import org.zackratos.ultimatebar.UltimateBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.rong.imkit.RongIM;
import io.rong.imlib.model.Conversation;

public class MainActivity extends BaseActivity {

    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.rb_Game)
    RadioButton rbGame;
    @BindView(R.id.rb_Okami)
    RadioButton rbOkami;
    @BindView(R.id.rgp)
    RadioGroup rgp;
    private List<BaseFragment> mBaseFragmentList = new ArrayList<>();
    private BaseFragment preFragment;
    private long preTime;
    private int position;

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
        rgp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_Game:
                        position = 0;
                        break;
                    case R.id.rb_Okami:
                        position = 1;
                        break;
                    default:
                        position = 0;
                        break;
                }
                switchFragment(preFragment, mBaseFragmentList.get(position));
            }
        });
        rgp.check(R.id.rb_Game);//默认选中发现
    }

    private void switchFragment(BaseFragment from, BaseFragment to) {
        if (from == to) {
            return;
        }
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        //判断有没有被添加
        if (!to.isAdded()) {
            //to没有被添加
            //from隐藏
            if (from != null) {
                ft.hide(from);
            }
            //添加to
            if (to != null) {
                ft.add(R.id.fl_content, to).commit();//不要忘记commit
            }
        } else {
            //to已经被添加
            // from隐藏
            if (from != null) {
                ft.hide(from);
            }
            //显示to
            if (to != null) {
                ft.show(to).commit();//不要忘记commit
            }
        }
        preFragment = to;//将要显示的fragment当然就成为了下一次切换的preFragment
    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() > preTime + 2000) {
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
            preTime = System.currentTimeMillis();
        } else {
            super.onBackPressed();//相当于finish()
            realBack();//删除所有引用
        }
    }
}
