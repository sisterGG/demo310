package com.example.demo373.tool;
import com.example.demo373.dao.IUserDao;
import com.example.demo373.entity.User;
import com.zaxxer.hikari.HikariDataSource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.apache.catalina.Session;
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
@Data
public class Dbtool {
    InputStream in;
    SqlSessionFactoryBuilder builder;
    SqlSessionFactory factory;
    SqlSession session;


    public  Dbtool(String sqlMapConfig_xml) throws IOException{
        this.in = Resources.getResourceAsStream(sqlMapConfig_xml);
        this.builder = new SqlSessionFactoryBuilder();
        this.factory = builder.build(in);
        this.session = factory.openSession();

    }
    public void close() throws IOException {

        this.session.close();
        this.in.close();
    }

}
