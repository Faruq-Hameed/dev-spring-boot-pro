package com.luv2code.employeemanagement.service;
import com.luv2code.employeemanagement.dao.EmployeeRepository;
import com.luv2code.employeemanagement.entity.Employee;
import com.luv2code.employeemanagement.rest.EmployeeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepo;
    private JsonMapper jsonMapper; //useful for partial updates

    //constructor with auto wired injection
    @Autowired
    public EmployeeServiceImpl(JsonMapper jsonMapper, EmployeeRepository employeeRepo){
        this.employeeRepo = employeeRepo;
        this.jsonMapper =  jsonMapper;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = this.employeeRepo.findById(id);

        Employee employee = null;
        //check for null
        if(result.isEmpty()) {

            throw new EmployeeNotFoundException("Employee with id " + id + " not found");
        }
        return result.get();
    }

    @Override
    @Transactional//best to be used in service level not dao
    public Employee save(Employee employee) {
        return this.employeeRepo.save(employee);
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
        return this.employeeRepo.save(patchedEmployee);
    }

    @Override
    @Transactional
    public void delete(int id) {
        //confirm the employee existence

        employeeRepo.findById(id);
        this.employeeRepo.deleteById(id);
//        return null;
    }

}
