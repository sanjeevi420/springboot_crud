package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.model.employee;

public interface EmpRepository extends CrudRepository<employee, Integer>  
{  
}  