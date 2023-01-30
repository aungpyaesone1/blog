package com.aps.demo.model;

public class ExceptionResponse extends BaseResponse{
    private String timestamps;
    public ExceptionResponse(String code, String msg, String timestamps){
        super(code, msg);
        this.timestamps = timestamps;
    }

    public String getTimestamps() {
        return timestamps;
    }

    public void setTimestamps(String timestamps) {
        this.timestamps = timestamps;
    }
}
