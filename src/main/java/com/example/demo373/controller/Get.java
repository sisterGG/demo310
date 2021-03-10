package com.example.demo373.controller;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.example.demo373.tool.Dbtool;
import com.example.demo373.dao.IUserDao;
import com.example.demo373.entity.User;
import com.example.demo373.tool.Obj2List;
import com.example.demo373.tool.ObjectUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

@Controller

public class Get {

    @GetMapping( "/gettest")
    public String hello2(Model model) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Dbtool dbt=new Dbtool("SqlMapConfig.xml");
        IUserDao userDao= dbt.getSession().getMapper(IUserDao.class);



        List<User> users = userDao.findAll();
         String json1 = JSON.toJSONString(users);
        String s1 = JSONUtil.toJsonStr(users);
        System.out.println("s1= "+s1);
        String s="";
        User u=null;
        for (User user :
                users) {
            System.out.println("hhaha");

            System.out.println(user);
            s=s+user.toString();
            u=user;
        }
        dbt.close();

        Obj2List obj2List=new Obj2List(u);
        System.out.println( obj2List.getkeys());

        System.out.println( obj2List.gettypes());
        System.out.println( obj2List.getvalues());



//        Field[] field = u.getClass().getDeclaredFields();
//        List<String> key_list=new ArrayList<String>();
//        List<String> type_list=new ArrayList<String>();
////
//        for(int j=0 ; j<field.length ; j++){
//             key_list.add(field[j].getName());
//             type_list.add(field[j].getGenericType().toString());
//
//        }
//        System.out.println(key_list+" type: "+type_list);



        model.addAttribute(users);
        model.addAttribute("hellothy",s);
        System.out.println(json1);
        model.addAttribute("json1",json1);
        model.addAttribute("user",users.get(0));
        model.addAttribute("date",new Date());




        return "keytest";
    }
}
