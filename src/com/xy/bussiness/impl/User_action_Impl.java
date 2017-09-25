package com.xy.bussiness.impl;

import java.util.Vector;

import com.xy.bussiness.User_action;
import com.xy.dao.impl.User_dao_Impl;
import com.xy.entity.User;

public class User_action_Impl implements User_action {

	@Override
	public boolean addUser(User adduser) {
		int b5 = new User_dao_Impl().insertuserdao(adduser); 
		if(b5 == 1) return true;
		else  return false; 
	}
	public boolean deleteUser(User deleteuser) {
		int b5 = new User_dao_Impl().deleteuserdao(deleteuser); 
		if(b5 == 1) return true;
		else  return false; 
	}
	public boolean updateUser(User updateuser) {
		int b5 = new User_dao_Impl().updateuserdao(updateuser); 
		if(b5 == 1) return true;
		else  return false; 	 
	}
	public Vector searchUser(User selectuser) {
		Vector a= new User_dao_Impl().selectuserdao(selectuser);
		  return a;
	}
}
