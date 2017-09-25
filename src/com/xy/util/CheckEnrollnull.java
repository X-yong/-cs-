package com.xy.util;
import javax.swing.plaf.synth.SynthStyle;

import com.xy.entity.Admin;

public class CheckEnrollnull {
	public boolean checkenrollnull(Admin identify)
	{
	   String c1 = identify.getEname();
	   String c2 = identify.getKey();
	   String c3 =identify.getSurekey();
	   String c4 = identify.getSex();
	   String c5 =identify.getId();
	   String c6 = identify.getPhonenumber();

	    if("".equals(c1) || c1 == null) {System.err.println("1");return false;}
	    else if("".equals(c2) || c2 ==null) {System.err.println("2");return false;}
	    else if(!c2.equals(c3))             {System.err.println("2=3");return false;}
	    else if("".equals(c3) || c3 ==null) {System.err.println("3"); return false;}
	    else if("".equals(c4) || c4 ==null) {System.err.println("4"); return false;}
	    else if("".equals(c5) || c5 ==null) {System.err.println("5");return false;}
	    else if("".equals(c6) || c6 ==null) {System.err.println("6");return false;}
	    else return true;  
	}
}
