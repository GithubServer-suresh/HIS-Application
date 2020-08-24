<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Here</title>
<link type="text/css" rel="stylesheet" href="css/test.css" />

</head>

<body>
${loginStatus}
	<center>
		<%@include file="/views/Header.jsp"%>
		
		<div id="div1" >
			<form:form action="./login" method="POST" modelAttribute="userLogin" >
				<table border="1">

					<thead><h1><b>Login Here</b></h1>
					</thead>
					<tr>
						<td><form:label path="email">Email: </form:label></td>
						<td><form:input path="email" /></td>
					</tr>
					<tr>
						<td><form:label path="password">Password :</form:label></td>
						<td><form:password path="password" /></td>
					</tr>
					<tr>
						<td><input type="reset" value="Reset" /></td>
						<td><input type="submit" value="Sign In" /></td>
					</tr>

					<tr>
						<td><a href="http://localhost:8053/UserMgmt/">Sign Up</a></td>
						<td><a href="http://localhost:8053/UserMgmt/forgotPwd">Forgot Password</a></td>
					</tr>

				</table>

			</form:form>

		</div>
		<%@include file="/views/Footer.jsp"%>
	</center>
</body>
</html>