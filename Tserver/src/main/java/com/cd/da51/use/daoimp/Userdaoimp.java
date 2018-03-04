package com.cd.da51.use.daoimp;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cd.da51.use.dao.userDao;
import com.cd.use.model.user;
import com.publics.publick;
@Repository("userdao")
public class Userdaoimp extends publick implements  userDao  {

	public int userInsert(user u) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.insert("insertUsers", u);
	}

	public int deleteUsers(long id) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.delete("dropUsers", id);
	}

	public List<user> queryUser(user u) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("queryUser", u);
	}

	public String queryUserPsw(user u) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("queryUserPsw", u);
	}

}
