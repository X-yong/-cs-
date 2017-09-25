package com.xy.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
/**
 * 
 * @author xiongyong
 * @time   2016-4-28
 */
public class About_view extends JFrame  {
       public About_view()
       {
    	   setTitle("关于");
    	   setBounds(450,200,400,500);
    	   setResizable(false);
    	   setIconImage(Toolkit.getDefaultToolkit().createImage("tp/b.png") );
	   
    	   JLabel jla_bk = new JLabel(new ImageIcon("tp/f.jpg"));//设置图标
    	   JLabel jla_wb = new JLabel("WT图书管理系统1.0版");//设置文本区
    	   jla_wb.setHorizontalAlignment(JLabel.CENTER);//设置字体居中
    	   JButton jba_sure = new JButton("确认");
    	   JButton jba_cancel = new JButton("取消");
    	   JPanel  jpa_button = new JPanel();
    	   
    	   setLayout(new BorderLayout());
    	   jpa_button.setLayout(new FlowLayout());
    	   jpa_button.add(jba_sure);
    	   jpa_button.add(jba_cancel);
    	   add(jla_bk,BorderLayout.NORTH );//将图片置于上方
    	   add(jla_wb,BorderLayout.CENTER);//将标签放中间
    	   add(jpa_button,BorderLayout.SOUTH);//按钮放下边
    	    	 
    	   setVisible(true);
    	   
    	   jba_sure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			  }
		   });
    	   
       }
	
}
