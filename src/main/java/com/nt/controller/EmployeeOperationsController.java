package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgtService;

@Controller("empController")
public class EmployeeOperationsController {
	@Autowired
	private IEmployeeMgtService empService;
	public List<Employee> showEmployeeByDesgs(String desg1, String desg2, String desg3) throws Exception{
		System.out.println("inside conroller");
		List<Employee> list =empService.getEmployeesService(desg1, desg2, desg3);
		
		return list;
		
	}
}
