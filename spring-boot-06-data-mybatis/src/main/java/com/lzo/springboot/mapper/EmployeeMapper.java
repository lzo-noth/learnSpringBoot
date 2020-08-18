package com.lzo.springboot.mapper;

import com.lzo.springboot.bean.Employee;

import java.util.List;

public interface EmployeeMapper {
    List<Employee> selectAll();

    int save(Employee employee);
}
