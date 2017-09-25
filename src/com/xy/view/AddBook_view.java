package com.xy.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;

import com.xy.bussiness.impl.Book_action_Impl;
import com.xy.entity.Books;
import com.xy.entity.User;
import com.xy.util.CheckAddBook;

/**
 * @author :xiongyong
 * @time :2016-4-25
 * @function :添加图书
 */

public class AddBook_view extends JInternalFrame {
	JTextField jt_bookname ;
	JTextField jt_booknumber ;
	JTextField jt_bookstock ;
	JTextField jt_bookautor ;
	JTextField jt_bookprice ;
	JTextField jt_bookISBN ;
	JTextField jt_bookissue ;
	
	JLabel jl_bookissue;
	
	
	public AddBook_view() {
		setFrameIcon(new ImageIcon("selecticon\\addbook.png"));
		setClosable(true);
		setIconifiable(true);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setTitle("添加图书 ");
		setBounds(100, 10, 459, 500);
		setResizable(false);
		//setIconImage(Toolkit.getDefaultToolkit().getImage("H:\\\u9879\u76EE\\\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF_4\\selecticon\\addbook.png"));

		JLabel jl_bookname = new JLabel("图书名称");
		jl_bookname.setBounds(57, 0, 126, 34);
		JLabel jl_booknumber = new JLabel("图书编号");
		jl_booknumber.setBounds(57, 147, 126, 34);
		JLabel jl_bookstock = new JLabel("图书数量");
		jl_bookstock.setBounds(57, 196, 126, 34);
		JLabel jl_bookautor = new JLabel("图书作者");
		jl_bookautor.setBounds(57, 49, 126, 34);
		JLabel jl_bookprice = new JLabel("图书价格");
		jl_bookprice.setBounds(57, 245, 126, 34);
		JLabel jl_bookISBN = new JLabel("图书ISBN");
		jl_bookISBN.setBounds(57, 294, 126, 34);
		
		jl_bookissue = new JLabel("图书出版社");
		jl_bookissue.setBounds(57, 98, 126, 34);
		
		jl_bookname.setHorizontalAlignment(JLabel.CENTER);
		jl_booknumber.setHorizontalAlignment(JLabel.CENTER);
		jl_bookstock.setHorizontalAlignment(JLabel.CENTER);
		jl_bookautor.setHorizontalAlignment(JLabel.CENTER);
		jl_bookprice.setHorizontalAlignment(JLabel.CENTER);
		jl_bookISBN.setHorizontalAlignment(JLabel.CENTER);
		jl_bookissue.setHorizontalAlignment(JLabel.CENTER);

		 jt_bookname = new JTextField();
		 jt_bookname.setBounds(193, 0, 172, 34);
		 jt_booknumber = new JTextField();
		 jt_booknumber.setBounds(193, 147, 172, 34);
		 jt_bookstock = new JTextField();
		 jt_bookstock.setBounds(193, 196, 172, 34);
		 jt_bookautor = new JTextField();
		 jt_bookautor.setBounds(193, 49, 172, 34);
		 jt_bookprice = new JTextField();
		 jt_bookprice.setBounds(193, 245, 172, 34);
		 jt_bookISBN = new JTextField();
		 jt_bookISBN.setBounds(193, 294, 172, 34);
		 jt_bookissue = new JTextField();
		 jt_bookissue.setBounds(193, 98, 172, 34);

		
		JPanel jp_newbook = new JPanel();
		jp_newbook.setBackground(Color.LIGHT_GRAY);
		jp_newbook.setBounds(0, 36, 457, 374);
		jp_newbook.setLayout(null);
		jp_newbook.add(jl_bookname);
		jp_newbook.add(jt_bookname);
		jp_newbook.add(jl_bookautor);
		jp_newbook.add(jt_bookautor);
		
		jp_newbook.add(jl_bookissue);
		jp_newbook.add(jt_bookissue);
		
		jp_newbook.add(jl_booknumber);
		jp_newbook.add(jt_booknumber);
		jp_newbook.add(jl_bookstock);
		jp_newbook.add(jt_bookstock);
		jp_newbook.add(jl_bookprice);
		jp_newbook.add(jt_bookprice);
		jp_newbook.add(jl_bookISBN);
		jp_newbook.add(jt_bookISBN);
		getContentPane().setLayout(null);
		getContentPane().add(jp_newbook);
		JButton jb_c = new JButton("取消");
		jb_c.setBounds(246, 420, 89, 23);
		getContentPane().add(jb_c);
		
		JButton jb_s = new JButton("确认");
		jb_s.setBounds(111, 420, 88, 23);
		getContentPane().add(jb_s);
		setVisible(true);
		
		jb_s.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  Books addbook  = new Books();
				
				  addbook.setBname(jt_bookname.getText());
				  addbook.setBauthor(jt_bookautor.getText());
				  addbook.setBissue(jt_bookissue.getText());
				  addbook.setBnumber(jt_booknumber.getText());
				  addbook.setBprice(Integer.parseInt(jt_bookprice.getText()));
				  addbook.setBisbn(jt_bookISBN.getText());
				  addbook.setBstock(Integer.parseInt(jt_bookstock.getText()));
				  boolean e = new CheckAddBook().checkAddBook(addbook);
				  if(e ==false) {
					  JOptionPane.showMessageDialog(null,"输入不能为空"); return;}
				  boolean e6 = new Book_action_Impl().addbook(addbook);
					if(e6)JOptionPane.showMessageDialog(null,"新增图书成功！！");
					else JOptionPane.showMessageDialog(null, "新增图书失败!!");	  
			}
		});
		jb_c.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			dispose();
				
			}
		});
		
	}
}


