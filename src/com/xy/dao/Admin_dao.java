package com.xy.dao;

import java.util.Vector;

import com.xy.entity.Admin;

public interface Admin_dao {
    /**
     * 连接数据库校验用户名和密码
     * @param identify
     * @return
     */
	public Admin nameAndKey(Admin identify);

    /**
     * 向数据库插入新用户数据
     * @param identify
     * @return
     */
	public int insertEnroll(Admin identify);
    /**
     * 向数据库查询管理员数据
     * @param update
     * @return
     */
	public Vector updateAdmin();
   /**
    * 向数据库删除管理员数据
    * @return
    */
	public int deleteAdmin(Admin root);
}
