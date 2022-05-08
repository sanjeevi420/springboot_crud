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
	public List<employee> getAllemployees()   
	{  
		System.out.println("All employees data retrived");
		System.out.println("--------------------------------------------------");
		return emps.getallemp();  
	}  
	
	@GetMapping("/employee/{empid}")
	@Override
	public employee getemployee(@PathVariable("empid") int empid)   
	{  
		System.out.println("The Data of EmpId : "+empid+" retrived");
		System.out.println("--------------------------------------------------");
		return emps.getEmployeeById(empid);  
	}  
	
	@DeleteMapping("/employee/{empid}")
	@Override
	public void deleteEmployee(@PathVariable("empid") int empid)   
	{  
		System.out.println("The Data of EmpId : "+empid+" deleted");
		System.out.println("--------------------------------------------------");
		emps.delete(empid);  
	}  
	
	@PostMapping("/employees")
	@Override
	public int saveEmployee(@RequestBody employee emplo)   
	{  
		
		emps.saveOrUpdate(emplo);
		System.out.println("The new data is added with EmpId : "+emplo.getEmpid());
		System.out.println("--------------------------------------------------");
		return emplo.getEmpid();  
	} 
	
	@PutMapping("/employees")
	@Override
	public employee update(@RequestBody employee emplo)   
	{  
		emps.saveOrUpdate(emplo);
		System.out.println("The data is updated for EmpId : "+emplo.getEmpid());
		System.out.println("--------------------------------------------------");
		return emplo;  
	}

}
