package com.xy.bussiness.impl;

import java.util.Vector;

import com.xy.bussiness.Admin_action;
import com.xy.dao.impl.Admin_dao_Impl;
import com.xy.entity.Admin;

public class Admin_action_Impl implements  Admin_action{

	@Override
	public boolean check(Admin identify) {
   	 Admin s5 = new Admin_dao_Impl().nameAndKey(identify);
   	 if(s5 ==null)
   	 {
   		 return false;
   	 } else return true;	
	}

	@Override
	public boolean enroll(Admin identify) {
		int a2 = new Admin_dao_Impl().insertEnroll(identify);
    	if (a2==0){
    	return false;
    	}else{
    	  return true;}
	}

	@Override
	public Vector update() {
		Vector v1 = new Admin_dao_Impl().updateAdmin(); 
		return v1;
	}

	@Override
	public boolean delete(Admin root) {
		int a = new Admin_dao_Impl().deleteAdmin(root);
		if( a== 1)			
		return true;
		else return false;
	}

}
