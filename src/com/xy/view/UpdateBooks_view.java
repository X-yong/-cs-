package com.xy.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.xy.bussiness.impl.Book_action_Impl;
import com.xy.bussiness.impl.User_action_Impl;
import com.xy.entity.Books;
import com.xy.entity.User;

import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;

public class UpdateBooks_view extends JInternalFrame {
	private JTextField tf_bookname;
	private JTextField tf_bname;
	private JTextField tf_bprice;
	private JTextField tf_bauthor;
	private JTextField tf_bisbn;
	private JTextField tf_bissue;
	private JTextField tf_bstock;
	private JTextField tf_bnumber;
	private Object order1;
	private JTable table_books;
	private JTextField tf_addtime;


//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Updatebooks_view frame = new Updatebooks_view();
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
	public UpdateBooks_view() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("\u67E5\u8BE2\u4E0E\u4FEE\u6539\u56FE\u4E66");
		setBackground(Color.GRAY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1000, 531);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(64, 64, 64)), "\u67E5\u8BE2\u56FE\u4E66\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		panel.setBounds(10, 10, 964, 242);
		panel.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("searchbooks");
		lblNewLabel.setFont(new Font("华文新魏", Font.PLAIN, 17));
		lblNewLabel.setBounds(85, 30, 98, 18);
		panel.add(lblNewLabel);
		
		tf_bookname = new JTextField();
		tf_bookname.setBounds(213, 29, 162, 21);
		panel.add(tf_bookname);
		tf_bookname.setColumns(10);
		
		JButton jb_search = new JButton("\u67E5\u8BE2");
		jb_search.setBackground(Color.WHITE);
		jb_search.setFont(new Font("华文新魏", Font.PLAIN, 18));
		jb_search.setBounds(675, 28, 93, 23);
		panel.add(jb_search);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 74, 964, 168);
		panel.add(scrollPane);
		
		table_books = new JTable();
		table_books.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"bname", "bauthor", "bissue", "bnumber", "bprice", "bisbn", "bstock", "addtime"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table_books);
		//下拉栏
		JComboBox cb_order = new JComboBox();
		cb_order.setFont(new Font("华文新魏", Font.PLAIN, 15));
		cb_order.setModel(new DefaultComboBoxModel(new String[] {"~order by~", "bname", "bnumber", "bprice", "bstock"}));
		cb_order.setBounds(513, 30, 98, 21);
		panel.add(cb_order);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "\u4FEE\u6539\u56FE\u4E66\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		panel_1.setBounds(10, 262, 964, 229);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("bname");
		lblNewLabel_1.setFont(new Font("华文新魏", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(179, 34, 54, 15);
		panel_1.add(lblNewLabel_1);
		
		tf_bname = new JTextField();
		tf_bname.setBounds(260, 31, 149, 21);
		panel_1.add(tf_bname);
		tf_bname.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("bprice");
		lblNewLabel_2.setFont(new Font("华文新魏", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(570, 34, 66, 15);
		panel_1.add(lblNewLabel_2);
		
		tf_bprice = new JTextField();
		tf_bprice.setBounds(660, 31, 135, 21);
		panel_1.add(tf_bprice);
		tf_bprice.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("bauthor");
		lblNewLabel_3.setFont(new Font("华文新魏", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(179, 73, 71, 15);
		panel_1.add(lblNewLabel_3);
		
		tf_bauthor = new JTextField();
		tf_bauthor.setBounds(260, 70, 149, 21);
		panel_1.add(tf_bauthor);
		tf_bauthor.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("bisbn");
		lblNewLabel_4.setFont(new Font("华文新魏", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(570, 73, 54, 15);
		panel_1.add(lblNewLabel_4);
		
		tf_bisbn = new JTextField();
		tf_bisbn.setBounds(660, 70, 135, 21);
		panel_1.add(tf_bisbn);
		tf_bisbn.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("bissue");
		lblNewLabel_5.setFont(new Font("华文新魏", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(179, 113, 54, 15);
		panel_1.add(lblNewLabel_5);
		
		tf_bissue = new JTextField();
		tf_bissue.setBounds(260, 110, 149, 21);
		panel_1.add(tf_bissue);
		tf_bissue.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("bstock");
		lblNewLabel_6.setFont(new Font("华文新魏", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(570, 109, 54, 15);
		panel_1.add(lblNewLabel_6);
		
		tf_bstock = new JTextField();
		tf_bstock.setBounds(660, 106, 135, 21);
		panel_1.add(tf_bstock);
		tf_bstock.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("bnumber");
		lblNewLabel_7.setFont(new Font("华文新魏", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(179, 144, 71, 15);
		panel_1.add(lblNewLabel_7);
		
		tf_bnumber = new JTextField();
		tf_bnumber.setBounds(260, 141, 149, 21);
		panel_1.add(tf_bnumber);
		tf_bnumber.setColumns(10);
		
		JButton jb_bupdate = new JButton("\u4FEE\u6539");
		jb_bupdate.setFont(new Font("华文新魏", Font.PLAIN, 18));
		jb_bupdate.setBounds(432, 186, 93, 23);
		panel_1.add(jb_bupdate);
		
		JButton jb_bc = new JButton("\u8FD4\u56DE");
		jb_bc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		jb_bc.setFont(new Font("华文新魏", Font.PLAIN, 18));
		jb_bc.setBounds(642, 186, 93, 23);
		panel_1.add(jb_bc);
		
		JLabel lblAddtime = new JLabel("addtime");
		lblAddtime.setFont(new Font("华文新魏", Font.PLAIN, 16));
		lblAddtime.setBounds(570, 144, 80, 15);
		panel_1.add(lblAddtime);
		
		tf_addtime = new JTextField();
		tf_addtime.setBounds(660, 141, 135, 21);
		panel_1.add(tf_addtime);
		tf_addtime.setColumns(10);
		setVisible(true);
		//查询图书
		jb_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				order1 =cb_order.getSelectedItem();	//获取下拉栏里面的值
				Books  selectbooks = new Books();
				selectbooks.setBname(tf_bookname.getText());
				selectbooks.setOrder(order1);
				fillTable(selectbooks);
				//--------------------------------------------------------------
			
			}
		});
		//修改图书
		jb_bupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Books updatebooks = new Books();
				updatebooks.setBname(tf_bname.getText());
				updatebooks.setBauthor(tf_bauthor.getText());
				updatebooks.setBissue(tf_bissue.getText());
				updatebooks.setBnumber(tf_bnumber.getText());
				updatebooks.setBprice(Integer.parseInt(tf_bprice.getText()));
				updatebooks.setBisbn(tf_bisbn.getText());
				updatebooks.setBstock(Integer.parseInt(tf_bstock.getText()));
				updatebooks.setAddtime(tf_addtime.getText());
				boolean a = new Book_action_Impl().updateBooks(updatebooks);
				if(a) JOptionPane.showMessageDialog(null,"修改图书信息成功！");
				else JOptionPane.showMessageDialog(null,"修改图书信息失败");	
			}
		});
		//--------------------------设置鼠标事件-----------------------------------------
				table_books.addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent arg0) {
						int row = table_books.getSelectedRow();
						tf_bname.setText(table_books.getValueAt(row, 0) + "");//通过Jtable的getValueAt
						tf_bauthor.setText(table_books.getValueAt(row, 1) + "");//将单元格里的值赋给文本框
						tf_bissue.setText(table_books.getValueAt(row, 2) + "");
						tf_bnumber.setText(table_books.getValueAt(row, 3) + "");				
						tf_bprice.setText(table_books.getValueAt(row, 4) + "");
						tf_bisbn.setText(table_books.getValueAt(row, 5) + "");
						tf_bstock.setText(table_books.getValueAt(row, 6) + "");
						tf_addtime.setText(table_books.getValueAt(row, 7)+"");
					}
				});
	}
	//填充查询图书的Jtable
	public void fillTable(Books selectbooks) {
		DefaultTableModel dtm = (DefaultTableModel) table_books.getModel();
		Vector v2 = new Book_action_Impl().searchbooks(selectbooks);
		dtm.setRowCount(0);
		for (int i = 0; i < v2.size(); i++) {
			dtm.addRow((Vector) v2.get(i));
		}
	}
}
