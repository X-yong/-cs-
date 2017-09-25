package com.xy.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.xy.dao.impl.Book_dao_Impl;
import com.xy.entity.Bookanalyse;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Bcount_view extends JFrame {

	private JPanel contentPane;
	private JTextField tf_total;
	private JTextField tf_borrow;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Bcount frame = new Bcount();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	/**
	 * Create the frame.
	 */
	public Bcount_view() {
		setTitle("\u56FE\u4E66\u7EDF\u8BA1");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(350, 200, 303, 226);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 218, 185));
		contentPane.setForeground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u603B\u91CF\uFF08\u518C\uFF09");
		lblNewLabel.setFont(new Font("华文新魏", Font.PLAIN, 14));
		lblNewLabel.setIcon(new ImageIcon("selecticon\\borrowbook.png"));
		lblNewLabel.setBounds(10, 44, 118, 15);
		contentPane.add(lblNewLabel);
		
		tf_total = new JTextField();
		tf_total.setBounds(155, 40, 66, 21);
		contentPane.add(tf_total);
		tf_total.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u5DF2\u501F\u9605\u91CF\uFF08\u518C\uFF09");
		lblNewLabel_1.setFont(new Font("华文新魏", Font.PLAIN, 14));
		lblNewLabel_1.setIcon(new ImageIcon("selecticon\\retuanbook.png"));
		lblNewLabel_1.setBounds(10, 107, 146, 15);
		contentPane.add(lblNewLabel_1);
		
		tf_borrow = new JTextField();
		tf_borrow.setBounds(155, 103, 66, 21);
		contentPane.add(tf_borrow);
		tf_borrow.setColumns(10);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setBounds(90, 155, 93, 23);
		contentPane.add(btnNewButton);
		
		Bookanalyse  a = new Book_dao_Impl().Bookcount(); 
		tf_total.setText(a.getBooktotal());
		tf_borrow.setText(a.getBookborrowanalyse());
		setVisible(true);
	}
}
