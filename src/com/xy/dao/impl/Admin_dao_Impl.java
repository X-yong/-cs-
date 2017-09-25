package com.xy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.xy.dao.Admin_dao;
import com.xy.entity.Admin;
import com.xy.util.JDBConnection;

public class Admin_dao_Impl implements Admin_dao{
    Admin a;
	int rs;
	Connection conn;
	public Admin nameAndKey(Admin identify) {
		String s1 = identify.getEname();
		String s2 = identify.getKey(); 
		Connection conn = new JDBConnection().connection();
		try {
		PreparedStatement stat = conn.prepareStatement("select * from admin where ename = ? and key=?");
		stat.setString(1, s1);
		stat.setString(2, s2);
		ResultSet rs =  stat.executeQuery();
		if(rs.next())
		{   a = new Admin(); 
			String s3 = rs.getString(1);
			String s4 = rs.getString(2);
			a.setEname(s3);
			a.setKey(s4);		
		}	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
		finally {
			if(conn !=null)
			{
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return a;
		}
		
	}

	public int insertEnroll(Admin identify) {

		 String a2 = identify.getEname();
		 String a3 = identify.getKey();
		 String a4 = identify.getSurekey();
		 String a5 = identify.getSex();
		 String a6 = identify.getId();
		 String a7 = identify.getPhonenumber();
   	
	     conn = new JDBConnection().connection();
		 try {
			PreparedStatement stat = conn.prepareStatement("insert into admin values(?,?,?,?,?,?)");
		   stat.setString(1,a2);
		   stat.setString(2,a3);
		   stat.setString(3,a4);
		   stat.setString(4,a5);
		   stat.setString(5,a6);
		   stat.setString(6,a7);
		   rs = stat.executeUpdate();
		   
		  
		 } catch (SQLException e) {
			e.printStackTrace();
			return rs;
		}
		return rs;		 
   }

	@Override
	public Vector updateAdmin() {
		 conn = new JDBConnection().connection();
		 Vector vv = new Vector();
		 try {
			 Vector vv2;
			PreparedStatement stat =  conn.prepareStatement("select * from admin");
		    ResultSet rSet = stat.executeQuery();
			while(rSet.next())
			{ 
				vv2 = new Vector();
				vv2.add(rSet.getString(1));
				vv2.add(rSet.getString(2));
				vv2.add(rSet.getString(4));
				vv2.add(rSet.getString(5));
				vv2.add(rSet.getString(6));
				vv.add(vv2);
			}
			
		 } catch (SQLException e) {
			e.printStackTrace();
		}
		return vv;
		
	}

	@Override
	public int deleteAdmin(Admin root) {
		conn = new JDBConnection().connection();
		int k=0; 
		try {
		   PreparedStatement stat  = conn.prepareStatement("delete from admin where ename=? and sex = ? and ID = ?");
		   stat.setString(1,root.getEname());
		   stat.setString(2,root.getSex());
           stat.setString(3,root.getId());	
           k = stat.executeUpdate();
           
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return k;
	}
}


