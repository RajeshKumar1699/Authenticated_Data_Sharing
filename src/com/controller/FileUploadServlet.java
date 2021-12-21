package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ProfileBean;
import com.dao.FileUploadDao;



public class FileUploadServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public FileUploadServlet() {
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


		
		
		
String loginid=request.getParameter("loginid");
		
		String filename=request.getParameter("filename");
		String subject=request.getParameter("sub");
		
		String file=request.getParameter("file");
	
		
		
		
		
		File f=new File(request.getParameter("file"));
		
		
	
		
		
		
		
		
		ProfileBean bcb=new ProfileBean();

		
		bcb.setLoginid(loginid);
		bcb.setFilename(filename);
		bcb.setSub(subject);
		
		bcb.setFile(file);
	
		
		
		
		FileUploadDao fd=new FileUploadDao();
		
		try {
			int i=fd.upload(bcb);
			System.out.println("rrrrrr");
			if(i!=0){
				RequestDispatcher rd=request.getRequestDispatcher("FileUpload.jsp?status=Data Uploaded successfully");
				rd.include(request, response);
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("FileUpload.jsp?status=Data NOt Uploaded");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			RequestDispatcher rd=request.getRequestDispatcher("FileUpload.jsp?status=Some Internal Problem Occured");
			rd.include(request, response);
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
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
