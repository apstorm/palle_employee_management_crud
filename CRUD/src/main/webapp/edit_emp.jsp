<%@page import="com.employee.entity.Employee"%>
<%@page import="com.employee.conn.DbConnect"%>
<%@page import="com.employee.dao.EmpDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="allCss.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<p class="fs-3 text-center">Update Employee</p>

						<%
						int id = Integer.parseInt(request.getParameter("id"));
						EmpDao dao = new EmpDao(DbConnect.getConnect());
						Employee emp = dao.getEmpById(id);
						%>

						<form action="edit_emp" method="post">
							
							<input type="hidden" name="id" value="<%=emp.getId() %>" />
							
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Name
								</label> <input type="text" class="form-control" name="name"
									value="<%=emp.getName()%>">
							</div>
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label"> DOB</label>
								<input type="date" class="form-control" name="dob" value="<%=emp.getDob()%>">
							</div>
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">
									address</label> <input type="text" class="form-control" value="<%=emp.getAddress() %>" name="address">
							</div>
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Email
								</label> <input type="email" class="form-control" name="email" value="<%=emp.getEmail()%>">
							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Password</label>
								<input type="password" class="form-control" value="<%=emp.getPassword() %>" name="password">
							</div>

							<button type="submit" class="btn btn-primary">Update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>