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
						<p class="fs-3 text-center">Add Employee</p>
						<c:if test="${not empty msg}">
							<p class="text-center text-success">${msg}</p>
							<c:remove var="msg"/>
						</c:if>
						<form action="add_emp" method="post">
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Name
								</label> <input type="text" class="form-control" name="name">
							</div>
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label"> DOB</label>
								<input type="date" class="form-control" name="dob">
							</div>
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">
									address</label> <input type="text" class="form-control" name="address">
							</div>
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Email
								</label> <input type="email" class="form-control" name="email">
							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Password</label>
								<input type="password" class="form-control" name="password">
							</div>

							<button type="submit" class="btn btn-primary">Add</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>