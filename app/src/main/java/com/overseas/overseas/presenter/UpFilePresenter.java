package com.overseas.overseas.presenter;

import android.app.Activity;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.overseas.overseas.bean.FileBean;
import com.overseas.overseas.callback.DialogCallback;
import com.overseas.overseas.utils.MyUrls;

import java.io.File;
import java.util.List;

/**
 * admin  2018/6/22
 */
public class UpFilePresenter {
    private Activity activity;
    private UpFileCallBack callBack;

    public UpFilePresenter(Activity activity, UpFileCallBack callBack) {
        this.activity = activity;
        this.callBack = callBack;
    }

    /**
     * oss
     * @param file
     */
    public void upFileRequest(List<File> file) {
        OkGo.<FileBean>post(MyUrls.BASEURL + "/app/oss/upload")
                .tag(this)
                .isMultipart(true)
                .addFileParams("file", file)
                .execute(new DialogCallback<FileBean>(activity, FileBean.class) {
                    @Override
                    public void onSuccess(Response<FileBean> response) {
                        callBack.upFileRequest(response);
                    }
                });
    }

    /**
     * oss
     * @param file
     */
    public void upFilePicRequest(File file) {
        OkGo.<FileBean>post(MyUrls.BASEURL + "/app/oss/upload")
                .tag(this)
                .isMultipart(true)
                .params("file", file)
                .execute(new DialogCallback<FileBean>(activity, FileBean.class) {
                    @Override
                    public void onSuccess(Response<FileBean> response) {
                        callBack.upFileRequest(response);
                    }
                });
    }

    public interface UpFileCallBack {
        void upFileRequest(Response<FileBean> response);
    }
}
