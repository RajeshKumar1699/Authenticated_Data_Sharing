package com.dao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.bean.ProfileBean;
import com.util.Dbconnection;

public class FileUploadDao {
	
	
	public int upload(ProfileBean pb) throws SQLException {
		
		String loginid=pb.getLoginid();
		
		
		String subject=pb.getSub();
		
		String file=pb.getFile();
		
		String filename=pb.getFilename();
	
		
		int i=0;
		int fileid=100;
		Connection con=null;
		
		
		
		/*PreparedStatement pst=con.prepareStatement("select max(FILEID) from FILES_TABLE");
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			fileid = rs.getInt(1);
			fileid=fileid+1;
		}
*/
		try{
			con=Dbconnection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into FILES_TABLE(FID,FILENAME,SUB,FILESTATUS,LOGINID,FILES) values((select nvl(max(fid),1)+1 from FILES_TABLE),?,?,?,?,?)");
			ps.setString(1, filename);
			ps.setString(2,subject);
          ps.setString(3, "Uploaded");
			
			ps.setString(4, loginid);  
			
			File f=new File(file);
			FileInputStream fis=new FileInputStream(f);
			ps.setBinaryStream(5, fis,(int)f.length());
			
			 
			 i=ps.executeUpdate();
			 System.out.println("i*********"+i);
			 
			
			 
			 
		}
		catch (Exception e) {
				e.printStackTrace();
		}
		
		
		
		
		finally {
        	try {
        	if (con != null)
        	con.close();
        	} catch (SQLException e) {
        	}
        	}
		
		
		
		
		return i;
	}
}


