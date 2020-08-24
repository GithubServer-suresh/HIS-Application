<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register here</title>
</head>
<body>
${successMsg} ${errorMsg} ${userInfoMsg}
<center>
		<form:form action="./saveAccount" method="post" modelAttribute="registerInfo">
			<h1>Registration Form</h1>
			<table>
				<tr>
					<form:hidden path="registerId" />
					<td><form:label path="firstName">First Name: </form:label></td>
					<td><form:input path="firstName" /></td>
				</tr>
				<tr>
					<td><form:label path="lastName">Last Name: </form:label></td>
					<td><form:input path="lastName" /></td>
				</tr>
				<tr>
					<td><form:label path="email">Email: </form:label></td>
					<td><form:input path="email" id="email" /></td>
				</tr>
				<tr>
					<td><form:label path="gender">Gender: </form:label></td>
					<td><form:radiobutton path="gender" value="M" />Male <form:radiobutton
							path="gender" value="F" />FeMale</td>
				</tr>
				<tr>
					<td>Role:</td>
					<td><form:select path="role">
							<form:option value="">-Select-</form:option>
							<form:options items="${allRoles}" />
						</form:select></td>
				</tr>
				<tr>
					<td><input type="reset" value="Reset" /></td>
					<td><input type="submit" value="Submit" /></td>
				</tr>
				
				
				</table>
				</form:form>
				</center>


</body>
</html>