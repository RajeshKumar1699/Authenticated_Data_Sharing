package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import com.bean.ProfileBean;
import com.util.Dbconnection;

public class NewUserAcceptanceDao {
	
static Connection con;
	

	private boolean flag;

	public  NewUserAcceptanceDao() {
		try
		{
		con=Dbconnection.getConnection();
		
		}
		catch (Exception e) {
			
		}
		
		
		
		
	}
	
	
	
	public boolean getAcceptNewUser(String id) {
		try {
			PreparedStatement ps = con
					.prepareStatement("update LOGINDETAILS set status=1 where LOGINID='"
							+ id + "'");
			int i = 0;
			i = ps.executeUpdate();
			if (i > 0) {
				flag = true;

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}
	
	
	
	
	
	public boolean rejectUser(String id){
		try{
			
			PreparedStatement ps=con.prepareStatement("update LOGINDETAILS  set status=2 where LOGINID='"+id+"'");
			int i=0;
			i=ps.executeUpdate();
			if(i>0){
				 flag=true;
				
			}
		}
			catch (Exception e) {
				System.out.println(e);
					}
			return flag;
			
		}
	
	
	
	
	public boolean deleteNewUserAccount(String loginid){
		
		 try {
			  
			 PreparedStatement ps=con.prepareStatement("delete LOGINDETAILS where LOGINID='"+loginid+"'");
			 PreparedStatement ps1=con.prepareStatement("delete USERDETAILS where LOGINID='"+loginid+"'");
			 int i=0;
			 int i2=0;
			 i=ps.executeUpdate();
			 i2=ps1.executeUpdate();
			 if(i>0 && i2>0){
				 flag=true;
				 
				 
			 }
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public HashMap getUser(){
		
		  HashMap hm=new HashMap();
		  try {
				PreparedStatement ps = con
						.prepareStatement("select * FROM LOGINDETAILS where STATUS='0' ");
				int i = 0;
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {

					ProfileBean rbean = new ProfileBean();
					rbean.setLoginid(rs.getString(2));
					rbean.setRole(rs.getString(4));
					rbean.setUsername(rs.getString(5));
					i = i + 1;
					hm.put(i, rbean);

				}
			} catch (Exception e) {
				System.out.println(e);
			}
			return hm;
		}

	

}
