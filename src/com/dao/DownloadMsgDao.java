package com.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import com.bean.ProfileBean;
import com.crypt.util.CryptMsgUtil;
import com.util.Dbconnection;

public class DownloadMsgDao {
	public ArrayList<ProfileBean> msgDownload(ProfileBean pb) throws FileNotFoundException {
		
		//String loginid=bcb.getLoginid();
		
		int mid1=pb.getMid();
		String key=pb.getKey();
		
		
		Connection con=null;
		
		ArrayList<ProfileBean> list=new ArrayList<ProfileBean>();
		try {
			
			
			
			
			CryptMsgUtil decrypt = new CryptMsgUtil("passPhrase");
			con=Dbconnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select MID,SUBJECT,MESSAGE from MESSAGEUPLOAD where KEY=?");
			
			ps.setString(1, key);
			
			
			
			ResultSet rs=ps.executeQuery();
			
			while (rs.next()) {
				System.out.println("ddddffffd");
				ProfileBean pb1=new ProfileBean();
				
				int mid=rs.getInt(1);
				
				String subject=rs.getString(2);
				System.out.println("before");
				
				
				String message = decrypt.decrypt(rs.getString(3));
				System.out.println("ddddd"+message);
				
				pb1.setMid(mid);
				//pb1.setLoginid(lodinid1);
				pb1.setSubject(subject);
				pb1.setMessage(message);
				
				System.out.println("miv-->"+mid);
				
				System.out.println("subject-->"+subject);
				System.out.println("message-->"+message);
				
				System.out.println("decrypted successfully");
				
							
				list.add(pb1);
			}
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;
	}





	
	

}
