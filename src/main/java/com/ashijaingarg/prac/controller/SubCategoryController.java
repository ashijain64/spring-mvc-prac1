package com.ashijaingarg.prac.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ashijaingarg.prac.model.Category;
import com.ashijaingarg.prac.model.SubCategory;
import com.ashijaingarg.prac.service.SubCategoryService;

@Controller
public class SubCategoryController {
	
	Logger log = Logger.getLogger(SubCategoryController.class.getName());
	
	@Autowired
	private SubCategoryService subCategoryService;
	
	@RequestMapping(value = "/add-subCategory", method = RequestMethod.GET)
	public String showSubCategoryPage(ModelMap model) {	
		List<Category> categories = subCategoryService.getAllCategories();
		model.put("categories", categories);
		SubCategory subCategory = new SubCategory();
		//subCategory.setCategoryId("0");
		model.put("subCategory", subCategory);
		return "subCategory";
	}
	
	@RequestMapping(value = "/add-subCategory", method = RequestMethod.POST)
	public String addSubCategory(SubCategory subCategory, BindingResult result, ModelMap model) {
		//subCategoryService.addSubCategory(subCategory);
		Category category = subCategoryService.getCategoryById(Integer.parseInt(subCategory.getCategoryId()));
		log.info("===" + subCategory.getSubCategoryName() + "  " + subCategory.getCategoryId());
		subCategory.setCategory(category);
		subCategoryService.addSubCategory(subCategory);
		model.put("subCategory",new SubCategory());
		return "subCategory";
	}
	
	@RequestMapping(value = "/list-subCategories",  method = RequestMethod.GET)
	public String getAllSubCategories(ModelMap model) {
		List<SubCategory> subCategories = subCategoryService.getAllSubCategories();
		model.put("subCategories", subCategories);
		return "list-subCategories";
	}

}
