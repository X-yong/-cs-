package com.xy.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/**
*@author    :xiongyong
*@time      :2016-4-25
*@function  :用户反馈
*/

public class FeedBack_view extends JFrame
{
	public FeedBack_view()
	{
	setTitle("用户反馈");
	setBounds(450,200,400,350);
	setResizable(false);
	setIconImage(Toolkit.getDefaultToolkit().createImage("tp/b.png"));
	
	JButton jb_su = new JButton("提交");
	JTextArea jta_message = new JTextArea("请输入你的意见，我们会及时采纳:",20,15);
	jta_message.setLineWrap(true );//设置自动换行
	JPanel jp_message = new JPanel();
	
	jp_message .setLayout(new BorderLayout());
	jp_message.add(jb_su,BorderLayout.SOUTH);
	jp_message .add(jta_message,BorderLayout.CENTER );
	add(jp_message ,BorderLayout.CENTER );
	
	setVisible(true);
	jb_su.addActionListener(new  ActionListener() {

		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	 });	
    }
}

