<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="EditMeeting" method="post">
		<table border="1" align="center">
			<c:set var="day" value="${param.day}"></c:set>
			<c:set var="time" value="${param.time}"></c:set>
			<c:set var="notes" value="${param.notes}"></c:set>
			
			<tr><td colspan="2" align="center">Add A Meeting</td></tr>
			<tr>
				<td>Day</td>
				<td>
					<c:out value="${day}"></c:out>
					<input type="hidden" name="day" value="${day}" />
				</td>
			</tr>
			<tr>
				<td>Time Slot</td>
				<td>
					<c:out value="${time}"></c:out>
					<input type="hidden" name="time" value="${time}" />
				</td>
			</tr>
			<tr>
				<td>Meeting Notes</td>
				<td><input type="text" name="notes" value="${notes}" required="true" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" name="Delete" value="Delete" />
					<input type="submit" name="Save" value="Save" />
				</td>
			</tr>
			<%if(request.getAttribute("ErrMsg2") != null){ %>
				<tr>
					<td colspan="2"><%=request.getAttribute("ErrMsg2")%></td>
				</tr>
			<%}%>
		</table>
	</form>
</body>
</html>