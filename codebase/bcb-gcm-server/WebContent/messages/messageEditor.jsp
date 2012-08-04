<%@page import="org.bcb.gcm.resource.IForward"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bar Camp Bangalore</title>
</head>
<body>

	<form action="<%=IForward.SEND_MESSAGE %>">
		Write message (maximum: 140 char) <br>

		<textarea rows="7" cols="30" maxlength="140"></textarea>
		<br>
		<br> <input type="submit" name="submit" value="Send">
	</form>

<br><br><br><a href="../index.jsp">Back</a>
</body>
</html>
