package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.ProfileBean;
import com.dao.Checkdao;
import com.dao.DownloadMsgDao;




public class SearchEnterKeyServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();


		
		try{
			HttpSession session=request.getSession();
			String loginid=(String) session.getAttribute("userid");
			
			
			
			String key=request.getParameter("key");
			
			String mid=request.getParameter("mid");
			
			ProfileBean pb=new ProfileBean();
			
			
			System.out.println("hhhhhhhhh"+loginid);
			
			pb.setLoginid(loginid);
			
			pb.setKey(key);
			
			System.out.println("hhhh"+key);
			System.out.println("iiiiii"+mid);
			
			//pb.setMid(Integer.parseInt(mid));
		
			
			Checkdao ocd=new Checkdao();
		System.out.println("cvdsghfsdvfsdfsdtbvvbvbbbb");
			
			int i=ocd.keyCheck(pb);
			
			System.out.println("12548788598545554");
			
			System.out.println("iiiii"+i);
			System.out.println("iiivvvv");

			if(i==1){
				
				DownloadMsgDao fdd=new DownloadMsgDao();
				
				ArrayList<ProfileBean> list7=fdd.msgDownload(pb);
				System.out.println("after downloadmethod");
				
				session.setAttribute("list7",list7);			
				RequestDispatcher rd= request.getRequestDispatcher("MsgDownload.jsp");
				rd.include(request,response);
			}
			else{
				
				
				RequestDispatcher rd= request.getRequestDispatcher("MsgDownload.jsp?msg=Invalid Key");
				rd.include(request, response);
				
				}
			}
				
			
			
			catch (Exception e) {
				RequestDispatcher rd= request.getRequestDispatcher("MsgDownload.jsp?msg=Invalid key");
				rd.include(request, response);
				
			}
		}


}

