package com.cjc.emspp.app.client;

import java.util.List;
import java.util.Scanner;

import com.cjc.emspp.app.model.Employee;
import com.cjc.emspp.app.servicei.Employeeservicei;
import com.cjc.emspp.app.serviceimpl.Employeeserviceimpl;

public class Testui {

	public static void main(String[] args) {

		System.out.println("*** EMPLOYEE MANAGEMENT SYSTEM ***");
		Scanner sc = new Scanner(System.in);
		Employeeservicei ems=new Employeeserviceimpl();
        
		while(true) {
		System.out.println("0.LOGIN");
		System.out.println("1.Add  Employee Data");
		System.out.println("2.View Employee Data");
		System.out.println("3.Modify Employee Data");
		System.out.println("4.Delete Employee Data");
		System.out.println("5.Create Employee Table");
		System.out.println("6.Delete Employee Table");
		System.out.println("7.Sort by name ;");
		System.out.println("Enter Your Choice");
		int ch = sc.nextInt();
		if(ch==0) {
			System.out.println("Enter EID :");
			int eid=sc.nextInt();
			System.out.println("Enter Name :");
			String name=sc.next();
			Employee e1=ems.loginbyEidandNmae(eid, name);
			if(e1!=null) {
				 System.out.println(""+e1.getEid()+"          |"+e1.getEname()+"          |"+e1.getEsalary()+"     |"+e1.getEmailid());
			}
			else {
				System.out.println("invalid credentials!");
			}
			
		}
		else if (ch == 1) {
			
			Employee e=new Employee();
			System.out.println("Enter id");
			e.setEid(sc.nextInt());
			System.out.println("Enter Name");
			e.setEname(sc.next());
			System.out.println("Enter Salary");
			e.setEsalary(sc.nextDouble());
			System.out.println("Enter Email");
			e.setEmailid(sc.next());
			ems.addEmployee(e);
			

		} else if (ch == 2) {
			List<Employee> list=ems.getallEmployee();
			             System.out.println("|emp id            | emp name            | emp salary            | emp email   |\n");
           
			for(Employee e :list) {
			             System.out.println(""+e.getEid()+"          |"+e.getEname()+"          |"+e.getEsalary()+"     |"+e.getEmailid());
			}
		} else if (ch == 3) {
			Employee e=new Employee();
			System.out.println("---UPDATE DETAILS---");
			System.out.println("Enter name:");
			e.setEname(sc.next());
			System.out.println("Enter salary :");
			e.setEsalary(sc.nextDouble());
			System.out.println("Enter emailid:");
			e.setEmailid(sc.next());
			System.out.println("Enter id for update employee details :");
			e.setEid(sc.nextInt());
			
		List<Employee> list=ems.updateEmployee(e);
		System.out.println("updated details..!");
		  System.out.println("|emp id            | emp name            | emp salary            | emp email   |\n");
          
			for(Employee e1 :list) {
			             System.out.println(""+e1.getEid()+"          |"+e1.getEname()+"          |"+e1.getEsalary()+"     |"+e1.getEmailid());
			}
		

		} else if (ch == 4) {
			
			System.out.println("---DELETE EMPLOYEE---");
			System.out.println("Enter id to delete employee object :");
			int empid =sc.nextInt();
			List<Employee> list=ems.deleteEmployee(empid);
			System.out.println("Deleted details..!");
			  System.out.println("|emp id            | emp name            | emp salary            | emp email   |\n");
	          
				for(Employee e1 :list) {
				             System.out.println(""+e1.getEid()+"          |"+e1.getEname()+"          |"+e1.getEsalary()+"     |"+e1.getEmailid());
				}

		} else if (ch == 5) {
			System.out.println("---CREATE TABLE---");
			System.out.println("Enter table name :");
			int tn=sc.nextInt();
			
			

		} else if (ch == 6) {

		}else if(ch==7) {
			List<Employee> list =ems.sortbyname(); 
			list.forEach(s->{
				System.out.println(s.getEid());
				System.out.println(s.getEname());
				System.out.println(s.getEsalary());
				System.out.println(s.getEmailid());
			});
			
			 
			
		}
		else  {

			System.out.println("Invalid Choice");
		}

	}
}
}
