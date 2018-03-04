package com.cd.da51.admin.dao.interfaces;

import com.cd.da51.admin.model.admin;
import com.cd.da51.admin.model.userAdmin;

public interface userAdminDao {

	public long insertAdmin(admin a)throws Exception;
	
	public int insertUserAdmin(userAdmin use)throws Exception;
	
}
