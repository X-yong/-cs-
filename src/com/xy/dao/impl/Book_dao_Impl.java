package com.xy.dao.impl;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import com.xy.bussiness.Book_action;
import com.xy.dao.Book_dao;
import com.xy.entity.Bookanalyse;
import com.xy.entity.Books;
import com.xy.entity.Borrowbooks;
import com.xy.util.AchieveTime;
import com.xy.util.JDBConnection;
import com.xy.view.UpdateBooks_view;

public class Book_dao_Impl implements Book_dao{
    Connection conn;
	int rs;
//添加图书	
	public int insertBookDao(Books addbook) {
		String st = AchieveTime.achieveTime();
		System.err.println(st);
        String sql = "insert into books values(?,?,?,?,?,?,?,'"+st+"',books_se.nextval)"; 
        int b = updatebookdao(addbook, sql);	  
		return b;		 
	}
/********************添加与修改图书公共部分****************************************************/
	   public int updatebookdao(Books book ,String sql) {

		 String b1 = book.getBname();
		 String b2 = book.getBauthor();
		 String b3 = book.getBissue();
		 String b4 = book.getBnumber();
		 int b5 = book.getBprice();
		 String b6 = book.getBisbn();
		 int b7 = book.getBstock();
        
	      conn = new JDBConnection().connection();
		 try {
		   PreparedStatement stat = conn.prepareStatement(sql);
		   stat.setString(1,b1);
		   stat.setString(2,b2);
		   stat.setString(3,b3);
		   stat.setString(4,b4);
		   stat.setInt(5,b5);
		   stat.setString(6,b6);
		   stat.setInt(7,b7);	
		  
		   rs = stat.executeUpdate();
		 } catch (SQLException e) {
			e.printStackTrace();
			return rs;
		}
		return rs;		 
	}
	/*************************************************************************/
	//删除图书
	public int deleteBookDao(Books deletebook) {
		 String b1 = deletebook.getBname();
		 String b2 = deletebook.getBauthor();
		 String b3 = deletebook.getBissue();
	     conn = new JDBConnection().connection();
		 try {
			PreparedStatement stat = conn.prepareStatement("delete from books where bname=? and bauthor=? and bissue = ? ");
		   stat.setString(1,b1);
		   stat.setString(2,b2);
		   stat.setString(3,b3); 
		   rs = stat.executeUpdate();  	  
		 } catch (SQLException e) {
			e.printStackTrace();
			return rs;
		}
		return rs;		 
	}
//查询图书
	public Vector selectBooksDao(Books selectbooks) {
	  
		String s = selectbooks.getBname();
		Vector  v = new Vector();//定义一个向量
		String orderby = selectbooks.getOrder().toString();
	    conn = new JDBConnection().connection();
	    StringBuffer st2 = new StringBuffer("select * from books order by "+orderby +"");
	    StringBuffer st = new StringBuffer("select * from books");
	   if(s == null || s.equals("") && !orderby.equals("~order by~"))
		  st =  st2;
	    else if(s !=null && !s.equals("") && !orderby.equals("~order by~")) 
	    	st.append(" where bname like'%"+s+"%' order by "+orderby+"");
	    else if(s == null || s.equals("") && orderby.equals("~order by~"))
	    	st =st;
	    else 	
	      st.append(" where bname like'%"+s+"%'");
		try {
			PreparedStatement stat =  conn.prepareStatement(st.toString());
		    ResultSet rs2 = stat.executeQuery();
		    while (rs2.next())
		    {
		    	Vector v2 = new Vector();
		    	v2.add(rs2.getString(1));
		    	v2.add(rs2.getString(2));
		    	v2.add(rs2.getString(3));
		    	v2.add(rs2.getString(4));
		    	v2.add(rs2.getInt(5));
		    	v2.add(rs2.getString(6));
		    	v2.add(rs2.getInt(7));
		    	v2.add(rs2.getString(8));
		    	v.add(v2);	
		    }	    
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}
	//修改图示信息
	public int updateBooksDao(Books updatebooks) {

		String s4 = updatebooks.getBnumber();
		String s5 = updatebooks.getAddtime();
		String  sql = "update books set bname=?,bauthor=?,bissue=?,bnumber=?,bprice=?,bisbn=?,bstock=? ,addtime='"+s5+"' where bnumber ='"+s4+"' ";
		int a =  updatebookdao(updatebooks ,sql );
		return a;
	}

/***************************借书*************************************************/
	public boolean borrowBooksDao(String n, String b) {
		int credit;
	    conn =  new JDBConnection().connection();
	    try {  
				PreparedStatement state = conn.prepareStatement("select credit from users where unumber =?");
				state.setString(1, n);
				ResultSet a = state.executeQuery();
				if(a.next())
				{
			    credit =  a.getInt(1);	
				if(credit > 0 ) 	
				{
				  creditdesc(n,b);//调用creditdesc() 方法
				  writeRecorddao(n,b);
				 return  true;	
			    }
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//借书成功后将该用户的信用值与图书库存减一
  public void creditdesc(String n,String b)
  {   
	  try {
		PreparedStatement s = conn.prepareStatement("update users set credit =credit-1 where unumber = '"+n+"'");
		PreparedStatement s2 = conn.prepareStatement("update books set bstock =bstock-1 where bnumber = '"+b+"'");
       s.executeUpdate();
       s2.executeUpdate();
    
	} catch (SQLException e) {
		e.printStackTrace();
	}
  }
  //插入借书记录
  public void writeRecorddao(String n,String b)
  {    String  q1 = null;
       String  q2 = n;
       String  q3 = null;
       String  q4 = b;
       String  q5 = new AchieveTime().achieveTime();//获取系统日期
       String  q6 = new AchieveTime().achieveTimeOver(1);//获取一个月之后的日期
       String  q7 = null;
       String  q9 = new AchieveTime().achieveTime();
       double    q8 =new AchieveTime().descTime(q6,q9);
       Borrowbooks borrowbooks = new Borrowbooks();
       int i= q9.compareTo(q6);
       if (i == 1 ||i==0) {q7 = "是"; q8 = (q8 * 0.1); }
       else if(i == -1) {q7 = "否"; q8 = 0;} 
     
	  try {
	    PreparedStatement s3 = conn.prepareStatement("select uname from users where unumber ='"+n+"'");
	    
	    ResultSet re = s3.executeQuery();
	    while(re.next())
	    {
	    	q1 = (re.getString(1));    	
	    }
	    PreparedStatement s4 = conn.prepareStatement("select bname from books where bnumber ='"+b+"'");
	  
	    ResultSet re2 = s4.executeQuery();
	    while(re2.next())
	    {
	    	q3=(re2.getString(1));
	    }
		PreparedStatement s5 = conn.prepareStatement("insert into borrowbooks values(?,?,?,?,?,?,?,?)");
	    s5.setString(1, q1);
	    s5.setString(2, q2);
	    s5.setString(3, q3);
	    s5.setString(4, q4);
	    s5.setString(5, q5);
	    s5.setString(6, q6);
	    s5.setString(7, q7);
	    s5.setDouble(8, q8);
	  
	  int k = s5 .executeUpdate();
	  } catch (SQLException e) {
		e.printStackTrace();
	}  
  }

//查询借书记录
public Vector selectBorrowBooksDao(String s) 
{
	
	Vector v4 = new Vector();
	conn = new JDBConnection().connection();
	try {
	   StringBuffer sql = new StringBuffer("select * from BORROWBOOKS");
		if (s == null||s.equals(""))
			sql =sql ;
		else sql.append(" where unumber ='"+s+"'");
		PreparedStatement stP = conn.prepareStatement(sql.toString());//用srtingBUffer拼接字符串要用toString()方法
		ResultSet res = stP.executeQuery();
		
	  while(res.next())  
	  { 
		  Vector v3 = new Vector();
		  v3.add(res.getString(1));
		  v3.add(res.getString(2));
		  v3.add(res.getString(3));
		  v3.add(res.getString(4));
		  v3.add(res.getString(5));
		  v3.add(res.getString(6));
		  v3.add(res.getString(7));
		  v3.add(res.getDouble(8));
		  v4.add(v3); 
			  
	  }
	} catch (SQLException e) {
		e.printStackTrace();
		return v4;
	} 
	return v4;
  }
/***************************还书************************************************/
public boolean returnBooksDao(String n2, String b2) {
	int credit2;
    conn =  new JDBConnection().connection();
    try {  
			PreparedStatement state = conn.prepareStatement("select unumber from BORROWBOOKS where unumber =? and booksnumber=?");
			state.setString(1, n2);
			state.setString(2,b2);
			ResultSet a2 = state.executeQuery();
			if(a2.next())
			{
			  creditascdao(n2,b2);//调用creditdesc() 方法
			  droprecord(n2,b2);
			}else return false;
			
			return  true;	
		
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
}
//还书成功后将该用户的信用值与图书库存加一
public void creditascdao(String n2,String b2)
   {   
  try {
	   PreparedStatement s = conn.prepareStatement("update users set credit =credit+1 where unumber = '"+n2+"'");
	  PreparedStatement s2 = conn.prepareStatement("update books set bstock =bstock+1 where bnumber = '"+b2+"'");
      s.executeUpdate();
      s2.executeUpdate();
      }  catch (SQLException e) {
	e.printStackTrace();
       }
   }
//还书后删除借书记录
public void droprecord(String j, String k)
   {
	try {
		PreparedStatement prep = conn.prepareStatement("delete from BORROWBOOKS where unumber ='"+j+"' and booksnumber='"+k+"'");
	    prep .executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
   }
 //图书总量
 public Bookanalyse Bookcount()
 {    Bookanalyse  analyse = new Bookanalyse();
	 conn =  new JDBConnection().connection();
	 try {
		PreparedStatement stat = conn.prepareStatement("select count(bk.borrowbooks),count(b.bname) from borrowbooks bk full join books b on  b.bnumber = bk. booksnumber");
	    ResultSet rs = stat.executeQuery();
	    while(rs.next())
	    {
	    	analyse.setBookborrowanalyse(rs.getString(1));
	    	analyse.setBooktotal(rs.getString(2));
	    }
	 } catch (SQLException e) {
		e.printStackTrace();
	}
	return analyse;
 }

}
