package com.overseas.overseas.bean;

/**
 * Created by Administrator on 2018/6/28.
 */
public class UserInfo {


    /**
     * msg : 请求成功
     * code : 200
     * datas : {"ljPrice":1000000,"pjcjNum":1,"dayNum":0,"lscjNum":1,"broker":{"lastTime":1530172238000,"birthday":1530181534000,"shop":"","counts":0,"areaNameCn":"","inYears":0,"caeateTime":1530170330000,"pic":"http://www.rongcloud.cn/images/logo.png","cityId":0,"rongCloudToken":"23ZQ46uS0xgJvTs8W7I1w27tnvnoFRHtvRSk65MeRaWf2YegecO5asDRjexQGtq7Oo8pKJ1C7a62d4d5kWyr9flrQRYILiVo","telePhone":"","password":"123456a","isDeleted":0,"intimacyJpn":"","nickname":"","areaNameJpn":"","id":20,"turnover":0,"tagsCn":"","areaManage":0,"period":0,"brokerId":0,"sex":"1","updateTime":1530172238000,"intimacyCn":"","token":"e531ea2898c5b87da3021f855ec4991b","avgStar":0,"phone":"15811337458","tagsJpn":"","wechatId":"","brokerName":"FCL经纪人","status":""}}
     */
    private String msg;
    private String code;
    private DatasEntity datas;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDatas(DatasEntity datas) {
        this.datas = datas;
    }

    public String getMsg() {
        return msg;
    }

    public String getCode() {
        return code;
    }

    public DatasEntity getDatas() {
        return datas;
    }

    public static class DatasEntity {
        /**
         * ljPrice : 1000000
         * pjcjNum : 1
         * dayNum : 0
         * lscjNum : 1
         * broker : {"lastTime":1530172238000,"birthday":1530181534000,"shop":"","counts":0,"areaNameCn":"","inYears":0,"caeateTime":1530170330000,"pic":"http://www.rongcloud.cn/images/logo.png","cityId":0,"rongCloudToken":"23ZQ46uS0xgJvTs8W7I1w27tnvnoFRHtvRSk65MeRaWf2YegecO5asDRjexQGtq7Oo8pKJ1C7a62d4d5kWyr9flrQRYILiVo","telePhone":"","password":"123456a","isDeleted":0,"intimacyJpn":"","nickname":"","areaNameJpn":"","id":20,"turnover":0,"tagsCn":"","areaManage":0,"period":0,"brokerId":0,"sex":"1","updateTime":1530172238000,"intimacyCn":"","token":"e531ea2898c5b87da3021f855ec4991b","avgStar":0,"phone":"15811337458","tagsJpn":"","wechatId":"","brokerName":"FCL经纪人","status":""}
         */
        private int ljPrice;
        private int pjcjNum;
        private int dayNum;
        private int lscjNum;
        private BrokerEntity broker;

        public void setLjPrice(int ljPrice) {
            this.ljPrice = ljPrice;
        }

        public void setPjcjNum(int pjcjNum) {
            this.pjcjNum = pjcjNum;
        }

        public void setDayNum(int dayNum) {
            this.dayNum = dayNum;
        }

        public void setLscjNum(int lscjNum) {
            this.lscjNum = lscjNum;
        }

        public void setBroker(BrokerEntity broker) {
            this.broker = broker;
        }

        public int getLjPrice() {
            return ljPrice;
        }

        public int getPjcjNum() {
            return pjcjNum;
        }

        public int getDayNum() {
            return dayNum;
        }

        public int getLscjNum() {
            return lscjNum;
        }

        public BrokerEntity getBroker() {
            return broker;
        }

        public static class BrokerEntity {
            /**
             * lastTime : 1530172238000
             * birthday : 1530181534000
             * shop :
             * counts : 0
             * areaNameCn :
             * inYears : 0
             * caeateTime : 1530170330000
             * pic : http://www.rongcloud.cn/images/logo.png
             * cityId : 0
             * rongCloudToken : 23ZQ46uS0xgJvTs8W7I1w27tnvnoFRHtvRSk65MeRaWf2YegecO5asDRjexQGtq7Oo8pKJ1C7a62d4d5kWyr9flrQRYILiVo
             * telePhone :
             * password : 123456a
             * isDeleted : 0
             * intimacyJpn :
             * nickname :
             * areaNameJpn :
             * id : 20
             * turnover : 0
             * tagsCn :
             * areaManage : 0
             * period : 0
             * brokerId : 0
             * sex : 1
             * updateTime : 1530172238000
             * intimacyCn :
             * token : e531ea2898c5b87da3021f855ec4991b
             * avgStar : 0
             * phone : 15811337458
             * tagsJpn :
             * wechatId :
             * brokerName : FCL经纪人
             * status :
             */
            private long lastTime;
            private long birthday;
            private String shop;
            private int counts;
            private String areaNameCn;
            private int inYears;
            private long caeateTime;
            private String pic;
            private int cityId;
            private String rongCloudToken;
            private String telePhone;
            private String password;
            private int isDeleted;
            private String intimacyJpn;
            private String nickname;
            private String areaNameJpn;
            private int id;
            private int turnover;
            private String tagsCn;
            private int areaManage;
            private int period;
            private int brokerId;
            private String sex;
            private long updateTime;
            private String intimacyCn;
            private String token;
            private int avgStar;
            private String phone;
            private String tagsJpn;
            private String wechatId;
            private String brokerName;
            private String status;

