package com.chengkx.mapper;

import com.chengkx.entity.Person;

public interface PersonMapper {

    // 查找操作
    public Person getPersonById(Integer id);

    public Person getPersonById2(Integer id);

}
