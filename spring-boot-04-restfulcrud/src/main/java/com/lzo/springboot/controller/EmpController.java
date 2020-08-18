package com.lzo.springboot.controller;

import com.lzo.springboot.dao.DepartmentDao;
import com.lzo.springboot.dao.EmployeeDao;
import com.lzo.springboot.entities.Department;
import com.lzo.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmpController {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;
    @RequestMapping("/emps")
    public String list(Model model){
        //classpath:/templates/xxx.html
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //准备部门下拉框数据
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/add";
    }
    @PostMapping("/emp")
    /**springMVC自动将请求参数和入参对象的属性一一绑定;
     *要求请求参数的名字和javaBean入参的对象名的属性一样
     * */
    public String addEmp(Employee employee){
        System.out.println(employee);
        //模拟添加到数据库
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        //准备部门下拉框数据
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("emp", employee).addAttribute("departments", departments);
        return "/emp/edit";
    }
    @PutMapping("/emp")
    public String update(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    @DeleteMapping("/emp/{id}")
    public String delete(@PathVariable Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
