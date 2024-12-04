package com.chengkx.mapper;

import com.chengkx.entity.monster;
import com.chengkx.util.MonsterUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

// 测试
public class MonsterMapperTest {

    private SqlSession sqlSession;
    private MonsterMapper monsterMapper;

    // before注释表示：在进行任何测试之前，先对下面的代码进行初始化
    @Before
    public void init() throws Exception{

        // 获取sqlsession
        sqlSession = MonsterUtil.getSqlSession();
        // 获取mapper对象
        // 注意：这里monsterMapper是一个接口，怎么实例化呢? 使用接口类型来反射获取对象 类似于spring
        //动态代理机制  这里的monsterMapper是一个代理对象
        monsterMapper = sqlSession.getMapper(MonsterMapper.class);
        System.out.println("monsterMapper" + monsterMapper.getClass());
    }


    @Test
    public void addMonster(){
        monster monster = new monster();
        for (int i = 0; i < 3; i++) {
            monster.setName("chengkx002" + i);
            monster.setAge(10 + i);
            monster.setBirthday(new Date());
            monster.setEmail("ckx5143002@163.com");
            monster.setGender(0);
            monster.setSalary(10000 + i);
            monsterMapper.addMonster(monster);
            System.out.println(monster);
            // 设置了useGeneratedKeys="true" keyProperty="id"后，就可以返回自增长的id
            Integer id = monster.getId();
            System.out.println(id);
        }
        // 如果是增删改，需要手动提交事务 默认是不提交的
        if (sqlSession != null) {
            sqlSession.commit();
            // 这里的close并不是真正的关闭连接，而是将连接返回到连接池中
            sqlSession.close();
        }
        System.out.println("数据已保存~~~~");
    }

    @Test
    public void delMonster() {
        monsterMapper.delMonster(8);
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
        System.out.println("删除 ok");
    }

    @Test
    public void updateMonster(){
        monster monster = new monster();
        monster.setAge(200);
        monster.setBirthday(new Date());
        monster.setEmail("ckx@sohu.com");
        monster.setGender(1);
        monster.setName("狐狸精");
        monster.setSalary(9234);
        monster.setId(1);
        monsterMapper.updateMonster(monster);

        if (sqlSession != null) {
            sqlSession.commit();
            // 这里的close并不是真正的关闭连接，而是将连接返回到连接池中
            sqlSession.close();
        }
        System.out.println("数据已更新~~~~");
    }

    @Test
    public void getMonsterById(){
        monster monster = monsterMapper.getMonsterById(2);
        System.out.println(monster);

        if (sqlSession != null) {
            sqlSession.commit();
            // 这里的close并不是真正的关闭连接，而是将连接返回到连接池中
            sqlSession.close();
        }
        System.out.println("数据已找到~~~~");
    }

    @Test
    public void findAllMonster(){
        List<monster> allMonster = monsterMapper.findAllMonster();
        System.out.println(allMonster);

        if (sqlSession != null) {
            sqlSession.commit();
            // 这里的close并不是真正的关闭连接，而是将连接返回到连接池中
            sqlSession.close();
        }
        System.out.println("所有的monster已全部找到~~~~");
    }
}

