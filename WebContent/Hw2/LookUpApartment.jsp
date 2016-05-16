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
	<table align="center" valign="middle" border="1">
		<tr>
			<td align="center" colspan="9">
				<h3>Leasing Management System</h3>
			</td>
		</tr>
		<tr>
			<td align="center" colspan="9"><%=session.getAttribute("name")%><a href=LMSlogout>Log Out</a>
			</td>
		</tr>
		<%@page import="java.util.List,HW2.Apartment,HW2.Appointment,HW2.Customer,java.text.DateFormat,java.text.SimpleDateFormat"%>
		<%List<Apartment> entries = (List<Apartment>)getServletContext().getAttribute("Appentries"); %>
		<%DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss"); %>
		<%if(entries != null){ %>
			<tr>
				<th>Apt No</th>
				<th>Apt Type</th>
				<th>Facility</th>
				<th>Max ppl</th>
				<th>Rent</th>
				<th>Deposit</th>
				<th>Status</th>
				<th>Operation</th>
				<th>Accept/Deny</th>
			</tr>
			<%Integer Flag = 0;%>
			<%Integer Flag2 = 0; %>
			<%List<Appointment> AppoEntries = (List<Appointment>)getServletContext().getAttribute("AppoEntries");%>
			<%List<Customer> CustEntries = (List<Customer>)getServletContext().getAttribute("entries");%>
			<%for(Apartment entry: entries){ %>
			<%if(entry.getVacant()){ %>
				<tr>
					<td><%=entry.getAptNo()%></td>
					<td><%=entry.getType()%></td>
					<td><%=entry.getFacility()%></td>
					<td><%=entry.getMaxppl()%></td>
					<td><%=entry.getDeposit()%></td>
					<td><%=entry.getRent()%></td>
					
					<%Flag2 = 0;%>
					<%if(AppoEntries != null){%>
						<%for(Appointment AppEnt : AppoEntries){%>
							<%if(AppEnt.getCusName().equals(session.getAttribute("name"))){ %>
								<%if(AppEnt.getAppNo().equals(entry.getAptNo())){ %>
									<%if(Flag2 == 1){%>
										</tr><tr>
										<td><%=entry.getAptNo()%></td>
										<td><%=entry.getType()%></td>
										<td><%=entry.getFacility()%></td>
										<td><%=entry.getMaxppl()%></td>
										<td><%=entry.getDeposit()%></td>
										<td><%=entry.getRent()%></td>
									<%}%>
									<td><%=AppEnt.getStatus()%></td>
									<%if(AppEnt.getSchedule() != null){ %>
										<td><%=sdf.format(AppEnt.getSchedule())%></td>
										<%if(AppEnt.getStatus().equals("Scheduled")){ %>
											<td><a href="AcceptAppointment?CusName=<%=session.getAttribute("name")%>&AptNo=<%=entry.getAptNo()%>&ScheduleDate=<%=sdf.format(AppEnt.getSchedule())%>"><button>Accept</button></a>
											<a href="DenyAppointment?CusName=<%=session.getAttribute("name")%>&AptNo=<%=entry.getAptNo()%>&ScheduleDate=<%=sdf.format(AppEnt.getSchedule())%>"><button>Deny</button></a></td>
										<%}else{%>
											<td></td>
										<%}%>
									<%}else{ %>
										<td></td>
										<td></td>
									<%}%>
									<%Flag = 1;%>
									<%Flag2 = 1;%>
								<%}%>
							<%}%>
						<%}%>	
					<%}%>
					<%if(Flag == 0){ %>
						<td></td>
						<td><a href="RequestAppointment?CusName=<%=session.getAttribute("name")%>&AptNo=<%=entry.getAptNo()%>">Request Appointment</a></td>
						<td></td>
					<%}%>
					<%Flag = 0;%>
				</tr>
			<%}}%>
		<%}%>
	</table>
</body>
</html>