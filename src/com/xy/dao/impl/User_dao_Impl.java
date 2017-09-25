package com.xy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.xy.dao.User_dao;
import com.xy.entity.Admin;
import com.xy.entity.User;
import com.xy.util.AchieveTime;
import com.xy.util.JDBConnection;
import com.xy.view.UpdateUser_view;

public class User_dao_Impl implements User_dao {
	Connection conn;
	int rs;
	PreparedStatement stat;
	ResultSet r;
	int b;

	/******************* 添加用户 *************************************************/
	public int insertuserdao(User adduser) {
       
		String sql = "insert into users(uname,usex,usid,uphone,unumber,enrolltime,canceltime,seid) values(?,?,?,?,?,?,?,users_se.nextval)";
		 int i = updateuserdao(adduser,sql); 
		return i;
	}
/******************添加与修改用户公共程序*****************************************************************/
	public int updateuserdao(User user,String sql) {
		String b1 = user.getUname();
		String b2 = user.getUsex();
		String b3 = user.getUsid();
		String b4 = user.getUphone();
		String b5 = user.getUnumber();
		String b6 = user.getEnrolltime();
		String b7 = user.getCanceltime();
		conn = new JDBConnection().connection();
		try {
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, b1);
			stat.setString(2, b2);
			stat.setString(3, b3);
			stat.setString(4, b4);
			stat.setString(5, b5);
			stat.setString(6, b6);
			stat.setString(7, b7);
			
			rs = stat.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return rs;
		}
		return rs;
	}
	/******************* 删除用户 *************************************************/
	public int deleteuserdao(User deleteuser) {
		String b1 = deleteuser.getUname();
		String b3 = deleteuser.getUsid();
		String b5 = deleteuser.getUnumber();
	  	conn = new JDBConnection().connection();
		try {
			stat = conn.prepareStatement("delete from users where uname=? and usid = ?  and unumber = ?");
			stat.setString(1, b1);
			stat.setString(2, b3);
			stat.setString(3, b5);
			rs = stat.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return rs;
		}
		return rs;
	}

	/******************* 查询用户 *************************************************/

	public Vector selectuserdao(User selectuser) {
		String s1 = selectuser.getUname();
		String s2 = selectuser.getUsex();
		conn = new JDBConnection().connection();
		Vector v = new Vector();
		try {
			StringBuffer sql = new StringBuffer("select * from users ");
			if (s1 != null && !s1.equals(""))
				sql.append("where uname like '%" + s1 + "%'");
			else if (s2 != "")
				sql.append("where usex = '" + s2 + "'");
			stat = conn.prepareStatement(sql.toString());
			r = stat.executeQuery();
			while (r.next()) {
				Vector v1 = new Vector();// 将得到的数据存入向量
				v1.add(r.getString(1));
				v1.add(r.getString(2));
				v1.add(r.getString(3));
				v1.add(r.getString(4));
				v1.add(r.getString(5));
				v1.add(r.getString(6));
				v1.add(r.getString(7));
				v1.add(r.getInt(8));
				v.add(v1);
			}
			return v;
		} catch (SQLException e) {
			e.printStackTrace();
			return v;
		}
	}

	/******************* 修改用户 *************************************************/
	public int updateuserdao(User updateuser) {

		String s6 = updateuser.getUnumber();	
		String sql = "update users set uname = ? , usex = ?,usid = ? ,uphone = ? ,unumber=?,  enrolltime = ? , canceltime = ? where unumber ='"+ s6+"'";
		int b  = updateuserdao(updateuser,sql);
		return b;
	}
	//调用数据库数据
	public Admin userinfo(String s)
	{
		Connection conn = new JDBConnection().connection();//创建连接
		Admin  info = new Admin();
		try {
			
			PreparedStatement stat =  conn.prepareStatement("select * from admin where ename = ? ");
			stat.setString(1, s);
			ResultSet rs = stat.executeQuery();
			while (rs.next())
			{
				info.setEname(rs.getString(1));
				info.setKey(rs.getString(2));
				info.setSex(rs.getString(4));
				info.setId(rs.getString(5));
				info.setPhonenumber(rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return info;
		}	
	  return info;
	}
}
