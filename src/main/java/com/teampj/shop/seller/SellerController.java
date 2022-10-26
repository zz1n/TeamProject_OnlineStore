package com.teampj.shop.seller;

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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
		mav.setView(new RedirectView("/shop")); // �뜝�럥堉꾬옙紐닷뜝占� 占쎈슓維귨옙諭쒎슖�뼯�걞占쎌몠�슖�댙�삕 viewname
		return mav;
	}

	// �뜝�럥�냷嶺뚮씞�걠占쎌겱 �슖�돦裕꾬옙�쟽�뜝�럩逾ε뜝�럩�꼨嶺뚮〕�삕 �뜝�럩�쓧�뜝�럥苑�
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView home(Model model) {
		mav.setViewName("sellerindex");
		return mav;
	}

	// �슖�돦裕꾬옙�쟽�뜝�럩逾� 嶺뚳퐢�샑野껓옙,嶺뚮∥�뾼占쎈데�뜝�럩�꼨嶺뚮∥�샍占쎈さ�슖�댙�삕 �뜝�럩�쓧�뜝�럥苑�
	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public ModelAndView loginCheck(HttpServletRequest request, Model mo, RedirectAttributes red) {

		String sellerid = request.getParameter("sellerid");
		String sellerpw = request.getParameter("sellerpw");

		SellerService ss = sqlSession.getMapper(SellerService.class);
		String scode = ss.login(sellerid, sellerpw);
		
		int loginchk = ss.loginCheck(sellerid, sellerpw);
		if (loginchk == 1) {

			if (scode != null) {
				HttpSession hs = request.getSession();
				hs.setAttribute("member", scode);
				hs.setAttribute("loginstate", true);
				System.out.println(scode + " sto sellercontroller");
				mav.setView(new RedirectView("/shop/sellerOrder/sellermain"));
			}

		} else {
			mav.setViewName("sellerindex");
		}

		return mav;
	}

	// �뜝�럥�냷嶺뚮씞�걠占쎌겱 嶺뚮∥�뾼占쎈데 // �슖�돦裕꾬옙�쟽�뜝�럩逾� �뜝�럡�뎽占썩뫅�삕 占쎈퉲�겫�룞�삕�슖�댙�삕
	// �썒�슣�닑�룇�뜝�럡���뜝�럥�뿴�뜝�럩諭� 占쎄껀占쎈쐞占쎌몠�뜝�룞�삕�뜝�럡�맋
	// �뜝�룞�삕�뜝�럩�몠嶺뚮∥�뾼占쎈데�뜝�럥�쓡�뜝�럩逾좂춯�쉻�삕�뜝�럥�뱺 �뜝�럡�맂�뇦爰용쳛鸚룹뼲�삕�뜮�쉻�삕�뇡占�.
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView sellermain(HttpServletRequest request, Model mo) {
		String sellerid = request.getParameter("sellerid");
		String sellerpw = request.getParameter("sellerpw");

		SellerService ss = sqlSession.getMapper(SellerService.class);

		mav.setView(new RedirectView("/shop/sellerOrderMain/sellermain"));
		return mav;
	}

	// �뜝�럥�냷嶺뚮씞�걠占쎌겱 �뜝�럩�뤂�뜝�럩�쐸�뤆�룊�삕�뜝�럩肉� �뜝�럩�꼨嶺뚮∥�샍占쎈さ�슖�댙�삕 �뜝�럩�쓧�뜝�럥苑�
	@RequestMapping(value = "/sellerinput", method = RequestMethod.GET)
	public ModelAndView sellerinput() {
		mav.setViewName("sellerinput");
		return mav;
	}
	@RequestMapping(value = "/sellerup", method = RequestMethod.GET)
	public ModelAndView sellerup(Model mo,HttpServletRequest request) {
		String scode = request.getParameter("scode");
		SellerService ss = sqlSession.getMapper(SellerService.class);
		SellerDTO sto =ss.sellerup(scode);
		mo.addAttribute("sto",sto);
		mo.addAttribute("scode", scode);
		mav.setViewName("sellerupdate");
		return mav;
	}
	@RequestMapping(value = "/sellerupsave", method = RequestMethod.GET)
	public ModelAndView sellerupsave(HttpServletRequest request,Model mo) {
		String scode = request.getParameter("scode");
		String sellerid = request.getParameter("sellerid");
		String sellerpw = request.getParameter("sellerpw");
		String scomname = request.getParameter("scomname");
		String sprename = request.getParameter("sprename");
		String sbusnum = request.getParameter("sbusnum");
		String scomsalenum = request.getParameter("scomsalenum");
		String scomaddress = request.getParameter("scomaddress");
		String semail = request.getParameter("semail");
		String smobile = request.getParameter("smobile");
		System.out.println(scode+sellerid+sellerpw+scomname+sprename+sbusnum+scomsalenum+scomaddress+semail+smobile);
		SellerService ss = sqlSession.getMapper(SellerService.class);
		ss.sellerupsave(scode,sellerid,sellerpw,scomname,sprename,sbusnum,scomsalenum,scomaddress,semail,smobile);
		ModelAndView mav1 = new ModelAndView();
		mav1.addObject("scode",scode);
		mav.setView(new RedirectView("/shop/sellerOrder/sellermain"));
		return mav;
	}
	

}
