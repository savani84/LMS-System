<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Apartment</title>
</head>
<body>
	<table align="center" valign="middle" border="1">
		<tr>
			<td align="center" colspan="9">
				<h3>Leasing Management System</h3>
			</td>
		</tr>
		<tr>
			<td>
				<a href="ManagerHome">Home</a>
			</td>
			<td colspan="2">
				<a href="PayRent">Pay Rent</a>
			</td>
			<td align="center" colspan="4">
				Wel Come <%=session.getAttribute("name")%> !<a href=LMSlogout>Log Out</a>
			</td>
			<td>
				<a href="RentHistory">Rent History</a>
			</td>
			<td>
				<a href=AddApartment>Add Apartment</a>
			</td>
		</tr>
		<%@page import="java.util.List,HW2.Apartment,HW2.Appointment,HW2.Customer"%>
		<%List<Apartment> entries = (List<Apartment>)getServletContext().getAttribute("Appentries"); %>
		<%List<Appointment> AppoEntries = (List<Appointment>)getServletContext().getAttribute("AppoEntries");%>
		<%Integer Flag = 0; %>
		<%if(entries != null){ %>
			<tr>
				<th>Apt No</th>
				<th>Apt Type</th>
				<th>Facility</th>
				<th>Max ppl</th>
				<th>Rent</th>
				<th>Deposit</th>
				<th>Vacant</th>
				<th>Change Availablity</th>
				<th>Appoinments</th>
			</tr>
			<%for(Apartment entry: entries){ %>
				<tr>
					<td><%=entry.getAptNo()%></td>
					<td><%=entry.getType()%></td>
					<td><%=entry.getFacility()%></td>
					<td><%=entry.getMaxppl()%></td>
					<td><%=entry.getRent()%></td>
					<td><%=entry.getDeposit()%></td>
					<%if(entry.getVacant()){ %>
						<td>YES</td>
					<%}else{ %>
						<td>NO</td>
					<%}%>
					<%if(entry.getVacant()){ %>
						<td><a href="#">Make Available</a></td>
					<%}else{ %>
						<td></td>
					<%}%>
					<%Flag = 0; %>
					<%if(AppoEntries != null){ %>
						<%for(Appointment AppoE : AppoEntries){ %>
							<%if(AppoE.getAppNo().equals(entry.getAptNo())){%>
								<%Flag = 1; %>
								<break>
							<%} %>
						<%} %>
					<%} %>
					<%if(Flag == 1){ %>
						<td><a href="ViewAppointment?AptNo=<%=entry.getAptNo()%>">View</a></td>
					<%}else{%>
						<td></td>
					<%}%>
				</tr>
			<%}%>
		<%}%>
	</table>
</body>
</html>