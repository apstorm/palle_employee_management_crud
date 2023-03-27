package com.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.employee.entity.Employee;

public class EmpDao {

	private Connection conn;

	public EmpDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addEmp(Employee emp) {
		boolean f=false;
		
		try {
			String sql="insert into emp(name,dob,address,email,password) "
					+ "values(?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getDob());
			ps.setString(3, emp.getAddress());
			ps.setString(4, emp.getEmail());
			ps.setString(5, emp.getPassword());
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public Employee getEmpById(int id) {
		Employee emp=null;
		try {
			String sql="select * from emp where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				emp=new Employee();
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setDob(rs.getString(3));
				emp.setAddress(rs.getString(4));
				emp.setEmail(rs.getString(5));
				emp.setPassword(rs.getString(6));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}
	
	public List<Employee> allEmp(){
		List<Employee> list=new ArrayList<>();
		Employee emp=null;
		
		try {
			String sql="select * from emp";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				emp=new Employee();
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setDob(rs.getString(3));
				emp.setAddress(rs.getString(4));
				emp.setEmail(rs.getString(5));
				emp.setPassword(rs.getString(6));
				list.add(emp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public boolean editEmp(Employee emp) {
		boolean f=false;
		
		try {
			String sql="update emp set name=?,dob=?,address=?,email=?,password=? "
					+ "where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getDob());
			ps.setString(3, emp.getAddress());
			ps.setString(4, emp.getEmail());
			ps.setString(5, emp.getPassword());
			ps.setInt(6, emp.getId());
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public boolean deleteEmp(int id) {
		boolean f=false;
		
		try {
			String sql="delete from emp where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
}
