package com.teampj.shop.seller;

import java.util.ArrayList;

public interface SellerService {

	//嶺뚳퐣伊볟뜝�룞�삕

	// �슖�돦裕꾬옙�쟽�뜝�럩逾� 嶺뚳퐢�샑野껓옙
	public int loginCheck(String sellerid, String sellerpw);

	// �슖�돦裕꾬옙�쟽�뜝�럩逾� �뜝�럡�뎽占썩뫅�삕 scode �뛾�룇裕꾬옙�땵
	public String logincode(String sellerid);

	//창용
	public String login(String sellerid, String sellerpw);
	//셀러 정보조회
	public SellerDTO sellerup(String scode);
	//셀러 정보저장
	public void sellerupsave(String scode, String sellerid, String sellerpw, String scomname, String sprename,
			String sbusnum, String scomsalenum, String scomaddress, String semail, String smobile);


}