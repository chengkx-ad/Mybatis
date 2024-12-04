package com.chengkx.mapper;

import com.chengkx.entity.Pet;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PetMapperAnnotation {

    @Select("SELECT * FROM mybatis_pet WHERE user_id=#{userId}")
    @Results({
            @Result(id=true,property="id",column="id"),
            @Result(property="name",column="nickname"),
    })
    public List<Pet> getPetsByUserId(Integer userId);

    @Select("SELECT * FROM mybatis_pet WHERE id=#{id}")
    @Results({
            @Result(id = true,property="id",column="id"),
            @Result(property="name",column="nickname"),
            @Result(property="user",column="user_id",
            one = @One(select="com.chengkx.mapper.UserMapper.getUserById"))
    })
    public Pet getPetById(Integer id);
}
