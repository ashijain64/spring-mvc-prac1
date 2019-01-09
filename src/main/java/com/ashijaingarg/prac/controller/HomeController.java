package com.ashijaingarg.prac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ashijaingarg.prac.service.CategoryService;

@Controller
public class HomeController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String showHome(ModelMap model) {	
		model.put("categories",categoryService.getAllCategories());
		return "home";
	}
	
	
}
