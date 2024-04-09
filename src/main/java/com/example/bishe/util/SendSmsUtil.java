package com.example.bishe.util;

import com.aliyun.auth.credentials.Credential;
import com.aliyun.auth.credentials.provider.StaticCredentialProvider;
import com.aliyun.sdk.service.dysmsapi20170525.models.*;
import com.aliyun.sdk.service.dysmsapi20170525.*;
import com.example.bishe.config.SendSmsConfig;
import com.google.gson.Gson;
import darabonba.core.client.ClientOverrideConfiguration;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Component
public class SendSmsUtil {

    @Resource
    private SendSmsConfig sendSmsConfig;


    public void SendSms(String phoneNumber, String num) throws ExecutionException, InterruptedException {
        StaticCredentialProvider provider = StaticCredentialProvider.create(Credential.builder()
                .accessKeyId(sendSmsConfig.getAccoessKeyId())
                .accessKeySecret(sendSmsConfig.getAccoessKeySecret())
                .build());
        AsyncClient client = AsyncClient.builder()
                .region(sendSmsConfig.getRegionId()) // Region ID
                .credentialsProvider(provider)
                .overrideConfiguration(
                        ClientOverrideConfiguration.create()
                                .setEndpointOverride("dysmsapi.aliyuncs.com")
                )
                .build();
        SendSmsRequest sendSmsRequest = SendSmsRequest.builder()
                .phoneNumbers(phoneNumber)
                .signName(sendSmsConfig.getSignName())
                .templateCode(sendSmsConfig.getTemplateCode())
                .templateParam("{\"num\":\"" + num + "\"}")
                .build();
        CompletableFuture<SendSmsResponse> response = client.sendSms(sendSmsRequest);
        SendSmsResponse resp = response.get();
        System.out.println(new Gson().toJson(resp));
        client.close();

    }
}


