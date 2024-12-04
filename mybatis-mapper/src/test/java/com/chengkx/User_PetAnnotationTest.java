package com.chengkx;

import com.chengkx.entity.Pet;
import com.chengkx.entity.User;
import com.chengkx.mapper.PetMapper;
import com.chengkx.mapper.PetMapperAnnotation;
import com.chengkx.mapper.UserMapper;
import com.chengkx.mapper.UserMapperAnnotation;
import com.chengkx.util.MonsterUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class User_PetAnnotationTest {

    private SqlSession sqlSession;
    private PetMapperAnnotation petMapperAnnotation;
    private UserMapperAnnotation userMapperAnnotation;

    @Before
    public void init(){

        sqlSession = MonsterUtil.getSqlSession();

        petMapperAnnotation = sqlSession.getMapper(PetMapperAnnotation.class);
        userMapperAnnotation = sqlSession.getMapper(UserMapperAnnotation.class);
    }

    @Test
    public void getUserById(){

        User user = userMapperAnnotation.getUserById(1);
        System.out.println("用户信息：" + user.getId() + "--" + user.getName());

        List<Pet> pets = user.getPets();
        for (Pet pet : pets) {
            System.out.println("宠物信息：" + pet.getId() + "--" + pet.getName());
        }

        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    @Test
    public void getPetById(){

        Pet pet = petMapperAnnotation.getPetById(4);
        System.out.println("查找的宠物信息：" + pet.getId() + "---" + pet.getName());
        User user = pet.getUser();
        System.out.println("该宠物的用户为：" + user.getId() + "---" + user.getName());

        if (sqlSession != null) {
            sqlSession.close();
        }
    }

}
