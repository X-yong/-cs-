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
    	   setTitle("����");
    	   setBounds(450,200,400,500);
    	   setResizable(false);
    	   setIconImage(Toolkit.getDefaultToolkit().createImage("tp/b.png") );
	   
    	   JLabel jla_bk = new JLabel(new ImageIcon("tp/f.jpg"));//����ͼ��
    	   JLabel jla_wb = new JLabel("WTͼ�����ϵͳ1.0��");//�����ı���
    	   jla_wb.setHorizontalAlignment(JLabel.CENTER);//�����������
    	   JButton jba_sure = new JButton("ȷ��");
    	   JButton jba_cancel = new JButton("ȡ��");
    	   JPanel  jpa_button = new JPanel();
    	   
    	   setLayout(new BorderLayout());
    	   jpa_button.setLayout(new FlowLayout());
    	   jpa_button.add(jba_sure);
    	   jpa_button.add(jba_cancel);
    	   add(jla_bk,BorderLayout.NORTH );//��ͼƬ�����Ϸ�
    	   add(jla_wb,BorderLayout.CENTER);//����ǩ���м�
    	   add(jpa_button,BorderLayout.SOUTH);//��ť���±�
    	    	 
    	   setVisible(true);
    	   
    	   jba_sure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			  }
		   });
    	   
       }
	
}
