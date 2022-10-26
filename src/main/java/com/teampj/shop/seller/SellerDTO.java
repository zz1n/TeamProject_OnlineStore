package com.teampj.shop.seller;

public class SellerDTO {

	String scode, sellerid, sellerpw, scomname, sprename, sbusnum, scomsalenum, scomaddress, semail, smobile, srgtdate;
	int selleryn;
	
	public SellerDTO() {
		super();
	}
	public SellerDTO(String scode, String sellerid, String sellerpw, String scomname, String sprename, String sbusnum,
			String scomsalenum, String scomaddress, String semail, String smobile, String srgtdate, int selleryn) {
		super();
		this.scode = scode;
		this.sellerid = sellerid;
		this.sellerpw = sellerpw;
		this.scomname = scomname;
		this.sprename = sprename;
		this.sbusnum = sbusnum;
		this.scomsalenum = scomsalenum;
		this.scomaddress = scomaddress;
		this.semail = semail;
		this.smobile = smobile;
		this.srgtdate = srgtdate;
		this.selleryn = selleryn;
	}
	public String getScode() {
		return scode;
	}
	public void setScode(String scode) {
		this.scode = scode;
	}
	public String getSellerid() {
		return sellerid;
	}
	public void setSellerid(String sellerid) {
		this.sellerid = sellerid;
	}
	public String getSellerpw() {
		return sellerpw;
	}
	public void setSellerpw(String sellerpw) {
		this.sellerpw = sellerpw;
	}
	public String getScomname() {
		return scomname;
	}
	public void setScomname(String scomname) {
		this.scomname = scomname;
	}
	public String getSprename() {
		return sprename;
	}
	public void setSprename(String sprename) {
		this.sprename = sprename;
	}
	public String getSbusnum() {
		return sbusnum;
	}
	public void setSbusnum(String sbusnum) {
		this.sbusnum = sbusnum;
	}
	public String getScomsalenum() {
		return scomsalenum;
	}
	public void setScomsalenum(String scomsalenum) {
		this.scomsalenum = scomsalenum;
	}
	public String getScomaddress() {
		return scomaddress;
	}
	public void setScomaddress(String scomaddress) {
		this.scomaddress = scomaddress;
	}
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	public String getSmobile() {
		return smobile;
	}
	public void setSmobile(String smobile) {
		this.smobile = smobile;
	}
	public String getSrgtdate() {
		return srgtdate;
	}
	public void setSrgtdate(String srgtdate) {
		this.srgtdate = srgtdate;
	}
	public int getSelleryn() {
		return selleryn;
	}
	public void setSelleryn(int selleryn) {
		this.selleryn = selleryn;
	}
	
	
}