package com.teampj.shop.profit;

import java.util.ArrayList;

public interface ProfitService {
	
	//
	public ArrayList<ProfitDTO> testout();
	//일 매출조회(day profit serch)
	public ArrayList<ProfitDTO> dayprofitcall(String scode,  String begindate, String enddate);
	//월 매출조회(month profit serch)
	public ArrayList<ProfitDTO> monthprofitcall(String scode,  String begindate, String enddate);
	//상품 매출조회(pname profit serch)
	public ArrayList<ProfitDTO> pnameprofitcall(String scode, String pcode, String begindate, String enddate);
	
}