package com.xy.dao;

import java.awt.print.Book;
import java.util.Vector;

import com.xy.entity.Books;

public interface Book_dao {
  
	/**
	 *向数据库插入新图书数据
	 * @param addbook
	 * @return
	 */
    public int insertBookDao(Books addbook);

    /**
     * 向数据库删除图书数据
     * @param deletebook
     * @return
     */
    public int deleteBookDao(Books deletebook);
   /**
    * 向数据库查询图书数据
    * @param selectbooks
    * @return
    */
    public Vector selectBooksDao(Books selectbooks);
    /**
     * 向数据库删除图书数据
     * @param updatebooks
     * @return
     */
    public int updateBooksDao(Books updatebooks);
    /**
     * 向数据库添加借书记录并将库存减一
     * @param n
     * @param b
     * @return
     */
    public boolean borrowBooksDao(String n, String b);
   /**
    * 向数据库查询借书记录
    * @param selectbooks
    * @return
    */
    public Vector selectBorrowBooksDao(String s);
    /**
     * 还书并删除借书记录
     * @param n2
     * @param b2
     * @return
     */
    public boolean returnBooksDao(String n2, String b2);
}
