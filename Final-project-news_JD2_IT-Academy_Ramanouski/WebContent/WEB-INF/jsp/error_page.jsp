<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
<link rel="stylesheet" href="style.css">

</head>


<body>
	
<a href="AnonymousController?command=localization&language=en&commandRedirect=AnonymousController%3Fcommand%3Derrorpage">
<spring:message code="en.button" /></a><br>
<a href="AnonymousController?command=localization&language=ru&commandRedirect=AnonymousController%3Fcommand%3Derrorpage">
<spring:message code="ru.button" /></a><br>
	
	<c:if test="${param.message != 'null'}">
			<div align="center">
				<c:out value="${param.message}" />
			</div>
	</c:if><br />

		<a href="AnonymousController?command=toindexpage"> 
			<spring:message code="mainpage" />
		</a>

</body>
</html>