<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/script/jquery.js"></script>

<script type="text/javascript">
	function onLoad() {

		$("#password").keyup(verifyMatchingPassword);
		$("#confirmingpassword").keyup(verifyMatchingPassword);
		$("#info").submit(allowSubmission);
	}
	function allowSubmission(){
		var password = $("#password").val();
		var confirmpassword = $("#confirmingpassword").val();
		
		if (password != confirmpassword){
			alert("Passwords do not match");
			return false;
		} else {
			
			return true;
		}
	}
	function verifyMatchingPassword() {
		var password = $("#password").val();
		var confirmpassword = $("#confirmingpassword").val();

		if (password.length > 3 || confirmpassword.length > 3) {

			if (password == confirmpassword) {
				$("#passwordmatch").text("Passwords match");
				$("#passwordmatch").addClass("validpass");
				$("#passwordmatch").removeClass("error");
			
			} else {
				$("#passwordmatch").text("Passwords do not match");
				$("#passwordmatch").addClass("error");
				$("#passwordmatch").removeClass("validpass");
			}
		}
	}
	$(document).ready(onLoad);
</script>


<link href="${pageContext.request.contextPath}/static/css/main.css/"
	rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create New Account</title>
</head>
<body>

	<h2>Create New Account</h2>
	<div class="form">
		<sform:form id="info" method="post"
			action="${pageContext.request.contextPath}/establishaccount"
			commandName="user">
			<table class="usertable">
				<tr>
					<td class="label">Name:</td>
					<td><sform:input class="formcontrol" path="username"
							name="username" type="text" /><br />
					<div class="error">
							<sform:errors path="username"></sform:errors>
						</div></td>
				</tr>
				<tr>
					<td class="label">Email:</td>
					<td><sform:input class="formcontrol" path="email" name="email"
							type="text" /><br />
					<div class="error">
							<sform:errors path="email"></sform:errors>
						</div></td>
				</tr>
				<tr>
					<td class="label">Password:</td>
					<td><sform:input id="password" class="formcontrol"
							path="password" name="password" type="text" /><br />
					<div class="error">
							<sform:errors path="password"></sform:errors>
						</div></td>

				</tr>
				<tr>
					<td class="label">Confirm Password:</td>
					<td><input id="confirmingpassword" class="formcontrol"
						name="passwordconfirm" type="text" /> <div id="passwordmatch"></div></td>
				</tr>
				<tr>
					<td></td>
					<td class="button"><input class="formcontrol"
						value="Create User" type="submit" /></td>
				</tr>
			</table>
		</sform:form>
	</div>


</body>
</html>