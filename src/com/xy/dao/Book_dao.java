package com.xy.dao;

import java.awt.print.Book;
import java.util.Vector;

import com.xy.entity.Books;

public interface Book_dao {
  
	/**
	 *�����ݿ������ͼ������
	 * @param addbook
	 * @return
	 */
    public int insertBookDao(Books addbook);

    /**
     * �����ݿ�ɾ��ͼ������
     * @param deletebook
     * @return
     */
    public int deleteBookDao(Books deletebook);
   /**
    * �����ݿ��ѯͼ������
    * @param selectbooks
    * @return
    */
    public Vector selectBooksDao(Books selectbooks);
    /**
     * �����ݿ�ɾ��ͼ������
     * @param updatebooks
     * @return
     */
    public int updateBooksDao(Books updatebooks);
    /**
     * �����ݿ���ӽ����¼��������һ
     * @param n
     * @param b
     * @return
     */
    public boolean borrowBooksDao(String n, String b);
   /**
    * �����ݿ��ѯ�����¼
    * @param selectbooks
    * @return
    */
    public Vector selectBorrowBooksDao(String s);
    /**
     * ���鲢ɾ�������¼
     * @param n2
     * @param b2
     * @return
     */
    public boolean returnBooksDao(String n2, String b2);
}
