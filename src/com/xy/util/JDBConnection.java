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
	//��̬�����
	static {
		    try {
		    	FileInputStream file = new FileInputStream("jdbc/jdbc.abc");//������
		    	pro.load(file);//��fileװ�ص�Pro����ȥ
		    	file.close();//�ر���
				Class.forName(pro.getProperty("DRIVER"));//ͨ��pro��getproperty������ȡdriver�ļ�
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
			JOptionPane.showMessageDialog(null,"��������������ӣ���");
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
