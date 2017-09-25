package com.xy.bussiness;

import java.util.Vector;

import com.xy.entity.Books;

public interface Book_action {
    /**
     * 添加图书
     * @param addbook
     * @return
     */
	 public boolean addbook(Books addbook);
  
	 /**
	  * 删除图书
	  * @param deletebook
	  * @return
	  */
	 public boolean deletebook(Books deletebook);
    /**
     * 查找图书
     * @param selectbooks
     * @return
     */
	 public Vector searchbooks(Books selectbooks);
	 /**
	  * 修改图书
	  * @param updatebooks
	  * @return
	  */
	 public boolean updateBooks(Books updatebooks);
	 /**
	  * 借书
	  * @param n 借阅者
	  * @param b 借阅的图书
	  * @return
	  */
	 public boolean borrowBooks(String n ,String b);
	/**
	 * 借书记录查询
	 * @param s
	 * @return
	 */
	 public Vector selectBorrowBooks(String s);
	 
	 /**
	  * 还书
	  * @param n2
	  * @param b2
	  * @return
	  */
	 public  boolean returnBooks(String n2,String b2);
}
