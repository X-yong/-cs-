package com.xy.view;

/**
*@author  :xiongyong
*@time    :2016-4-22
*
*
*/
import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.xy.util.DailyRecord;

public class MainFrame_view extends JFrame 
{   
	 JDesktopPane desktopPane;
     public MainFrame_view(String us)
	{
      setTitle("�𾴵ģ�"+us+" ���");
	  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//������ϽǵĲ��˳�
      setSize(1105,685);
	  setLocation(200,40);
	  setResizable(false);//���ô�С���ɱ�
	  setTray(us);//����������ʾ����
	 
	  //final int SCREEN_HEIGHT  = Toolkit.getDefaultToolkit().getScreenSize().height;
	  // final int SCREEN_WIDTH  = Toolkit.getDefaultToolkit().getScreenSize().width;
	  //JOptionPane.showMessageDialog(null,"��Ļ��:"+SCREEN_WIDTH+ "  ��Ļ�߶�:"+SCREEN_HEIGHT);
	  //frame.setLocation((SCREEN_WIDTH-500)/2,(SCREEN_HEIGHT-300)/2); 
	  //-----------------------------------------------------------------------------------	
	  ((JPanel) getContentPane()).setOpaque(false);//����ContentPane��͸��
	  JPanel jp_all = new JPanel();
	  jp_all.setOpaque(false);
	  JPanel title_panel = new JPanel();
	  title_panel.setBackground(Color.LIGHT_GRAY);
	  title_panel.setForeground(Color.WHITE);
	  title_panel.setBounds(83, 0, 1006, 61);
	  jp_all.add(title_panel);
	  
	
	//-------------------------------------------------------------------------------------
	  setIconImage(Toolkit.getDefaultToolkit().createImage("tp/d.png"));//�������Ͻ�ͼ��
		
     //------------------------------------------------------------------------------------
	  JMenuBar menubar = new JMenuBar();//�����˵���
	  menubar.setBackground(Color.LIGHT_GRAY);
	  JMenu jm_userinfo = new JMenu("�û���Ϣ����");//�����˵�
	  jm_userinfo.setFont(new Font("������κ", Font.PLAIN, 16));
	   JMenuItem jm_userinfo1 = new JMenuItem("����û�");//�����Ӳ˵�
	   jm_userinfo1.setFont(new Font("������κ", Font.PLAIN, 16));
	   jm_userinfo1.setIcon(new ImageIcon("selecticon\\adduser.png"));
	   jm_userinfo1.setSelectedIcon(new ImageIcon("selecticon\\a.ico"));
	   JMenuItem jm_userinfo2 = new JMenuItem("ɾ���û�");
	   jm_userinfo2.setFont(new Font("������κ", Font.PLAIN, 16));
	   jm_userinfo2.setIcon(new ImageIcon("selecticon\\deleteuser.png"));
	   jm_userinfo2.setSelectedIcon(new ImageIcon("selecticon\\b.ico"));
	   JMenuItem jm_userinfo3 = new JMenuItem("��ѯ���޸��û�");
	   jm_userinfo3.setFont(new Font("������κ", Font.PLAIN, 16));
	   jm_userinfo3.setIcon(new ImageIcon("selecticon\\selectandupdate_user.png"));
	   jm_userinfo3.setSelectedIcon(new ImageIcon("selecticon\\c.png"));


	  JMenu jm_bookmanage = new JMenu("ͼ����Ϣ����");//�����ڶ����˵�
	  jm_bookmanage.setFont(new Font("������κ", Font.PLAIN, 16));
	    JMenuItem jm_bookmanage1 = new JMenuItem("���ͼ��");//�����Ӳ˵�
	    jm_bookmanage1.setFont(new Font("������κ", Font.PLAIN, 16));
	    jm_bookmanage1.setIcon(new ImageIcon("selecticon\\addbook.png"));
	    JMenuItem jm_bookmanage2 = new JMenuItem("ɾ��ͼ��");
	    jm_bookmanage2.setFont(new Font("������κ", Font.PLAIN, 16));
	    jm_bookmanage2.setIcon(new ImageIcon("selecticon\\deletebook.png"));
	    JMenuItem jm_bookmanage3 = new JMenuItem("��ѯ���޸�ͼ��");
	    jm_bookmanage3.setFont(new Font("������κ", Font.PLAIN, 16));
	    jm_bookmanage3.setIcon(new ImageIcon("selecticon\\selectandupdate_book.png"));
	  JMenu jm_booklend = new JMenu("ͼ����Ĺ���");//�����������˵�
	  jm_booklend.setFont(new Font("������κ", Font.PLAIN, 16));
	    JMenuItem jm_booklend1 = new JMenuItem("ͼ�����");//�����Ӳ˵�
	    jm_booklend1.setFont(new Font("������κ", Font.PLAIN, 16));
	    jm_booklend1.setIcon(new ImageIcon("selecticon\\borrowbook.png"));
	    JMenuItem jm_booklend2 = new JMenuItem("ͼ��黹");
	    jm_booklend2.setFont(new Font("������κ", Font.PLAIN, 16));
	  
	    jm_booklend2.setIcon(new ImageIcon("selecticon\\retuanbook.png"));
	  JMenu jm_help = new JMenu("����");
	  jm_help.setFont(new Font("������κ", Font.PLAIN, 16));
	    JMenuItem jm_help1 = new JMenuItem("����");
	    jm_help1.setFont(new Font("������κ", Font.PLAIN, 16));
	    jm_help1.setIcon(new ImageIcon("selecticon\\about.png"));
		JMenuItem jm_help2 = new JMenuItem("����");
		jm_help2.setFont(new Font("������κ", Font.PLAIN, 16));
		jm_help2.setIcon(new ImageIcon("selecticon\\feedback.png"));
		JMenuItem jm_help3 = new JMenuItem("�汾����");
		jm_help3.setFont(new Font("������κ", Font.PLAIN, 16));
		jm_help3.setIcon(new ImageIcon("selecticon\\update.png"));
	
	//------------------------------------------------------------------------
	  jm_userinfo.add(jm_userinfo1);//���Ӳ˵����뵽�˵�
	  jm_userinfo.add(jm_userinfo2);
	  jm_userinfo.addSeparator();//����ָ���
	  jm_userinfo.add(jm_userinfo3);
	  
	  jm_bookmanage.add(jm_bookmanage1);
	  jm_bookmanage.add(jm_bookmanage2);
	  jm_bookmanage.addSeparator();//����ָ���
	  jm_bookmanage.add(jm_bookmanage3);
	 

	  jm_booklend.add(jm_booklend1);
	  jm_booklend.add(jm_booklend2);
	  jm_help .add(jm_help1);
	  jm_help .add(jm_help2);
	  jm_help .add(jm_help3);

	//------------------------------------------------------------------------
	  menubar.add(jm_userinfo);//���˵����뵽�˵���
	  menubar.add(jm_bookmanage);
	  menubar.add(jm_booklend);
      
      JMenu mnNewMenu = new JMenu("\u9AD8\u7EA7\u529F\u80FD");
      mnNewMenu.setFont(new Font("������κ", Font.PLAIN, 16));
      menubar.add(mnNewMenu);
      
      JMenuItem admin_search = new JMenuItem("\u7BA1\u7406\u5458\u66F4\u65B0");
      admin_search.setFont(new Font("������κ", Font.PLAIN, 16));
      admin_search.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent arg0) {
      		if("root".equals(us))
      		{
      		adminUpdate_view a = new adminUpdate_view();
      		a.setVisible(true);
      		desktopPane.add(a);
      		a.toFront();
      		}else JOptionPane.showMessageDialog(null, "��û���㹻��Ȩ�޽��д˲�������");
      	}
      });
      admin_search.setIcon(new ImageIcon("selecticon\\admin_search.png"));
      mnNewMenu.add(admin_search);
      JMenuItem jm_infostatistics1 = new JMenuItem("ͼ��ͳ��");//�����Ӳ˵�
      jm_infostatistics1.setFont(new Font("������κ", Font.PLAIN, 16));
      mnNewMenu.add(jm_infostatistics1);
      jm_infostatistics1.setIcon(new ImageIcon("selecticon\\booktotal.png"));
      JMenuItem jm_infostatistics2 = new JMenuItem("ϵͳ��־");
      jm_infostatistics2.setFont(new Font("������κ", Font.PLAIN, 16));
      mnNewMenu.add(jm_infostatistics2);
      jm_infostatistics2.setIcon(new ImageIcon("selecticon\\journal.png"));
      //ϵͳ��־��������Ҫroot�˺ŵ�½��
      jm_infostatistics2.addActionListener(new ActionListener() {		
     	public void actionPerformed(ActionEvent e) {
		DailyRecord_view a = new DailyRecord_view( us);
			 a.setVisible(true);
			 desktopPane.add(a);
			 a.toFront();
			 
		}
	});
      //ͳ��ͼ��ѡ�����
      jm_infostatistics1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    new Bcount_view();		
		}
	});
	  menubar.add(jm_help);
	  
	 //���߳� 
	  TimeThread time = new TimeThread();
	  TitleThread notice = new TitleThread();
	  time.setBackground(Color.LIGHT_GRAY);
	  Thread ttr1 = new Thread(notice);
	  Thread ttr2 = new Thread(time);
	  title_panel.setLayout(null);
	  title_panel.add(time);
	  
	
	  
	  jp_all.setLayout(null);
      
	  time.setBounds(814, 23, 186, 28);
	  
	  JLabel lblNewLabel_1 = new JLabel("WT \u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
	  lblNewLabel_1.setFont(new Font("������κ", Font.PLAIN, 44));
	  lblNewLabel_1.setBounds(347, 0, 365, 51);
	  title_panel.add(lblNewLabel_1);
	  
	  getContentPane().setLayout( new BorderLayout());
	  setJMenuBar(menubar);//���˵��ӵ�frame
	  getContentPane().add(jp_all,BorderLayout.CENTER);
	  
	  JLabel lblNewLabel = new JLabel("");
	  lblNewLabel.setIcon(new ImageIcon("tp\\r.png"));
	  lblNewLabel.setBounds(0, 10, 73, 89);
	  jp_all.add(lblNewLabel);
	  
	  JPanel panel = new JPanel();
	  panel.setBackground(Color.LIGHT_GRAY);
	  panel.setBounds(0, 0, 77, 599);
	  jp_all.add(panel);
	  panel.setLayout(null);
	  JButton jb_download = new JButton(new ImageIcon("tp/q.png"));
	  jb_download.setBounds(0, 300, 77, 55);
	  panel.add(jb_download);
	  JButton jb_messageboard = new JButton(new ImageIcon("tp/p.png"));
	  jb_messageboard.setBounds(0, 368, 77, 55);
	  panel.add(jb_messageboard);
	  JButton jb_changeuser = new JButton(new ImageIcon("tp/n.png"));
	  jb_changeuser.setBounds(0, 435, 77, 55);
	  panel.add(jb_changeuser);
	  JButton jb_exit = new JButton(new ImageIcon("tp/j.png"));
	  jb_exit.setBounds(0, 500, 77, 55);
	  panel.add(jb_exit);
	  
	  	  JButton jb_userinfo = new JButton(new ImageIcon("tp/m.png"));
	  	  jb_userinfo.setBounds(0, 103, 77, 55);
	  	  panel.add(jb_userinfo);
	  	  JButton jb_sersh = new JButton(new ImageIcon("tp/i.png"));
	  	  jb_sersh.setBounds(0, 170, 77, 55);
	  	  panel.add(jb_sersh);
	  	  JButton jb_borrow = new JButton(new ImageIcon("tp/k.png"));
	  	  jb_borrow.setBounds(0, 235, 77, 55);
	  	  panel.add(jb_borrow);
	  	  //--------------------------------------------------------------------------------
	  	  //------------��ݽ��鰴ť����-----------------------------------------------------
	  	  jb_borrow.addActionListener(new ActionListener(){
	  	  	   public void actionPerformed(ActionEvent e)
	  	  		{
	  	  	        BorroworBackBooks_view a =  new BorroworBackBooks_view();
	  	  	        a.setVisible(true);  
	  	  	        desktopPane.add(a);
	  	  	        a.toFront();
	  	  	        new DailyRecord().dailyWrite(us," �û������뻹�����   ʱ��Ϊ: ");
	  	  		}
	  	  	});
	  	  //----------------------------------------------------------------------------
	  	  //------------��ѯͼ�鰴ť����-----------------------------------------------------
	  	  jb_sersh.addActionListener(new ActionListener(){
	  	     public void actionPerformed(ActionEvent e)
	  	  	{
	  	         UpdateBooks_view a =  new UpdateBooks_view();
	  	         a.setVisible(true);
	  	         desktopPane.add(a);
	  	         a.toFront();
	  	         new DailyRecord().dailyWrite(us," �û���ѯͼ��   ʱ��Ϊ: ");
	  	         
	  	      }
	  	  });
	  	  //-----------------------------------------------------------------------------  
	  	  //------------������Ϣ��ť����-----------------------------------------------------
	  	  jb_userinfo.addActionListener(new ActionListener(){
	  	     public void actionPerformed(ActionEvent e)
	  	  	{  
	  	        UserInfo_view a = new UserInfo_view(us);
	  	        a.setVisible(true);
	  	        desktopPane.add(a);
	  	        a.toFront();
	  	        new DailyRecord().dailyWrite(us," �鿴������Ϣ   ʱ��Ϊ: ");//������д����־�ĵ�
	  	      }
	  	  });
	  //-------------------------------------------------------------------------------
	  //�˳�ϵͳ����(������)
	  jb_exit.addMouseListener(new MouseAdapter(){
	     public void mouseClicked(MouseEvent e)	           
	  	{
	        int k =  JOptionPane.showConfirmDialog(null,"��ȷ��Ҫ�˳���","��ʾ",
	      		                             JOptionPane.YES_NO_OPTION);
	  	   if ( k == JOptionPane.YES_OPTION)//�ж��Ƿ���YES������������yes���˳�
	  	   {
	  		   new DailyRecord().dailyWrite(us," �û��˳�ϵͳ   ʱ��Ϊ: ");
	  		   System.exit(0);//�˳������
	  	   }else 
	  		   return;
	  	   //dispose();
	      }
	  });
	  //--------------------------------------------------------------------------------
	//�л��˺ż���(������)
	jb_changeuser.addMouseListener(new MouseAdapter(){
	   public void mouseClicked(MouseEvent e)	           
	  {
	     int k =  JOptionPane.showConfirmDialog(null,"��ȷ��Ҫ�л��˻���","��ʾ",
	  		                                JOptionPane.YES_NO_OPTION);
	     if ( k == JOptionPane.YES_OPTION)//�ж��Ƿ���YES������������yes���˳�
	     {
	  	   new UserLogin_view();
	  	   new DailyRecord().dailyWrite(us," �û��л��˻�   ʱ��Ϊ: ");
	  	   setVisible(false);
	     }else 
	  	   return;
	    }
	 });
	  //--------------------------------------------------------------------------------
	  //------------���԰尴ť����-----------------------------------------------------
	  jb_messageboard.addActionListener(new ActionListener(){
	     public void actionPerformed(ActionEvent e)
	  	{
	           new MessageBoard_view();
	           new DailyRecord().dailyWrite(us," �û�����   ʱ��Ϊ: ");
	      }
	  });
	  //--------------------------------------------------------------------------------
	  //------------���������ذ�ť����-----------------------------------------------------
	  jb_download.addActionListener(new ActionListener(){
	     public void actionPerformed(ActionEvent e)
	     {
	  	try {
	  	Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler"
	  			     + " http://home.feiku.com/shuku/");
	  		} catch (IOException e1) {
	  			
	  			e1.printStackTrace();
	  		} 
	  	 new DailyRecord().dailyWrite(us," �û����ص�����   ʱ��Ϊ: ");
	  	}
	  });
	  
	
	  desktopPane = new JDesktopPane();
	  desktopPane.setBackground(Color.LIGHT_GRAY);
	  desktopPane.setBounds(83, 68, 1006, 531);
	  jp_all.add(desktopPane);
	  
	  JPanel panel_1 = new JPanel();
	  panel_1.setBackground(Color.LIGHT_GRAY);
	  panel_1.setBounds(0, 604, 1089, 31);
	  jp_all.add(panel_1);
	  //  JLabel jl_background = new JLabel(new ImageIcon("tp/e.jpg"));//���ñ���
	  //  jl_background.setBounds(0, 0, 1100, 650);
	   // getLayeredPane().add( jl_background,new Integer( Integer.MIN_VALUE));
	    
