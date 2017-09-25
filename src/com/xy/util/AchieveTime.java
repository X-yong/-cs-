package com.xy.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.colorchooser.DefaultColorSelectionModel;
import javax.xml.ws.soap.AddressingFeature;
/**
 * 获取系统当前时间
 * @author soonsmile
 *
 */
public class AchieveTime {
	
//	public static void main(String[] args)
//	{
//		String a1=achievetime(); 
//		String a2=achievetimeover(); 
//		//int i = a1.compareTo(a2);
//		//System.err.println(i);
//		System.err.println(descTime(a1,a2));
//	}
	/**
	 * 获取系统当前时间
	 * @return
	 */
   public static String  achieveTime()
   {
	 Date  date = new Date();
	 SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");
	   return sd.format(date);
	   
   }
   /**
    * 设置过期时间
    * @return
    */
   public static String  achieveTimeOver(int j)
   {
	 Date  date = new Date();
	 SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");
	 Calendar cal =  Calendar.getInstance(); 
	 cal.setTime(date);
	 cal.add(Calendar.MONTH,j);//日期加一个月
	
	   return sd.format(cal.getTime());  
   }
   /**
    * 计算是否超时
    * @param a
    * @param b
    * @return
    */
   public static long descTime(String a,String b)
   {
	      long days = -1;
		   SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		  try {
			 days = (sdf.parse(b).getTime()- sdf.parse(a).getTime())/(24*60*60*1000);
		  
		  } catch (ParseException e) {	
			e.printStackTrace();
			return days;
		}
		  return days;
   }
}
