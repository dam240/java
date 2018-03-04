package com.cd.da51.app.index;

import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.boot.json.JsonSimpleJsonParser;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cd.da51.admin.interfaces.use.service.userAdminService;
import com.cd.da51.admin.model.admin;
import com.cd.da51.admin.model.userAdmin;
import com.cd.da51.app.cachelist;
import com.cd.use.Dto.userService;
import com.cd.use.model.ReulstType;
import com.cd.use.model.user;
import com.cd.use.tools.resultType;

import modei.Tokens;
import modei.publics;


@RestController

@EnableAutoConfiguration
@ImportResource({ "classpath:*.xml" })
public class index {

	
	/*@Autowired
	private userAdminService userAdminservice;*/
	@Autowired
	private userService userservice;
	
	@RequestMapping("/login_APP")
	public  Tokens login_APP(HttpServletRequest request,HttpServletResponse response) {
		String Token=(String) request.getParameter("Token");
		Tokens ken=null;
		publics ps=new publics();
		if(Token==null||Token.isEmpty()||Token.equals("")) {
			ps.setStatu(ReulstType.FINDER.getStatu());
			ps.setStatu_cond(ReulstType.FINDER.getStatu_cond());
			 ken=new Tokens(null, ps);
			return ken;
		}
		 System.out.println(Token);		
		 JSONObject json= JSON.parseObject(Token);
	     String id=json.getString("l_id");
	     String psw=json.getString("psw");
		if( !this.userservice.exists(null,id)) {
			ps.setStatu(ReulstType.ATIONCFAIL.getStatu());
			ps.setStatu_cond(ReulstType.ATIONCFAIL.getStatu_cond());
		    ken=new Tokens(null, ps);
			return ken;
		}

		if(!this.userservice.normal(id, psw)) {
			ps.setStatu(ReulstType.PS_L_ER.getStatu());
			ps.setStatu_cond(ReulstType.PS_L_ER.getStatu_cond());
			 ken=new Tokens(null, ps);
				return ken;
		}
		 cachelist.cache.put(id, id+"app--520da--22");
		 ps.setStatu(ReulstType.SEUSEE.getStatu());
		 ps.setStatu_cond(ReulstType.SEUSEE.getStatu_cond());
		 ken=new Tokens(cachelist.cache.get(id), ps);
		return ken;
		
	}
	
     @RequestMapping("/reg_APP")	
	 public publics reg_APP(HttpServletRequest request,HttpServletResponse response) {
    	 String Token=(String) request.getParameter("Token");
    	 publics ps=new publics();
 		if(Token==null||Token.isEmpty()||Token.equals("")) {
 			ps.setStatu_cond(ReulstType.FINDER.getStatu_cond());
 			ps.setStatu(ReulstType.FINDER.getStatu());
 			return ps;
 		}
 		 System.out.println(Token);		
 		publics p= JSON.parseObject(Token, publics.class);
 		user u=new user(0, p.getL_id(), p.getName(), p.getPsw(), 'Y', "", "dw/selected_search.png", null, p.getPhone(), new Date().toLocaleString(), "中国", "广西", "防城港", null);
 		if(this.userservice.exists(p.getPhone(), p.getL_id())) {
 			ps.setStatu_cond(ReulstType.EXISTS.getStatu_cond());
 			ps.setStatu(ReulstType.EXISTS.getStatu());
 			return ps;
 		}
 		resultType r=this.userservice.insertUser(u);
 		if(r.getNode()==resultType.Su.getNode()) {
 			ps.setStatu_cond(ReulstType.SEUSEE.getStatu_cond());
 			ps.setStatu(ReulstType.SEUSEE.getStatu());
 			return ps;
 		}
			ps.setStatu_cond(ReulstType.ERR.getStatu_cond());
			ps.setStatu(ReulstType.ERR.getStatu());
		 return ps;
	 }
	
     
     @RequestMapping("/index")
     public Tokens index(HttpServletRequest request,HttpServletResponse response) {
    	 String Token=(String) request.getParameter("Token");
    	  JSONObject json   =JSON.parseObject(Token);
    	  String token=json.getString("token");
    	    String l_id =json.getString("l_id");
    	  Tokens result=null;
    	  publics ps=new publics();
          if(token==null||token.isEmpty()) {
        	  ps.setStatu(ReulstType.RE_LOGIN.getStatu());
        	  ps.setStatu_cond(ReulstType.RE_LOGIN.getStatu_cond());
        	  result=new Tokens(null, ps);
        	  return result;
          }
          String tok  =cachelist.cache.get(l_id);
          if(l_id.isEmpty()||!l_id.equals(tok)) {
        	  ps.setStatu(ReulstType.FINDER.getStatu());
        	  ps.setStatu_cond(ReulstType.FINDER.getStatu_cond());
        	  result=new Tokens(null, ps);
        	  return result;
          }
         
          cachelist.cache.remove(l_id);
          cachelist.cache.put(l_id, l_id+"---000"+new Date().getHours()+"--"+new Date().getSeconds()+"-00-"+new Date().getDay());
          String To=cachelist.cache.get(l_id);
          ps.setStatu(ReulstType.SEUSEE.getStatu());
    	  ps.setStatu_cond(ReulstType.SEUSEE.getStatu_cond());
    	  result=new Tokens(To, ps);
    	 return result;
     }
     
	 @RequestMapping("/")
	    String home() {
	        return "Hello Word!";
	    }


	
}