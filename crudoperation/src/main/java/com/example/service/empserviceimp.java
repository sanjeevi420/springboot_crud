package com.example.service;

import java.util.List;

import com.example.model.employee;

public interface empserviceimp {
	List<employee> getallemp() throws Exception;
	
	employee getEmployeeById(int id) throws Exception;
	
	void saveOrUpdate(employee emp) throws Exception;
	
	void delete(int id) throws Exception;
	
	void update(employee emp, int empid) throws Exception;
	
}
