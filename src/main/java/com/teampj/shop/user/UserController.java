package com.teampj.shop.user;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping(value = "/user/**")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private SqlSession sqlSession;

	ModelAndView mav = new ModelAndView();
	JSONParser jp = new JSONParser();
	JSONObject jo;

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView main(Model model) {
		mav.setViewName("usermain");
		return mav;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView mainhome(Model model) {
		mav.setView(new RedirectView("/shop"));	//�떎瑜� 而⑦듃濡ㅻ윭濡� viewname
		return mav;
	}
	// 
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView home(Model model) {
		mav.setViewName("login");
		return mav;
	}
	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public ModelAndView loginCheck(HttpServletRequest request, Model mo, RedirectAttributes red) {
		
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
        String nowtime =request.getParameter("nowtime");
        
		UserService ss = sqlSession.getMapper(UserService.class);
		String member = ss.login(userid, userpw);
		
		int loginchk = ss.loginCheck(userid, userpw);
		if (loginchk == 1) {
			
			if(member!=null)
			{
				HttpSession hs = request.getSession();
				hs.setAttribute("member", member);
				hs.setAttribute("loginstate", true);
				hs.setMaxInactiveInterval(20*60);
				mav.setViewName("redirect:/list/main");
			}
			
		} else {
			mav.setViewName("/shop/list/main");
		}
		
		return mav;
	}
	@RequestMapping(value = "/loginn", method = RequestMethod.GET)
	public ModelAndView loginn(Model model) {
		mav.setViewName("loginn");
		return mav;
	
}
	@RequestMapping(value = "/idCheck", method = RequestMethod.GET)
	public int idCheck(UserDTO dto, HttpServletRequest request) {

		UserService ss = sqlSession.getMapper(UserService.class);

		int cnt = ss.idCheck();

		return cnt;
	}
	@RequestMapping(value = "/loginnsave", method = RequestMethod.POST)
	public ModelAndView Userin(HttpServletRequest request, Model mo) {

		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		String uname = request.getParameter("uname");
		String uaddress1 = request.getParameter("uaddress1");		
		String uemail = request.getParameter("umail1")+"@"+request.getParameter("umail2");
		System.out.println(uemail+"회원가입");
		String umobile = request.getParameter("umobile");
		String uzlpcode1 = request.getParameter("uzlpcode1");
		
		UserService ss = sqlSession.getMapper(UserService.class);
		
		ss.userin(userid, userpw, uname,uaddress1, uemail, umobile,uzlpcode1);
		mav.setViewName("usermain");
		return mav;
		
	}
	
	@RequestMapping(value = "/UserUpdateView", method = RequestMethod.GET)
	public ModelAndView UserUpdate(Model model) {
		mav.setViewName("UserUpdateView");
		return mav;
	}
	@RequestMapping(value = "/UserUpdate", method = RequestMethod.POST)
	public ModelAndView UserUpdate(HttpServletRequest request, Model mo) {

		HttpSession hs = request.getSession();
		String userid = (String) hs.getAttribute("member");
		String userpw = request.getParameter("userpw");
		String uname = request.getParameter("uname");
		String uaddress1 = request.getParameter("uaddress1");
		String uaddress2 = request.getParameter("uaddress2");
		String uaddress3 = request.getParameter("uaddress3");
		String uemail = request.getParameter("umail1")+"@"+request.getParameter("umail2");
		String umobile = request.getParameter("umobile");
		String uzlpcode1 = request.getParameter("uzlpcode1");
		String uzlpcode2 = request.getParameter("uzlpcode2");
		String uzlpcode3 = request.getParameter("uzlpcode3");
		UserService ss = sqlSession.getMapper(UserService.class);
		
		ss.UserUpdate(userid, userpw, uname,uaddress1,uaddress2,uaddress3, uemail, umobile,uzlpcode1,uzlpcode2,uzlpcode3);
		mav.setViewName("usermain");
		return mav;
	}
	@RequestMapping(value = "/deleteView", method = RequestMethod.GET)
	public ModelAndView delete(Model model) {
		mav.setViewName("deleteView");
		return mav;
	}
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView delete(HttpServletRequest request, Model mo) {
		String userid = "user001";
		String userpw = request.getParameter("userpw");
		UserService sss = sqlSession.getMapper(UserService.class);
		sss.delete(userid, userpw);
		mav.setViewName("redirect:home");
		return mav;
	}
	
	
	
}