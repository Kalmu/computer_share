package com.computer.share.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultResponse<T> {
    private int code;
    private String message;
    private T data;

    public ResultResponse(int code, String message){
        this.code = code;
        this.message = message;
    }
}
