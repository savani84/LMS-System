<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Apartment</title>
</head>
<body>
	<form action="AddApartment" method="POST">
		<table align="center" valign="middle" border="1">
			<tr>
				<td align="center" colspan="3">
					<h3>Leasing Management System</h3>
				</td>
			</tr>
			<tr>
				<td align="center" colspan="3">
					Add Apartment Details
				</td>
			</tr>
			<tr>
				<td>Apartment #</td>
				<td><input type="text" name="AptNo" /></td>
			</tr>
			<tr>
				<td>Type</td>
				<td>
					<input type="radio" name="Type" value="1BD,1 Bath" checked>1BHK</input><br/>
					<input type="radio" name="Type" value="2BD,1 Bath">2BHK - 1 Bath</input><br/>
					<input type="radio" name="Type" value="2BD,2 Bath">2BHK - 2 Bath</input>
				</td>
			</tr>
			<tr>
				<td>Facilities</td>
				<td><textarea name="Facilities"></textarea></td>
			</tr>
			<tr>
				<td>Max People</td>
				<td><input type="text" name="Maxppl"></td>
			</tr>
			<tr>
				<td>Rent</td>
				<td><input type="text" name="Rent"></td>
			</tr>
			<tr>
				<td>Deposits</td>
				<td><input type="text" name="Deposits"></td>
			</tr>
			<tr>
				<td><input type=submit name="Submit" value="Submit"></td>
				<td colspan="2"><input type=submit name="Clear" value="Clear"></td>
			</tr>
			<c:if test="${requestScope.error2 != null}">
				<tr>
					<td colspan="3">${requestScope.error2}</td>
				</tr>
			</c:if>
		</table>
	</form>
</body>
</html>