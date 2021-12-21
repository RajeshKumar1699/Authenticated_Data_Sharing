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
import javax.servlet.http.HttpSession;

import com.bean.ProfileBean;



import com.crypt.util.*;
import com.dao.MessageUploadDao;

public class MessageUploadServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MessageUploadServlet() {
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
		
		String message = null;
		//String subject = null;
String loginid=request.getParameter("loginid");

HttpSession session = request.getSession();

		
	
		String subject=request.getParameter("subject");
		
	
		String key=request.getParameter("key");
		
		
		String msg=request.getParameter("message");
		
		
		CryptMsgUtil decrypt = new CryptMsgUtil("passPhrase");
		if (msg != null) {
			message = decrypt.encrypt(msg);
			if (message != null) {
				System.out.println("message encrypted   ");
			} else {
				System.out.println("message cannot be encrypted ");
			}
		}
		
		/*CryptMsgUtil decrypt1 = new CryptMsgUtil("passPhrase");
		if (subject1 != null) {
			subject = decrypt.encrypt(subject1);
			if (subject != null) {
				System.out.println("subject encrypted   ");
			} else {
				System.out.println("subject cannot be encrypted ");
			}
		}*/
		
	
		System.out.println("encryptmsg"+message);
		
		
		
		ProfileBean pb=new ProfileBean();

		
		pb.setLoginid(loginid);
		
		pb.setSubject(subject);
		
		
		pb.setKey(key);
		pb.setMessage(message);
		
		
		MessageUploadDao fd=new MessageUploadDao();
		
		try {
			int i=fd.uploadMsg(pb);
			
			System.out.println("rrrrrr");
			if(i!=0){
				RequestDispatcher rd=request.getRequestDispatcher("MsgUpload.jsp?status=Data Uploaded successfully");
				rd.include(request, response);
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("MsgUpload.jsp?status=Data NOt Uploaded");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			RequestDispatcher rd=request.getRequestDispatcher("MsgUpload.jsp?status=Some Internal Problem Occured");
			rd.include(request, response);
			
		}
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
