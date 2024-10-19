package com.cjc.emspp.app.daoi;

import java.util.List;

import com.cjc.emspp.app.model.Employee;

public interface Employeedaoi {
	
	public void addEmployee(Employee e);
	
	public List<Employee> getallEmployee();
	
	public List<Employee> updateEmployee(Employee e);
	
	public List<Employee> deleteEmployee(int eid);
	
	public Employee loginbyEidandNmae(int eid,String name);
	
	public List<Employee> sortbyname();

	
	

}
