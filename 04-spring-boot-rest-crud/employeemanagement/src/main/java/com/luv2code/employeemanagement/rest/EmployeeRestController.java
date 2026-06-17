package com.luv2code.employeemanagement.rest;

import com.luv2code.employeemanagement.dao.EmployeeDAO;
import com.luv2code.employeemanagement.entity.Employee;
import com.luv2code.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
        employee.setId(0);//set this to 0 incase id was passed
        return this.employeeService.save(employee);
    }

    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee){
        System.out.println("Req body is :"+ employee.toString()+ "\n");
        //confirm the employee passed exist
        employeeService.findById(employee.getId());

        //update the employee with the new info and return the updated row
        return this.employeeService.save(employee);
    }

    @PutMapping("/{employeeId}")
    public Employee updateEmployee(@PathVariable int employeeId, Map<String, Object> patchData){
        //check for null object incase passed in
        if(patchData == null){
            throw new RuntimeException("Minimum of on update must be performed");
        }

        //the req body must not contain the id
        if(patchData.containsKey("id")){
            throw new EmployeeBadRequestException("Cannot update id.");
        }
        return this.employeeService.update(employeeId, patchData);
    }

    @DeleteMapping("/{employeeId}")
    public void updateEmployee(@PathVariable int employeeId){
        this.employeeService.delete(employeeId);
    }

}
