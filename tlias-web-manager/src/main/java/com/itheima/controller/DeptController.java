package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    //查
    @GetMapping
    public Result get(){
         List<Dept> deptList=deptService.findAll();
         log.info("查询所有部门"+deptList);
         return Result.success(deptList);
    }

    //删
    @DeleteMapping
    public Result delete(Integer id){
        deptService.deleteById(id);
        log.info("删除id为"+id+"的部门");
        return Result.success();
    }

    //增
    @PostMapping
    public Result add(@RequestBody Dept dept){
        deptService.add(dept);
        log.info("新增部门"+dept);
        return Result.success();
    }

    //改
    //数据回显
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Dept dept=deptService.getById(id);
        return Result.success(dept);
    }

    //修改数据
    @PutMapping
    public Result update(@RequestBody Dept dept){
        deptService.update(dept);
        log.info("更新部门为"+dept);
        return Result.success();
    }
}
