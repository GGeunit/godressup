package com.godressup.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.godressup.domain.DressVO;
import com.godressup.service.DressService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/dress")
public class DressController {
	
	@Autowired
	private DressService dressService;
	
	private static final Logger logger = LoggerFactory.getLogger(DressController.class);

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String readDress(@PathVariable("id") int id, Model model) throws Exception {
		DressVO dress = dressService.readDress(id);
		logger.info("/dress/{id} GET execute.");
		
		model.addAttribute("dress", dress);
		return "dress/detail";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registerDressGet() throws Exception {
		logger.info("dress register page (GET)");
		
		return "/dress/register";
	}
}
