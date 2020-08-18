package com.lzo.springboot.controller;

import com.lzo.springboot.bean.Employee;
import com.lzo.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmploController {

    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping("/emp/list")
    public List<Employee> getALl() {
        return employeeMapper.selectAll();
    }

    @GetMapping("/emp/{id}")
    public Employee save(Employee employee) {
        employeeMapper.save(employee);
        return employee;
    }
}