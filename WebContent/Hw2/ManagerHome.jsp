<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Manager</title>
</head>
<body>
	<table align="center" valign="middle" border="1">
		<tr>
			<td>
				<h3>Leasing Management System</h3>
			</td>
		</tr>
		<tr>
			<td>
				Welcome	${sessionScope.name} ! <a href=LMSlogout>Log Out</a>
			</td>
		</tr>
		<tr>
			<td>
				<a href=AddApartment>Add Apartment</a>
			</td>
		</tr>
		<tr>
			<td>
				<a href=ViewApartment>View Apartment</a>
			</td>
		</tr>
	</table>
</body>
</html>