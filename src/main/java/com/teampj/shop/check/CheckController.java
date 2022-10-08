package com.teampj.shop.check;

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
import com.teampj.shop.list.ListService;


@Controller
@RequestMapping(value="/check/**")
public class CheckController {

	private static final Logger logger = LoggerFactory.getLogger(CheckController.class);

	@Autowired
	private SqlSession sqlSession;

	ModelAndView mav = new ModelAndView();
	JSONParser jp = new JSONParser();
	JSONObject jo;

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView main(Model model) {
		mav.setViewName("checkmain");
		return mav;
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView mainhome(Model model) {
		mav.setView(new RedirectView("/shop"));	//다른 컨트롤러로 viewname
		return mav;
	}
	
	// 유저 장바구니/좋아요
	@RequestMapping(value = "/usercheckcart", method = RequestMethod.GET)	// 세션작업 필요
	public ModelAndView usercheckcart(Model model, HttpServletRequest request) {
		// 세션에서 아이디 가져오는걸로 수정하기
		ListService ser = sqlSession.getMapper(ListService.class);
		
		ArrayList<TotalDTO> list = ser.usercheck("user001", 1);
		mav.addObject("list", list);
		mav.setViewName("usercart");
		

		return mav;
	}
	
	// 유저 장바구니/좋아요
		@RequestMapping(value = "/userchecklike", method = RequestMethod.GET)	// 세션작업 필요
		public ModelAndView userchecklike(Model model, HttpServletRequest request) {
			// 세션에서 아이디 가져오는걸로 수정하기
			ListService ser = sqlSession.getMapper(ListService.class);
			
			ArrayList<TotalDTO> list = ser.usercheck("user001", 2);
			mav.addObject("list", list);
			mav.setViewName("userlike");

			return mav;
		}
	
	// 유저 장바구니/좋아요 삭제
	@RequestMapping(value = "/checkdel", method = RequestMethod.POST)	// 세션작업 필요
	public ModelAndView checkdel(Model model, HttpServletRequest request) {
		// 세션에서 아이디 가져오는걸로 수정하기
		CheckService ser = sqlSession.getMapper(CheckService.class);
		
		String [] check = request.getParameterValues("chk");
		
		for(int i=0; i<=(check.length-1); i++)
		{
			ser.checkdel(check[i], "user001");
		}
		
		mav.setViewName("usermain");
		return mav;
	}

}
