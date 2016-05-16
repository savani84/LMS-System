<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table align="center" valign="middle" border="1">
		<tr>
			<td align="center" colspan="6">
				<h3>Leasing Management System</h3>
				Rent History
			</td>
		</tr>
		<tr>
			<td>
				<a href="ManagerHome">Home</a>
			</td>
			<td>
				<a href="PayRent">Pay Rent</a>
			</td>
			<td align="center" colspan="2">
				Wel Come <%=session.getAttribute("name")%> !<a href=LMSlogout>Log Out</a>
			</td>
			<td>
				<a href="ViewApartment">View Apartment</a>
			</td>
			<td>
				<a href=AddApartment>Add Apartment</a>
			</td>
		</tr>
		<tr>
			<th>Apartment #</th>
			<th>User Name</th>
			<th>Rent</th>
			<th>Rent Paid</th>
			<th>Month</th>
			<th>Year</th>
		</tr>
		<%@page import="java.util.List,HW2.RentPaid"%>
		<%List<RentPaid> RentPaidentries = (List<RentPaid>)getServletContext().getAttribute("RentPaidentries");%>
		<%if(RentPaidentries != null){ %>
			<%for(RentPaid RentPaidentry: RentPaidentries){ %>
				<tr>
					<td><%=RentPaidentry.getAptno()%></td>
					<td><%=RentPaidentry.getCustname()%></td>
					<td><%=RentPaidentry.getRent()%></td>
					<td><%=RentPaidentry.getPaidrent()%></td>
					<td><%=RentPaidentry.getMonth()%></td>
					<td><%=RentPaidentry.getYear()%></td>
				</tr>
			<%}%>
		<%}%>
	</table>
</body>
</html>