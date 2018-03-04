package com.cd.da51.use.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cd.da51.use.dao.LevelDao;
import com.cd.da51.use.dao.userDao;
import com.cd.use.Dto.userService;
import com.cd.use.model.user;
import com.cd.use.model.userLevel;
import com.cd.use.tools.resultType;

public class userServiceimp implements userService{

	@Autowired
	private userDao userdao;
	@Autowired
	private LevelDao leveldao;
	
	public resultType insertUser(user u) {
		// TODO Auto-generated method stub
		System.out.println("----------");
		int id= this.userdao.userInsert(u);
		userLevel leve=new userLevel(0, u.getId(), 0, "新用户");
		if(this.leveldao.levelInsert(leve)==1) {
			System.out.println("----------");
			return resultType.Su;
		}
		this.userdao.deleteUsers(u.getId());
		return resultType.ER;
	}

	public boolean exists(String phone, String login_id) {
		// TODO Auto-generated method stub
	 List<user>list	=this.userdao.queryUser(new user(0, login_id, null, null, '0', null, null, null
				, phone, null, null, null, null, null));
	if(list.size()>0)	
		return true;
	return false;
	
	}

	public boolean normal(String login_id,String psw) {
		// TODO Auto-generated method stub
		user u=new user();
		u.setLogin_id(login_id);
		String pasw=this.userdao.queryUserPsw(u);
		if(!pasw.equals(psw))
		  return false;
		return true ;
	}

	
	
	
}
