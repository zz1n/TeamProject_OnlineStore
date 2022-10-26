package com.teampj.shop.profit;

import java.util.ArrayList;
import java.util.Locale;

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
@RequestMapping(value = "/profit/**")
public class ProfitController {

	private static final Logger logger = LoggerFactory.getLogger(ProfitController.class);

	@Autowired
	private SqlSession sqlSession;

	ModelAndView mav = new ModelAndView();
	JSONParser jp = new JSONParser();
	JSONObject jo;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView mainhome(Model mo,HttpServletRequest request) {
		String scode = request.getParameter("scode");
		mo.addAttribute("scode", scode);
		mav.setView(new RedirectView("/shop")); // �떎瑜� 而⑦듃濡ㅻ윭濡� viewname
		return mav;
	}

	//판매자 매출조회 메인
	@RequestMapping(value = "/profitmain", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request, Model mo) {
		String scode = request.getParameter("scode");
		mo.addAttribute("scode", scode);
		mav.setViewName("profitmain");
		return mav;
	}

	//기간별 매출조회
	@RequestMapping(value = "/periodprofitcall", method = RequestMethod.GET)
	public ModelAndView profitcall(HttpServletRequest request, Model mo) {
		String scode = request.getParameter("scode");
		String serchset = request.getParameter("serchset");
		String begindate = request.getParameter("begindate");
		String enddate = request.getParameter("enddate");
		
		ProfitService ps = sqlSession.getMapper(ProfitService.class);
		
		if(serchset.equals("month")) { //(month profit serch)
			ArrayList<ProfitDTO> list = ps.monthprofitcall(scode,begindate,enddate);
			mo.addAttribute("list", list);
			
		}
		else if(serchset.equals("day")) { //(day profit serch)
			ArrayList<ProfitDTO> list = ps.dayprofitcall(scode,begindate,enddate);
			mo.addAttribute("list", list);
		}
		
		mo.addAttribute("scode", scode);
		mav.setViewName("periodProfitView");//留ㅼ텧蹂닿린
		return mav;
	}
	//상품별 매출조회(pname profit serch)
	@RequestMapping(value="/pnameprofitcall",method = RequestMethod.GET)
	public ModelAndView pnameProfitView(HttpServletRequest request,Model mo)
	{
		String scode = request.getParameter("scode");
		String pcode = request.getParameter("pcode");
		String begindate = request.getParameter("begindate");
		String enddate = request.getParameter("enddate");
		
		ProfitService ps = sqlSession.getMapper(ProfitService.class);
		ArrayList<ProfitDTO> list = ps.pnameprofitcall(scode,pcode,begindate,enddate);
		
		mo.addAttribute("scode", scode);
		mo.addAttribute("list", list);
		
		mav.setViewName("pnameProfitView");
		return mav;
	}

}
