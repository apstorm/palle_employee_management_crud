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

@WebServlet("/add_emp")
public class AddEmpServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Employee e=new Employee(name, dob, address, email, password);
		EmpDao dao=new EmpDao(DbConnect.getConnect());
		boolean i = dao.addEmp(e);
		
		HttpSession s=req.getSession();
		if(i) {
			s.setAttribute("msg", "employee added successfully..");
			System.out.println("employee added successfully..");
			resp.sendRedirect("add_emp.jsp");
		} else {
			s.setAttribute("msg", "something went wrong..");
			System.out.println("something went wrong..");
			resp.sendRedirect("add_emp.jsp");
		}
		
	}

}
