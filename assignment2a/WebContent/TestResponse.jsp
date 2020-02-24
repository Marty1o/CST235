<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test Response</title>
</head>
<body>

	Hello there
	<%=request.getAttribute("firstname")%><br> Is Your last name
	must be
	<%=request.getAttribute("lastname")%>



</body>
</html>