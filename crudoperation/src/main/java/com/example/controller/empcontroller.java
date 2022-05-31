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
	
	excel empex=new excel();
		
	@GetMapping("/employee")
	@Override
	public List<employee> getAllemployees()   
	{  
		List<employee> emp =null;
		try {
			System.out.println("All employees data retrived");
			System.out.println("--------------------------------------------------");
			emp= emps.getallemp(); 
		}catch (Exception e) {
			System.out.println("--------------------------------------------------");
			System.out.println("Controller error is: "+e.getMessage());
			System.out.println("--------------------------------------------------");
		}
		return emp;
		 
	}  
	
	@GetMapping("/employee/{empid}")
	@Override
	public employee getemployee(@PathVariable("empid") int empid)   
	{  
		employee emp=null;
		try {
			emp=emps.getEmployeeById(empid);
			System.out.println("The Data of EmpId : "+empid+" retrived");
			System.out.println("--------------------------------------------------");
		}catch (Exception e) {
			System.out.println("--------------------------------------------------");
			System.out.println("Controller error is: "+e.getMessage());
			System.out.println("--------------------------------------------------");
		}
		return emp;   
	}  
	
	@DeleteMapping("/employee/{empid}")
	@Override
	public void deleteEmployee(@PathVariable("empid") int empid) 
	{  
		try {
			emps.delete(empid); 	
			System.out.println("The Data of EmpId : "+empid+" deleted");
			System.out.println("--------------------------------------------------");
		}catch (Exception e) {
			System.out.println("--------------------------------------------------");
			System.out.println("Controller error is: "+e.getMessage());
			System.out.println("--------------------------------------------------");
		}
		
		 
	}  
	
	@PostMapping("/employees")
	@Override
	public int saveEmployee(@RequestBody employee emplo)   
	{  
		try {
			emps.saveOrUpdate(emplo);
			System.out.println("The new data is added with EmpId : "+emplo.getEmpid());
			System.out.println("--------------------------------------------------");
		}catch (Exception e) {
			System.out.println("--------------------------------------------------");
			System.out.println("Controller error is: "+e.getMessage());
			System.out.println("--------------------------------------------------");
		}
		return emplo.getEmpid();  
	} 
	
	@PutMapping("/employees")
	@Override
	public employee update(@RequestBody employee emplo)   
	{  
		try {
			emps.saveOrUpdate(emplo);
			System.out.println("The data is updated for EmpId : "+emplo.getEmpid());
			System.out.println("--------------------------------------------------");
		}catch (Exception e) {
			System.out.println("--------------------------------------------------");
			System.out.println("Controller error is: "+e.getMessage());
			System.out.println("--------------------------------------------------");
		}
		
		return emplo;  
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/toExcel")
	@Override
	public void writeExcel(@RequestParam("file") MultipartFile[] file)
	{
		Path rootLocation= Paths.get("D:\\");
		try {
	         try {
	            Files.copy(file[0].getInputStream(), rootLocation.resolve("EmpList.xlsx"));
	            empex.readFromExcel();
	         } catch (Exception e) {
	            System.out.println(e.getMessage());
	         }
	      } catch (Exception e) {
	         System.out.println(e.getMessage());
	      }
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/InExcel/{filename}")
	@ResponseBody
	@Override
	public ResponseEntity<Resource> downloadFile(@PathVariable("filename") String filename) throws IOException {
        Resource file;
        Path path;
			this.writeInExcel();
			file = excel.download(filename);
			
			path =file.getFile().toPath();
			     
        return ResponseEntity.ok()
                             .header(HttpHeaders.CONTENT_TYPE, Files.probeContentType(path))
                             .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                             .body(file);
    }
	
	public void writeInExcel()
	{
		try {
			List<employee> em = this.getAllemployees();
			empex.writeExcel(em);
		}catch (Exception e) {
			System.out.println(e.getMessage()+"ExcelError");
		}
		
	}


}
