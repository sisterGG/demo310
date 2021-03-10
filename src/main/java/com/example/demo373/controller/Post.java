package com.example.demo373.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo373.entity.User;
import com.example.demo373.model.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//@Controller
@RestController

public class Post {
    @Autowired
    private Cat cat;


    @PostMapping("/posttest")
    public String result(@RequestBody String jsons) {
        System.out.println("post received");
        System.out.println(jsons);
        User user1 = JSON.parseObject(jsons, User.class);

        System.out.println(user1.getName()+user1.getPid());


        int i=2;
        if (i>1){
            return "success";
        }else{
            return "sorry";

        }
    }

    @PostMapping("/posttestmul")
    public String resultmul(@RequestBody String jsons) {
        System.out.println("post received");
        System.out.println(jsons);
//        User user1 = JSON.parseObject(jsons, User.class);
//        System.out.println(user1.getName()+user1.getPid());
        List<User> users = JSON.parseArray(jsons, User.class);
        for (User u : users){
            System.out.println(u.getName()+u.getPid());

        }

        int i=2;
        if (i>1){
            return "success";
        }else{
            return "sorry";

        }
    }

}