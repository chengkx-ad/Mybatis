package com.chengkx.mapper;

import com.chengkx.entity.User;
import com.chengkx.util.MonsterUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    private SqlSession sqlSession;
    private UserMapper userMapper;

    // before注释表示：在进行任何测试之前，先对下面的代码进行初始化
    @Before
    public void init() throws Exception{

        sqlSession = MonsterUtil.getSqlSession();

        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void addUser(){

        User user = new User();
        user.setUseremail("cckx5143@163.com");
        user.setUsername("成凯璇");

        userMapper.addUser(user);
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
        System.out.println("添加成功~~~");
    }

    @Test
    public void findAllUser(){

        List<User> users = userMapper.findAllUser();
        for (User user : users) {
            System.out.println("user" + user);
        }

        if (sqlSession != null) {
            sqlSession.close();
        }
        System.out.println("查询成功~~~");
    }
}