            public void setLastTime(long lastTime) {
                this.lastTime = lastTime;
            }

            public void setBirthday(long birthday) {
                this.birthday = birthday;
            }

            public void setShop(String shop) {
                this.shop = shop;
            }

            public void setCounts(int counts) {
                this.counts = counts;
            }

            public void setAreaNameCn(String areaNameCn) {
                this.areaNameCn = areaNameCn;
            }

            public void setInYears(int inYears) {
                this.inYears = inYears;
            }

            public void setCaeateTime(long caeateTime) {
                this.caeateTime = caeateTime;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public void setCityId(int cityId) {
                this.cityId = cityId;
            }

            public void setRongCloudToken(String rongCloudToken) {
                this.rongCloudToken = rongCloudToken;
            }

            public void setTelePhone(String telePhone) {
                this.telePhone = telePhone;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public void setIsDeleted(int isDeleted) {
                this.isDeleted = isDeleted;
            }

            public void setIntimacyJpn(String intimacyJpn) {
                this.intimacyJpn = intimacyJpn;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public void setAreaNameJpn(String areaNameJpn) {
                this.areaNameJpn = areaNameJpn;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setTurnover(int turnover) {
                this.turnover = turnover;
            }

            public void setTagsCn(String tagsCn) {
                this.tagsCn = tagsCn;
            }

            public void setAreaManage(int areaManage) {
                this.areaManage = areaManage;
            }

            public void setPeriod(int period) {
                this.period = period;
            }

            public void setBrokerId(int brokerId) {
                this.brokerId = brokerId;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public void setUpdateTime(long updateTime) {
                this.updateTime = updateTime;
            }

            public void setIntimacyCn(String intimacyCn) {
                this.intimacyCn = intimacyCn;
            }

            public void setToken(String token) {
                this.token = token;
            }

            public void setAvgStar(int avgStar) {
                this.avgStar = avgStar;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public void setTagsJpn(String tagsJpn) {
                this.tagsJpn = tagsJpn;
            }

            public void setWechatId(String wechatId) {
                this.wechatId = wechatId;
            }

            public void setBrokerName(String brokerName) {
                this.brokerName = brokerName;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public long getLastTime() {
                return lastTime;
            }

            public long getBirthday() {
                return birthday;
            }

            public String getShop() {
                return shop;
            }

            public int getCounts() {
                return counts;
            }

            public String getAreaNameCn() {
                return areaNameCn;
            }

            public int getInYears() {
                return inYears;
            }

            public long getCaeateTime() {
                return caeateTime;
            }

            public String getPic() {
                return pic;
            }

            public int getCityId() {
                return cityId;
            }

            public String getRongCloudToken() {
                return rongCloudToken;
            }

            public String getTelePhone() {
                return telePhone;
            }

            public String getPassword() {
                return password;
            }

            public int getIsDeleted() {
                return isDeleted;
            }

            public String getIntimacyJpn() {
                return intimacyJpn;
            }

            public String getNickname() {
                return nickname;
            }

            public String getAreaNameJpn() {
                return areaNameJpn;
            }

            public int getId() {
                return id;
            }

            public int getTurnover() {
                return turnover;
            }

            public String getTagsCn() {
                return tagsCn;
            }

            public int getAreaManage() {
                return areaManage;
            }

            public int getPeriod() {
                return period;
            }

            public int getBrokerId() {
                return brokerId;
            }

            public String getSex() {
                return sex;
            }

            public long getUpdateTime() {
                return updateTime;
            }

            public String getIntimacyCn() {
                return intimacyCn;
            }

            public String getToken() {
                return token;
            }

            public int getAvgStar() {
                return avgStar;
            }

            public String getPhone() {
                return phone;
            }

            public String getTagsJpn() {
                return tagsJpn;
            }

            public String getWechatId() {
                return wechatId;
            }

            public String getBrokerName() {
                return brokerName;
            }

            public String getStatus() {
                return status;
            }
        }
    }
}
