package com.teampj.shop.sellerOrder;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.servlet.ModelAndView;

import com.teampj.shop.seller.SellerDTO;

@Controller
@RequestMapping(value = "/sellerOrder/*")
public class SellerOrderController {

	private static final Logger logger = LoggerFactory.getLogger(SellerOrderController.class);

	@Autowired
	private SqlSession sqlSession;

	ModelAndView mav = new ModelAndView();
	JSONParser jp = new JSONParser();
	JSONObject jo;

	// �뜝�떎紐뚯삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕
	@RequestMapping(value = "/sellermain", method = RequestMethod.GET)
	public ModelAndView sellermain(HttpServletRequest request, Model mo) {
		HttpSession hs = request.getSession();
		String scode = (String) hs.getAttribute("member");

		OrderMainService oms = sqlSession.getMapper(OrderMainService.class);
		ArrayList<OrderMainDTO> list = oms.mainOut(scode);
		System.out.println(list + " list");
		System.out.println(scode + "sellermain");
		hs.setAttribute("seller", scode); // hs.setAttribute("seller", sto);
		mo.addAttribute("list", list);
		mo.addAttribute("scode", scode);

		mav.setViewName("sellermain");
		return mav;
	}

	// �뜝�룞�삕�뭹 �뜝�뙇諭꾩삕�뜝�룞�삕�뜝�룞�삕 (�뜝�룞�삕�뼶�뜝�룞�삕�뜝占�)
	@RequestMapping(value = "/sellerorder", method = RequestMethod.GET)
	public ModelAndView selleroder(HttpServletRequest request, Model mo) {
		String scode = request.getParameter("scode");
		mo.addAttribute("scode", scode);
		System.out.println(scode + "sellerorder");
		mav.setViewName("sellerorder");
		return mav;
	}

	// �뜝�룞�삕�뜝�룞�삕�뜝�떕占�
	@RequestMapping(value = "/sellerorder1", method = RequestMethod.GET)
	public ModelAndView selleroder1(HttpServletRequest request, Model mo) {

		String scode = request.getParameter("scode");
		System.out.println(scode + "sellerorder1");
		String serchcolumn = request.getParameter("serchcolumn");
		String serchname = request.getParameter("serchname");
		String orderday1 = request.getParameter("orderday1");
		String orderday2 = request.getParameter("orderday2");

		if (orderday1 != "" && orderday2 != "" || serchcolumn != "" && serchname != "") {

			SellerOrderService ss = sqlSession.getMapper(SellerOrderService.class);
			System.out.println(scode + serchcolumn + serchname + orderday1 + orderday2);

			ArrayList<SellerOrderDTO> list = ss.orderview(scode, serchcolumn, serchname, orderday1, orderday2);

			mo.addAttribute("list", list);
			mo.addAttribute("scode", scode);
			mav.setViewName("sellerorderview");
		} else {
			mo.addAttribute("scode", scode);
			mav.setViewName("redirect:sellerorder");
		}

		return mav;
	}

	// �뜝�룞�삕�뜝�룞�삕�뀧�뜝�룞�삕�뜝�떕占�
	@RequestMapping(value = "/sellerorder2", method = RequestMethod.GET)
	public ModelAndView selleroder2(HttpServletRequest request, Model mo) {

		String scode = request.getParameter("scode");
		System.out.println(scode + "sellerorder2");
		String serchcolumn = request.getParameter("serchcolumn");
		String serchname = request.getParameter("serchname");
		String orderday1 = request.getParameter("orderday1");
		String orderday2 = request.getParameter("orderday2");

		if (orderday1 != "" && orderday2 != "" || serchcolumn != "" && serchname != "") {
			SellerOrderService ss = sqlSession.getMapper(SellerOrderService.class);
			System.out.println(scode + serchcolumn + serchname + orderday1 + orderday2);

			ArrayList<SellerOrderDTO> list = ss.orderview(scode, serchcolumn, serchname, orderday1, orderday2);

			mo.addAttribute("list", list);
			mo.addAttribute("scode", scode);
			mav.setViewName("sellerorderview");
		} else {
			mo.addAttribute("scode", scode);
			mav.setViewName("redirect:sellerorder");
		}

		return mav;
	}

