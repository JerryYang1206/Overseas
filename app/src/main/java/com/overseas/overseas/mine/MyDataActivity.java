package com.overseas.overseas.mine;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bumptech.glide.Glide;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.compress.Luban;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.overseas.overseas.R;
import com.overseas.overseas.base.BaseActivity;
import com.overseas.overseas.base.BaseDialog;
import com.overseas.overseas.utils.MyUtils;
import com.overseas.overseas.view.BaseSelectPopupWindow;
import com.overseas.overseas.view.CircleImageView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyDataActivity extends BaseActivity {

    @BindView(R.id.see_large_photo)
    CircleImageView seeLargePhoto;
    @BindView(R.id.select_photo)
    ImageView selectPhoto;
    @BindView(R.id.back_img)
    ImageView backimg;
    @BindView(R.id.cb_nan)
    CheckBox cbNan;
    @BindView(R.id.cb_nv)
    CheckBox cbNv;
    @BindView(R.id.layout_Erweima)
    LinearLayout layoutErweima;
    @BindView(R.id.tv_name)
    EditText tvName;
    @BindView(R.id.tv_shengri)
    TextView tvShengri;
    @BindView(R.id.ll_man)
    LinearLayout llMan;
    @BindView(R.id.ll_woman)
    LinearLayout llWoman;
    @BindView(R.id.activity_my_data)
    LinearLayout activityMyData;
    @BindView(R.id.ll_bing_number)
    LinearLayout llBingNumber;
    private BaseDialog dialog;
    private BaseSelectPopupWindow popWiw;// 昵称 编辑框
    private TimePickerView pvCustomLunar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_data);
        ButterKnife.bind(this);
        initLunarPicker();//初始化时间选择器
    }

    @OnClick({R.id.see_large_photo, R.id.select_photo, R.id.back_img, R.id.layout_Erweima,R.id. tv_name, R.id.tv_shengri, R.id.ll_man, R.id.ll_woman,R.id.ll_bing_number})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.see_large_photo:
                Toast.makeText(this, "查看大头像", Toast.LENGTH_SHORT).show();
                break;
            case R.id.back_img:
                finish();
                break;
            case R.id.select_photo:
                showDialog(Gravity.BOTTOM, R.style.Bottom_Top_aniamtion);
                break;
            case R.id.layout_Erweima:
                showcallDialog();
                break;
            case R.id. tv_name:
