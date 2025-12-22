package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {
    //方法1:Result映射
    //方法2:select起别名
    //方法3:配置文件中打开mybatis驼峰转换
    @Select("select * from dept order by update_time desc")
    public List<Dept> findAll();
}
