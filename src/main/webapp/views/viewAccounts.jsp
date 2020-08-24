<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Contacts</title>

<script type="text/javascript" src="https://unpkg.com/jquery@3.3.1/dist/jquery.min.js"></script>

<link rel="stylesheet" type="text/css"  href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css"/>
<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.js"></script>
 


<script type="text/javascript">
	function deleteconfirm() {
		return confirm("Do you want to delete?");
	}
</script>
</head>
<body>
	<h1>All Accounts</h1> &nbsp;
	<br/>
	
	Select Role: 
					<form:select path="role">
							<form:option value="">-Select-</form:option>
							<form:options items="${allRoles}" />
						</form:select></td>
				</tr>
	<br/>

	<table border="1" id="accountTab" style="width:100%">
		<thead>
			<tr>
				<th>S.No</th>
				<th>Name</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${accountsList}" var="c" varStatus="index">
				<tr>
					<td>${index.count}</td>
					<td>${c.firstName}</td>
					<td>${c.email}</td>
					<td><a href="editAccount?accId=${c.registerId}">Edit</a>  ||
						   <a href="deleteAccount?accId=${c.registerId}"
						onclick="return deleteconfirm()">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>