package com.chengkx.mapper;

import com.chengkx.entity.monster;
import com.chengkx.util.MonsterUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

// 测试
public class MonsterMapperTest {

    private SqlSession sqlSession;
    private MonsterMapper monsterMapper;

    // before注释表示：在进行任何测试之前，先对下面的代码进行初始化
    @Before
    public void init() throws Exception{
        // 获取sqlsession
        sqlSession = MonsterUtil.getSqlSession();
        monsterMapper = sqlSession.getMapper(MonsterMapper.class);
    }

    @Test
    public void findMonsterByAge(){
        List<monster> monsters = monsterMapper.findMonsterByAge(-1);

        for (monster m : monsters) {
            System.out.println(m);
        }

        if (sqlSession != null) {
            sqlSession.close();
        }
        System.out.println("查询成功~");
    }

    @Test
    public void findMonsterByIdAndName(){
        monster monster = new monster();
        monster.setId(9);
        monster.setName("chengkx009");

        List<monster> monsters = monsterMapper.findMonsterByIdAndName(monster);

        for (monster m : monsters) {
            System.out.println(m);
        }

        if (sqlSession != null) {
            sqlSession.close();
        }
        System.out.println("查询成功~~~");
    }

    @Test
    public void findMonsterByIdOrName(){
        Map<String, Object> map = new HashMap<>();
        map.put("name", "狐狸精");

        List<monster> monsters = monsterMapper.findMonsterByIdOrName(map);
        for (monster m : monsters) {
            System.out.println(m);
        }

        if (sqlSession != null) {
            sqlSession.close();
        }
        System.out.println("查询成功！！！");
    }

    @Test
    public void findMonsterById(){

        Map<String, Object> map = new HashMap<>();
        map.put("ids", Arrays.asList(10,11,12));

        List<monster> monsters = monsterMapper.findMonsterById(map);

        for (monster m : monsters) {
            System.out.println(m);
        }
        System.out.println("查询成功~~~");
    }

    @Test
    public void updateMonster(){

        Map<String, Object> map = new HashMap<>();
        map.put("id", 6);
        map.put("age", 66);
        map.put("birthday", "2024-09-30");
        map.put("email", "cckx5143@qq.com");
        map.put("gender", 1);
        map.put("name", "ccc666");

        monsterMapper.updateMonster(map);
        if (sqlSession != null) {

            sqlSession.commit();
            sqlSession.close();
        }
        System.out.println("修改成功~~~");
    }
}

