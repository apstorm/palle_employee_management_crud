package com.employee.servlet;

import java.io.IOException;

import com.employee.conn.DbConnect;
import com.employee.dao.EmpDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/delete")
public class DeleteEmpServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		
		EmpDao dao=new EmpDao(DbConnect.getConnect());
		boolean f = dao.deleteEmp(id);
		
		HttpSession s=req.getSession();
		
		if(f) {
			s.setAttribute("msg", "employee deleted successfully..");
			System.out.println("employee deleted successfully..");
			resp.sendRedirect("index.jsp");
		} else {
			s.setAttribute("msg", "something went wrong..");
			System.out.println("something went wrong..");
			resp.sendRedirect("index.jsp");
		}
		
		
	}
	
}
