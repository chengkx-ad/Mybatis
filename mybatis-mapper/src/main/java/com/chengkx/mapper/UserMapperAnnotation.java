package com.chengkx.mapper;

import com.chengkx.entity.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserMapperAnnotation {
    @Select("SELECT * FROM mybatis_user WHERE id=#{id}")
    @Results({
            @Result(id=true,property="id",column="id"),
            @Result(property="name",column="name"),
            @Result(property="pets",column="id",
         many = @Many(select="com.chengkx.mapper.PetMapperAnnotation.getPetsByUserId")),
    })
    public User getUserById(Integer id);
}
