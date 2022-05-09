package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.EmpRepository;
import com.example.model.employee;


@Service
public class empservice implements empserviceimp{
	
	@Autowired
	EmpRepository emprep;
	

	
	@Override
	public List<employee> getallemp() throws Exception
	{
		List<employee> emps = new ArrayList<employee>();
		try {  
			emprep.findAll().forEach(emps1 -> emps.add(emps1));  
		}catch (Exception e) {
			throw e;
		}
		return emps;
	}
	
	@Override
	public employee getEmployeeById(int id) throws Exception   
	{  employee emp=null;
		try {
			emp=emprep.findById(id).get();
		}catch (Exception e) {
			throw e;
		}
		return emp;  
	}  
	
	@Override
	public void saveOrUpdate(employee emp) throws Exception   
	{  try {
		emprep.save(emp);  
		}catch (Exception e) {
			throw e;
		}
		
	}  
	
	@Override
	public void delete(int id) throws Exception   
	{  
		try {
			emprep.deleteById(id);
		}catch (Exception e) {
			throw e;
		}
		  
	}  
	
	@Override
	public void update(employee emp, int empid) throws Exception 
	{  
		try {
			emprep.save(emp);  
		}catch (Exception e) {
			throw e;
		}
		
	}

}

