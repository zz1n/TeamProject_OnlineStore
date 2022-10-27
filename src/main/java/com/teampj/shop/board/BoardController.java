package com.teampj.shop.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.teampj.shop.list.ListDTO;
import com.teampj.shop.list.ListService;
import com.teampj.shop.user.UserDTO;

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
		mav.setView(new RedirectView("/shop")); // 다른 컨트롤러로 viewname
		return mav;
	}

	// 리뷰 상세출력
	@RequestMapping(value = "/reviewout", method = RequestMethod.GET)
	public ModelAndView reviewout(Model model, HttpServletRequest request) {
		BoardService ser = sqlSession.getMapper(BoardService.class);
		ListService ler = sqlSession.getMapper(ListService.class);

		HttpSession hs = request.getSession();
		String userid = (String) hs.getAttribute("member");

		int bnum = Integer.parseInt(request.getParameter("bnum"));
		BoardDTO dto = ser.usereareview(userid, bnum);
		ListDTO lto = ler.usereareview(userid, bnum);

		mav.addObject("dto", dto);
		mav.addObject("lto", lto);
		mav.setViewName("userreviewout");
		return mav;
	}

	// 리뷰작성
	@RequestMapping(value = "/userreviewwrite", method = RequestMethod.GET)
	public ModelAndView userreviewwrite(Model model, HttpServletRequest request) {

		String ocode = request.getParameter("ocode");

		mav.addObject("ocode", ocode);
		mav.setViewName("userreviewwrite");
		return mav;
	}

	// 리뷰 작성 저장
	@RequestMapping(value = "/userreviewsave", method = RequestMethod.POST)
	public ModelAndView userreviewsave(Model model, HttpServletRequest request) {
		BoardService ser = sqlSession.getMapper(BoardService.class);

		HttpSession hs = request.getSession();
		String userid = (String) hs.getAttribute("member");
		String ocode = request.getParameter("ocode");
		String bname = request.getParameter("bname");
		String bcont = request.getParameter("bcont");

		int k = ser.userreviewsave(ocode, bname, bcont, userid);
		System.out.println(k + "由щ럭���옣�릱�땲?");

		mav.addObject("btype", 2);
		mav.setViewName("redirect:reviewlist");
		return mav;
	}

	// 작성한 리뷰 목록
	@RequestMapping(value = "/reviewlist", method = RequestMethod.GET)
	public ModelAndView reviewlist(Model model, HttpServletRequest request) {
		BoardService ser = sqlSession.getMapper(BoardService.class);

		HttpSession hs = request.getSession();
		String userid = (String) hs.getAttribute("member");
		int btype = Integer.parseInt(request.getParameter("btype"));
		ArrayList<BoardDTO> list = ser.userreviewlist(userid, btype);
		System.out.println(btype);

		mav.addObject("list", list);
		mav.setViewName("userreviewlist");
		return mav;
	}

	// 작성한 리뷰 삭제
	@RequestMapping(value = "/userreviewdel", method = RequestMethod.GET)
	public ModelAndView userreviewdel(Model model, HttpServletRequest request) {

		BoardService ser = sqlSession.getMapper(BoardService.class);
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		HttpSession hs = request.getSession();
		String userid = (String) hs.getAttribute("member");

		int k = ser.userboarddel(userid, bnum);

		mav.addObject("btype", 2);
		mav.setViewName("redirect:reviewlist");

		return mav;
	}

	// 리뷰 수정할 내용 가져오기
	@RequestMapping(value = "/reviewupdateget", method = RequestMethod.GET)
	public ModelAndView reviewupdateget(Model model, HttpServletRequest request) {
		BoardService ser = sqlSession.getMapper(BoardService.class);
		ListService ler = sqlSession.getMapper(ListService.class);

		HttpSession hs = request.getSession();
		String userid = (String) hs.getAttribute("member");
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		BoardDTO dto = ser.usereareview(userid, bnum);
		ListDTO lto = ler.usereareview(userid, bnum);

		mav.addObject("dto", dto);
		mav.addObject("lto", lto);
		mav.setViewName("userreviewupdate");
		return mav;
	}

	// 리뷰 수정한 내용 저장하기
	@RequestMapping(value = "/reviewupdateset", method = RequestMethod.POST)
	public ModelAndView reviewupdateset(Model model, HttpServletRequest request) {
		BoardService ser = sqlSession.getMapper(BoardService.class);

		String bnum = request.getParameter("bnum");
		String bname = request.getParameter("bname");
		String bcont = request.getParameter("bcont");
		HttpSession hs = request.getSession();
		String userid = (String) hs.getAttribute("member");

		int k = ser.userreviewupdateset(userid, bnum, bname, bcont);

		mav.addObject("btype", 2);
		mav.setViewName("redirect:reviewlist");
		return mav;
	}

	// 판매자에게 문의하기
	@RequestMapping(value = "/usertoseller", method = RequestMethod.GET)
	public ModelAndView usertoseller(Model model, HttpServletRequest request) {
		ListService ser = sqlSession.getMapper(ListService.class);
		int btype = Integer.parseInt(request.getParameter("btype"));
		String ocode = request.getParameter("ocode");
		ListDTO dto = ser.usertoseller(ocode);

		mav.addObject("btype", btype);
		mav.addObject("dto", dto);
		mav.setViewName("usertoseller");

		return mav;
	}

	// 판매자에게 문의한 글 저장하기
	@RequestMapping(value = "/usertosellersave", method = RequestMethod.POST)
	public ModelAndView usertosellersave(Model model, HttpServletRequest request) {
		BoardService ser = sqlSession.getMapper(BoardService.class);

		String bname = request.getParameter("bname");
		String bcont = request.getParameter("bcont");
		String pcode = request.getParameter("pcode");
		HttpSession hs = request.getSession();
		String userid = (String) hs.getAttribute("member");

		int k = ser.usertosellersave(userid, bname, bcont, pcode);

		mav.addObject("btype", 1);
		mav.setViewName("redirect:usertosellerlist");

		return mav;
	}

	// 판매자 문의 목록 출력
	@RequestMapping(value = "/usertosellerlist", method = RequestMethod.GET)
	public ModelAndView usertosellerlist(Model model, HttpServletRequest request) {
		HttpSession hs = request.getSession();

		String userid = (String) hs.getAttribute("member");
		int btype = Integer.parseInt(request.getParameter("btype"));
		BoardService ser = sqlSession.getMapper(BoardService.class);

		ListService ler = sqlSession.getMapper(ListService.class);
		ArrayList<BoardDTO> list = ser.usertolist(userid, btype);
		ArrayList<ListDTO> list2 = ler.usertolist(userid, btype);

		mav.addObject("list", list);
		mav.addObject("list2", list2);
		mav.setViewName("usertosellerlist");

		return mav;
	}

	// 판매자 문의 상세내역
	@RequestMapping(value = "/usertosellerout", method = RequestMethod.GET) 
	public ModelAndView usertosellerout(Model model, HttpServletRequest request) {
		BoardService ser = sqlSession.getMapper(BoardService.class);
		ListService ler = sqlSession.getMapper(ListService.class);

		int bnum = Integer.parseInt(request.getParameter("bnum"));

		ArrayList<BoardDTO> list = ser.usertoaskout(bnum);
		ArrayList<ListDTO> list2 = ler.usertoaskout(bnum);

		mav.addObject("list", list);
		mav.addObject("list2", list2);
		mav.setViewName("usertosellerout");

		return mav;
	}

	// 판매자 문의 삭제
	@RequestMapping(value = "/usertosellerdel", method = RequestMethod.GET) 
	public ModelAndView usertosellerdel(Model model, HttpServletRequest request) {
		BoardService ser = sqlSession.getMapper(BoardService.class);

		int bnum = Integer.parseInt(request.getParameter("bnum"));
		HttpSession hs = request.getSession();
		String userid = (String) hs.getAttribute("member");

		int k = ser.userboarddel(userid, bnum);

		mav.addObject("btype", 1);
		mav.setViewName("redirect:usertosellerlist");

		return mav;
	}

	// 사이트에 문의하기
	@RequestMapping(value = "/usertosite", method = RequestMethod.GET) 
	public ModelAndView usertosite(Model model, HttpServletRequest request) {
		
		mav.setViewName("usertosite");

		return mav;
	}

	// 사이트 문의 저장하기
	@RequestMapping(value = "/usertositesave", method = RequestMethod.POST) 
	public ModelAndView usertositesave(Model model, HttpServletRequest request) {

		BoardService ser = sqlSession.getMapper(BoardService.class);

		String bname = request.getParameter("bname");
		String bcont = request.getParameter("bcont");
		HttpSession hs = request.getSession();
		String userid = (String) hs.getAttribute("member");

		int k = ser.usertositesave(userid, bname, bcont);

		mav.addObject("btype", 3);
		mav.setViewName("redirect:usertositelist");

		return mav;
	}

	// 사이트 문의 목록
	@RequestMapping(value = "/usertositelist", method = RequestMethod.GET) 
	public ModelAndView usertositelist(Model model, HttpServletRequest request) {
		BoardService ser = sqlSession.getMapper(BoardService.class);

		int btype = Integer.parseInt(request.getParameter("btype"));
		HttpSession hs = request.getSession();
		String userid = (String) hs.getAttribute("member");
		ArrayList<BoardDTO> list = ser.usertolist(userid, btype);

		System.out.println(btype);
		mav.addObject("list", list);
		mav.setViewName("usertositelist");

		return mav;
	}

	// 사이트 문의 상세
	@RequestMapping(value = "/usertositeout", method = RequestMethod.GET) 
	public ModelAndView usertositeout(Model model, HttpServletRequest request) {
		BoardService ser = sqlSession.getMapper(BoardService.class);

		int bnum = Integer.parseInt(request.getParameter("bnum"));

		ArrayList<BoardDTO> list = ser.usertoaskout(bnum);

		mav.addObject("list", list);
		mav.setViewName("usertositeout");

		return mav;
	}

	// 사이트 문의 삭제
	@RequestMapping(value = "/usertositedel", method = RequestMethod.GET) 
	public ModelAndView usertositedel(Model model, HttpServletRequest request) {
		BoardService ser = sqlSession.getMapper(BoardService.class);

		int bnum = Integer.parseInt(request.getParameter("bnum"));
		HttpSession hs = request.getSession();
		String userid = (String) hs.getAttribute("member");

		int k = ser.userboarddel(userid, bnum);

		mav.addObject("btype", 3);
		mav.setViewName("redirect:usertositelist");

		return mav;
	}
}
