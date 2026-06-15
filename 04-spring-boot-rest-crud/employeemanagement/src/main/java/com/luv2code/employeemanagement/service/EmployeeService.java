package com.luv2code.employeemanagement.service;

import com.luv2code.employeemanagement.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();

    public Employee findById(int id);

    public Employee save(Employee employee);

//    public Employee update(Employee employee);

    public void delete(int id);

}
