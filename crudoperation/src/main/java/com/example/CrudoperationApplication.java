package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;




@SpringBootApplication
@ComponentScan
public class CrudoperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudoperationApplication.class, args);
		System.out.println("--------------------------------------------------");
		System.out.println("Started Employee CRUD opertation....");
		System.out.println("--------------------------------------------------");
	}

}
