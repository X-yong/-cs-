package com.xy.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/**
*@author    :xiongyong
*@time      :2016-4-25
*@function  :�û�����
*/

public class FeedBack_view extends JFrame
{
	public FeedBack_view()
	{
	setTitle("�û�����");
	setBounds(450,200,400,350);
	setResizable(false);
	setIconImage(Toolkit.getDefaultToolkit().createImage("tp/b.png"));
	
	JButton jb_su = new JButton("�ύ");
	JTextArea jta_message = new JTextArea("�����������������ǻἰʱ����:",20,15);
	jta_message.setLineWrap(true );//�����Զ�����
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

