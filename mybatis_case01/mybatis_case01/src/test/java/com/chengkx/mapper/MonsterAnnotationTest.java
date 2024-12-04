package com.chengkx.mapper;


import com.chengkx.entity.monster;
import com.chengkx.util.MonsterUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import javax.sound.midi.SoundbankResource;
import java.util.Date;

public class MonsterAnnotationTest {

    private SqlSession sqlSession;

    @Before
    public void init(){

        sqlSession = MonsterUtil.getSqlSession();

    }

    @Test
    // 添加monster
    public void addMonster(){
        monster monster = new monster();
        monster.setName("chengkx009");
        monster.setAge(100);
        monster.setBirthday(new Date());
        monster.setEmail("ckx51427273002@163.com");
        monster.setGender(0);
        monster.setSalary(100000);

        MonsterAnnotation monsterAnnotation = sqlSession.getMapper(MonsterAnnotation.class);

        monsterAnnotation.addMonster(monster);

        if (sqlSession != null) {

            sqlSession.commit();
            sqlSession.close();
        }

        System.out.println("monster添加成功~~~");
    }
}
