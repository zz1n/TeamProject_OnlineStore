package com.teampj.shop.list;

public class ListDTO {

	String pcode, scode, pname;
	int price, cost, pcount, pshipday, pshipcost, preshipcost, pspshipcost;
	String pthumbnail, pdscrpt, pmaincate, psubcate, ptag, prgtdate;
	
	public ListDTO() {
		super();
	}
	public ListDTO(String pcode, String scode, String pname, int price, int cost, int pcount, int pshipday,
			int pshipcost, int preshipcost, int pspshipcost, String pthumbnail, String pdscrpt, String pmaincate,
			String psubcate, String ptag, String prgtdate) {
		super();
		this.pcode = pcode;
		this.scode = scode;
		this.pname = pname;
		this.price = price;
		this.cost = cost;
		this.pcount = pcount;
		this.pshipday = pshipday;
		this.pshipcost = pshipcost;
		this.preshipcost = preshipcost;
		this.pspshipcost = pspshipcost;
		this.pthumbnail = pthumbnail;
		this.pdscrpt = pdscrpt;
		this.pmaincate = pmaincate;
		this.psubcate = psubcate;
		this.ptag = ptag;
		this.prgtdate = prgtdate;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getScode() {
		return scode;
	}
	public void setScode(String scode) {
		this.scode = scode;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getPcount() {
		return pcount;
	}
	public void setPcount(int pcount) {
		this.pcount = pcount;
	}
	public int getPshipday() {
		return pshipday;
	}
	public void setPshipday(int pshipday) {
		this.pshipday = pshipday;
	}
	public int getPshipcost() {
		return pshipcost;
	}
	public void setPshipcost(int pshipcost) {
		this.pshipcost = pshipcost;
	}
	public int getPreshipcost() {
		return preshipcost;
	}
	public void setPreshipcost(int preshipcost) {
		this.preshipcost = preshipcost;
	}
	public int getPspshipcost() {
		return pspshipcost;
	}
	public void setPspshipcost(int pspshipcost) {
		this.pspshipcost = pspshipcost;
	}
	public String getPthumbnail() {
		return pthumbnail;
	}
	public void setPthumbnail(String pthumbnail) {
		this.pthumbnail = pthumbnail;
	}
	public String getPdscrpt() {
		return pdscrpt;
	}
	public void setPdscrpt(String pdscrpt) {
		this.pdscrpt = pdscrpt;
	}
	public String getPmaincate() {
		return pmaincate;
	}
	public void setPmaincate(String pmaincate) {
		this.pmaincate = pmaincate;
	}
	public String getPsubcate() {
		return psubcate;
	}
	public void setPsubcate(String psubcate) {
		this.psubcate = psubcate;
	}
	public String getPtag() {
		return ptag;
	}
	public void setPtag(String ptag) {
		this.ptag = ptag;
	}
	public String getPrgtdate() {
		return prgtdate;
	}
	public void setPrgtdate(String prgtdate) {
		this.prgtdate = prgtdate;
	}
	
	
}