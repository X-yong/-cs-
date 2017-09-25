package com.xy.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

/**
 * @author :xiongyong
 * @time :2016-4-25
 * @function :留言板
 */

public class MessageBoard_view extends JFrame {
	JTextArea jta_message;
	public MessageBoard_view() {
		setTitle("留言板");
		setBounds(450, 200, 468, 343);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().createImage("tp/b.png"));
		getContentPane().setLayout(null);
		((JPanel) getContentPane()).setOpaque(false);
		jta_message = new JTextArea("请输入你的留言:", 20, 15);
		jta_message.setBounds(0, 0, 290, 186);
		jta_message.setLineWrap(true);// 设置自动换行
		JPanel jp_message = new JPanel();
		jp_message.setBounds(80, 55, 290, 186);
		jp_message.setLayout(null);
		jp_message.add(jta_message);
		jp_message.setOpaque(false);
		getContentPane().add(jp_message);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 459, 310);
		getContentPane().add(layeredPane);
				
				JButton jb_r = new JButton("\u8FD4\u56DE");
				jb_r.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				jb_r.setBounds(249, 260, 68, 23);
				layeredPane.add(jb_r);
		
				JButton jb_su = new JButton("提交");
				jb_su.setBounds(122, 260, 68, 23);
				layeredPane.add(jb_su);
				
						jb_su.addActionListener(new ActionListener() {
				
							public void actionPerformed(ActionEvent arg0) {
								File file = new File("messageboard/" + "messageboard.txt");
				
								BufferedWriter bw = null;
								BufferedReader br = null;
								try {
									bw = new BufferedWriter(new FileWriter(file));
									// br = new BufferedReader(new FileReader(file));
									bw.write(jta_message.getText());
				                     JOptionPane.showMessageDialog(null, "提交成功！！");
				                     
				                     dispose();
				                     
								} catch (FileNotFoundException e) {
									e.printStackTrace();
								} catch (IOException e) {
									e.printStackTrace();
								}
								finally
								{
									if (bw !=null)
										try {
											bw.close();
										} catch (IOException e) {
											e.printStackTrace();
										}
								}
							}
						});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("tp\\g.jpg"));
		lblNewLabel.setBounds(0, 0, 456, 310);
		layeredPane.add(lblNewLabel);

		setVisible(true);

	}
}
