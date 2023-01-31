package com.sk.userman;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sk.userman.mapper")
public class UsermanApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsermanApplication.class, args);
        System.out.println("接口文档：http://localhost:8080/swagger-ui.html");
    }

}
