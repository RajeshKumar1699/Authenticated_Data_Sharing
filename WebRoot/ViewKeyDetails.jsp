<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.bean.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>My JSP '' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/table.css">
  </head>
  
  <body>
  <%
				String u = (String) session.getAttribute("userid");
				if (u == null) {
					String target = "Login.jsp?status=Please Enter UserName and Password";
					RequestDispatcher rd = request.getRequestDispatcher(target);
					rd.forward(request, response);
				}
			%>
   <center>
<div style="width: 1000px; height: auto; margin-top: -15px;">

			<jsp:include page="Header.jsp"></jsp:include>
			
			<div class="signup" style="margin-top: -1px; width: 100%;">
			
			<center>
			
  <%
    ArrayList<ProfileBean> al=new ArrayList<ProfileBean>();
    al=(ArrayList)session.getAttribute("list");
     %>
   <center><h1><font style="color: rgb(0, 0, 136)" face="Algerian">View  Message Key Details</font></h1></center>
<table border='1px' align='center' bordercolor="black">
<tr>

 <th><font color="blue" >MESSAGEID</font></th>
 
 <th><font color="blue">SUBJECT</font></th>
 <th><font color="blue" >KEY</font></th>

 
  </tr>
 
  <%for(ProfileBean pb:al){ %>
<tr>

 <td>
  <font color="green"><%=pb.getMid()%></font>
</td>
  
 <td>
<font color="green"><%=pb.getSubject()%></font>
 </td>
 <td>
<font color="green"><%=pb.getKey()%></font>
 </td>
 
 
 
 
 </tr>
  
  
  
  
  <%  } %>
  
  
  
  
  
</table>
 </center>
 </div>
 </div>
 </center>
 

   <div style="margin-top: -3px;">
				<jsp:include page="Footer.jsp"></jsp:include>
		</div>
 
  
  
  </body>
</html>

