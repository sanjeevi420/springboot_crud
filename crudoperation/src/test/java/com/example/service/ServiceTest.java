package com.example.service;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;
import com.example.controller.empcontroller;
import com.example.model.employee;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest{
	
	@Mock 
	private empcontroller empctrl;
	 
	@InjectMocks
    private empcontroller empser = new empcontroller();
 
 
    @Test 
    public void getAllEmp()
    {
    	List<employee> em = empser.getAllemployees();
    	assertNull(em);
    }
    
    @Test
    public void getEmpById() {
    	
    	employee emp = empser.getemployee(1234);
    	assertNull(emp);
    }
    
    @Test
    public void empSave() {
    	employee Employee = new employee(1234);
    	int epid = empser.saveEmployee(Employee);
    	assertEquals(epid, Employee.getEmpid());
    }
}

