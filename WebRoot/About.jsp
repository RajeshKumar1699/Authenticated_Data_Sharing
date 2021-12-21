<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'About.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->


<style type="text/css">

p  {
    color: black;
    font-family: courier;
    font-size: 120%;
    
}







</style>



  </head>
  <jsp:include page="Header.jsp"></jsp:include>
  
  <body>
  <table width="100%" height="350px" cellspacing="0px"
				cellpadding="0px" style="background-color: BDB76B">
				<tr>
					<td width="20%">
						
					</td>
					<td width="70%" bgcolor="5F9EA0">
						<p style="vertical-align: top; text-align: center; font-size: 20;" >
Secure and efficient file storage and sharing via
authenticated physical devices remain challenging to achieve
in a cyber-physical cloud environment, particularly due to the
diversity of devices used to access the services and data. Thus in
this paper, we present a lightweight identity-based authenticated
data sharing protocol to provide secure data sharing among
geographically dispersed physical devices and clients. The proposed
protocol is demonstrated to resist chosen-ciphertext attack
(CCA) under the hardness assumption of decisional-Strong Diffie-
Hellman (SDH) problem. We also evaluate the performance of
the proposed protocol with existing data sharing protocols in
terms of computational overhead, communication overhead, and
response time.

	</p>
					</td>
					<td width="20%">
						
					</td>
				</tr>
			</table>
 

  </body>
</html>
