<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="AddMeeting" method="post">
		<table border="1" align="center">
			<tr><td colspan="2" align="center">Add A Meeting</td></tr>
			<tr>
				<td>Day</td>
				<td>
					<select name="day">
						<option>Monday</option>
						<option>Tuesday</option>
						<option>Wednesday</option>
						<option>Thursday</option>
						<option>Friday</option>
						<option selected="true">Select Day</option>
					</select>
				</td>
			</tr>
			<%@page import="java.util.List,final_model.time"%>
			<tr>
				<td>Time Slot</td>
				<td>
					<select name="time">
						<c:forEach items="${timeentries}" var="entry" >
							<c:if test="${!empty entry}">
								<option><c:out value="${entry.time}"></c:out></option>
							</c:if>
						</c:forEach>
						<option selected="true">Select Time</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Meeting Notes</td>
				<td><input type="text" name="notes" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" name="Add" value="Add" />
				</td>
			</tr>
			<c:if test="${!empty ErrMsg2}">
				<tr>
					<td colspan="2"><c:out value="${ErrMsg2}"></c:out></td>
				</tr>
			</c:if>
		</table>
	</form>
</body>
</html>