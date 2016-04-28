<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
	<form:form method="POST"
		action="${pageContext.request.contextPath}${loginForm.userActionUrl}"
		modelAttribute="loginForm">
		<table>
			<spring:bind path="userId">
				<tr>
					<td>User Id</td>
					<td><input type="text" name="userId"></td>
					<td><form:errors path="userId" cssClass="error" /></td>
				</tr>
			</spring:bind>
			<tr>
				<td>User Name</td>
				<td><input type="text" name="userName"></td>
				<td><form:errors path="userName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="newPswd"></td>
				<td><form:errors path="newPswd" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Change Password</td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>