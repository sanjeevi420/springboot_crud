package com.example.service;

import java.util.List;

import com.example.model.employee;

public interface empserviceimp {
	List<employee> getallemp();
	
	employee getEmployeeById(int id);
	
	void saveOrUpdate(employee emp);
	
	void delete(int id);
	
	void update(employee emp, int empid);
	
}
