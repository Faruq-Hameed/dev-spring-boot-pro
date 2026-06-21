package com.luv2code.employeemanagement.dao;

import com.luv2code.employeemanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "members")//manually configure the route to members instead of employees
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
