package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

@Service("empService")
public class EmployeeMgtServiceImpl implements IEmployeeMgtService {
@Autowired
private IEmployeeDAO IEDao;
	@Override
	public List<Employee> getEmployeesService(String desg1, String desg2, String desg3) throws Exception {
		List<Employee> list = IEDao.getEmployeesDAO(desg1, desg2, desg3);
		System.out.println("inside service");
		list.forEach(emp->{
			emp.setGrossSalary(emp.getSalary()*12+(emp.getSalary()*0.4));
			emp.setNetSalary(emp.getSalary()*12-(emp.getSalary()*0.2));
		});
		return list;
	}

}
