package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.bean.ProfileBean;
import com.util.Dbconnection;

public class UsersDetailsDao {
	
	public ArrayList<ProfileBean> getdata(String userid) {
		Connection con=null;
		
		ArrayList<ProfileBean> list=new ArrayList<ProfileBean>();
		try {
			  con=Dbconnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select LOGINID from LOGINDETAILS where loginid=?");
			ps.setString(1, userid);
			
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				ProfileBean pb=new ProfileBean();
				String loginid=rs.getString(1);
				
				System.out.println(loginid);
				
				list.add(pb);
				//System.out.println(list.add(rb));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}







	
	
	public ArrayList<ProfileBean> getMid() {
		Connection con=null;
		
		ArrayList<ProfileBean> list=new ArrayList<ProfileBean>();
		try {
			  con=Dbconnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select MID from MESSAGEUPLOAD ");
			//ps.setString(1, userid);
			
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				ProfileBean pb=new ProfileBean();
				int mid=rs.getInt(1);
				
				System.out.println(mid);
				
				list.add(pb);
				//System.out.println(list.add(rb));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}

	
	
	
	
	
	
	
	
	
	
	







}
