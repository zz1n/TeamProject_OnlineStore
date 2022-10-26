package com.teampj.shop.sellerAjax;

public interface SellerAjaxService {

	//아이디 중복체크
	public int idCheck(String sellerid);
	//회원가입
	public void sellerin(String sellerid, String sellerpw, String scomname, String sprename, String sbusnum,
			String scomsalenum, String scomaddress, String semail, String smobile, String srgtdate);
}
