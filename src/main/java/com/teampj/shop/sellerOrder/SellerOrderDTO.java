package com.teampj.shop.sellerOrder;

public class SellerOrderDTO {

	String scode, ocode, uname, ucode, umobile, pname, oaddress, odate, oshipcomp, oshipcode;
	int ocount, ocharge, ozipcode, ostate;

	public SellerOrderDTO() {
		super();
	}

	public SellerOrderDTO(String scode, String ocode, String uname, String ucode, String umobile, String pname,
			String oaddress, String odate, String oshipcomp, String oshipcode, int ocount, int ocharge, int ozipcode,
			int ostate) {
		super();
		this.scode = scode;
		this.ocode = ocode;
		this.uname = uname;
		this.ucode = ucode;
		this.umobile = umobile;
		this.pname = pname;
		this.oaddress = oaddress;
		this.odate = odate;
		this.oshipcomp = oshipcomp;
		this.oshipcode = oshipcode;
		this.ocount = ocount;
		this.ocharge = ocharge;
		this.ozipcode = ozipcode;
		this.ostate = ostate;
	}

	public String getScode() {
		return scode;
	}

	public void setScode(String scode) {
		this.scode = scode;
	}

	public String getOcode() {
		return ocode;
	}

	public void setOcode(String ocode) {
		this.ocode = ocode;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUcode() {
		return ucode;
	}

	public void setUcode(String ucode) {
		this.ucode = ucode;
	}

	public String getUmobile() {
		return umobile;
	}

	public void setUmobile(String umobile) {
		this.umobile = umobile;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getOaddress() {
		return oaddress;
	}

	public void setOaddress(String oaddress) {
		this.oaddress = oaddress;
	}

	public String getOdate() {
		return odate;
	}

	public void setOdate(String odate) {
		this.odate = odate;
	}

	public String getOshipcomp() {
		return oshipcomp;
	}

	public void setOshipcomp(String oshipcomp) {
		this.oshipcomp = oshipcomp;
	}

	public String getOshipcode() {
		return oshipcode;
	}

	public void setOshipcode(String oshipcode) {
		this.oshipcode = oshipcode;
	}

	public int getOcount() {
		return ocount;
	}

	public void setOcount(int ocount) {
		this.ocount = ocount;
	}

	public int getOcharge() {
		return ocharge;
	}

	public void setOcharge(int ocharge) {
		this.ocharge = ocharge;
	}

	public int getOzipcode() {
		return ozipcode;
	}

	public void setOzipcode(int ozipcode) {
		this.ozipcode = ozipcode;
	}

	public int getOstate() {
		return ostate;
	}

	public void setOstate(int ostate) {
		this.ostate = ostate;
	}


}