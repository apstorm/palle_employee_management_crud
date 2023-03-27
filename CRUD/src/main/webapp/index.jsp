<%@page import="com.employee.entity.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.employee.dao.EmpDao"%>
<%@page import="com.employee.conn.DbConnect"%>
<%@page import="java.sql.Connection"%>
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
	<%
	Connection conn = DbConnect.getConnect();
	/* out.print(conn); */
	%>

	<div class="container text-center p-3">
		<div class="card">
			<div class="card-body">
			<c:if test="${not empty msg}">
				<p class="text-center text-success">${msg}</p>
				<c:remove var="msg"/>
			</c:if>
			<p class="fs-3 mt-3 text-center">All Employees</p>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Name</th>
							<th scope="col">DOB</th>
							<th scope="col">Address</th>
							<th scope="col">Email</th>
							<th scope="col">Password</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<%
						EmpDao dao=new EmpDao(DbConnect.getConnect());
						List<Employee> emp=dao.allEmp();
						for(Employee e:emp){
					%>
					<tbody>
						<tr>
							<th scope="row"><%=e.getId() %></th>
							<td><%=e.getName() %></td>
							<td><%=e.getDob() %></td>
							<td><%=e.getAddress() %></td>
							<td><%=e.getEmail() %></td>
							<td><%=e.getPassword() %></td>
							<td>
								<a href="edit_emp.jsp?id=<%=e.getId()%>" class="btn btn-sm btn-primary">Edit</a>
								<a href="delete?id=<%=e.getId()%>" class="btn btn-sm btn-danger">Delete</a>
							</td>
						</tr>

					</tbody>
					<%
						}
					%>
				</table>
			</div>
		</div>
	</div>

</body>
</html>