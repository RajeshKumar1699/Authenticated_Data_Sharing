package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.ProfileBean;
import com.dao.LoginDao;

public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();


		
		String target = "Login.jsp?status=Invalid username and password";
		
		String usertype="";
	     String username="";
		
		String loginid=request.getParameter("loginid");
		
		String password=request.getParameter("password");
	
		ProfileBean pb=new ProfileBean();
		
		
		try
		{
		
		HttpSession session = request.getSession();
		
		
		//session.setAttribute("userid",userid);
		
		pb.setLoginid(loginid);
		
		pb.setPassword(password);
		
		
		ProfileBean pb1=new ProfileBean();
		
		LoginDao dao=new LoginDao();
		/*LoginServicei ls=new LoginServiceImpl();*/
	
		pb1=dao.loginCheck(pb);
		
		usertype=pb1.getRole();
		
		username=pb1.getUsername();

		
		
		session.setAttribute("role",usertype);
		
		System.out.println("uuuuuuuuu"+usertype);
		
		
		
		//session.setAttribute("userid", request.getParameter("userid"));
		
      if(usertype.equals("ADMIN"))
      {          
         target = "AdminHome.jsp?status=Welcome "+loginid;
         session.setAttribute("userid",loginid);
         session.setAttribute("role",usertype);
      } 
      else if(usertype.equals("OWNER"))
      {
         target = "OwnerHome.jsp?status=Welcome "+loginid;  	
         session.setAttribute("userid",loginid);
         session.setAttribute("role",usertype);
         
      } 
      else if(usertype.equals("USER"))
      {
         target = "UserHome.jsp?status=Welcome "+loginid;  	
         session.setAttribute("userid",loginid);
         session.setAttribute("role",usertype);
         
      } 
     
      else { 
         target = "Login.jsp?status=Invalid username and password";
         }    
		}
		catch (Exception e) {
			target = "Login.jsp?status=Invalid username and password";
		}
	
     RequestDispatcher rd = request.getRequestDispatcher(target);
     rd.forward(request,response);    
	
		out.flush();
		out.close();
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
