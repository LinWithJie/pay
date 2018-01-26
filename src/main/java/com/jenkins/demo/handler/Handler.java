package com.jenkins.demo.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author created by BangZhuLi
 * @date 2018/1/26  10:41
 */
@ControllerAdvice
public class Handler {


    @ExceptionHandler(value = Exception.class)
    public void handlerException(Exception e) {
        e.printStackTrace();
    }
}
