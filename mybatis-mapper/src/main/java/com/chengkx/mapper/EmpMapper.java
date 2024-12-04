package com.chengkx.mapper;

import com.chengkx.entity.Emp;

import java.util.List;

public interface EmpMapper {

    public List<Emp> getEmpsByDeptId(Integer deptId);

    public Emp getEmpById(Integer id);

}
