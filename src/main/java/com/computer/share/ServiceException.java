package com.computer.share;

public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 3248067767385420131L;

    public ServiceException(String message){
        super(message);
    }
}

