package com.xy.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;

public class JDBConnection {
	private Connection conn =null;
	private static Properties pro = new Properties();
	//静态代码块
	static {
		    try {
		    	FileInputStream file = new FileInputStream("jdbc/jdbc.abc");//输入流
		    	pro.load(file);//将file装载到Pro里面去
		    	file.close();//关闭流
				Class.forName(pro.getProperty("DRIVER"));//通过pro的getproperty方法获取driver的键
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		
	       }
	public Connection connection()
	{
		try {
			conn = DriverManager.getConnection(pro.getProperty("URL"),
				                               pro.getProperty("USER"),
					                           pro.getProperty("KEY"));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"请检查你的网络连接！！");
			//e.printStackTrace();
		}	
		return conn;	
	}
      public void close()
      {
    	  if (conn !=null )
    	  {
    		  try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	  }
      }
}
