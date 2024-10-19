package com.cjc.emspp.app.serviceimpl;

import java.util.List;

import com.cjc.emspp.app.daoi.Employeedaoi;
import com.cjc.emspp.app.daoimpl.Employeedaoimpl;
import com.cjc.emspp.app.model.Employee;
import com.cjc.emspp.app.servicei.Employeeservicei;

public class Employeeserviceimpl implements Employeeservicei {

	Employeedaoi edi=new Employeedaoimpl();
	

	@Override
	public void addEmployee(Employee e) {
	edi.addEmployee(e);
		
	}


	
	


	@Override
	public List<Employee> getallEmployee() {
		
		List<Employee> list=edi.getallEmployee();
		return list;
	}






	@Override
	public List<Employee> updateEmployee(Employee e) {
		List<Employee> list=edi.updateEmployee(e);
		
		return list;
	}






	@Override
	public List<Employee> deleteEmployee(int eid) {
		List<Employee> list=edi.deleteEmployee(eid);
		
		return list;
	}






	@Override
	public Employee loginbyEidandNmae(int eid, String name) {
		Employee list=edi.loginbyEidandNmae(eid, name);
		return list;
	}






	@Override
	public List<Employee> sortbyname() {
		
		return edi.sortbyname();
	}

}
