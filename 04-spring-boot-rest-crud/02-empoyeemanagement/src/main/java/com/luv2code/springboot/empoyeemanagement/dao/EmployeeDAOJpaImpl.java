package com.luv2code.springboot.empoyeemanagement.dao;

import com.luv2code.springboot.empoyeemanagement.entity.Employee;
import jakarta.persistence.EntityManager;
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
        List<Employee> employees = theQuery.getResultList();

        //return result
        return employees;
    }
}
