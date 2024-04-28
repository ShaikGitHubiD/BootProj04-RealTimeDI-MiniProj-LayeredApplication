package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
	private static final String GET_EMP = "SELECT EMPNO,ENAME,JOB, SAL, DEPTNO FROM EMP WHERE JOB IN (?,?,?)ORDER BY JOB";
	@Autowired
	private DataSource ds;
	@Override
	public List<Employee> getEmployeesDAO(String desg1, String desg2, String desg3) throws Exception {
		// get pooled connection from DataSource 
		List <Employee> list = null;
		try(// try with resource
				Connection con = ds.getConnection();
				// create prepared statement with object using con object 
				PreparedStatement ps= con.prepareStatement(GET_EMP);){
			System.out.println("inside DAO");
			ps.setString(1, desg1);
			ps.setString(2, desg2);
			ps.setString(3, desg3);
			try(// nested try with resource 
					ResultSet rs = ps.executeQuery();){
				// create arraylist 
				list = new ArrayList();
				while(rs.next()) {
					Employee emp1= new Employee();
					
					emp1.setEno(rs.getInt(1));
					emp1.setEname(rs.getString(2));
					emp1.setJob(rs.getString(3));
					emp1.setSalary(rs.getDouble(4));
					emp1.setDeptno(rs.getInt(5));
					list.add(emp1);
				}
			}
			
		}catch (SQLException se) { //handelling known eception
			se.printStackTrace();
			throw se;
		}catch(Exception e) {// handeling unknown exception
			throw e;
		}
		return list;
	}
	

}
