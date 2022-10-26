package com.teampj.shop.sellerAjax;

import java.io.PrintWriter;
import java.util.HashMap;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.teampj.shop.seller.SellerService;

@RestController

@RequestMapping(value = "/sellerAjax/**")
public class SellerAjaxController {

	private static final Logger logger = LoggerFactory.getLogger(SellerAjaxController.class);

	@Autowired
	private SqlSession sqlSession;

	ModelAndView mav = new ModelAndView();
	JSONParser jp = new JSONParser();
	JSONObject jo;


	// 占쎈툡占쎌뵠占쎈탵 餓λ쵎�궗占쎌넇占쎌뵥
	@RequestMapping(value = "/idCheck", method = RequestMethod.GET)
	@ResponseBody
	public int idCheck(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		System.out.println("넘어오니?");
		String sellerid = request.getParameter("id");
		System.out.println(sellerid);
		SellerAjaxService ss = sqlSession.getMapper(SellerAjaxService.class);
		int chk = ss.idCheck(sellerid);
		System.out.println(chk);
	
		
		return chk;
		
	}

	// 占쎈솇筌띲끉�쁽 占쎌돳占쎌뜚揶쏉옙占쎌뿯 占쏙옙占쎌삢
	@RequestMapping(value = "/sinsave", method = RequestMethod.POST)
	public ModelAndView sellerin(HttpServletRequest request, Model mo) {
		
		String sellerid = request.getParameter("sellerid");
		String sellerpw = request.getParameter("sellerpw");
		String scomname = request.getParameter("scomname");
		String sprename = request.getParameter("sprename");
		String sbusnum = request.getParameter("sbusnum");
		String scomsalenum = request.getParameter("scomsalenum");
		String scomaddress = request.getParameter("scomaddress");
		String semail = request.getParameter("semail1");
		String smobile = request.getParameter("smobile");
		String srgtdate = request.getParameter("srgtdate");

		SellerAjaxService ss = sqlSession.getMapper(SellerAjaxService.class);
		ss.sellerin(sellerid, sellerpw, scomname, sprename, sbusnum, scomsalenum, scomaddress, semail, smobile,
				srgtdate);
			mav.setView(new RedirectView("/shop/seller/index"));
		
		return mav;
	}

}
