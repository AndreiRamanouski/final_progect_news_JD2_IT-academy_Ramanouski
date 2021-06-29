<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>You are reading the news</title>
<link rel="stylesheet" href="style.css">
</head>
<body class="body">

<a href="Controller?command=localization&language=en&commandRedirect=Controller%3Fcommand%3Dsingle_news%26id=${param['id']}">
<spring:message code="en.button" /></a><br>
<a href="Controller?command=localization&language=ru&commandRedirect=Controller%3Fcommand%3Dsingle_news%26id=${param['id']}">
<spring:message code="ru.button" /></a><br>
	
<a href="Controller?command=logout"><p align="left"><spring:message code="logout" /></p></a>

  <div class = 'news'>
	<c:set var="n" value='${requestScope["singleNews"]}' />
	
		<tr>
			<td>
				<p align="right">
				<c:out value="${n.date }" />
				</p>
				<h2>
				<c:out value="${n.title }" /> 
				<br />
				</h2>
				
				<h5 align="left" style="font-family:Arial, Verdana, sans-serif">
				<c:out value="${n.brief }" /> <br/>
				<c:out value="${n.content }" />
				
				
						<form action="AdminController" method="get">
      						<input type="hidden" name="command" value="editnews" />
      						<input type="hidden" name="id" value="${param['id']}">
							<button><spring:message code="edit" /></button>
						</form>
						
						<br />
						
						<form action="AdminController" method="get">
      						<input type="hidden" name="command" value="removenews" />
      						<input type="hidden" name="id" value="${param['id']}">
							<button><spring:message code="delete" /></button>
						</form>
				
				
		
				 
				</h5>
				<a href="Controller?command=tomainpage" align="center"><spring:message code="back" /></a>
			</td>
		</tr>
		
	
	</div>
</body>
</html>