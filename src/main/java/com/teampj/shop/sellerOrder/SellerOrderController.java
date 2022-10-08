package com.teampj.shop.sellerOrder;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.teampj.shop.sellerOrder.SellerOrderService;
import com.teampj.shop.sellerOrder.SellerOrderDTO;

@Controller
@RequestMapping(value = "/sellerOrder/*")
public class SellerOrderController {

	private static final Logger logger = LoggerFactory.getLogger(SellerOrderController.class);

	@Autowired
	private SqlSession sqlSession;

	ModelAndView mav = new ModelAndView();
	JSONParser jp = new JSONParser();
	JSONObject jo;

	// 판매자 메인페이지
	@RequestMapping(value = "/sellermain", method = RequestMethod.GET)
	public ModelAndView sellermain(HttpServletRequest request, Model mo) {
		String scode = request.getParameter("scode");
		System.out.println(scode);
		OrderMainService oms = sqlSession.getMapper(OrderMainService.class);
		ArrayList<OrderMainDTO> list = oms.mainOut(scode);
		System.out.println(list);
		mav.addObject("list", list);
		mav.addObject("scode", scode);
		/*
		 * mav.addObject("list",request.getParameter("list"));
		 * mav.addObject("scode",request.getParameter("scode"));
		 */
		mav.setViewName("sellermain");
		return mav;
	}

	// 매출내역 조회
	@RequestMapping(value = "/sellersales", method = RequestMethod.GET)
	public ModelAndView sellersales(HttpServletRequest request, Model mo) {
		String scode = request.getParameter("scode");
		mo.addAttribute("scode", scode);
		mav.setView(new RedirectView("/shop/profit/main"));
		return mav;
	}

	// 상품 주문내역 (배송관리)
	@RequestMapping(value = "/sellerorder", method = RequestMethod.GET)
	public ModelAndView selleroder(HttpServletRequest request, Model mo) {
		String scode = request.getParameter("scode");
		mo.addAttribute("scode", scode);
		mav.setViewName("sellerorder");
		return mav;
	}

	// 배송관리
	@RequestMapping(value = "/sellerorder1", method = RequestMethod.GET)
	public ModelAndView selleroder1(HttpServletRequest request, Model mo) {

		String scode = request.getParameter("scode");
		String serchcolumn = request.getParameter("serchcolumn");
		String serchname = request.getParameter("serchname");
		String orderday1 = request.getParameter("orderday1");
		String orderday2 = request.getParameter("orderday2");

		SellerOrderService ss = sqlSession.getMapper(SellerOrderService.class);
		System.out.println(scode + serchcolumn + serchname + orderday1 + orderday2);

		ArrayList<SellerOrderDTO> list = ss.orderview(scode, serchcolumn, serchname, orderday1, orderday2);

		mo.addAttribute("list", list);
		mo.addAttribute("scode", scode);
		mav.setViewName("sellerorderview");

		return mav;
	}

	// 배송추가조회
	@RequestMapping(value = "/sellerorder2", method = RequestMethod.GET)
	public ModelAndView selleroder2(HttpServletRequest request, Model mo) {

		String scode = request.getParameter("scode");
		String serchcolumn = request.getParameter("serchcolumn");
		String serchname = request.getParameter("serchname");
		String orderday1 = request.getParameter("orderday1");
		String orderday2 = request.getParameter("orderday2");

		SellerOrderService ss = sqlSession.getMapper(SellerOrderService.class);
		System.out.println(scode + serchcolumn + serchname + orderday1 + orderday2);

		ArrayList<SellerOrderDTO> list = ss.orderview(scode, serchcolumn, serchname, orderday1, orderday2);

		mo.addAttribute("list", list);
		mo.addAttribute("scode", scode);
		mav.setViewName("sellerorderview");

		return mav;
	}

