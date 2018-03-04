package com.cd.da51.use.daoimp;

import org.springframework.stereotype.Repository;

import com.cd.da51.use.dao.LevelDao;
import com.cd.use.model.userLevel;
import com.publics.publick;
@Repository("leveldao")
public class leveldaoimp  extends publick implements LevelDao{

	public int levelInsert(userLevel leve) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.insert("insertUserLevel", leve);
	}

}
