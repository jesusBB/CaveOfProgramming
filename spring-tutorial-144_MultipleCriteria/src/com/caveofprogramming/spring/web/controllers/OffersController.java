package com.caveofprogramming.spring.web.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.caveofprogramming.spring.web.dao.FormValidationGroup;
import com.caveofprogramming.spring.web.dao.Offer;
import com.caveofprogramming.spring.web.service.OffersService;

@Controller
public class OffersController {
	
	private OffersService offersService;
	
	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String showTest(Model model, @RequestParam("id") String id) {
		System.out.println("Id is: " + id);
		return "home";
	}
	
	/*
	@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseException(DataAccessException ex) {
		return "error";
	*/

	@RequestMapping("/offers")
	public String showOffers(Model model) {
		
		//offersService.throwTestException();
		
		List<Offer> offers = offersService.getCurrent();
		
		model.addAttribute("offers", offers);
		
		return "offers";
	}
	
	@RequestMapping("/createoffer")
	public String createOffer(Model model, Principal principal) {
		
		Offer offer = null;
		
		if(principal != null){
			String username = principal.getName();
			
			offer = offersService.getOffer(username);
		}
		if(offer == null){
			model.addAttribute("offer", new Offer());
		}else{
			model.addAttribute("offer", offer);
		}
		
		return "createoffer";
	}
	
	@RequestMapping(value="/docreate", method=RequestMethod.POST)
	public String doCreate(Model model, @Validated(value=FormValidationGroup.class) Offer offer, BindingResult result, Principal principal, @RequestParam(value="delete", required=false)String delete) {
		
		if(result.hasErrors()) {
			return "createoffer";
		}
		
		if(delete == null){
			offer.getUser().setUsername(principal.getName());
			
			offersService.saveOrUpdate(offer);
			return "offercreated";
		}else{
			offersService.delete(offer.getId());
			return "offerdeleted";
		}
		
		
	}
}
