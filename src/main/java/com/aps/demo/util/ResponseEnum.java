package com.aps.demo.util;

public class ResponseEnum {
    public enum ResponseMessage{
        SAVE_SUCCESS("Successfully Saved"),
        SAVE_FAIL("Save Fail"),
        UPDATE_SUCCESS("Successfully Updated"),
        UPDATE_FAIL("Update Fail"),
        DELETE_SUCCESS("Successfully Deleted"),
        DELETE_FAIL("Delete Fail"),
        NOT_FOUND("Item not found"),
        SUCCESS("Success"),
        FAIL("Fail"),
        INVALID_REQUEST("Invalid request");

        private String message;

        ResponseMessage (String value){
            this.message = value;
        }

        public String message() {
            return message;
        }
    }
    public enum ResponseCode{
        SUCCESS("200"),
        INVALID_REQUEST("400"),
        SERVER_ERROR("500"),
        UNKNOWN_ERROR("505"),
        UNAUTHORIZED("401"),
        NOT_FOUND("404");

        private String code;
        ResponseCode(String value){
            this.code = value;
        }
        public String code(){
            return code;
        }
    }
}
