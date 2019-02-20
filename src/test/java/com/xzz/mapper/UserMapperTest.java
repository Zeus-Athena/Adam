package com.xzz.mapper;

import com.xzz.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class UserMapperTest {
    private UserMapper mapper = null;
    @Before
    public void init() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream in = Resources.getResourceAsStream("mybatis-Config.xml");
        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(in);
        SqlSession session = factory.openSession();
        mapper = session.getMapper(UserMapper.class);
    }

    @Test
    public void findUSer() {
        User user = mapper.findUserById(1);
        System.out.println(user);
    }
}