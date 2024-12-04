package com.chengkx.mapper;

// 输入部门id，找到对应的部门，以及部门内的所有员工
// 反过来，输入一个员工id应该返回该员工的信息，以及所在的部门信息

import com.chengkx.entity.Dept;

public interface DeptMapper {

    public Dept getDeptById(Integer id);
}
