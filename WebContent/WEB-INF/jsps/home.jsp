<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ILEG</title>
</head>
<body>
	<p>Welcome!
	
</p>


	<c:forEach var="row" items="${users}">
    ID: ${row.id}<br />
    Name: ${row.name}<br />
    Email: ${row.email}<br />
	</c:forEach>
</body>
</html>