<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LMS Login</title>
</head>
<body>
	<form action="LMSlogin" method="POST">
		<table align="center" valign="middle" border="1">
			<tr>
				<td colspan="3">
					<h3>Leasing Management System</h3>
				</td>
			</tr>
			<tr>
				<td>
					Email ID
				</td>
				<td>
					<input type="text" name="EmailID" />
				</td>
			</tr>
			<tr>
				<td>
					Password
				</td>
				<td>
					<input type="Password" name="Pass" />
				</td>
			</tr>
			<tr>
				<td>
					<input type=submit name="Login" value="Login">
				</td>
				<td colspan="2">
					<input type=submit name="Clear" value="Clear">
				</td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<a href=RegisterResident>Registration</a>
				</td>
			</tr>
			<c:if test="${requestScope.error != null}">
				<tr>
					<td colspan="3">
						${requestScope.error}
					</td>
				</tr>
			</c:if>
		</table>
	</form>
</body>
</html>