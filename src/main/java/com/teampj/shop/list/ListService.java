package com.teampj.shop.list;

import java.util.ArrayList;

import com.teampj.shop.TotalDTO;

public interface ListService {

	//효진
	ArrayList<TotalDTO> usercheck(String string, int bcode);

	ListDTO usertoseller(String ocode);

	//창용
	ArrayList<ListDTO> mainout();

	ArrayList<ListDTO> rankingout();

	ArrayList<ListDTO> monthout();

	ArrayList<ListDTO> search(String svalue);

	ArrayList<ListDTO> detail(String pcode);

	ArrayList<ListDTO> listcate(String listcate);

	ArrayList<ListDTO> buy(String pcode);

	void buysave(String scode, String pcode, int bb, String omethod);

	ArrayList<ListDTO> brandcate(String brandcate);

	

}