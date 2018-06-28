package com.overseas.overseas.model;

/**
 * admin  2018/6/13
 */
public class UserBean {


    /**
     * msg : 请求成功
     * code : 200
     * datas : {"istxl":1,"phone":"1234"}
     */

    private String msg;
    private String code;
    private DatasBean datas;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DatasBean getDatas() {
        return datas;
    }

    public void setDatas(DatasBean datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        /**
         * istxl : 1
         * phone : 1234
         */

        private int istxl;
        private String phone;

        public int getIstxl() {
            return istxl;
        }

        public void setIstxl(int istxl) {
            this.istxl = istxl;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}
