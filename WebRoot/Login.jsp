<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'CommuneLogin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="css/a.css" rel="stylesheet" type="text/css" media="all"/>
			<script type="text/javascript">
function validator() {

		document.getElementById("msguid").innerHTML = "";
		document.getElementById("msgpass").innerHTML = "";

	if (document.getElementById("uid").value == "") {

		document.getElementById("msguid").innerHTML = "Plealse Enter User ID";
		return false;
	} else if (document.getElementById("pass").value == "") {

		document.getElementById("msgpass").innerHTML = "Plealse Enter Password";
		return false;
	}

}
</script>
  </head>  
  <jsp:include page="Header.jsp"></jsp:include>
  
  <body> 
  <center>
<div style="width: 1000px; height: auto; margin-top: -15px;">
			<div class="signup" style="margin-top: -1px; width: 100%;">
			<br/><br/>
			<h2><font color=green> LOGIN HERE</font></h2>   
			<center>
			
		<form action="./LoginServlet"  onsubmit="return validator();">
                <table border="0"  style="" width="305px"  >   
                          	
                	<tr>
                	<td colspan="2" style="">
                	<label style="color: red; font-style:italic; text-align: center; ">
                	<% String status=request.getParameter("status"); if(status!=null){out.println(status);} %></label>      
           
                	</td>
                	</tr>
                	
                    <tr>
                        <td>Login ID : <span class="dot"></span></td>
                        <td><input type="text" name="loginid" id="uid" class="input_text"  value="" placeholder="Please Enter Valid Loginid" autofocus/>
                         <label id="msguid"  style="color: red;font-size: 16px;font-style: italic;"></label>
                      
                        </td>
                    </tr>
                    <tr>
                	<td> &nbsp; </td>
                	<td> &nbsp; </td>
                	</tr>
                    <tr>
                        <td>Password : <span class="dot"></span></td>
                        <td><input type="password" name="password" id="pass" class="input_password" value="" placeholder="Please Enter Valid Password">
                         <label id="msgpass"  style="color: red;font-size: 16px;font-style: italic;"></label>
                      </td>
                    </tr>
                    <tr>
                	<td> &nbsp; </td>
                	<td> &nbsp; </td>
                	</tr>
                    <tr>
                        <td> &nbsp; </td>
                        <td><input type="submit" class="submit" value="LOGIN"></td>
                    </tr>
                    
                </table>
            </form>	 
        
			</center>
			</div>
			</div>
		 
		</center>
		<div style="margin-top: -3px;">
				
		</div>  
  </body>
 
</html>
