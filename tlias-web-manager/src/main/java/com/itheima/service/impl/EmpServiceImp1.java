package com.itheima.service.impl;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageResult;
import com.itheima.service.EmpService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImp1 implements EmpService {
    private EmpMapper empMapper;

    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        Integer start = (page-1)*pageSize;
        List<Emp> empList=empMapper.list(start,pageSize);
        Long count =empMapper.count();

        return new PageResult<>(count,empList);
    }
}
