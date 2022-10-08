package com.teampj.shop.seller;

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

@Controller
@RequestMapping(value = "/seller/**")
public class SellerController {

	private static final Logger logger = LoggerFactory.getLogger(SellerController.class);

	@Autowired
	private SqlSession sqlSession;

	ModelAndView mav = new ModelAndView();
	JSONParser jp = new JSONParser();
	JSONObject jo;

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView main(Model model) {
		mav.setViewName("sellermain");
		return mav;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView mainhome(Model model) {
		mav.setView(new RedirectView("/shop")); // 다른 컨트롤러로 viewname
		return mav;
	}

	// 판매자 로그인화면 전송
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView home(Model model) {
		mav.setViewName("sellerindex");
		return mav;
	}

	// 로그인 체크,메인화면으로 전송
	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public ModelAndView loginCheck(HttpServletRequest request, Model mo) {
		String sellerid = request.getParameter("sellerid");
		String sellerpw = request.getParameter("sellerpw");
		String nowtime = request.getParameter("nowtime");
		SellerService ss = sqlSession.getMapper(SellerService.class);
		int loginchk = ss.loginCheck(sellerid, sellerpw);
		if (loginchk == 1) {
			String scode = ss.logincode(sellerid);
			mo.addAttribute("scode", scode);
			mo.addAttribute("nowtime", nowtime);
			System.out.println(nowtime);
			mav.setView(new RedirectView("/shop/sellerOrder/sellermain"));
		} else {
			mav.setViewName("sellerindex");
		}

		return mav;
	}

	// 판매자 메인 // 로그인 성공 추가로 주문내역을 불러와서 셀러메인페이지에 넘겨줘야함.
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView sellermain(HttpServletRequest request, Model mo) {
		String sellerid = request.getParameter("sellerid");
		String sellerpw = request.getParameter("sellerpw");

		SellerService ss = sqlSession.getMapper(SellerService.class);

		mav.setView(new RedirectView("/shop/sellerOrderMain/sellermain"));
		return mav;
	}

	// 판매자 회원가입 화면으로 전송
	@RequestMapping(value = "/sellerinput", method = RequestMethod.GET)
	public ModelAndView sellerinput(Model model) {
		mav.setViewName("sellerinput");
		return mav;
	}

	// 아이디 중복확인
	@RequestMapping(value = "/idCheck", method = RequestMethod.GET)
	public int idCheck(SellerDTO dto, HttpServletRequest request) {

		SellerService ss = sqlSession.getMapper(SellerService.class);

		int cnt = ss.idCheck();

		return cnt;
	}

	// 판매자 회원가입 저장
	@RequestMapping(value = "/sinsave", method = RequestMethod.POST)
	public ModelAndView sellerin(HttpServletRequest request) {

		String sellerid = request.getParameter("sellerid");
		String sellerpw = request.getParameter("sellerpw");
		String scomname = request.getParameter("scomname");
		String sprename = request.getParameter("sprename");
		String sbusnum = request.getParameter("sbusnum");
		String scomsalenum = request.getParameter("scomsalenum");
		String scomaddress = request.getParameter("scomaddress");
		String semail = request.getParameter("semail");
		String smobile = request.getParameter("smobile");
		String srgtdate = request.getParameter("srgtdate");

		SellerService ss = sqlSession.getMapper(SellerService.class);
		ss.sellerin(sellerid, sellerpw, scomname, sprename, sbusnum, scomsalenum, scomaddress, semail, smobile,
				srgtdate);
		mav.setViewName("sellerindex");
		return mav;
	}

}
