<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style type="text/css">
div.form {
	display: block;
	text-align: center;
}

form {
	display: inline-block;
	text-align: left;
	margin-left: auto;
	margin-right: auto;
}

.usertable {
	width: 400px padding: 10px;
	border: 1px blue solid
}

input[type=text] {
	width: 250px
}

.label {
	text-align: right vertical-align: top
}

.button {
	text-align: center
}

.formcontrol {
	margin-left: 10px
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="form">
		<form method="post"
			action="${pageContext.request.contextPath}/docreate">
			<table class="usertable">
				<tr>
					<td class="label">Name:</td>
					<td><input class="formcontrol" name="name" type="text" /></td>
				</tr>
				<tr>
					<td class="label">Email:</td>
					<td><input class="formcontrol" name="email" type="text" /></td>
				</tr>
				<tr>
					<td></td>
					<td class="button"><input class="formcontrol"
						value="Create User" type="submit" /></td>
				</tr>
			</table>
		</form>
	</div>


</body>
</html>