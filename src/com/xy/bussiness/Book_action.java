package com.xy.bussiness;

import java.util.Vector;

import com.xy.entity.Books;

public interface Book_action {
    /**
     * ���ͼ��
     * @param addbook
     * @return
     */
	 public boolean addbook(Books addbook);
  
	 /**
	  * ɾ��ͼ��
	  * @param deletebook
	  * @return
	  */
	 public boolean deletebook(Books deletebook);
    /**
     * ����ͼ��
     * @param selectbooks
     * @return
     */
	 public Vector searchbooks(Books selectbooks);
	 /**
	  * �޸�ͼ��
	  * @param updatebooks
	  * @return
	  */
	 public boolean updateBooks(Books updatebooks);
	 /**
	  * ����
	  * @param n ������
	  * @param b ���ĵ�ͼ��
	  * @return
	  */
	 public boolean borrowBooks(String n ,String b);
	/**
	 * �����¼��ѯ
	 * @param s
	 * @return
	 */
	 public Vector selectBorrowBooks(String s);
	 
	 /**
	  * ����
	  * @param n2
	  * @param b2
	  * @return
	  */
	 public  boolean returnBooks(String n2,String b2);
}
