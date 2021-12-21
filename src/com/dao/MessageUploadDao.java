package com.dao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.bean.ProfileBean;
import com.util.Dbconnection;

public class MessageUploadDao {
public int uploadMsg(ProfileBean pb) throws SQLException {
		
		String loginid=pb.getLoginid();
		
		
		String subject=pb.getSubject();
		
		String key=pb.getKey();
		String msg=pb.getMessage();
	
		
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
			PreparedStatement ps=con.prepareStatement("insert into MESSAGEUPLOAD(MID,LOGINID,SUBJECT,KEY,MESSAGE,MSTATUS) values((select nvl(max(MID),1)+1 from MESSAGEUPLOAD),?,?,?,?,?)");
			
			ps.setString(1,loginid);
			ps.setString(2,subject);
			
			
			 ps.setString(3, key);
			
			ps.setString(4, msg);
			ps.setString(5, "MsgUploaded");
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







