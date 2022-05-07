package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.employee;
import com.example.service.empservice;

@RestController
@CrossOrigin
public class empcontroller implements empcontrollerimp {
	
	@Autowired
	empservice emps;
		
	@GetMapping("/employee")
	@Override
	public List<employee> getAllBooks()   
	{  
		return emps.getallemp();  
	}  
	
	@GetMapping("/employee/{empid}")
	@Override
	public employee getemployee(@PathVariable("empid") int empid)   
	{  
		return emps.getEmployeeById(empid);  
	}  
	
	@DeleteMapping("/employee/{empid}")
	@Override
	public void deleteEmployee(@PathVariable("empid") int empid)   
	{  
		emps.delete(empid);  
	}  
	
	@PostMapping("/employees")
	@Override
	public int saveEmployee(@RequestBody employee emplo)   
	{  
		emps.saveOrUpdate(emplo);
		return emplo.getEmpid();  
	} 
	
	@PutMapping("/employees")
	@Override
	public employee update(@RequestBody employee emplo)   
	{  
		emps.saveOrUpdate(emplo);  
		return emplo;  
	}

}