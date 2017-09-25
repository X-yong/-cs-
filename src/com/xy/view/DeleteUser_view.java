package com.xy.view;

/**
*@author   : xiongyong
*@time     :2016-4-23
*@function :����û�
*/
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;

import com.xy.bussiness.impl.User_action_Impl;
import com.xy.entity.User;

public class DeleteUser_view extends JInternalFrame {
	JTextField jtf_username ;
	JTextField jtf_id ;
	JTextField jtf_unumber;
	
	public DeleteUser_view() {
		setFrameIcon(new ImageIcon("selecticon\\deleteuser.png"));
		setIconifiable(true);
		setClosable(true);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		// -----------------------------------
		setTitle("ɾ���û�");
		setBounds(100, 10, 422, 336);
        setResizable(false);
		// -------------------------------------
		//setIconImage(Toolkit.getDefaultToolkit().getImage("selecticon\\deleteuser.png"));// �������Ͻ�ͼ��
		JLabel jl_username = new JLabel("�û���");
		jl_username.setBounds(67, 11, 84, 35);
		JLabel jl_id = new JLabel("���֤����");
		jl_id.setBounds(67, 82, 84, 35);
		JLabel jl_unumber = new JLabel("�û����");
		jl_unumber.setBounds(67, 154, 95, 35);
		JLabel jl_welcome = new JLabel(new ImageIcon("tp/c.jpg"));
		jl_welcome.setBounds(0, 0, 434, -1);

		 jtf_username = new JTextField();
		 jtf_username.setBounds(144, 10, 217, 37);
		 jtf_id = new JTextField();
		 jtf_id.setBounds(144, 82, 217, 35);
		 jtf_unumber  = new JTextField();
		 jtf_unumber.setBounds(144, 154, 217, 35);

		JPanel jp_info = new JPanel();
		jp_info.setBackground(Color.LIGHT_GRAY);
		jp_info.setBounds(0, 28, 396, 215);
		jp_info.setLayout(null);

		jp_info.add(jl_username);
		jp_info.add(jtf_username);

		jp_info.add(jl_id);
		jp_info.add(jtf_id);
		
		jp_info.add(jl_unumber);
		jp_info.add(jtf_unumber);
		getContentPane().setLayout(null);

		getContentPane().add(jp_info);
		JButton jb_cancel = new JButton("����");
		jb_cancel.setFont(new Font("������κ", Font.PLAIN, 16));
		jb_cancel.setBounds(248, 271, 79, 23);
		getContentPane().add(jb_cancel);
		jb_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 jtf_username.setText("");
		    	 jtf_id.setText("");
		    	 jtf_unumber.setText("");
				
			}
		});
		getContentPane().add(jl_welcome);
		
				JButton jb_sure = new JButton("ȷ��");
				jb_sure.setFont(new Font("������κ", Font.PLAIN, 16));
				jb_sure.setBounds(104, 271, 79, 23);
				getContentPane().add(jb_sure);
				// --------ȷ�ϰ�ť����---------------------------------------
				jb_sure.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
				    	  User deleteuser = new User();
				    	  deleteuser.setUname(jtf_username.getText());
				    	  deleteuser.setUsid(jtf_id.getText());
				    	  deleteuser.setUnumber(jtf_unumber.getText());
						  	    	  
						 boolean  d1 = new User_action_Impl().deleteUser(deleteuser);
						 if(d1)JOptionPane.showMessageDialog(null,"ɾ���û��ɹ�����");
						 else JOptionPane.showMessageDialog(null, "�û������ڻ��ѱ�ɾ����!");		  
					}
				});
		setVisible(true);
	}

}
