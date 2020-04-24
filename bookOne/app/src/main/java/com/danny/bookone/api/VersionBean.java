package com.danny.bookone.api;

public class VersionBean {

    /**
     * success : true
     * status : 200
     * message : 获取App版本成功
     * data : {"id":"742","version":14,"version_name":"2.2","flag":0,"url":"https://uzh.oss-cn-hangzhou.aliyuncs.com/packages/testApk/uzh_2.2_test.apk","describes":"优装汇2.2测试包","remark":"优装汇2.2测试包","create_time":"2019-06-03 15:09:44"}
     */

    private boolean success;
    private int status;
    private String message;
    private DataBean data;

    @Override
    public String toString() {
        return "VersionBean{" +
                "success=" + success +
                ", status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 742
         * version : 14
         * version_name : 2.2
         * flag : 0
         * url : https://uzh.oss-cn-hangzhou.aliyuncs.com/packages/testApk/uzh_2.2_test.apk
         * describes : 优装汇2.2测试包
         * remark : 优装汇2.2测试包
         * create_time : 2019-06-03 15:09:44
         */

        private String id;
        private int version;
        private String version_name;
        private int flag;
        private String url;
        private String describes;
        private String remark;
        private String create_time;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public String getVersion_name() {
            return version_name;
        }

        public void setVersion_name(String version_name) {
            this.version_name = version_name;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getDescribes() {
            return describes;
        }

        public void setDescribes(String describes) {
            this.describes = describes;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }
    }
}
