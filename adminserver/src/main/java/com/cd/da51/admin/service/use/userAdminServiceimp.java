package com.cd.da51.admin.service.use;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cd.da51.admin.dao.interfaces.userAdminDao;
import com.cd.da51.admin.interfaces.use.service.userAdminService;
import com.cd.da51.admin.model.admin;
import com.cd.da51.admin.model.userAdmin;
import com.cd.use.model.ReulstType;

@Service("userAdminservice")
public class userAdminServiceimp implements userAdminService {

	private static Log log = LogFactory.getLog(userAdminServiceimp.class);	
	@Autowired
	private  userAdminDao userAdmindao;

	
	public ReulstType InsertUserAdmin(userAdmin arg0, admin arg1) {
		// TODO Auto-generated method stub
		log.info("InsertUserAdmin--->inter");
		System.out.println("InsertUserAdmin--->inter");
		if(arg0==null)
			return ReulstType.ATIONCFAIL;
		
	     try {
			long id=this.userAdmindao.insertUserAdmin(arg0);
			arg1.setId(id);
			if(this.userAdmindao.insertAdmin(arg1)==0)
				return ReulstType.ATIONCFAIL; 
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("InsertUserAdmin--->err",e);
			return ReulstType.ATIONCFAIL;
			
		}
		return ReulstType.INTERT;
	}

}
