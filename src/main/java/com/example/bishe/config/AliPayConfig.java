package com.example.bishe.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "alipay")
@Data
public class AliPayConfig {

    private String privateKey;

    private String serverUrl;

    private String appId;
}
