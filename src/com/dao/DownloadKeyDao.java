package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import com.bean.ProfileBean;
import com.util.Dbconnection;

public class DownloadKeyDao {
	
	
public ArrayList<ProfileBean> downloadKey(String loginid) {
		
		Connection con=null;
		
		ArrayList<ProfileBean> list=new ArrayList<ProfileBean>();
		try{
			con=Dbconnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select MID,SUBJECT,KEY from MESSAGEUPLOAD  where  MSTATUS='MsgUploaded'");
			
			ResultSet rs=ps.executeQuery();
			System.out.println("bbbbbbbb");
			while (rs.next()) {
				ProfileBean pb=new ProfileBean();
				System.out.println("aaaaaaaa");
				
				int mid=rs.getInt(1);
				//String loginid1=rs.getString(2);
				
				String subject=rs.getString(2);
				String key=rs.getString(3);
				
				pb.setMid(mid);
				//pb.setLoginid(loginid1);
				pb.setSubject(subject);
				pb.setKey(key);
				
				list.add(pb);
			}
			
		}
		catch (Exception e) {

		}
		return list;
	}
	
	

}
