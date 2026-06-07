package com.luv2code.springboot.empoyeemanagement.rest;

import com.luv2code.springboot.empoyeemanagement.dao.EmployeeDAO;
import com.luv2code.springboot.empoyeemanagement.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeController(EmployeeDAO theEmployeeDAO){
        this.employeeDAO = theEmployeeDAO;
    }

    //get all employees handler
    @GetMapping()
    public List<Employee> getAllEmployees (){
        return this.employeeDAO.findAll();
    }

}
