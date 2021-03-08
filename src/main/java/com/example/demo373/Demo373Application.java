package com.example.demo373;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@MapperScan("com.example.demo373.mapper")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, MybatisPlusAutoConfiguration.class})
 public class Demo373Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo373Application.class, args);
    }

}
