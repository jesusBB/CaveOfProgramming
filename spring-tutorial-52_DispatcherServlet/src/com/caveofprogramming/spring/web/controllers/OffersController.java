package com.caveofprogramming.spring.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OffersController {
	
	/*
	@RequestMapping("/")
	public ModelAndView showHome() {
		
		ModelAndView mv = new ModelAndView("home");
		
		Map<String, Object> model = mv.getModel();
		
		model.put("name", "<b>River</b>");
		
		return mv;
	}
	*/
	
	@RequestMapping("/")
	public String showHome(Model model) {
		
		model.addAttribute("name", "Tiffany");
		
		return "home";
	}
}

