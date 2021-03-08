package com.example.demo373.controller;

import com.example.demo373.model.Cat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//@Controller
@RestController
@RequestMapping("/hello")
@Api(tags = "登录接口")
  public class hello {
    @Autowired
    private Cat cat;

    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    @ApiOperation("登录")
    public String hello(){
        System.out.println(cat);

        return "pros";
    }

}