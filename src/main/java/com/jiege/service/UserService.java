package com.jiege.service;

import com.jiege.mapper.UserMapper;
import com.jiege.pojo.User;
import com.jiege.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    SqlSessionFactory factory =SqlSessionFactoryUtils.getSqlSessionFactory();
    public User login(String username, String password){
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.select(username, password);
        sqlSession.close();
        return user;
    }
    public boolean register(User user){
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = mapper.selectByUsername(user.getUsername());
        if(user1 == null ){
            mapper.add(user);
            sqlSession.commit();
        }
        sqlSession.close();
        return user1 == null;
    }
}
