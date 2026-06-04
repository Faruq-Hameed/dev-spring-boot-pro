package com.luv2code.springboot.empoyeemanagement.dao;

import com.luv2code.springboot.empoyeemanagement.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    @Override
    public List<Employee> findAll() {
        return List.of();
    }
}
