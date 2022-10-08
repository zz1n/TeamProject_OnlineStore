package com.teampj.shop.list;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.teampj.shop.board.BoardDTO;
import com.teampj.shop.board.BoardService;
import com.teampj.shop.board.PageDTO;

@Controller
@RequestMapping(value = "/list/**")
public class ListController {

	private static final Logger logger = LoggerFactory.getLogger(ListController.class);

	@Autowired
	private SqlSession sqlSession;

	ModelAndView mav = new ModelAndView();
	JSONParser jp = new JSONParser();
	JSONObject jo;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView mainhome(Model model) {
		mav.setView(new RedirectView("/shop")); // �떎瑜� 而⑦듃濡ㅻ윭濡� viewname
		return mav;
	}

	//창용
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView main(Model model) {

		ListService ls = sqlSession.getMapper(ListService.class);
		ArrayList<ListDTO> list = ls.mainout();

		model.addAttribute("list", list);

		mav.setViewName("listmain");
		return mav;
	}

	@RequestMapping(value = "/ranking", method = RequestMethod.GET)
	public ModelAndView ranking(Model model, HttpServletRequest request) {

		ListService ls = sqlSession.getMapper(ListService.class);
		ArrayList<ListDTO> list = ls.rankingout();

		model.addAttribute("list", list);

		mav.setViewName("listranking");
		return mav;
	}

	@RequestMapping(value = "/month", method = RequestMethod.GET)
	public ModelAndView month(Model model, HttpServletRequest request) {

		ListService ls = sqlSession.getMapper(ListService.class);
		ArrayList<ListDTO> list = ls.monthout();

		model.addAttribute("list", list);

		mav.setViewName("listmonth");
		return mav;
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search(Model model, HttpServletRequest request) {

		String svalue = request.getParameter("svalue");

		ListService ls = sqlSession.getMapper(ListService.class);
		ArrayList<ListDTO> list = ls.search(svalue);

		model.addAttribute("list", list);
		model.addAttribute("svalue", svalue);

		mav.setViewName("listsearchpage");
		return mav;
	}

	@RequestMapping(value = "/listcate", method = RequestMethod.GET)
	public ModelAndView listcate(Model model, HttpServletRequest request) {

		ListService ls = sqlSession.getMapper(ListService.class);
		String listcate = request.getParameter("listcate");
		ArrayList<ListDTO> list = ls.listcate(listcate);

		model.addAttribute("list", list);

		mav.setViewName("lists_category");
		return mav;
	}


	@RequestMapping(value = "/brandcate", method = RequestMethod.GET)
	public ModelAndView brandcate(Model model, HttpServletRequest request) {

		ListService ls = sqlSession.getMapper(ListService.class);
		String brandcate = request.getParameter("brandcate");
		ArrayList<ListDTO> list = ls.brandcate(brandcate);

		model.addAttribute("list", list);

		mav.setViewName("listp_category");
		return mav;
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detail(Model model, HttpServletRequest request) {

		String pcode = request.getParameter("pcode");

		ListService ls = sqlSession.getMapper(ListService.class);
		BoardService bs = sqlSession.getMapper(BoardService.class);

		ArrayList<ListDTO> list = ls.detail(pcode);
		ArrayList<BoardDTO> list1 = bs.review(pcode);
		ArrayList<BoardDTO> list2 = bs.inquiry(pcode);

		model.addAttribute("list", list);
		model.addAttribute("list1", list1);
		model.addAttribute("list2", list2);
		mav.setViewName("listdetail");
		return mav;
	}

	@RequestMapping(value = "/buy", method = RequestMethod.GET)
	public ModelAndView buy(Model model, HttpServletRequest request) {

		String pcode = request.getParameter("pcode");
		int bb = Integer.parseInt(request.getParameter("bb"));

		ListService ls = sqlSession.getMapper(ListService.class);
		ArrayList<ListDTO> list = ls.buy(pcode);

		model.addAttribute("list", list);
		model.addAttribute("bb", bb);

		mav.setViewName("listbuy");
		return mav;
	}

	@RequestMapping(value = "/buysave", method = RequestMethod.GET)
	public ModelAndView buysave(Model model, HttpServletRequest request) {

		String pcode = request.getParameter("pcode");
		String scode = request.getParameter("scode");
		String omethod = request.getParameter("omethod");
		int bb = Integer.parseInt(request.getParameter("bb"));

		ListService ls = sqlSession.getMapper(ListService.class);
		ls.buysave(scode, pcode, bb, omethod);

		mav.setViewName("redirect:main");
		return mav;
	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public String page(Model model, HttpServletRequest request, PageDTO pto,
			@RequestParam(value = "nowpage", required = false) String nowpage,
			@RequestParam(value = "cntperpage", required = false) String cntperpage) {

		String pcode = request.getParameter("pcode");

		BoardService bs = sqlSession.getMapper(BoardService.class);

		int total = bs.cntnotice(); // �쟾泥� �젅肄붾뱶 �닔
		if (nowpage == null && cntperpage == null) {
			nowpage = "1";
			cntperpage = "5";
		} else if (nowpage == null) {
			nowpage = "1";
		} else if (cntperpage == null) {
			cntperpage = "5";
		}

		pto = new PageDTO(total, Integer.parseInt(nowpage), Integer.parseInt(cntperpage));
		ArrayList<BoardDTO> list1 = bs.review(pcode);
		ArrayList<BoardDTO> list = bs.selectnotice(pto);

		model.addAttribute("paging", pto);
		model.addAttribute("view", list);
		model.addAttribute("list1", list1);

		return "page";
	}

}
