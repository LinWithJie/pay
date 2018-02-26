package com.jenkins.demo.controller;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.alipay.api.AlipayApiException;
import com.help.shiro.core.remote.PermissionContext;
import com.help.shiro.core.remote.RemoteServiceInterface;
import com.jenkins.demo.dto.PayParamsDTO;
import com.jenkins.demo.util.CookieUtil;
import com.jenkins.demo.util.PayUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * @author created by BangZhuLi
 * @date 2018/1/25  17:48
 * 目前暂时用于支付宝支付控制器
 */
@Controller
@Slf4j
public class PayController {

    @Autowired
    private PayUtil payUtil;

    @Autowired
    private HttpInvokerProxyFactoryBean remoteService;

    @PostMapping("/aliPCPay")
    public void aliPCPay(@RequestParam(value = "totalAmount") String totalAmount,
                          @RequestParam(value = "subject") String subject,
                           HttpServletResponse httpResponse) throws AlipayApiException, IOException{
        PayParamsDTO payParamsDTO = new PayParamsDTO();
        payParamsDTO.setOutTradeNo(UUID.randomUUID().toString());
        payParamsDTO.setSubject(subject);
        payParamsDTO.setTotalAmount(Double.parseDouble(totalAmount));
        String form = payUtil.pay(payParamsDTO);
        httpResponse.setContentType("text/html;charset=utf-8");
        httpResponse.getWriter().write(form);//直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }

    @GetMapping("/test")
    @RequiresRoles("admin")
    public String toPay(HttpServletRequest request, HttpServletResponse response){
        return "/pay";
    }

    @GetMapping("/remoteTest")
    @ResponseBody
    public String remoteTest(@RequestParam("sessionId") String sessionId) {
        if (remoteService == null) {
            return "remoteService为空";
        }

        Session session = ((RemoteServiceInterface)remoteService.getObject()).getSession(sessionId);
        return session.toString();
    }
}
