package com.luv2code.employeemanagement.rest;

import com.luv2code.employeemanagement.dao.EmployeeDAO;
import com.luv2code.employeemanagement.entity.Employee;
import com.luv2code.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {
    private EmployeeService employeeService;
    @Autowired
    public EmployeeRestController( EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    //get all employees api
    @GetMapping()
    public List<Employee> getAll(){
        return employeeService.findAll();
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){
        return this.employeeService.findById(employeeId);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        System.out.println(employee);
        employee.setId(0);
        return this.employeeService.save(employee);
    }

    @PutMapping("/{employeeId}")
    public Employee updateEmployee(@PathVariable int employeeId, Employee employee){
        if(employee.getId() !=employeeId){
            throw new EmployeeConflictException("Path Variable and employee id differs");
        }
        return this.employeeService.update(employee);
    }

    @DeleteMapping("/{employeeId}")
    public void updateEmployee(@PathVariable int employeeId){
        this.employeeService.delete(employeeId);
    }

}
