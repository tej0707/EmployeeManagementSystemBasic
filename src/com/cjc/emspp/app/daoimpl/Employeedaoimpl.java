package com.cjc.emspp.app.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cjc.emspp.app.daoi.Employeedaoi;
import com.cjc.emspp.app.model.Employee;
import com.cjc.emspp.app.util.JDBCConnectivity;
import com.mysql.cj.jdbc.JdbcConnection;

public class Employeedaoimpl implements Employeedaoi {

	@Override
	public void addEmployee(Employee e) {
		
		try {
			
			Connection con=JDBCConnectivity.getConnection();
			String sql="insert into employee values(?,?,?,?)";
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,e.getEid());
			ps.setString(2,e.getEname());
			ps.setDouble(3,e.getEsalary());
			ps.setString(4,e.getEmailid());
			ps.execute();
			System.out.println("Employee Data Added");
			 
		} catch (Exception e2) {
			System.out.println(e2);
		}
		
	}

	@Override
	public List<Employee> getallEmployee() {
		List<Employee> list=new ArrayList<Employee>();
		try {
			Connection con=JDBCConnectivity.getConnection();
			
			String sql="select * from employee";
			
			PreparedStatement ps=con.prepareStatement(sql);
		
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Employee e=new Employee();
				e.setEid(rs.getInt(1));
				e.setEname(rs.getString(2));
				e.setEsalary(rs.getDouble(3));
				e.setEmailid(rs.getString(4));
				list.add(e);
				
			}
			return list;
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		return list;
		

	
		
	}

	@Override
	public List<Employee> updateEmployee(Employee e) {
		try {
			Connection con=JDBCConnectivity.getConnection();
			String sql="update employee set ename=?,esalary=?,emailid=? where eid=?";
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,e.getEname());
			ps.setDouble(2, e.getEsalary());
			ps.setString(3,e.getEmailid());
			ps.setInt(4,e.getEid());
			
			ps.execute();
			
		} catch (Exception e1) {
		e1.printStackTrace();
		}
		List<Employee> list=this.getallEmployee();
		
		return list;
	}

	@Override
	public List<Employee> deleteEmployee(int eid) {
		try {
			Connection con=JDBCConnectivity.getConnection();
			String sql="delete from employee where eid=?";
		PreparedStatement ps	=con.prepareStatement(sql);
		
		ps.setInt(1, eid);
		ps.execute();
			
		} catch (Exception e1) {
		e1.printStackTrace();
		}

		
		return this.getallEmployee();
	}

	@Override
	public Employee loginbyEidandNmae(int eid, String name) {
		try {
			Connection con=JDBCConnectivity.getConnection();
			String sql="select * from employee where eid=? and ename=?";
			PreparedStatement ps	=con.prepareStatement(sql);
			
			ps.setInt(1, eid);
			ps.setString(2,name);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				Employee e=new Employee();
				e.setEid(rs.getInt(1));
				e.setEname(rs.getString(2));
				e.setEsalary(rs.getDouble(3));
				e.setEmailid(rs.getString(4));
				return e;
				
				
			}
			else {
				return null;
			}
			
		
			
		} catch (Exception e1) {
		e1.printStackTrace();
		}

		
		return null;
	}

	@Override
	public List<Employee> sortbyname() {
		List<Employee> list=new ArrayList<Employee>();
		Connection con=JDBCConnectivity.getConnection();
		String sql="select * from employee order by ename ASC";//for acending ordr//
		//String sql="select * from employee order by ename DESC";//FOR DECENDING ORDER//
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Employee e=new Employee();
				e.setEid(rs.getInt(1));
				e.setEname(rs.getString(2));
				e.setEsalary(rs.getDouble(3));
				e.setEmailid(rs.getString(4));
				list.add(e);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return list;
	}

	
}
