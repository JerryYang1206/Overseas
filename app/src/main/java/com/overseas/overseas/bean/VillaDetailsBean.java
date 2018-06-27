package com.overseas.overseas.bean;

import java.io.Serializable;

/**
 * Created by   admin on 2018/5/23.
 */

public class VillaDetailsBean {


    /**
     * msg : 请求成功
     * code : 200
     * datas : {"id":1,"brokerId":1,"houseType":"户型（汉语、日语通用）","titleCn":"别墅标题","titleJpn":"别墅标题","articleNameCn":"物件名称","articleNameJpn":"物件名称","homesLayerCn":"楼层","homesLayerJpn":"楼层","areaCn":"土地面积","areaJpn":"土地面积","ownershipCn":"所有权","ownershipJpn":"所有权","orientationCn":"朝向","orientationJpn":"朝向","architecturalCn":"建筑设计公司","architecturalJpn":"建筑设计公司","yearBuiltCn":"建筑年份","yearBuiltJpn":"建筑年份","districtCn":"地段","districtJpn":"地段","trainStationCn":"主要车站","trainStationJpn":"主要车站","specificLocationCn":"具体位置","specificLocationJpn":"具体位置","streetDistanceCn":"道路临街距离","streetDistanceJpn":"道路临街距离","landCn":"土地","landJpn":"土地","stationDistanceCn":"车站距离","stationDistanceJpn":"车站距离","indoorFacilityCn":"室内设施","indoorFacilityJpn":"室内设施","performanceCn":"性能","performanceJpn":"性能","testimonialCn":"证明书","testimonialJpn":"证明书","defectsEnsureCn":"瑕疵保证","defectsEnsureJpn":"瑕疵保证","coveredAreaCn":"建筑面积","coveredAreaJpn":"建筑面积","sellingPriceCn":"售价","sellingPriceJpn":"售价","buildingConstructionCn":"建筑构造","buildingConstructionJpn":"建筑构造","doichoIrinoDateCn":"入居日期","doichoIrinoDateJpn":"入居日期","parkCn":"停车场","parkJpn":"停车场","buildingWrap":"建筑覆盖（中文、日文共用）","plotRatio":"建筑覆盖（中文、日文共用）","currentSituationCn":"现状","currentSituationJpn":"现状","publicInformationDayCn":"公开情报日","publicInformationDayJpn":"公开情报日","kitchenCn":"厨房","kitchenJpn":"厨房","toiletCn":"卫生间","toiletJpn":"卫生间","showerRoomCn":"浴室","showerRoomJpn":"浴室","remarkCn":"备注","remarkJpn":"备注","villaTypeCn":"别墅类型","villaTypeJpn":"别墅类型","videoUrls":"","videoImgs":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527165849795&di=83a34452110e5bf1f69c0881b5805cf1&imgtype=0&src=http%3A%2F%2Fpic2.ooopic.com%2F12%2F10%2F28%2F85bOOOPIC81_1024.jpg","roomImgs":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527165849795&di=83a34452110e5bf1f69c0881b5805cf1&imgtype=0&src=http%3A%2F%2Fpic2.ooopic.com%2F12%2F10%2F28%2F85bOOOPIC81_1024.jpg","floorSearch":true,"areaSearch":10,"sellingPriceSearch":10,"yearBuiltSearch":10,"status":"","createTime":1527067561000,"updateTime":1527067564000,"isDeleted":0,"tableFlag":"4","longitude":1,"latitude":1,"locationLevel1Cn":"1","locationLevel2Cn":"2","locationLevel3Cn":"3","locationLevel4Cn":"","locationLevel1Jpn":"","locationLevel2Jpn":"","locationLevel3Jpn":"","locationLevel4Jpn":"","hwdcBroker":{"id":1,"brokerName":"姓名","phone":"1234","password":"1232132","telePhone":"123132","shop":"所属门店","turnover":100,"inYears":3,"period":1,"counts":60,"pic":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527155765877&di=6b937ef9850ce295871cc7e3a9ef4393&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fa08b87d6277f9e2fd7e815091530e924b999f3d6.jpg","nickname":"昵称","sex":"0","wechatId":"123456","caeateTime":1525781849000,"updateTime":1527067564000,"isDeleted":0,"status":""},"isSc":1}
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
         * brokerId : 1
         * houseType : 户型（汉语、日语通用）
         * titleCn : 别墅标题
         * titleJpn : 别墅标题
         * articleNameCn : 物件名称
         * articleNameJpn : 物件名称
         * homesLayerCn : 楼层
         * homesLayerJpn : 楼层
         * areaCn : 土地面积
         * areaJpn : 土地面积
         * ownershipCn : 所有权
         * ownershipJpn : 所有权
         * orientationCn : 朝向
         * orientationJpn : 朝向
         * architecturalCn : 建筑设计公司
         * architecturalJpn : 建筑设计公司
         * yearBuiltCn : 建筑年份
         * yearBuiltJpn : 建筑年份
         * districtCn : 地段
         * districtJpn : 地段
         * trainStationCn : 主要车站
         * trainStationJpn : 主要车站
         * specificLocationCn : 具体位置
         * specificLocationJpn : 具体位置
         * streetDistanceCn : 道路临街距离
         * streetDistanceJpn : 道路临街距离
         * landCn : 土地
         * landJpn : 土地
         * stationDistanceCn : 车站距离
         * stationDistanceJpn : 车站距离
         * indoorFacilityCn : 室内设施
         * indoorFacilityJpn : 室内设施
         * performanceCn : 性能
         * performanceJpn : 性能
         * testimonialCn : 证明书
         * testimonialJpn : 证明书
         * defectsEnsureCn : 瑕疵保证
         * defectsEnsureJpn : 瑕疵保证
         * coveredAreaCn : 建筑面积
         * coveredAreaJpn : 建筑面积
         * sellingPriceCn : 售价
         * sellingPriceJpn : 售价
         * buildingConstructionCn : 建筑构造
         * buildingConstructionJpn : 建筑构造
         * doichoIrinoDateCn : 入居日期
         * doichoIrinoDateJpn : 入居日期
         * parkCn : 停车场
         * parkJpn : 停车场
         * buildingWrap : 建筑覆盖（中文、日文共用）
         * plotRatio : 建筑覆盖（中文、日文共用）
         * currentSituationCn : 现状
         * currentSituationJpn : 现状
         * publicInformationDayCn : 公开情报日
         * publicInformationDayJpn : 公开情报日
         * kitchenCn : 厨房
         * kitchenJpn : 厨房
         * toiletCn : 卫生间
         * toiletJpn : 卫生间
         * showerRoomCn : 浴室
         * showerRoomJpn : 浴室
         * remarkCn : 备注
         * remarkJpn : 备注
         * villaTypeCn : 别墅类型
         * villaTypeJpn : 别墅类型
         * videoUrls :
         * videoImgs : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527165849795&di=83a34452110e5bf1f69c0881b5805cf1&imgtype=0&src=http%3A%2F%2Fpic2.ooopic.com%2F12%2F10%2F28%2F85bOOOPIC81_1024.jpg
         * roomImgs : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527165849795&di=83a34452110e5bf1f69c0881b5805cf1&imgtype=0&src=http%3A%2F%2Fpic2.ooopic.com%2F12%2F10%2F28%2F85bOOOPIC81_1024.jpg
         * floorSearch : true
         * areaSearch : 10
         * sellingPriceSearch : 10
         * yearBuiltSearch : 10
         * status :
         * createTime : 1527067561000
         * updateTime : 1527067564000
         * isDeleted : 0
         * tableFlag : 4
         * longitude : 1
         * latitude : 1
         * locationLevel1Cn : 1
         * locationLevel2Cn : 2
         * locationLevel3Cn : 3
         * locationLevel4Cn :
         * locationLevel1Jpn :
         * locationLevel2Jpn :
         * locationLevel3Jpn :
         * locationLevel4Jpn :
         * hwdcBroker : {"id":1,"brokerName":"姓名","phone":"1234","password":"1232132","telePhone":"123132","shop":"所属门店","turnover":100,"inYears":3,"period":1,"counts":60,"pic":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527155765877&di=6b937ef9850ce295871cc7e3a9ef4393&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fa08b87d6277f9e2fd7e815091530e924b999f3d6.jpg","nickname":"昵称","sex":"0","wechatId":"123456","caeateTime":1525781849000,"updateTime":1527067564000,"isDeleted":0,"status":""}
         * isSc : 1
         */

