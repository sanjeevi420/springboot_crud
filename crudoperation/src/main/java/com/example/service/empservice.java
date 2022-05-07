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
	public List<employee> getallemp(){
		List<employee> emps = new ArrayList<employee>();  
		emprep.findAll().forEach(emps1 -> emps.add(emps1));  
		return emps;  
	}
	
	@Override
	public employee getEmployeeById(int id)   
	{  
		return emprep.findById(id).get();  
	}  
	
	@Override
	public void saveOrUpdate(employee emp)   
	{  
		emprep.save(emp);  
	}  
	
	@Override
	public void delete(int id)   
	{  
		emprep.deleteById(id);  
	}  
	
	@Override
	public void update(employee emp, int empid)   
	{  
		emprep.save(emp);  
	}

}

