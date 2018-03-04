package modei;

public class publics {

    private String l_id;
    private String name;
    private String psw;
    private long id;
    private char xing;
    private int statu_cond;
	private String statu;
  public int getStatu_cond() {
		return statu_cond;
	}


	public void setStatu_cond(int statu_cond) {
		this.statu_cond = statu_cond;
	}


	public String getStatu() {
		return statu;
	}


	public void setStatu(String statu) {
		this.statu = statu;
	}


public publics() {
	// TODO Auto-generated constructor stub
}

  
    public publics(String l_id, String name, String psw, long id, char xing, String card, String drawable, String lateLogin,
		String phone) {
	super();
	this.l_id = l_id;
	this.name = name;
	this.psw = psw;
	this.id = id;
	this.xing = xing;
	this.card = card;
	this.drawable = drawable;
	this.lateLogin = lateLogin;
	this.phone = phone;
}


	public String getL_id() {
		return l_id;
	}
	public void setL_id(String l_id) {
		this.l_id = l_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public char getXing() {
		return xing;
	}
	public void setXing(char xing) {
		this.xing = xing;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getDrawable() {
		return drawable;
	}
	public void setDrawable(String drawable) {
		this.drawable = drawable;
	}
	public String getLateLogin() {
		return lateLogin;
	}
	public void setLateLogin(String lateLogin) {
		this.lateLogin = lateLogin;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	private String card;
    private String drawable;
    private String lateLogin;
    private String phone;
}
