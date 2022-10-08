package com.teampj.shop.board;

import java.util.ArrayList;

import com.teampj.shop.TotalDTO;

public interface BoardService {

	//효진
	TotalDTO usereareview(String string, int bnum);
	
	int userreviewsave(String ocode, String bname, String bcont);

	ArrayList<TotalDTO> userreviewlist(String string, int btype);

	int userboarddel(String string, int bnum);

	//didn't use, i guess
//	BoardDTO userreviewupdateget(String string, int bnum);

	int userreviewupdateset(String string, String bnum, String bname, String bcont);

	int usertosellersave(String string, String bname, String bcont, String pcode);

	ArrayList<TotalDTO> usertolist(String string, int btype);

	ArrayList<TotalDTO> usertosellerout(int bnum);

	int usertositesave(String string, String bname, String bcont);
	
	//창용
	ArrayList<BoardDTO> review(String pcode);

	ArrayList<BoardDTO> inquiry(String pcode);
	
	ArrayList<BoardDTO> selectnotice(PageDTO pto); //�럹�씠吏� 泥섎━ 寃뚯떆湲� 議고쉶
	
	int cntnotice();
	
	//민섭
	
	public void preply(String bname, String bcont);
}