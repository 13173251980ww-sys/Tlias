package com.itheima.service;

import com.itheima.pojo.Dept;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DeptService {
    List<Dept> findAll();
}
