package com.teampj.shop.prlist;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.teampj.shop.board.BoardService;

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
		// Ÿ������ name listmain ���� ����
		return mav;
	}

	@RequestMapping(value = "/inputsave", method = RequestMethod.POST)
	public String inputdb(MultipartHttpServletRequest mul) {

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
		String pmaincate = mul.getParameter("pmaincate");// ��з�
		String psubcate = mul.getParameter("psubcate");// �Һз�
		String pdscrpt = mul.getParameter("pdscrpt");
		String ptag = mul.getParameter("ptag");

		System.out.println(pname + "-" + price + "-" + cost + "-" + pcount + "-" + pshipday + "-" + pshipcost + "-"
				+ preshipcost + "-" + pspshipcost + "-" + pthumbnail + "-" + pmaincate + "-" + psubcate + "-" + pdscrpt
				+ "-" + ptag);

		PrListService listdao = sqlSession.getMapper(PrListService.class);
		listdao.listinsert(pname, price, cost, pcount, pshipday, pshipcost, preshipcost, pspshipcost, pthumbnail,
				pmaincate, psubcate, pdscrpt, ptag);

		return "redirect:main";
	}

	@RequestMapping(value = "/simplegoodslist")
	public String simplegoodslist(Model mo) {
		PrListService listdao = sqlSession.getMapper(PrListService.class);
		ArrayList<PrListDTO> list = listdao.simplegoodslist();
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
	public String update2(MultipartHttpServletRequest mul) {
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
		String pmaincate = mul.getParameter("pmaincate");// ��з�
		String psubcate = mul.getParameter("psubcate");// �Һз�
		String pdscrpt = mul.getParameter("pdscrpt");
		String ptag = mul.getParameter("ptag");
		String pcode = mul.getParameter("pcode");

		PrListService listdao = sqlSession.getMapper(PrListService.class);
		listdao.update2(pname, price, cost, pcount, pshipday, pshipcost, preshipcost, pspshipcost, pthumbnail,
				pmaincate, psubcate, pdscrpt, ptag, pcode);
		return "redirect:simplegoodslist";
	}

	@RequestMapping(value = "/preply", method = RequestMethod.POST)
	public String reply(HttpServletRequest request) {
		String bname = request.getParameter("bname");
		String bcont = request.getParameter("bcont");
		BoardService board = sqlSession.getMapper(BoardService.class);
		board.preply(bname, bcont);

		return "redirect:reply";
	}

	@RequestMapping(value = "/reply", method = RequestMethod.GET)

	public ModelAndView replypage(Model model) {
		mav.setViewName("reply");
		// Ÿ������ name listmain ���� ����
		return mav;
	}

}
