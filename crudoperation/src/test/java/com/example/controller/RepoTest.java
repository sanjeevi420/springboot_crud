package com.example.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.model.employee;

@SpringBootTest
public class RepoTest {

	@Autowired
	private empcontroller empctrl;
	
	 @Test
	 void isEmpExistById() {
		 employee Employee = new employee(1234);
		 empctrl.saveEmployee(Employee);
		 employee actualResult = empctrl.getemployee(1234);
		 assertNull(actualResult);
		 
	 }
	 
	 @Test
	 void getAllEmp() {
		 List<employee> res = empctrl.getAllemployees();
		 assertNotNull(res);
	 }
	
	 @Test
	 void noEmpInDb() {
		 List<employee> res = empctrl.getAllemployees();
		 List<employee> def = new ArrayList<employee>();
		 assertEquals(res.size(), def.size());
	 }
	
	 @Test
	 void noEmpById() {
		 employee Employee = new employee(3333,"Sam");
		 empctrl.saveEmployee(Employee);
		 employee actualResult = empctrl.getemployee(2233);
		 assertNull(actualResult);
		 empctrl.deleteEmployee(3333);
	 }
	
	@Test
	 void updateEmp() {
		 employee Employee = new employee(1234,"Sam");
		 int eid = empctrl.saveEmployee(Employee);
		 employee Employee1 = new employee(1234,"Tam");
		 empctrl.update(Employee1);
		 String name=empctrl.getemployee(eid).getEmpname();
		 assertEquals(name, "Tam");
		 empctrl.deleteEmployee(1234);
		 
	 }
	
	 @Test
	 void saveEmp() {
		 employee Employee = new employee(1234);
		 int eid = empctrl.saveEmployee(Employee);
		 assertEquals(Employee.getEmpid(), eid);
		
	 }
	 
}
