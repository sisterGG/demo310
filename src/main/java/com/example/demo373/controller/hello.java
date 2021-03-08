package com.example.demo373.controller;

import com.example.demo373.model.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@Controller
//@RestController

public class hello {
    @Autowired
    private Cat cat;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)

    public String hello(){
        System.out.println(cat);

        return "pros";
    }

}