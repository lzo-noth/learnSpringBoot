package com.lzo.springboot.controller;

import com.lzo.springboot.bean.Department;
import com.lzo.springboot.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {
    @Autowired
    DepartmentMapper departmentMapper;
    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        return departmentMapper.selectById(id);
    }
    @GetMapping("/dept")
    public Department insertDept(Department department){
           departmentMapper.save(department);
           return department;
    }
}
