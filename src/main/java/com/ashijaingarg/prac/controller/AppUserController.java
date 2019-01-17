package com.ashijaingarg.prac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ashijaingarg.prac.model.AppUser;
import com.ashijaingarg.prac.model.Category;
import com.ashijaingarg.prac.service.AppUserService;
import com.ashijaingarg.prac.service.CategoryService;

@Controller
public class AppUserController {
	
	@Autowired
	private AppUserService appUserService;
	
	@RequestMapping(value = "/add-user", method = RequestMethod.GET)
	public String showUserPage(ModelMap model) {	
		model.put("appUser",new AppUser());
		return "user";
	}
	
	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public String addUser(AppUser appUser , BindingResult result , ModelMap model) {
		appUserService.addAppUser(appUser);
		model.put("appUser",new AppUser());
		return "user";
	}
	
}
