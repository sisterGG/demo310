package com.example.demo373;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.example.demo373.mapper")
@SpringBootApplication
public class Demo373Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo373Application.class, args);
    }

}
