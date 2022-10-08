package com.teampj.shop.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.teampj.shop.TotalDTO;
import com.teampj.shop.list.ListDTO;
import com.teampj.shop.list.ListService;

@Controller
@RequestMapping(value = "/board/**")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private SqlSession sqlSession;

	ModelAndView mav = new ModelAndView();
	JSONParser jp = new JSONParser();
	JSONObject jo;

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView main(Model model) {
		mav.setViewName("boardmain");
		return mav;
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView mainhome(Model model) {
		mav.setView(new RedirectView("/shop"));	//다른 컨트롤러로 viewname
		return mav;
	}

	// �옉�꽦�븳 由щ럭 蹂닿린
	@RequestMapping(value = "/reviewout", method = RequestMethod.GET) // �꽭�뀡�옉�뾽 �븘�슂
	public ModelAndView reviewout(Model model, HttpServletRequest request) {
		// �꽭�뀡�뿉�꽌 �븘�씠�뵒 媛��졇�삤�뒗嫄몃줈 �닔�젙�븯湲�
		BoardService ser = sqlSession.getMapper(BoardService.class);

		int bnum = Integer.parseInt(request.getParameter("bnum"));
		System.out.println("紐뉖쾲由щ럭?" + bnum);
		TotalDTO dto = ser.usereareview("user001", bnum);

		mav.addObject("dto", dto);
		mav.setViewName("userreviewout");
		return mav;
	}

	// 援щℓ紐⑸줉�뿉�꽌 由щ럭 �옉�꽦�븯�윭媛�湲�
	@RequestMapping(value = "/userreviewwrite", method = RequestMethod.GET) // �꽭�뀡�옉�뾽 �븘�슂
	public ModelAndView userreviewwrite(Model model, HttpServletRequest request) {

		String ocode = request.getParameter("ocode");

		mav.addObject("ocode", ocode);
		mav.setViewName("userreviewwrite");
		return mav;
	}

	// �옉�꽦�븳 由щ럭 ���옣
	@RequestMapping(value = "/userreviewsave", method = RequestMethod.POST) // �꽭�뀡�옉�뾽 �븘�슂
	public ModelAndView userreviewsave(Model model, HttpServletRequest request) {
		// �꽭�뀡�뿉�꽌 �븘�씠�뵒 媛��졇�삤�뒗嫄몃줈 �닔�젙�븯湲�
		BoardService ser = sqlSession.getMapper(BoardService.class);

		String ocode = request.getParameter("ocode");
		String bname = request.getParameter("bname");
		String bcont = request.getParameter("bcont");

		int k = ser.userreviewsave(ocode, bname, bcont);
		System.out.println(k + "由щ럭���옣�릱�땲?");

		mav.setViewName("redirect:main");
		return mav;
	}

	// �궡媛� �옉�꽦�븳 由щ럭 紐⑸줉 蹂닿린
	@RequestMapping(value = "/reviewlist", method = RequestMethod.GET) // �꽭�뀡�옉�뾽 �븘�슂
	public ModelAndView reviewlist(Model model, HttpServletRequest request) {
		// �꽭�뀡�뿉�꽌 �븘�씠�뵒 媛��졇�삤�뒗嫄몃줈 �닔�젙�븯湲�
		BoardService ser = sqlSession.getMapper(BoardService.class);

		int btype = Integer.parseInt(request.getParameter("btype"));
		ArrayList<TotalDTO> list = ser.userreviewlist("user001", btype);

		mav.addObject("list", list);
		mav.setViewName("userreviewlist");
		return mav;
	}

	// �궡媛� �옉�꽦�븳 由щ럭 �궘�젣�븯湲�
	@RequestMapping(value = "/userreviewdel", method = RequestMethod.GET) // �꽭�뀡�옉�뾽 �븘�슂
	public ModelAndView userreviewdel(Model model, HttpServletRequest request) {
		// �꽭�뀡�뿉�꽌 �븘�씠�뵒 媛��졇�삤�뒗嫄몃줈 �닔�젙�븯湲�

		BoardService ser = sqlSession.getMapper(BoardService.class);
		int bnum = Integer.parseInt(request.getParameter("bnum"));

		int k = ser.userboarddel("user001", bnum);
		System.out.println("由щ럭�궘�젣�릱�땲? " + k);

		mav.setViewName("redirect:main");

		return mav;
	}

	// 由щ럭 �닔�젙 異쒕젰
	@RequestMapping(value = "/reviewupdateget", method = RequestMethod.GET) // �꽭�뀡�옉�뾽 �븘�슂
	public ModelAndView reviewupdateget(Model model, HttpServletRequest request) {
		// �꽭�뀡�뿉�꽌 �븘�씠�뵒 媛��졇�삤�뒗嫄몃줈 �닔�젙�븯湲�
		BoardService ser = sqlSession.getMapper(BoardService.class);

		int bnum = Integer.parseInt(request.getParameter("bnum"));
		TotalDTO dto = ser.usereareview("user001", bnum);

		mav.addObject("dto", dto);
		mav.setViewName("userreviewupdate");
		return mav;
	}

	// �닔�젙�븳 由щ럭 ���옣
	@RequestMapping(value = "/reviewupdateset", method = RequestMethod.POST) // �꽭�뀡�옉�뾽 �븘�슂
	public ModelAndView reviewupdateset(Model model, HttpServletRequest request) {
		// �꽭�뀡�뿉�꽌 �븘�씠�뵒 媛��졇�삤�뒗嫄몃줈 �닔�젙�븯湲�
		BoardService ser = sqlSession.getMapper(BoardService.class);

		String bnum = request.getParameter("bnum");
		String bname = request.getParameter("bname");
		String bcont = request.getParameter("bcont");

		int k = ser.userreviewupdateset("user001", bnum, bname, bcont);
		System.out.println(k + "由щ럭�닔�젙�릱�땲?");

		mav.setViewName("redirect:main");
		return mav;
	}

	// 臾몄쓽�븯�윭媛�湲�
	@RequestMapping(value = "/usertoseller", method = RequestMethod.GET) // �꽭�뀡�옉�뾽 �븘�슂
	public ModelAndView usertoseller(Model model, HttpServletRequest request) {
		// �꽭�뀡�뿉�꽌 �븘�씠�뵒 媛��졇�삤�뒗嫄몃줈 �닔�젙�븯湲�

		ListService ser = sqlSession.getMapper(ListService.class);
		String ocode = request.getParameter("ocode");
		System.out.println("usertoseller ocode �옒 �룄李⑺뻽�땲? " + ocode);
		ListDTO dto = ser.usertoseller(ocode);

		mav.addObject("dto", dto);
		mav.setViewName("usertoseller");

		return mav;
	}

	// 臾몄쓽 ���옣�븯湲�
	@RequestMapping(value = "/usertosellersave", method = RequestMethod.POST) // �꽭�뀡�옉�뾽 �븘�슂
	public ModelAndView usertosellersave(Model model, HttpServletRequest request) {
		// �꽭�뀡�뿉�꽌 �븘�씠�뵒 媛��졇�삤�뒗嫄몃줈 �닔�젙�븯湲�

		BoardService ser = sqlSession.getMapper(BoardService.class);

		String bname = request.getParameter("bname");
		String bcont = request.getParameter("bcont");
		String pcode = request.getParameter("pcode");
		System.out.println("臾몄쓽 �벑濡� 以�! " + bname + pcode);

		int k = ser.usertosellersave("user001", bname, bcont, pcode);
		System.out.println("臾몄쓽 �벑濡� �릱�땲? " + k);

		mav.setViewName("redirect:main");

		return mav;
	}

	// �궡媛� �벖 臾몄쓽 紐⑸줉 �솗�씤
	@RequestMapping(value = "/usertosellerlist", method = RequestMethod.GET) // �꽭�뀡�옉�뾽 �븘�슂
	public ModelAndView usertosellerlist(Model model, HttpServletRequest request) {
		// �꽭�뀡�뿉�꽌 �븘�씠�뵒 媛��졇�삤�뒗嫄몃줈 �닔�젙�븯湲�

		int btype = Integer.parseInt(request.getParameter("btype"));
		BoardService ser = sqlSession.getMapper(BoardService.class);
		ArrayList<TotalDTO> list = ser.usertolist("user001", btype);

		mav.addObject("list", list);
		mav.setViewName("usertosellerlist");

		return mav;
	}

	// �궡媛� �벖 臾몄쓽 �궡�슜
	@RequestMapping(value = "/usertosellerout", method = RequestMethod.GET) // �꽭�뀡�옉�뾽 �븘�슂
	public ModelAndView usertosellerout(Model model, HttpServletRequest request) {
		// �꽭�뀡�뿉�꽌 �븘�씠�뵒 媛��졇�삤�뒗嫄몃줈 �닔�젙�븯湲�
		BoardService ser = sqlSession.getMapper(BoardService.class);

		int bnum = Integer.parseInt(request.getParameter("bnum"));
		System.out.println("臾몄쓽 �궡�슜 �씫�쑝�윭 �솕�뒗�뜲, " + bnum);

		ArrayList<TotalDTO> list = ser.usertosellerout(bnum);

		mav.addObject("list", list);
		mav.setViewName("usertosellerout");

		return mav;
	}

	// �궡媛� �벖 臾몄쓽 �궘�젣
	@RequestMapping(value = "/usertosellerdel", method = RequestMethod.GET) // �꽭�뀡�옉�뾽 �븘�슂
	public ModelAndView usertosellerdel(Model model, HttpServletRequest request) {
		// �꽭�뀡�뿉�꽌 �븘�씠�뵒 媛��졇�삤�뒗嫄몃줈 �닔�젙�븯湲�
		BoardService ser = sqlSession.getMapper(BoardService.class);

		int bnum = Integer.parseInt(request.getParameter("bnum"));
		System.out.println("臾몄쓽 �궡�슜 �궘�젣�븯�윭, " + bnum);

		int k = ser.userboarddel("user001", bnum);
		System.out.println("臾몄쓽 �궘�젣 �릱�땲? " + k);

		mav.setViewName("redirect:main");

		return mav;
	}

	// 사이트에 문의하기
	@RequestMapping(value = "/usertosite", method = RequestMethod.GET) // 세션작업 필요
	public ModelAndView usertosite(Model model, HttpServletRequest request) {
		// 세션에서 아이디 가져오는걸로 수정하기

		mav.setViewName("usertosite");

		return mav;
	}

	// 사이트 문의 저장하기
	@RequestMapping(value = "/usertositesave", method = RequestMethod.POST) // 세션작업 필요
	public ModelAndView usertositesave(Model model, HttpServletRequest request) {
		// 세션에서 아이디 가져오는걸로 수정하기

		BoardService ser = sqlSession.getMapper(BoardService.class);

		String bname = request.getParameter("bname");
		String bcont = request.getParameter("bcont");
		System.out.println("문의 등록 중! " + bname);

		int k = ser.usertositesave("user001", bname, bcont);
		System.out.println("사이트 문의 등록 됐니? " + k);

		mav.setViewName("redirect:main");

		return mav;
	}

	// 사이트 문의 목록
	@RequestMapping(value = "/usertositelist", method = RequestMethod.GET) // 세션작업 필요
	public ModelAndView usertositelist(Model model, HttpServletRequest request) {
		// 세션에서 아이디 가져오는걸로 수정하기
		BoardService ser = sqlSession.getMapper(BoardService.class);

		int btype = Integer.parseInt(request.getParameter("btype"));
		ArrayList<TotalDTO> list = ser.usertolist("user001", btype);

		mav.addObject("list", list);
		mav.setViewName("usertositelist");

		return mav;
	}

	// �궡媛� �벖 臾몄쓽 �궡�슜
	@RequestMapping(value = "/usertositeout", method = RequestMethod.GET) // �꽭�뀡�옉�뾽 �븘�슂
	public ModelAndView usertositeout(Model model, HttpServletRequest request) {
		// �꽭�뀡�뿉�꽌 �븘�씠�뵒 媛��졇�삤�뒗嫄몃줈 �닔�젙�븯湲�
		BoardService ser = sqlSession.getMapper(BoardService.class);

		int bnum = Integer.parseInt(request.getParameter("bnum"));
		System.out.println("臾몄쓽 �궡�슜 �씫�쑝�윭 �솕�뒗�뜲, " + bnum);

		ArrayList<TotalDTO> list = ser.usertosellerout(bnum);

		mav.addObject("list", list);
		mav.setViewName("usertositeout");

		return mav;
	}
}
