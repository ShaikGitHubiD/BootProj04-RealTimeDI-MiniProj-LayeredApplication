package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.EmployeeOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootProj04RealTimeDiMiniProjLayeredApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx =  SpringApplication.run(BootProj04RealTimeDiMiniProjLayeredApplication.class, args);
		EmployeeOperationsController empc = ctx.getBean("empController", EmployeeOperationsController.class);
		try {
			System.out.println("inside try");
		List<Employee> list = empc.showEmployeeByDesgs("CLERK", "MANAGER", "SALESMAN");
		System.out.println("After show method");
		list.forEach(emp->{
			System.out.println(emp);
		});
		}catch(Exception e) {
			e.printStackTrace();
		} 
		ctx.close();
		}

}
