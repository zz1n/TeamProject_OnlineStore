package com.teampj.shop.list;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.teampj.shop.board.BoardDTO;
import com.teampj.shop.board.BoardService;
import com.teampj.shop.board.PageDTO;
import com.teampj.shop.check.CheckService;
import com.teampj.shop.order.OrderDTO;
import com.teampj.shop.order.OrderService;

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

	// 창용
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
	public ModelAndView detail(Model mo, HttpServletRequest request) {
		
		HttpSession hs = request.getSession();
		if((Boolean)hs.getAttribute("loginstate")) 
		{
			mo.addAttribute("signIn", "login");
		} 
		else 
		{
			mo.addAttribute("signIn", "");
		}
		
		String pcode = request.getParameter("pcode");

		ListService ls = sqlSession.getMapper(ListService.class);
		BoardService bs = sqlSession.getMapper(BoardService.class);

		ArrayList<ListDTO> list = ls.detail(pcode);
		ArrayList<BoardDTO> list1 = bs.review(pcode);
		ArrayList<BoardDTO> list2 = bs.inquiry(pcode);
			
		mo.addAttribute("list", list);
		mo.addAttribute("list1", list1);
		mo.addAttribute("list2", list2);
			
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
		int ocharge = Integer.parseInt(request.getParameter("totcharge"));
		int bb = Integer.parseInt(request.getParameter("bb"));
		HttpSession hs = request.getSession();
		String userid = (String) hs.getAttribute("member");
		System.out.println("buy" + pcode);
		System.out.println(scode);
		System.out.println(omethod);
		System.out.println(ocharge);
		System.out.println(bb);

		ListService ls = sqlSession.getMapper(ListService.class);
		ls.buysave(scode, pcode, bb, omethod, ocharge, userid);

		mav.setViewName("listbuycomplete");
		return mav;
	}

	@RequestMapping(value = "/buycomplete", method = RequestMethod.GET)
	public ModelAndView buycomplete(Model model, HttpServletRequest request) {

		String pcode = request.getParameter("pcode");
		String scode = request.getParameter("scode");

		ListService ls = sqlSession.getMapper(ListService.class);
		OrderService os = sqlSession.getMapper(OrderService.class);
		ArrayList<OrderDTO> list = os.buycomplete(pcode);

		model.addAttribute("list", list);

		mav.setViewName("listbuycomplete");
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

	@RequestMapping(value = "/orderlist")
	public ModelAndView output1(Model mo, HttpServletRequest request, HttpServletResponse response, RedirectAttributes red) {

		HttpSession hs = request.getSession();
		
		if((Boolean)hs.getAttribute("loginstate")) 
		{
			mo.addAttribute("signIn", "login");
		} 
		else 
		{
			mo.addAttribute("signIn", "");
		}

		mav.setViewName("redirect:/order/orderlist");
		
		return mav;
	}

	@RequestMapping(value = "/logout")
	public String logout1(HttpServletRequest request, Model mod) {

		HttpSession hs = request.getSession();
		hs.removeAttribute("member");
		hs.removeAttribute("loginstate");
		hs.setAttribute("loginstate", false);

		return "redirect:/list/main";
	}
	
	//hj
	@RequestMapping(value = "/gotocart", method = RequestMethod.GET)
	public ModelAndView gotocart(Model model, HttpServletRequest request) {
		System.out.println("gotocart 도착");
		String pcode = request.getParameter("pcode");
		System.out.println(pcode+"도착");
		HttpSession hs = request.getSession();
		String userid = (String) hs.getAttribute("member");
		
		CheckService cer = sqlSession.getMapper(CheckService.class);
		int k = cer.gotocheck(userid, pcode, 1);
		System.out.println(k+" 쿼리문 작동?");
		
		mav.setView(new RedirectView("/shop/check/usercart"));
		return mav;
	}
	
	@RequestMapping(value = "/gotolike", method = RequestMethod.GET)
	public ModelAndView gotolike(Model model, HttpServletRequest request) {
		String pcode = request.getParameter("pcode");
		HttpSession hs = request.getSession();
		String userid = (String) hs.getAttribute("member");
		
		CheckService cer = sqlSession.getMapper(CheckService.class);
		int k = cer.gotocheck(userid, pcode, 2);
		
		mav.setView(new RedirectView("/shop/check/userlike"));
		return mav;
	}
}
