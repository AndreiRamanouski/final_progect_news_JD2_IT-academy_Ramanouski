<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<style>

</style>
 <link rel="stylesheet" href="style.css">
<meta charset="utf-8">
<title>Registration</title>
</head>

<body class='body'>

<a href="AnonymousController?command=localization&language=en&commandRedirect=AnonymousController%3Fcommand%3Dregistration">
<spring:message code="en.button" /></a><br>
<a href="AnonymousController?command=localization&language=ru&commandRedirect=AnonymousController%3Fcommand%3Dregistration">
<spring:message code="ru.button" /></a><br>

	
 <header >

	<form:form action="AnonymousController?command=savenewuser" modelAttribute="user" method="POST">
			<form:hidden path="idUser" />

				<label><spring:message code="name" />:</label><br>
			<form:input path="name" />
			<br>

				<label><spring:message code="surname" />:</label><br>
			<form:input path="surname" />
			<br>

				<label><spring:message code="login" />:</label><br>
			<form:input path="login" />
			<br>

				<label><spring:message code="password" />:</label><br>
			<form:input path="password" />
			<br>

				<label></label>
			<input type="submit" value='<spring:message code="save" />' class="save" />

		</form:form>
		
	</form>
	
	</header>
	</body>
</html>