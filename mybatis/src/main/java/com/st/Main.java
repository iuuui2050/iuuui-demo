package com.st;

import com.st.dao.UserDao;
import com.st.domain.User;
import jdk.nashorn.internal.runtime.UserAccessorProperty;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author iuuui
 * @time 2024/01/21 1403
 */
public class Main {

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setName("小红");
        user.setIntroduction("小红是个女孩");

        int i = sqlSession.insert("com.st.dao.UserDao.insert", user);
        System.out.println("insert result:" + (i > 0 ? "成功" : "失败"));

        List<User> list = sqlSession.selectList("com.st.dao.UserDao.select");
        System.out.println(list);

        UserDao userMapper = sqlSession.getMapper(UserDao.class);
        List<User> users = userMapper.select();
        System.out.println(users);

        sqlSession.commit();

        sqlSession.close();;
    }

}
