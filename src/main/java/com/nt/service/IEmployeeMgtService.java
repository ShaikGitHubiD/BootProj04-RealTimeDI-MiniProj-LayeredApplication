package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeMgtService {
	public List<Employee> getEmployeesService(String desg1,String desg2,String desg3)throws Exception;
}
