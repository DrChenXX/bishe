package com.example.bishe;

import cn.dev33.satoken.secure.SaSecureUtil;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConfig;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayFundTransUniTransferModel;
import com.alipay.api.domain.Participant;
import com.alipay.api.request.AlipayFundTransUniTransferRequest;
import com.alipay.api.response.AlipayFundTransUniTransferResponse;
import com.example.bishe.config.AliPayConfig;
import com.example.bishe.util.SendSmsUtil;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import static com.example.bishe.contnat.UserConstant.PASSWORD;


@SpringBootTest
class BisheApplicationTests {

    @Resource
    private SendSmsUtil sendSmsUtil;

    @Resource
    private AliPayConfig payConfig;

    @Test
    public void SendSmsTest() {
        ArrayList<String> phones = new ArrayList<>();
        phones.add("13579237483");
        phones.add("19313103723");

        String phoneNumbers = StringUtils.join(phones, ",");
        System.out.println(phoneNumbers);

        String num = "1234";
        try {
            sendSmsUtil.SendSms(phoneNumbers, num);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getAlipayConfig() {
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
        System.out.println("密钥"+alipayConfig.getPrivateKey());
    }

    @Test
    public void alipay() throws AlipayApiException {
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


        // 初始化SDK
        AlipayClient alipayClient = new DefaultAlipayClient(alipayConfig);

        // 构造请求参数以调用接口
        AlipayFundTransUniTransferRequest request = new AlipayFundTransUniTransferRequest();
        AlipayFundTransUniTransferModel model = new AlipayFundTransUniTransferModel();

        // 设置转账业务的标题
        model.setOrderTitle("工资支付");

        // 设置描述特定的业务场景
        model.setBizScene("DIRECT_TRANSFER");

        // 设置转账业务请求的扩展参数
        model.setBusinessParams("{\"payer_show_name_use_alias\":\"true\"}");

        // 设置业务备注
        model.setRemark("工资支付");

        // 设置商家侧唯一订单号
        model.setOutBizNo("201806300002");

        // 设置订单总金额
        model.setTransAmount("77.00");

        // 设置业务产品码
        model.setProductCode("TRANS_ACCOUNT_NO_PWD");

        // 设置收款方信息
        Participant payeeInfo = new Participant();
        payeeInfo.setIdentity("2088722033365674");
        payeeInfo.setName("tcqile8097");
        payeeInfo.setIdentityType("ALIPAY_USER_ID");
        model.setPayeeInfo(payeeInfo);

        request.setBizModel(model);
        AlipayFundTransUniTransferResponse response = alipayClient.certificateExecute(request);
        System.out.println(response.getBody());

        if (response.isSuccess()) {
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
            // sdk版本是"4.38.0.ALL"及以上,可以参考下面的示例获取诊断链接
            // String diagnosisUrl = DiagnosisUtils.getDiagnosisUrl(response);
            // System.out.println(diagnosisUrl);
        }
    }

    @Test
    public void publishTask() {
        String todayDate = new SimpleDateFormat("yyyyMMdd")
                .format(new Date());
        // 1为 int 类型、0代表前面要补位的字符、2代表字符串的长度、d表示参数为整数类型
        String s = String.format("%04d", 1);
        String str = todayDate + s;
        System.out.println(todayDate);
        System.out.println(s);
        System.out.println(str);
    }

    @Test
    public void md5() {
        String md5 = SaSecureUtil.md5(PASSWORD);
        System.out.println(md5);
    }


}
