package com.jenkins.demo.util;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.jenkins.demo.dto.PayParamsDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author created by BangZhuLi
 * @date 2018/1/25  17:58
 * 支付工具类
 */
@Component
@Slf4j
public class PayUtil {

    @Autowired
    private AlipayClient alipayClient;

    @Value("${alipay.returnUrl}")
    private String returnUrl;
    @Value("${alipay.notifyUrl}")
    private String notifyUrl;



    public String pay(PayParamsDTO payParamsDTO) throws AlipayApiException{
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
        alipayRequest.setReturnUrl(returnUrl);
        alipayRequest.setNotifyUrl(notifyUrl);//在公共参数中设置回跳和通知地址
        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":\"" + payParamsDTO.getOutTradeNo() + "\"," +
                "    \"product_code\":\"" + payParamsDTO.getProductCode() + "\"," +
                "    \"total_amount\":" + payParamsDTO.getTotalAmount() + "," +
                "    \"subject\":\"" +  payParamsDTO.getSubject() + "\"," +
                "    \"body\":\"" + payParamsDTO.getBody() + "\"" +
                "  }");//填充业务参数

        log.info("业务参数为{}", alipayRequest.getBizContent());
        String form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        return form;
    }
}
