package com.example.bishe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.bishe.mapper")
public class BisheApplication {

    public static void main(String[] args) {
        SpringApplication.run(BisheApplication.class, args);
    }

}
