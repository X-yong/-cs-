package com.xy.entity;

public class User {
     private  String uname;
     private  String usex;
     private  String usid;
     private  String uphone;
     private  String unumber;
     private  String enrolltime;
     private  String canceltime;
     
     public String getEnrolltime() {
		return enrolltime;
	}
	public void setEnrolltime(String enrolltime) {
		this.enrolltime = enrolltime;
	}
	public String getCanceltime() {
		return canceltime;
	}
	public void setCanceltime(String canceltime) {
		this.canceltime = canceltime;
	}
	private  String credit;
     
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getUnumber() {
		return unumber;
	}
	public void setUnumber(String unumber) {
		this.unumber = unumber;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public String getUsid() {
		return usid;
	}
	public void setUsid(String usid) {
		this.usid = usid;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
 }
