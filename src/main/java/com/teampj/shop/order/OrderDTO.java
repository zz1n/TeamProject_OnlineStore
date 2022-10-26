package com.teampj.shop.order;

public class OrderDTO {

	String ocode, ucode, scode, pcode;
	int ocount;
	String oaddress;
	int ozipcode;
	String omemo, omethod, odate;
	int ostate;
	String oshipcode;
	int oshipstate, ocharge;
	String oshipcomp;
	
	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OrderDTO(String ocode, String ucode, String scode, String pcode, int ocount, String oaddress, int ozipcode,
			String omemo, String omethod, String odate, int ostate, String oshipcode, int oshipstate, int ocharge,
			String oshipcomp) {
		super();
		this.ocode = ocode;
		this.ucode = ucode;
		this.scode = scode;
		this.pcode = pcode;
		this.ocount = ocount;
		this.oaddress = oaddress;
		this.ozipcode = ozipcode;
		this.omemo = omemo;
		this.omethod = omethod;
		this.odate = odate;
		this.ostate = ostate;
		this.oshipcode = oshipcode;
		this.oshipstate = oshipstate;
		this.ocharge = ocharge;
		this.oshipcomp = oshipcomp;
	}
	
	public String getOcode() {
		return ocode;
	}
	public void setOcode(String ocode) {
		this.ocode = ocode;
	}
	public String getUcode() {
		return ucode;
	}
	public void setUcode(String ucode) {
		this.ucode = ucode;
	}
	public String getScode() {
		return scode;
	}
	public void setScode(String scode) {
		this.scode = scode;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public int getOcount() {
		return ocount;
	}
	public void setOcount(int ocount) {
		this.ocount = ocount;
	}
	public String getOaddress() {
		return oaddress;
	}
	public void setOaddress(String oaddress) {
		this.oaddress = oaddress;
	}
	public int getOzipcode() {
		return ozipcode;
	}
	public void setOzipcode(int ozipcode) {
		this.ozipcode = ozipcode;
	}
	public String getOmemo() {
		return omemo;
	}
	public void setOmemo(String omemo) {
		this.omemo = omemo;
	}
	public String getOmethod() {
		return omethod;
	}
	public void setOmethod(String omethod) {
		this.omethod = omethod;
	}
	public String getOdate() {
		return odate;
	}
	public void setOdate(String odate) {
		this.odate = odate;
	}
	public int getOstate() {
		return ostate;
	}
	public void setOstate(int ostate) {
		this.ostate = ostate;
	}
	public String getOshipcode() {
		return oshipcode;
	}
	public void setOshipcode(String oshipcode) {
		this.oshipcode = oshipcode;
	}
	public int getOshipstate() {
		return oshipstate;
	}
	public void setOshipstate(int oshipstate) {
		this.oshipstate = oshipstate;
	}
	public int getOcharge() {
		return ocharge;
	}
	public void setOcharge(int ocharge) {
		this.ocharge = ocharge;
	}
	public String getOshipcomp() {
		return oshipcomp;
	}
	public void setOshipcomp(String oshipcomp) {
		this.oshipcomp = oshipcomp;
	}
	
	
}