<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>

<%@page import="java.sql.Connection"%>


<%@page import="com.util.Dbconnection"%>
<%@page import="com.bean.ProfileBean"%>
<%@page import="java.sql.PreparedStatement"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%

HttpServletResponse httpResponse = (HttpServletResponse)response;

httpResponse.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); 
response.addHeader("Cache-Control", "post-check=0, pre-check=0");
httpResponse.setHeader("Pragma","no-cache"); 
httpResponse.setDateHeader ("Expires", 0); 

String uid=(String)session.getAttribute("userid");
if(uid==null)
{

response.sendRedirect("Login.jsp?status=Please Enter UserName and Password");
return ;
}


%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Cloud</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/table.css">

	
<jsp:include page="Header.jsp"></jsp:include>
<br/><br/>
  </head>
    <% if(request.getParameter("status")!=null) 
					  {%>
                           <h3 style=color:red><center><strong><%=request.getParameter("status")%></strong></center></h3>
                      <%}%>
  <body>
  
  
  
  
  
      <h3 align="center" style="color: #cc0066">View Users Status</h3>
  
  <table align="center">
  <%ResultSet rs1=null; %>
  <tr>

<th style="text-align: center;color: #99004d">Id</th>
<th style="text-align: center;color: #99004d">LoginId</th>
<th style="text-align: center;color: #99004d">UserName</th>
<th style="text-align: center;color: #99004d">Role</th>



</tr>

<%String userid=(String) session.getAttribute("userid");%>

<%
      
   try
   {
  Dbconnection dc=new Dbconnection();
  Connection con = dc.getConnection();
  
  
  
	     		
    PreparedStatement st1=con.prepareStatement("select LID,LOGINID,USERNAME,ROLE from LOGINDETAILS where (role='USER' or role='OWNER') and status='1'");
   
  
  
   rs1=st1.executeQuery();
   while(rs1.next())
   {%>
  <tr>
  <td><%=rs1.getInt(1) %></td>

<td><%=rs1.getString(2) %></td>

<td><%=rs1.getString(3) %></td>
							
	<td><%=rs1.getString(4) %></td>




</tr>
  
   <%   } }
    
    catch(Exception e){
        e.printStackTrace();
        
    }
  
%>



	
	
						
			
				</table>
														



</form>


  </body>
  

<br/>
				<br/>
				<br/>
				<br/>
				<br/>
				<br>
				<br/>
				<br/>

				<div style="margin-top: -3px;">
				<jsp:include page="Footer.jsp"></jsp:include>
		</div>
				

</html>
