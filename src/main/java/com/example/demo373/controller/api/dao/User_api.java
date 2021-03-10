package com.example.demo373.controller.api.dao;



import com.alibaba.fastjson.JSON;
import com.example.demo373.dao.IUserDao;
import com.example.demo373.entity.User;
import com.example.demo373.model.Cat;
import com.example.demo373.tool.Dbtool;
import com.example.demo373.tool.Obj2List;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Controller
@RestController
@RequestMapping("/api/dao")
@Api(tags = "登录接口")
public class User_api {
    @Autowired
    private Cat cat;
    @ResponseBody
    @RequestMapping(value = "/User_api",method = RequestMethod.GET)
    @ApiOperation("登录")
    public String hello() throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        User u=new User();
        Obj2List obj2List=new Obj2List(u);
        Map<String,List<String>> map=new HashMap<String,List<String>>();
        map.put("keys",obj2List.getkeys());
        map.put("types",obj2List.gettypes()        );
        String json1 = JSON.toJSONString(map);
        return json1;
    }

}