package com.overseas.overseas.model;

import java.util.List;

/**
 * admin  2018/6/13
 */
public class LinkmanBean {


    /**
     * msg : 请求成功
     * code : 200
     * datas : [{"key":"X","list":[{"id":1,"brokerName":"姓名","rongCloudToken":null,"pic":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527155765877&di=6b937ef9850ce295871cc7e3a9ef4393&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fa08b87d6277f9e2fd7e815091530e924b999f3d6.jpg"}]},{"key":"W","list":[{"id":2,"brokerName":"我是经纪人","rongCloudToken":null,"pic":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527155765877&di=6b937ef9850ce295871cc7e3a9ef4393&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fa08b87d6277f9e2fd7e815091530e924b999f3d6.jpg"}]}]
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
         * key : X
         * list : [{"id":1,"brokerName":"姓名","rongCloudToken":null,"pic":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527155765877&di=6b937ef9850ce295871cc7e3a9ef4393&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fa08b87d6277f9e2fd7e815091530e924b999f3d6.jpg"}]
         */

        private String key;
        private List<ListBean> list;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 1
             * brokerName : 姓名
             * rongCloudToken : null
             * pic : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527155765877&di=6b937ef9850ce295871cc7e3a9ef4393&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fa08b87d6277f9e2fd7e815091530e924b999f3d6.jpg
             */

            private int id;
            private String brokerName;
            private Object rongCloudToken;
            private String pic;

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

            public Object getRongCloudToken() {
                return rongCloudToken;
            }

            public void setRongCloudToken(Object rongCloudToken) {
                this.rongCloudToken = rongCloudToken;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }
        }
    }
}
