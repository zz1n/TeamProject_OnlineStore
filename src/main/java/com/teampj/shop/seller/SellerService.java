package com.teampj.shop.seller;

import java.util.ArrayList;

public interface SellerService {

	//철민
	// 회원가입
	public void sellerin(String sellerid, String sellerpw, String scomname, String sprename, String sbusnum,
			String scomsalenum, String scomaddress, String semail, String smobile, String srgtdate);

	// 아이디중복체크
	public int idCheck(String sellerid);

	// 로그인 체크
	public int loginCheck(String sellerid, String sellerpw);

	// 로그인 성공 scode 발급
	public String logincode(String sellerid);

	public int idCheck();

}