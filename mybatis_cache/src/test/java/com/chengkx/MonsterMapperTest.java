package com.chengkx;

import com.chengkx.entity.monster;
import com.chengkx.mapper.MonsterMapper;
import com.chengkx.util.MonsterUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

// 测试
public class MonsterMapperTest {

    private SqlSession sqlSession;
    private MonsterMapper monsterMapper;

    // before注释表示：在进行任何测试之前，先对下面的代码进行初始化
    @Before
    public void init(){

        // 获取sqlsession
        sqlSession = MonsterUtil.getSqlSession();
        // 获取mapper对象
        // 注意：这里monsterMapper是一个接口，怎么实例化呢? 使用接口类型来反射获取对象 类似于spring
        //动态代理机制  这里的monsterMapper是一个代理对象
        monsterMapper = sqlSession.getMapper(MonsterMapper.class);
    }


    @Test
    public void getMonsterById(){
        monster monster1 = monsterMapper.getMonsterById(2);
        System.out.println(monster1);
//        // 清理缓存
//        sqlSession.clearCache();

        monster monster2 = monsterMapper.getMonsterById(2);
        System.out.println(monster2);

        monster monster3 = monsterMapper.getMonsterById(2);
        System.out.println(monster3);

        if (sqlSession != null) {
            // 这里的close并不是真正的关闭连接，而是将连接返回到连接池中
            sqlSession.close();
        }
        System.out.println("数据已找到~~~~");
    }
}