// 	    JLabel jl_info = new JLabel("�������WT�Ŷӿ����������������ʾ�����ѯ���Ŷ�");
//	    panel_1.add(jl_info);
//	    jl_info.setBackground(Color.LIGHT_GRAY);
//	    jl_info.setForeground(Color.GRAY);//���ñ�ǩ������ɫ
//	    jl_info.setHorizontalAlignment(JLabel.CENTER);//�����������
//	    jl_info.setFont(new Font("������κ", Font.BOLD, 18));//��������������壬�Ӵ֣��ֺţ�
	    
	    JLabel lblNewLabel_2 = new JLabel("");
	    lblNewLabel_2.setIcon(new ImageIcon("tp\\ss.jpg"));
	    lblNewLabel_2.setBounds(0, 0, 1006, 528);
	    lblNewLabel_2.setOpaque(false);
	    desktopPane.add(lblNewLabel_2);
	  
	 
	 //�����߳�  
	  ttr1.start();
	  panel_1.setLayout(null);
	  notice.setBounds(84, 0, 920, 26);
	  notice .setBackground(Color.LIGHT_GRAY);
	  notice.setFont(new Font("������κ", Font.BOLD, 15));
	  panel_1.add(notice);
	  notice.setLayout(new BorderLayout(0, 0));
	  ttr2.start();
	  setVisible(true);
	
	 //����������������������û���ע�ᡤ����������������������������������������������������������������������������������������������������������������
	  jm_userinfo1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		 	AddUser_view a = new AddUser_view();
		 	a.setVisible(true);
		 	desktopPane.add(a);
		 	a.toFront();
		 	 new DailyRecord().dailyWrite(us," ������û�   ʱ��Ϊ: ");
	   }
    });
	 //������������������������������������������������������������������������������������������������������������������������������������������������������
	// ���������������������ͼ�顤������������������������������������������������������������������������������������������������������������������������
	  jm_bookmanage1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
				AddBook_view a = new AddBook_view();
				a.setVisible(true);
				desktopPane.add(a);
				a.toFront();
				new DailyRecord().dailyWrite(us," ���ͼ��   ʱ��Ϊ: ");
		}
	});
	 //������������������������������������������������������������������������������������������������������������������������������������������������������
	// ������������������ɾ���û���������������������������������������������������������������������������������������������������������������������������
	  jm_userinfo2.addActionListener(new ActionListener() {
	   public void actionPerformed(ActionEvent arg0) {
					DeleteUser_view a = new DeleteUser_view();
					a.setVisible(true);
					desktopPane.add(a);
					a.toFront();
					new DailyRecord().dailyWrite(us," ɾ���û�����   ʱ��Ϊ: ");
			}
		});
	 //������������������������������������������������������������������������������������������������������������������������������������������������������
	 // ������������������ɾ��ͼ�顤������������������������������������������������������������������������������������������������������������������������
	   jm_bookmanage2.addActionListener(new ActionListener() {
	   public void actionPerformed(ActionEvent arg0) {
					DeleteBook_view a = new DeleteBook_view();
					desktopPane.add(a);
					a.toFront();
					new DailyRecord().dailyWrite(us," ɾ��ͼ�����  ʱ��Ϊ: ");
			}
		});
	 //������������������������������������������������������������������������������������������������������������������������������������������������������
	  //------------------------�޸����ѯ�û���Ϣ--------------------------------------------
	   jm_userinfo3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			 UpdateUser_view a = new UpdateUser_view();
			 a.setVisible(true);
			 desktopPane.add(a);
			 a.toFront();
			 new DailyRecord().dailyWrite(us," ��ѯ���޸��û�����   ʱ��Ϊ: ");
		}
	});
	//--------------------------------------------------------------------------------
	 /***************************��ѯ���޸�ͼ����Ϣ�˵�����*******************************************************/
	   jm_bookmanage3.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
			  UpdateBooks_view a =  new  UpdateBooks_view();
			  a.setVisible(true);
			  desktopPane.add(a);
			  a.toFront();
			  new DailyRecord().dailyWrite(us," ��ѯ���޸�ͼ�����   ʱ��Ϊ: ");
		}
	});
	//-------------����ѡ�����---------------------------------------------------------
	jm_help2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			new FeedBack_view();
			
		}
	});
	//--------------------------------------------------------------------------------
	//------------����ѡ�����-----------------------------------------------------------
	 jm_help1.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent e)
			{
		         new About_view();
		    }
		});
	 //����ͼ��ѡ�����
	 jm_booklend1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			 BorroworBackBooks_view a = new BorroworBackBooks_view();
		     a.setVisible(true);
		     desktopPane.add(a);
		     a.toFront();
		     new DailyRecord().dailyWrite(us," �û�����   ʱ��Ϊ: ");
		
		}
	});
	 //�黹ͼ��ѡ�����
	  jm_booklend2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		 BorroworBackBooks_view a = new BorroworBackBooks_view();
			     a.setVisible(true);
			     desktopPane.add(a);
			     a.toFront();
			     new DailyRecord().dailyWrite(us," �û�����   ʱ��Ϊ: ");
	    	}
	    });
	 
	//-------------------------------------------------------------------------------
	 jm_help3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "�Ѿ������°棡");		
		}
	});
	}
     /***********************����������ʾ***************************************************/
 	//���������ʾ��1.���жϵ�ǰƽ̨�Ƿ�֧��������ʾ
 		public void setTray(String us) {
 			
 			if(SystemTray.isSupported()){//�жϵ�ǰƽ̨�Ƿ�֧�����̹���
 				//��������ʵ��
 				SystemTray tray = SystemTray.getSystemTray();
 				//��������ͼ�꣺1.��ʾͼ��Image 2.ͣ����ʾtext 3.�����˵�popupMenu 4.��������ͼ��ʵ��
 				//1.����Imageͼ��
 				Image image = Toolkit.getDefaultToolkit().getImage("tp/t.png");
 				//2.ͣ����ʾtext
 				String text = "ͼ�����ϵͳ";
 				//3.�����˵�popupMenu
 				PopupMenu popMenu = new PopupMenu();
 				MenuItem itmOpen = new MenuItem("��");
 				itmOpen.addActionListener(new ActionListener(){
 					public void actionPerformed(ActionEvent e) {
 						Show();
 					}				
 				});
 				MenuItem itmHide = new MenuItem("����");
 				itmHide.addActionListener(new ActionListener(){
 					public void actionPerformed(ActionEvent e) {
 						UnVisible();
 					}
 				});
 				MenuItem itmExit = new MenuItem("�˳�");
 				itmExit.addActionListener(new ActionListener(){
 					public void actionPerformed(ActionEvent e) {
 						new DailyRecord().dailyWrite(us, " �˳�ϵͳ ʱ��Ϊ�� ");
 						Exit();
 					}
 				});
 				popMenu.add(itmOpen);
 				popMenu.add(itmHide);
 				popMenu.add(itmExit);
 				
 				//��������ͼ��
 				TrayIcon trayIcon = new TrayIcon(image,text,popMenu);
 				//������ͼ��ӵ�������
 				try {
 					tray.add(trayIcon);
 				} catch (AWTException e1) {
 					e1.printStackTrace();
 				}
 			}
 		}
 		
 		//�ڲ����в���ֱ�ӵ����ⲿ�ࣨthis����ָ��
 		public void UnVisible() {
 			this.setVisible(false);
 		}
 		public void Show() {
 			this.setVisible(true);
 		}
 		public void Exit() {
 			System.exit(0);
 		} 
}

