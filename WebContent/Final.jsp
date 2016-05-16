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
	<table border="1" align="center">
		<tr>
			<td colspan=3><a href="AddTime">Add A Time Slot</a></td>
			<td colspan=3><a href="AddMeeting">Add A Meeting</a></td>
		</tr>
		<tr>
			<td></td>
			<td>Monday</td>
			<td>Tuesday</td>
			<td>Wednesday</td>
			<td>Thursday</td>
			<td>Friday</td>
		</tr>
		<%@page import="java.util.List,final_model.meeting,final_model.time"%>
		<c:set var="notes" value=""></c:set>
		<c:forEach items="${timeentries}" var="entry" >
		 	<c:if test="${!empty entry}">
			<tr>
				<td><c:out value="${entry.time}"></c:out></td>
				<c:choose>
				<c:when test="${!empty meetingentries}">
					<c:set var="notes" value=""></c:set>
					<c:forEach items="${applicationScope['timeentries']}" var="timee" >
						<c:if test="${timee.day eq Monday}">
							<c:if test="${timee.time eq entry.time}">
								<c:set var="notes" value="${timee.meetingnotes}"></c:set>
							</c:if>
						</c:if>
					</c:forEach>
					<c:choose>
						<c:when test="${notes eq ''}">
							<td></td>
						</c:when>
						<c:when test="${notes ne ''}">
							<td><c:out value="${notes}"></c:out> <a href="EditMeeting?notes=${notes}&day=Monday&time=${entry.time}">[EDIT]</a></td>
						</c:when>
					</c:choose>
					
					<c:set var="notes" value=""></c:set>
					<c:forEach items="${timeentries}" var="timee" >
						<c:if test="${timee.day eq 'Tuesday'}">
							<c:if test="${timee.time eq entry.time}">
								<c:set var="notes" value="${timee.meetingnotes}"></c:set>
							</c:if>
						</c:if>
					</c:forEach>
					<c:choose>
						<c:when test="${notes eq ''}">
							<td></td>
						</c:when>
						<c:when test="${notes ne ''}">
							<td><c:out value="${notes}"></c:out> <a href="EditMeeting?notes=${notes}&day=Tuesday&time=${entry.time}">[EDIT]</a></td>
						</c:when>
					</c:choose>
					
					<c:set var="notes" value=""></c:set>
					<c:forEach items="${timeentries}" var="timee" >
						<c:if test="${timee.day eq 'Wednesday'}">
							<c:if test="${timee.time eq entry.time}">
								<c:set var="notes" value="${timee.meetingnotes}"></c:set>
							</c:if>
						</c:if>
					</c:forEach>
					<c:choose>
						<c:when test="${notes eq ''}">
							<td></td>
						</c:when>
						<c:when test="${notes ne ''}">
							<td><c:out value="${notes}"></c:out> <a href="EditMeeting?notes=${notes}&day=Wednesday&time=${entry.time}">[EDIT]</a></td>
						</c:when>
					</c:choose>
					
					<c:set var="notes" value=""></c:set>
					<c:forEach items="${timeentries}" var="timee" >
						<c:if test="${timee.day eq 'Thursday'}">
							<c:if test="${timee.time eq entry.time}">
								<c:set var="notes" value="${timee.meetingnotes}"></c:set>
							</c:if>
						</c:if>
					</c:forEach>
					<c:choose>
						<c:when test="${notes eq ''}">
							<td></td>
						</c:when>
						<c:when test="${notes ne ''}">
							<td><c:out value="${notes}"></c:out> <a href="EditMeeting?notes=${notes}&day=Thursday&time=${entry.time}">[EDIT]</a></td>
						</c:when>
					</c:choose>
					
					<c:set var="notes" value=""></c:set>
					<c:forEach items="${timeentries}" var="timee" >
						<c:if test="${timee.day eq 'Friday'}">
							<c:if test="${timee.time eq entry.time}">
								<c:set var="notes" value="${timee.meetingnotes}"></c:set>
							</c:if>
						</c:if>
					</c:forEach>
					<c:choose>
						<c:when test="${notes eq ''}">
							<td></td>
						</c:when>
						<c:when test="${notes ne ''}">
							<td><c:out value="${notes}"></c:out> <a href="EditMeeting?notes=${notes}&day=Friday&time=${entry.time}">[EDIT]</a></td>
						</c:when>
					</c:choose>
				</c:when>
				<c:when test="${empty meetingentries}">
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</c:when>
				</c:choose>
			</tr>
			</c:if>
		</c:forEach>
	</table>
</body>
</html>