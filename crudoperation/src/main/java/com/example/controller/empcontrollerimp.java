package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.model.employee;

public interface empcontrollerimp {
	
	List<employee> getAllemployees();
	
	employee getemployee(@PathVariable("empid") int empid);
	
	void deleteEmployee(@PathVariable("empid") int empid);
	
	int saveEmployee(@RequestBody employee emplo);
	
	employee update(@RequestBody employee emplo);   


}
