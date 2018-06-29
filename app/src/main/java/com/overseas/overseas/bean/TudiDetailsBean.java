package com.overseas.overseas.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/28.
 */

public class TudiDetailsBean implements Serializable {

    /**
     * msg : 请求成功
     * code : 200
     * datas : {"id":1,"locationLevel1Cn":"1","locationLevel2Cn":"2","locationLevel3Cn":"3","locationLevel4Cn":"","locationLevel1Jpn":"","locationLevel2Jpn":"","locationLevel3Jpn":"","locationLevel4Jpn":"","longitude":1,"latitude":1,"titleCn":"标题","titleJpn":"标题","videoUrls":"http://www.iqiyi.com/w_19rsxrgq8d.html","videoImgs":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1526960221&di=d5a70cd88be67479c20836cbdb04c46d&src=http://www.08lr.cn/uploads/allimg/170513/1-1F513100951.jpg","createTime":1526353616000,"updateTime":1526353618000,"isDeleted":0,"status":"","tableFlag":"1","specificLocationCn":"具体位置","specificLocationJpn":"具体位置","sellingPriceCn":"售价","sellingPriceJpn":"售价","areaCn":"面积","areaJpn":"面积","stationCn":"车站距离","stationJpn":"车站距离","aroundLightingCn":"周围采光","aroundLightingJpn":"周围采光","cornerCn":"是否是街角","cornerJpn":"是否是街角","aroundSceneryCn":"周围风景","aroundSceneryJpn":"周围风景","tallShipsCn":"能否高建筑","tallShipsJpn":"能否高建筑","locationCn":"","locationJpn":"","ownershipCn":"所有权","ownershipJpn":"所有权","buildingCoverageCn":"建筑覆盖率","buildingCoverageJpn":"建筑覆盖率","engineryCn":"机能","engineryJpn":"机能","plotRatioCn":"容积率","plotRatioJpn":"容积率","returnRateCn":"回报率","returnRateJpn":"回报率","remarksCn":"备注","remarksJpn":"备注","actualityCn":"","actualityJpn":"","trainStationCn":"主要车站","trainStationJpn":"主要车站","areaSearch":1,"sellingPriceSearch":1,"landImgs":"","hwdcBroker":{"id":1,"brokerName":"姓名","phone":"1234","password":"1232132","telePhone":"123132","shop":"所属门店","turnover":100,"inYears":3,"period":1,"counts":60,"pic":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527155765877&di=6b937ef9850ce295871cc7e3a9ef4393&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fa08b87d6277f9e2fd7e815091530e924b999f3d6.jpg","nickname":"昵称","sex":"0","wechatId":"123456","caeateTime":1525781849000,"updateTime":1526353618000,"isDeleted":0,"status":null}}
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

    public static class DatasBean implements Serializable {
        /**
         * id : 1
         * locationLevel1Cn : 1
         * locationLevel2Cn : 2
         * locationLevel3Cn : 3
         * locationLevel4Cn :
         * locationLevel1Jpn :
         * locationLevel2Jpn :
         * locationLevel3Jpn :
         * locationLevel4Jpn :
         * longitude : 1
         * latitude : 1
         * titleCn : 标题
         * titleJpn : 标题
         * videoUrls : http://www.iqiyi.com/w_19rsxrgq8d.html
         * videoImgs : https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1526960221&di=d5a70cd88be67479c20836cbdb04c46d&src=http://www.08lr.cn/uploads/allimg/170513/1-1F513100951.jpg
         * createTime : 1526353616000
         * updateTime : 1526353618000
         * isDeleted : 0
         * status :
         * tableFlag : 1
         * specificLocationCn : 具体位置
         * specificLocationJpn : 具体位置
         * sellingPriceCn : 售价
         * sellingPriceJpn : 售价
         * areaCn : 面积
         * areaJpn : 面积
         * stationCn : 车站距离
         * stationJpn : 车站距离
         * aroundLightingCn : 周围采光
         * aroundLightingJpn : 周围采光
         * cornerCn : 是否是街角
         * cornerJpn : 是否是街角
         * aroundSceneryCn : 周围风景
         * aroundSceneryJpn : 周围风景
         * tallShipsCn : 能否高建筑
         * tallShipsJpn : 能否高建筑
         * locationCn :
         * locationJpn :
         * ownershipCn : 所有权
         * ownershipJpn : 所有权
         * buildingCoverageCn : 建筑覆盖率
         * buildingCoverageJpn : 建筑覆盖率
         * engineryCn : 机能
         * engineryJpn : 机能
         * plotRatioCn : 容积率
         * plotRatioJpn : 容积率
         * returnRateCn : 回报率
         * returnRateJpn : 回报率
         * remarksCn : 备注
         * remarksJpn : 备注
         * actualityCn :
         * actualityJpn :
         * trainStationCn : 主要车站
         * trainStationJpn : 主要车站
         * areaSearch : 1
         * sellingPriceSearch : 1
         * landImgs :
         * hwdcBroker : {"id":1,"brokerName":"姓名","phone":"1234","password":"1232132","telePhone":"123132","shop":"所属门店","turnover":100,"inYears":3,"period":1,"counts":60,"pic":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527155765877&di=6b937ef9850ce295871cc7e3a9ef4393&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fa08b87d6277f9e2fd7e815091530e924b999f3d6.jpg","nickname":"昵称","sex":"0","wechatId":"123456","caeateTime":1525781849000,"updateTime":1526353618000,"isDeleted":0,"status":null}
         */

