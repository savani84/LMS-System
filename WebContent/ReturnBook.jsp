<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>ID</td>
			<td>Title</td>
			<td>Author</td>
			<td>Date</td>
			<td>Action</td>
		</tr>
		<c:forEach items="${requestScope['htmlborrowentries']}" var="BorrowClass" varStatus="status">
				<tr>
					<td>${BorrowClass.id}</td>
					<td>${BorrowClass.title}</td>
					<td>${BorrowClass.studentname}</td>
					<td>${BorrowClass.borrowdate}</td>
					<td><a href="ReturnBook1?myID=${BorrowClass.id}">Return</a></td>
				</tr>
		</c:forEach>
	</table>
</body>
</html>