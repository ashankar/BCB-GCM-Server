<%@page import="java.util.List"%>
<%@page import="org.bcb.gcm.servlet.DataStore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bar Camp Bangalore</title>
</head>
<body>
	<h2>Registered devices</h2>
	<br>
	<br>

	<%
		List<String> list = DataStore.getDevices();

		if (list.size() > 0) {

			int count=1;
			%>
			
			<b>S. No.  &nbsp;&nbsp;  Device ID</b>
			<br>
			<%
			for (String s : list) {
		%>
			 <%=count %>. &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			 <%=s %><br>	
				
				<%
				count++;
			}
		} else {
			out.println("no device available");
		}
	%>
	
	<br><br><br><a href="../index.jsp">Back</a>
</body>
</html>