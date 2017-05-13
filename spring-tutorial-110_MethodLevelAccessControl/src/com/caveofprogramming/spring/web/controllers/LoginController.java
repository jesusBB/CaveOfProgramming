package com.caveofprogramming.spring.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.caveofprogramming.spring.web.dao.User;
import com.caveofprogramming.spring.web.service.UsersService;

@Controller
public class LoginController {
private UsersService usersService;
	
	
	@Autowired
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}
	@RequestMapping("/login")
	public String showLogin(){
		return "mylogin";
	}
	
	@RequestMapping("/loggedout")
	public String showLogout(){
		return "loggedout";
	}
	
	@RequestMapping("/newaccount")
	public String showNewAccount(Model model){
		model.addAttribute("user", new User());
		return "newaccount";
	}
	
	@RequestMapping(value="/createaccount", method=RequestMethod.POST)
	public String createAccount( @Valid User user, BindingResult result) {

		if(result.hasErrors()){
			System.out.println("Form does not validated");
			for(ObjectError error : result.getAllErrors()){
				System.out.println(error.getDefaultMessage());
			}
			
			return "newaccount";
		}
		
		user.setEnabled(true);
		user.setAuthority("user");
		
		if(usersService.exist(user.getUsername())){
			System.out.println("Caught duplicate username");
			result.rejectValue("username", "DuplicateKey.user.username");
			return "newaccount";
		}else{
			usersService.create(user);
		}
		
		
/*		try {
			usersService.create(user);
		} catch (DuplicateKeyException e) {
			result.rejectValue("username", "DuplicateKey.user.username", "This username already exist");
			return "newaccount";
		}*/
		
		return "accountcreated";
	}
	
	@RequestMapping("/admin")
	public String showAdmin(Model model) {
		List<User> users = usersService.getAllUsers();
		
		model.addAttribute("users", users);
		return "admin";
	}
	
}
