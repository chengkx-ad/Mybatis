package com.chengkx.mapper;


import com.chengkx.entity.monster;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface MonsterMapper {

    // 下面的各种方法，就是对数据库表的各种操作，通过获取MonsterMapper对象操作数据库

    // 通过name或者id查找monster
    public List<monster> findMonsterByNameORId(monster monster);

    // 模糊查询 查找name中包含kai的记录
    public  List<monster> findMonsterByName(String name);

    // 通过hashmap入参进行查询(重点)
    public  List<monster> findMonsterByIdAndSalary_PrameterHashMap(Map<String, Object> map);

    // 通过hashmap入参，将最后的monster也以map的形式保存和输出
    public List<Map<String, Object>> findMonsterByIdAndSalary_PrameterHashMap_ReturnHashMap(Map<String, Object> map);

}