        private int id;
        private String locationLevel1Cn;
        private String locationLevel2Cn;
        private String locationLevel3Cn;
        private String locationLevel4Cn;
        private String locationLevel1Jpn;
        private String locationLevel2Jpn;
        private String locationLevel3Jpn;
        private String locationLevel4Jpn;
        private int longitude;
        private int latitude;
        private String titleCn;
        private String titleJpn;
        private String videoUrls;
        private String videoImgs;
        private long createTime;
        private long updateTime;
        private int isDeleted;
        private String status;
        private String tableFlag;
        private String specificLocationCn;
        private String specificLocationJpn;
        private String sellingPriceCn;
        private String sellingPriceJpn;
        private String areaCn;
        private String areaJpn;
        private String stationCn;
        private String stationJpn;
        private String aroundLightingCn;
        private String aroundLightingJpn;
        private String cornerCn;
        private String cornerJpn;
        private String aroundSceneryCn;
        private String aroundSceneryJpn;
        private String tallShipsCn;
        private String tallShipsJpn;
        private String locationCn;
        private String locationJpn;
        private String ownershipCn;
        private String ownershipJpn;
        private String buildingCoverageCn;
        private String buildingCoverageJpn;
        private String engineryCn;
        private String engineryJpn;
        private String plotRatioCn;
        private String plotRatioJpn;
        private String returnRateCn;
        private String returnRateJpn;
        private String remarksCn;
        private String remarksJpn;
        private String actualityCn;
        private String actualityJpn;
        private String trainStationCn;
        private String trainStationJpn;
        private int areaSearch;
        private int sellingPriceSearch;
        private String landImgs;
        private HwdcBrokerBean hwdcBroker;
        private int isSc;

        public int getIsSc() {
            return isSc;
        }

