package com.xy.view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.channels.NonWritableChannelException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.imageio.stream.FileImageInputStream;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.xy.bussiness.impl.Book_action_Impl;
import com.xy.entity.Books;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class DeleteBook_view extends JInternalFrame  {
	  JTextField jtf_bookname ;
	  JTextField jtf_bookauthor ;
	  JTextField jtf_bookissue ;
      JTextField jtf_bookunumber;
	
	
       public DeleteBook_view()
       {
       	setClosable(true);
       	setFrameIcon(new ImageIcon("selecticon\\deletebook.png"));
       	setIconifiable(true);
       //	setIconImage(Toolkit.getDefaultToolkit().getImage("H:\\\u9879\u76EE\\\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF_4\\selecticon\\deletebook.png"));
       	getContentPane().setBackground(Color.LIGHT_GRAY);
    	  setTitle("删除图书");  
    	  setBounds(100,10,350,222);
    	  setResizable(false);
    	  JLabel jl_bookname = new JLabel("图书名称");
    	  jl_bookname.setHorizontalAlignment(JLabel.CENTER);
    	  JLabel jl_bookauthor = new JLabel("图书作者");
    	  jl_bookauthor.setHorizontalAlignment(JLabel.CENTER);
    	  JLabel jl_bookissue = new JLabel("图书出版社");
    	  jl_bookissue.setHorizontalAlignment(JLabel.CENTER);
       	  JLabel jl_bookunumber = new JLabel("图书编号");
          jl_bookunumber.setHorizontalAlignment(JLabel.CENTER);
    	  jtf_bookname = new JTextField();
    	  jtf_bookauthor = new JTextField();
    	  jtf_bookissue = new JTextField();
          jtf_bookunumber = new JTextField();
    	  
    	  JButton  jb_dsure = new JButton("确认");
    	  jb_dsure.setFont(new Font("华文新魏", Font.PLAIN, 16));
    	  JButton  jb_dcanael = new JButton("取消");
    	  jb_dcanael.setFont(new Font("华文新魏", Font.PLAIN, 16));
    	  
    	  JPanel jp_delete = new JPanel();
    	  jp_delete.setBackground(Color.LIGHT_GRAY);
    	  JPanel jp_dbutton = new JPanel();
    	  jp_dbutton.setBackground(Color.LIGHT_GRAY);
    	  
    	  jp_delete.setLayout(new GridLayout(4,2,0,10));
    	  jp_dbutton. setLayout(new FlowLayout());
    	  
    	  jp_delete.add(jl_bookname);
    	  jp_delete.add(jtf_bookname);
    	  jp_delete.add(jl_bookauthor);
    	  jp_delete.add(jtf_bookauthor);
    	  jp_delete.add(jl_bookissue);
    	  jp_delete.add(jtf_bookissue);
    	  jp_delete.add(jl_bookunumber);
    	  jp_delete.add(jtf_bookunumber);
    	  
    	  jp_dbutton.add(jb_dsure);
    	  jp_dbutton.add(jb_dcanael);
    	  
    	  getContentPane().setLayout(new BorderLayout(20,10));
    	  getContentPane().add(jp_delete,BorderLayout.CENTER);
    	  getContentPane().add(jp_dbutton,BorderLayout.SOUTH);
    	  getContentPane().add(new JLabel(),BorderLayout.EAST);
    	  getContentPane().add(new JLabel(),BorderLayout.NORTH);
    	  
    	  setVisible(true);
    	  jb_dsure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                   Books deletebook = new Books();
                   deletebook.setBname(jtf_bookname.getText());
                   deletebook.setBauthor(jtf_bookauthor.getText());
                   deletebook.setBissue(jtf_bookissue.getText());
                   deletebook.setBnumber(jtf_bookunumber.getText());
				   
				   boolean  d2 = new Book_action_Impl().deletebook(deletebook);
					 if(d2)JOptionPane.showMessageDialog(null,"删除图书成功！！");
					 else JOptionPane.showMessageDialog(null, "图示不存在或已被删除！!");				   
			}
		});
    	  jb_dcanael.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
       }
}
