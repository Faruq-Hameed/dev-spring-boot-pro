package com.luv2code.employeemanagement.dao;

import com.luv2code.employeemanagement.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();

    public Employee findById(int id);

    public Employee save(Employee employee);

//    public Employee update(Employee theEmployee);

    public void delete(int id);
}
