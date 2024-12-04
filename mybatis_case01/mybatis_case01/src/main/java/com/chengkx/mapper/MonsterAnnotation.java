package com.chengkx.mapper;

// 使用注解的方式配置

import com.chengkx.entity.monster;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MonsterAnnotation {

    // 添加monster
    @Insert("INSERT INTO monster (`age`, `birthday`, `email`, `gender`, `name`, `salary`)" +
            "VALUES (#{age}, #{birthday}, #{email}, #{gender}, #{name}, #{salary})")
    // 这个注解的意思是使用注解的方式返回自增长的id，其实和xml方式一个道理
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public void addMonster(monster monster);

    @Delete("DELETE FROM `monster`" +
            "WHERE id=#{id}")
    public void delMonster(Integer id);

    @Update("UPDATE `monster`" +
    "SET `age`=#{age},`birthday`=#{birthday},`email`=#{email},`gender`=#{gender},`name`=#{name},`salary`=#{salary}" +
    "WHERE id=#{id}")
    public void updateMonster(monster monster);

    @Select("SELECT * FROM `monster`\n" +
            "WHERE id=#{id}")
    public monster getMonsterById(Integer id);

    @Select("SELECT * FROM `monster`")
    public List<monster> findAllMonster();
}