//                initListener();
                showNickName();
                break;
            case R.id.tv_shengri:
                pvCustomLunar.show();
                break;
            case R.id.ll_man:
                cbNan.setChecked(true);
                cbNv.setChecked(false);
                break;
            case R.id.ll_woman:
                cbNan.setChecked(false);
                cbNv.setChecked(true);
                break;
            case R.id.ll_bing_number:
                startActivity(new Intent(this, MineBindPhoneActivity.class));
                break;
        }
    }
    private void initListener() {
        tvName.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    tvName.setCursorVisible(true);// 再次点击显示光标
                }
                return false;
            }
        });
        tvName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                tvName.setCursorVisible(false);// 再次点击显示光标
            }
        });
    }
    //修改昵称
    private void showNickName() {
        if (popWiw == null) {
            popWiw = new BaseSelectPopupWindow(this, R.layout.edit_name_data);
            // popWiw.setOpenKeyboard(true);
            popWiw.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);

            popWiw.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
            popWiw.setShowTitle(false);
        }
        popWiw.setFocusable(true);
        InputMethodManager im = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        im.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);

        final ImageView send = (ImageView) popWiw.getContentView().findViewById(R.id.query_iv);
        final EditText edt = (EditText) popWiw.getContentView().findViewById(R.id.edt_content);
        final ImageView close = (ImageView) popWiw.getContentView().findViewById(R.id.cancle_iv);

        edt.setInputType(EditorInfo.TYPE_CLASS_TEXT);
        //        edt.setImeOptions(EditorInfo.IME_ACTION_SEND);
        edt.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                if (TextUtils.isEmpty(edt.getText())) {
                    send.setEnabled(false);
                } else {
                    send.setEnabled(true);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });

        send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(edt.getText().toString().trim())) {
                    // 昵称
                    String content = edt.getText().toString().trim();
                    tvName.setText(content);
                    //                    requestEditInfo(NAME, content);
                    popWiw.dismiss();
                }
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popWiw.dismiss();
            }
        });

        popWiw.showAtLocation(tvName, Gravity.BOTTOM
                | Gravity.CENTER_HORIZONTAL, 0, 0);
    }


    private void showcallDialog() {
        BaseDialog.Builder builder = new BaseDialog.Builder(MyDataActivity.this);
        //设置dialogpadding
        //设置显示位置
        //设置动画
        //设置dialog的宽高
        //设置触摸dialog外围是否关闭
        //设置监听事件
        final BaseDialog
                dialog = builder.setViewId(R.layout.item_erweima)
                //设置dialogpadding
                .setPaddingdp(40, 0, 40, 0)
                //设置显示位置
                .setGravity(Gravity.CENTER)
                //设置动画
                .setAnimation(R.style.bottom_tab_style)
                //设置dialog的宽高
                .setWidthHeightpx(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                //设置触摸dialog外围是否关闭
                .isOnTouchCanceled(true)
                //设置监听事件
                .builder();
        dialog.show();

    }

    private void showDialog(int grary, int animationStyle) {
        BaseDialog.Builder builder = new BaseDialog.Builder(this);
        //设置触摸dialog外围是否关闭
        //设置监听事件
        dialog = builder.setViewId(R.layout.dialog_selectphoto)
                //设置dialogpadding
                .setPaddingdp(10, 0, 10, 0)
                //设置显示位置
                .setGravity(grary)
                //设置动画
                .setAnimation(animationStyle)
                //设置dialog的宽高
                .setWidthHeightpx(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                //设置触摸dialog外围是否关闭
                .isOnTouchCanceled(true)
                //设置监听事件
                .builder();
        dialog.show();
        TextView tv_pai = dialog.getView(R.id.dialog_tv_pai);
        TextView tv_tuku = dialog.getView(R.id.dialog_tv_tuku);
        TextView tv_dissmiss = dialog.getView(R.id.dialog_tv_dismiss);
        tv_pai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestCamera();
                //关闭dialog
                dialog.close();
            }
        });
        tv_tuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPhoto();
                //关闭dialog
                dialog.close();
            }
        });
        tv_dissmiss.setOnClickListener(new View
                .OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    private void requestPhoto() {
        // 进入相册 以下是例子：不需要的api可以不写
        PictureSelector.create(this)
                .openGallery(PictureMimeType.ofImage())// 全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                .theme(R.style.picture_default_style)// 主题样式设置 具体参考 values/styles   用法：R.style.picture.white.style
                .maxSelectNum(1)// 最大图片选择数量
                .minSelectNum(1)// 最小选择数量
                .imageSpanCount(4)// 每行显示个数
                .selectionMode(PictureConfig.SINGLE)// 多选 or 单选 PictureConfig.SINGLE
                .previewImage(true)// 是否可预览图片
                .previewVideo(false)// 是否可预览视频
                .enablePreviewAudio(false) // 是否可播放音频
                .compressGrade(Luban.THIRD_GEAR)// luban压缩档次，默认3档 Luban.FIRST_GEAR、Luban.CUSTOM_GEAR
                .isCamera(true)// 是否显示拍照按钮
                .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                //.setOutputCameraPath("/CustomPath")// 自定义拍照保存路径
                .enableCrop(true)// 是否裁剪
                .compress(true)// 是否压缩
                .compressMode(PictureConfig.SYSTEM_COMPRESS_MODE)//系统自带 or 鲁班压缩 PictureConfig.SYSTEM_COMPRESS_MODE or LUBAN_COMPRESS_MODE
                //.sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
                .glideOverride(200, 200)// glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
                //                .withAspectRatio(aspect_ratio_x, aspect_ratio_y)// 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                .hideBottomControls(true)// 是否显示uCrop工具栏，默认不显示
                .isGif(false)// 是否显示gif图片
                .freeStyleCropEnabled(true)// 裁剪框是否可拖拽
                .circleDimmedLayer(true)// 是否圆形裁剪
                .showCropFrame(false)// 是否显示裁剪矩形边框 圆形裁剪时建议设为false
                .showCropGrid(false)// 是否显示裁剪矩形网格 圆形裁剪时建议设为false
                .openClickSound(false)// 是否开启点击声音
                //                .selectionMedia(list)// 是否传入已选图片
                //                        .videoMaxSecond(15)
                //                        .videoMinSecond(10)
                //.previewEggs(false)// 预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中)
                //.cropCompressQuality(90)// 裁剪压缩质量 默认100
                //.compressMaxKB()//压缩最大值kb compressGrade()为Luban.CUSTOM_GEAR有效
                //.compressWH() // 压缩宽高比 compressGrade()为Luban.CUSTOM_GEAR有效
                //.cropWH()// 裁剪宽高比，设置如果大于图片本身宽高则无效
                //.rotateEnabled() // 裁剪是否可旋转图片
                .scaleEnabled(false)// 裁剪是否可放大缩小图片
                //.videoQuality()// 视频录制质量 0 or 1
                //.videoSecond()//显示多少秒以内的视频or音频也可适用
                //.recordVideoSecond()//录制视频秒数 默认60s
                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
    }


    private void requestCamera() {
        PictureSelector.create(MyDataActivity.this)
                .openCamera(PictureMimeType.ofImage())// 单独拍照，也可录像或也可音频 看你传入的类型是图片or视频
                .theme(R.style.picture_default_style)// 主题样式设置 具体参考 values/styles
                .glideOverride(160, 160)// glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
//                .selectionMedia(list)// 是否传入已选图片
                .previewEggs(true)//预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中)
                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    List<LocalMedia> localMedias = PictureSelector.obtainMultipleResult(data);
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true
                    // 如果裁剪并压缩了，已取压缩路径为准，因为是先裁剪后压缩的
                    String compressPath = localMedias.get(0).getPath();
                    MyUtils.syso("照片地址是：" + compressPath);
//                Toast.makeText(this, "照片地址是：" + compressPath, Toast.LENGTH_SHORT).show();
//        SpUtils.putString(this, "userhead", compressPath);
                    Glide.with(this).load(compressPath).into(seeLargePhoto);
//                    Bitmap bitmap = BitmapFactory.decodeFile(compressPath);
//
//                    OkGo.post(MyContants.BASEURL+"User/update/")
//                            .tag(this)
//                            .params("userid",userid)
//                            .execute(new StringCallback() {
//                                @Override
//                                public void onSuccess(String s, Call call, Response response) {
//                                }
//
//                                @Override
//                                public void onError(Call call, Response response, Exception e) {
//                                    Toast.makeText(MyDaTaActivity.this, "请检查网络或重试", Toast.LENGTH_SHORT).show();
//                                    Log.e("请求失败", "失败原因：" + response);
//                                }
//                            });
                    break;
            }
        }
    }

    /**
     * 时间选择器
     */
    private void initLunarPicker() {
        Calendar selectedDate = Calendar.getInstance();//系统当前时间
        Calendar startDate = Calendar.getInstance();
        startDate.set(1949, 0, 1);
        Calendar endDate = Calendar.getInstance();
        endDate.set(2030, 11, 31);
        //时间选择器 ，自定义布局
        pvCustomLunar = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                /*Date nowDate = TimeUtils.getNowDate();
                if (date.getTime() > nowDate.getTime()) {
                    TUtils.showShort(getApplicationContext(), "只能选择当前日期之前的日期");
                    return;
                }*/
                tvShengri.setText(getTime(date));
                //                requestEditInfo(BIRTHDAY, getTime(date));
            }
        })
                .setDate(selectedDate)
                .setRangDate(startDate, endDate)
                .setLayoutRes(R.layout.pickerview_date_layout, new CustomListener() {

                    @Override
                    public void customLayout(final View v) {
                        final TextView tvSubmit = (TextView) v.findViewById(R.id.tv_finish);
                        final TextView tvCancle = (TextView) v.findViewById(R.id.tv_cancle);
                        tvSubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvCustomLunar.returnData();
                                pvCustomLunar.dismiss();
                            }
                        });
                        tvCancle.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                pvCustomLunar.dismiss();
                            }
                        });
                    }
                })
                .setContentSize(16)
                .setLineSpacingMultiplier(1.6f)
                .isCyclic(true)//是否循环滚动
                .setType(new boolean[]{true, true, true, false, false, false})
                .isCenterLabel(true) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setDividerColor(getResources().getColor(R.color.gray))
                .setTextColorOut(getResources().getColor(R.color.gray))
                .setBgColor(getResources().getColor(R.color.white))
                .setLabel("", "", "", "", "", "")//默认设置为年月日时分秒
                .isCenterLabel(true)
                .setTextColorCenter(getResources().getColor(R.color.text_black)) //设置选中项文字颜色
                .build();
    }

    private String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
}

