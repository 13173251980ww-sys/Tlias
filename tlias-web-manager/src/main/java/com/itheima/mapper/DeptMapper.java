package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Mapper
public interface DeptMapper {
    //方法1:Result映射
    //方法2:select起别名
    //方法3:配置文件中打开mybatis驼峰转换
    @Select("select * from dept order by update_time desc")
    public List<Dept> findAll();

    @Delete("delete from dept where id= #{id}")
    void deleteById(Integer id);

    @Insert("INSERT into dept(name, create_time, update_time) values (#{name},#{createTime},#{updateTime})")
    void add(Dept dept);

    @Select("select * from dept where id = #{id}")
    public Dept getById(Integer id);

    @Update("update dept set name =#{name},update_time =#{updateTime} where id= #{id}")
    void update(Dept dept);
}
