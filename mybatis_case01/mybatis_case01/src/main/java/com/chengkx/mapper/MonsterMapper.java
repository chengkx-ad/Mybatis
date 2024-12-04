package com.chengkx.mapper;


import com.chengkx.entity.monster;
import java.util.List;

public interface MonsterMapper {

    // 下面的各种方法，就是对数据库表的各种操作，通过获取MonsterMapper对象操作数据库

    // 添加monster
    public void addMonster(monster monster);

    // 删除monster
    public void delMonster(Integer id);

    // 更新monster
    public void updateMonster(monster monster);

    //查询-根据 id
    public monster getMonsterById(Integer id);

    //查询所有的 Monster
    public List<monster> findAllMonster();
}
