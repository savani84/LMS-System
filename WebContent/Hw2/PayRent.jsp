<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="PayRent" method="post">
		<table align="center" valign="middle" border="1">
			<tr>
				<td align="center" colspan="7">
					<h3>Leasing Management System</h3>
					Pay Rent
				</td>
			</tr>
			<tr>
				<td>
					<a href="ManagerHome">Home</a>
				</td>
				<td>
					<a href="ViewApartment">View Apartment</a>
				</td>
				<td align="center" colspan="2">
					Wel Come <%=session.getAttribute("name")%> !<a href=LMSlogout>Log Out</a>
				</td>
				<td colspan="2">
					<a href="RentHistory">Rent History</a>
				</td>
				<td>
					<a href=AddApartment>Add Apartment</a>
				</td>
			</tr>
			<tr>
				<th>
					Apartment ID
				</th>
				<th>
					User Name
				</th>
				<th>
					Rent
				</th>
				<th>
					Rent Paid
				</th>
				<th>
					Month
				</th>
				<th>
					Year
				</th>
				<th>
					Operation
				</th>
			</tr>
			<%@page import="java.util.List,HW2.Rent"%>
			<%List<Rent> Rententries = (List<Rent>)getServletContext().getAttribute("Rententries"); %>
			<%Integer mycnt = 0;%>
			<%if(Rententries != null){ %>
				<%for(Rent RentE : Rententries){ %>
					<%mycnt = mycnt + 1;%>
					<tr>
						<td><%=RentE.getAptno() %></td>
						<td><%=RentE.getCustname() %></td>
						<td><%=RentE.getRent() %></td>
						<input type="hidden" name="id<%=mycnt%>" value=<%=RentE.getrentid()%> />
						<td><input type="text" name="paid<%=mycnt%>" value="" /></td>
						<td>
							<select name="month<%=mycnt%>">
								<option>JAN</option>
								<option>FEB</option>
								<option>MAR</option>
								<option>APR</option>
								<option>MAY</option>
								<option>JUN</option>
								<option>JUL</option>
								<option>AUG</option>
								<option>SEP</option>
								<option>NOV</option>
								<option>DEC</option>
								<option Selected="true">SELECT MONTH</option>
							</select>
						</td>
						<td>
							<select name="year<%=mycnt%>">
								<option>2011</option>
								<option>2012</option>
								<option>2013</option>
								<option>2014</option>
								<option>2015</option>
								<option>2016</option>
								<option>2017</option>
								<option Selected="true">SELECT YEAR</option>
							</select>
						</td>
						<td align="center">
							<input type="submit" name="sub<%=mycnt%>" value="DONE" />
						</td>
					</tr>
				<%}%>
			<%}%>
			<input type="hidden" name="mycnt" value=<%=mycnt%> />
			<%if(request.getAttribute("ErrMsg4") != null){ %>
				<tr>
					<td colspan="7"><%=request.getAttribute("ErrMsg4")%></td>
				</tr>
			<%}%>
		</table>
	</form>
</body>
</html>