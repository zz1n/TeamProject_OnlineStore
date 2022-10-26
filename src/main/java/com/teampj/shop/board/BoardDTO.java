package com.teampj.shop.board;

public class BoardDTO {

	String bnum, bcode, bname, bcont, pcode, bdate;
	int btype, reproot, repstep, repindent;
	
	public BoardDTO() {
		super();
	}
	public BoardDTO(String bnum, String bcode, String bname, String bcont, String pcode, String bdate, int btype,
			int reproot, int repstep, int repindent) {
		super();
		this.bnum = bnum;
		this.bcode = bcode;
		this.bname = bname;
		this.bcont = bcont;
		this.pcode = pcode;
		this.bdate = bdate;
		this.btype = btype;
		this.reproot = reproot;
		this.repstep = repstep;
		this.repindent = repindent;
	}
	public String getBnum() {
		return bnum;
	}
	public void setBnum(String bnum) {
		this.bnum = bnum;
	}
	public String getBcode() {
		return bcode;
	}
	public void setBcode(String bcode) {
		this.bcode = bcode;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBcont() {
		return bcont;
	}
	public void setBcont(String bcont) {
		this.bcont = bcont;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public int getBtype() {
		return btype;
	}
	public void setBtype(int btype) {
		this.btype = btype;
	}
	public int getReproot() {
		return reproot;
	}
	public void setReproot(int reproot) {
		this.reproot = reproot;
	}
	public int getRepstep() {
		return repstep;
	}
	public void setRepstep(int repstep) {
		this.repstep = repstep;
	}
	public int getRepindent() {
		return repindent;
	}
	public void setRepindent(int repindent) {
		this.repindent = repindent;
	}
	
	
}