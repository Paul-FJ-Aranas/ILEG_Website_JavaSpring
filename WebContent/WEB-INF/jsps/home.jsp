<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ILEG</title>
</head>
<body>
	<p>Welcome!	</p>
	
	<p><a href="${pageContext.request.contextPath}/users" >Users Online</a></p>
	<p><a href="${pageContext.request.contextPath}/createuser" >Create User Account</a></p>
    <p><a href="<c:url value='j_spring_security_logout' />">Log out</a></p>
</body>
</html>