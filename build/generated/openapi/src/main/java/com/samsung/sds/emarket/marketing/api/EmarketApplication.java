package com.samsung.sds.emarket.marketing.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.samsung.sds.emarket.marketing.api.repository")
public class EmarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmarketApplication.class, args);
    }

}
