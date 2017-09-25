package com.xy.bussiness.impl;

import java.util.Vector;

import com.xy.bussiness.Book_action;
import com.xy.dao.impl.Book_dao_Impl;
import com.xy.entity.Books;

public class Book_action_Impl implements Book_action{

	/**
	 * 增加图书
	 */
	public boolean addbook(Books addbook) {
		int b = new Book_dao_Impl().insertBookDao(addbook); 
		if(b == 1) return true;
		else  return false; 
	}
    
	/**
	 * 删除图书
	 */
	public boolean deletebook(Books deletebook) {
		int b = new Book_dao_Impl().deleteBookDao(deletebook); 
		if(b == 1) return true;
		else  return false; 
	}
	
	/**
	 * 查询图书
	 */
    public Vector searchbooks(Books selectbooks)
    {
		Vector a = new Book_dao_Impl().selectBooksDao(selectbooks);
    	return a; 	
    }
    
    /**
     * 修改图书
     */
	public boolean updateBooks(Books updatebooks) {
		int b = new Book_dao_Impl().updateBooksDao(updatebooks);
		if (b == 1) return true; 
		else return false;
	}

	/**
	 * 借书
	 */
	public boolean borrowBooks(String n, String b) {
	   boolean c = new Book_dao_Impl().borrowBooksDao(n, b) ;
		if (c) return true;
		else   return false;
	}
	/**
	 * 借书记录查询
	 */
	public Vector selectBorrowBooks(String s)
	    {
			Vector a = new Book_dao_Impl().selectBorrowBooksDao(s);
	    	return a; 	
	    }
	/**
	 * 还书
	 */
	public  boolean returnBooks(String n2,String b2)
	{
		boolean d = new Book_dao_Impl().returnBooksDao(n2, b2);
		if(d) return true;
		else return false;
		
	}
}
