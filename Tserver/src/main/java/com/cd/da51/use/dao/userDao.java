package com.cd.da51.use.dao;

import java.util.List;

import com.cd.use.model.user;

public interface userDao {

	public int userInsert(user u);
	
	public int deleteUsers(long id);
	
	public List<user> queryUser(user u);
	
	public String queryUserPsw(user u);
	
}
