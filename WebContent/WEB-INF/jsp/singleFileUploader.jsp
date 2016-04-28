<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring 4 MVC File Upload Example</title>
</head>
<body>
	<div class="form-container">
		<h1>Spring 4 MVC File Upload Example</h1>
		<form:form method="POST" modelAttribute="fileBucket"
			enctype="multipart/form-data"
			action="${pageContext.request.contextPath}${fileBucket.userActionUrl}">
			<table>
				<spring:bind path="file">
					<tr>
						<td>Upload a file</td>
						<td><form:input type="file" path="file" id="file" name="file"/></td>
						<td><form:errors path="file" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Upload"></td>
					</tr>
				</spring:bind>
			</table>
		</form:form>
	</div>
</body>
</html>