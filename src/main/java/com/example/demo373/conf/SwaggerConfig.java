package com.example.demo373.conf;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujiaxing
 * <p>
 * 使用Swagger2只需三步
 * 1、导入Swaggerr依赖
 * 2、配置Docket的bean
 * 3、使用@Api等注解修饰
 * </p>
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket getUserDocket(){
        ApiInfo apiInfo=new ApiInfoBuilder()
                .title("用户管理")//api标题
                .description("用户管理相关接口描述")//api描述
                .version("1.0.0")//版本号
                .contact("sabre")//本API负责人的联系信息
                .build();
        return new Docket(DocumentationType.SWAGGER_2)//文档类型（swagger2）
                .apiInfo(apiInfo)//设置包含在json ResourceListing响应中的api元信息
                .select()//启动用于api选择的构建器
                .apis(RequestHandlerSelectors.basePackage("com.example.demo373.controller"))
                .paths(PathSelectors.any())//路径过滤器（扫描所有路径）
                .build();
    }
}
