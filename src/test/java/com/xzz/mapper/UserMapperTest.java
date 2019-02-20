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
import java.util.Iterator;
import java.util.List;

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

    @Test
    public void findAllUser() {
        List<User> list = mapper.findAllUser();
        Iterator<User> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}