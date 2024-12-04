package com.chengkx;

import com.chengkx.entity.Person;
import com.chengkx.mapper.PersonMapper;
import com.chengkx.util.MonsterUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

public class idenCardTest {

    private SqlSession sqlSession;
    private PersonMapper personMapper;


    @Before
    public void init(){

        sqlSession = MonsterUtil.getSqlSession();
        personMapper = sqlSession.getMapper(PersonMapper.class);
    }

    // 通过查找person，来级联查询idcard，不是直接查找idcard
    @Test
    public void getPersonById(){
        Person person = personMapper.getPersonById(1);

        System.out.println(person);
        if (sqlSession != null) {
            sqlSession.close();
        }
        System.out.println("查询成功~~~");
    }

    @Test
    public void getPersonById2(){
        Person person = personMapper.getPersonById2(1);

        System.out.println(person);
        if (sqlSession != null) {
            sqlSession.close();
        }
        System.out.println("查询成功~~~");
    }

}
