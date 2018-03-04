package com.cd.use.model;

public enum ReulstType {

	ERR(500,"内部异常"),
	FINDER(404,"找不"),
	INTERT(001,"储藏成功"),
	DELE(002,"删除成功"),
	ATIONC(111,"ATIONC成功"),
	ATIONCFAIL(222,"ATIONCfail"),
	SEUSEE(000,"成功"),
	EXISTS(999,"手机号码已在或账号"),
	PS_L_ER(555,"密码或账号不正确"),
	RE_LOGIN(555,"请登录");
	private int statu_cond;
	private String statu;
	private ReulstType(int statu_cond, String statu) {
		this.statu_cond = statu_cond;
		this.statu = statu;
	}
	public int getStatu_cond() {
		return statu_cond;
	}
	public String getStatu() {
		return statu;
	}
	
	
	
	
}
