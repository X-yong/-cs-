package com.xy.dao;

import java.util.Vector;

import com.xy.entity.User;

public interface User_dao {
    /**
     * 向数据库添加新用户数据
     * @param adduser
     * @return
     */
	public int insertuserdao(User adduser);
    /**
     * 向数据库删除新用户数据
     * @param deleteuser
     * @return
     */
    public int deleteuserdao(User deleteuser);
   /**
    * 向数据库查询用户数据
    * @param user
    * @return
    */
    public Vector selectuserdao(User selectuser);
    /**
     * 向数据库修改用户数据
     * @param user
     * @return
     */
    public int updateuserdao(User updateuser);
   
   
}
