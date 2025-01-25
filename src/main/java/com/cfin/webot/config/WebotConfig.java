package com.cfin.webot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "cfin.webot")
@Data
public class WebotConfig {


    /**
     * 管理员
     */
    private String owner;


    /**
     * 服务地址
     */
    private String baseUrl;




}
