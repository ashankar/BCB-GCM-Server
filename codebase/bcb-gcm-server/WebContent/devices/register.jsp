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
<form action="<%=IForward.REGISTER %>" method="post">
Device ID to register: <input type="text" name="<%=IString.DEVICE_ID %>"><br><br>
<input type="submit" name="submit" value="Register">
</form>

<br><br><br><a href="../index.jsp">Back</a>
</body>
</html>