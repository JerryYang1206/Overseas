package com.overseas.overseas.mine;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.FutureTarget;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.compress.Luban;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.lzy.okgo.model.Response;
import com.overseas.overseas.MyApplication;
import com.overseas.overseas.R;
import com.overseas.overseas.base.BaseActivity;
import com.overseas.overseas.base.BaseDialog;
import com.overseas.overseas.base.LoginActivity;
import com.overseas.overseas.bean.FileBean;
import com.overseas.overseas.bean.NoDataBean;
import com.overseas.overseas.bean.UserInfo;
import com.overseas.overseas.presenter.UpFilePresenter;
import com.overseas.overseas.presenter.UserPresenter;
import com.overseas.overseas.utils.QRCode;
import com.overseas.overseas.utils.SharedPreferencesUtils;
import com.overseas.overseas.utils.SoftKeyboardTool;
import com.overseas.overseas.utils.TUtils;
import com.overseas.overseas.view.CircleImageView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.zelory.compressor.Compressor;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MyDataActivity extends BaseActivity implements UserPresenter.UserCallBack, UpFilePresenter.UpFileCallBack {

    @BindView(R.id.see_large_photo)
    CircleImageView seeLargePhoto;
    @BindView(R.id.select_photo)
    ImageView ivArrow;
    @BindView(R.id.back_img)
    ImageView backimg;
    @BindView(R.id.cb_nan)
    CheckBox cbNan;
    @BindView(R.id.cb_nv)
    CheckBox cbNv;
    @BindView(R.id.layout_Erweima)
    LinearLayout layoutErweima;
    @BindView(R.id.et_name)
    EditText et_name;
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
    @BindView(R.id.ll_name)
    LinearLayout llName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    private BaseDialog dialog;
    private TimePickerView pvCustomLunar;
    private List<String> cameraList;
    private String name;
    private String pic;
    private String sex;
    private String birthday;
    private String birthday2;
    private String phone;
    private UserPresenter presenter;
    private List<LocalMedia> selectList;
    private String cutPath;
    private UpFilePresenter filePresenter;
    private Bitmap picbitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_data);
        ButterKnife.bind(this);
        presenter = new UserPresenter(this, this);
        filePresenter = new UpFilePresenter(this, this);
        cameraList = new ArrayList<>();
        cameraList.add(getString(R.string.paizhao));
        cameraList.add(getString(R.string.congxiangcexuanze));
        name = getIntent().getStringExtra("name");
        pic = getIntent().getStringExtra("pic");
        sex = getIntent().getStringExtra("sex");
        phone = getIntent().getStringExtra("phone");
        birthday = getIntent().getStringExtra("birthday");
        birthday2 = getTime4(birthday);
        Glide.with(MyApplication.getGloableContext()).load(pic).into(seeLargePhoto);
        if (sex.equals("0")) {
            cbNan.setChecked(true);
            cbNv.setChecked(false);
        } else {
            cbNan.setChecked(false);
            cbNv.setChecked(true);
        }
        et_name.setText(name);
        if (!TextUtils.isEmpty(birthday) && !birthday.equals("0")) {
            tvShengri.setText(getTime3(birthday));
        } else {
            tvShengri.setText(getString(R.string.input_select));
        }
        tvPhone.setText(phone);
        initLunarPicker();//初始化时间选择器
        initListener();
        initBitmap();
    }

    private void initBitmap() {
        /*glide将url转换成bitmap，在这先弄好了，省的弹出的时候浪费时间*/
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    FutureTarget<Bitmap> target = Glide.with(MyApplication.getGloableContext()).asBitmap().load(pic).submit();
                    final Bitmap bimap = target.get();
                    picbitmap = bimap;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @OnClick({R.id.see_large_photo, R.id.select_photo, R.id.back_img, R.id.layout_Erweima, R.id.tv_shengri, R.id.ll_man, R.id.ll_woman, R.id.ll_bing_number})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.see_large_photo:
                showCamera(Gravity.BOTTOM, R.style.Bottom_Top_aniamtion);
                break;
            case R.id.back_img:
                finish();
                break;
            case R.id.select_photo:
                showCamera(Gravity.BOTTOM, R.style.Bottom_Top_aniamtion);
                break;
            case R.id.layout_Erweima:
                showcallDialog();
                break;
            case R.id.tv_shengri:
                SoftKeyboardTool.closeKeyboard2(this);
                pvCustomLunar.show();
                break;
            case R.id.ll_man:
                cbNan.setChecked(true);
                cbNv.setChecked(false);
                sex = "0";
                break;
            case R.id.ll_woman:
                cbNan.setChecked(false);
                cbNv.setChecked(true);
                sex = "1";
                break;
            case R.id.ll_bing_number:
                //                startActivity(new Intent(this, MineBindPhoneActivity.class));
                break;
        }
    }

    private void initListener() {
        et_name.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    et_name.setCursorVisible(true);// 再次点击显示光标
                }
                return false;
            }
        });
        et_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() >= 20) {
                    TUtils.showFail(MyDataActivity.this, getString(R.string.name_max_char));
                }
                et_name.setCursorVisible(false);// 再次点击显示光标
                name = et_name.getText().toString();
            }
        });
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
        ImageView iv_code = dialog.getView(R.id.iv_code);
        String content = SharedPreferencesUtils.getInstace(this).getStringPreference("brokerId", "");
        Bitmap bitmap = QRCode.createQRCodeWithLogo(content, 700, picbitmap);
        iv_code.setImageBitmap(bitmap);
        dialog.show();
    }

    private void showCamera(int grary, int animationStyle) {
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
        PictureSelector.create(this)
                .openCamera(PictureMimeType.ofImage())// 单独拍照，也可录像或也可音频 看你传入的类型是图片or视频
                .theme(R.style.picture_default_style)// 主题样式设置 具体参考 values/styles
                .enableCrop(true)// 是否裁剪
                .compress(true)// 是否压缩
                .compressMode(PictureConfig.LUBAN_COMPRESS_MODE)//系统自带 or 鲁班压缩 PictureConfig.SYSTEM_COMPRESS_MODE or LUBAN_COMPRESS_MODE
                .freeStyleCropEnabled(true)// 裁剪框是否可拖拽
                .circleDimmedLayer(true)// 是否圆形裁剪
                .showCropFrame(false)// 是否显示裁剪矩形边框 圆形裁剪时建议设为false
                .showCropGrid(false)// 是否显示裁剪矩形网格 圆形裁剪时建议设为false
                .scaleEnabled(false)// 裁剪是否可放大缩小图片
                //                .glideOverride(160, 160)// glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
                //                .selectionMedia(list)// 是否传入已选图片
                //                .previewEggs(true)//预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中)
                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true
                    // 如果裁剪并压缩了，已取压缩路径为准，因为是先裁剪后压缩的
                    selectList = PictureSelector.obtainMultipleResult(data);
                    cutPath = selectList.get(0).getCutPath();
                    new Compressor(this)
                            .compressToFileAsFlowable(new File(cutPath))
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Consumer<File>() {
                                @Override
                                public void accept(File file) {
                                    filePresenter.upFilePicRequest(file);
                                }
                            }, new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) {
                                    throwable.printStackTrace();

                                }
                            });
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
                birthday2 = getTime2(date);
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
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        //        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    private String getTime2(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    private String getTime3(String time) {//可根据需要自行截取数据显示
        long lcc_time = Long.valueOf(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        //        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date(lcc_time));
        return format;
    }

    private String getTime4(String time) {//可根据需要自行截取数据显示
        long lcc_time = Long.valueOf(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date(lcc_time));
        return format;
    }

    @Override
    public void getUserInfo(Response<UserInfo> response) {

    }

    @Override
    public void updateUserInfo(Response<NoDataBean> response) {
        if (TextUtils.equals(response.body().getCode(), "201")) {
            startActivity(new Intent(this, LoginActivity.class));
            MyApplication.logOut();
            return;
        }
        //        Toast.makeText(this, " " + response.body().getMsg(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void finish() {
        presenter.updateUserInfo(MyApplication.getUserToken(), name, Integer.parseInt(sex), birthday2, pic);
        setResult(1, new Intent());
        super.finish();
    }

    @Override
    public void upFileRequest(Response<FileBean> response) {
        if (response != null && response.body() != null && response.body().getDatas() != null) {
            pic = response.body().getDatas();
            Glide.with(MyApplication.getGloableContext()).load(pic).into(seeLargePhoto);
            initBitmap();
        }
    }

}

