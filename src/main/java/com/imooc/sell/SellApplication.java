package com.imooc.sell;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author panshao
 */
@SpringBootApplication
@EnableJpaAuditing
@MapperScan(value = "com.imooc.sell.dataobject.mapper")
public class SellApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellApplication.class, args);
    }

}
