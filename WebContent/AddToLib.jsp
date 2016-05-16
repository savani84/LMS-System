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
	<form action="AddToLibraryDB" method="post">
	<table>
		<tr>
			<td>
				ID
			</td>
			<td>
				<input type="text" name="LibID" value=${requestScope['htmlentries'].size() + 1} />
			</td>
		</tr>
		<tr>
			<td>
				Title
			</td>
			<td>
				<input type="text" name="Title"/>
			</td>
		</tr>
		<tr>
			<td>
				Author
			</td>
			<td>
				<input type="text" name="Author"/>
			</td>
		</tr>
		<tr>	
			<td>
				Copies
			</td>
			<td>
				<input type="text" name="Copies"/>
			</td>
		</tr>
		<tr>	
			<td colspan="2" align="center">
				<input type="submit" name="submit" value="submit"/>
			</td>
		</tr>
		<c:if test="${requestScope.ErrMsg != null}">
			<tr>
				<td colspan="2">
					<p color="red"><%=request.getAttribute("ErrMsg")%></p>
				</td>
			</tr>
		</c:if>
		</form>
	</table>
</body>
</html>