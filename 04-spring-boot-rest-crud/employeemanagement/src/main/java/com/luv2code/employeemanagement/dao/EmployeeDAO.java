package com.luv2code.employeemanagement.dao;

import com.luv2code.employeemanagement.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();
}
