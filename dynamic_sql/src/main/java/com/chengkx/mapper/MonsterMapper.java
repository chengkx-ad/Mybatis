package com.chengkx.mapper;


import com.chengkx.entity.monster;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MonsterMapper {

    // 下面的各种方法，就是对数据库表的各种操作，通过获取MonsterMapper对象操作数据库

    public List<monster> findMonsterByAge(@Param(value = "age") Integer age);

    public  List<monster> findMonsterByIdAndName(monster monster);

    public List<monster> findMonsterByIdOrName(Map<String, Object> map);

    public List<monster> findMonsterById(Map<String, Object> map);

    public void updateMonster(Map<String, Object> map);
}
