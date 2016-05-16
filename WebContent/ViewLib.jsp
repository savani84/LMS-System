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
			<td>Pages</td>
			<td>Action</td>
		</tr>

		<c:forEach items="${requestScope['htmlentries']}" var="Library" varStatus="status">
				<tr>
					<td>${Library.libid}</td>
					<td>${Library.title}</td>
					<td>${Library.author}</td>
					<td>${Library.pages}</td>
					<c:choose>
					    <c:when test="${Library.pages != 0}">
					       <td><a href="Borrrow?myID=${Library.libid}&myBookTitle=${Library.title}">Borrrow</a></td>
					    </c:when>
					    <c:otherwise>
					        <td>Can't borrow</td>
					    </c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
		<tr>
			<td colspan="5">
				<a href="AddToLibraryDB">Add To Library</a><a href="ReturnBook">Return Book</a>
			</td>
		</tr>
	</table>
</body>
</html>