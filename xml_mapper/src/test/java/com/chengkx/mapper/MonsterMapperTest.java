package com.chengkx.mapper;

import com.chengkx.entity.monster;
import com.chengkx.util.MonsterUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

// 测试
public class MonsterMapperTest {

    private SqlSession sqlSession;
    private MonsterMapper monsterMapper;

    // before注释表示：在进行任何测试之前，先对下面的代码进行初始化
    @Before
    public void init() throws Exception{

        sqlSession = MonsterUtil.getSqlSession();

        monsterMapper = sqlSession.getMapper(MonsterMapper.class);
    }

    @Test
    public void findMonsterByNameORId(){

        monster monster = new monster();
        monster.setId(10);
        monster.setName("ccc");

        List<monster> monsters = monsterMapper.findMonsterByNameORId(monster);

        for (monster m : monsters) {
            System.out.println(m);
        }
        if (sqlSession != null) {

            sqlSession.close();
        }

        System.out.println("查找结束~");
    }

    @Test
    public void findMonsterByName(){

        List<monster> monsterList = monsterMapper.findMonsterByName("chengkx");

        for (monster m : monsterList) {
            System.out.println(m);
        }

        if (sqlSession != null) {
            sqlSession.close();
        }
        System.out.println("查询结束~");
    }

    // 通过map入参
    @Test
    public void findMonsterByIdAndSalary_PrameterHashMap(){

        Map<String, Object> map = new HashMap<>();
        map.put("id", 5);
        map.put("salary", 10000);

        List<monster> monsters
                = monsterMapper.findMonsterByIdAndSalary_PrameterHashMap(map);

        for (monster m : monsters) {
            System.out.println(m);
        }
        if (sqlSession != null) {
            sqlSession.close();
        }
        System.out.println("查询成功~");
    }

    @Test
    public void findMonsterByIdAndSalary_PrameterHashMap_ReturnHashMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("id", 5);
        map.put("salary", 10000);

        List<Map<String, Object>> monsterMap
                = monsterMapper.findMonsterByIdAndSalary_PrameterHashMap_ReturnHashMap(map);

//         方法一
//        for (Map<String, Object> m : monsterMap) {
//            //System.out.println(m);
//            //输出结果 m的形式
//            /*
//            {birthday=2022-06-06, gender=1, name=chengchengcheng, id=6, salary=30000.0, age=200, email=gaoyushi@qq.com}
//            {birthday=2024-11-12, gender=0, name=chengkx0021, id=9, salary=10001.0, age=11, email=ckx5143002@163.com}
//            {birthday=2024-11-12, gender=0, name=chengkx0022, id=10, salary=10002.0, age=12, email=ckx5143002@163.com}
//            {birthday=2024-11-12, gender=0, name=chengkx009, id=11, salary=100000.0, age=100, email=ckx51427273002@163.com}
//            {birthday=2024-11-12, gender=0, name=chengkx009, id=12, salary=100000.0, age=100, email=ckx51427273002@163.com}
//             */
//            //现在要把monster从map中取出来
//            Set<String> keys = m.keySet();
//            for (String key : keys) {
//                System.out.println(key + "-" + m.get(key));
//            }
//            System.out.println("================================");
//        }

        // 方法二
        for (Map<String, Object> m : monsterMap) {
            for (Map.Entry<String, Object> entry: m.entrySet()){
                System.out.println(entry.getKey() + "-" + entry.getValue());
            }
            System.out.println("================================");
        }
        if (sqlSession != null) {
            sqlSession.close();
        }
        System.out.println("查询成功~");
    }

}

