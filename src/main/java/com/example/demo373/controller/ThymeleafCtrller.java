package com.example.demo373.controller;

 import com.example.demo373.dao.IUserDao;
 import com.example.demo373.entity.User;
 import org.apache.ibatis.io.Resources;
 import org.apache.ibatis.session.SqlSession;
 import org.apache.ibatis.session.SqlSessionFactory;
 import org.apache.ibatis.session.SqlSessionFactoryBuilder;
 import org.springframework.stereotype.Controller;
 import org.springframework.ui.Model;
 import org.springframework.web.bind.annotation.*;

 import java.io.IOException;
 import java.io.InputStream;
 import java.util.Date;
 import java.util.List;
 import java.util.Map;

@Controller
public class ThymeleafCtrller {
    @GetMapping("pros")
    public String hello(@RequestParam(name = "idd", required = false) Integer id,
                        @RequestParam(name = "sxx", required = false) String sex,Model model){
        model.addAttribute("hellothy","hello horrac womenday"+" " +id+"  "+sex);


        return "pros";
    }




    @GetMapping("thy")
    public String hello1(Model model){
        model.addAttribute("hellothy","hello horrac");

        return "index";
    }
    @GetMapping("inserttest")
    public String inserttest(Model model) throws IOException {
        model.addAttribute("hellothy","hello horrac i am insert");
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession session = factory.openSession(true);
        IUserDao userDao = session.getMapper(IUserDao.class);
        User u= new User(9,"i am nine");
        User u1=new User(16,"i am 16");
        userDao.insert(u);
//        session.commit();
        session.close();
        in.close();
        return "inserttest";
    }


    @GetMapping("pros/{pid}")
    public String hello4(@PathVariable("pid")int pid,Model model){
        model.addAttribute("hellothy","hello horrac i am pros/1");
        pid=1;

        return "index";
    }

    @GetMapping( "/dt")

    public String hellodata(Model model) throws IOException {
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
        model.addAttribute(users);
        model.addAttribute("hellothy",s);
        model.addAttribute("user",users.get(0));
        model.addAttribute("date",new Date());

        return "hellothyem";
    }






}

