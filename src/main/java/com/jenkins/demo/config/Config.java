package com.jenkins.demo.config;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author created by BangZhuLi
 * @date 2018/1/25  18:00
 * 配置复用的bean
 */
@Configuration
@ConfigurationProperties(prefix = "alipay")
public class Config {
    private String APP_ID;
    private String APP_PRIVATE_KEY;
    private String CHARSET;
    private String ALIPAY_PUBLIC_KEY;


    @Bean
    public AlipayClient getAlipayClient(){
        return new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do"
                , APP_ID, APP_PRIVATE_KEY
                , "json", CHARSET
                , ALIPAY_PUBLIC_KEY
                , "RSA2");
    }
}
