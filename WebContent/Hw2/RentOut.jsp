<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="RentOut" method="post">
	<table border="1" align="center">
		<%String Apt =(String)request.getParameter("AptNo");%>
		<%String CutName =(String)request.getParameter("CutName");%>
		<%Integer AptNo = 0;%>
		<%if(Apt != null && !Apt.isEmpty()){ %>
			<%AptNo = Integer.parseInt(Apt.trim());}%>
		<tr>
			<td>
				Apt No
			</td>
			<td>
				<input type="text" name="AptNo" value="<%=AptNo%>" readonly=true />
			</td>
		</tr>
		<tr>
			<td>
				Customer Name
			</td>
			<td>
				<input type="text" name="CutName" value="<%=CutName%>" readonly=true />
			</td>
		</tr>
		<tr>
			<td>
				Lease Date
			</td>
			<td>
				<input type="text" name="LDate" value="" />
			</td>
		</tr>
		<tr>
			<td>
				Lease Holder Name
			</td>
			<td>
				<input type="text" name="LName" value="" />
			</td>
		</tr>
		<tr>
			<td>
				Document List
			</td>
			<td>
				<input type="text" name="DocList" value="" />
			</td>
		</tr>
		<tr>
			<td>
				Deposit
			</td>
			<td>
				<input type="text" name="Deposit" value="" />
			</td>
		</tr>
		<tr>
			<td>
				Rent
			</td>
			<td>
				<input type="text" name="Rent" value="" />
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" name="submit" value="submit" />
			</td>
		</tr>
		<%if(request.getAttribute("ErrMsg3") != null){ %>
			<tr>
				<td colspan="2"><%=request.getAttribute("ErrMsg3")%></td>
			</tr>
		<%}%>
	</table>
	</form>
</body>
</html>