package com.example.bishe.util;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConfig;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.diagnosis.DiagnosisUtils;
import com.alipay.api.domain.AlipayFundTransUniTransferModel;
import com.alipay.api.domain.Participant;
import com.alipay.api.request.AlipayFundTransUniTransferRequest;
import com.alipay.api.response.AlipayFundTransUniTransferResponse;
import com.example.bishe.config.AliPayConfig;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AliPayUtil {

    @Resource
    private AliPayConfig payConfig;

    public  HashMap<String, String> pay(Map<String,String> hashMap) throws AlipayApiException {
        // 初始化SDK
        AlipayClient alipayClient = new DefaultAlipayClient(getAlipayConfig());

        // 构造请求参数以调用接口
        AlipayFundTransUniTransferRequest request = new AlipayFundTransUniTransferRequest();
        AlipayFundTransUniTransferModel model = new AlipayFundTransUniTransferModel();

        // 设置转账业务的标题
        model.setOrderTitle("工人工资支付");

        // 设置描述特定的业务场景
        model.setBizScene("DIRECT_TRANSFER");

        // 设置转账业务请求的扩展参数
        model.setBusinessParams("{\"payer_show_name_use_alias\":\"true\"}");

        // 设置业务备注
        model.setRemark("工人工资支付");

        // 设置商家侧唯一订单号
        model.setOutBizNo(hashMap.get("outBizNo"));

        // 设置订单总金额
        model.setTransAmount(hashMap.get("transAmount"));

        // 设置业务产品码
        model.setProductCode("TRANS_ACCOUNT_NO_PWD");

        // 设置收款方信息
        Participant payeeInfo = new Participant();
        payeeInfo.setIdentity(hashMap.get("identity"));
        payeeInfo.setName(hashMap.get("name"));
        payeeInfo.setIdentityType("ALIPAY_USER_ID");
        model.setPayeeInfo(payeeInfo);

        request.setBizModel(model);
        AlipayFundTransUniTransferResponse response = alipayClient.certificateExecute(request);
        //System.out.println(response.getBody());

        if (response.isSuccess()) {
            HashMap<String, String> res = new HashMap<>();
            res.put("msg",response.getMsg());
            res.put("orderId",response.getOrderId());
            res.put("payFundOrderId",response.getPayFundOrderId());
            res.put("transDate",response.getTransDate());
            System.out.println("调用成功");
            return res;

        } else {
            //System.out.println("调用失败");
            // sdk版本是"4.38.0.ALL"及以上,可以参考下面的示例获取诊断链接
            String diagnosisUrl = DiagnosisUtils.getDiagnosisUrl(response);
            //System.out.println(diagnosisUrl);
            HashMap<String, String> res = new HashMap<>();
            res.put("DiagnosisUrl", diagnosisUrl);
            return res;
        }

    }

    public AlipayConfig getAlipayConfig() {
        AlipayConfig alipayConfig = new AlipayConfig();
        alipayConfig.setPrivateKey(payConfig.getPrivateKey());
        alipayConfig.setServerUrl(payConfig.getServerUrl());
        alipayConfig.setAppId(payConfig.getAppId());
        alipayConfig.setCharset("UTF-8");
        alipayConfig.setSignType("RSA2");
        alipayConfig.setFormat("json");
        alipayConfig.setAppCertPath("F:\\bamboo\\bishe\\src\\main\\resources\\crt\\appPublicCert.crt");
        alipayConfig.setAlipayPublicCertPath("F:\\bamboo\\bishe\\src\\main\\resources\\crt\\alipayPublicCert.crt");
        alipayConfig.setRootCertPath("F:\\bamboo\\bishe\\src\\main\\resources\\crt\\alipayRootCert.crt");
        return alipayConfig;
    }
}