	// �뜝�룞�삕�뜝�룞�삕�뜝�떕占� �뜝�룞�삕�뜝�룞�삕 (�뜝�룞�삕�뼶�뜝�룞�삕�뜝占�)
	@RequestMapping(value = "/oshipsave", method = RequestMethod.GET)
	public ModelAndView sellershipsave(HttpServletRequest request, Model mo) {
		SellerOrderService ss = sqlSession.getMapper(SellerOrderService.class);

		String scode = request.getParameter("scode");
		String[] ocode = request.getParameterValues("ocode");
		String[] chk = request.getParameterValues("chk");
		String[] oshipcomp = request.getParameterValues("oshipcomp");
		String[] oshipcode = request.getParameterValues("oshipcode");
		String[] oshistate = request.getParameterValues("oshipstate");

		if (scode != "" && "".equals(ocode) && "".equals(chk)) {
			for (int i = 0; i <= (chk.length - 1); i++) {
				System.out.println(scode + ocode[Integer.parseInt(chk[i])] + oshipcomp[Integer.parseInt(chk[i])]
						+ oshipcode[Integer.parseInt(chk[i])] + oshistate[Integer.parseInt(chk[i])]);
				int k = ss.oshipUpdate(scode, ocode[Integer.parseInt(chk[i])], oshipcomp[Integer.parseInt(chk[i])],
						oshipcode[Integer.parseInt(chk[i])], oshistate[Integer.parseInt(chk[i])]);
				System.out.println(k);
			}
			mo.addAttribute("scode", scode);
			mav.setViewName("sellerorder");
		} else {
			mo.addAttribute("scode", scode);
			mav.setViewName("redirect:sellerorder");
		}
		return mav;
	}

	// �솚�뜝���슱�삕泥� �뜝�룞�삕�쉶 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�떛�벝�삕
	@RequestMapping(value = "/sellRefund", method = RequestMethod.GET)
	public ModelAndView sellrefund(HttpServletRequest request, Model mo) {
		String scode = request.getParameter("scode");
		mo.addAttribute("scode", scode);
		mav.setViewName("sellRefund");
		return mav;
	}

	// �솚�뜝�룞�삕�뜝�룞�삕�쉶
	@RequestMapping(value = "/sellrefund1", method = RequestMethod.GET)
	public ModelAndView sellrefundview(HttpServletRequest request, Model mo) {

		String scode = request.getParameter("scode");
		String serchcolumn = request.getParameter("serchcolumn");
		String serchname = request.getParameter("serchname");
		String ostate = request.getParameter("ostate");
		String orderday1 = request.getParameter("orderday1");
		String orderday2 = request.getParameter("orderday2");
		if (orderday1 != "" && orderday2 != "" || serchcolumn != "" && serchname != "") {
			SellerOrderService ss = sqlSession.getMapper(SellerOrderService.class);
			System.out.println(scode + serchcolumn + serchname + orderday1 + orderday2);

			ArrayList<SellerOrderDTO> list = ss.refundview(scode, serchcolumn, serchname, ostate, orderday1, orderday2);

			mo.addAttribute("list", list);
			mo.addAttribute("scode", scode);
			mav.setViewName("sellrefundview");
		} else {
			mo.addAttribute("scode", scode);
			mav.setViewName("redirect:sellRefund");
		}

		return mav;
	}

	// �솚�뜝���냲�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕 (�뜝�룞�삕�뼶�뜝�룞�삕�뜝占�)
	@SuppressWarnings("unused")
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
		String[] oshistate = request.getParameterValues("oshipstate");

		if (scode != "" && "".equals(ocode) && "".equals(chk)) {
			for (int i = 0; i <= (chk.length - 1); i++) {
				System.out.println(scode + ocode[Integer.parseInt(chk[i])] + "" + oshipcomp[Integer.parseInt(chk[i])]
						+ "" + oshipcode[Integer.parseInt(chk[i])] + "\t" + ostate[Integer.parseInt(chk[i])] + "\t"
						+ pshipcost[Integer.parseInt(chk[i])] + "\t" + shipprice[Integer.parseInt(chk[i])]);
				if (pshipcost[Integer.parseInt(chk[i])].equals("ocharge-")) {
					int k = ss.refundsaveseller(scode, ocode[Integer.parseInt(chk[i])],
							oshipcomp[Integer.parseInt(chk[i])], oshipcode[Integer.parseInt(chk[i])],
							Integer.parseInt(ostate[Integer.parseInt(chk[i])]),
							Integer.parseInt(shipprice[Integer.parseInt(chk[i])]),
							Integer.parseInt(ostate[Integer.parseInt(chk[i])]));
				} else if (pshipcost[Integer.parseInt(chk[i])].equals("ocharge+")) {
					int k = ss.refundsaveuser(scode, ocode[Integer.parseInt(chk[i])],
							oshipcomp[Integer.parseInt(chk[i])], oshipcode[Integer.parseInt(chk[i])],
							Integer.parseInt(ostate[Integer.parseInt(chk[i])]),
							Integer.parseInt(shipprice[Integer.parseInt(chk[i])]),
							Integer.parseInt(ostate[Integer.parseInt(chk[i])]));
				}

			}

			mo.addAttribute("scode", scode);
			mav.setViewName("sellrefundview");
		} else {
			mo.addAttribute("scode", scode);
			mav.setViewName("redirect:sellRefund");
		}
		return mav;
	}
}
