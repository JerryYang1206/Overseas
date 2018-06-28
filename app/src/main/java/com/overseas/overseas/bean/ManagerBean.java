package com.overseas.overseas.bean;

/**
 * Created by Administrator on 2018/6/24.
 */

public class ManagerBean {

    /**
     * msg : 请求成功
     * code : 200
     * datas : {"brokerinfo":{"id":2,"brokerName":"我是经纪人","phone":"12345","password":"1232132","telePhone":"123132","shop":"所属门店","turnover":100,"inYears":3,"period":1,"counts":60,"pic":"https://hwdc-huabei.oss-cn-beijing.aliyuncs.com/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20180621161322.jpg","nickname":"昵称","sex":"0","wechatId":"123456","caeateTime":1525781849000,"updateTime":1525781851000,"isDeleted":0,"status":"","tagsCn":"全城看房","tagsJpn":"全城看房","intimacyCn":"望京","intimacyJpn":"望京","cityId":2,"areaManage":1,"rongCloudToken":"PibTsgmH5czG758Ty9lb0ZtacAbWKJAKs7xt/96ZapHzee8Uw/BiEqnRkwLcLq+r7lOzoKtIr9BIFCh7S2Ktn0NJOhFvtdh9","token":null,"lastTime":null,"birthday":null,"avgStar":0,"areaNameCn":"","areaNameJpn":""},"fwrs":0,"daynum":"46天"}
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
         * brokerinfo : {"id":2,"brokerName":"我是经纪人","phone":"12345","password":"1232132","telePhone":"123132","shop":"所属门店","turnover":100,"inYears":3,"period":1,"counts":60,"pic":"https://hwdc-huabei.oss-cn-beijing.aliyuncs.com/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20180621161322.jpg","nickname":"昵称","sex":"0","wechatId":"123456","caeateTime":1525781849000,"updateTime":1525781851000,"isDeleted":0,"status":"","tagsCn":"全城看房","tagsJpn":"全城看房","intimacyCn":"望京","intimacyJpn":"望京","cityId":2,"areaManage":1,"rongCloudToken":"PibTsgmH5czG758Ty9lb0ZtacAbWKJAKs7xt/96ZapHzee8Uw/BiEqnRkwLcLq+r7lOzoKtIr9BIFCh7S2Ktn0NJOhFvtdh9","token":null,"lastTime":null,"birthday":null,"avgStar":0,"areaNameCn":"","areaNameJpn":""}
         * fwrs : 0
         * daynum : 46天
         */

        private BrokerinfoBean brokerinfo;
        private int fwrs;
        private String daynum;

        public BrokerinfoBean getBrokerinfo() {
            return brokerinfo;
        }

        public void setBrokerinfo(BrokerinfoBean brokerinfo) {
            this.brokerinfo = brokerinfo;
        }

        public int getFwrs() {
            return fwrs;
        }

        public void setFwrs(int fwrs) {
            this.fwrs = fwrs;
        }

        public String getDaynum() {
            return daynum;
        }

        public void setDaynum(String daynum) {
            this.daynum = daynum;
        }

        public static class BrokerinfoBean {
            /**
             * id : 2
             * brokerName : 我是经纪人
             * phone : 12345
             * password : 1232132
             * telePhone : 123132
             * shop : 所属门店
             * turnover : 100
             * inYears : 3
             * period : 1
             * counts : 60
             * pic : https://hwdc-huabei.oss-cn-beijing.aliyuncs.com/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20180621161322.jpg
             * nickname : 昵称
             * sex : 0
             * wechatId : 123456
             * caeateTime : 1525781849000
             * updateTime : 1525781851000
             * isDeleted : 0
             * status :
             * tagsCn : 全城看房
             * tagsJpn : 全城看房
             * intimacyCn : 望京
             * intimacyJpn : 望京
             * cityId : 2
             * areaManage : 1
             * rongCloudToken : PibTsgmH5czG758Ty9lb0ZtacAbWKJAKs7xt/96ZapHzee8Uw/BiEqnRkwLcLq+r7lOzoKtIr9BIFCh7S2Ktn0NJOhFvtdh9
             * token : null
             * lastTime : null
             * birthday : null
             * avgStar : 0
             * areaNameCn :
             * areaNameJpn :
             */

