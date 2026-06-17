package com.luv2code.employeemanagement.dao;

import com.luv2code.employeemanagement.entity.Employee;
import com.luv2code.employeemanagement.rest.EmployeeNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{
    //define field for entity manager
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //set up constructor
    @Override
    public List<Employee> findAll() {
        //create a query
        TypedQuery<Employee> theQuery= this.entityManager.createQuery("FROM Employee",Employee.class);

        // execute query and get result list
        return theQuery.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return this.entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        System.out.println("Passed employee is : " + employee.toString());
        return this.entityManager.merge(employee); //merge will insert/create if id is 0
    }

//    @Override
//    public Employee update(Employee theEmployee) {
//        return this.entityManager.merge(theEmployee) //so update will occur since id cannot be zero
//                ;
//    }

    @Override
    public void delete(int id) {
        //find the employee with the id
        Employee employee = this.entityManager.find(Employee.class, id);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }
        //delete the employee persistently
        entityManager.remove(employee);

    }
}
