<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@page import="java.util.List,HW2.Apartment,HW2.Appointment,HW2.Customer,java.lang.*,java.text.DateFormat,java.text.SimpleDateFormat"%>
	<%List<Apartment> entries = (List<Apartment>)getServletContext().getAttribute("Appentries"); %>
	<%List<Appointment> AppoEntries = (List<Appointment>)getServletContext().getAttribute("AppoEntries");%>
	<%List<Customer> CustEntries = (List<Customer>)getServletContext().getAttribute("entries");%>
	<%String Apt =(String)request.getParameter("AptNo");%>
	<%Integer AptNo = 0;%>
	<%if(Apt != null && !Apt.isEmpty()){ %>
		<%AptNo = Integer.parseInt(Apt.trim());}%>
	<form method="post" action="./ScheduleAppointment">		
	<table align="center" valign="middle" border="1">
		<%for(Apartment entry : entries){ %>
			<%if(entry.getAptNo().equals(AptNo)){ %>
				<tr>
					<td>
						Apartment#
					</td>
					<td>
						<input readonly="true" type="text" name="AptNo" value=<%=entry.getAptNo()%> />
					</td>
				</tr>
				<tr>
					<td>
						Type
					</td>
					<td>
						<%if(entry.getType().equals("1BD,1 Bath")){ %>
							<input type="radio" name="Type" value="1BD,1 Bath" checked=true>1BHK</input><br/>
						<%}else{ %>
							<input type="radio" name="Type" value="1BD,1 Bath">1BHK</input><br/>
						<%} %>
						<%if(entry.getType().equals("2BD,1 Bath")){ %>
							<input type="radio" name="Type" value="2BD,1 Bath" checked=true>2BHK - 1 Bath</input><br/>
						<%}else{ %>
							<input type="radio" name="Type" value="2BD,1 Bath">2BHK - 1 Bath</input><br/>
						<%} %>
						<%if(entry.getType().equals("2BD,2 Bath")){ %>
							<input type="radio" name="Type" value="2BD,2 Bath" checked=true>2BHK - 2 Bath</input>
						<%}else{ %>
							<input type="radio" name="Type" value="2BD,2 Bath">2BHK - 2 Bath</input>
						<%} %>
					</td>
				</tr>
				<tr>
					<td>
						Facility
					</td>
					<td>
						<textarea readonly="true" name="facility"><%=entry.getFacility()%></textarea>
					</td>
				</tr>
				<tr>
					<td>
						Max ppl
					</td>
					<td>
						<input type="text" name="Maxppl" value=<%=entry.getMaxppl()%> />
					</td>
				</tr>
				<tr>
					<td>
						Rent
					</td>
					<td>
						<input type="text" name="Rent" value=<%=entry.getRent()%> />
					</td>
				</tr>
				<tr>
					<td>
						Deposit
					</td>
					<td>
						<input type="text" name="Deposit" value=<%=entry.getDeposit()%> />
					</td>
				</tr>
			<%}%>
		<%}%>
	</table>
	<%Integer mycnt = 0;%>
	<%DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");%>
	<table align="center" valign="middle" border="1">
				<tr>
					<th>Application #</th>
					<th>Application Name</th>
					<th>Contact #</th>
					<th># People</th>
					<th>Occupation</th>
					<th>Preference</th>
					<th>Need Date</th>
					<th>Status</th>
					<th>Reschedule Date</th>
					<th>Ruled out Date</th>
					<th>Rent Out</th>
				</tr>
		<%for(Appointment AppoE : AppoEntries){ %>
			<%if(AppoE.getAppNo().equals(AptNo)){ %>
				<%for(Customer CustE : CustEntries){ %>
					<%if(AppoE.getCusName().equals(CustE.getUserNm())){ %>
						<tr>
							<%mycnt = mycnt + 1;%>
							<td><%=mycnt %></td>
							<td><input readonly="true" type="text" name="usr<%=mycnt%>" value=<%=CustE.getUserNm()%> /></td>
							<td><%=CustE.getContact()%></td>
							<td><%=CustE.getpplNo()%></td>
							<td><%=CustE.getOccupation()%></td>
							<td><%=CustE.getPreference()%></td>
							<td><%=sdf.format(CustE.getNeedDate())%></td>
							<td><%=AppoE.getStatus()%></td>
							<%if(AppoE.getSchedule() == null){ %>
								<td><input type="text" name="txt<%=mycnt%>" value="" />
									<input type="submit" name="sub<%=mycnt%>" value="Schedule" /></td>
								<td></td>
							<%}else{%>
								<%if(!AppoE.getStatus().equals("Appointment Confirm")){ %>
									<td><input type="text" name="txt<%=mycnt%>" value="" />
										<input type="submit" name="sub<%=mycnt%>" value="ReSchedule" /></td>
								<%}else{%>
									<td></td>
								<%}%>
									<td><%=sdf.format(AppoE.getSchedule())%></td>
							<%}%>
							<%if(AppoE.getStatus().equals("Appointment Confirm")){ %>
								<td><a href="RentOut?CutName=<%=AppoE.getCusName()%>&AptNo=<%=AppoE.getAppNo()%>">Rent Out</a></td>
							<%}else{%>
								<td></td>
							<%}%>
						</tr>
					<%} %>
				<%} %>
			<%} %>
		<%} %>
		<input type="hidden" name="mycnt" value=<%=mycnt%> />
		<%if(request.getAttribute("ErrMsg2") != null){ %>
			<tr>
				<td colspan="8"><%=request.getAttribute("ErrMsg2")%></td>
			</tr>
		<%}%>
	</table>
	</form>
</body>
</html>