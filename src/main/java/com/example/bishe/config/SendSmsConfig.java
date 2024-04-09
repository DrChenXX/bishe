package com.example.bishe.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "aliyun.sms")
@Data
public class SendSmsConfig {

    private String regionId;

    private String accoessKeyId;

    private String accoessKeySecret;

    private String signName;

    private String templateCode;

}