        public void setIsSc(int isSc) {
            this.isSc = isSc;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLocationLevel1Cn() {
            return locationLevel1Cn;
        }

        public void setLocationLevel1Cn(String locationLevel1Cn) {
            this.locationLevel1Cn = locationLevel1Cn;
        }

        public String getLocationLevel2Cn() {
            return locationLevel2Cn;
        }

        public void setLocationLevel2Cn(String locationLevel2Cn) {
            this.locationLevel2Cn = locationLevel2Cn;
        }

        public String getLocationLevel3Cn() {
            return locationLevel3Cn;
        }

        public void setLocationLevel3Cn(String locationLevel3Cn) {
            this.locationLevel3Cn = locationLevel3Cn;
        }

        public String getLocationLevel4Cn() {
            return locationLevel4Cn;
        }

        public void setLocationLevel4Cn(String locationLevel4Cn) {
            this.locationLevel4Cn = locationLevel4Cn;
        }

        public String getLocationLevel1Jpn() {
            return locationLevel1Jpn;
        }

        public void setLocationLevel1Jpn(String locationLevel1Jpn) {
            this.locationLevel1Jpn = locationLevel1Jpn;
        }

        public String getLocationLevel2Jpn() {
            return locationLevel2Jpn;
        }

        public void setLocationLevel2Jpn(String locationLevel2Jpn) {
            this.locationLevel2Jpn = locationLevel2Jpn;
        }

        public String getLocationLevel3Jpn() {
            return locationLevel3Jpn;
        }

        public void setLocationLevel3Jpn(String locationLevel3Jpn) {
            this.locationLevel3Jpn = locationLevel3Jpn;
        }

        public String getLocationLevel4Jpn() {
            return locationLevel4Jpn;
        }

        public void setLocationLevel4Jpn(String locationLevel4Jpn) {
            this.locationLevel4Jpn = locationLevel4Jpn;
        }

        public int getLongitude() {
            return longitude;
        }

        public void setLongitude(int longitude) {
            this.longitude = longitude;
        }

        public int getLatitude() {
            return latitude;
        }

        public void setLatitude(int latitude) {
            this.latitude = latitude;
        }

        public String getTitleCn() {
            return titleCn;
        }

        public void setTitleCn(String titleCn) {
            this.titleCn = titleCn;
        }

        public String getTitleJpn() {
            return titleJpn;
        }

        public void setTitleJpn(String titleJpn) {
            this.titleJpn = titleJpn;
        }

        public String getVideoUrls() {
            return videoUrls;
        }

        public void setVideoUrls(String videoUrls) {
            this.videoUrls = videoUrls;
        }

        public String getVideoImgs() {
            return videoImgs;
        }

        public void setVideoImgs(String videoImgs) {
            this.videoImgs = videoImgs;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
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

        public String getTableFlag() {
            return tableFlag;
        }

        public void setTableFlag(String tableFlag) {
            this.tableFlag = tableFlag;
        }

        public String getSpecificLocationCn() {
            return specificLocationCn;
        }

        public void setSpecificLocationCn(String specificLocationCn) {
            this.specificLocationCn = specificLocationCn;
        }

        public String getSpecificLocationJpn() {
            return specificLocationJpn;
        }

        public void setSpecificLocationJpn(String specificLocationJpn) {
            this.specificLocationJpn = specificLocationJpn;
        }

        public String getSellingPriceCn() {
            return sellingPriceCn;
        }

        public void setSellingPriceCn(String sellingPriceCn) {
            this.sellingPriceCn = sellingPriceCn;
        }

        public String getSellingPriceJpn() {
            return sellingPriceJpn;
        }

        public void setSellingPriceJpn(String sellingPriceJpn) {
            this.sellingPriceJpn = sellingPriceJpn;
        }

        public String getAreaCn() {
            return areaCn;
        }

        public void setAreaCn(String areaCn) {
            this.areaCn = areaCn;
        }

        public String getAreaJpn() {
            return areaJpn;
        }

        public void setAreaJpn(String areaJpn) {
            this.areaJpn = areaJpn;
        }

        public String getStationCn() {
            return stationCn;
        }

        public void setStationCn(String stationCn) {
            this.stationCn = stationCn;
        }

        public String getStationJpn() {
            return stationJpn;
        }

        public void setStationJpn(String stationJpn) {
            this.stationJpn = stationJpn;
        }

        public String getAroundLightingCn() {
            return aroundLightingCn;
        }

        public void setAroundLightingCn(String aroundLightingCn) {
            this.aroundLightingCn = aroundLightingCn;
        }

        public String getAroundLightingJpn() {
            return aroundLightingJpn;
        }

        public void setAroundLightingJpn(String aroundLightingJpn) {
            this.aroundLightingJpn = aroundLightingJpn;
        }

        public String getCornerCn() {
            return cornerCn;
        }

        public void setCornerCn(String cornerCn) {
            this.cornerCn = cornerCn;
        }

        public String getCornerJpn() {
            return cornerJpn;
        }

        public void setCornerJpn(String cornerJpn) {
            this.cornerJpn = cornerJpn;
        }

        public String getAroundSceneryCn() {
            return aroundSceneryCn;
        }

        public void setAroundSceneryCn(String aroundSceneryCn) {
            this.aroundSceneryCn = aroundSceneryCn;
        }

        public String getAroundSceneryJpn() {
            return aroundSceneryJpn;
        }

        public void setAroundSceneryJpn(String aroundSceneryJpn) {
            this.aroundSceneryJpn = aroundSceneryJpn;
        }

        public String getTallShipsCn() {
            return tallShipsCn;
        }

        public void setTallShipsCn(String tallShipsCn) {
            this.tallShipsCn = tallShipsCn;
        }

        public String getTallShipsJpn() {
            return tallShipsJpn;
        }

        public void setTallShipsJpn(String tallShipsJpn) {
            this.tallShipsJpn = tallShipsJpn;
        }

        public String getLocationCn() {
            return locationCn;
        }

        public void setLocationCn(String locationCn) {
            this.locationCn = locationCn;
        }

        public String getLocationJpn() {
            return locationJpn;
        }

        public void setLocationJpn(String locationJpn) {
            this.locationJpn = locationJpn;
        }

        public String getOwnershipCn() {
            return ownershipCn;
        }

        public void setOwnershipCn(String ownershipCn) {
            this.ownershipCn = ownershipCn;
        }

        public String getOwnershipJpn() {
            return ownershipJpn;
        }

        public void setOwnershipJpn(String ownershipJpn) {
            this.ownershipJpn = ownershipJpn;
        }

        public String getBuildingCoverageCn() {
            return buildingCoverageCn;
        }

        public void setBuildingCoverageCn(String buildingCoverageCn) {
            this.buildingCoverageCn = buildingCoverageCn;
        }

        public String getBuildingCoverageJpn() {
            return buildingCoverageJpn;
        }

        public void setBuildingCoverageJpn(String buildingCoverageJpn) {
            this.buildingCoverageJpn = buildingCoverageJpn;
        }

        public String getEngineryCn() {
            return engineryCn;
        }

        public void setEngineryCn(String engineryCn) {
            this.engineryCn = engineryCn;
        }

        public String getEngineryJpn() {
            return engineryJpn;
        }

        public void setEngineryJpn(String engineryJpn) {
            this.engineryJpn = engineryJpn;
        }

        public String getPlotRatioCn() {
            return plotRatioCn;
        }

        public void setPlotRatioCn(String plotRatioCn) {
            this.plotRatioCn = plotRatioCn;
        }

        public String getPlotRatioJpn() {
            return plotRatioJpn;
        }

        public void setPlotRatioJpn(String plotRatioJpn) {
            this.plotRatioJpn = plotRatioJpn;
        }

        public String getReturnRateCn() {
            return returnRateCn;
        }

        public void setReturnRateCn(String returnRateCn) {
            this.returnRateCn = returnRateCn;
        }

        public String getReturnRateJpn() {
            return returnRateJpn;
        }

        public void setReturnRateJpn(String returnRateJpn) {
            this.returnRateJpn = returnRateJpn;
        }

        public String getRemarksCn() {
            return remarksCn;
        }

        public void setRemarksCn(String remarksCn) {
            this.remarksCn = remarksCn;
        }

        public String getRemarksJpn() {
            return remarksJpn;
        }

        public void setRemarksJpn(String remarksJpn) {
            this.remarksJpn = remarksJpn;
        }

        public String getActualityCn() {
            return actualityCn;
        }

        public void setActualityCn(String actualityCn) {
            this.actualityCn = actualityCn;
        }

        public String getActualityJpn() {
            return actualityJpn;
        }

        public void setActualityJpn(String actualityJpn) {
            this.actualityJpn = actualityJpn;
        }

        public String getTrainStationCn() {
            return trainStationCn;
        }

        public void setTrainStationCn(String trainStationCn) {
            this.trainStationCn = trainStationCn;
        }

        public String getTrainStationJpn() {
            return trainStationJpn;
        }

        public void setTrainStationJpn(String trainStationJpn) {
            this.trainStationJpn = trainStationJpn;
        }

        public int getAreaSearch() {
            return areaSearch;
        }

        public void setAreaSearch(int areaSearch) {
            this.areaSearch = areaSearch;
        }

        public int getSellingPriceSearch() {
            return sellingPriceSearch;
        }

        public void setSellingPriceSearch(int sellingPriceSearch) {
            this.sellingPriceSearch = sellingPriceSearch;
        }

        public String getLandImgs() {
            return landImgs;
        }

        public void setLandImgs(String landImgs) {
            this.landImgs = landImgs;
        }

        public HwdcBrokerBean getHwdcBroker() {
            return hwdcBroker;
        }

        public void setHwdcBroker(HwdcBrokerBean hwdcBroker) {
            this.hwdcBroker = hwdcBroker;
        }

        public static class HwdcBrokerBean implements Serializable {
            /**
             * id : 1
             * brokerName : 姓名
             * phone : 1234
             * password : 1232132
             * telePhone : 123132
             * shop : 所属门店
             * turnover : 100
             * inYears : 3
             * period : 1
             * counts : 60
             * pic : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527155765877&di=6b937ef9850ce295871cc7e3a9ef4393&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fa08b87d6277f9e2fd7e815091530e924b999f3d6.jpg
             * nickname : 昵称
             * sex : 0
             * wechatId : 123456
             * caeateTime : 1525781849000
             * updateTime : 1526353618000
             * isDeleted : 0
             * status : null
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
            private Object status;

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

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
                this.status = status;
            }
        }
    }
}
