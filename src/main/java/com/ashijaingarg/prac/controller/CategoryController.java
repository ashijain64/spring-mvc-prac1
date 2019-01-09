package com.ashijaingarg.prac.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ashijaingarg.prac.model.Category;
import com.ashijaingarg.prac.service.CategoryService;


@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/add-category", method = RequestMethod.GET)
	public String showCategoryPage(ModelMap model) {	
		model.put("category",new Category());
		return "category";
	}
	
	@RequestMapping(value = "/add-category", method = RequestMethod.POST)
	public String addCategory(Category category , BindingResult result , ModelMap model) {
		categoryService.addCategory(category);
		model.put("category",new Category());
		return "category";
	}
	
	@RequestMapping(value = "/list-categories",  method = RequestMethod.GET)
	public String getAllCategories(ModelMap model) {
		List<Category> categories = categoryService.getAllCategories();
		model.put("categories", categories);
		return "list-categories";
	}

}
