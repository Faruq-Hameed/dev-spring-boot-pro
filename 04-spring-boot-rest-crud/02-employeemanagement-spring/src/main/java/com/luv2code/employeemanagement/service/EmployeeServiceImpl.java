package com.luv2code.employeemanagement.service;

import com.luv2code.employeemanagement.dao.EmployeeDAO;
import com.luv2code.employeemanagement.dao.EmployeeRepository;
import com.luv2code.employeemanagement.entity.Employee;
import com.luv2code.employeemanagement.rest.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepo;
    private EmployeeDAO employeeDAO;
    private JsonMapper jsonMapper; //useful for partial updates

    //constructor with auto wired injection
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepo, EmployeeDAO employeeDAO, JsonMapper jsonMapper){
        this.employeeRepo = employeeRepo;
        this.employeeDAO = employeeDAO;
        this.jsonMapper =  jsonMapper;
    }

    @Override
    public List<Employee> findAll() {
//        return this.employeeDAO.findAll();
        return this.employeeRepo.findAll();

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

//    @Override
    @Transactional
    public Employee update( int id, Map<String, Object> patchData) {
        //fetch the employee existence
        Employee employee = this.findById(id);
        System.out.println("Employee fetched by service is : " + employee.toString() + "\n");

        Employee patchedEmployee = this.jsonMapper.updateValue(employee, patchData); //i.e update this object with the patch data
        System.out.println("PAtched employee is : " + patchedEmployee.toString() + " \n");
        //save and return the updated employee
        return this.employeeDAO.save(patchedEmployee);
    }

    @Override
    @Transactional
    public void delete(int id) {
        //confirm the employee existence

        employeeDAO.findById(id);
        this.employeeDAO.delete(id);
//        return null;
    }

}
