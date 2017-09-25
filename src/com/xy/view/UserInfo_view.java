package com.xy.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.xy.dao.impl.User_dao_Impl;
import com.xy.entity.Admin;
import com.xy.util.JDBConnection;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserInfo_view extends JInternalFrame {

	private JPanel contentPane;
	private JTextField tf_uname;
	private JPasswordField tf_key;
	private JTextField tf_sex;
	private JTextField tf_ID;
	private JTextField tf_phonenumber;

	/**
	 * 显示用户信息
	 * Create the frame.
	 */
	public UserInfo_view(String s) {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		setTitle("管理员信息");
		setBounds(100, 20, 450, 460);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tf_phonenumber = new JTextField();
		tf_phonenumber.setEditable(false);
		tf_phonenumber.setBounds(248, 219, 114, 21);
		contentPane.add(tf_phonenumber);
		tf_phonenumber.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u8054\u7CFB\u7535\u8BDD");
		lblNewLabel_5.setForeground(new Color(244, 164, 96));
		lblNewLabel_5.setFont(new Font("华文新魏", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(169, 222, 83, 15);
		contentPane.add(lblNewLabel_5);
		
		tf_ID = new JTextField();
		tf_ID.setEditable(false);
		tf_ID.setBounds(211, 191, 130, 21);
		contentPane.add(tf_ID);
		tf_ID.setColumns(10);
		
		tf_sex = new JTextField();
		tf_sex.setEditable(false);
		tf_sex.setBounds(191, 162, 93, 21);
		contentPane.add(tf_sex);
		tf_sex.setColumns(10);
		
		tf_key = new JPasswordField();
		tf_key.setEditable(false);
		tf_key.setBounds(169, 131, 83, 21);
		contentPane.add(tf_key);
		
		tf_uname = new JTextField();
		tf_uname.setEditable(false);
		tf_uname.setBounds(147, 100, 83, 21);
		contentPane.add(tf_uname);
		tf_uname.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("ID");
		lblNewLabel_4.setFont(new Font("华文新魏", Font.PLAIN, 16));
		lblNewLabel_4.setForeground(new Color(244, 164, 96));
		lblNewLabel_4.setBounds(160, 197, 41, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("\u6027\u522B");
		lblNewLabel_3.setFont(new Font("华文新魏", Font.PLAIN, 16));
		lblNewLabel_3.setForeground(new Color(244, 164, 96));
		lblNewLabel_3.setBounds(135, 160, 54, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801");
		lblNewLabel_2.setFont(new Font("华文新魏", Font.PLAIN, 16));
		lblNewLabel_2.setForeground(new Color(244, 164, 96));
		lblNewLabel_2.setBounds(115, 129, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D");
		lblNewLabel_1.setFont(new Font("华文新魏", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(new Color(244, 164, 96));
		lblNewLabel_1.setBounds(83, 103, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("tp\\s.jpg"));
		lblNewLabel.setBounds(0, 0, 434, 430);
		contentPane.add(lblNewLabel);
	
		//查找数据库将用户信息取出
		Admin admin =new User_dao_Impl().userinfo(s);
		tf_uname.setText(admin.getEname());
		tf_key.setText(admin.getKey());
		tf_sex.setText(admin.getSex());
		tf_ID.setText(admin.getId());
		tf_phonenumber.setText(admin.getPhonenumber());
		setVisible(true);
	}
}
