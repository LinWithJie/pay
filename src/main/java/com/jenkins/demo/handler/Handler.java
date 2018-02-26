package com.jenkins.demo.handler;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author created by BangZhuLi
 * @date 2018/1/26  10:41
 */
@ControllerAdvice
public class Handler {


    @ExceptionHandler(value = AuthorizationException.class)
    public void handleAuthorizationException(AuthorizationException e) {
        System.out.println("用户未登录");
    }

    @ExceptionHandler(value = UnauthenticatedException.class)
    public void handleUnauthenticatedException(UnauthenticatedException e) {
        e.printStackTrace();
    }

    @ExceptionHandler(value = Exception.class)
    public void handlerException(Exception e) {
        e.printStackTrace();
    }
}
