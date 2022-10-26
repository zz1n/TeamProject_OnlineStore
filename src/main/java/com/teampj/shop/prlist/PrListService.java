package com.teampj.shop.prlist;

import java.util.ArrayList;

public interface PrListService {

	public void listinsert(String pname, int price, int cost, int pcount, String pshipday, int pshipcost,
			int preshipcost, int pspshipcost, String pthumbnail, String pmaincate, String psubcate, String pdscrpt,
			String ptag, String scode);

	public ArrayList<PrListDTO> simplegoodslist(String scode);

	public void delete(String pcode);

	public ArrayList<PrListDTO> update(String pcode);

	public void update2(String pname, int price, int cost, int pcount, String pshipday, int pshipcost, int preshipcost,
			int pspshipcost, String pthumbnail, String pmaincate, String psubcate, String pdscrpt, String ptag, String pcode);

	

}