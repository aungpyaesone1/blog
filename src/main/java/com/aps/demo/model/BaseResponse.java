package com.aps.demo.model;

public class BaseResponse {
    private String status_code;
    private String status_message;
    private long syskey;

    public BaseResponse(){

    }
    public BaseResponse(String status_code, String status_message){
        this.status_code = status_code;
        this.status_message = status_message;
    }
    public String getStatus_code() {
        return status_code;
    }

    public void setStatus_code(String status_code) {
        this.status_code = status_code;
    }

    public String getStatus_message() {
        return status_message;
    }

    public void setStatus_message(String status_message) {
        this.status_message = status_message;
    }

    public long getSyskey() {
        return syskey;
    }

    public void setSyskey(long syskey) {
        this.syskey = syskey;
    }
}
