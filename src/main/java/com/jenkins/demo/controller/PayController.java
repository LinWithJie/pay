package com.jenkins.demo.controller;

import com.alipay.api.AlipayApiException;
import com.jenkins.demo.dto.PayParamsDTO;
import com.jenkins.demo.util.PayUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author created by BangZhuLi
 * @date 2018/1/25  17:48
 * 目前暂时用于支付宝支付控制器
 */
@RestController
@Slf4j
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private PayUtil payUtil;

    @PostMapping("/aliPCPay")
    public String aliPCPay(@RequestBody PayParamsDTO payParamsDTO) throws AlipayApiException{
        return  payUtil.pay(payParamsDTO);
    }
}
