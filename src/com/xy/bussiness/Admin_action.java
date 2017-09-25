package com.xy.bussiness;

import java.util.Vector;

import com.xy.entity.Admin;

public interface Admin_action {
	 /**
	  * 校验密码
	  * @param identify
	  * @return
	  */
	public boolean check(Admin identify);
	
	/**
	 * 管理员注册
	 * @param identify
	 * @return
	 */
	public boolean enroll(Admin identify);
	/**
	 * 管理员查询
	 * @param update
	 * @return
	 */
	public Vector update(); 
	/**
	 * 管理员删除
	 * @return
	 */
	public boolean delete(Admin root);
	
}
