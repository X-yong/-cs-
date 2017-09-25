package com.xy.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.JobAttributes;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.xy.bussiness.impl.Book_action_Impl;
import com.xy.bussiness.impl.User_action_Impl;
import com.xy.entity.User;

import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class BorroworBackBooks_view extends JInternalFrame {

	private JPanel contentPane;
	private JTextField tf_breader;
	private JTextField tf_bbooks;
	private JTextField tf_rreader;
	private JTextField tf_rbooks;
	private JTable table_record;
	private JTextField tf_lender;

//
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BorroworBackBooks_view frame = new BorroworBackBooks_view();
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
	public BorroworBackBooks_view() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("\u5FEB\u6377\u501F\u4E66");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1000, 534);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "\u501F\u4E66\u4E0E\u8FD8\u4E66", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 964, 183);
		contentPane.add(panel);
		panel.setLayout(null);
		
		tf_breader = new JTextField();
		tf_breader.setBounds(205, 42, 93, 21);
		panel.add(tf_breader);
		tf_breader.setColumns(10);
		
		JButton jb_borrowbooks = new JButton("\u501F\u4E66");
		jb_borrowbooks.setFont(new Font("华文新魏", Font.PLAIN, 16));
		jb_borrowbooks.setBounds(666, 35, 93, 23);
		panel.add(jb_borrowbooks);
		
		JLabel lblNewLabel_1 = new JLabel("\u4E66\u540Did");
		lblNewLabel_1.setFont(new Font("华文新魏", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(343, 42, 54, 15);
		panel.add(lblNewLabel_1);
		
		tf_bbooks = new JTextField();
		tf_bbooks.setBounds(428, 36, 130, 21);
		panel.add(tf_bbooks);
		tf_bbooks.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u8BFB\u8005id");
		lblNewLabel_2.setFont(new Font("华文新魏", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(104, 105, 54, 15);
		panel.add(lblNewLabel_2);
		
		tf_rreader = new JTextField();
		tf_rreader.setBounds(205, 102, 94, 21);
		panel.add(tf_rreader);
		tf_rreader.setColumns(10);
		
		tf_rbooks = new JTextField();
		tf_rbooks.setBounds(428, 102, 130, 21);
		panel.add(tf_rbooks);
		tf_rbooks.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u4E66\u540Did");
		lblNewLabel_3.setFont(new Font("华文新魏", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(343, 105, 54, 15);
		panel.add(lblNewLabel_3);
		
		JButton jb_returnbooks = new JButton("\u8FD8\u4E66");
		jb_returnbooks.setFont(new Font("华文新魏", Font.PLAIN, 16));
		jb_returnbooks.setBounds(666, 101, 93, 23);
		panel.add(jb_returnbooks);
		
		JLabel lblNewLabel = new JLabel("\u501F\u9605\u8005id");
		lblNewLabel.setFont(new Font("华文新魏", Font.PLAIN, 16));
		lblNewLabel.setBounds(104, 45, 71, 15);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "\u8BFB\u8005\u501F\u4E66\u8BB0\u5F55", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(10, 203, 964, 226);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 944, 193);
		panel_1.add(scrollPane);
		
		table_record = new JTable();
		table_record.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BFB\u8005", "\u8BFB\u8005id", "\u4E66\u540D", "\u4E66id", "\u501F\u4E66\u65E5\u671F", "\u8FD8\u4E66\u622A\u6B62\u65E5\u671F", "\u662F\u5426\u903E\u671F", "\u5E94\u4EA4\u7F5A\u91D1"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_record.getColumnModel().getColumn(4).setPreferredWidth(90);
		table_record.getColumnModel().getColumn(5).setPreferredWidth(89);
		scrollPane.setViewportView(table_record);
		
		JButton jb_srecord = new JButton("\u67E5\u8BE2\u8BB0\u5F55");
		jb_srecord.setFont(new Font("华文新魏", Font.PLAIN, 16));
		jb_srecord.setBounds(441, 455, 123, 23);
		contentPane.add(jb_srecord);
		
		JButton jb_c = new JButton("\u8FD4\u56DE");
		jb_c.setFont(new Font("华文新魏", Font.PLAIN, 16));
		jb_c.setBounds(749, 455, 93, 23);
		contentPane.add(jb_c);
		
		JLabel lblNewLabel_4 = new JLabel("\u501F\u9605\u8005id");
		lblNewLabel_4.setFont(new Font("华文新魏", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(88, 459, 64, 15);
		contentPane.add(lblNewLabel_4);
		
		tf_lender = new JTextField();
		tf_lender.setBounds(197, 456, 197, 21);
		contentPane.add(tf_lender);
		tf_lender.setColumns(10);
		setVisible(true);
		jb_c.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
		
		//借书监听
		jb_borrowbooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s1 = tf_breader.getText();
				String s2 = tf_bbooks.getText();
				 boolean s = new Book_action_Impl().borrowBooks(s1, s2);
				 if(s) JOptionPane.showMessageDialog(null, "借书成功,请保管好书籍以免出现遗失破损，谢谢合作！！");
				 else JOptionPane.showMessageDialog(null, "很遗憾借书失败，请查看你的借书量是否已超过5本！！");
			}
		});
		//查询记录监听
		jb_srecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s3 = tf_lender.getText();
				fillTable(s3);
			}
		});
		//还书监听
		jb_returnbooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s4 = tf_rreader.getText();
				String s5 = tf_rbooks.getText();
				 boolean  s6 = new Book_action_Impl().returnBooks(s4, s5);
				 if (s6) JOptionPane.showMessageDialog(null,"还书成功，欢迎再次借阅！！");	
				 else JOptionPane.showMessageDialog(null,"还书失败，请检查你是否有借阅记录！！");
			}
		});
	}
	// ---------------将向量里的值添加到Jtable-------------------------------------------
		public void fillTable(String s3) {
			DefaultTableModel dtm = (DefaultTableModel) table_record.getModel();
			Vector v4 = new Book_action_Impl().selectBorrowBooks(s3);
			dtm.setRowCount(0);
			for (int i = 0; i < v4.size(); i++) {
				dtm.addRow((Vector) v4.get(i));
			}
		}
}
