package com.xy.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Vector;

public class DailyRecord {

//	public static void main(String[] args) {
//		dailyWrite("2425252","afffsfa");
//		Vector v2 = dailyReader();
//		for(int i= 0; i <v2.size(); i++)
//         System.out.println(v2.get(i));    
//	}
	//写入系统日志
	public  static void  dailyWrite(String s, String s2)
	{
		File file = new File("dailyrecord/record.abc");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
		     bw.write(s+ " " +s2 +"  "+ new Date().toLocaleString());
		     bw.newLine();
 	         bw.flush();
 	         bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//读出系统日志
	public static  Vector  dailyReader()
	{
		String c = null ;
		Vector v = new Vector(); 
		File file = new File("dailyrecord/record.abc");
		try {
		  BufferedReader br = new  BufferedReader(new FileReader(file));
		  
		  while((c =br.readLine()) != null)
		  { 
			 v.add(c);
		  }
		     br.close();
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		return v;
	}

}
