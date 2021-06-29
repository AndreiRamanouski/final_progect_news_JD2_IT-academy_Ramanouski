<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>You are about to change the news</title>
	<link rel="stylesheet" href="style.css">
<style>
.title{
align:right;
width:700px;
height:20px;
}
.brief{
width:700px;
height:50px;
}
.content{
width:700px;
height:250px;
}
</style>

</head>



<body class="body">

	<a href="AdminController?command=localization&language=en&commandRedirect=AdminController%3Fcommand%3Deditnews%26id=${param['id']}">
	<spring:message code="en.button" /></a><br>
	<a href="AdminController?command=localization&language=ru&commandRedirect=AdminController%3Fcommand%3Deditnews%26id=${param['id']}">
	<spring:message code="ru.button" /></a><br>


	
<div id="container" align="center" style="position: absolute; left: 150px; right: 150px;">
	<form:form action="AdminController?command=savenews" modelAttribute="singleNews" method="POST">
		<form:hidden path="id" />

		<form:textarea class="title" path="title" rows="1" cols="80"></form:textarea><br>
		<form:textarea class="brief" path="brief" rows="3" cols="80"></form:textarea><br>
		<form:textarea class="content" path="content" rows="10" cols="80"></form:textarea><br>		

		<input type="submit" value="<spring:message code='save' />" class="save" />

	</form:form>

	<form action="Controller" method="get">
		<input type="hidden" name="command" value="single_news" />
		<input type="hidden" name="id" value="${param['id']}" />
		<input type="submit" value="<spring:message code='cancel' />" />
	</form>
	</div>
	
</body>
</html>