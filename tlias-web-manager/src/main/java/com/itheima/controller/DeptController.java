package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping("/depts")
    public Result get(){
         List<Dept> deptList=deptService.findAll();
         return Result.success(deptList);
    }

//    @DeleteMapping("/depts")
//    public Result delete(HttpServletRequest request){
//        String params =request.getParameter("id");
//        int id=Integer.parseInt(params);
//        System.out.println("删除id为"+id+"的部门");
//        return Result.success();
//    }

//    方式二：通过RequestParam注解来实现
//    @DeleteMapping("/depts")
//    public Result delete(@RequestParam("id") Integer id){
//        System.out.println("删除id为"+id+"的部门");
//        return Result.success();
//    }

    //方式三：若名字相同，则@Params可以省略
    @DeleteMapping("/depts")
    public Result delete(Integer id){
        System.out.println("删除id为"+id+"的部门");
        return Result.success();
    }

}
