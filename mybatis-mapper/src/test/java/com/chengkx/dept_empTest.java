package com.chengkx;

import com.chengkx.entity.Dept;
import com.chengkx.entity.Emp;
import com.chengkx.mapper.DeptMapper;
import com.chengkx.mapper.EmpMapper;
import com.chengkx.util.MonsterUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class dept_empTest {

    private SqlSession sqlSession;
    private DeptMapper deptMapper;
    private EmpMapper empMapper;

    @Before
    public void init(){

        sqlSession = MonsterUtil.getSqlSession();
        deptMapper = sqlSession.getMapper(DeptMapper.class);
        empMapper = sqlSession.getMapper(EmpMapper.class);
    }

    @Test
    public void getDeptById(){

        Dept dept = deptMapper.getDeptById(2);
        System.out.println("查询到的部门信息：" + dept.getId() + "--" + dept.getName());

        List<Emp> emps = dept.getEmps();
        for (Emp emp : emps) {
            System.out.println("该部门的所有员工：" + emp.getId() + "--" + emp.getName());
        }

        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    @Test
    public void getEmpById(){
        Emp emp = empMapper.getEmpById(5);
        System.out.println("查询的员工信息为：" + emp.getId() + "--" + emp.getName());

        Dept dept = emp.getDept();
        System.out.println("该员工所在的部门为：" + dept.getId() + "--" + dept.getName());

        if (sqlSession != null) {
            sqlSession.close();
        }
    }
}
