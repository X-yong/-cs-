package com.xy.dao;

import java.util.Vector;

import com.xy.entity.Admin;

public interface Admin_dao {
    /**
     * �������ݿ�У���û���������
     * @param identify
     * @return
     */
	public Admin nameAndKey(Admin identify);

    /**
     * �����ݿ�������û�����
     * @param identify
     * @return
     */
	public int insertEnroll(Admin identify);
    /**
     * �����ݿ��ѯ����Ա����
     * @param update
     * @return
     */
	public Vector updateAdmin();
   /**
    * �����ݿ�ɾ������Ա����
    * @return
    */
	public int deleteAdmin(Admin root);
}
