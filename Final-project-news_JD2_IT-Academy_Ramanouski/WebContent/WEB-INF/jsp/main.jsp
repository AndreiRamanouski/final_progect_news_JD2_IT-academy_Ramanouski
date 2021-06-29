<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>You are logged in</title>
	<link rel="stylesheet" href="style.css">
	
</head>

<body class="body">
	<a href="Controller?command=localization&language=en&commandRedirect=Controller%3Fcommand%3Dtomainpage">
	<spring:message code="en.button" /></a><br>
	<a href="Controller?command=localization&language=ru&commandRedirect=Controller%3Fcommand%3Dtomainpage">
	<spring:message code="ru.button" /></a>
	
	
	<c:if test="${param.message != 'null'}">
		<div align="center">
			<c:out value="${param.message}" />
		</div>
	</c:if>
	
	<a href="Controller?command=logout"><p align="left"><spring:message code="logout" /></p></a>

  	<font color="green" >	
		<c:out value="${param.message}"></c:out>
	</font>
  
  <div class = 'news'>
		<c:forEach var="n" items="${requestScope.news }">
			<tr>
				<td>
					<h2>
						<c:out value="${n.title }" /> 
						<br />
					</h2>
				
					<h5 align="left" style="font-family:Arial, Verdana, sans-serif">
						<c:out value="${n.brief }" />
				 		<a href="Controller?command=single_news&id=<c:out value="${n.id}"/>">
						<spring:message code="fullNews" />
					</h5>
				</td>
			</tr>
		</c:forEach>
	</div>
</body>
</html>