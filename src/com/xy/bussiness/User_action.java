package com.xy.bussiness;

import java.util.Vector;

import com.xy.entity.User;

public interface User_action {
   
	/**
     * �����û���Ϣ
     * @param adduser
     * @return
     */
	public boolean addUser(User adduser);
     
	/**
	 * ɾ���û���Ϣ
	 * @param deleteuser
	 * @return
	 */
	public boolean deleteUser(User deleteuser);
  
	/**
	 *��ѯ�û���Ϣ
	 * @param user
	 * @return
	 */
	public Vector searchUser(User user);
    /**
     * �޸��û���Ϣ
     * @param user
     * @return
     */
	public boolean updateUser(User user); 
	
}
