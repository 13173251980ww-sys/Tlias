package com.itheima.mapper;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageResult;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmpMapper {

    //查看总记录数
    @Select("select count(*) from emp e left join dept d on e.dept_id =d.id")
    public Long count();

    //分页查询
    @Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id = d.id limit #{start},#{pageSize}")
    public List<Emp> list(Integer start, Integer limit);
}