        private int id;
        private int brokerId;
        private String houseType;
        private String titleCn;
        private String titleJpn;
        private String articleNameCn;
        private String articleNameJpn;
        private String homesLayerCn;
        private String homesLayerJpn;
        private String areaCn;
        private String areaJpn;
        private String ownershipCn;
        private String ownershipJpn;
        private String orientationCn;
        private String orientationJpn;
        private String architecturalCn;
        private String architecturalJpn;
        private String yearBuiltCn;
        private String yearBuiltJpn;
        private String districtCn;
        private String districtJpn;
        private String trainStationCn;
        private String trainStationJpn;
        private String specificLocationCn;
        private String specificLocationJpn;
        private String streetDistanceCn;
        private String streetDistanceJpn;
        private String landCn;
        private String landJpn;
        private String stationDistanceCn;
        private String stationDistanceJpn;
        private String indoorFacilityCn;
        private String indoorFacilityJpn;
        private String performanceCn;
        private String performanceJpn;
        private String testimonialCn;
        private String testimonialJpn;
        private String defectsEnsureCn;
        private String defectsEnsureJpn;
        private String coveredAreaCn;
        private String coveredAreaJpn;
        private String sellingPriceCn;
        private String sellingPriceJpn;
        private String buildingConstructionCn;
        private String buildingConstructionJpn;
        private String doichoIrinoDateCn;
        private String doichoIrinoDateJpn;
        private String parkCn;
        private String parkJpn;
        private String buildingWrap;
        private String plotRatio;
        private String currentSituationCn;
        private String currentSituationJpn;
        private String publicInformationDayCn;
        private String publicInformationDayJpn;
        private String kitchenCn;
        private String kitchenJpn;
        private String toiletCn;
        private String toiletJpn;
        private String showerRoomCn;
        private String showerRoomJpn;
        private String remarkCn;
        private String remarkJpn;
        private String villaTypeCn;
        private String villaTypeJpn;
        private String videoUrls;
        private String videoImgs;
        private String roomImgs;
        private boolean floorSearch;
        private int areaSearch;
        private int sellingPriceSearch;
        private int yearBuiltSearch;
        private String status;
        private long createTime;
        private long updateTime;
        private int isDeleted;
        private String tableFlag;
        private int longitude;
        private int latitude;
        private String locationLevel1Cn;
        private String locationLevel2Cn;
        private String locationLevel3Cn;
        private String locationLevel4Cn;
        private String locationLevel1Jpn;
        private String locationLevel2Jpn;
        private String locationLevel3Jpn;
        private String locationLevel4Jpn;
        private HwdcBrokerBean hwdcBroker;
        private int isSc;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getBrokerId() {
            return brokerId;
        }

