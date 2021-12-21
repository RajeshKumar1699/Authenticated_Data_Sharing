package com.dao;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import com.bean.ProfileBean;


import com.util.Dbconnection;

public class FileDownloadDao {

	
	
	
	
	
public ArrayList<ProfileBean> filedownload(ProfileBean rb2) {
		
		Connection con=null;
		
		
		
		
		String fn=rb2.getFilename();
		String sub=rb2.getSub();
		
		System.out.println("fn--------"+fn);
		
		System.out.println("sub--------"+sub);
		
		ArrayList<ProfileBean> list=new ArrayList<ProfileBean>();
		try{
			 con=Dbconnection.getConnection();
			 
			System.out.println("ccccccccccc"+con);
			
			PreparedStatement ps=con.prepareStatement("select FILEID,FILENAME,SUBJECT,FILES from FILES_TABLE  where FILENAME=? and SUB=?");
			ps.setString(1, fn);
			ps.setString(2, sub);
			
			
			ResultSet rs=ps.executeQuery();
			System.out.println("before while");
			
			while (rs.next()) {
				
				System.out.println("after while");
				
				ProfileBean rb=new ProfileBean();
				
				int fileid=rs.getInt(1);
				
				String filename=rs.getString(2);
				
				String sub1=rs.getString(3);
				
				rb.setFid(fileid);
				System.out.println("fileid"+fileid);
				System.out.println("filename"+filename);
				System.out.println("subject"+sub1);
				
				Blob b=rs.getBlob(4);
				
				byte brr[] = b.getBytes(1, (int) b.length());
				OutputStream fos=new FileOutputStream("F:/"+filename);
				fos.write(brr);
				
				
				
				System.out.println("brr"+brr);
				
				
				
				rb.setFilename(filename);
				rb.setSub(sub1);
				rb.setFile(""+filename);
				
				
				
				list.add(rb);
				
			}
			
		}
		catch (Exception e) {
                                  e.printStackTrace();
		}
		return list;
	}



public ArrayList<ProfileBean> download() {
	
	Connection con=null;
	
	ArrayList<ProfileBean> list=new ArrayList<ProfileBean>();
	try{
		con=Dbconnection.getConnection();
		PreparedStatement ps=con.prepareStatement("select FID,FILENAME,SUB from FILES_TABLE  where FILESTATUS=?");
		
		ps.setString(1, "Uploaded");
		ResultSet rs=ps.executeQuery();
		System.out.println("bbbbbbbb");
		while (rs.next()) {
			
			ProfileBean rb=new ProfileBean();
			
			System.out.println("aaaaaaaa");
			int fid=rs.getInt(1);
			
			String filename=rs.getString(2);
			String sub=rs.getString(3);
			
			rb.setFid(fid);
			rb.setFilename(filename);
			rb.setSub(sub);
			
			list.add(rb);
		}
		
	}
	catch (Exception e) {
		e.printStackTrace();

	}
	return list;
}

	
	
	
	
	
	
	
}
