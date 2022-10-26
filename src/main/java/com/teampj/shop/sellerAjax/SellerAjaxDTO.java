package com.teampj.shop.sellerAjax;

public class SellerAjaxDTO {
	String sellerid,sellerpw;

	public SellerAjaxDTO() {
		super();}

	public SellerAjaxDTO(String sellerid, String sellerpw) {
		super();
		this.sellerid = sellerid;
		this.sellerpw = sellerpw;
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
	
	
}
