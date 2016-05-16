<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add A Time Slot</title>
</head>
<body>
	<form action="AddTime" method="post">
		<table border="1" align="center">
			<tr><td colspan="2" align="center">Add A Time Slot</td></tr>
			<tr>
				<td>Time Slot</td>
				<td><input type="text" name="time" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" name="Add" value="Add" />
				</td>
			</tr>
			<c:if test="${!empty ErrMsg1}">
				<tr>
					<td colspan="2"><c:out value="${ErrMsg1}"></c:out></td>
				</tr>
			</c:if>
		</table>
	</form>
</body>
</html>