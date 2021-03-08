package com.example.demo373.controller;


import com.example.demo373.dao.IUserDao;
import com.example.demo373.entity.User;
import com.example.demo373.mapper.PersonMapper;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo373.dao.IUserDao;

import com.example.demo373.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@RestController
@RequestMapping


public class fuck {
    @Autowired
    private DataSource ds;
    private PersonMapper pmr;
    @RequestMapping(value = "/fuck",method = RequestMethod.GET)

    public String hello1(){
        System.out.println("hellofuck");
        System.out.println(ds   );
        System.out.println(pmr);
        return "hellofuck0088880";
    }
    @RequestMapping(value = "/fuck1",method = RequestMethod.GET)

    public List<User> hello2() throws IOException {
        System.out.println("hellofuck1");
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产一个SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建dao接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        String s="";
        User u=null;
        for (User user :
                users) {
            System.out.println("hhaha");

            System.out.println(user);
            s=s+user.toString();
            u=user;
        }

        //6.释放资源
        session.close();
        in.close();
        return users;
    }




}