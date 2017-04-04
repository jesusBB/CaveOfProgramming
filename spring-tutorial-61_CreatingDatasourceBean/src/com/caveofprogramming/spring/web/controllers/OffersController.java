package com.caveofprogramming.spring.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OffersController {
	
	@RequestMapping("/")
	public String showHome(Model model) {
		
		model.addAttribute("name", "Tiffany");
		
		return "home2";
	}
}

