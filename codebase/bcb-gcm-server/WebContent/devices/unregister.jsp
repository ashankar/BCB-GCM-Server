<%@page import="java.util.List"%>
<%@page import="org.bcb.gcm.servlet.DataStore"%>
<%@page import="org.bcb.gcm.resource.IForward"%>
<%@page import="org.bcb.gcm.resource.IString"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bar Camp Bangalore</title>
</head>
<body>
	<form action="<%=IForward.UN_REGISTER%>">
		<%
			List<String> devices = DataStore.getDevices();
		%>

		Select a device ID to unregister : <select
			name="<%=IString.DEVICE_ID%>">
			<%
				for (String s : devices) {
			%>
			<option><%=s%></option>

			<%
				}
			%>

		</select> <br> <br> <input type="submit" name="submit"
			value="Unregister">
	</form>

	<br>
	<br>
	<br>
	<a href="../index.jsp">Back</a>
</body>
</html>