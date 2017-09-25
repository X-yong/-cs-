package com.xy.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;

import com.xy.bussiness.impl.User_action_Impl;
import com.xy.entity.User;

import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.TitledBorder;

public class UpdateUser_view extends JInternalFrame {

	private JPanel contentPane;
	private JTextField tf_sname;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table_user;
	private JTextField tf_uname;
	private JTextField tf_usid;
	private JTextField tf_uphone;
	private JRadioButton rb_boy;
	private JRadioButton rb_girl;
	private JRadioButton rb_all;
	private JTextField tf_unumber;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField tf_credit;
	private JTextField tf_enrolltime;
	private JTextField tf_canceltime;

	public UpdateUser_view() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);

		setTitle("\u67E5\u627E\u4E0E\u4FEE\u6539\u7528\u6237");
		setBounds(0, 0, 1007, 535);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 68, 971, 207);
		contentPane.add(scrollPane);

		table_user = new JTable();

		table_user.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u59D3\u540D", "\u6027\u522B", "\u8EAB\u4EFD\u8BC1\u53F7\u7801", "\u8054\u7CFB\u7535\u8BDD", "\u7528\u6237\u7F16\u53F7", "\u6CE8\u518C\u65F6\u95F4", "\u9500\u6237\u65F6\u95F4", "\u4FE1\u7528\u503C"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table_user);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)),
				"\u67E5\u8BE2\u7528\u6237\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 971, 266);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("srarch");
		lblNewLabel.setBounds(58, 23, 75, 15);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Calisto MT", Font.PLAIN, 16));

		tf_sname = new JTextField();
		tf_sname.setBounds(143, 21, 202, 21);
		panel.add(tf_sname);
		// 搜索用户键盘监听
		tf_sname.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				searchuser_key();
			}
		});
		tf_sname.setForeground(Color.LIGHT_GRAY);
		tf_sname.setToolTipText("");
		tf_sname.setColumns(10);

		rb_all = new JRadioButton("\u5168\u90E8");
		rb_all.setBounds(435, 21, 64, 21);
		panel.add(rb_all);
		rb_all.setFont(new Font("华文新魏", Font.PLAIN, 16));
		rb_all.setSelected(true);
		buttonGroup.add(rb_all);

		rb_boy = new JRadioButton("\u7537");
		rb_boy.setBounds(523, 20, 53, 23);
		panel.add(rb_boy);
		rb_boy.setFont(new Font("华文新魏", Font.PLAIN, 16));
		buttonGroup.add(rb_boy);

		rb_girl = new JRadioButton("\u5973");
		rb_girl.setBounds(599, 20, 46, 23);
		panel.add(rb_girl);
		rb_girl.setFont(new Font("华文新魏", Font.PLAIN, 16));
		buttonGroup.add(rb_girl);

		JButton jb_start = new JButton("\u67E5\u8BE2");
		jb_start.setBounds(755, 20, 93, 23);
		panel.add(jb_start);
		jb_start.setFont(new Font("华文新魏", Font.PLAIN, 16));

		// -----------------------查询--------------------------------------------
		jb_start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchuser_key();
			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)),
				"\u4FEE\u6539\u7528\u6237\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(10, 286, 971, 209);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		tf_unumber = new JTextField();
		tf_unumber.setBounds(185, 86, 126, 21);
		panel_1.add(tf_unumber);
		tf_unumber.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("\u7528\u6237\u7F16\u53F7");
		lblNewLabel_5.setBounds(89, 87, 64, 18);
		panel_1.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("华文新魏", Font.PLAIN, 16));

		JLabel lblNewLabel_3 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\u7801");
		lblNewLabel_3.setBounds(89, 58, 86, 15);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("华文新魏", Font.PLAIN, 16));

		tf_usid = new JTextField();
		tf_usid.setBounds(185, 55, 126, 21);
		panel_1.add(tf_usid);
		tf_usid.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D");
		lblNewLabel_1.setBounds(89, 25, 54, 18);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("华文新魏", Font.PLAIN, 16));

		tf_uname = new JTextField();
		tf_uname.setBounds(185, 24, 126, 21);
		panel_1.add(tf_uname);
		tf_uname.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("\u4FE1\u7528\u503C");
		lblNewLabel_6.setBounds(516, 89, 54, 15);
		panel_1.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("华文新魏", Font.PLAIN, 16));

		tf_credit = new JTextField();
		tf_credit.setBounds(597, 86, 127, 21);
		panel_1.add(tf_credit);
		tf_credit.setEditable(false);
		tf_credit.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("\u8054\u7CFB\u7535\u8BDD");
		lblNewLabel_4.setBounds(516, 62, 71, 15);
		panel_1.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("华文新魏", Font.PLAIN, 16));

		tf_uphone = new JTextField();
		tf_uphone.setBounds(597, 59, 127, 21);
		panel_1.add(tf_uphone);
		tf_uphone.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u6027\u522B");
		lblNewLabel_2.setBounds(516, 27, 54, 15);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("华文新魏", Font.PLAIN, 16));

		JRadioButton rd_boy = new JRadioButton("\u7537");
		rd_boy.setBounds(597, 23, 46, 23);
		panel_1.add(rd_boy);
		buttonGroup_1.add(rd_boy);

		JRadioButton rd_girl = new JRadioButton("\u5973");
		rd_girl.setBounds(667, 23, 53, 23);
		panel_1.add(rd_girl);
		buttonGroup_1.add(rd_girl);
		
				JButton jb_update = new JButton("\u4FEE\u6539");
				jb_update.setBounds(325, 165, 93, 23);
				panel_1.add(jb_update);
				jb_update.setFont(new Font("华文新魏", Font.PLAIN, 16));
				
						JButton jb_c = new JButton("\u8FD4\u56DE");
						jb_c.setBounds(500, 165, 93, 23);
						panel_1.add(jb_c);
						// 取消键监听
						jb_c.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								dispose();
							}
						});
						jb_c.setFont(new Font("华文新魏", Font.PLAIN, 16));
						
						JLabel label = new JLabel("\u6CE8\u518C\u65F6\u95F4");
						label.setFont(new Font("华文新魏", Font.PLAIN, 16));
						label.setBounds(89, 122, 71, 15);
						panel_1.add(label);
						
						tf_enrolltime = new JTextField();
						tf_enrolltime.setBounds(185, 119, 126, 21);
						panel_1.add(tf_enrolltime);
						tf_enrolltime.setColumns(10);
						
						JLabel label_1 = new JLabel("\u9500\u6237\u65F6\u95F4");
						label_1.setFont(new Font("华文新魏", Font.PLAIN, 16));
						label_1.setBounds(516, 120, 71, 15);
						panel_1.add(label_1);
						
						tf_canceltime = new JTextField();
						tf_canceltime.setBounds(597, 119, 127, 21);
						panel_1.add(tf_canceltime);
						tf_canceltime.setColumns(10);
				// -------------------修改------------------------------------------
				jb_update.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						User updateuser = new User();
						if (rd_boy.isSelected())
							updateuser.setUsex("男");
						else
							updateuser.setUsex("女");
						updateuser.setUname(tf_uname.getText());
						updateuser.setUsid(tf_usid.getText());
						updateuser.setUphone(tf_uphone.getText());
						updateuser.setUnumber(tf_unumber.getText());
						updateuser.setEnrolltime(tf_enrolltime.getText());
						updateuser.setCanceltime(tf_canceltime.getText());
						updateuser.setCredit(tf_credit.getText());

						boolean s = new User_action_Impl().updateUser(updateuser);
						if (s)
							JOptionPane.showMessageDialog(null, "修改用户信息成功！！");
						else
							JOptionPane.showMessageDialog(null, "修改用户信息失败！！");
					}
				});
	
		// --------------------鼠标事件取得点击的行-------------------------------------------------------
		table_user.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent arg0) {
				int row = table_user.getSelectedRow();
				tf_uname.setText(table_user.getValueAt(row, 0) + "");
				String s = (table_user.getValueAt(row, 1) + "");
				if ("男".equals(s))
					rd_boy.setSelected(true);
				else
					rd_girl.setSelected(true);
				tf_usid.setText(table_user.getValueAt(row, 2) + "");
				tf_uphone.setText(table_user.getValueAt(row, 3) + "");
				tf_unumber.setText(table_user.getValueAt(row, 4) + "");
				tf_enrolltime.setText(table_user.getValueAt(row, 5)+"");
				tf_canceltime.setText(table_user.getValueAt(row, 6)+"");
				tf_credit.setText(table_user.getValueAt(row, 7) + "");
			}
		});
	}

	public void searchuser_key() {
		User selectuser = new User();
		selectuser.setUname(tf_sname.getText());
		if (rb_all.isSelected())
			selectuser.setUsex("");
		else if (rb_boy.isSelected())
			selectuser.setUsex("男");
		else
			selectuser.setUsex("女");
		fillTable(selectuser);

	}

	// ---------------将向量里的值添加到Jtable-------------------------------------------
	public void fillTable(User selectuser) {
		DefaultTableModel dtm = (DefaultTableModel) table_user.getModel();
		Vector v2 = new User_action_Impl().searchUser(selectuser);
		dtm.setRowCount(0);
		for (int i = 0; i < v2.size(); i++) {
			dtm.addRow((Vector) v2.get(i));
		}
	}
}
