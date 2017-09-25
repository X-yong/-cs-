package com.xy.entity;

public class Books {
     private String  bname ;
     private String  bauthor;
     private String  bissue;
     private String  bnumber;
     private int     bprice;
     private String  bisbn;
     private int     bstock;
     private String  addtime;
     public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	private Object  order;
     
	public Object getOrder() {
		return order;
	}
	public void setOrder(Object order) {
		this.order = order;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBauthor() {
		return bauthor;
	}
	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	public String getBissue() {
		return bissue;
	}
	public void setBissue(String bissue) {
		this.bissue = bissue;
	}
	public String getBnumber() {
		return bnumber;
	}
	public void setBnumber(String bnumber) {
		this.bnumber = bnumber;
	}
	public int getBprice() {
		return bprice;
	}
	public void setBprice(int bprice) {
		this.bprice = bprice;
	}
	public String getBisbn() {
		return bisbn;
	}
	public void setBisbn(String bisbn) {
		this.bisbn = bisbn;
	}
	public int getBstock() {
		return bstock;
	}
	public void setBstock(int bstock) {
		this.bstock = bstock;
	} 
     
}

