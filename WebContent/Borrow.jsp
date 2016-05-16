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
	<form method="post" action="Borrrow">
		<table>
			<tr>
				<td>
					Book ID
				</td>
				<td>
					<input readonly="true" type="text" name="LibID" value=${requestScope['myID']} />
				</td>
			</tr>
			<tr>
				<td>
					Book Title
				</td>
				<td>
					<input readonly="true" type="text" name="Title" value=${requestScope['myBookTitle']} />
				</td>
			</tr>
			<tr>
				<td>
					Student Name
				</td>
				<td>
					<input type="text" name="Student" value="" />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" name="submit" value="submit" />
				</td>
			</tr>
			<c:if test="${requestScope.ErrMsg2 != null}">
			<tr>
				<td colspan="2">
					<p color="red"><%=request.getAttribute("ErrMsg")%></p>
				</td>
			</tr>
		</c:if>
		</table>
	</form>
</body>
</html>