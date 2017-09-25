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
import javax.swing.plaf.synth.SynthStyle;

import com.xy.bussiness.impl.User_action_Impl;
import com.xy.entity.User;
import com.xy.util.AchieveTime;

public class AddUser_view extends JInternalFrame {
	JTextField jtf_username ;
	JTextField jtf_id ;
	JTextField jtf_phonenumber ;
	JTextField jtf_unumber;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	
	public AddUser_view() {
		setFrameIcon(new ImageIcon("selecticon\\adduser.png"));
		setClosable(true);
		setIconifiable(true);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		// -----------------------------------
		setTitle("������û�");
		setBounds(100, 10, 450, 458);
		setResizable(false);
		// -------------------------------------
		//setIconImage(Toolkit.getDefaultToolkit().getImage("selecticon\\adduser.png"));// �������Ͻ�ͼ��
		JLabel jl_username = new JLabel("�û���");
		jl_username.setBounds(54, 32, 67, 34);
		JLabel jl_sex = new JLabel("�Ա�");
		jl_sex.setBounds(54, 87, 67, 34);
		JLabel jl_id = new JLabel("���֤����");
		jl_id.setBounds(54, 153, 81, 29);
		JLabel jl_phonenumber = new JLabel("�ֻ�����");
		jl_phonenumber.setBounds(54, 210, 98, 34);
		JLabel jl_unumber = new JLabel("�û����");
		jl_unumber.setBounds(54, 273, 98, 34);

	     jtf_username = new JTextField();
	     jtf_username.setBounds(155, 33, 217, 34);
		 jtf_id = new JTextField();
		 jtf_id.setBounds(155, 151, 217, 34);
		 jtf_phonenumber = new JTextField();
		 jtf_phonenumber.setBounds(155, 211, 217, 34);
		 jtf_unumber = new JTextField();
		 jtf_unumber.setBounds(155, 274, 217, 34);

		JPanel jp_info = new JPanel();
		jp_info.setBackground(Color.LIGHT_GRAY);
		jp_info.setBounds(0, 38, 434, 340);
		jp_info.setLayout(null);

		jp_info.add(jl_username);
		jp_info.add(jtf_username);

		jp_info.add(jl_sex);

		jp_info.add(jl_id);
		jp_info.add(jtf_id);

		jp_info.add(jl_phonenumber);
		jp_info.add(jtf_phonenumber);
		
		jp_info.add(jl_unumber);
		jp_info.add(jtf_unumber);
		getContentPane().setLayout(null);

		getContentPane().add(jp_info);
		
		JRadioButton rb_boy = new JRadioButton("\u7537");
		rb_boy.setOpaque(false);
		rb_boy.setSelected(true);
		buttonGroup.add(rb_boy);
		rb_boy.setBounds(155, 93, 54, 23);
		jp_info.add(rb_boy);
		
		JRadioButton rb_girl = new JRadioButton("\u5973");
		rb_girl.setOpaque(false);
		buttonGroup.add(rb_girl);
		rb_girl.setBounds(266, 93, 47, 23);
		jp_info.add(rb_girl);
		
				JButton jb_sure = new JButton("ȷ��");
				jb_sure.setFont(new Font("������κ", Font.PLAIN, 16));
				jb_sure.setBounds(100, 388, 82, 23);
				getContentPane().add(jb_sure);
				
				// --------ȷ�ϰ�ť����---------------------------------------
				jb_sure.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						User adduser  = new User();
						if(rb_boy.isSelected()) adduser.setUsex("��");
						else adduser.setUsex("Ů");
						adduser.setUname(jtf_username.getText());	
						adduser.setUsid(jtf_id.getText());
						adduser.setUphone(jtf_phonenumber.getText());
						adduser.setUnumber(jtf_unumber.getText());
						adduser.setEnrolltime( AchieveTime.achieveTime());
					    adduser.setCanceltime(AchieveTime.achieveTimeOver(12));//ע����Ϣ����һ��
						
						boolean b6 = new User_action_Impl().addUser(adduser);
						if(b6)JOptionPane.showMessageDialog(null,"������û��ɹ�����");
						else JOptionPane.showMessageDialog(null, "������û�ʧ��,������������Ƿ���Ϲ淶!!");
						
					}
				});
		JLabel jl_welcome = new JLabel(new ImageIcon("tp/c.jpg"));
		jl_welcome.setBounds(0, 0, 434, -1);
		getContentPane().add(jl_welcome);
		JButton jb_cancel = new JButton("����");
		jb_cancel.setFont(new Font("������κ", Font.PLAIN, 16));
		jb_cancel.setBounds(248, 388, 79, 23);
		getContentPane().add(jb_cancel);
		
		jb_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtf_username.setText("");
				jtf_id.setText("");
				jtf_phonenumber.setText("");
				jtf_unumber.setText("");
		
			}
		});
		setVisible(true);
	}
}
