package com.xy.dao;

import java.util.Vector;

import com.xy.entity.User;

public interface User_dao {
    /**
     * �����ݿ�������û�����
     * @param adduser
     * @return
     */
	public int insertuserdao(User adduser);
    /**
     * �����ݿ�ɾ�����û�����
     * @param deleteuser
     * @return
     */
    public int deleteuserdao(User deleteuser);
   /**
    * �����ݿ��ѯ�û�����
    * @param user
    * @return
    */
    public Vector selectuserdao(User selectuser);
    /**
     * �����ݿ��޸��û�����
     * @param user
     * @return
     */
    public int updateuserdao(User updateuser);
   
   
}
