package com.overseas.overseas.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/29.
 */

public class ShangYeDetailsBean {

    /**
     * msg : 请求成功
     * code : 200
     * datas : {"id":1,"locationLevel1Cn":"1","locationLevel2Cn":"2","locationLevel3Cn":"3","locationLevel4Cn":"","locationLevel1Jpn":"","locationLevel2Jpn":"","locationLevel3Jpn":"","locationLevel4Jpn":"","longitude":100,"latitude":100,"titleCn":"海外地产标题","titleJpn":"海外地产标题","videoUrls":"","videoImgs":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527165849796&di=ec7155a96b50c7741aac8e50ca34cd98&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F4d086e061d950a7b9138ff1000d162d9f3d3c9d1.jpg","realEstateImgs":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527165849796&di=ec7155a96b50c7741aac8e50ca34cd98&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F4d086e061d950a7b9138ff1000d162d9f3d3c9d1.jpg","createTime":1526727055000,"updateTime":1526727057000,"isDeleted":0,"status":"0","tableFlag":"2","yearBuiltCn":"1990","yearBuiltJpn":"1990","articleCn":"物件","articleJpn":"物件","floorCn":"3层以下","floorJpn":"3层以下","stationDistanceCn":"1","stationDistanceJpn":"1","sellingPriceCn":"100","sellingPriceJpn":"100","ownershipCn":"所有权","ownershipJpn":"所有权","actualityCn":"现状","actualityJpn":"现状","regionalPurposesCn":"地域用途","regionalPurposesJpn":"地域用途","returnRateCn":"回报率","returnRateJpn":"回报率","buildingConstructionCn":"建筑构造","buildingConstructionJpn":"建筑构造","remarksCn":"备注","remarksJpn":"备注","areaCn":"100","areaJpn":"100","headwatersCn":"水源","headwatersJpn":"水源","terrainCn":"地形","terrainJpn":"地形","soilRegimeCn":"土壤","soilRegimeJpn":"土壤","surroundingsCn":"周边环境","surroundingsJpn":"周边环境","leaseTypeCn":"出租、售卖类型","leaseTypeJpn":"出租、售卖类型","doichoIrinoCn":"入局日期","doichoIrinoJpn":"入局日期","manageCn":"管理","manageJpn":"管理","managementSocietyCn":"管理会社","managementSocietyJpn":"管理会社","managementFeeCn":"管理费","managementFeeJpn":"管理费","railwayStationCn":"1","railwayStationJpn":"1","parkingSpaceCn":"停车位","parkingSpaceJpn":"停车位","indoorEquipmentCn":"室内设备","indoorEquipmentJpn":"室内设备","orientationCn":"朝向","orientationJpn":"朝向","districtCn":"地段","districtJpn":"地段","shopSignsCn":"商铺招牌","shopSignsJpn":"山沟招牌","outdoorSettingCn":"室外设置","outdoorSettingJpn":"室外设置","bicepsShelfCn":"举架高度","bicepsShelfJpn":"举架高度","insidePlantCn":"室内设施","insidePlantJpn":"室内设施","characteristicCn":"特征","characteristicJpn":"特征","conditionCn":"条件","conditionJpn":"条件","areaSearch":1,"sellingPriceSearch":1,"yearBuiltSearh":2010,"specificLocationCn":"1","specificLocationJpn":"1","hwdcBroker":{"id":1,"brokerName":"姓名","phone":"1234","password":"1232132","telePhone":"123132","shop":"所属门店","turnover":100,"inYears":3,"period":1,"counts":60,"pic":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527155765877&di=6b937ef9850ce295871cc7e3a9ef4393&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fa08b87d6277f9e2fd7e815091530e924b999f3d6.jpg","nickname":"昵称","sex":"0","wechatId":"123456","caeateTime":1525781849000,"updateTime":1526727057000,"isDeleted":0,"status":"0"}}
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
         * longitude : 100
         * latitude : 100
         * titleCn : 海外地产标题
         * titleJpn : 海外地产标题
         * videoUrls :
         * videoImgs : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527165849796&di=ec7155a96b50c7741aac8e50ca34cd98&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F4d086e061d950a7b9138ff1000d162d9f3d3c9d1.jpg
         * realEstateImgs : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527165849796&di=ec7155a96b50c7741aac8e50ca34cd98&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F4d086e061d950a7b9138ff1000d162d9f3d3c9d1.jpg
         * createTime : 1526727055000
         * updateTime : 1526727057000
         * isDeleted : 0
         * status : 0
         * tableFlag : 2
         * yearBuiltCn : 1990
         * yearBuiltJpn : 1990
         * articleCn : 物件
         * articleJpn : 物件
         * floorCn : 3层以下
         * floorJpn : 3层以下
         * stationDistanceCn : 1
         * stationDistanceJpn : 1
         * sellingPriceCn : 100
         * sellingPriceJpn : 100
         * ownershipCn : 所有权
         * ownershipJpn : 所有权
         * actualityCn : 现状
         * actualityJpn : 现状
         * regionalPurposesCn : 地域用途
         * regionalPurposesJpn : 地域用途
         * returnRateCn : 回报率
         * returnRateJpn : 回报率
         * buildingConstructionCn : 建筑构造
         * buildingConstructionJpn : 建筑构造
         * remarksCn : 备注
         * remarksJpn : 备注
         * areaCn : 100
         * areaJpn : 100
         * headwatersCn : 水源
         * headwatersJpn : 水源
         * terrainCn : 地形
         * terrainJpn : 地形
         * soilRegimeCn : 土壤
         * soilRegimeJpn : 土壤
         * surroundingsCn : 周边环境
         * surroundingsJpn : 周边环境
         * leaseTypeCn : 出租、售卖类型
         * leaseTypeJpn : 出租、售卖类型
         * doichoIrinoCn : 入局日期
         * doichoIrinoJpn : 入局日期
         * manageCn : 管理
         * manageJpn : 管理
         * managementSocietyCn : 管理会社
         * managementSocietyJpn : 管理会社
         * managementFeeCn : 管理费
         * managementFeeJpn : 管理费
         * railwayStationCn : 1
         * railwayStationJpn : 1
         * parkingSpaceCn : 停车位
         * parkingSpaceJpn : 停车位
         * indoorEquipmentCn : 室内设备
         * indoorEquipmentJpn : 室内设备
         * orientationCn : 朝向
         * orientationJpn : 朝向
         * districtCn : 地段
         * districtJpn : 地段
         * shopSignsCn : 商铺招牌
         * shopSignsJpn : 山沟招牌
         * outdoorSettingCn : 室外设置
         * outdoorSettingJpn : 室外设置
         * bicepsShelfCn : 举架高度
         * bicepsShelfJpn : 举架高度
         * insidePlantCn : 室内设施
         * insidePlantJpn : 室内设施
         * characteristicCn : 特征
         * characteristicJpn : 特征
         * conditionCn : 条件
         * conditionJpn : 条件
         * areaSearch : 1
         * sellingPriceSearch : 1
         * yearBuiltSearh : 2010
         * specificLocationCn : 1
         * specificLocationJpn : 1
         * hwdcBroker : {"id":1,"brokerName":"姓名","phone":"1234","password":"1232132","telePhone":"123132","shop":"所属门店","turnover":100,"inYears":3,"period":1,"counts":60,"pic":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527155765877&di=6b937ef9850ce295871cc7e3a9ef4393&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fa08b87d6277f9e2fd7e815091530e924b999f3d6.jpg","nickname":"昵称","sex":"0","wechatId":"123456","caeateTime":1525781849000,"updateTime":1526727057000,"isDeleted":0,"status":"0"}
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
        private String realEstateImgs;
        private long createTime;
        private long updateTime;
        private int isDeleted;
        private String status;
        private String tableFlag;
        private String yearBuiltCn;
        private String yearBuiltJpn;
        private String articleCn;
        private String articleJpn;
        private String floorCn;
        private String floorJpn;
        private String stationDistanceCn;
        private String stationDistanceJpn;
        private String sellingPriceCn;
        private String sellingPriceJpn;
        private String ownershipCn;
        private String ownershipJpn;
        private String actualityCn;
        private String actualityJpn;
        private String regionalPurposesCn;
        private String regionalPurposesJpn;
        private String returnRateCn;
        private String returnRateJpn;
        private String buildingConstructionCn;
        private String buildingConstructionJpn;
        private String remarksCn;
        private String remarksJpn;
        private String areaCn;
        private String areaJpn;
        private String headwatersCn;
        private String headwatersJpn;
        private String terrainCn;
        private String terrainJpn;
        private String soilRegimeCn;
        private String soilRegimeJpn;
        private String surroundingsCn;
        private String surroundingsJpn;
        private String leaseTypeCn;
        private String leaseTypeJpn;
        private String doichoIrinoCn;
        private String doichoIrinoJpn;
        private String manageCn;
        private String manageJpn;
        private String managementSocietyCn;
        private String managementSocietyJpn;
        private String managementFeeCn;
        private String managementFeeJpn;
        private String railwayStationCn;
        private String railwayStationJpn;
        private String parkingSpaceCn;
        private String parkingSpaceJpn;
        private String indoorEquipmentCn;
        private String indoorEquipmentJpn;
        private String orientationCn;
        private String orientationJpn;
        private String districtCn;
        private String districtJpn;
        private String shopSignsCn;
        private String shopSignsJpn;
        private String outdoorSettingCn;
        private String outdoorSettingJpn;
        private String bicepsShelfCn;
        private String bicepsShelfJpn;
        private String insidePlantCn;
        private String insidePlantJpn;
        private String characteristicCn;
        private String characteristicJpn;
        private String conditionCn;
        private String conditionJpn;
        private int areaSearch;
        private int sellingPriceSearch;
        private int yearBuiltSearh;
        private String specificLocationCn;
        private String specificLocationJpn;
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

        public String getRealEstateImgs() {
            return realEstateImgs;
        }

        public void setRealEstateImgs(String realEstateImgs) {
            this.realEstateImgs = realEstateImgs;
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

        public String getArticleCn() {
            return articleCn;
        }

        public void setArticleCn(String articleCn) {
            this.articleCn = articleCn;
        }

        public String getArticleJpn() {
            return articleJpn;
        }

        public void setArticleJpn(String articleJpn) {
            this.articleJpn = articleJpn;
        }

        public String getFloorCn() {
            return floorCn;
        }

        public void setFloorCn(String floorCn) {
            this.floorCn = floorCn;
        }

        public String getFloorJpn() {
            return floorJpn;
        }

        public void setFloorJpn(String floorJpn) {
            this.floorJpn = floorJpn;
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

        public String getRegionalPurposesCn() {
            return regionalPurposesCn;
        }

        public void setRegionalPurposesCn(String regionalPurposesCn) {
            this.regionalPurposesCn = regionalPurposesCn;
        }

        public String getRegionalPurposesJpn() {
            return regionalPurposesJpn;
        }

        public void setRegionalPurposesJpn(String regionalPurposesJpn) {
            this.regionalPurposesJpn = regionalPurposesJpn;
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

        public String getHeadwatersCn() {
            return headwatersCn;
        }

        public void setHeadwatersCn(String headwatersCn) {
            this.headwatersCn = headwatersCn;
        }

        public String getHeadwatersJpn() {
            return headwatersJpn;
        }

        public void setHeadwatersJpn(String headwatersJpn) {
            this.headwatersJpn = headwatersJpn;
        }

        public String getTerrainCn() {
            return terrainCn;
        }

        public void setTerrainCn(String terrainCn) {
            this.terrainCn = terrainCn;
        }

        public String getTerrainJpn() {
            return terrainJpn;
        }

        public void setTerrainJpn(String terrainJpn) {
            this.terrainJpn = terrainJpn;
        }

        public String getSoilRegimeCn() {
            return soilRegimeCn;
        }

        public void setSoilRegimeCn(String soilRegimeCn) {
            this.soilRegimeCn = soilRegimeCn;
        }

        public String getSoilRegimeJpn() {
            return soilRegimeJpn;
        }

        public void setSoilRegimeJpn(String soilRegimeJpn) {
            this.soilRegimeJpn = soilRegimeJpn;
        }

        public String getSurroundingsCn() {
            return surroundingsCn;
        }

        public void setSurroundingsCn(String surroundingsCn) {
            this.surroundingsCn = surroundingsCn;
        }

        public String getSurroundingsJpn() {
            return surroundingsJpn;
        }

        public void setSurroundingsJpn(String surroundingsJpn) {
            this.surroundingsJpn = surroundingsJpn;
        }

        public String getLeaseTypeCn() {
            return leaseTypeCn;
        }

        public void setLeaseTypeCn(String leaseTypeCn) {
            this.leaseTypeCn = leaseTypeCn;
        }

        public String getLeaseTypeJpn() {
            return leaseTypeJpn;
        }

        public void setLeaseTypeJpn(String leaseTypeJpn) {
            this.leaseTypeJpn = leaseTypeJpn;
        }

        public String getDoichoIrinoCn() {
            return doichoIrinoCn;
        }

        public void setDoichoIrinoCn(String doichoIrinoCn) {
            this.doichoIrinoCn = doichoIrinoCn;
        }

        public String getDoichoIrinoJpn() {
            return doichoIrinoJpn;
        }

        public void setDoichoIrinoJpn(String doichoIrinoJpn) {
            this.doichoIrinoJpn = doichoIrinoJpn;
        }

        public String getManageCn() {
            return manageCn;
        }

        public void setManageCn(String manageCn) {
            this.manageCn = manageCn;
        }

        public String getManageJpn() {
            return manageJpn;
        }

        public void setManageJpn(String manageJpn) {
            this.manageJpn = manageJpn;
        }

        public String getManagementSocietyCn() {
            return managementSocietyCn;
        }

        public void setManagementSocietyCn(String managementSocietyCn) {
            this.managementSocietyCn = managementSocietyCn;
        }

        public String getManagementSocietyJpn() {
            return managementSocietyJpn;
        }

        public void setManagementSocietyJpn(String managementSocietyJpn) {
            this.managementSocietyJpn = managementSocietyJpn;
        }

        public String getManagementFeeCn() {
            return managementFeeCn;
        }

        public void setManagementFeeCn(String managementFeeCn) {
            this.managementFeeCn = managementFeeCn;
        }

        public String getManagementFeeJpn() {
            return managementFeeJpn;
        }

        public void setManagementFeeJpn(String managementFeeJpn) {
            this.managementFeeJpn = managementFeeJpn;
        }

        public String getRailwayStationCn() {
            return railwayStationCn;
        }

        public void setRailwayStationCn(String railwayStationCn) {
            this.railwayStationCn = railwayStationCn;
        }

        public String getRailwayStationJpn() {
            return railwayStationJpn;
        }

        public void setRailwayStationJpn(String railwayStationJpn) {
            this.railwayStationJpn = railwayStationJpn;
        }

        public String getParkingSpaceCn() {
            return parkingSpaceCn;
        }

        public void setParkingSpaceCn(String parkingSpaceCn) {
            this.parkingSpaceCn = parkingSpaceCn;
        }

        public String getParkingSpaceJpn() {
            return parkingSpaceJpn;
        }

        public void setParkingSpaceJpn(String parkingSpaceJpn) {
            this.parkingSpaceJpn = parkingSpaceJpn;
        }

        public String getIndoorEquipmentCn() {
            return indoorEquipmentCn;
        }

        public void setIndoorEquipmentCn(String indoorEquipmentCn) {
            this.indoorEquipmentCn = indoorEquipmentCn;
        }

        public String getIndoorEquipmentJpn() {
            return indoorEquipmentJpn;
        }

        public void setIndoorEquipmentJpn(String indoorEquipmentJpn) {
            this.indoorEquipmentJpn = indoorEquipmentJpn;
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

        public String getShopSignsCn() {
            return shopSignsCn;
        }

        public void setShopSignsCn(String shopSignsCn) {
            this.shopSignsCn = shopSignsCn;
        }

        public String getShopSignsJpn() {
            return shopSignsJpn;
        }

        public void setShopSignsJpn(String shopSignsJpn) {
            this.shopSignsJpn = shopSignsJpn;
        }

        public String getOutdoorSettingCn() {
            return outdoorSettingCn;
        }

        public void setOutdoorSettingCn(String outdoorSettingCn) {
            this.outdoorSettingCn = outdoorSettingCn;
        }

        public String getOutdoorSettingJpn() {
            return outdoorSettingJpn;
        }

        public void setOutdoorSettingJpn(String outdoorSettingJpn) {
            this.outdoorSettingJpn = outdoorSettingJpn;
        }

        public String getBicepsShelfCn() {
            return bicepsShelfCn;
        }

        public void setBicepsShelfCn(String bicepsShelfCn) {
            this.bicepsShelfCn = bicepsShelfCn;
        }

        public String getBicepsShelfJpn() {
            return bicepsShelfJpn;
        }

        public void setBicepsShelfJpn(String bicepsShelfJpn) {
            this.bicepsShelfJpn = bicepsShelfJpn;
        }

        public String getInsidePlantCn() {
            return insidePlantCn;
        }

        public void setInsidePlantCn(String insidePlantCn) {
            this.insidePlantCn = insidePlantCn;
        }

        public String getInsidePlantJpn() {
            return insidePlantJpn;
        }

        public void setInsidePlantJpn(String insidePlantJpn) {
            this.insidePlantJpn = insidePlantJpn;
        }

        public String getCharacteristicCn() {
            return characteristicCn;
        }

        public void setCharacteristicCn(String characteristicCn) {
            this.characteristicCn = characteristicCn;
        }

        public String getCharacteristicJpn() {
            return characteristicJpn;
        }

        public void setCharacteristicJpn(String characteristicJpn) {
            this.characteristicJpn = characteristicJpn;
        }

        public String getConditionCn() {
            return conditionCn;
        }

        public void setConditionCn(String conditionCn) {
            this.conditionCn = conditionCn;
        }

        public String getConditionJpn() {
            return conditionJpn;
        }

        public void setConditionJpn(String conditionJpn) {
            this.conditionJpn = conditionJpn;
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

        public int getYearBuiltSearh() {
            return yearBuiltSearh;
        }

        public void setYearBuiltSearh(int yearBuiltSearh) {
            this.yearBuiltSearh = yearBuiltSearh;
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
             * updateTime : 1526727057000
             * isDeleted : 0
             * status : 0
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
