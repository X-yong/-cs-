package com.xy.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.xy.bussiness.impl.Admin_action_Impl;
import com.xy.bussiness.impl.User_action_Impl;
import com.xy.entity.Admin;
import com.xy.entity.User;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class adminUpdate_view extends JInternalFrame {

	private JPanel contentPane;
	private JTable admin_table;
	private JTextField tf_user;
	private JTextField tf_sex;
	private JTextField tf_id;

	/**
	 * Create the frame.
	 */
	public adminUpdate_view() {
		setClosable(true);
		setIconifiable(true);
		setBackground(Color.WHITE);
		setBounds(50, 10, 701, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new TitledBorder(null, "\u67E5\u8BE2\u7BA1\u7406\u5458", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 665, 231);
		contentPane.add(scrollPane);
		
		admin_table = new JTable();
		admin_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7528\u6237\u540D", "\u5BC6\u7801", "\u6027\u522B", "\u8EAB\u4EFD\u771F\u8BC1\u53F7\u7801", "\u7535\u8BDD\u53F7\u7801"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		admin_table.getColumnModel().getColumn(3).setPreferredWidth(109);
		scrollPane.setViewportView(admin_table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "\u5220\u9664\u7BA1\u7406\u5458", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 265, 665, 195);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D");
		lblNewLabel.setFont(new Font("华文新魏", Font.PLAIN, 16));
		lblNewLabel.setBounds(97, 37, 54, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u6027\u522B");
		lblNewLabel_1.setFont(new Font("华文新魏", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(371, 34, 61, 21);
		panel.add(lblNewLabel_1);
		
		tf_user = new JTextField();
		tf_user.setBounds(200, 34, 118, 21);
		panel.add(tf_user);
		tf_user.setColumns(10);
		
		tf_sex = new JTextField();
		tf_sex.setBounds(442, 34, 54, 21);
		panel.add(tf_sex);
		tf_sex.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\u7801");
		lblNewLabel_2.setFont(new Font("华文新魏", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(97, 78, 93, 15);
		panel.add(lblNewLabel_2);
		
		tf_id = new JTextField();
		tf_id.setBounds(200, 75, 181, 21);
		panel.add(tf_id);
		tf_id.setColumns(10);
		
		JButton seaarch_admin = new JButton("\u67E5  \u8BE2");
		seaarch_admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fillTable() ;
			}
		});
		seaarch_admin.setFont(new Font("华文新魏", Font.PLAIN, 16));
		seaarch_admin.setBounds(114, 151, 93, 23);
		panel.add(seaarch_admin);
		//管理员删除
		JButton delete_admin = new JButton("\u5220  \u9664");
		delete_admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin root = new Admin();
				root.setEname(tf_user.getText());
				root.setSex(tf_sex.getText());
				root.setId(tf_id.getText());
				boolean a = new Admin_action_Impl().delete(root);
				if(a) JOptionPane.showMessageDialog(null,"删除成功！");
				else JOptionPane.showMessageDialog(null ,"删除失败！！");
			}
		});
		delete_admin.setFont(new Font("华文新魏", Font.PLAIN, 16));
		delete_admin.setBounds(292, 151, 93, 23);
		panel.add(delete_admin);
		
		JButton return_admin = new JButton("\u8FD4  \u56DE");
		return_admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		return_admin.setFont(new Font("华文新魏", Font.PLAIN, 16));
		return_admin.setBounds(467, 151, 93, 23);
		panel.add(return_admin);
		//表格鼠标事件
		admin_table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int row = admin_table.getSelectedRow();
				 tf_user.setText(admin_table.getValueAt(row, 0)+"");
				 tf_sex.setText(admin_table.getValueAt(row, 2)+"");
				 tf_id.setText(admin_table.getValueAt(row, 3)+"");				 
			}
		});	
	}
	// ---------------将向量里的值添加到Jtable-------------------------------------------
		public void fillTable() {
			DefaultTableModel dtm = (DefaultTableModel) admin_table.getModel();
			Vector v2 = new Admin_action_Impl().update();
			dtm.setRowCount(0);
			for (int i = 0; i < v2.size(); i++) {
				dtm.addRow((Vector) v2.get(i));
			}
		}
}
