package com.chengkx;

import com.chengkx.entity.Pet;
import com.chengkx.entity.User;
import com.chengkx.mapper.PetMapper;
import com.chengkx.mapper.UserMapper;
import com.chengkx.util.MonsterUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class User_PetTest {

    private SqlSession sqlSession;
    private PetMapper petMapper;
    private UserMapper userMapper;

    @Before
    public void init(){

        sqlSession = MonsterUtil.getSqlSession();

        petMapper = sqlSession.getMapper(PetMapper.class);
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void getUserById(){

        User user = userMapper.getUserById(2);
        System.out.println("user信息" + user.getId() + "---" + user.getName());

        List<Pet> pets = user.getPets();
        for (Pet p : pets) {
            System.out.println(p.getId() + "-" + p.getName());
        }

        if (sqlSession != null) {
            sqlSession.close();
        }
        System.out.println("666");
    }

    @Test
    public void getPetsByUserId(){

        List<Pet> pets = petMapper.getPetsByUserId(2);
        for (Pet pet : pets) {
            System.out.println("宠物信息：" + pet.getId() + "--" + pet.getName());
            User user = pet.getUser();
            System.out.println("主人信息：" + user.getName());
        }

        if (sqlSession != null) {
            sqlSession.close();
        }
        System.out.println("666");
    }

    @Test
    public void getPetById(){

        Pet pet = petMapper.getPetById(3);
        System.out.println("宠物信息：" + pet.getId() + "-" + pet.getName());
        User user = pet.getUser();
        System.out.println(user.getName());

        if (sqlSession != null) {
            sqlSession.close();
        }
        System.out.println("666");
    }
}
