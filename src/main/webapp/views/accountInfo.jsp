<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	${account}
	<center>
		<form action="./updateAccount" method="post"  modelAttribute="registerInfo">
			<h1>Update Form</h1>
			<table>
				<tr>
					<td>Account Id:</td>
					<td><input type="text" value="${account.registerId}"
						readonly="readonly" /></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><input type="text" value="${account.firstName}" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="text" value="${account.email}" /></td>
				</tr>
				<tr>
					<td>Gender:</td>
					<td>
					<c:choose>
							<c:when test="${account.gender='M'}">
								<input type="radio" name="gender"checked="checked" />Male
								<input type="radio" name="gender"/>Fe-Male
         					</c:when>
							<c:otherwise>
								<input type="radio"  name="gender"/>Male
								<input type="radio" name="gender" checked="checked" />Fe-Male
         					</c:otherwise>
					</c:choose></td>
				</tr>



		
				<%-- <tr>
					<td>Role:</td>
					<td><form:select path="role">
							<form:option value="">-Select-</form:option>
							<form:options items="${allRoles}" />
						</form:select></td>
				</tr> --%>
				<tr>
					<td><input type="reset" value="Reset" /></td>
					<td><input type="submit" value="Submit" /></td>
				</tr>


			</table>
		</form>
	</center>
</body>
</html>