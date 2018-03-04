package com.cd.da51.admin.dao.imp;

import org.springframework.stereotype.Repository;

import com.cd.da51.admin.dao.interfaces.userAdminDao;
import com.cd.da51.admin.model.admin;
import com.cd.da51.admin.model.userAdmin;
import com.cd.da51.publics.comms;
@Repository("userAdmindao")
public class userAdmindaoImp extends comms implements userAdminDao{


	public long insertAdmin(admin a) throws Exception {
		// TODO Auto-generated method stub
		 return this.sqlSessionTemplate.insert("insertAdmin", a);
	}

	public int insertUserAdmin(userAdmin use) throws Exception {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.insert("insertUserAdmin", use);
	}
	




}
