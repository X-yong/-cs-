package com.xy.view;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitleThread extends JPanel implements Runnable  {
	
	    int x,y =10; 
	    JLabel jb;
		  public void title_label(){
			 setLayout(null);
			
			 jb = new JLabel("本软件有WT团队开发制作，如有疑问敬请咨询  QQ:728165842");
			 jb.setBounds(x, y, 400, 15); 
			 jb.setForeground(Color.WHITE);
			  add(jb);
		  }  	 
	    	
		public void run() {
			while(true)
			{   
				if (x >=this.getWidth())
				{
				 	x = 0;
				}
				x +=1;		
			title_label();	
				try {
					
					this.repaint(); 
					Thread .sleep(80);
					remove(jb);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
				
			}
			
		}
}
