package com.example.bishe;

import com.example.bishe.mapper.UserMapper;
import com.example.bishe.model.entity.User;
import com.example.bishe.service.UserService;
import com.example.bishe.util.SendSmsUtil;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


@SpringBootTest
class BisheApplicationTests {

    @Resource
    private SendSmsUtil sendSmsUtil;

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




}