	// 송장번호 저장 (배송관리)
	@RequestMapping(value = "/oshipsave", method = RequestMethod.GET)
	public ModelAndView sellershipsave(HttpServletRequest request, Model mo) {
		SellerOrderService ss = sqlSession.getMapper(SellerOrderService.class);

		String scode = request.getParameter("scode");
		String[] ocode = request.getParameterValues("ocode");
		String[] chk = request.getParameterValues("chk");
		String[] oshipcomp = request.getParameterValues("oshipcomp");
		String[] oshipcode = request.getParameterValues("oshipcode");

		for (int i = 0; i <= (chk.length - 1); i++) {
			System.out.println(scode + ocode[Integer.parseInt(chk[i])] + oshipcomp[Integer.parseInt(chk[i])]
					+ oshipcode[Integer.parseInt(chk[i])]);
			int k = ss.oshipUpdate(scode, ocode[Integer.parseInt(chk[i])], oshipcomp[Integer.parseInt(chk[i])],
					oshipcode[Integer.parseInt(chk[i])]);
			System.out.println(k);
		}
		mo.addAttribute("scode", scode);
		mav.setViewName("sellerorder");
		return mav;
	}

	// 환불요청 조회 페이지 이동
	@RequestMapping(value = "/sellRefund", method = RequestMethod.GET)
	public ModelAndView sellrefund() {
		mav.setViewName("sellRefund");
		return mav;
	}

	// 환불조회
	@RequestMapping(value = "/sellrefund1", method = RequestMethod.GET)
	public ModelAndView sellrefund(HttpServletRequest request, Model mo) {

		String scode = request.getParameter("scode");
		String serchcolumn = request.getParameter("serchcolumn");
		String serchname = request.getParameter("serchname");
		String ostate = request.getParameter("ostate");
		String orderday1 = request.getParameter("orderday1");
		String orderday2 = request.getParameter("orderday2");

		SellerOrderService ss = sqlSession.getMapper(SellerOrderService.class);
		System.out.println(scode + serchcolumn + serchname + orderday1 + orderday2);

		ArrayList<SellerOrderDTO> list = ss.refundview(scode, serchcolumn, serchname, ostate, orderday1, orderday2);

		mo.addAttribute("list", list);
		mo.addAttribute("scode", scode);
		mav.setViewName("sellrefundview");

		return mav;
	}

	// 환불내역 저장 (배송관리)
	@RequestMapping(value = "/refundsave", method = RequestMethod.GET)
	public ModelAndView sellrefundsave(HttpServletRequest request, Model mo) {
		SellerOrderService ss = sqlSession.getMapper(SellerOrderService.class);

		String scode = request.getParameter("scode");
		String[] ocode = request.getParameterValues("ocode");
		String[] chk = request.getParameterValues("chk");
		String[] oshipcomp = request.getParameterValues("oshipcomp");
		String[] oshipcode = request.getParameterValues("oshipcode");
		String[] ostate = request.getParameterValues("ostate");
		// int[] ostate = new int[ostate1.length];
		String[] pshipcost = request.getParameterValues("pshipcost");

		String[] shipprice = request.getParameterValues("shipprice");
		/*
		 * for (int j = 0; j <= ostate1.length; j++) { ostate[j] =
		 * Integer.parseInt(ostate1[j]);
		 */
		for (int i = 0; i <= (chk.length - 1); i++) {
			System.out.println(scode + "" + ocode[Integer.parseInt(chk[i])] + "" + oshipcomp[Integer.parseInt(chk[i])]
					+ "" + oshipcode[Integer.parseInt(chk[i])] + "" + ostate[Integer.parseInt(chk[i])] + ""
					+ pshipcost[Integer.parseInt(chk[i])] + "" + shipprice[Integer.parseInt(chk[i])]);

			int k = ss.refundsave(scode, ocode[Integer.parseInt(chk[i])], oshipcomp[Integer.parseInt(chk[i])],
					oshipcode[Integer.parseInt(chk[i])], Integer.parseInt(ostate[Integer.parseInt(chk[i])]),
					pshipcost[Integer.parseInt(chk[i])], Integer.parseInt(shipprice[Integer.parseInt(chk[i])]));
		}
		mo.addAttribute("scode", scode);
		mav.setViewName("sellrefundview");
		return mav;
	}

	//
	@RequestMapping(value = "/sellRefundViwe", method = RequestMethod.GET)
	public ModelAndView sellRefundViwe(HttpServletRequest request, Model mo) {
		String scode = request.getParameter("scode");
		mo.addAttribute("scode", scode);
		mav.setViewName("sellRefundView");
		return mav;
	}
}
