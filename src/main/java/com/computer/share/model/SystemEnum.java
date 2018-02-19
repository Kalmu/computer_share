package com.computer.share.model;

public enum SystemEnum {
    SUCCESS(1000, "成功"),
    FAIL(1001, "失败"),
    OTHER(1002, "其他");
    private int code;
    private String message;

    SystemEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode(){
        return code;
    }

    public String getMessage(){
        return message;
    }
}
