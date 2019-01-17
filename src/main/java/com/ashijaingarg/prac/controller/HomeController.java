package com.ashijaingarg.prac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ashijaingarg.prac.model.AppUser;
import com.ashijaingarg.prac.model.Category;
import com.ashijaingarg.prac.model.Product;
import com.ashijaingarg.prac.model.SubCategory;
import com.ashijaingarg.prac.service.AppUserService;
import com.ashijaingarg.prac.service.CategoryService;
import com.ashijaingarg.prac.service.ProductService;
import com.ashijaingarg.prac.service.SubCategoryService;

@Controller
public class HomeController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private SubCategoryService subCategoryService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired AppUserService appUserService;
	
	

	@RequestMapping(value = "/testing", method = RequestMethod.GET)
	public String createTestData(ModelMap model) {
		Category homeCat = new Category("Home" ,1);
		Category electronicsCat = new Category("Electronics" ,2);
		categoryService.addCategory(homeCat);
		categoryService.addCategory(electronicsCat);
		
		SubCategory decor = new SubCategory("Decor", homeCat);
		SubCategory mobiles = new SubCategory("iphone" , electronicsCat);
		subCategoryService.addSubCategory(decor);
		subCategoryService.addSubCategory(mobiles);
		
		Product iphone = new Product("iphone","mobile phone", "www.iphone.com",40000,mobiles);
		Product vase = new Product("vase", "for flowers", "www.vase.com", 500, decor);
		productService.addProduct(iphone);
		productService.addProduct(vase);
		
		AppUser appUser1 = new AppUser("Ashi");
		AppUser appUser2 = new AppUser("Ankur");
		appUserService.addAppUser(appUser1);
		appUserService.addAppUser(appUser2);
		
		model.put("categories",categoryService.getAllCategories());
		model.put("products", productService.getProducts());

		return "home";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String showHome(ModelMap model) {	
		model.put("categories",categoryService.getAllCategories());
		model.put("products", productService.getProducts());
		return "home";
	}
	
	
	
	
}
