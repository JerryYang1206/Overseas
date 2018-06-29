package com.overseas.overseas.im;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.lzy.okgo.model.Response;
import com.overseas.overseas.R;
import com.overseas.overseas.base.BaseActivity;
import com.overseas.overseas.model.UserBean;
import com.overseas.overseas.presenter.FromPhonePresenter;
import io.rong.imkit.RongIM;
import io.rong.imlib.model.Message;


/**
 * Created by   admin on 2018/4/25.
 */

public class RongChatActivity extends BaseActivity implements FromPhonePresenter.PhoneCallBack{
    private TextView title;
    private ImageView back;
    private CheckBox star;

    private FromPhonePresenter presenter;

    private String targetId;

    private int state = 0; //0否 1是

    private String name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rong_chat);

        title = (TextView) findViewById(R.id.activity_chat_title);
        back = (ImageView) findViewById(R.id.activity_chat_back);
        star = (CheckBox) findViewById(R.id.activity_chat_star);

        //会话界面 对方id
        targetId = getIntent().getData().getQueryParameter("targetId");

        presenter = new FromPhonePresenter(this, this);
        presenter.getUserPhone(targetId);

        //对方 昵称
        name = getIntent().getData().getQueryParameter("title");

        if (name != null) {
            title.setText(name);
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (state == 1) {
                    presenter.deteleLinkman(targetId);
                    state = 0;
                } else {
                    presenter.addLinkman(targetId);
                    state = 1;
                }
            }
        });

        RongIM.getInstance().setSendMessageListener(new RongIM.OnSendMessageListener() {
            @Override
            public Message onSend(Message message) {
                /**
                 * getTargetId   接受者id
                 * 如果不使用的话将此方法删除
                 */
                presenter.recordReply(targetId);
                return message;
            }

            @Override
            public boolean onSent(Message message, RongIM.SentMessageErrorCode sentMessageErrorCode) {
                return false;
            }
        });
    }

    @Override
    public void getUserPhone(Response<UserBean> response) {
        if (response != null && response.body() != null && response.body().getDatas() != null) {

            state = response.body().getDatas().getIstxl();

            if (response.body().getDatas().getIstxl() == 1) {
                star.setChecked(true);
            } else {
                star.setChecked(false);
            }
        }
    }
}
