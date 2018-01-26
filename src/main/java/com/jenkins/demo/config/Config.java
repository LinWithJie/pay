package com.jenkins.demo.config;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import lombok.Data;
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
@Data
public class Config {
    private String appId;
    private String appPrivateKey;
    private String charset;
    private String alipayPublicKey;


    @Bean
    public AlipayClient getAlipayClient(){
        return new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do"
                , appId, appPrivateKey
                , "json", charset
                , alipayPublicKey
                , "RSA2");
    }
}
