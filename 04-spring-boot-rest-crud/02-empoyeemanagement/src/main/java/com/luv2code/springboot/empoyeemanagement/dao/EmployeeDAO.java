package com.luv2code.springboot.empoyeemanagement.dao;

import com.luv2code.springboot.empoyeemanagement.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
