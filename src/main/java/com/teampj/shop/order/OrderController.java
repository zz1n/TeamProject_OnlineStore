package com.teampj.shop.order;

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

@Controller
@RequestMapping(value = "/order/*")
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private SqlSession sqlSession;

	ModelAndView mav = new ModelAndView();
	JSONParser jp = new JSONParser();
	JSONObject jo;

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView main(Model model) {
		mav.setViewName("ordermain");
		return mav;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView mainhome(Model model) {
		mav.setView(new RedirectView("/shop")); // 다른 컨트롤러로 viewname
		return mav;
	}

	// 援щℓ紐⑸줉 3媛쒖썡�씠�궡, 3媛쒖썡�씠�쟾
	@RequestMapping(value = "/orderlist", method = RequestMethod.GET) // �꽭�뀡�옉�뾽 �븘�슂
	public ModelAndView orderlist(Model model, HttpServletRequest request) {
		OrderService ser = sqlSession.getMapper(OrderService.class);

		int stnrd = Integer.parseInt(request.getParameter("stnrd"));
		ArrayList<TotalDTO> list = ser.orderlist("user001", stnrd);

		mav.addObject("list", list);
		mav.setViewName("userorderlist");
		return mav;
	}

	// 주문내역 > 주문상세정보
	@RequestMapping(value = "/orderdetail", method = RequestMethod.GET) // 세션작업필요
	public ModelAndView orderdetail(Model model, HttpServletRequest request) {
		OrderService ser = sqlSession.getMapper(OrderService.class);

		String ocode = request.getParameter("ocode");
		TotalDTO tto = ser.orderdetail("user001", ocode);

		mav.addObject("tto", tto);
		mav.setViewName("userorderdetail");
		return mav;
	}

	// 배송정보 수정
	@RequestMapping(value = "/#", method = RequestMethod.GET)
	public ModelAndView orderaddressupdate(Model model) {
		mav.setView(new RedirectView("/shop")); // 다른 컨트롤러로 viewname
		return mav;
	}

	// 취소신청
	@RequestMapping(value = "/ordercancel", method = RequestMethod.GET)
	public ModelAndView userordercancel(HttpServletRequest request, Model model) {
		OrderService ser = sqlSession.getMapper(OrderService.class);
		
		String ocode = request.getParameter("ocode");
		ser.ordercancel(ocode, "user001");
		
		mav.setViewName("userorderlist");
		return mav;
	}

}
