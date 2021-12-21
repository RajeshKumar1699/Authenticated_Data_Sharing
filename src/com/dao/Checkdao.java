package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.ProfileBean;
import com.util.Dbconnection;

public class Checkdao {

	public int keyCheck(ProfileBean pb) {
		
		
		int i=1;
		
		Connection con=null;
		
		//int mid=pb.getMid();				
		
		//String loginid=bcb.getLoginid();
		
		String key1=pb.getKey();
		
		System.out.println("key1"+key1);
		
		try
		{
			con=Dbconnection.getConnection();
			System.out.println("connection==========>"+con);
		
		PreparedStatement ps=con.prepareStatement("select KEY,MID from MESSAGEUPLOAD where KEY=?");
		ps.setString(1, key1);
		
		ResultSet rs=ps.executeQuery();
		
		System.out.println("bbkkkkkk");
		
		while(rs.next())
		{
			
		String	key=rs.getString(1);
		int mid=rs.getInt(2);
		
		ProfileBean pb2=new ProfileBean();
		pb2.setMid(mid);
		pb2.setKey(key);
		
			System.out.println("aaakkk");
			System.out.println("key"+key);
			System.out.println("mid+"+mid);
			
		
			if(key.equals(key1)){
				
				System.out.println("vvvvvvvvv"+i);
					return i;
				
				
								
			}else{
				
				i++;
				System.out.println("aaavvvvvvvvv"+i);
				
				
		}
			return i;	
		
		
		
		
		
		
		
		
		
		
		}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
			
		
		
		
		System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		
	return i;
	}

}
