package com.xy.view;

import java.awt.BorderLayout;
import java.util.Date;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TimeThread extends JPanel implements Runnable {
    
	JLabel jl = new JLabel("");
	public TimeThread()
	{ 
		this.setLayout(new BorderLayout());
		add(jl,BorderLayout.CENTER);
	}
	public void run() {
		while(true)
		{	
			try {
			    jl.setText("��ǰʱ��"+new Date().toLocaleString()); 
				Thread.sleep(1000);//1000����
			} catch (InterruptedException e) {
			e.printStackTrace();
			}
		}	
		
	}

}
