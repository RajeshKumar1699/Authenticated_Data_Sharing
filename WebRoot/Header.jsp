<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Header.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div style="padding: 30px; text-align: center; width: 100%; background-color: rgb(228, 231, 254);"/>
  <h2><font face="Calibri"><b><i><font size="8" color="9ACD32">Provably secure and lightweight identity-based
authenticated data sharing protocol for cyber-physical cloud environment</font></i></b></font></h2> 
  </div>


		<c:choose>
			<c:when test="${sessionScope.role eq'ADMIN'}">
				<jsp:include page="./AdminMenu.jsp" />
			</c:when>
			<c:when test="${sessionScope.role eq 'OWNER'}">
				<jsp:include page="./OwnerMenu.jsp" />
			</c:when>
			
			
			<c:when test="${sessionScope.role eq 'USER'}">
				<jsp:include page="./UserMenu.jsp" />
			</c:when>
			
			
			
			
			
			<c:when test="${sessionScope.role eq null}">
				<jsp:include page="./HomeMenu.jsp" />
			</c:when>
			
			
			
			
			
			
			
			
		</c:choose>
		<br>
		<br>
		<br>
		<font color="red">
		<center>
		<b> <c:if test="${requestScope.status!='null'}">
				<c:out value="${requestScope.status}"></c:out>
			</c:if> </b>
		</font>
		</center>
	</body>
</html>