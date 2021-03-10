package com.example.demo373.controller.api;


import com.alibaba.fastjson.JSON;
import com.example.demo373.dao.IUserDao;
import com.example.demo373.entity.User;
import com.example.demo373.model.Cat;
import com.example.demo373.tool.Dbtool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

//@Controller
@RestController
@RequestMapping("/api")
@Api(tags = "登录接口")
public class First_api {
    @Autowired
    private Cat cat;
    @ResponseBody
    @RequestMapping(value = "/first_api",method = RequestMethod.GET)
    @ApiOperation("登录")
    public String hello() throws IOException {
         Dbtool dbt=new Dbtool("SqlMapConfig.xml");
         IUserDao userDao= dbt.getSession().getMapper(IUserDao.class);
         List<User> users = userDao.findAll();
         String json1 = JSON.toJSONString(users);
         return json1;
    }

}