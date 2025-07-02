package com.godressup.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.godressup.domain.DressVO;
import com.godressup.domain.ProfileVO;
import com.godressup.domain.UserVO;
import com.godressup.service.DressService;
import com.godressup.service.ProfileService;
import com.godressup.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DressService dressService;
	
	@Autowired
	private ProfileService profileService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {
		logger.info("Welcome home! The client locale is {}.", locale);
		List<DressVO> dresses = dressService.readDressList();
		model.addAttribute("dresses", dresses);
		return "home";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginGet() throws Exception {
		logger.info("login page (GET)");
		
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginPost(@ModelAttribute("user") UserVO vo, HttpSession session, Model model) throws Exception {
		logger.info("login page (POST)");
		
		UserVO loginUser = userService.readUser(vo.getUsername());
		if(loginUser != null && loginUser.getPassword().equals(vo.getPassword())) {
			session.setAttribute("loginUser", loginUser);
			return "redirect:/";
		}
		else {
			model.addAttribute("error", "아이디 혹은 비밀번호를 잘못 입력하였습니다.");
			return "login";
		}
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signupGet() throws Exception {
		logger.info("signup page (GET)");
		return "signup";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signupPost(@ModelAttribute("user") UserVO user, @ModelAttribute("profile") ProfileVO profile, @RequestParam("confirmPassword") String confirmPassword, Model model) throws Exception {
		logger.info("signup page (POST)");

		if(userService.readUser(user.getUsername()) != null) {
			model.addAttribute("error", "이미 존재하는 계정입니다.");
			return "signup";
		}
		
		if(!user.getPassword().equals(confirmPassword)) {
			model.addAttribute("error", "비밀번호가 일치하지 않습니다.");
			return "signup";
		}
		
		try {
			userService.signup(user, profile);
		} catch(Exception e) {
			model.addAttribute("error", "닉네임 입력값이 너무 깁니다. 다시 입력해주세요.");
			return "signup";
		}
		
			
		return "redirect:/login";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		logger.info("logout execute.");
		session.invalidate();
		return "redirect:/";
	}
}
