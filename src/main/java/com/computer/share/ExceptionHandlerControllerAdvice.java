package com.computer.share;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yongx
 */
@ControllerAdvice(annotations = {RestController.class, Controller.class})
public class ExceptionHandlerControllerAdvice {

    private static final int SERVICE_EXCEPTION_CODE = 3001;


    @ExceptionHandler
    @ResponseBody
    public ExceptionResult exception(HttpServletRequest request, Exception e) {
        // 添加自己的异常处理逻辑，如日志记录
        // 根据不同的异常类型进行不同处理
        ExceptionResult result = new ExceptionResult();
        if (e instanceof ServiceException) {// 服务层异常
            result = printExcepiton(e, SERVICE_EXCEPTION_CODE);
        } else {
            result = printExcepiton(e, 2001);
        }
        return result;
    }


    public ExceptionResult printExcepiton(Exception e, int code) {
        ExceptionResult result = new ExceptionResult();
        e.printStackTrace();
        result.setCode(code);
        if (e.getMessage() == null) {
            result.setMessage("illegal args");
        } else {
            result.setMessage(e.getMessage());
        }
        result.setInfo(e.getStackTrace());
        return result;
    }

}
