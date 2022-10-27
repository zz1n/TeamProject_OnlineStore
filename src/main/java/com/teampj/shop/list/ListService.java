package com.teampj.shop.list;

import java.util.ArrayList;

public interface ListService {

	//효진
	ArrayList<ListDTO> usercheck(String string, int bcode);

	ListDTO usertoseller(String ocode);
	
	ListDTO usereareview(String string, int bnum);

	ArrayList<ListDTO> usertolist(String string, int btype);

	ArrayList<ListDTO> usertoaskout(int bnum);

	ArrayList<ListDTO> orderlist(String string, int stnrd);

	ListDTO orderdetail(String string, String ocode);

	ListDTO userorderchangeget(String string, String ocode);

	//창용
	ArrayList<ListDTO> mainout();

	ArrayList<ListDTO> rankingout();

	ArrayList<ListDTO> monthout();

	ArrayList<ListDTO> search(String svalue);

	ArrayList<ListDTO> detail(String pcode);

	ArrayList<ListDTO> listcate(String listcate);

	ArrayList<ListDTO> buy(String pcode);

	void buysave(String scode, String pcode, int bb, String omethod, int ocharge, String userid);

	ArrayList<ListDTO> brandcate(String brandcate);


	

}