        public void setBrokerId(int brokerId) {
            this.brokerId = brokerId;
        }

        public String getHouseType() {
            return houseType;
        }

        public void setHouseType(String houseType) {
            this.houseType = houseType;
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

        public String getArticleNameCn() {
            return articleNameCn;
        }

        public void setArticleNameCn(String articleNameCn) {
            this.articleNameCn = articleNameCn;
        }

        public String getArticleNameJpn() {
            return articleNameJpn;
        }

        public void setArticleNameJpn(String articleNameJpn) {
            this.articleNameJpn = articleNameJpn;
        }

        public String getHomesLayerCn() {
            return homesLayerCn;
        }

        public void setHomesLayerCn(String homesLayerCn) {
            this.homesLayerCn = homesLayerCn;
        }

        public String getHomesLayerJpn() {
            return homesLayerJpn;
        }

        public void setHomesLayerJpn(String homesLayerJpn) {
            this.homesLayerJpn = homesLayerJpn;
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

        public String getOrientationCn() {
            return orientationCn;
        }

        public void setOrientationCn(String orientationCn) {
            this.orientationCn = orientationCn;
        }

        public String getOrientationJpn() {
            return orientationJpn;
        }

        public void setOrientationJpn(String orientationJpn) {
            this.orientationJpn = orientationJpn;
        }

        public String getArchitecturalCn() {
            return architecturalCn;
        }

        public void setArchitecturalCn(String architecturalCn) {
            this.architecturalCn = architecturalCn;
        }

        public String getArchitecturalJpn() {
            return architecturalJpn;
        }

        public void setArchitecturalJpn(String architecturalJpn) {
            this.architecturalJpn = architecturalJpn;
        }

        public String getYearBuiltCn() {
            return yearBuiltCn;
        }

        public void setYearBuiltCn(String yearBuiltCn) {
            this.yearBuiltCn = yearBuiltCn;
        }

        public String getYearBuiltJpn() {
            return yearBuiltJpn;
        }

        public void setYearBuiltJpn(String yearBuiltJpn) {
            this.yearBuiltJpn = yearBuiltJpn;
        }

        public String getDistrictCn() {
            return districtCn;
        }

        public void setDistrictCn(String districtCn) {
            this.districtCn = districtCn;
        }

        public String getDistrictJpn() {
            return districtJpn;
        }

        public void setDistrictJpn(String districtJpn) {
            this.districtJpn = districtJpn;
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

        public String getStreetDistanceCn() {
            return streetDistanceCn;
        }

        public void setStreetDistanceCn(String streetDistanceCn) {
            this.streetDistanceCn = streetDistanceCn;
        }

        public String getStreetDistanceJpn() {
            return streetDistanceJpn;
        }

        public void setStreetDistanceJpn(String streetDistanceJpn) {
            this.streetDistanceJpn = streetDistanceJpn;
        }

        public String getLandCn() {
            return landCn;
        }

        public void setLandCn(String landCn) {
            this.landCn = landCn;
        }

        public String getLandJpn() {
            return landJpn;
        }

        public void setLandJpn(String landJpn) {
            this.landJpn = landJpn;
        }

        public String getStationDistanceCn() {
            return stationDistanceCn;
        }

        public void setStationDistanceCn(String stationDistanceCn) {
            this.stationDistanceCn = stationDistanceCn;
        }

        public String getStationDistanceJpn() {
            return stationDistanceJpn;
        }

        public void setStationDistanceJpn(String stationDistanceJpn) {
            this.stationDistanceJpn = stationDistanceJpn;
        }

        public String getIndoorFacilityCn() {
            return indoorFacilityCn;
        }

        public void setIndoorFacilityCn(String indoorFacilityCn) {
            this.indoorFacilityCn = indoorFacilityCn;
        }

        public String getIndoorFacilityJpn() {
            return indoorFacilityJpn;
        }

        public void setIndoorFacilityJpn(String indoorFacilityJpn) {
            this.indoorFacilityJpn = indoorFacilityJpn;
        }

        public String getPerformanceCn() {
            return performanceCn;
        }

        public void setPerformanceCn(String performanceCn) {
            this.performanceCn = performanceCn;
        }

        public String getPerformanceJpn() {
            return performanceJpn;
        }

        public void setPerformanceJpn(String performanceJpn) {
            this.performanceJpn = performanceJpn;
        }

        public String getTestimonialCn() {
            return testimonialCn;
        }

        public void setTestimonialCn(String testimonialCn) {
            this.testimonialCn = testimonialCn;
        }

        public String getTestimonialJpn() {
            return testimonialJpn;
        }

        public void setTestimonialJpn(String testimonialJpn) {
            this.testimonialJpn = testimonialJpn;
        }

        public String getDefectsEnsureCn() {
            return defectsEnsureCn;
        }

        public void setDefectsEnsureCn(String defectsEnsureCn) {
            this.defectsEnsureCn = defectsEnsureCn;
        }

        public String getDefectsEnsureJpn() {
            return defectsEnsureJpn;
        }

        public void setDefectsEnsureJpn(String defectsEnsureJpn) {
            this.defectsEnsureJpn = defectsEnsureJpn;
        }

        public String getCoveredAreaCn() {
            return coveredAreaCn;
        }

        public void setCoveredAreaCn(String coveredAreaCn) {
            this.coveredAreaCn = coveredAreaCn;
        }

        public String getCoveredAreaJpn() {
            return coveredAreaJpn;
        }

        public void setCoveredAreaJpn(String coveredAreaJpn) {
            this.coveredAreaJpn = coveredAreaJpn;
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

        public String getBuildingConstructionCn() {
            return buildingConstructionCn;
        }

        public void setBuildingConstructionCn(String buildingConstructionCn) {
            this.buildingConstructionCn = buildingConstructionCn;
        }

        public String getBuildingConstructionJpn() {
            return buildingConstructionJpn;
        }

        public void setBuildingConstructionJpn(String buildingConstructionJpn) {
            this.buildingConstructionJpn = buildingConstructionJpn;
        }

        public String getDoichoIrinoDateCn() {
            return doichoIrinoDateCn;
        }

        public void setDoichoIrinoDateCn(String doichoIrinoDateCn) {
            this.doichoIrinoDateCn = doichoIrinoDateCn;
        }

        public String getDoichoIrinoDateJpn() {
            return doichoIrinoDateJpn;
        }

        public void setDoichoIrinoDateJpn(String doichoIrinoDateJpn) {
            this.doichoIrinoDateJpn = doichoIrinoDateJpn;
        }

        public String getParkCn() {
            return parkCn;
        }

        public void setParkCn(String parkCn) {
            this.parkCn = parkCn;
        }

        public String getParkJpn() {
            return parkJpn;
        }

        public void setParkJpn(String parkJpn) {
            this.parkJpn = parkJpn;
        }

        public String getBuildingWrap() {
            return buildingWrap;
        }

        public void setBuildingWrap(String buildingWrap) {
            this.buildingWrap = buildingWrap;
        }

        public String getPlotRatio() {
            return plotRatio;
        }

        public void setPlotRatio(String plotRatio) {
            this.plotRatio = plotRatio;
        }

        public String getCurrentSituationCn() {
            return currentSituationCn;
        }

        public void setCurrentSituationCn(String currentSituationCn) {
            this.currentSituationCn = currentSituationCn;
        }

        public String getCurrentSituationJpn() {
            return currentSituationJpn;
        }

        public void setCurrentSituationJpn(String currentSituationJpn) {
            this.currentSituationJpn = currentSituationJpn;
        }

        public String getPublicInformationDayCn() {
            return publicInformationDayCn;
        }

        public void setPublicInformationDayCn(String publicInformationDayCn) {
            this.publicInformationDayCn = publicInformationDayCn;
        }

        public String getPublicInformationDayJpn() {
            return publicInformationDayJpn;
        }

        public void setPublicInformationDayJpn(String publicInformationDayJpn) {
            this.publicInformationDayJpn = publicInformationDayJpn;
        }

        public String getKitchenCn() {
            return kitchenCn;
        }

        public void setKitchenCn(String kitchenCn) {
            this.kitchenCn = kitchenCn;
        }

        public String getKitchenJpn() {
            return kitchenJpn;
        }

        public void setKitchenJpn(String kitchenJpn) {
            this.kitchenJpn = kitchenJpn;
        }

        public String getToiletCn() {
            return toiletCn;
        }

        public void setToiletCn(String toiletCn) {
            this.toiletCn = toiletCn;
        }

        public String getToiletJpn() {
            return toiletJpn;
        }

        public void setToiletJpn(String toiletJpn) {
            this.toiletJpn = toiletJpn;
        }

        public String getShowerRoomCn() {
            return showerRoomCn;
        }

        public void setShowerRoomCn(String showerRoomCn) {
            this.showerRoomCn = showerRoomCn;
        }

        public String getShowerRoomJpn() {
            return showerRoomJpn;
        }

        public void setShowerRoomJpn(String showerRoomJpn) {
            this.showerRoomJpn = showerRoomJpn;
        }

        public String getRemarkCn() {
            return remarkCn;
        }

        public void setRemarkCn(String remarkCn) {
            this.remarkCn = remarkCn;
        }

        public String getRemarkJpn() {
            return remarkJpn;
        }

        public void setRemarkJpn(String remarkJpn) {
            this.remarkJpn = remarkJpn;
        }

        public String getVillaTypeCn() {
            return villaTypeCn;
        }

        public void setVillaTypeCn(String villaTypeCn) {
            this.villaTypeCn = villaTypeCn;
        }

        public String getVillaTypeJpn() {
            return villaTypeJpn;
        }

        public void setVillaTypeJpn(String villaTypeJpn) {
            this.villaTypeJpn = villaTypeJpn;
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

        public String getRoomImgs() {
            return roomImgs;
        }

        public void setRoomImgs(String roomImgs) {
            this.roomImgs = roomImgs;
        }

        public boolean isFloorSearch() {
            return floorSearch;
        }

        public void setFloorSearch(boolean floorSearch) {
            this.floorSearch = floorSearch;
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

        public int getYearBuiltSearch() {
            return yearBuiltSearch;
        }

        public void setYearBuiltSearch(int yearBuiltSearch) {
            this.yearBuiltSearch = yearBuiltSearch;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
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

        public String getTableFlag() {
            return tableFlag;
        }

        public void setTableFlag(String tableFlag) {
            this.tableFlag = tableFlag;
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

        public HwdcBrokerBean getHwdcBroker() {
            return hwdcBroker;
        }

        public void setHwdcBroker(HwdcBrokerBean hwdcBroker) {
            this.hwdcBroker = hwdcBroker;
        }

        public int getIsSc() {
            return isSc;
        }

        public void setIsSc(int isSc) {
            this.isSc = isSc;
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
             * updateTime : 1527067564000
             * isDeleted : 0
             * status :
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
        }
    }
}
