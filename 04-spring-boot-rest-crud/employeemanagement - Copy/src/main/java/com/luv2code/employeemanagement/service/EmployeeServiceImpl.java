package com.luv2code.employeemanagement.service;

import com.luv2code.employeemanagement.dao.EmployeeDAO;
import com.luv2code.employeemanagement.entity.Employee;
import com.luv2code.employeemanagement.rest.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO;

    //constructor with auto wired injection
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        Employee employee = this.employeeDAO.findById(id);
        if(employee == null){
            throw new EmployeeNotFoundException("Employee with id " + id + " not found");
        }
        return employee;
    }

    @Override
    @Transactional//best to be used in service level not dao
    public Employee save(Employee employee) {
        return this.employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public Employee update(Employee employee) {
        //confirm the employee existence
        this.findById(employee.getId());
        return this.employeeDAO.update(employee);
    }

    @Override
    @Transactional
    public void delete(int id) {
        this.employeeDAO.delete(id);
//        return null;
    }

}
