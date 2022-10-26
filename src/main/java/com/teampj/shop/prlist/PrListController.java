package com.teampj.shop.prlist;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.teampj.shop.board.BoardDTO;
import com.teampj.shop.board.BoardService;
import com.teampj.shop.seller.SellerDTO;

@Controller
@RequestMapping(value = "/prlist/**")
public class PrListController {

	private static final Logger logger = LoggerFactory.getLogger(PrListController.class);

	@Autowired
	private SqlSession sqlSession;

	ModelAndView mav = new ModelAndView();
	JSONParser jp = new JSONParser();
	JSONObject jo;

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView home(Model model) {
		mav.setViewName("prlistmain");
		// ���뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 name listmain �뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕
		return mav;
	}

	@RequestMapping(value = "/inputsave", method = RequestMethod.POST)
	public String inputdb(MultipartHttpServletRequest mul, HttpServletRequest req) {

		// String saveDir = mul.getSession().getServletContext().getRealPath("/image");

		String pname = mul.getParameter("pname");
		int price = Integer.parseInt(mul.getParameter("price"));
		int cost = Integer.parseInt(mul.getParameter("cost"));
		int pcount = Integer.parseInt(mul.getParameter("pcount"));
		String pshipday = mul.getParameter("pshipday");
		int pshipcost = Integer.parseInt(mul.getParameter("pshipcost"));
		int preshipcost = Integer.parseInt(mul.getParameter("preshipcost"));
		int pspshipcost = Integer.parseInt(mul.getParameter("pspshipcost"));
		MultipartFile image = mul.getFile("pthumbnail");
		String pthumbnail = image.getOriginalFilename();
		String pmaincate = mul.getParameter("pmaincate");// �뜝�룞�삕�닞�뜝占�
		String psubcate = mul.getParameter("psubcate");// �뜝��遺꾨쨪�삕
		String pdscrpt = req.getParameter("pdscrpt");
		String ptag = mul.getParameter("ptag");
		HttpSession hs = req.getSession();
		String scode = (String) hs.getAttribute("member");

		System.out.println(pname + "-" + price + "-" + cost + "-" + pcount + "-" + pshipday + "-" + pshipcost + "-"
				+ preshipcost + "-" + pspshipcost + "-" + pthumbnail + "-" + pmaincate + "-" + psubcate + "-" + pdscrpt
				+ "-" + ptag);

		PrListService listdao = sqlSession.getMapper(PrListService.class);
		listdao.listinsert(pname, price, cost, pcount, pshipday, pshipcost, preshipcost, pspshipcost, pthumbnail,
				pmaincate, psubcate, pdscrpt, ptag, scode);

		return "redirect:main";
	}

	@RequestMapping(value = "/simplegoodslist")
	public String simplegoodslist(Model mo, HttpServletRequest req) {
		PrListService listdao = sqlSession.getMapper(PrListService.class);
		HttpSession hs = req.getSession();
		String scode = (String) hs.getAttribute("member");
		ArrayList<PrListDTO> list = listdao.simplegoodslist(scode);
		mo.addAttribute("list", list);
		return "output";

	}

	@RequestMapping(value = "/delete")
	public String delete(HttpServletRequest request) {
		String pcode = request.getParameter("pcode");
		PrListService listdao = sqlSession.getMapper(PrListService.class);
		listdao.delete(pcode);
		return "redirect:simplegoodslist";
	}

	@RequestMapping(value = "/update")
	public String update(HttpServletRequest request, Model mo) {
		String pcode = request.getParameter("pcode");
		PrListService listdao = sqlSession.getMapper(PrListService.class);
		ArrayList<PrListDTO> list = listdao.update(pcode);
		mo.addAttribute("update", list);
		return "update";

	}

	@RequestMapping(value = "/update2", method = RequestMethod.POST)
	public String update2(MultipartHttpServletRequest mul, HttpServletRequest req) {
		String pname = mul.getParameter("pname");
		int price = Integer.parseInt(mul.getParameter("price"));
		int cost = Integer.parseInt(mul.getParameter("cost"));
		int pcount = Integer.parseInt(mul.getParameter("pcount"));
		String pshipday = mul.getParameter("pshipday");
		int pshipcost = Integer.parseInt(mul.getParameter("pshipcost"));
		int preshipcost = Integer.parseInt(mul.getParameter("preshipcost"));
		int pspshipcost = Integer.parseInt(mul.getParameter("pspshipcost"));
		MultipartFile image = mul.getFile("pthumbnail");
		String pthumbnail = image.getOriginalFilename();
		String pmaincate = mul.getParameter("pmaincate");// �뜝�룞�삕�닞�뜝占�
		String psubcate = mul.getParameter("psubcate");// �뜝��遺꾨쨪�삕
		String pdscrpt = req.getParameter("pdscrpt");
		String ptag = mul.getParameter("ptag");
		String pcode = mul.getParameter("pcode");

		PrListService listdao = sqlSession.getMapper(PrListService.class);
		listdao.update2(pname, price, cost, pcount, pshipday, pshipcost, preshipcost, pspshipcost, pthumbnail,
				pmaincate, psubcate, pdscrpt, ptag, pcode);
		return "redirect:simplegoodslist";
	}

	@RequestMapping(value = "/preply") //臾몄쓽�븯湲�(援щℓ�옄 臾몄쓽�궡�뿭 異쒕젰)
	public String reply(Model mo, HttpServletRequest req) {
		BoardService board = sqlSession.getMapper(BoardService.class);
		HttpSession hs = req.getSession();
		String scode = (String) hs.getAttribute("member");
		
		ArrayList<BoardDTO> boardlist = board.preply(scode);
		mo.addAttribute("list", boardlist);
		
		return "reply";
	}

//	@RequestMapping(value = "/reply", method = RequestMethod.GET)
//
//	public ModelAndView replypage(Model model) {
//		mav.setViewName("reply");
//		// ���뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 name listmain �뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕
//		return mav;
//	}
	@RequestMapping(value = "/selleranswer", method=RequestMethod.GET)//臾몄쓽�븯湲� 踰꾪듉�닃�윭�꽌 臾몄쓽李� �쓣�슦湲�
	public String answer(HttpServletRequest request, Model mo) {
		String bnum = request.getParameter("bnum");
		String pcode = request.getParameter("pcode");
		
		mo.addAttribute("bnum", bnum);
		mo.addAttribute("pcode", pcode);
		
		return "selleranswer"; //臾몄쓽�븯湲곗갹 �쓣�슦湲�
	}
	@RequestMapping(value = "/answercomplete", method=RequestMethod.POST)
	public String answercomplete(HttpServletRequest request) {
		String bnum = request.getParameter("bnum");
		String pcode = request.getParameter("pcode");
		String bname = request.getParameter("bname");
		String bcont = request.getParameter("bcont");
		HttpSession hs = request.getSession();
		String scode = (String) hs.getAttribute("member");
		BoardService board = sqlSession.getMapper(BoardService.class);
		board.answercomplete(bnum,pcode,bname,bcont, scode);
		
		
		
		
		return "redirect:preply";
	}
	}
	
	
