//package com.overseas.overseas.im;
//
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.text.TextUtils;
//import android.view.Gravity;
//import android.view.View;
//import android.widget.CheckBox;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import com.bumptech.glide.Glide;
//import com.example.administrator.japanhouse.R;
//import com.example.administrator.japanhouse.base.BaseActivity;
//import com.example.administrator.japanhouse.model.AgentInfoBean;
//import com.example.administrator.japanhouse.model.NoDataBean;
//import com.example.administrator.japanhouse.model.UserBean;
//import com.example.administrator.japanhouse.presenter.AppraiseManagerPresenter;
//import com.example.administrator.japanhouse.presenter.FromPhonePresenter;
//import com.example.administrator.japanhouse.utils.CacheUtils;
//import com.example.administrator.japanhouse.utils.Constants;
//import com.example.administrator.japanhouse.utils.SharedPreferencesUtils;
//import com.example.administrator.japanhouse.utils.TUtils;
//import com.example.administrator.japanhouse.view.BaseDialog;
//import com.example.administrator.japanhouse.view.CircleImageView;
//import com.example.administrator.japanhouse.view.RatingBarView;
//import com.lzy.okgo.model.Response;
//
//import java.util.List;
//
//import io.rong.imkit.DefaultExtensionModule;
//import io.rong.imkit.IExtensionModule;
//import io.rong.imkit.RongExtensionManager;
//import io.rong.imkit.RongIM;
//import io.rong.imlib.model.Message;
//
//
///**
// * Created by   admin on 2018/4/25.
// */
//
//public class RongChatActivity extends BaseActivity implements FromPhonePresenter.PhoneCallBack, AppraiseManagerPresenter.AppraiseCallBack {
//    private TextView title;
//    private ImageView back;
//    private ImageView phone;
//    private CheckBox star;
//
//    private TextView tvAppraise;
//
//    private FromPhonePresenter presenter;
//    private AppraiseManagerPresenter managerPresenter;
//
//    private String strPhone = "";
//
//    private String targetId;
//
//    private int state = 0; //0否 1是
//
//    private String avatar = "";
//
//    private String name;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_rong_chat);
//
//        title = (TextView) findViewById(R.id.activity_chat_title);
//        back = (ImageView) findViewById(R.id.activity_chat_back);
//        phone = (ImageView) findViewById(R.id.activity_chat_phone);
//        star = (CheckBox) findViewById(R.id.activity_chat_star);
//        tvAppraise = (TextView) findViewById(R.id.act_rongChat_appraise);
//
//        //会话界面 对方id
//        targetId = getIntent().getData().getQueryParameter("targetId");
//        presenter = new FromPhonePresenter(this, this);
//        presenter.getUserPhone(targetId);
//        presenter.getManagerInfo(targetId);
//
//        managerPresenter = new AppraiseManagerPresenter(this, this);
//
//        //对方 昵称
//        name = getIntent().getData().getQueryParameter("title");
//
//        String chat = SharedPreferencesUtils.getInstace(this).getStringPreference(Constants.CHAT, "");
//        if (!TextUtils.isEmpty(chat)) {
//            if (chat.equals(Constants.CHAT_DETAILS)) {
//                if (!TextUtils.isEmpty(name)) {
//                    this.title.setText(name);
//                }
//                phone.setVisibility(View.GONE);
//                star.setVisibility(View.VISIBLE);
//                tvAppraise.setVisibility(View.VISIBLE);
//            } else {
//                if (!TextUtils.isEmpty(name)) {
//                    this.title.setText(name);
//                }
//                phone.setVisibility(View.VISIBLE);
//                star.setVisibility(View.GONE);
//                tvAppraise.setVisibility(View.GONE);
//            }
//        } else {
//            if (!TextUtils.isEmpty(name)) {
//                this.title.setText(name);
//            }
//            phone.setVisibility(View.VISIBLE);
//            star.setVisibility(View.GONE);
//            tvAppraise.setVisibility(View.GONE);
//        }
//
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
//
//        phone.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (strPhone != null && !"".equals(strPhone)) {
//                    ShowCallDialog(strPhone);
//                }
//            }
//        });
//
//        star.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (state == 1) {
//                    presenter.deteleLinkman(targetId);
//                    state = 0;
//                } else {
//                    presenter.addLinkman(targetId);
//                    state = 1;
//                }
//            }
//        });
//
//        final String country = CacheUtils.get(Constants.COUNTRY);
//
//        tvAppraise.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!TextUtils.isEmpty(country) && TextUtils.equals(country, "ja")) {
//                    showJaDialog();
//                } else {
//                    showZhDialog();
//                }
//            }
//        });
//
//        RongIM.getInstance().setSendMessageListener(new RongIM.OnSendMessageListener() {
//            @Override
//            public Message onSend(Message message) {
//                /**
//                 * getTargetId   接受者id
//                 * 如果不使用的话将此方法删除
//                 */
//                return message;
//            }
//
//            @Override
//            public boolean onSent(Message message, RongIM.SentMessageErrorCode sentMessageErrorCode) {
//                return false;
//            }
//        });
//    }
//
//    private void ShowCallDialog(final String tel) {
//        BaseDialog.Builder builder = new BaseDialog.Builder(this);
//        final BaseDialog dialog = builder.setViewId(R.layout.call_layout)
//                .setPaddingdp(0, 10, 0, 10)
//                .setGravity(Gravity.CENTER)
//                .setAnimation(R.style.bottom_tab_style)
//                .setWidthHeightpx(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
//                .isOnTouchCanceled(false)
//                .builder();
//        dialog.show();
//        TextView text_sure = dialog.getView(R.id.text_sure);
//        final TextView tv_content = dialog.getView(R.id.tv_content);
//        tv_content.setText(tel);
//        TextView text_pause = dialog.getView(R.id.text_pause);
//
//        text_sure.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialog.dismiss();
//                Intent dialIntent = new Intent(Intent.ACTION_DIAL,
//                        Uri.parse("tel:" + tel));
//                startActivity(dialIntent);
//            }
//        });
//
//        text_pause.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialog.dismiss();
//            }
//        });
//        dialog.show();
//    }
//
//    private void showJaDialog() {
//        BaseDialog.Builder builder = new BaseDialog.Builder(this);
//        final BaseDialog
//                dialog = builder.setViewId(R.layout.dialog_chat_details_ja)
//                .setGravity(Gravity.CENTER)
//                .setAnimation(R.style.bottom_tab_style)
//                .setWidthHeightpx(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
//                .isOnTouchCanceled(true)
//                .builder();
//        CheckBox rbReply = dialog.getView(R.id.dialog_chat_huanman);
//        CheckBox rbNoMajor = dialog.getView(R.id.dialog_chat_zuanye);
//        CheckBox rbColdness = dialog.getView(R.id.dialog_chat_lengdan);
//        CheckBox rbMsgPartial = dialog.getView(R.id.dialog_chat_buquan);
//
//        TextView tvName = dialog.getView(R.id.dialog_chat_name);
//        tvName.setText("＜" + name + "＞のサービスが評価してください");
//
//        CircleImageView circleImageView = dialog.getView(R.id.dialog_chat_avatar);
//        Glide.with(this)
//                .load(avatar)
//                .into(circleImageView);
//
//        final EditText editText = dialog.getView(R.id.dialog_chat_content);
//
//        final RatingBarView ratingBarView = dialog.getView(R.id.dialog_chat_tatingbar);
//        ratingBarView.setRatingCount(5);
//        ratingBarView.setSelectedCount(0);
//        ratingBarView.setSelectedIconResId(R.drawable.start_check);
//        ratingBarView.setNormalIconResId(R.drawable.start_nocheck);
//        ratingBarView.setClickable(true);
//        ratingBarView.setChildPadding(0);
//        ratingBarView.setChildMargin(12);
//        ratingBarView.setChildDimension(28);
//
//        dialog.getView(R.id.iv_cancel).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//
//        dialog.getView(R.id.tv_submit).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!TextUtils.isEmpty(editText.getText().toString())) {
//                    managerPresenter.appraiseManagerRequest(targetId, editText.getText().toString(), ratingBarView.getSelectedCount());
//                    dialog.dismiss();
//                } else {
//                    TUtils.showFail(RongChatActivity.this, getString(R.string.input_qppraise_content));
//                }
//            }
//        });
//
//        dialog.show();
//
//    }
//
//    private void showZhDialog() {
//        BaseDialog.Builder builder = new BaseDialog.Builder(this);
//        final BaseDialog
//                dialog = builder.setViewId(R.layout.dialog_chat_details_zh)
//                .setGravity(Gravity.CENTER)
//                .setAnimation(R.style.bottom_tab_style)
//                .setWidthHeightpx(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
//                .isOnTouchCanceled(true)
//                .builder();
//        CheckBox rbReply = dialog.getView(R.id.dialog_chat_huanman);
//        CheckBox rbNoMajor = dialog.getView(R.id.dialog_chat_zuanye);
//        CheckBox rbColdness = dialog.getView(R.id.dialog_chat_lengdan);
//        CheckBox rbMsgPartial = dialog.getView(R.id.dialog_chat_buquan);
//
//        TextView tvName = dialog.getView(R.id.dialog_chat_name);
//        tvName.setText("请对" + name + "对微聊服务作出评价");
//
//        CircleImageView circleImageView = dialog.getView(R.id.dialog_chat_avatar);
//        Glide.with(this)
//                .load(avatar)
//                .into(circleImageView);
//
//        final EditText editText = dialog.getView(R.id.dialog_chat_content);
//
//        final RatingBarView ratingBarView = dialog.getView(R.id.dialog_chat_tatingbar);
//        ratingBarView.setRatingCount(5);
//        ratingBarView.setSelectedCount(0);
//        ratingBarView.setSelectedIconResId(R.drawable.start_check);
//        ratingBarView.setNormalIconResId(R.drawable.start_nocheck);
//        ratingBarView.setClickable(true);
//        ratingBarView.setChildPadding(0);
//        ratingBarView.setChildMargin(12);
//        ratingBarView.setChildDimension(28);
//
//        dialog.getView(R.id.iv_cancel).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//        dialog.getView(R.id.tv_submit).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!TextUtils.isEmpty(editText.getText().toString())) {
//                    managerPresenter.appraiseManagerRequest(targetId, editText.getText().toString(), ratingBarView.getSelectedCount());
//                    dialog.dismiss();
//                } else {
//                    TUtils.showFail(RongChatActivity.this, getString(R.string.input_qppraise_content));
//                }
//            }
//        });
//        dialog.show();
//    }
//
//    @Override
//    public void finish() {
//        SharedPreferencesUtils.getInstace(this).setStringPreference(Constants.CHAT, "abc");
//        List<IExtensionModule> moduleList = RongExtensionManager.getInstance().getExtensionModules();
//        IExtensionModule defaultModule = null;
//        if (moduleList != null) {
//            for (IExtensionModule module : moduleList) {
//                if (module instanceof DefaultExtensionModule) {
//                    defaultModule = module;
//                    break;
//                }
//            }
//            if (defaultModule != null) {
//                RongExtensionManager.getInstance().unregisterExtensionModule(defaultModule);
//                RongExtensionManager.getInstance().registerExtensionModule(new TalkExtensionModule());
//            }
//        }
//        super.finish();
//    }
//
//    @Override
//    public void getUserPhone(Response<UserBean> response) {
//        if (response != null && response.body() != null && response.body().getDatas() != null) {
//
//            strPhone = response.body().getDatas().getPhone();
//            state = response.body().getDatas().getIstxl();
//
//            if (response.body().getDatas().getIstxl() == 1) {
//                star.setChecked(true);
//            } else {
//                star.setChecked(false);
//            }
//        }
//    }
//
//    @Override
//    public void getManagerInfo(Response<AgentInfoBean> response) {
//        if (response != null && response.body() != null && response.body().getDatas() != null) {
//            if (response.body().getDatas().getBrokerinfo() != null) {
//                avatar = response.body().getDatas().getBrokerinfo().getPic();
//            }
//        }
//    }
//
//    @Override
//    public void appraiseManagerRequest(Response<NoDataBean> response) {
//        if (response != null && response.body() != null && response.body().getCode() != null) {
//            if (response.body().getCode().equals("200")) {
//                TUtils.showFail(this, getString(R.string.appraise_manager_success));
//            } else {
//                TUtils.showFail(this, getString(R.string.appraise_manager_fail));
//            }
//        }
//    }
//}
