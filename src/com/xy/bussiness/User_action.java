package com.xy.bussiness;

import java.util.Vector;

import com.xy.entity.User;

public interface User_action {
   
	/**
     * 增加用户信息
     * @param adduser
     * @return
     */
	public boolean addUser(User adduser);
     
	/**
	 * 删除用户信息
	 * @param deleteuser
	 * @return
	 */
	public boolean deleteUser(User deleteuser);
  
	/**
	 *查询用户信息
	 * @param user
	 * @return
	 */
	public Vector searchUser(User user);
    /**
     * 修改用户信息
     * @param user
     * @return
     */
	public boolean updateUser(User user); 
	
}
