package com.xy.util;

import javax.swing.JOptionPane;

import com.xy.entity.Admin;

public class CheckNull {
    public boolean checknull(Admin identify)
    {   
    	String s7 = identify.getEname();
    	String s8 = identify.getKey();
    	if(s7.equals("")||s7==null)
    	{
    		JOptionPane.showMessageDialog(null, "��������û��������Ϲ淶���������룡");
    		return true;
    	}else if(s8.equals("")||s8==null)
    	{
    		JOptionPane.showMessageDialog(null, "����������벻���Ϲ淶���������룡");
    		return true;
    	}
    	return false;
    }
}
