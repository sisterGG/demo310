package com.example.demo373.test;

import com.example.demo373.dao.IUserDao;

import com.example.demo373.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author ：
 * @date ：Created in 2019/11/8 10:12
 * @description ： 入门案例
 */
public class MybatisTest {
    /**
     * @author      ：
     * @description ：入门案例
     * @param       : [args]
     * @return      : void
     * @date        ：Created in 2019/11/8
     */
    public static void main(String[] args) throws Exception {
        //1.读取配置文件
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
        for (User user :
                users) {
            System.out.println("hhaha");

            System.out.println(user);
        }

        //6.释放资源
        session.close();
        in.close();

    }
}
