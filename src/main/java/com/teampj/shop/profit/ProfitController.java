package com.teampj.shop.profit;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping(value = "/profit/**")
public class ProfitController {

	private static final Logger logger = LoggerFactory.getLogger(ProfitController.class);

	@Autowired
	private SqlSession sqlSession;

	ModelAndView mav = new ModelAndView();
	JSONParser jp = new JSONParser();
	JSONObject jo;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView mainhome(Model model) {
		mav.setView(new RedirectView("/shop")); // 다른 컨트롤러로 viewname
		return mav;
	}

	// 매출 메인
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request, Model mo) {
		String scode = request.getParameter("scode");
		mo.addAttribute("scode", scode);
		mav.setViewName("profitmain");
		return mav;
	}

	// 매출조회
	@RequestMapping(value = "/profitcall", method = RequestMethod.GET) // 매출기간조회
	public ModelAndView profitcall(HttpServletRequest request, Model mo) {
		String scode = request.getParameter("scode");
		String begindate = request.getParameter("begindate");
		String enddate = request.getParameter("enddate");
		ProfitService ps = sqlSession.getMapper(ProfitService.class);
		ArrayList<ProfitDTO> list = ps.testin(scode, begindate, enddate);

		mo.addAttribute("list", list);
		mo.addAttribute("scode", scode);
		mav.setViewName("testview");
		return mav;
	}

	// 테스트
	@RequestMapping(value = "/dateIncome", method = RequestMethod.GET)
	public void dateIncome(Locale locale, Model model) {

	}

	// 매출기간 출력
//	@RequestMapping(value = "/incomeList", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
//	public @ResponseBody String incomeList(HttpServletRequest request, HttpServletResponse resopnse, Model model)
//			throws Throwable {
//		String data = request.getParameter("profitdata");
//		jo = (JSONObject) jp.parse(data);
//		String scode = (String) jo.get("scode");
//		String begindate = (String) jo.get("begindate");
//		String enddate = (String) jo.get("enddate");
//
//		ProfitService ps = sqlSession.getMapper(ProfitService.class);
//		List<ProfitDTO> list = ps.getIncome(scode, begindate, enddate);
//		Gson gson = new Gson();
//
//		return gson.toJson(list);
//	}
//
//	@RequestMapping(value = "/serch", method = RequestMethod.GET) // 매출기간조회
//	public ModelAndView serch(HttpServletRequest request, Model mo) {
//		String scode = "S00001";
//		String begindate = request.getParameter("begindate");
//		String enddate = request.getParameter("enddate");
//		ProfitService ps = sqlSession.getMapper(ProfitService.class);
//		ArrayList<ProfitDTO> list = ps.testin(scode, begindate, enddate);
//
//		mo.addAttribute("list", list);
//
//		mav.setViewName("testview");
//		return mav;
//	}
}
