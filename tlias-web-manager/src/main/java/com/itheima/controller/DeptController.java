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
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    //查
    @GetMapping("/depts")
    public Result get(){
         List<Dept> deptList=deptService.findAll();
         return Result.success(deptList);
    }

    //删
    @DeleteMapping("/depts")
    public Result delete(Integer id){
        deptService.deleteById(id);
        return Result.success();
    }

    //增
    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept){
        deptService.add(dept);
        return Result.success();
    }

    //改
    //数据回显
    @GetMapping("/depts/{id}")
    public Result getById(@PathVariable Integer id){
        System.out.println(id);
        Dept dept=deptService.getById(id);
        return Result.success(dept);
    }

}
