<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.bean.*"%>

<%@page import="com.dao.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP '' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		
		<!--<link rel="stylesheet" type="text/css" href="css/tables.css">
		
	--><script type="text/javascript">
function validator() {

		document.getElementById("msg").innerHTML = "";
		if (document.getElementById("msg").value == "") {

		document.getElementById("msg").innerHTML = "Please Upload msg";
		return false;
	}
		</script>
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
					<h2>
						<font color="blue">Message Upload Here</font>
					</h2>
					<center>
					
						<%
							String userid=(String)session.getAttribute("userid");
							
						UsersDetailsDao rod=new UsersDetailsDao();
							
							ArrayList<ProfileBean> list=rod.getdata(userid);
							System.out.println(list);
						%>

						<%
							String status = request.getParameter("status");
							if (status != null) {
								out.println(status);
							}
						%>
						<table border="2" align="center">

							<%
								for (ProfileBean bcb : list) {
							%>
							<tr>
								<form action="./MessageUploadServlet">
									
									
									
										<table border="1" width="530" height="186">

											<tr>
												<td align='left'>
													Login Id
												</td>
												<td align="left">
				<font color="#0080ff"><input type="text" name="loginid"	value="<%=session.getAttribute("userid")%>" readonly="readonly">
													</font>
													<br>
												</td>
											</tr>

											
											
											
											<tr>
												<td align='left'>
													Subject
												</td>
												<td align="left">
												<font color="#0080ff">
												<input type="text" name="subject" /> 
                                               </font>
													<br>
												</td>
											</tr>
											<tr>
												<td align='left'>
													Encription File Key
												</td>
												<td align="left">
												<font color="#0080ff">
												<input type="text" name="key" /> (please enter 16 digits)
                                               </font>
													<br>
												</td>
											</tr>
											
																						
												<tr>
                        <td>Message:</td>
                        <td><input type="text" name="message" id="msg" class="input_text" value="">
                        
                      </td>
                    </tr>
													
											<tr>
												<td></td>
												<td>
													<input type="submit" value="submit" />
												</td>
											</tr>
										</table>
								</form>

							</tr>
							<%
								}
							%>
						</table>
					</center>
				</div>
				</div>
				</center>
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
				
	</body>
</html>
