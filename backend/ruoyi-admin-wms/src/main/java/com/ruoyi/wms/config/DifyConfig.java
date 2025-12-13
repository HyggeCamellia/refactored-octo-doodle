package com.ruoyi.wms.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Dify API配置类
 *
 * @author ruoyi
 */
@Configuration
@ConfigurationProperties(prefix = "dify.api")
@Data
public class DifyConfig {
    /**
     * API密钥
     */
    private String apiKey;

    /**
     * API地址
     */
    private String baseUrl = "https://api.dify.ai";

    /**
     * 超时时间(毫秒)
     */
    private int timeout = 30000;
}
