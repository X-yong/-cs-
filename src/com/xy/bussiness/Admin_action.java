package com.xy.bussiness;

import java.util.Vector;

import com.xy.entity.Admin;

public interface Admin_action {
	 /**
	  * У������
	  * @param identify
	  * @return
	  */
	public boolean check(Admin identify);
	
	/**
	 * ����Աע��
	 * @param identify
	 * @return
	 */
	public boolean enroll(Admin identify);
	/**
	 * ����Ա��ѯ
	 * @param update
	 * @return
	 */
	public Vector update(); 
	/**
	 * ����Աɾ��
	 * @return
	 */
	public boolean delete(Admin root);
	
}
