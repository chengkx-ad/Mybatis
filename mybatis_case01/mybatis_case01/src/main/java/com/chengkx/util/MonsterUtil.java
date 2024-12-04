package com.chengkx.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 工具类  用于获取sqlSession
 */

public class MonsterUtil {

    private static SqlSessionFactory sqlSessionFactory;

    // 只执行一次 类加载时执行
    static {
        try {
            // 指定资源文件
            String resource = "mybatis-config.xml";
            //获取资源文件对应的数据流
            InputStream resourceAsStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            System.out.println("sqlSessionFactory" + sqlSessionFactory.getClass());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //编写方法获取sqlSession
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

}
