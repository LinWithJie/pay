package com.jenkins.demo;


import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMessage;
import org.springframework.http.converter.HttpMessageConverter;

@SpringBootApplication(scanBasePackages = {"com.jenkins.demo","com.help.shiro"})
@EnableConfigurationProperties
public class DemoApplication{

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}


}
