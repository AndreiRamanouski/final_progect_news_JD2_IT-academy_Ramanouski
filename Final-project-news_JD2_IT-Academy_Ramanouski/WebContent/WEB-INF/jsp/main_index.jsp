<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
import="java.util.List, by.htp.les04.bean.News"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Main Index</title>
<link rel="stylesheet" href="style.css">
<style>
.p{
text-align:left;
}
</style>



</head>
	<body class='body'>
	
<a href="AnonymousController?command=localization&language=en&commandRedirect=AnonymousController%3Fcommand%3Dtoindexpage">
<spring:message code="en.button" /></a><br>
<a href="AnonymousController?command=localization&language=ru&commandRedirect=AnonymousController%3Fcommand%3Dtoindexpage">
<spring:message code="ru.button" /></a><br>

	
 <header>
 
 <c:if test="${param.message != 'null'}">
	<font color="green" >	
		<c:out value="${param.message}"></c:out>
	</font>
	</c:if>
 	
	<a href="AnonymousController?command=registration">
	<spring:message code="registration" /></a>
	
	<form:form style="text-align: center" action="login" modelAttribute="user">	
	    <spring:message code="login" />: <br/>
		<form:input path="login" />
		<br/><br/>
		
	    <spring:message code="password" />:<br/>
		<form:input path="password" />
		<br/><br/>
		<input type="submit" value="<spring:message code='submit' />" />
	</form:form>
	<br><br>
	
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
					</h5>
				</td>
			</tr>
		</c:forEach>
	</div>
	
</header>


</body>
</html>