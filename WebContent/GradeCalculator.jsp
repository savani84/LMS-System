<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Grade Calculator</title>
<script type="text/javascript">
	function isNumber(evt) {
	    evt = (evt) ? evt : window.event;
	    var charCode = (evt.which) ? evt.which : evt.keyCode;
	    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
	        return false;
	    }
	    return true;
	}
</script>
</head>
<body>
	<form action="GradeCalculator" method="post">
	<table border="1">
		<tr>
			<th>
				Title
			</th>
			<th>
				User Total
			</th>
			<th>
				Total Point
			</th>
		</tr>
		<tr>
			<td>
				Home Work
			</td>
			<td>
				<table>
					<tr>
						<td>
							Hw0
						</td>
						<td>
							Hw1
						</td>
						<td>
							Hw2
						</td>
						<td>
							Hw3
						</td>
						<td>
							Hw4
						</td>
					</tr>
					<tr>
						<td>
							<input type="text" name="Hw0" size="3" onkeypress="return isNumber(event)"/>
						</td>
						<td>
							<input type="text" name="Hw1" size="3"  onkeypress="return isNumber(event)" />
						</td>
						<td>
							<input type="text" name="Hw2" size="3"  onkeypress="return isNumber(event)"/>
						</td>
						<td>
							<input type="text" name="Hw3" size="3"  onkeypress="return isNumber(event)"/>
						</td>
						<td>
							<input type="text" name="Hw4" size="3"  onkeypress="return isNumber(event)"/>
						</td>
					</tr>
				</table>
			</td>
			<td valign="middle">
				<input type="text" name="TotHw" value="365" readonly="true" />
			</td>
		</tr>
		<tr>
			<td>
				Lab
			</td>
			<td>
				<table>
					<tr>
						<td>
							lab1
						</td>
						<td>
							lab2
						</td>
						<td>
							lab3
						</td>
						<td>
							lab4
						</td>
						<td>
							lab5
						</td>
						<td>
							lab6
						</td>
					</tr>
					<tr>
						<td>
							<input type="text" name="lab1" size="3"  onkeypress="return isNumber(event)"/>
						</td>
						<td>
							<input type="text" name="lab2" size="3"  onkeypress="return isNumber(event)"/>
						</td>
						<td>
							<input type="text" name="lab3" size="3" onkeypress="return isNumber(event)" />
						</td>
						<td>
							<input type="text" name="lab4" size="3" onkeypress="return isNumber(event)" />
						</td>
						<td>
							<input type="text" name="lab5" size="3" onkeypress="return isNumber(event)" />
						</td>
						<td>
							<input type="text" name="lab6" size="3" onkeypress="return isNumber(event)" />
						</td>
					</tr>
				</table>
			</td>
			<td valign="middle">
				<input type="text" name="Totlab" value="310" readonly="true" />
			</td>
		</tr>
		<tr>
			<td>
				Mid Term
			</td>
			<td>
				<input type="text" name="MidTm" onkeypress="return isNumber(event)" />
			</td>
			<td>
				<input type="text" name="TotMidTm" value="140" readonly="true" />
			</td>
		</tr>
		<tr>
			<td>
				Finals
			</td>
			<td>
				<input type="text" name="final" onkeypress="return isNumber(event)" />
			</td>
			<td>
				<input type="text" name="Totfinal" value="120" readonly="true" />
			</td>
		</tr>
		<tr>
			<td>
				Attendance
			</td>
			<td>
				<input type="text" name="Attendance" onkeypress="return isNumber(event)" />(0 - 5 %)
			</td>
			<td></td>
		</tr>
		<tr>
			<td colspan="3" align="center">
				<input type="submit" name="Calculator" value="Calculator" />
			</td>
		</tr>
		<%if(request.getAttribute("ErrMsg") != null){ %>
			<tr>
				<td colspan="3"><%=request.getAttribute("ErrMsg")%></td>
			</tr>
		<%}%>
		<%if(request.getAttribute("Grad") != null){ %>
			<tr>
				<td colspan="3">congratulations your grad is <%=request.getAttribute("Grad")%></td>
			</tr>
		<%}%>
	</table>
	</form>
</body>
</html>