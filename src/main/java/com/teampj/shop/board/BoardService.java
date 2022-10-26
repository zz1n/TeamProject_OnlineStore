package com.teampj.shop.board;

import java.util.ArrayList;


public interface BoardService {

	//효진
BoardDTO usereareview(String string, int bnum);
	
	int userreviewsave(String ocode, String bname, String bcont, String string);

	ArrayList<BoardDTO> userreviewlist(String string, int btype);

	int userboarddel(String string, int bnum);

	BoardDTO userreviewupdateget(String string, int bnum);

	int userreviewupdateset(String string, String bnum, String bname, String bcont);

	int usertosellersave(String string, String bname, String bcont, String pcode);

	ArrayList<BoardDTO> usertolist(String string, int btype);

	ArrayList<BoardDTO> usertosellerout(int bnum);

	int usertositesave(String string, String bname, String bcont);
	
	//창용
	ArrayList<BoardDTO> review(String pcode);

	ArrayList<BoardDTO> inquiry(String pcode);
	
	ArrayList<BoardDTO> selectnotice(PageDTO pto); //�럹�씠吏� 泥섎━ 寃뚯떆湲� 議고쉶
	
	int cntnotice();
	ArrayList<BoardDTO> preply(String scode);

	public void answercomplete(String bnum, String pcode, String bname, String bcont, String scode);
}