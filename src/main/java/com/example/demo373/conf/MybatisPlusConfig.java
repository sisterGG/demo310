//package com.example.demo373.conf;
//
//
//import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import  com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
//@Configuration
////扫描dao或者是Mapper接口
//@MapperScan("com.example.dome373.mapper*")
//public class MybatisPlusConfig {
//    /**
//     * mybatis-plus 分页插件
//     */
//
//    @Bean
//    public PaginationInterceptor paginationInterceptor() {
//        PaginationInterceptor page = new PaginationInterceptor();
//        page.setDialectType("mysql");
//        return page;
//    }
//
//
//}