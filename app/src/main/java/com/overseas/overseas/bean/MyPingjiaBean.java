package com.overseas.overseas.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/6/27.
 */

public class MyPingjiaBean {

    /**
     * msg : 请求成功
     * code : 200
     * datas : [{"picUrl":"https://hwdc-huabei.oss-cn-beijing.aliyuncs.com/å¾®ä¿¡å\u009b¾ç\u0089\u0087_20180621161322.jpg","star":3.6,"createTime":1527068057000,"userName":"FCL用户","content":"asdads"},{"picUrl":"http://hwdc.oss-ap-northeast-1.aliyuncs.com/å¾®ä¿¡å\u009b¾ç\u0089\u0087_20180621115832.jpg","star":5,"createTime":1529480015000,"userName":"哈哈哈","content":"sadasdassd"},{"picUrl":"http://hwdc.oss-ap-northeast-1.aliyuncs.com/å¾®ä¿¡å\u009b¾ç\u0089\u0087_20180621115832.jpg","star":2,"createTime":1529480302000,"userName":"哈哈哈","content":"sadasdassd"}]
     */
    private String msg;
    private String code;
    private List<DatasEntity> datas;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDatas(List<DatasEntity> datas) {
        this.datas = datas;
    }

    public String getMsg() {
        return msg;
    }

    public String getCode() {
        return code;
    }

    public List<DatasEntity> getDatas() {
        return datas;
    }

    public static class DatasEntity {
        /**
         * picUrl : https://hwdc-huabei.oss-cn-beijing.aliyuncs.com/å¾®ä¿¡å¾ç_20180621161322.jpg
         * star : 3.6
         * createTime : 1527068057000
         * userName : FCL用户
         * content : asdads
         */
        private String picUrl;
        private double star;
        private long createTime;
        private String userName;
        private String content;

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public void setStar(double star) {
            this.star = star;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public double getStar() {
            return star;
        }

        public long getCreateTime() {
            return createTime;
        }

        public String getUserName() {
            return userName;
        }

        public String getContent() {
            return content;
        }
    }
}
