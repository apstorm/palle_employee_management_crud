package com.employee.servlet;

import java.io.IOException;

import com.employee.conn.DbConnect;
import com.employee.dao.EmpDao;
import com.employee.entity.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/edit_emp")
public class UpdateEmpServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		int id=Integer.parseInt(req.getParameter("id"));
		
		Employee emp=new Employee(id, name, dob, address, email, password);
		
		EmpDao dao=new EmpDao(DbConnect.getConnect());
		boolean f = dao.editEmp(emp);
		
		HttpSession s=req.getSession();
		if(f) {
			s.setAttribute("msg", "employee details updated successfully..");
			System.out.println("employee details updated successfully..");
			resp.sendRedirect("index.jsp");
		} else {
			s.setAttribute("msg", "something went wrong..");
			System.out.println("something went wrong..");
			resp.sendRedirect("index.jsp");
		}
		
	}
	
}
