package com.computer.share;

import com.computer.share.model.SystemEnum;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Scope("prototype")
public class ExceptionResult implements Serializable {
    private static final long serialVersionUID = 7646741917792145323L;

    private Integer code;
    private String message;
    private Object info;

    public static final ExceptionResult MESSAGE_RESULT_NO_OBJECT_OK = new ExceptionResult(
            SystemEnum.SUCCESS.getCode(), SystemEnum.SUCCESS.getMessage(), null);

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public ExceptionResult(Integer code, String message, Object info) {
        super();
        this.code = code;
        this.message = message;
        this.info = info;
    }
    public ExceptionResult(Object info) {
        this.code = SystemEnum.SUCCESS.getCode();
        this.message = SystemEnum.SUCCESS.getMessage();
        this.info = info;
    }
    public ExceptionResult() {
    }

}
