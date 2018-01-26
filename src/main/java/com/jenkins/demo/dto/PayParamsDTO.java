package com.jenkins.demo.dto;

import lombok.Data;

/**
 * @author created by BangZhuLi
 * @date 2018/1/25  18:14
 * 所要提交到支付宝的预支付参数类
 */
@Data
public class PayParamsDTO {
    /**
     * 订单号，需要保证本系统唯一
     */
    private String outTradeNo;

    /**
     * 商品销售码，支付宝目前仅支持FAST_INSTANT_TRADE_PAY
     */
    private String productCode = "FAST_INSTANT_TRADE_PAY";

    /**
     * 支付总金额
     */
    private Double totalAmount;

    /**
     * 商品标题
     */
    private String subject;

    /**
     * 商品主体信息，可为空
     */
    private String body;

}