            private int id;
            private String brokerName;
            private String phone;
            private String password;
            private String telePhone;
            private String shop;
            private int turnover;
            private int inYears;
            private int period;
            private int counts;
            private String pic;
            private String nickname;
            private String sex;
            private String wechatId;
            private long caeateTime;
            private long updateTime;
            private int isDeleted;
            private String status;
            private String tagsCn;
            private String tagsJpn;
            private String intimacyCn;
            private String intimacyJpn;
            private int cityId;
            private int areaManage;
            private String rongCloudToken;
            private Object token;
            private Object lastTime;
            private Object birthday;
            private int avgStar;
            private String areaNameCn;
            private String areaNameJpn;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getBrokerName() {
                return brokerName;
            }

            public void setBrokerName(String brokerName) {
                this.brokerName = brokerName;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getTelePhone() {
                return telePhone;
            }

            public void setTelePhone(String telePhone) {
                this.telePhone = telePhone;
            }

            public String getShop() {
                return shop;
            }

            public void setShop(String shop) {
                this.shop = shop;
            }

            public int getTurnover() {
                return turnover;
            }

            public void setTurnover(int turnover) {
                this.turnover = turnover;
            }

            public int getInYears() {
                return inYears;
            }

            public void setInYears(int inYears) {
                this.inYears = inYears;
            }

            public int getPeriod() {
                return period;
            }

            public void setPeriod(int period) {
                this.period = period;
            }

            public int getCounts() {
                return counts;
            }

            public void setCounts(int counts) {
                this.counts = counts;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getWechatId() {
                return wechatId;
            }

            public void setWechatId(String wechatId) {
                this.wechatId = wechatId;
            }

            public long getCaeateTime() {
                return caeateTime;
            }

            public void setCaeateTime(long caeateTime) {
                this.caeateTime = caeateTime;
            }

            public long getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(long updateTime) {
                this.updateTime = updateTime;
            }

            public int getIsDeleted() {
                return isDeleted;
            }

            public void setIsDeleted(int isDeleted) {
                this.isDeleted = isDeleted;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getTagsCn() {
                return tagsCn;
            }

            public void setTagsCn(String tagsCn) {
                this.tagsCn = tagsCn;
            }

            public String getTagsJpn() {
                return tagsJpn;
            }

            public void setTagsJpn(String tagsJpn) {
                this.tagsJpn = tagsJpn;
            }

            public String getIntimacyCn() {
                return intimacyCn;
            }

            public void setIntimacyCn(String intimacyCn) {
                this.intimacyCn = intimacyCn;
            }

            public String getIntimacyJpn() {
                return intimacyJpn;
            }

            public void setIntimacyJpn(String intimacyJpn) {
                this.intimacyJpn = intimacyJpn;
            }

            public int getCityId() {
                return cityId;
            }

            public void setCityId(int cityId) {
                this.cityId = cityId;
            }

            public int getAreaManage() {
                return areaManage;
            }

            public void setAreaManage(int areaManage) {
                this.areaManage = areaManage;
            }

            public String getRongCloudToken() {
                return rongCloudToken;
            }

            public void setRongCloudToken(String rongCloudToken) {
                this.rongCloudToken = rongCloudToken;
            }

            public Object getToken() {
                return token;
            }

            public void setToken(Object token) {
                this.token = token;
            }

            public Object getLastTime() {
                return lastTime;
            }

            public void setLastTime(Object lastTime) {
                this.lastTime = lastTime;
            }

            public Object getBirthday() {
                return birthday;
            }

            public void setBirthday(Object birthday) {
                this.birthday = birthday;
            }

            public int getAvgStar() {
                return avgStar;
            }

            public void setAvgStar(int avgStar) {
                this.avgStar = avgStar;
            }

            public String getAreaNameCn() {
                return areaNameCn;
            }

            public void setAreaNameCn(String areaNameCn) {
                this.areaNameCn = areaNameCn;
            }

            public String getAreaNameJpn() {
                return areaNameJpn;
            }

            public void setAreaNameJpn(String areaNameJpn) {
                this.areaNameJpn = areaNameJpn;
            }
        }
    }
}
