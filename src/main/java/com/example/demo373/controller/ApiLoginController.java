package com.example.demo373.controller;

import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujiaxing
 * @date 2019-07-07
 */
@Api(tags = "登录接口")
@RequestMapping("/api")
@RestController
public class ApiLoginController {



    @RequestMapping("/login")
//    @ApiOperation("登录")
    public R login(@RequestBody  String s) {

        Map m1 = new HashMap();
        m1.put("Zara", "8");
        m1.put("Mahnaz", "31");
        m1.put("Ayan", "12");
        m1.put("Daisy", "14");

        return R.ok(m1);
    }



}