package com.xy.view;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTextArea;

import com.xy.util.DailyRecord;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class DailyRecord_view extends JInternalFrame {
	private final JScrollPane scrollPane = new JScrollPane();
	public DailyRecord_view( String us)
	{

		getContentPane().setFont(new Font("������κ", Font.PLAIN, 16));
		setClosable(true);
		setTitle("\u7CFB\u7EDF\u65E5\u5FD7");
		setIconifiable(true);
		setMaximizable(true);
		getContentPane().setLayout(null);
		setBounds(0,0,1000,500);
		scrollPane.setBounds(0, 49, 974, 416);
		getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u767B\u9646\u65E5\u5FD7");
		lblNewLabel.setFont(new Font("������κ", Font.PLAIN, 25));
		lblNewLabel.setBounds(411, 20, 182, 19);
		getContentPane().add(lblNewLabel);
		
		
		//����dailyreader������ȡ��־�ļ�
		if( "root".equals(us))
		{
		Vector v = new DailyRecord().dailyReader();
		String s = null;
		for(int i =0; i<v.size(); i++)
			s = s+(v.get(i).toString())+"\n";
		    
		    textArea.setText(s);
		}else JOptionPane.showMessageDialog(null,"�Բ�����û���㹻��Ȩ�޲鿴ϵͳ��־������ϵϵͳ����Ա����");
	}
}
