package com.xy.view;

/**
*@author   : xiongyong
*@time     :2016-4-23
*@function :注册程序
*/
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;

import com.xy.bussiness.impl.Admin_action_Impl;
import com.xy.entity.Admin;
import com.xy.util.CheckEnrollnull;
/**
 * 用户注册
 * @author soonsmile
 *
 */
public class Enroll_view extends JFrame {
	JTextField jtf_username;
	JTextField jtf_password;
	JTextField jtf_sure;
	JTextField jtf_id;
	JTextField jtf_phonenumber;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public Enroll_view() {
		// -----------------------------------
		setTitle("\u7BA1\u7406\u5458\u6CE8\u518C");
		setBounds(500, 100, 450, 500);
        setResizable(false);
		// -------------------------------------
		setIconImage(Toolkit.getDefaultToolkit().createImage("tp/b.png"));// 设置左上角图标
		JLabel jl_username = new JLabel("用户名");
		jl_username.setBounds(59, 62, 67, 32);
		JLabel jl_password = new JLabel("密码");
		jl_password.setBounds(59, 113, 67, 32);
		JLabel jl_sure = new JLabel("确认密码");
		jl_sure.setBounds(59, 166, 67, 32);
		JLabel jl_sex = new JLabel("性别");
		jl_sex.setBounds(59, 225, 54, 32);
		JLabel jl_id = new JLabel("身份证号码");
		jl_id.setBounds(59, 287, 67, 32);
		JLabel jl_phonenumber = new JLabel("手机号码");
		jl_phonenumber.setBounds(59, 340, 67, 37);

		jtf_username = new JTextField();
		jtf_username.setBounds(156, 63, 217, 32);
		jtf_password = new JTextField();
		jtf_password.setBounds(156, 114, 217, 32);
		jtf_sure = new JTextField();
		jtf_sure.setBounds(156, 167, 217, 32);
		jtf_id = new JTextField();
		jtf_id.setBounds(156, 288, 217, 32);
		jtf_phonenumber = new JTextField();
		jtf_phonenumber.setBounds(156, 343, 217, 32);

		JPanel jp_info = new JPanel();
		jp_info.setBounds(0, 0, 434, 461);
		jp_info.setLayout(null);
				
				JRadioButton rd_girl = new JRadioButton("\u5973");
				buttonGroup.add(rd_girl);
				rd_girl.setBounds(272, 230, 54, 23);
				jp_info.add(rd_girl);
				
				JRadioButton rd_boy = new JRadioButton("\u7537");
				buttonGroup.add(rd_boy);
				rd_boy.setBounds(157, 230, 46, 23);
				jp_info.add(rd_boy);
		
				JButton jb_sure = new JButton("确定");
				jb_sure.setBounds(157, 406, 72, 23);
				jp_info.add(jb_sure);
				jb_sure.setFont(new Font("华文新魏", Font.PLAIN, 16));
				
		JButton jb_cancel = new JButton("取消");
		jb_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		jb_cancel.setBounds(268, 406, 72, 23);
		jp_info.add(jb_cancel);
		jb_cancel.setFont(new Font("华文新魏", Font.PLAIN, 16));

		jp_info.add(jl_username);
		jp_info.add(jtf_username);

		jp_info.add(jl_password);
		jp_info.add(jtf_password);

		jp_info.add(jl_sure);
		jp_info.add(jtf_sure);

		jp_info.add(jl_sex);

		jp_info.add(jl_id);
		jp_info.add(jtf_id);

		jp_info.add(jl_phonenumber);
		jp_info.add(jtf_phonenumber);
		getContentPane().setLayout(null);

		getContentPane().add(jp_info);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("tp\\h.jpg"));
		lblNewLabel.setBounds(0, 0, 434, 460);
		jp_info.add(lblNewLabel);
		
		setVisible(true);
		
		// --------确认按钮监听---------------------------------------
		jb_sure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin identify = new Admin();
				identify.setEname(jtf_username.getText());
				identify.setKey(jtf_password.getText());
				identify.setSurekey(jtf_sure.getText());
				if(rd_boy.isSelected()) identify.setSex("男");
				else identify.setSex("女");
				identify.setId(jtf_id.getText());
				identify.setPhonenumber(jtf_phonenumber.getText());

				boolean b7 = new CheckEnrollnull().checkenrollnull(identify);
				if (b7 == false) {
					JOptionPane.showMessageDialog(null, "请输入完整的注册信息！");
					return;
				}
				boolean a1 = new Admin_action_Impl().enroll(identify);
				if (a1) {
					JOptionPane.showMessageDialog(null, "恭喜你注册用户成功请返回登录界面登录！");
					dispose();	
				}
			}
		});

	}
}
