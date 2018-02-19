package com.computer.share.model;

public enum SystemEnum {
    SUCCESS(0, "成功"),
    FAIL(0, "失败"),
    OTHER(0, "其他");
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
