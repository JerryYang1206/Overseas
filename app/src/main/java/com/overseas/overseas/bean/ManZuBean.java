package com.overseas.overseas.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/6/25.
 */

public class ManZuBean {

    /**
     * msg : 请求成功
     * code : 200
     * datas : [{"id":3,"titleCn":"办公室出租","titleJpn":"办公室出租","specificLocationCn":"1","specificLocationJpn":"1","areaJpn":"100","areaCn":"100","priceCn":"1000","priceJpn":"1000","videoImgs":"http://hwdchk.oss-cn-hongkong.aliyuncs.com/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20180621161322.jpg?x-oss-process=style/ya_suo","roomImgs":"http://hwdchk.oss-cn-hongkong.aliyuncs.com/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20180621161322.jpg?x-oss-process=style/ya_suo","doorModelCn":"户型","doorModelJpn":"户型","houseType":"0","rentCn":"1.00","rentJpn":"1.00","status":"2","zfType":0,"imageList":[]}]
     */

    private String msg;
    private String code;
    private List<DatasBean> datas;

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

    public List<DatasBean> getDatas() {
        return datas;
    }

    public void setDatas(List<DatasBean> datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        /**
         * id : 3
         * titleCn : 办公室出租
         * titleJpn : 办公室出租
         * specificLocationCn : 1
         * specificLocationJpn : 1
         * areaJpn : 100
         * areaCn : 100
         * priceCn : 1000
         * priceJpn : 1000
         * videoImgs : http://hwdchk.oss-cn-hongkong.aliyuncs.com/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20180621161322.jpg?x-oss-process=style/ya_suo
         * roomImgs : http://hwdchk.oss-cn-hongkong.aliyuncs.com/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20180621161322.jpg?x-oss-process=style/ya_suo
         * doorModelCn : 户型
         * doorModelJpn : 户型
         * houseType : 0
         * rentCn : 1.00
         * rentJpn : 1.00
         * status : 2
         * zfType : 0
         * imageList : []
         */

        private int id;
        private String titleCn;
        private String titleJpn;
        private String specificLocationCn;
        private String specificLocationJpn;
        private String areaJpn;
        private String areaCn;
        private String priceCn;
        private String priceJpn;
        private String videoImgs;
        private String roomImgs;
        private String doorModelCn;
        private String doorModelJpn;
        private String houseType;
        private String rentCn;
        private String rentJpn;
        private String status;
        private int zfType;
        private List<?> imageList;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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

        public String getAreaJpn() {
            return areaJpn;
        }

        public void setAreaJpn(String areaJpn) {
            this.areaJpn = areaJpn;
        }

        public String getAreaCn() {
            return areaCn;
        }

        public void setAreaCn(String areaCn) {
            this.areaCn = areaCn;
        }

        public String getPriceCn() {
            return priceCn;
        }

        public void setPriceCn(String priceCn) {
            this.priceCn = priceCn;
        }

        public String getPriceJpn() {
            return priceJpn;
        }

        public void setPriceJpn(String priceJpn) {
            this.priceJpn = priceJpn;
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

        public String getDoorModelCn() {
            return doorModelCn;
        }

        public void setDoorModelCn(String doorModelCn) {
            this.doorModelCn = doorModelCn;
        }

        public String getDoorModelJpn() {
            return doorModelJpn;
        }

        public void setDoorModelJpn(String doorModelJpn) {
            this.doorModelJpn = doorModelJpn;
        }

        public String getHouseType() {
            return houseType;
        }

        public void setHouseType(String houseType) {
            this.houseType = houseType;
        }

        public String getRentCn() {
            return rentCn;
        }

        public void setRentCn(String rentCn) {
            this.rentCn = rentCn;
        }

        public String getRentJpn() {
            return rentJpn;
        }

        public void setRentJpn(String rentJpn) {
            this.rentJpn = rentJpn;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getZfType() {
            return zfType;
        }

        public void setZfType(int zfType) {
            this.zfType = zfType;
        }

        public List<?> getImageList() {
            return imageList;
        }

        public void setImageList(List<?> imageList) {
            this.imageList = imageList;
        }
    }
}
