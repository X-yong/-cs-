package com.xy.view;

/**
*@author   : xiongyong
*@time     :2016-4-23
*@function :��½����
*/
import java.awt.*;

import javax.sound.midi.SysexMessage;
import javax.swing.*;
import org.omg.CORBA.PUBLIC_MEMBER;
import com.xy.bussiness.impl.Admin_action_Impl;
import com.xy.entity.Admin;
import com.xy.util.CheckNull;
import com.xy.util.DailyRecord;
import com.xy.util.MemoryKey;

import java.awt.event.*;

public class UserLogin_view extends JFrame// ��Userlogin��̳�JFrame��
{
	public int m = 0;
	private static JTextField jtf_user;
	private static JPasswordField jpf_password;
	static JCheckBox ch_memory;

	public UserLogin_view() {
		getContentPane().setBackground(Color.WHITE);
		((JPanel) getContentPane()).setOpaque(false);//����͸��
		// ---------����Jframe----------------------------------------------------------
		setTitle("�û���½");
		setBounds(400, 200, 490, 325);// ���ô��ڴ�С
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// �����˳�����
	    setResizable(false);// ���ô��ڴ�С���ɱ�
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("tp\\a.png"));
		// jp_bj.setBounds(0,0,450,300);
		JButton jb_login = new JButton("��½");

		jb_login.setForeground(new Color(0, 191, 255));
		jb_login.setFont(new Font("������κ", Font.PLAIN, 18));
		jb_login.setBounds(206, 218, 154, 32);
		// -------------------------------------------------------------------------
		JPanel jp_ui = new JPanel();// ��ť���
		jp_ui.setBounds(0, 0, 484, 303);
		jp_ui.setLayout(null);
		jp_ui.setOpaque(false);

		// --------------------------------------------------------------------------
		jp_ui.add(jb_login);
		getContentPane().setLayout(null);
		getContentPane().add(jp_ui);

		JLabel jl_username = new JLabel("\u7528\u6237\u540D");
		jl_username.setFont(new Font("������κ", Font.PLAIN, 15));
		jl_username.setBounds(142, 130, 54, 15);
		jp_ui.add(jl_username);

		jtf_user = new JTextField();
		jtf_user.setBounds(206, 121, 154, 23);
		jp_ui.add(jtf_user);
		jtf_user.setColumns(10);

		JLabel jl_password = new JLabel("\u5BC6\u7801\r\n\r\n");
		jl_password.setFont(new Font("������κ", Font.PLAIN, 15));
		jl_password.setBounds(142, 167, 54, 15);
		jp_ui.add(jl_password);

		jpf_password = new JPasswordField();
		jpf_password.setBounds(206, 158, 154, 23);
		jp_ui.add(jpf_password);

		JLabel jl_enroll = new JLabel("\u6CA1\u6709\u8D26\u53F7\uFF0C\u7ACB\u5373\u521B\u5EFA\u4E00\u4E2A\uFF01");
		// ------------------ע�����--------------------------------------------
		jl_enroll.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent arg0) {
				new Enroll_view();
			}
		});
		jl_enroll.setForeground(new Color(224, 255, 255));
		jl_enroll.setBounds(267, 260, 170, 15);
		jp_ui.add(jl_enroll);

		ch_memory = new JCheckBox("\u8BB0\u4F4F\u5BC6\u7801");
		ch_memory.setFont(new Font("������κ", Font.PLAIN, 12));
		ch_memory.setBounds(206, 189, 103, 23);
		ch_memory.setOpaque(false);
		jp_ui.add(ch_memory);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 494, 303);
		getContentPane().add(layeredPane);

		JLabel J_background = new JLabel("");
		J_background.setIcon(
				new ImageIcon("tp\\aa.png"));
		J_background.setBounds(0, 0, 494, 303);
		layeredPane.add(J_background);

		setVisible(true);
		// ----------------��½����-----------------------------------------------
		jb_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();		
			}
		});
		// ---------------���̼���--------------------------------------------
		jpf_password.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					login();
			}
		});
		//-------------------��ѡ�����--------------------------------------------
			ch_memory.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (ch_memory.isSelected())
				    ch_memory.setSelected(true);
					else ch_memory.setSelected(false);								
				}
			});
	}
	public void login() {
		Admin identify = new Admin();
	    Admin memorykey = new Admin();
		identify.setEname(jtf_user.getText());
		identify.setKey(jpf_password.getText());
		if (ch_memory.isSelected())//�жϸ�ѡ���Ƿ�ѡ��
		{
		memorykey.setEname(jtf_user.getText());
		memorykey.setKey(jpf_password.getText());
		}else {
			memorykey.setEname("");
			memorykey.setKey("");
		}
		boolean s9 = new CheckNull().checknull(identify);
		if (s9) {
			return;
		}
		boolean s6 = new Admin_action_Impl().check(identify);
		if (s6) {
			 dispose();
			// if(ch_memory.isSelected())//�����ѡ��ѡ�оͰ��û���������д�뵽TXT�ĵ�
			 new  MemoryKey().writeMemoryKey(memorykey);//���û�������д���ĵ�
			 new MainFrame_view(jtf_user.getText());//���������沢���û�������
			 new DailyRecord().dailyWrite(jtf_user.getText()," �û�����ϵͳ ʱ��Ϊ ��");
		} else
			JOptionPane.showMessageDialog(null, "��½ʧ�������µ�¼��");
	}
    public static void a()
    {
      Admin a = new MemoryKey().readMemoryKey();//��ȡ�û�������TXT�ĵ�
 	    if("".equals(a.getEname()) || a.getEname() ==null)
 	    {
 	     ch_memory.setSelected(false);
 	    }else {
 	    	ch_memory.setSelected(true);
 	 	    jtf_user.setText(a.getEname());
 	 	    jpf_password.setText(a.getKey());
 	    }	
    }
	public static void main(String[] args) {
		new UserLogin_view();
		a();
	}
}
